Highlighted = Class.create({
	  initialize: function(element) {
			this.elementId = element;
	   		Event.observe($(this.elementId), 'click', this.doHighlighter.bindAsEventListener(this));
       },
       doHighlighter: function(event) {$(this.elementId).style.color="green";}
});

Highlighted_vRed = Class.create({
		initialize: function(element) {
			this.elementId = element;
	   		Event.observe($(this.elementId), 'click', this.doHighlighter.bindAsEventListener(this));
		},
	    doHighlighter: function(event) {$(this.elementId).style.color="pink";}
});

Tapestry.Initializer.highlighted = function(element){
	new Highlighted(element);
};

