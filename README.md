# Дипломный проект профессии «Тестировщик»

В рамках дипломного проекта требовалось автоматизировать тестирование комплексного сервиса покупки тура,
взаимодействующего с СУБД и API Банка.

База данных хранит информацию о заказах, платежах, статусах карт, способах оплаты.

Для покупки тура есть два способа: с помощью карты и в кредит.

[Дипломное задание](https://github.com/netology-code/qa-diploma).

## Тестовая документация

1. [План тестирования](https://github.com/pno666/diplom/blob/main/documents/Plan.md);
1. [Отчёт по итогам тестирования](https://github.com/pno666/diplom/blob/main/documents/Report.md);
1. [Отчет по итогам автоматизации](https://github.com/pno666/diplom/blob/main/documents/Summary.md)

## Запуск приложения

### Подготовительный этап

1. Установить и запустить [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/)
1. Установать и запустить [Docker Desktop](https://www.docker.com/)
1. Установить и запустить [Git](https://git-scm.com/downloads)
1. Склонировать [репозиторий](https://github.com/pno666/diplom) с Github, скачав ZIP-файл, или при помощи команды в Git
   Bash:
   ```
   git clone https://github.com/pno666/diplom.git
   ```
1. Открыть проект в IntelliJ IDEA

### Запуск тестового приложения

1. В файлах `build.gradle` и `application.properties` раскомментруйте URL той СУБД, с помощью которой хотите запустить
   приложение (после изменений в build.gradle не забудьте загрузить изменения Ctrl+Shift+O):
    * `build.gradle`
   ``` 
   systemProperty 'db.url', System.getProperty('db.url', 'jdbc:mysql://localhost:3306/app') - MySQL
   systemProperty 'db.url', System.getProperty('db.url', 'jdbc:postgresql://localhost:5432/app') - PostgreSQL
   ```
    * `application.properties`
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/app - MySQL
   spring.datasource.url=jdbc:postgresql://localhost:5432/app - PostgreSQL
   ```
1. Запустить MySQL, PostgreSQL, NodeJS через терминал командой:
   ```
   docker-compose up -d
   ```
1. Через терминал запустить тестируемое приложение командой:
   ```
   java -jar artifacts/aqa-shop.jar
   ```
1. Убедиться в готовности системы. Приложение должно быть доступно по адресу:
   ```
   http://localhost:8080/
   ```

### Запуск тестов

1. При помощи `Double Ctrl` вызовите `Run Anything`
2. В поле `Run Anything` введите команду:
   ```
   gradle clean test
   ```

### Перезапуск тестов и приложения

Для остановки приложения в окне терминала нужно ввести команду `Ctrl+С` и повторить необходимые действия из предыдущих
разделов.

## Формирование отчёта о тестировании

Предусмотрено формирование отчётности через Allure. Для этого:

1. При помощи `Double Ctrl` вызовите `Run Anything`
2. В поле `Run Anything` введите команду:
   ```
   gradle allureServe
   ```