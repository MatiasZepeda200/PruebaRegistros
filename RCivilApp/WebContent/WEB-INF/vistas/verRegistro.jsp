<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<main class="container mt-6">
	<div class="columns is-centered">
		<div class="column is-8">
			<label class="label" for="tipo-select">Tipo de solicitudes</label>
			<div class="control">
				<div class="select">
					<select name="tipo-select" id="tipo-select">
					    <option>All</option>
						<option>Solicitud de Cedula de Identidad</option>
						<option>Retiro de Cedula de Identidad</option>
						<option>Solicitud de Certificado de Nacimiento</option>
						<option>Solicitud de Certificado de Defuncion</option>
					</select>
				</div>
			</div>
		    <button type="submit" class="button is-primary">Filtrar</button>
			<table class="table is-hovered is-bordered is-fullwidth" id="tabla">
				<thead class="has-background-link">
					<tr>
						<th>Numero de Atencion</th>
						<th>Nombre</th>
						<th>Tipo de solicitud</th>
						<th>Aceptar solicitud</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="registro" items="${registros}">
						<tr>
							<td>${registro.numeroSolicitud}</td>
							<td>${registro.nombre}</td>
							<td>${registro.solicitud}</td>
							<td><a
								href="VerRegistroControllers.do?nombreEliminar=${solicitud.nombre}"
								class="has-text-danger">Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
<body>

</body>
</html>