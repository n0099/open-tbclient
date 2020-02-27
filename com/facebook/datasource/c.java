package com.facebook.datasource;

import com.facebook.common.internal.j;
/* loaded from: classes13.dex */
public class c {
    public static <T> b<T> x(Throwable th) {
        g dlp = g.dlp();
        dlp.u(th);
        return dlp;
    }

    public static <T> j<b<T>> y(final Throwable th) {
        return new j<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dlj */
            public b<T> get() {
                return c.x(th);
            }
        };
    }
}
