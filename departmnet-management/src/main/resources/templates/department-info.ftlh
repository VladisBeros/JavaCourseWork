<h1>Деталі відділу</h1>
<div>
    <strong>Назва відділу:</strong> ${department.name}<br>
    <strong>Телефон:</strong> ${department.phone}<br>
    <strong>Номер відділу:</strong> ${department.number}
</div>
<div>
    <a href="/departments">Повернутись до списку відділів</a>
</div>
<h2>Додати працівників до відділу</h2>
<form action="/departments/${department.id}" method="post">
    <label>
        <select name="employeeIds" multiple>
            <#list allEmployees as employee>
                <option value="${employee.id}">${employee.name}</option>
            </#list>
        </select>
    </label>
    <button type="submit">Додати працівників</button>
</form>


<h2>Працівників відділу</h2>
<#if department.employees??>
    <ul>
        <#list department.employees as employee>
            <li>${employee.name} - ${employee.position}</li>
        </#list>
    </ul>
<#else>
    <p>Наразі до відділу не додано жодних працівників.</p>
</#if>

<div>
    <a href="/departments">Повернутись до списку відділів</a>
</div>

