package com.test.genetify.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.javascript.InitializationPriority;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import com.adaptivui.tapestry5.genetify.annotations.Genetify;

/**
 * Layout component for pages of application tapestry-genetify-sample.
 */
@Import(library={"context:js/script.js"},
		stylesheet = {
			"context:layout/layout.css",
			"context:layout/layout_vA.css",
			"context:layout/layout_vB.css"
		})
@Genetify
public class Layout
{
    /**
     * The page title, for the <title> element and the <h1> element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    private String pageName;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String sidebarTitle;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private Block sidebar;

    @Inject
    private ComponentResources resources;

    @Inject
    private JavaScriptSupport javascriptSupport; 
    
    @Property
    @Inject
    @Symbol(SymbolConstants.APPLICATION_VERSION)
    private String appVersion;


    public String getClassForPageName()
    {
        return resources.getPageName().equalsIgnoreCase(pageName)
                ? "current_page_item"
                : null;
    }

    public String[] getPageNames()
    {
        return new String[]{"Index", "About", "Contact"};
    }
    
    @AfterRender
    void addHighlighterFunction(){
    	/*javascriptSupport.addScript(
    			"genetify.vary('javascript');");*/
    	javascriptSupport.addScript(
    			InitializationPriority.NORMAL, 
    			String.format("new Highlighted('%s')", "jsvariant"));
    	
    }
}
