CREATE TABLE IF NOT EXISTS conferencias(
    id SERIAL,
    title VARCHAR(100),
    speaker VARCHAR(100),
    hour TIME,
    event_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY(event_id) REFERENCES event(id)
    );
