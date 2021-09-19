<%-- 
    Document   : tabela-price
    Created on : 13 de set. de 2021, 22:30:24
    Author     : Jose Horacio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <%
    double vp=0, n=0, i=0, result=0, totalPago =0, totalJuros =0;
    String error = null;
    
    if(request.getParameter("vp")==null || request.getParameter("n")==null || request.getParameter("i")==null)
        {
        error = "Não foram informados os 3 parâmetros necessários 'VP' , 'N' e 'i' ";
        }
    else
        {
        try{vp = Double.parseDouble(request.getParameter("vp"));}
        catch(Exception e)
            {error = "O valor informado como parâmetro vp ('"+request.getParameter("vp")+"') não é um número válido";}
            
        try{n = Double.parseDouble(request.getParameter("n"));}
        catch(Exception e)
            {error = "O valor informado como parâmetro n ('"+request.getParameter("n")+"') não é um número válido";}
            
        try{i = Double.parseDouble(request.getParameter("i"));}
        catch(Exception e)
            {error = "O valor informado como parâmetro i ('"+request.getParameter("i")+"') não é um número válido";}
            
        try{
            result = (vp*(i/100))/(1-(1/Math.pow((1+(i/100)),n)));
            totalPago = result*n;
            totalJuros = totalPago-vp;
           }
        catch(Exception e)
            {error = "Erro de cálculo "+ e.getMessage();}
       }
   
    %>
            

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Price - Amortização</title>
    </head>
     
    <body>
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        
        <h2>Preencha os dados abaixo:</h2>
        
        <%if(error != null){%>
        <div style="color: red"><%= error %></div>
        <%}else{%>
        <%--
        <div><%= vp %> , <%= n %> e <%= i %> = <%= result %></div>
        --%>
        <%}%>
                
            <form action="tabela-price.jsp" method="post">
                <input type="number"    placeholder="Valor Presente"        name="vp" required>
                <input type="number"    placeholder="Prazo (meses)"         name="n"  required>
                <input type="number"    placeholder="Taxa de Juros (% a.m)" name="i"  required>
                <input type="submit"    value="Calcular Prestação (PMT)">
            </form>
        
         
            <br/>
            
            <h2>Resultado:</h2>
            <table border = 1>
                <tr>
                    <td>Valor Parcela Amortização</td>
                    <td><% out.print("R$ " + result ); %></td>
                </tr>
                <tr>
                    <td>Nº de parcelas</td>
                    <td><% out.print(n); %></td>
                </tr>
                <tr>
                    <td>Saldo Devedor</td>
                    <td><% out.print("R$ " + vp ); %></td>
                </tr>
                <tr>
                    <td>Total Pago</td>
                    <td><% out.print("R$ " + totalPago ); %></td>
                </tr>
                <tr>
                    <td>Juros Pago</td>
                    <td><% out.print("R$ " + totalJuros ); %></td>
                </tr>
                <tr>
                    <td>Taxa de Juros (a.m)</td>
                    <td><% out.print( i + "%"); %></td>
                </tr>
            </table>
                    
        <%@include file="../WEB-INF/jspf/footer.jspf" %>
    </body>
    
</html>           

