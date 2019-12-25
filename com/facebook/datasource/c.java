package com.facebook.datasource;

import com.facebook.common.internal.j;
/* loaded from: classes11.dex */
public class c {
    public static <T> b<T> y(Throwable th) {
        g diZ = g.diZ();
        diZ.v(th);
        return diZ;
    }

    public static <T> j<b<T>> z(final Throwable th) {
        return new j<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: diT */
            public b<T> get() {
                return c.y(th);
            }
        };
    }
}
