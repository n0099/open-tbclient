package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes17.dex */
public enum ArrayListSupplier implements io.reactivex.c.h<Object, List<Object>>, Callable<List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> io.reactivex.c.h<O, List<T>> asFunction() {
        return INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public List<Object> call() throws Exception {
        return new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.c.h
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }
}
