package com.vivek.learn.graph_ql.controller;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof ServiceException exception) {
            return GraphqlErrorBuilder.newError()
                    .errorType(exception.getErrorType())
                    .message(ex.getMessage())
                    .path(env.getExecutionStepInfo().getPath())
                    .build();
        } if(ex instanceof InvalidDataAccessApiUsageException exception){
            return GraphqlErrorBuilder.newError()
                    .errorType(ErrorType.BAD_REQUEST)
                    .message(exception.getMessage())
                    .path(env.getExecutionStepInfo().getPath())
                    .build();
        }else{
            return null;
        }
    }
}
