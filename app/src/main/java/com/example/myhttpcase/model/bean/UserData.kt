package com.example.myhttpcase.model.bean

/**
 *
 * 作者: 杨志凡
 * 时间: 2024/5/10 16:44
 */
data class UserData(
    val bookmarkedNewsResources: Set<String>,
    val viewedNewsResources: Set<String>,
    val followedTopics: Set<String>,
    val useDynamicColor: Boolean,
    val shouldHideOnboarding: Boolean,
)
