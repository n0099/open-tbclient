package com.facebook.datasource;

import com.facebook.common.internal.j;
/* loaded from: classes3.dex */
public class c {
    public static <T> b<T> y(Throwable th) {
        g euK = g.euK();
        euK.u(th);
        return euK;
    }

    public static <T> j<b<T>> z(final Throwable th) {
        return new j<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: euE */
            public b<T> get() {
                return c.y(th);
            }
        };
    }
}
