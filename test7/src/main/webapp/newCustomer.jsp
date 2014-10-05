<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new customer</title>
<link rel="stylesheet" type="text/css" href="css/view.css" media="all">
<script type="text/javascript" src="js/view.js"></script>
</head>
<body>
	<br>
	<div id="form_container">
		<form id="formNewCustomer" class="appnitro" method="get"
			action="StorageEditor">
			<br>
			<div class="form_description">
				<h2>Add new customer</h2>
				<p>You can add new customer there.</p>
				<p style="color: red">${errorMessage}</p>
			</div>
			<ul>
				<li><label class="description" for="element_1">Name </label> <span>
						<input id="firstName" name="firstName" value="${firstName}"
						class="element text" size="8" /> <label>First</label>
				</span> <span> <input id="lastName" name="lastName"
						value="${lastName}" class="element text" size="14" /> <label>Last</label>
				</span></li>
				<li><label class="description" for="ipn">IPN </label>
					<div>
						<input id="ipn" name="ipn" value="${ipn}"
							class="element text medium" type="text" />
					</div></li>
				<li><label class="description" for="address">Address </label>
					<div>
						<input id="address" name="address" value="${address}"
							class="element text medium" type="text" />
					</div></li>
				<li><label class="description" for="phone">Phone </label>
					<div>
						<input id="phone" name="phone" value="${phone}"
							class="element text medium" type="text" />
					</div></li>
				<li><label class="description" for="email">Email </label>
					<div>
						<input id="email" name="email" value="${email}"
							class="element text medium" type="text" />
					</div></li>

				<li class="buttons"><input type="hidden" name="action"
					value="add" /> <input type="hidden" name="instance"
					value="customer" /> <input id="saveForm" class="button_text"
					type="submit" name="submit" value="Submit" /></li>
			</ul>
		</form>
		<div id="footer"></div>
	</div>
	<img id="bottom" src="images/bottom.png">
</body>
</html>