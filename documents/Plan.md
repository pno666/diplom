# План тестирования покупки тура
## Тестовые сценарии
- Тесты подходят для разделов "Купить" и "Купить в кредит".
- Предусловие - перед прохождением теста необходимо перейти в тестируемый раздел.
#### Позитивные сценарии:
1. Валидные данные:

   Ввести в поле Номер карты: 4444 4444 4444 4441

   Ввести в поле Месяц: 01

   Ввести в поле Год: 23

   Ввести в поле Владелец: Ivan Ivanov

   Ввести в поле CVC/CVV: 123

   Нажать кнопку Продолжить
* Ожидаемый результат: запрос обрабатывается, появляется сообщение "Операция одобрена банком".
2. Заполнение поля "Владелец" валидными данными, содержащими дефис:

   Ввести в поле Номер карты: 4444 4444 4444 4441

   Ввести в поле Месяц: 01

   Ввести в поле Год: 23

   Ввести в поле Владелец: Ivanov-Krutov Ivan

   Ввести в поле CVC/CVV: 123

   Нажать кнопку Продолжить
* Ожидаемый результат: запрос обрабатывается, появляется сообщение "Операция одобрена банком".
#### Негативные сценарии:
1. Заполнение поля "Номер карты" данными, содержащие латиницу:

   Ввести в поле Номер карты: 1234 1234 1234 123D

   Ввести в поле Месяц: 01

   Ввести в поле Год: 23

   Ввести в поле Владелец: Ivanov-Krutov Ivan

   Ввести в поле CVC/CVV: 123

   Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Номер карты" появляется сообщение "Неверный формат".
2. Заполнение поля "Номер карты" данными, содержащие кириллицу:

    Ввести в поле Номер карты: 1234 1234 1234 123Д

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Номер карты" появляется сообщение "Неверный формат".
3. Заполнение поля "Номер карты" данными, содержащие спец. символы:

    Ввести в поле Номер карты: 1234 1234 1234 123!

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Номер карты" появляется сообщение "Неверный формат".
4. Заполнение поля "Владелец" данными, содержащие кириллицу:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Иван Иванов
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Владелец" появляется сообщение "Неверный формат".
5. Заполнение поля "Владелец" данными, содержащие цифры:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Iv4n Ivanov
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Владелец" появляется сообщение "Неверный формат".
6. Заполнение поля "Владелец" данными, содержащие спец. символы:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Ivan I!anov
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Владелец" появляется сообщение "Неверный формат".
7. Заполнение поля "Владелец" валидными данными, состоящими из 65 символов:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Ivan I!anov
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Владелец" появляется сообщение "Неверный формат".
8. Заполнение поля "Месяц" данными, содержащие латиницу:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: m1
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Месяц" появляется сообщение "Неверный формат".
9. Заполнение поля "Месяц" данными, содержащие кириллицу:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: м1
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Месяц" появляется сообщение "Неверный формат".
10. Заполнение поля "Месяц" данными, содержащие спец. символы:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: *1
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Месяц" появляется сообщение "Неверный формат".
11. Заполнение поля "Месяц" данными, содержащие одну цифру:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 1
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Месяц" появляется сообщение "Неверный формат".
12. Заполнение поля "Месяц" данными, содержащие "00":

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 00
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Месяц" появляется сообщение "Неверный формат".
13. Заполнение поля "Месяц" данными, содержащие число больше чем 12:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 14
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Месяц" появляется сообщение "Неверный формат".
14. Заполнение поля "Год" данными, содержащие латиницу:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: y3
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Год" появляется сообщение "Неверный формат".
15. Заполнение поля "Год" данными, содержащие кириллицу:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: г3
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Год" появляется сообщение "Неверный формат".
16. Заполнение поля "Год" данными, содержащие спец. символы:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: !3
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Год" появляется сообщение "Неверный формат".
17. Заполнение поля "Год" данными, содержащие число меньше чем 22:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 19
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Год" появляется сообщение "Неверный формат".
18. Заполнение поля "Год" данными, содержащие 1 цифру:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 3
    
    Ввести в поле Владелец: Ivanov-Krutov Ivan
    
    Ввести в поле CVC/CVV: 123
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "Год" появляется сообщение "Неверный формат".
19. Заполнение поля "CVC/CVV" данными, содержащие кириллицу:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Иван Иванов
    
    Ввести в поле CVC/CVV: 12д
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "CVC/CVV" появляется сообщение "Неверный формат".
20. Заполнение поля "CVC/CVV" данными, содержащие латиницу:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Иван Иванов
    
    Ввести в поле CVC/CVV: 12k
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "CVC/CVV" появляется сообщение "Неверный формат".
21. Заполнение поля "CVC/CVV" данными, содержащие спец.символы:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Иван Иванов
    
    Ввести в поле CVC/CVV: 12!
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Под полем "CVC/CVV" появляется сообщение "Неверный формат".
22. Заполнение поля "CVC/CVV" данными, содержащие 4 цифры:

    Ввести в поле Номер карты: 1234 1234 1234 1234

    Ввести в поле Месяц: 01
    
    Ввести в поле Год: 23
    
    Ввести в поле Владелец: Иван Иванов
    
    Ввести в поле CVC/CVV: 1222
    
    Нажать кнопку Продолжить
* Ожидаемый результат: Поле "CVC/CVV" заполняется первыми тремя цифрами.
23. Оставить все поля пустыми:

    Нажать кнопку Продолжить
* Ожидаемый результат: Под каждым полем появляется сообщение "Неверный формат".
24. Отказ банка при использовании второй карты:

    Ввести в поле Номер карты: 4444 4444 4444 4442

    Ввести в поле Месяц: 01

    Ввести в поле Год: 23

    Ввести в поле Владелец: Иван Иванов

    Ввести в поле CVC/CVV: 1222

    Нажать кнопку Продолжить
* Ожидаемый результат: запрос обрабатывается, появляется сообщение "Ошибка! Банк отказал в проведении операции".
## Перечень используемых инструментов
1. IntelliJ IDEA 2022.1.2 (Community Edition) как среда разработки.
2. Браузер Chrome - для работы со страницей.
3. Docker - для контейнеризации СУБД и Node.js.
4. GitHub - для хранения и демонстрации работы.
5. Selenide - фреймворк для автоматизированного тестирования веб-приложений.
6. JUnit. Библиотека для написания и запуска авто-тестов.
7. Gradle - Система управления зависимостями, которая позволит удобно ставить необходимые фреймворки.
8. Allure - Фреймворк, предназначенный для создания отчетов о выполнении тестов.
## Перечень и описание возможных рисков при автоматизации
1. Риск появления проблем с настройкой приложения и необходимых БД.
2. Риск появления проблем с правильной идентификацией полей ввода.
3. Риск неработающего заявленного функционала приложения.
## Интервальная оцена с учетом риска в часах
    48 часов
## План сдачи работ
1. 19.10 - 21.10 - Планирование
2. 22.10 - 10.11 - Настройка окружения, написание и отладка автотестов, тестирование.
3. 11.11 - 17.11 - Подготовка отчетов о проделанной работе.