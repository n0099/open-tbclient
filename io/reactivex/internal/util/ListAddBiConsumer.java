package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.List;
/* loaded from: classes7.dex */
public enum ListAddBiConsumer implements BiFunction<List, Object, List> {
    INSTANCE;

    public static <T> BiFunction<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.functions.BiFunction
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}
