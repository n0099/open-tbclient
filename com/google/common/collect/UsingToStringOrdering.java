package com.google.common.collect;

import java.io.Serializable;
/* loaded from: classes6.dex */
public final class UsingToStringOrdering extends Ordering<Object> implements Serializable {
    public static final UsingToStringOrdering INSTANCE = new UsingToStringOrdering();
    public static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    public String toString() {
        return "Ordering.usingToString()";
    }
}
