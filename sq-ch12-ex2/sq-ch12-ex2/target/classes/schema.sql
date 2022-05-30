CREATE TABLE IF NOT EXISTS purchase (
    id  SERIAL,
    product varchar(50) NOT NULL,
    price double precision NOT NULL,
    version varchar(8)
);
