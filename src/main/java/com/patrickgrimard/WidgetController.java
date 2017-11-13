package com.patrickgrimard;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by XTL on 8/14/2014.
 */
@RequestMapping( "/" )
@RestController
public class WidgetController{

    @RequestMapping( value = "/", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public String index(){ return "Fill in a color in the URI"; }

    @RequestMapping( value = "/green", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Widget green(){
        return new Widget( "green", 10, 7 );
    }

    @RequestMapping( value = "/blue", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Widget blue(){
        return new Widget( "blue", 10, 7 );
    }

    @RequestMapping( value = "/red", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Widget red(){
        return new Widget( "red", 10, 7 );
    }

    @RequestMapping( value = "/yellow", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Widget yellow(){
        return new Widget( "yellow", 10, 7 );
    }
}
