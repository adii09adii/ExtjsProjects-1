Ext.onReady(function() {
			// 定义model	
			 Ext.define('Dep', { extend : 'Ext.data.Model', fields : [{ name :
			  'did', type : 'int' }, { name : 'dname', type : 'string' }] });
			 
			//创建数据源
			var store =  Ext.create('Ext.data.Store', {
						pageSize:'5',
						model:'Dep',
						proxy : new Ext.data.HttpProxy({
									url : 'demo/ComboBoxServlet',
									reader : new Ext.data.JsonReader({
									type : 'json',
									totalProperty : 'totalProperty',
									root : 'root'
								})
								})
					});
			// 定义ComboBox
			var combox = Ext.create('Ext.form.ComboBox', {
						fieldLabel : '请选择部门',
						store : store,
						queryMode : 'remote',
						pageSize :true,
						triggerAction : 'all',
						displayField : 'dname',
						valueField : 'did',
						emptyText : '请选择部门类别',
						renderTo : Ext.getBody(),
						editable : false,
						width:400
					});

		})