package com.google.common.base;

import d.h.c.a.g;
/* loaded from: classes6.dex */
public enum Functions$IdentityFunction implements g<Object, Object> {
    INSTANCE;

    @Override // d.h.c.a.g
    public Object apply(Object obj) {
        return obj;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "Functions.identity()";
    }
}
