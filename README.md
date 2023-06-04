## Процедура запуска автотестов:
#### 1. Предварительные условия
- на ПК должны быть установлены IntelliJ IDEA и Appium. 
- тесты написаны в редакторе кода IntelliJ IDEA при помощи Appium
#### 2. Подключение устройства и запуск программ
- запустить Appium Server 
- ОПЦИОНАЛЬНО - в случае возникновения проблем с подключением запустить команду appium doctor
- запустить IntelliJ IDEA
- подключить физическое устройство в режиме отладки к компьютеру или запустить эмулятор с установленным тестовым приложением
#### 3. Запуск тестов
- перейти в папку: src/test/java/ru.netology/qamid
- открыть тестовые файлы из указанной папки (тестовые файлы разделены по соответствующим разделам тестируемого приложения)
- в каждом тестовом файле нажать на кнопку запуска тестов рядом с названием класса - для запуска группы тестов или на кнопку запуска отдельного теста - для запуска каждого теста по отдельности