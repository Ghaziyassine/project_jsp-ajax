<%@page import="ma.school.service.MarqueService"%>
<%@page import="ma.school.beans.Marque"%>
<%@page import="ma.school.service.MachineService"%>
<%@page import="java.util.List"%>
<%@page import="ma.school.beans.Machine"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Graphique de machines par marque</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link href="style/monStyle.css" rel="stylesheet" type="text/css"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            padding: 20px;
        }

        canvas#machineChart {
            width: 80%;
            max-width: 800px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<%@include file="template/menu.jsp" %>

<div style="background-color: #fff; border: 1px solid #ddd; padding: 20px;">
    <h1 style="text-align: center;">Graphique de machines par marque</h1>
    
    <!-- Ajoutez la liste déroulante pour choisir le type de graphique -->
    <div style="text-align: center;">
        <label for="chartType">Choisissez le type de graphique :</label>
        <select id="chartType" onchange="updateChart()">
            <option value="bar">Barre</option>
            <option value="line">Ligne</option>
            <option value="pie">Camembert</option>
        </select>
    </div>
    
    <canvas id="machineChart"></canvas>
</div>

<%
    // Remplacez cette partie avec le code Java pour récupérer les données de la base de données
    MachineService ms = new MachineService();
    MarqueService mrs = new MarqueService();
    List<Machine> machines = ms.findAll();
    List<Marque> marques = mrs.findAll();
%>
<script>
    // Création d'un tableau pour stocker les données
    var labels = [];
    var data = [];
    var selectedChartType = "bar"; // Type de graphique par défaut

    // Boucle pour extraire les données de la liste de machines
    <%
        for (Marque marque : marques) {
    %>
    labels.push("<%= marque.getLibelle()%>"); // Remplacez par le nom de la propriété de la marque
    data.push(<%= ms.findByMarque(marque).size() %>); // Remplacez par la propriété de la machine que vous souhaitez afficher
    <%
        }
    %>

    // Création du graphique initial
    var ctx = document.getElementById('machineChart').getContext('2d');
    var machineChart = new Chart(ctx, {
        type: selectedChartType, // Type de graphique initial
        data: {
            labels: labels,
            datasets: [{
                label: 'Nombre de machines par marque',
                data: data,
                backgroundColor: [
                    'rgba(75, 192, 192, 0.6)',
                    'rgba(255, 99, 132, 0.6)',
                    'rgba(255, 206, 86, 0.6)',
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(153, 102, 255, 0.6)',
                    'rgba(255, 159, 64, 0.6)'
                ],
                borderColor: [
                    'rgba(75, 192, 192, 1)',
                    'rgba(255, 99, 132, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    suggestedMax: 20
                }
            }
        }
    });

    // Fonction pour mettre à jour le graphique en fonction de la sélection de l'utilisateur
    function updateChart() {
        selectedChartType = document.getElementById('chartType').value;
        
        // Détruire le graphique existant
        machineChart.destroy();
        
        // Créer un nouveau graphique avec le type sélectionné
        machineChart = new Chart(ctx, {
            type: selectedChartType,
            data: {
                labels: labels,
                datasets: [{
                    label: 'Nombre de machines par marque',
                    data: data,
                    backgroundColor: [
                        'rgba(75, 192, 192, 0.6)',
                        'rgba(255, 99, 132, 0.6)',
                        'rgba(255, 206, 86, 0.6)',
                        'rgba(54, 162, 235, 0.6)',
                        'rgba(153, 102, 255, 0.6)',
                        'rgba(255, 159, 64, 0.6)'
                    ],
                    borderColor: [
                        'rgba(75, 192, 192, 1)',
                        'rgba(255, 99, 132, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true,
                        suggestedMax: 20
                    }
                }
            }
        });
    }
</script>
</body>
</html>
