Ext.onReady(function() {
	var formcategoria;
	var windowcategoria;

	Ext.get("idcategoria").on('click', function(s, e) {
		windowcategoria = Ext.getCmp('idwincategoria');
		if (windowcategoria == null){
			Ext.create('FormCategoria');	
		}
	});
});

Ext
		.define(
				'FormCategoria',
				{
					extend : 'Ext.window.Window',
					id : 'idwincategoria',
					title : 'Cadastrar uma nova Categoria',
					layout : 'fit',
					height : 200,
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
							id : 'idformcategoria',
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
								,fieldLabel : 'Categoria'
								,anchor : '100%'
								,allowBlank : false
							}, {
								xtype : 'textarea'
								,name: 'txtdesc'
								,fieldLabel : 'Descricao'
								,height : 80
								,anchor : '100%'
							} ]
						} ]
						this.callParent();
					}

					/*
					 * Listeners
					 */
					,
					onCancelar : function() {
						var varformcategoria = Ext.getCmp('idformcategoria');
						varformcategoria.getForm().reset();
					},
					onFechar : function() {
						var varwincategoria = Ext.getCmp('idwincategoria');
						varwincategoria.close();
					},
					onSubmeter : function() {
						var varformcategoria = Ext.getCmp('idformcategoria');
						if (!varformcategoria.getForm().isValid()) {
							Ext.Msg
									.alert(
											'Erro',
											'Verificamos a existencia de dados inconsistentes.<br>Verifique os dados informados e tente novamente.');
							return false
						}

						varformcategoria
								.getForm()
								.submit(
										{
											method : 'POST',
											url : 'servletcat',
											waitTitle : 'Carregando...',
											waitMsg : 'Estamos salvando seus dados.',
											success : function(from, action) {
												Ext.MessageBox
														.alert('Parabens',
																'A partir de agora, o Manaus Tour APP contara com mais essa super categoria.<br>Agradecemos a sua colaboracao.');
												varformcategoria.getForm().reset();
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