//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.31 at 09:43:31 AM CST 
//


package wsdl.com;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsdl.com package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsdl.com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserDetail }
     * 
     */
    public UserDetail createUserDetail() {
        return new UserDetail();
    }

    /**
     * Create an instance of {@link InsertUserResponse }
     * 
     */
    public InsertUserResponse createInsertUserResponse() {
        return new InsertUserResponse();
    }

    /**
     * Create an instance of {@link GetAllUserDetailResponse }
     * 
     */
    public GetAllUserDetailResponse createGetAllUserDetailResponse() {
        return new GetAllUserDetailResponse();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link GetUserDetailResponse }
     * 
     */
    public GetUserDetailResponse createGetUserDetailResponse() {
        return new GetUserDetailResponse();
    }

    /**
     * Create an instance of {@link GetUserDetailRequest }
     * 
     */
    public GetUserDetailRequest createGetUserDetailRequest() {
        return new GetUserDetailRequest();
    }

    /**
     * Create an instance of {@link InsertUserRequest }
     * 
     */
    public InsertUserRequest createInsertUserRequest() {
        return new InsertUserRequest();
    }

    /**
     * Create an instance of {@link DeleteUserRequest }
     * 
     */
    public DeleteUserRequest createDeleteUserRequest() {
        return new DeleteUserRequest();
    }

    /**
     * Create an instance of {@link GetAllUserDetailRequest }
     * 
     */
    public GetAllUserDetailRequest createGetAllUserDetailRequest() {
        return new GetAllUserDetailRequest();
    }

    /**
     * Create an instance of {@link GetLoginRequest }
     * 
     */
    public GetLoginRequest createGetLoginRequest() {
        return new GetLoginRequest();
    }

    /**
     * Create an instance of {@link GetLoginResponse }
     * 
     */
    public GetLoginResponse createGetLoginResponse() {
        return new GetLoginResponse();
    }

}
