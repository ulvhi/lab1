create TABLE reservartions(
    id BIGSERIAL PRIMARY KEY,
    table_name VARCHAR,
    customer VARCHAR(64),
    date DATE,
    status VARCHAR,
    members_count int
);