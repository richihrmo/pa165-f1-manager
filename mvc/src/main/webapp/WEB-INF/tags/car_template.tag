<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="car" required="true" type="cz.muni.fi.dto.CarDTO"%>
<%@ attribute name="name" required="false"%>

<div>
    <div class="col-sm-12" style="padding-left: 0px;">
        <h4>Driver</h4>
        <p>
            <strong>Name:</strong>&nbsp;${car.driver.name}
            &nbsp;<strong>Surname:</strong>&nbsp;${car.driver.surname}
            &nbsp;<strong>Nationality:</strong>&nbsp;<span class="flag-icon flag-icon-${fn:toLowerCase(car.driver.nationality)}"></span> ${car.driver.nationality}
        </p>

    </div>


    <div class="col-sm-3" style="padding-left: 0px;">
        <h4>Engine</h4>
        <p>
            <strong>Name:</strong>&nbsp;
            ${car.engine.name}
        </p>
    </div>

    <div class="col-sm-3">
        <h4>Aerodynamics</h4>
        <p>
            <strong>Name:</strong>&nbsp;
            ${car.aerodynamics.name}
        </p>
    </div>

    <div class="col-sm-6">
        <h4>Suspension</h4>
        <p>
            <strong>Name:</strong>&nbsp;
            ${car.suspension.name}
        </p>
    </div>

    <div class="col-sm-3" style="padding-left: 0px;">
        <h4>Transmission</h4>
        <p>
            <strong>Name:</strong>&nbsp;
            ${car.transmission.name}
        </p>
    </div>

    <div class="col-sm-9">
        <h4>Brakes</h4>
        <p>
            <strong>Name:</strong>&nbsp;
            ${car.brakes.name}
        </p>
    </div>
</div>