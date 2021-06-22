package com.example.laboratory.statistics

import com.example.laboratory.data.Task
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Test


class StatisticsUtilTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero(){
        val tasks = listOf(Task("title", "desc", isCompleted = false))
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsHundredZero(){
        val tasks = listOf(Task("title", "desc", isCompleted = true))
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is`(100f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty(){
        val tasks = listOf(
            Task("Task1", "Desc1", isCompleted = true),
            Task("Task2", "Desc2", isCompleted = true),
            Task("Task3", "Desc3", isCompleted = false),
            Task("Task4", "Desc4", isCompleted = false),
            Task("Task5", "Desc5", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)

        assertThat(result.completedTasksPercent, `is`(40f))
        assertThat(result.activeTasksPercent, `is`(60f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeroes(){
        val result = getActiveAndCompletedStats(emptyList())

        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeroes(){
        val result = getActiveAndCompletedStats(null)

        assertThat(result.completedTasksPercent, `is`(0f))
        assertThat(result.activeTasksPercent, `is`(0f))
    }
}