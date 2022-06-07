package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TodosTests {
    Todos todos;


    @BeforeEach
    public void beforeEachMethod() {
        todos = new Todos();
    }
    @ParameterizedTest
    @ValueSource(strings = {"Акробатика", "Пробежка"})
    public void test_add_task(String e) {
        todos.addTask(e);
        Assertions.assertTrue(todos.getAllTasks().contains(e));
    }


    @ParameterizedTest
    @ValueSource(strings = {"Акробатика", "Пробежка"})
    public void test_remove_task(String g) {
        todos.addTask(g);
        todos.removeTask(g);
        Assertions.assertFalse(todos.getAllTasks().contains(g));
    }


    @Test
    public void test_get_all_tasks() {
        todos.addTask("Пробежка");
        todos.addTask("Акробатика");
        String expected = "Акробатика Пробежка";
        String result = todos.getAllTasks();
        Assertions.assertEquals(result, expected);
    }
}