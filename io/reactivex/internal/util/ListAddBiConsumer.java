package io.reactivex.internal.util;

import f.a.w.c;
import java.util.List;
/* loaded from: classes7.dex */
public enum ListAddBiConsumer implements c<List, Object, List> {
    INSTANCE;

    public static <T> c<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.a.w.c
    public List apply(List list, Object obj) throws Exception {
        list.add(obj);
        return list;
    }
}
