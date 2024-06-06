<h1>Працівники</h1>
<h2>Додати нового працівника</h2>
<form action="/employees" method="post">
    <div>
        <label for="name">Ім'я:</label>
        <input type="text" id="name" name="name" required>
    </div>
    <div>
        <label for="position">Посада:</label>
        <textarea id="position" name="position" required></textarea>
    </div>
    <button type="submit">Додати</button>
</form>

<h2>Список працівників</h2>
<ul>
    <#list employees as employee>
        <li>${employee.name} - ${employee.position}</li>
    </#list>
</ul>

<a href="/departments">Повернутися до списку відділів</a>
