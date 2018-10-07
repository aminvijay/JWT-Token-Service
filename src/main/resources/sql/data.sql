INSERT INTO app_user (id, username, password, first_name, last_name) VALUES (1, 'ajay', '$2a$10$3e/uiTzrXtdiKo6NyrGPU.X9UZM.S9XiqUKe3qEpZQILCsJ1.4cEu',  'ajay', 'patel');
INSERT INTO app_user (id, username, password, first_name, last_name) VALUES (2, 'admin', 'admin',  'avani', 'patel');


INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User has no admin rights.');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User has permission to admin task.');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);

