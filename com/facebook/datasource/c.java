package com.facebook.datasource;

import com.facebook.common.internal.j;
/* loaded from: classes12.dex */
public class c {
    public static <T> b<T> A(Throwable th) {
        g dDh = g.dDh();
        dDh.y(th);
        return dDh;
    }

    public static <T> j<b<T>> B(final Throwable th) {
        return new j<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dDb */
            public b<T> get() {
                return c.A(th);
            }
        };
    }
}
