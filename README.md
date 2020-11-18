## Библиотека

WEB-api с использованием REST для учета полученных книг в библиотеке. Предусмотрена авторизация с использованием JWT(логин,пароль).

API :
- Возвращает перечень книг пользователя
  - Все книги
  - Сданные книги
  - Не сданные книги
- Добавляет книги в каталог(автор, наименование, ISBN, дата получения, состояние(сдана\не сдана))
- Изменяет состояние сдачи книги
- Удаленет книги
Данные и пользователей хранить в базе

______________________________________________________________________________________________________

 - Spring Boot
 - Spring Data
 - Security\JWT
 - Hibernate
 - HSQLDB(in-memory)
 - Lombok
 - Curl


Curl: 

Login 
> curl -i -H "Content-Type: application/json" -X POST -d '{
      "username": "admin1",
      "password": "123"
  }' http://localhost:8181/login

Sign-up 
>curl -i -H "Content-Type: application/json" -X POST -d '{
       "username": "admin1",
       "password": "123"
   }' http://localhost:8181/sign-up

Добавить книгу в каталог
>curl -i -H "Content-Type: application/json" -H  "Authorization: Bearer xxx_token_xxx" -X POST -d '{
>"author":"author10" ,
>"name":"name10"}'
>http://localhost:8181/book

Получить книги пользователя 
>curl -H "Content-Type: application/json" -H "Authorization: Bearer xxx_token_xxx" http://localhost:8181/user/books

Получить сданные книги пользователя
>curl -H "Content-Type: application/json" -H "Authorization: Bearer xxx_token_xxx" http://localhost:8181/user/books/absent

Получить не сданные книги пользователя
>curl -H "Content-Type: application/json" -H "Authorization: Bearer xxx_token_xxx" http://localhost:8181/user/books/available

Получить каталог книг
>curl -H "Content-Type: application/json" -H "Authorization: Bearer xxx_token_xxx" http://localhost:8181/book

Изменить состояние книги в каталоге
>curl -i -H "Content-Type: application/json" -H "Authorization: Bearer xxx_token_xxx" -X PUT http://localhost:8181/book/change-status/{id}

Удаление книги из каталога
>curl -i -H "Content-Type: application/json" -H "Authorization: Bearer xxx_token_xxx" -X DELETE http://localhost:8181/book/{id}

Получить списов доступных книг из каталога
>curl -H "Content-Type: application/json" -H  "Authorization: Bearer xxx_token_xxx" http://localhost:8181/book/available

Получить списов недоступных книг из каталога
>curl -H "Content-Type: application/json" -H "Authorization: Bearer xxx_token_xxx" http://localhost:8181/book/absent





