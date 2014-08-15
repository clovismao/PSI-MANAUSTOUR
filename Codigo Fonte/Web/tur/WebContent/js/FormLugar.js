Ext.onReady(function() {
	var FormLugar;
	var windowlugar;

	Ext.get("idlugar").on('click', function(s, e) {
		windowlugar = Ext.getCmp('idwinlugar');
		if (windowlugar == null){
			Ext.create('FormLugar');	
		}
	});
});

Ext.define(
				'FormLugar',
				{
					extend : 'Ext.window.Window',
					id : 'idwinlugar',
					title : 'Adicionar um lugar ao Manaus Tour APP',
					layout : 'fit',
					height : 400,
					width : 500,
					labelWidth : 12,
					closable : true,
					modal : false,
					resizable : false,
					plain : true
					// ,iconCls:
					,
					autoShow : true,
					initComponent : function() {
						this.items = [ {
							xtype : 'form',
							id : 'idformlugar',
							bodyStyle : "padding: 15px 10px;",
							border : false,
							labelWidth : 80,
							frame : false,
							autoHeight : true,
							defaultType : 'textfield',
							// Botões
							bbar : [ '-', {
								text : 'Cadastrar',
								handler : this.onSubmeter
							}, '-', {
								text : 'Cancelar',
								handler : this.onCancelar
							}, '-', {
								text : 'Fechar',
								handler : this.onFechar
							} ],
							// Campos
							items : [ {
								xtype : 'textfield'
								,name: 'txtnome'
								,fieldLabel : 'Nome*'
								,anchor : '100%'
								,allowBlank : false
							}, {
								xtype : 'textfield'
								,name: 'txtendereco'
								,fieldLabel : 'Endereco'
								,anchor : '100%'
								,allowBlank : false
							}, {
								xtype : 'textfield'
								,name: 'txtrua'
								,fieldLabel : 'Rua Transversal'
								,anchor : '100%'
								,allowBlank : false
							}, {
								xtype : 'textfield'
								,name: 'txtcidade'
								,fieldLabel : 'Cidade'
								,anchor : '100%'
								,allowBlank : false	
							}, {	
								xtype : 'textfield'
								,name: 'txtestado'
								,fieldLabel : 'Estado/Provincia'
								,anchor : '100%'
								,allowBlank : false	
							}, {
								xtype : 'textfield'
								,name: 'txtcep'
								,fieldLabel : 'Codigo Postal'
								,anchor : '100%'
								,allowBlank : false	
							}, {
								xtype : 'textfield'
								,name: 'txtpais'
								,fieldLabel : 'Pais'
								,anchor : '100%'
								,allowBlank : false	
							}, {
								xtype : 'combo'
								,name: 'txtcategoria'
								,fieldLabel : 'Categoria'
								,anchor : '100%'
								,allowBlank : false	
							}, {
								xtype : 'combo'
								,name: 'txtsubcategoria'
								,fieldLabel : 'Subcategoria'
								,anchor : '100%'
								,allowBlank : false	
							}]
						} ]
						this.callParent();
					}

					/*
					 * Listeners
					 */
					,
					onCancelar : function() {
						var varFormLugar = Ext.getCmp('idformlugar');
						varFormLugar.getForm().reset();
					},
					onFechar : function() {
						var varwinsubcategoria = Ext.getCmp('idwinlugar');
						varwinsubcategoria.close();
					},
					onSubmeter : function() {
						var varFormLugar = Ext.getCmp('idformlugar');
						if (!varFormLugar.getForm().isValid()) {
							Ext.Msg
									.alert(
											'Erro',
											'Verificamos a existencia de dados inconsistentes.<br>Verifique os dados informados e tente novamente.');
							return false
						}

						varFormLugar.getForm().submit(
										{
											method : 'POST',
											url : 'servletcat',
											waitTitle : 'Carregando...',
											waitMsg : 'Estamos salvando seus dados.',
											success : function(from, action) {
												Ext.MessageBox
														.alert('Parabéns',
																'A partir de agora, o Manaus Tour APP contará com mais essa super categoria.');
											},
											failure : function(from, action) {
												Ext.Msg
														.show({
															title : 'Opa !',
															msg : 'Infelizmente ocorreu algum erro interno, enquanto tentava-mos gravar os seus dados.<br>Mas nao desanime, recarregue a página novamente e tente registrar-se de novo.',
															buttons : Ext.Msg.OK,
															icon : Ext.MessageBox.ERROR
														});
											}
										});
					}
				});