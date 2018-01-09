# Swagger Petstore - `1.0.0`
[ Base URL: petstore.swagger.io/v2 ]

This is a sample server Petstore server.  You can find out more about     Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).      For this sample, you can use the api key `special-key` to test the authorization     filters.
[Terms of Service](http://swagger.io/terms/)
[Contact the Developer](apiteam@swagger.io)

[Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
[Find out more about Swagger](http://swagger.io)

## Supported Schemes:
- [HTTP]

## Security Definitions:
- TODO

# Services
| Path | POST | GET | PUT | PATCH | DELETE | HEAD | OPTIONS |
| ------ | ------ | ------ | ------ | ------ | ------ | ------ | ------ |
|/pet|x||x|||||
|/pet/findByStatus||x||||||
|/pet/findByTags||x||||||
|/pet/{petId}|x|x|||x|||
|/pet/{petId}/uploadImage|x|||||||
|/store/inventory||x||||||
|/store/order|x|||||||
|/store/order/{orderId}||x|||x|||
|/user|x|||||||
|/user/createWithArray|x|||||||
|/user/createWithList|x|||||||
|/user/login||x||||||
|/user/logout||x||||||
|/user/{username}||x|x||x|||

### Add a new pet to the store
```sh
POST /pet
```
#### Description:


#### Consumes:
-[application/json, application/xml]
-[application/json, application/xml]

#### Parameters:
| Type | Name | Description | Schema | Default |
| ------ | ------ | ------ | ------ | ------ |
|body|body|Pet object that needs to be added to the store| | |

#### Http Responses:
| Http Code | Description | Schema |
| ------ | ------ | ------ |

#### Produces: 
-[application/xml, application/json]
-[application/xml, application/json]



### Updates a pet in the store with form data
```sh
POST /pet/{petId}
```
#### Description:


#### Consumes:
-[application/x-www-form-urlencoded]

#### Parameters:
| Type | Name | Description | Schema | Default |
| ------ | ------ | ------ | ------ | ------ |
|path|petId|ID of pet that needs to be updated| | |
|formData|name|Updated name of the pet| | |
|formData|status|Updated status of the pet| | |

#### Http Responses:
| Http Code | Description | Schema |
| ------ | ------ | ------ |

#### Produces: 
-[application/xml, application/json]
-[application/xml, application/json]

### uploads an image
```sh
POST /pet/{petId}/uploadImage
```
#### Description:


#### Consumes:
-[multipart/form-data]

#### Parameters:
| Type | Name | Description | Schema | Default |
| ------ | ------ | ------ | ------ | ------ |
|path|petId|ID of pet to update| | |
|formData|additionalMetadata|Additional data to pass to server| | |
|formData|file|file to upload| | |

#### Http Responses:
| Http Code | Description | Schema |
| ------ | ------ | ------ |

#### Produces: 
-[application/json]


### Place an order for a pet
```sh
POST /store/order
```
#### Description:


#### Consumes:

#### Parameters:
| Type | Name | Description | Schema | Default |
| ------ | ------ | ------ | ------ | ------ |
|body|body|order placed for purchasing the pet| | |

#### Http Responses:
| Http Code | Description | Schema |
| ------ | ------ | ------ |

#### Produces: 
-[application/xml, application/json]
-[application/xml, application/json]


### Create user
```sh
POST /user
```
#### Description:
This can only be done by the logged in user.

#### Consumes:

#### Parameters:
| Type | Name | Description | Schema | Default |
| ------ | ------ | ------ | ------ | ------ |
|body|body|Created user object| | |

#### Http Responses:
| Http Code | Description | Schema |
| ------ | ------ | ------ |

#### Produces: 
-[application/xml, application/json]
-[application/xml, application/json]

### Creates list of users with given input array
```sh
POST /user/createWithArray
```
#### Description:


#### Consumes:

#### Parameters:
| Type | Name | Description | Schema | Default |
| ------ | ------ | ------ | ------ | ------ |
|body|body|List of user object| | |

#### Http Responses:
| Http Code | Description | Schema |
| ------ | ------ | ------ |

#### Produces: 
-[application/xml, application/json]
-[application/xml, application/json]

### Creates list of users with given input array
```sh
POST /user/createWithList
```
#### Description:


#### Consumes:

#### Parameters:
| Type | Name | Description | Schema | Default |
| ------ | ------ | ------ | ------ | ------ |
|body|body|List of user object| | |

#### Http Responses:
| Http Code | Description | Schema |
| ------ | ------ | ------ |

#### Produces: 
-[application/xml, application/json]
-[application/xml, application/json]




