#### Nordcloud Engineering Blog : A song of Decentralization and Observability: Dance with open telemetry 
Refer to the blog for more details about the end to end architecture designs



#### Integrating OpenTelemetry with springboot services.

This project shows how to add [java OpenTelemetry agent](https://github.com/aws-observability/aws-otel-java-instrumentation)  with popular spring boot based microservices.
Refer the `Dockerfile` in the project to see how to add the java OpenTelemetry agent without making code changes to the application.


### Deployment Framework
The AWS SAM CLI is an extension of the AWS CLI that adds functionality for building and testing Lambda applications. 
To use the AWS SAM CLI, you need the following tools:

* AWS SAM CLI - [Install the AWS SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html).
* Docker - [Install Docker community edition](https://hub.docker.com/search/?type=edition&offering=community).

To build and deploy your application for the first time, run the following in your shell:

```bash
sam build
sam deploy --guided --capabilities CAPABILITY_NAMED_IAM
```

### Cleanup

To delete the sample pipeline that you created, use the AWS CLI. Assuming you used your project name for the stack
name, you can run the following:

```bash
sam delete
```

### Resources

See
the [AWS SAM developer guide](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/what-is-sam.html)
for an introduction to SAM specification, the SAM CLI, and serverless application concepts.

