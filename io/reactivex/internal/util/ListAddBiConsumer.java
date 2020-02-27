package io.reactivex.internal.util;

import java.util.List;
/* loaded from: classes7.dex */
public enum ListAddBiConsumer implements io.reactivex.c.c<List, Object, List> {
    INSTANCE;

    public static <T> io.reactivex.c.c<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.c.c
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}
