package com.retail.online.OnlineRetailShop.exception;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CustomException extends RuntimeException{

    private String message;
    private String exceptionDetails;


    protected CustomException(){}

    public CustomException(String message, String exceptionDetails){
            this.message = message ;
            this.exceptionDetails = exceptionDetails;
    }

}
