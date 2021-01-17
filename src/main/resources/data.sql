INSERT INTO T_USERS (ID, Name) VALUES
(1, 'Tom'),
(2, 'Joyce'),
(3, 'Eric');

INSERT INTO T_ROLES (ID, Name) VALUES
(1, 'Admin'),
(2, 'Developer'),
(3, 'User');

INSERT INTO T_USERS_ROLES(USERS_ID, ROLES_ID) VALUES
(1, 1),
(2, 2),
(3, 2),
(3, 3);