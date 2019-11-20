package com.facebook.datasource;

import com.facebook.common.internal.i;
/* loaded from: classes2.dex */
public class c {
    public static <T> b<T> v(Throwable th) {
        g cDu = g.cDu();
        cDu.t(th);
        return cDu;
    }

    public static <T> i<b<T>> x(final Throwable th) {
        return new i<b<T>>() { // from class: com.facebook.datasource.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.internal.i
            /* renamed from: cDq */
            public b<T> get() {
                return c.v(th);
            }
        };
    }
}
