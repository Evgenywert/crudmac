<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>стартовая страница</title>
    <style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f5f5f7;
            margin: 0;
        }

        h2 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }

        .apple-button {
            display: inline-block;
            padding: 15px 30px;
            font-size: 16px;
            color: white;
            background: linear-gradient(145deg, #555, #333);
            border-radius: 12px;
            text-decoration: none;
            text-align: center;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }

        .apple-button:hover {
            background: linear-gradient(145deg, #666, #444);
            transform: translateY(-3px);
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.3);
        }

        .apple-button:active {
            background: linear-gradient(145deg, #444, #222);
            transform: translateY(-1px);
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }

        .loading-overlay {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(255, 255, 255, 0.8);
            display: flex;
            justify-content: center;
            align-items: center;
            visibility: hidden;
        }

        .loading-overlay.visible {
            visibility: visible;
        }

        .loader {
            border: 12px solid #f3f3f3;
            border-radius: 50%;
            border-top: 12px solid #3498db;
            width: 60px;
            height: 60px;
            animation: spin 2s linear infinite;
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
    </style>
    <script>
        function showLoading() {
            document.getElementById('loading-overlay').classList.add('visible');
        }
    </script>
</head>
<body>
<div style="text-align: center;">
    <h2>Здравствуйте!</h2>
    <a href="http://localhost:8081/mycrud_war_exploded/users" class="apple-button" onclick="showLoading()">Перейти к пользователям</a>
</div>
<div id="loading-overlay" class="loading-overlay">
    <div class="loader"></div>
</div>
</body>
</html>
