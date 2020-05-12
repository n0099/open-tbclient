package com.facebook.datasource;

import com.facebook.common.internal.j;
/* loaded from: classes13.dex */
public class c {
    public static <T> b<T> B(Throwable th) {
        g dnI = g.dnI();
        dnI.z(th);
        return dnI;
    }

    public static <T> j<b<T>> C(final Throwable th) {
        return new j<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dnC */
            public b<T> get() {
                return c.B(th);
            }
        };
    }
}
