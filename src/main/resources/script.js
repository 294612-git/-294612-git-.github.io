// Call Java backend API when button is clicked
document.getElementById('apiBtn').addEventListener('click', function() {
    fetch('/api/data')
        .then(response => response.json())
        .then(data => {
            const responseDiv = document.getElementById('apiResponse');
            responseDiv.innerHTML = `
                <strong>Response from Java Backend:</strong><br>
                Message: ${data.message}<br>
                Timestamp: ${new Date(data.timestamp).toLocaleString()}
            `;
            responseDiv.classList.add('show');
        })
        .catch(error => {
            const responseDiv = document.getElementById('apiResponse');
            responseDiv.innerHTML = `<strong>Error:</strong> ${error.message}`;
            responseDiv.classList.add('show');
        });
});

// Smooth scrolling for navigation links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({ behavior: 'smooth' });
        }
    });
});
