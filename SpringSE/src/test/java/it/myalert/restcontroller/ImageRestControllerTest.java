package it.myalert.restcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


import it.myalert.DTO.ImageDTO;
import it.myalert.DTO.InterventionDTO;
import it.myalert.DTO.ManagerDTO;
import it.myalert.DTO.TypeDTO;
import it.myalert.DTO.UserDTO;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ImageRestControllerTest {

	@Autowired
	private WebApplicationContext context;
	
	@Mock
	private ImageRestController mockService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private MockMvc mockMvc;
	private ImageDTO imageDTO;
	
	
	@BeforeEach
	void setUpEnv() {
		
		imageDTO = new ImageDTO();
		UserDTO userDTO = new UserDTO();
		UserDTO userManagerDTO = new UserDTO();
		InterventionDTO interventionDTO = new InterventionDTO();
		TypeDTO typeDTO = new TypeDTO();
		ManagerDTO managerDTO = new ManagerDTO();

		userDTO = new UserDTO();
		userDTO.setIdUser(4);
		userDTO.setName("Salvatore");
		userDTO.setSurname("Corvaglia");
		userDTO.setEmail("s.corvagliabooking@gmail.com");
		userDTO.setBirthDate(new Timestamp(new Date().getTime()));
		userDTO.setSex("M");
		userDTO.setAddress("Via Pasquale Ferraro, 60");
		userDTO.setCity("Diso");
		userDTO.setState("Italy");
		
		userManagerDTO.setIdUser(1);
		userManagerDTO.setName("Luca");
		userManagerDTO.setSurname("Mainetti");
		userManagerDTO.setEmail("manager@myalert.com");
		userManagerDTO.setBirthDate(new Timestamp(new Date().getTime()));
		userManagerDTO.setSex("M");
		userManagerDTO.setAddress("Test");
		userManagerDTO.setCity("Test");
		userManagerDTO.setState("Italy");
		
		managerDTO.setIdManager(1);
		managerDTO.setUser(userManagerDTO);

		typeDTO.setIdType(1);
		typeDTO.setName("Type");
		typeDTO.setManagerDTO(managerDTO);
		
		interventionDTO.setType(typeDTO);
		interventionDTO.setIdIntervention(1);
		interventionDTO.setLat(20.0);
		interventionDTO.setLon(20.0);
		interventionDTO.setAddress("Address");
		interventionDTO.setStatus("closed");
		
		imageDTO.setIdImage(1);
		imageDTO.setIntervention(interventionDTO);
		imageDTO.setUser(userDTO);
		imageDTO.setUrl("http:\\url.image.it");
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	@Transactional
	public void addImage() throws Exception {

		List<ImageDTO> newlistDTO = new ArrayList<ImageDTO>();
		newlistDTO.add(imageDTO);
		
	    this.mockMvc.perform(MockMvcRequestBuilders.post("/image/addImage")
	    		.param("idUser", "3")
	    		.param("idIntervention", "4")
	    		.content(objectMapper.writeValueAsString(newlistDTO))
	    		.contentType(MediaType.APPLICATION_JSON_VALUE))
	      		.andExpect(status().isOk());
	}

	@Test
	@Transactional
	public void deleteImage() throws Exception {

	    this.mockMvc.perform(delete("/image/deleteImage/11")
	    		.contentType(MediaType.APPLICATION_JSON_VALUE))
	      		.andExpect(status().isOk());
	}

	@Test
	public void getAllImageByIdIntervention() throws Exception {


		this.mockMvc.perform(get("/image/getAllImageByIdIntervention/4")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

	@Test
	public void getImage() throws Exception {


		this.mockMvc.perform(get("/image/getImage")
				.param("idIntervention", "4")
				.param("idUser", "3")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}
	
}