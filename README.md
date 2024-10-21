# Проект автоматизации тестирования площадки [поле.рф](https://поле.рф).

## Содержание:
 - Технологии и инструменты используемые для тестирования данного проекта.
 - Способы запусков автотестов:
   - Локальный запуск
   - Удаленный запуск
   - Параметры для запуска тестов в Jenkins
 - Визуализация.

## Технологии и инструменты используемые для тестирования данного проекта.

<p style="text-align: center;">
<a href="https://www.java.com/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" height="50" width="50"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="50" width="50"/></a>
<a href="https://gradle.org/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original-wordmark.svg" height="70" width="70"/></a>
<a href="https://github.com/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/github/github-original-wordmark.svg" height="50" width="50"/></a>
<a href="https://junit.org/junit5/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original-wordmark.svg" height="70" width="70"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="https://selenide.org/images/selenide-logo-big.png" width="70"/></a>
<a href="https://rest-assured.io/"><img src="https://rest-assured.io/img/logo-transparent.png" title="REST-assured" alt="REST-assured" width="50" height="50"/></a>
<a href="https://allurereport.org/"><img alt="Allure Report" height="50" src="https://allurereport.org/svg/logo-report-sign.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" height="50" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="https://aerokube.com/selenoid/images/aerokube_logo.svg" width="50"/></a>
</p>

Авто тесты реализованы на языке программирования `Java`.
В качестве системы сборки и запуска тестов локально используется `Gradle`, а в качестве фреймворка для тестирования `JUnit5`.
Для автоматизации графического (пользовательского) интерфейса используется библиотека `Selenide`, а для проверки API — `REST-assured`.
Для предоставления отчетности о выполнения прогона использован инструмент — `Allure-Report`. 
Отчет состоит из следующих элементов:
- Шаги;
- Снимок экрана для последнего шага теста;
- Видео выполнения;
- Исходный код страницы;
- Логи консоли браузера.

Указанные выше элементы позволяют не только предоставить отчетность менеджерам, но и в случае падений быстрее позволит разобраться в причине падения конкретного теста.

Удаленный запуск осуществляется с помощью `Selenoid`, который предоставляет фермы браузеров, а системой CI/CD выступает — `Jenkins`.

## Запуск автотестов.

#### Локальный запуск автотестов.

Для локального запуска тестов необходимо в эмуляторе терминала выполнить следущую команду:
```bash
gradle clean ui_tests
```

#### Удаленный запуск автотестов.

Для удаленного запуска необходимо выполнить:
```bash
clean
${TASK}
-DbaseUrl=${BASE_URL}
-DpageLoadStrategy=${PAGE_LOAD_STRATEGY}
-Dremote=https://user1:1234@${REMOTE}/wd/hub
-Dbrowser=${BROWSER}
-DbrowserVersion=${VERSION}
-DbrowserSize=${RESOLUTION}
--stacktrace
```

## Визуализация.

Пример Allure-отчета.
