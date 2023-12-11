const express = require('express');
const sql = require('mssql');

const app = express();
const PORT = 3000;

// Thông tin kết nối đến SQL Server
const config = {
  server: 'your_server',
  user: 'your_username',
  password: 'your_password',
  database: 'your_database',
  options: {
    encrypt: false, // Nếu sử dụng kết nối qua SSL, đặt giá trị này là true
  },
};

// Kết nối đến cơ sở dữ liệu
sql.connect(config, (err) => {
  if (err) {
    console.error('Không thể kết nối đến cơ sở dữ liệu:', err);
  } else {
    console.log('Đã kết nối đến cơ sở dữ liệu');
  }
});

// Định nghĩa route để lấy dữ liệu từ cơ sở dữ liệu
app.get('/api/data', (req, res) => {
  // Thực hiện truy vấn cơ sở dữ liệu
  const query = 'SELECT * FROM your_table';
  sql.query(query, (err, result) => {
    if (err) {
      console.error('Lỗi truy vấn cơ sở dữ liệu:', err);
      res.status(500).send('Lỗi truy vấn cơ sở dữ liệu');
    } else {
      // Trả về kết quả
      res.json(result.recordset);
    }
  });
});

// Khởi động server
app.listen(PORT, () => {
  console.log(`Server đang lắng nghe tại http://localhost:${PORT}`);
});
