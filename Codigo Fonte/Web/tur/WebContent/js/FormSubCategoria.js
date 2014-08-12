Ext.onReady(function() {
	var FormSubCategoria;
	var windowsubcategoria;
	var carregaCategoria;

	Ext.get("idsubcategoria").on('click', function(s, e) {
		windowsubcategoria = Ext.getCmp('idwinsubcategoria');
		if (windowsubcategoria == null){
			Ext.create('FormSubCategoria');	
		}
	});
	

	
});

//Carrega dados da categoria
carregaCategoria =Ext.create('Ext.data.Store',{
	autoLoad: false
	,fields: ['codigo','nomecategoria']
	,proxy: {
		type: 'ajax'
		,url: 'servletcat'
		,reader: {root: 'dados'}
	}
});	

Ext.define(
				'FormSubCategoria',
				{
					extend : 'Ext.window.Window',
					id : 'idwinsubcategoria',
					title : 'Adicionar uma nova subcategoria',
					layout : 'fit',
					height : 250,
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
							id : 'idFormSubCategoria',
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
							},{
								xtype : 'combo'
								,name: 'txtcategoria'
								,fieldLabel : 'Selecione a Categoria'
								,anchor : '100%'
								,allowBlank : false
								,store: carregaCategoria
								
							},{
								xtype : 'textarea'
								,name: 'txtdesc'
								,fieldLabel : 'Descricao'
								,height : 80
								,anchor : '100%'
								
							}]
						} ]
						this.callParent();
					}

					/*
					 * Listeners
					 */
					,
					onCancelar : function() {
						var varFormSubCategoria = Ext.getCmp('idFormSubCategoria');
						varFormSubCategoria.getForm().reset();
					},
					onFechar : function() {
						var varwinsubcategoria = Ext.getCmp('idwinsubcategoria');
						varwinsubcategoria.close();
					},
					onSubmeter : function() {
						var varFormSubCategoria = Ext.getCmp('idFormSubCategoria');
						if (!varFormSubCategoria.getForm().isValid()) {
							Ext.Msg
									.alert(
											'Erro',
											'Verificamos a existencia de dados inconsistentes.<br>Verifique os dados informados e tente novamente.');
							return false
						}

						varFormSubCategoria.getForm().submit(
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