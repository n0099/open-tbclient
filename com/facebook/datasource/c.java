package com.facebook.datasource;

import com.facebook.common.internal.i;
/* loaded from: classes2.dex */
public class c {
    public static <T> b<T> u(Throwable th) {
        g cDw = g.cDw();
        cDw.s(th);
        return cDw;
    }

    public static <T> i<b<T>> v(final Throwable th) {
        return new i<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cDs */
            public b<T> get() {
                return c.u(th);
            }
        };
    }
}
