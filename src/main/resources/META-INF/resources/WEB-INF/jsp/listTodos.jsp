<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h1>Manage Your Todos</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done?</th>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td> <a href="deleteTodo?id=${todo.id}" class="btn btn-danger">Delete</a>   </td>
							<td> <a href="updateTodo?id=${todo.id}" class="btn btn-success">Update</a>   </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<a href="addTodo" class="btn btn-success">Add Todo</a>
		</div><%@ include file="common/footer.jspf" %>