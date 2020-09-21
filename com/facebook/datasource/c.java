package com.facebook.datasource;

import com.facebook.common.internal.j;
/* loaded from: classes17.dex */
public class c {
    public static <T> b<T> z(Throwable th) {
        g dTp = g.dTp();
        dTp.x(th);
        return dTp;
    }

    public static <T> j<b<T>> A(final Throwable th) {
        return new j<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dTj */
            public b<T> get() {
                return c.z(th);
            }
        };
    }
}
