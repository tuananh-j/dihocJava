<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>
	<c:url var = "path" value="/user"/>
    <div class="container mt-5">
        <form method="post" class="form">
            <div class="mb-3">
                <label for="id" class="form-label">ID:</label>
                <input type="text" class="form-control" id="id" name="id" value="${item.id}">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password:</label>
                <input type="password" class="form-control" id="password" name="password" value="${item.password}">
            </div>
            <div class="mb-3">
                <label for="fullname" class="form-label">Full Name:</label>
                <input type="text" class="form-control" id="fullname" name="fullname" value = "${item.fullname}">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value = "${item.email}">
            </div> 
            <div class="mb-3">
                <label class="form-label">Role:</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="admin" name="admin" ${item.admin?'checked':''} value="true">
                    <label for="admin" class="form-check-label">Admin</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="user" name="admin" value="false" ${item.admin?'':'checked'} >
                    <label for="user" class="form-check-label">User</label>
                </div>
            </div>
            <button type="submit" formaction="${path}/create" class="btn btn-primary">Create</button>
            <button type="submit" formaction="${path}/update" class="btn btn-primary">Update</button>
            <button type="submit" formaction="${path}/delete" class="btn btn-primary">Delete</button>
            <button type="submit" formaction="${path}/reset" class="btn btn-primary">Reset</button>

        </form>
        <!-- table -->
         <table class="table"> 
            <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Fullname
                    </th>
                    <th>
                        Email                    
                    </th>
                    <th>
                        Role
                    </th>
                    <th>
    
                    </th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var = "a" items="${list}">
            		<tr>
	                	<td>${a.id}</td>
	                	<td>${a.fullname}</td>
	                	<td>${a.email}</td>
	                	<td>${a.admin?'admin':'user'}</td>
	                	<td><a href="${path}/edit/${a.id}">edit</a></td>
                	</tr>
            	</c:forEach>
            </tbody>
         </table>
    </div>
</body>
</html>
