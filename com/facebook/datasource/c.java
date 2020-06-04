package com.facebook.datasource;

import com.facebook.common.internal.j;
/* loaded from: classes13.dex */
public class c {
    public static <T> b<T> B(Throwable th) {
        g dvo = g.dvo();
        dvo.z(th);
        return dvo;
    }

    public static <T> j<b<T>> C(final Throwable th) {
        return new j<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.j
            /* renamed from: dvi */
            public b<T> get() {
                return c.B(th);
            }
        };
    }
}
