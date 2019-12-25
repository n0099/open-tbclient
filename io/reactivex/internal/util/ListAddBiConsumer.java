package io.reactivex.internal.util;

import java.util.List;
/* loaded from: classes4.dex */
public enum ListAddBiConsumer implements io.reactivex.b.c<List, Object, List> {
    INSTANCE;

    public static <T> io.reactivex.b.c<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.b.c
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}
