package com.facebook.datasource;

import com.facebook.common.internal.i;
/* loaded from: classes2.dex */
public class c {
    public static <T> b<T> v(Throwable th) {
        g bTQ = g.bTQ();
        bTQ.t(th);
        return bTQ;
    }

    public static <T> i<b<T>> x(final Throwable th) {
        return new i<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: bTM */
            public b<T> get() {
                return c.v(th);
            }
        };
    }
}
