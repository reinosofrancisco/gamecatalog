# PostgreSQL

## Change Default Password

Start PostgreSQL with `postgres` user. 
```bash
sudo -u postgres psql postgres
```

Change password
```sql
ALTER USER postgres PASSWORD 'Localhost1';
```

## Create Database

Create database then connect to it via psql command
```sql
CREATE DATABASE catalog;
\c catalog
```

## Add a Game

```bash
curl --header "Content-Type: application/json" \
--request POST \
--data '{"name":"SOTC","genre":"Adventure","platform":"PS2","releaseDate":"2005-10-18","imgUrl":"nopath_yet","developer":"Team Ico","publisher":"sony"}' \
http://localhost:8080/api/v1/addGame
```

## Send Game List to the email
Go to `myaccount.google.com/apppasswords` and create an new app password.
Then create a `config.properties` file at `/resources` folder with the following content:

```
ext.mail.username=CHANGEME@gmail.com
ext.mail.password=CHANGEME
```

