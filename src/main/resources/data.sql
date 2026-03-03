INSERT INTO categories (name) VALUES ('Sport');
INSERT INTO categories (name) VALUES ('Java Grundlagen');
INSERT INTO categories (name) VALUES ('Geografie');

-- Sport Fragen (category_Id = 1)
INSERT INTO questions (question_text, option0, option1, option2, option3, correct_index, category_id)
VALUES ('Wer wurde 2025 Formel 1 Weltmeister?', 'Max Verstappen', 'Lewis Hamilton', 'Lando Norris', 'Oscar Piastri', 2, 1);

INSERT INTO questions (question_text, option0, option1, option2, option3, correct_index, category_id)
VALUES ('Welches Land hat bei den Olympischen Winterspielen 2026 im Eishockey der Herren und Frauen Gold geholt?', 'USA', 'Kanada', 'Deutschland', 'Finnland', 0, 1);

INSERT INTO questions (question_text, option0, option1, option2, option3, correct_index, category_id)
VALUES ('Wie viele Spieler hat eine Fußballmannschaft auf dem Feld?', '9', '10', '11', '12', 2, 1);

-- Java Grundlagen Fragen (category_Id = 2)
INSERT INTO questions (question_text, option0, option1, option2, option3, correct_index, category_id)
VALUES ('Was ist Java?', 'Ein Land', 'Eine Programmiersprache', 'Ein Kaffee', 'Ein Betriebssystem', 1, 2);

INSERT INTO questions (question_text, option0, option1, option2, option3, correct_index, category_id)
VALUES ('Was bedeutet OOP?', 'Open Object Protocol', 'Objektorientierte Programmierung', 'Optional Object Parameter', 'Online Output Process', 1, 2);

INSERT INTO questions (question_text, option0, option1, option2, option3, correct_index, category_id)
VALUES (
  'Was ist der Unterschied zwischen == und .equals()?',
  'Kein Unterschied',
  '== vergleicht Referenzen, .equals() vergleicht Inhalte',
  '.equals() vergleicht Referenzen, == vergleicht Inhalte',
  '== funktioniert nur bei Strings',
  1, 2
);

-- Geografie Fragen (category_Id = 3)
INSERT INTO questions (question_text, option0, option1, option2, option3, correct_index, category_id)
VALUES ('Was ist die Hauptstadt von Deutschland?', 'München', 'Hamburg', 'Berlin', 'Frankfurt', 2, 3);

INSERT INTO questions (question_text, option0, option1, option2, option3, correct_index, category_id)
VALUES ('Wie heißt die Hauptstadt von Australien?', 'Sydney', 'Melbourne', 'Perth', 'Canberra', 3, 3);

INSERT INTO questions (question_text, option0, option1, option2, option3, correct_index, category_id)
VALUES ('Wie heißt der längste Fluss der Welt?', 'Nil', 'Rhein', 'Mississippi', 'Donau', 0, 3);