DROP TABLE IF EXISTS Transaction;  
CREATE TABLE Transaction (  
cust_id INT NOT NULL,  
trans_id INT NOT NULL,
trans_date DATE NOT NULL,  
trans_amount INT NOT NULL,
PRIMARY KEY (cust_id,trans_id,trans_date)
);  