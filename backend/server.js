const express = require("express");
const { MongoClient } = require("mongodb");
const cors = require("cors");
require("dotenv").config();

const app = express();
app.use(cors());
app.use(express.json());

const client = new MongoClient(process.env.MONGO_URI);

let db;

async function start() {
  try {
    await client.connect();
    db = client.db("skillora_db");

    console.log("MongoDB connected");

    app.get("/notifications", async (req, res) => {
      try {
        const data = await db.collection("notifications").find().toArray();
        res.json(data);
      } catch (error) {
        res.status(500).json({ message: "Failed to get notifications" });
      }
    });

    app.post("/notifications", async (req, res) => {
      try {
        const result = await db.collection("notifications").insertOne(req.body);
        res.json(result);
      } catch (error) {
        res.status(500).json({ message: "Failed to save notification" });
      }
    });

    app.listen(5000, () => {
      console.log("Server running on port 5000");
    });
  } catch (error) {
    console.error("MongoDB connection error:", error);
  }
}

start();