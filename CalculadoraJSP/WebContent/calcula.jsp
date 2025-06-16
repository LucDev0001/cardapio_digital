<html>
  <head>
    <title>Calculadora JSP</title>
  </head>
  <body>
    <h2>Calculadora Simples</h2>
    <form
      action="calculo"
      method="post"
    >
      Valor 1:
      <input
        type="text"
        name="valor1"
      /><br />
      Valor 2:
      <input
        type="text"
        name="valor2"
      /><br />
      Operação:
      <select name="operacao">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option></select
      ><br />
      <input
        type="submit"
        value="Calcular"
      />
    </form>

    <% String resultado = (String) request.getAttribute("resultado"); if
    (resultado != null) { %>
    <h3>Resultado: <%= resultado %></h3>
    <% } %>
  </body>
</html>
