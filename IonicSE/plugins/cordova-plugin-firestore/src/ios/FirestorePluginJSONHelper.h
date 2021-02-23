//
//  FirestorePluginJSONHelper.h
//  leave your Egos at the door
//
//  Created by Richard WIndley on 05/12/2017.
//

#ifndef FirestorePluginJSONHelper_h
#define FirestorePluginJSONHelper_h

#import "FirestorePlugin.h"

@interface FirestorePluginJSONHelper : NSObject

+ (NSDictionary *)toJSON:(NSDictionary *)values;
+ (NSDictionary *)fromJSON:(NSDictionary *)values ForPlugin:(FirestorePlugin *)firestorePlugin;
+ (void)setReferencePrefix:(NSString *)referencePrefix;
+ (void)setGeopointPrefix:(NSString *)geopointPrefix;
+ (void)setDatePrefix:(NSString *)datePrefix;
+ (void)setTimestampPrefix:(NSString *)timestampPrefix;
+ (void)setFieldValueDelete:(NSString *)fieldValueDelete;
+ (void)setFieldValueServerTimestamp:(NSString *)fieldValueServerTimestamp;
+ (void)setFieldValueIncrement:(NSString *)fieldValueIncrement;
+ (void)setFieldValueArrayUnion:(NSString *)fieldValueArrayUnion;
+ (void)setFieldValueArrayRemove:(NSString *)fieldValueArrayRemove;
+ (NSObject *)parseSpecial:(NSObject *)value;

@end

#endif /* FirestorePluginJSONHelper_h */
