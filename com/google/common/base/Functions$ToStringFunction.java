package com.google.common.base;

import d.g.c.a.g;
import d.g.c.a.n;
/* loaded from: classes6.dex */
public enum Functions$ToStringFunction implements g<Object, String> {
    INSTANCE;

    @Override // java.lang.Enum
    public String toString() {
        return "Functions.toStringFunction()";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.a.g
    public String apply(Object obj) {
        n.p(obj);
        return obj.toString();
    }
}
