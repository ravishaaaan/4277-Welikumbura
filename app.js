const express = require('express');
const app = express();

app.get('/', (req, res) => {
  res.json([
    {
      id: '1',
      type: 'Book',
      title: 'The Great Gatsby',
      author: 'F. Scott Fitzgerald',
    },
    {
      id: '2',
      type: 'Game',
      title: 'The Legend of Zelda: Breath of the Wild',
      platform: 'Nintendo Switch',
    },
    {
      id: '3',
      type: 'Movie',
      title: 'Inception',
      director: 'Christopher Nolan',
    },
  ]);
});

module.exports = app;
