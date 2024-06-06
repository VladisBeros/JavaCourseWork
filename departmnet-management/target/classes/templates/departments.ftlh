<h1>Список Відділів</h1>
<ul>
    <#list departments as department>

    </#list>
</ul>
<h2>Додати новий відділ</h2>
<form action="/departments/create" method="post" accept-charset="UTF-8">
    <div>
        <label>Назва відділу:</label>
        <input type="text" name="name" required>
    </div>
    <div>
        <label>Телефон:</label>
        <input type="text" name="phone" required>
    </div>
    <div>
        <label>Номер відділу:</label>
        <input type="text" name="number" required>
    </div>
    <button type="submit">Додати</button>
</form>
