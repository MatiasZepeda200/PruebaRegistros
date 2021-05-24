<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="container mt-6">
	<c:if test="${errores !=null}">
		<div class="columns is-centered mb-6">
			<div class="column is-6">
				<div class="notification is-warning">
					<h6>Existen errores en el formulario</h6>
					<ul>
						<c:forEach var="error" items="${errores}">
							<li>${error}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</c:if>
	<div class="columns is-centered">
		<div class="column is-6">
			<form method="POST" action="AgregarRegistroController.do">
				<div class="card">
					<div class="card-header has-background-link">
						<span class="card-header-title">Ingresar Solicitud</span>
					</div>
					<div class="card-content">
						<div class="field">
							<label class="label" for="rut-txt">Rut</label>
							<div class="control">
								<input type="text" class="input" id="rut-txt" name="rut-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="nombre-txt">Nombre y Apellido</label>
							<div class="control">
								<input type="text" class="input" id="nombre-txt"
									name="nombre-txt" />
							</div>
						</div>
						<div class="field">
							<label class="label" for="tipo-select">Tipo de solicitud</label>
							<div class="control">
								<div class="select">
									<select name="tipo-select" id="tipo-select">
										<option>Solicitud de Cedula de Identidad</option>
										<option>Retiro de Cedula de Identidad</option>
										<option>Solicitud de Certificado de Nacimiento</option>
										<option>Solicitud de Certificado de Defuncion</option>
									</select>
								</div>
							</div>
						</div>
						<div class="field">
							<label class="label" for="original-txt">Ingrese el Numero
								de solicitud original para retirar su Cedula</label>
							<div class="control">
								<input type="number" class="input" id="original-txt"
									name="original-txt" disabled/>
							</div>
						</div>
					</div>
					<script>
        let opcion = document.getElementById("tipo-select")
        let caja = document.getElementById("original-txt")
        
        opcion.addEventListener("change", () => {
          let elementoElegido = opcion.options[opcion.selectedIndex].text
          if (elementoElegido === "Retiro de Cedula de Identidad") {
            caja.disabled = false
          } else{
            caja.disabled = true
          }
          if (caja.disabled === true){
        	  caja.value = 0
          }
        })
    </script>
					<div class="card-footer has-text-centered">
						<div class="card-footer-item">
							<button type="submit" class="button is-primary">Registrar</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</main>

</body>
</html>