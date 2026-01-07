# TravelWishlist

TravelWishlist is a simple web app that helps users plan and track their future trips. Users can add destinations with a description and travel date, see them on an interactive map, and manage their planned trips. Bonus features include budget estimation and flight price tracking.


## Features

- Search for a destination and view it on the map
- Add trips with a description and date
- Display planned trips under the map
- Save trips to a “Saved Trips” section
- Edit or delete trips
- (Bonus) Add a budget estimate
- (Bonus) Link to flight booking sites (e.g., Momondo)
- (Bonus) Manually save flight price


## Installation

1. Clone the repository:


2. Open `index.html` in a browser, or run a live server extension for live reload.
3. Make sure PostgreSQL is running and update application.properties with your database credentials:

spring.datasource.url=jdbc:postgresql://localhost:5050/travel_wishlist
spring.datasource.username=postgres
spring.datasource.password=12345


4. Run the Spring Boot application (TravelWishlistApplication.java).

Open the app in a browser: http://localhost:8080/.

(Optional) Use Live Server in VS Code or IntelliJ Live Edit plugin for automatic updates when saving files.


## Usage

1. Enter a destination, description, and date in the input fields.

2. Click Add to save the trip. It will appear under the map.

3. Click Edit or Delete on a trip to modify or remove it.

4. Search for a location using the search bar or click directly on the map to set a destination.

## Screenshots
Skiss 1: 
<img width="1024" height="1536" alt="ChatGPT Image 21 maj 2025 14_26_37" src="https://github.com/user-attachments/assets/3a014770-d45c-4f77-a1e2-f97cc7733ffd" />

Desktop : 

+-----------------------------------------------------------+
| H1: Travel Wishlist              [💖 Saved Trips]         |
+-----------------------------------------------------------+
| [Destination input]  [Description input]  [Date input]   |
|                               [Add Button]               |
+-----------------------------------------------------------+
|                       [MAP]                              |
|        (interactive map centered on the page)           |
+-----------------------------------------------------------+
|                 Planned Trips                             |
|  1. Japan | Visit temples | 2026-03-15 [Edit][Delete]    |
|  2. Thailand | Beach trip | 2026-05-20 [Edit][Delete]   |
+-----------------------------------------------------------+


Mobile: 

+-------------------------------+
| H1: Travel Wishlist           |
| [💖 Saved Trips]              |
+-------------------------------+
| [Destination input]           |
| [Description input]           |
| [Date input]                  |
| [Add Button]                  |
+-------------------------------+
|          [MAP]                |
|   (interactive map in center) |
+-------------------------------+
|       Planned Trips           |
| - Japan | Temples | 15/03     |
|   [Edit] [Delete]             |
| - Thailand | Beach | 20/05    |
|   [Edit] [Delete]             |
+-------------------------------+

## Technologies Used

* Backend: Java 21, Spring Boot, Spring Data JPA

* Database: PostgreSQL

* Frontend: HTML, CSS, JavaScript, Thymeleaf (template engine)

* Map: Leaflet + OpenStreetMap

* Development Tools: IntelliJ IDEA, Git/GitHub




## Future Improvements

* Move frontend to React for a fully dynamic UI

* Add user authentication and individual accounts

* Automatically fetch flight prices via API

* Improved UX/UI design based on user feedback

* Add budget tracking and statistics per trip


