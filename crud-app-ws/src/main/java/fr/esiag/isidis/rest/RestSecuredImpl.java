package fr.esiag.isidis.rest;



import java.io.Serializable;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;

import fr.esiag.isidis.common.annotation.Config;
import fr.esiag.isidis.common.exception.CustomException;
import fr.esiag.isidis.common.security.CustomAuthorizer;

/**
 * Created by rmpestano on 12/20/14.
 */
@RestSecured
@Interceptor
public class RestSecuredImpl implements Serializable{

    @Inject
    CustomAuthorizer authorizer;

    @Inject
    @Config
    Instance<HttpServletRequest> request;


    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        String currentUser = request.get().getHeader("user");
         if( currentUser != null){
             authorizer.login(currentUser);
         } else{
             throw new CustomException("Access forbidden");
         }
        return context.proceed();
    }

}
