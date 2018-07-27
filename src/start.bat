@echo off
del UI.class
javac UI.java
java UI | findstr "Exit"
if errorlevel 1 (
    PAUSE
)