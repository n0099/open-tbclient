package com.facebook.datasource;

import com.facebook.common.internal.i;
/* loaded from: classes2.dex */
public class c {
    public static <T> b<T> x(Throwable th) {
        g cuy = g.cuy();
        cuy.u(th);
        return cuy;
    }

    public static <T> i<b<T>> y(final Throwable th) {
        return new i<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cuu */
            public b<T> get() {
                return c.x(th);
            }
        };
    }
}
