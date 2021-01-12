package com.facebook.datasource;

import com.facebook.common.internal.j;
/* loaded from: classes14.dex */
public class c {
    public static <T> b<T> y(Throwable th) {
        g eqQ = g.eqQ();
        eqQ.u(th);
        return eqQ;
    }

    public static <T> j<b<T>> z(final Throwable th) {
        return new j<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: eqK */
            public b<T> get() {
                return c.y(th);
            }
        };
    }
}
