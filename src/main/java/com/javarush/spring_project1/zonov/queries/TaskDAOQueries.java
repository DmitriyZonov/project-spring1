package com.javarush.spring_project1.zonov.queries;

public final class TaskDAOQueries {

    public static final String GET_ALL = "select t from Task t";

    public static final String GET_ALL_COUNT = "select count(t) from Task t";

    public static final String GET_BY_ID = "select t from Task t where t.id = :ID";
}
