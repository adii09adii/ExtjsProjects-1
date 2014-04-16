Ext.Ajax.request(
	{
		url:'demo/TimeServlet',
		success:function(response){
			var text = response.responseText;
			//alert(config.url+","+config.method);
			Ext.Msg.alert("result",text);
		},
		failure:function(){
			Ext.MessageBox.alert("result","failure");
		},
		method:"post",
		params:{name:"潘永聪"}
	}
	);