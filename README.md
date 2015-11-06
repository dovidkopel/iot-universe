# iot-universe
Ecosystem for IoT connectivity and security

This is a project to bridge the many gaps in IoT. Much more to come.

The server utilizes MQTT/AMQP for queuing and transporting input and output data. The server is able to connect to clients using a wire protocol that is hardware independent. Hardware specific adapters may be implemented for different connection types. 

The basis of the wire protocol includes client authentication where the client provides identification information.

## Wire Protocol 

### Authentication
The server may be configured to allow for self registration. Where the client specifies a unique identifier, a list of input criteria it accepts, and a list of output criteria that it yields. The server may allow only some input/output types to self register. The server may be configured to completely disable self registration and all clients must be registered in the admin panel.

Whether or not a client is registered via self registration or by the admin panel an access token is returned that may or may not have a expiration alongside the token. This token will be used for future communications with the server. Depending on if encryption is enabled the access token can be used to encrypt and decrypt data that is being sent over the wire.

### Inputs 
An input is anything that produces data. Something as low level as a physical button press and something as high level as an HTTP request. An input defines what type of data it emits. It also specifies the way that input is triggered. The means that some inputs like a physical button can be constantly queried evaluating if the button is currently in a pressed state or non-pressed state. Alternatively that same button may only provide data when there is a change in its state. So the type of data an input provides, and the frequency and methodology of that input are included part of the inputs description.
 
### Outputs
An output is anything that consumes data. Something as low level as an led that lights up. An output requests information that it may process or simple information to output. An output must specify the type of data it wants to access, the trigger type it will use and the type of output it is.
 
