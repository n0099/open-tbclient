package com.google.common.base;

import d.h.c.a.g;
import d.h.c.a.n;
/* loaded from: classes6.dex */
public enum Functions$ToStringFunction implements g<Object, String> {
    INSTANCE;

    @Override // java.lang.Enum
    public String toString() {
        return "Functions.toStringFunction()";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.a.g
    public String apply(Object obj) {
        n.p(obj);
        return obj.toString();
    }
}
