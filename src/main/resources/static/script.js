document.addEventListener("DOMContentLoaded", () => {
    // Leaflet-map
    const map = L.map('map').setView([50, 10], 4);

    // add OpenStreetMap tiles
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; OpenStreetMap contributors'
    }).addTo(map);

    let currentMarker = null;

    // search - OpenStreetMap (Nominatim)
    async function searchLocation(query) {
        if (!query) return;

        const url = `https://nominatim.openstreetmap.org/search?format=json&q=${encodeURIComponent(query)}`;

        try {
            const response = await fetch(url);
            const data = await response.json();

            if (data.length === 0) {
                alert("No location found!");
                return;
            }

            const { lat, lon, display_name } = data[0];


            if (currentMarker) {
                map.removeLayer(currentMarker);
            }


            map.setView([lat, lon], 6);


            currentMarker = L.marker([lat, lon]).addTo(map)
                .bindPopup(display_name)
                .openPopup();


            const destinationInput = document.querySelector('input[name="destination"]');
            if (destinationInput) {
                destinationInput.value = display_name;
            }

        } catch (error) {
            console.error("Error searching location:", error);
        }
    }

    const searchInput = document.getElementById("searchInput");
    if (searchInput) {
        searchInput.addEventListener("keydown", (event) => {
            if (event.key === "Enter") {
                event.preventDefault();
                const query = searchInput.value.trim();
                searchLocation(query);
            }
        });
    }


    map.on('click', async (event) => {
        const { lat, lng } = event.latlng;


        if (currentMarker) {
            map.removeLayer(currentMarker);
        }


        currentMarker = L.marker([lat, lng]).addTo(map);

        try {

            const response = await fetch(`https://nominatim.openstreetmap.org/reverse?format=json&lat=${lat}&lon=${lng}`);
            const data = await response.json();

            const placeName = data.display_name || `Lat: ${lat}, Lon: ${lng}`;
            currentMarker.bindPopup(placeName).openPopup();


            const destinationInput = document.querySelector('input[name="destination"]');
            if (destinationInput) {
                destinationInput.value = placeName;
            }
        } catch (error) {
            console.error("Error reverse geocoding:", error);
        }
    });
});
