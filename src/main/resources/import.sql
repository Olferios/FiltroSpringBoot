insert into pais (id,nombre) values(1,"Colombia")

insert into ciudad (id,pais_id,nombre) values(1,1,"bogota")

insert into cliente (id,ciudad_id,email,name,password,telefono) values(1,1,"olf@","olfer","o1234","123456");

insert into venta (id,cliente_id,fecha) values(1,1,"2015-01-01");

insert into proveedor(id, ciudad_id,contacto,email,nombre, telefono) values (1,1,"olfrrrr","corre@","sebastian","3213222")

insert into compra(id, total,proveedor_id,fecha) values (1,222,1,"22-10-2015")

insert into modelo(id,descripcion,nombre) values (1,"holadescripcion","descripcion")

insert into marca (id, nombre) values( 1,"marcafirme");

insert into respuestos(id,stock,marca_id,modelo_id,proveedor_id,descripcion,nombre,precio) values(1,12,1,1,1,"descripcionrespuesto","respuestonombre","3333")

insert bicicleta (id,stock,marca_id,modelo_id,precio) values (1,12,1,1,"3333")

insert into detalles_compre(id, cantidad,compra_id,respuesto_id,precio_unitario) values(1,12,1,1,"3333")

insert into detalle_venta (id,bicicleta_id,cantidad,venta_id,precio_unitario) values(1,1,1,"233333")