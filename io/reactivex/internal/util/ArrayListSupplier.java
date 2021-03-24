package io.reactivex.internal.util;

import f.a.w.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public enum ArrayListSupplier implements Callable<List<Object>>, h<Object, List<Object>> {
    INSTANCE;

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> h<O, List<T>> asFunction() {
        return INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.a.w.h
    public List<Object> apply(Object obj) throws Exception {
        return new ArrayList();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    public List<Object> call() throws Exception {
        return new ArrayList();
    }
}
