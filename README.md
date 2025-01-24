# Blsky-Test
Chat app Blsky test

This project is a simple chat application developed using Android Native with following features:

Features

Full-Screen Chat Window

The app provides a full-screen chat interface with seamless navigation between two chat windows.

Swipe Navigation

Users can swipe left or right to switch between two chat windows.

Message Synchronization

Messages sent in the Left chat window by the "LEFT" sender will appear in the Right chat window as received messages, and vice versa.

Local Data Persistence

Messages are stored locally using Room Database, ensuring that all messages are preserved even when the app is closed and reopened.

Dynamic Message Alignment

Messages are displayed based on the sender (“LEFT” or “RIGHT”) with appropriate alignment for clarity and readability.

Project Structure

1. Main Components

LeftFragment: Displays the chat interface for the "LEFT" sender.

RightFragment: Displays the chat interface for the "RIGHT" sender.

ViewPager2: Enables swipe navigation between the two fragments.

RecyclerView: Used to display chat messages in a scrollable list.

2. Database

Room Database: Stores chat messages locally.

MessageEntity: Represents the structure of a message in the database.

MessageDao: Defines database operations (e.g., inserting and retrieving messages).

3. ViewModel

ChatViewModel: Manages data communication between the UI and the database, ensuring the data is reactive and persists across configuration changes.

4. Adapters

ChatAdapter: Handles the display of chat messages in the RecyclerView.


