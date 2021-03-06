<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<my:page_template title="Create Component" icon_class="fa fa-wrench">
<jsp:attribute name="body">
    <my:protected>
        <button class="btn" onclick="location.href='${pageContext.request.contextPath}/${end}/components'">Return</button>

        <form:form method="post" action="${pageContext.request.contextPath}/components/create"
                   modelAttribute="componentCreate" cssClass="form-horizontal">

            <div class="form-group ${name_error?'has-error':''}">
                <form:label path="name" cssClass="col-sm-3 control-label">Name</form:label>
                <div class="col-sm-9">
                    <form:input path="name" cssClass="form-control"/>
                    <form:errors path="name" cssClass="help-block"/>
                </div>
            </div>

            <div class="form-group ${name_error?'has-error':''}">
                <form:label path="type" cssClass="col-sm-3 control-label">Component Type</form:label>
                <div class="col-sm-9">
                    <form:select path="type" class="form-control" items="${componentTypeSelect}" itemValue="name" itemLabel="urlAnnotation"/>
                    <form:errors path="type" cssClass="help-block"/>
                </div>
            </div>

            <button class="btn btn-primary" type="submit">Create component</button>
        </form:form>
    </my:protected>

</jsp:attribute>
</my:page_template>
