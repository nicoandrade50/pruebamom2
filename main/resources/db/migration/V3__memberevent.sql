CREATE TABLE IF NOT EXISTS memberevent(
    id SERIAL NOT NULL,
    member_id INT,
    event_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(member_id) REFERENCES member(id),
    FOREIGN KEY(event_id) REFERENCES event(id)
    );



































