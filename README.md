### **Inspiration**  
The idea behind **Snake AI** was to **elevate the traditional Snake game** by introducing a **competitive AI opponent** that can challenge the player in real-time. I wanted to integrate **pathfinding algorithms** into game development and explore how **Dijkstra’s algorithm** could be applied to create an intelligent snake that actively competes with the player. This project was also an opportunity to **deepen my knowledge of Java Swing and AWT**, refining my ability to build interactive graphical applications.  

### **What it does**  
**Snake AI** is a **single-player snake game** where the player competes against an AI-controlled snake. The **AI snake uses Dijkstra’s algorithm** to determine the **shortest path to the apple**, making it incredibly efficient at collecting points. The player must **strategically maneuver** to eat apples before the AI, adding a layer of difficulty and competition. The game’s **graphical interface** is built using **Java Swing and AWT**, ensuring smooth rendering and responsive controls.  

### **How I built it**  
The game was developed in **Java**, utilizing **Swing and AWT** for GUI rendering. The core mechanics, such as movement and apple spawning, were built using **object-oriented programming principles**. Key aspects of the development process included:  
- **Pathfinding Algorithm**: Implemented **Dijkstra’s algorithm** using **HashMaps** and **priority queues** to calculate the shortest route for the AI snake.  
- **Game Loop & Collision Detection**: Designed an efficient game loop to handle player and AI movements while ensuring smooth gameplay.  
- **GUI Development**: Utilized **Java Swing and AWT** to render the game board, track game states, and create an interactive user experience.  

### **Challenges I ran into**  
One of the biggest challenges was **optimizing Dijkstra’s algorithm** for real-time gameplay. Since pathfinding calculations occur every frame, ensuring that the AI’s movements remained **fast and efficient** was critical. Another challenge was **balancing gameplay difficulty**—the AI snake was so efficient that it often **outperformed the player too easily**, so I had to tweak mechanics to keep the game engaging and fun.  

### **Accomplishments that I'm proud of**  
I’m proud that I successfully **integrated an advanced pathfinding algorithm** into a real-time game and made it work seamlessly. This was my **first project involving AI-driven behavior**, and seeing the AI snake navigate the board dynamically was a major milestone. Additionally, creating an interactive and visually appealing **GUI using Swing and AWT** helped me gain confidence in **desktop application development**.  

### **What I Learned**  
This project gave me a **deep understanding of Dijkstra’s algorithm**, particularly its **real-world applications in pathfinding and game AI**. I also improved my **Java GUI development skills**, learning how to effectively manage **event-driven programming** and optimize rendering performance in **Swing and AWT**. Additionally, working with **data structures like HashMaps and priority queues** helped reinforce my knowledge of efficient data handling in Java.  

### **What’s Next for Snake AI**  
In the future, I’d like to expand **Snake AI** with additional features:  
- **Adaptive AI difficulty**, where the AI’s intelligence scales based on player performance.  
- **Alternative pathfinding algorithms**, such as **A* search**, to compare efficiency and performance.  
- **Multiplayer mode**, allowing players to compete against each other and AI opponents.  
- **Power-ups and obstacles**, adding variety and unpredictability to gameplay.  

Building upon **Snake AI** with more advanced AI strategies and multiplayer capabilities would be a fun challenge, and I’m excited to explore these improvements in future iterations!
<br>
![SnakeShortestPathVideo](https://github.com/user-attachments/assets/e0184533-2518-4470-a12b-0c4a2469f42f)
