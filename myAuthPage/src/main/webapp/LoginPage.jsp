<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Сайт факультета</title>
</head>
<body>
<H1>Пройдите аутентификацию!</H1>
<br>
<br>
Вы можете войти как студент или как гость.<br>
Параметры входа студента: <br>
Логин: student<br>
Пароль: stud<br>
<br>
Параметры входа гостя: <br>
Логин: guest<br>
Пароль: guest<br>
<br>
По умолчанию - вход для гостя
<br>
<form action="login" method="post">
Логин: <input type="text" name="user" value="guest">
Праоль: <input type="password" name="pass" value="guest">
<input type="submit" value="Войти">
</form>
</body>
</html>