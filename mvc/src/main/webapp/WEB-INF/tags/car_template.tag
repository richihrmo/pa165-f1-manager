<%@ attribute name="car" required="true" type="cz.muni.fi.dto.CarDTO"%>
<%@ attribute name="name" required="true"%>

<div>
    <div class="col-sm-12" style="padding-left: 0px;">
        <h2>${name} <i class="fa fa-car" aria-hidden="true"></i></h2>
        <h4>Driver</h4>
        <p>
            <strong>Name:</strong>&nbsp;${car.driver.name}
            &nbsp;<strong>Surname:</strong>&nbsp;${car.driver.surname}
            &nbsp;<strong>Nationality:</strong>&nbsp;${car.driver.nationality}
        </p>

    </div>


    <div class="col-sm-3" style="padding-left: 0px;">
        <h4>Engine</h4>
        <p>
            <strong>Name:</strong>&nbsp;
            <my:a href="/component/read/${car.engine.id}"> ${car.engine.name}</my:a>
        </p>
    </div>

    <div class="col-sm-3">
        <h4>Aerodynamics</h4>
        <p>
            <strong>Aerodynamic:</strong>&nbsp;
            <my:a href="/component/read/${car.engine.id}"> ${car.aerodynamics.name}</my:a>
        </p>
    </div>

    <div class="col-sm-6">
        <h4>Suspension</h4>
        <p>
            <strong>Name:</strong>&nbsp;
            <my:a href="/component/read/${car.engine.id}"> ${car.suspension.name}</my:a>
        </p>
    </div>

    <div class="col-sm-3" style="padding-left: 0px;">
        <h4>Transmission</h4>
        <p>
            <strong>Name:</strong>&nbsp;
            <my:a href="/component/read/${car.engine.id}"> ${car.transmission.name}</my:a>
        </p>
    </div>

    <div class="col-sm-9">
        <h4>Brakes</h4>
        <p>
            <strong>Name:</strong>&nbsp;
            <my:a href="/component/read/${car.engine.id}"> ${car.brakes.name}</my:a>
        </p>
    </div>
</div>