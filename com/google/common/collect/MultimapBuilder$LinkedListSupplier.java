package com.google.common.collect;

import d.h.c.a.r;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public enum MultimapBuilder$LinkedListSupplier implements r<List<Object>> {
    INSTANCE;

    public static <V> r<List<V>> instance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.a.r
    public List<Object> get() {
        return new LinkedList();
    }
}
