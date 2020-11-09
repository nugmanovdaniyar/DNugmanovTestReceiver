package ru.nugmanov.DNugmanovTestReceiver.service;

public interface CrudService<T, ID> {
    T save(T object);
}
