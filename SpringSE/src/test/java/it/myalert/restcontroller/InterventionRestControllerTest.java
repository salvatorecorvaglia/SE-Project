package it.myalert.restcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.myalert.DTO.InterventionDTO;
import it.myalert.DTO.ManagerDTO;
import it.myalert.DTO.TypeDTO;
import it.myalert.DTO.UserDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InterventionRestControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	
	@Mock
	private InterventionRestController mockService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private MockMvc mockMvc;
	private InterventionDTO interventionDTO;
	
	
	@BeforeEach
	public void setUpEnv() {
		
		interventionDTO = new InterventionDTO();
		
		UserDTO userDTO = new UserDTO();
		TypeDTO typeDTO = new TypeDTO();
		ManagerDTO managerDTO = new ManagerDTO();


		userDTO.setIdUser(4);
		userDTO.setName("Salvatore");
		userDTO.setSurname("Corvaglia");
		userDTO.setEmail("s.corvagliabooking@gmail.com");
		userDTO.setBirthDate(new Timestamp(new Date().getTime()));
		userDTO.setSex("M");
		userDTO.setAddress("Via Pasquale Ferraro, 60");
		userDTO.setCity("Diso");
		userDTO.setState("Italy");
		
		managerDTO.setIdManager(1);
		managerDTO.setUser(userDTO);


		typeDTO.setIdType(1);
		typeDTO.setName("Type");
		typeDTO.setManagerDTO(managerDTO);
		
		interventionDTO.setType(typeDTO);
		interventionDTO.setIdIntervention(1);
		interventionDTO.setLat(10.0);
		interventionDTO.setLon(10.0);
		interventionDTO.setAddress("Address");
		interventionDTO.setStatus("signaled");

		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	@Transactional
	public void updateIntervention() throws Exception {

	    this.mockMvc.perform(put("/intervention/updateIntervention/4")
	    		.param("idType", "4")
	    		.content(objectMapper.writeValueAsString(interventionDTO))
	    		.contentType(MediaType.APPLICATION_JSON_VALUE))
	      		.andExpect(status().isOk());
	}

	@Test
	public void getInterventionById() throws Exception {


		this.mockMvc.perform(get("/intervention/getInterventionById/4")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

	@Test
	public void getInterventionByStatus() throws Exception {


		this.mockMvc.perform(get("/intervention/getInterventionByStatus/signaled")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

}
