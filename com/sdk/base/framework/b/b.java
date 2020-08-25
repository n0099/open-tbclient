package com.sdk.base.framework.b;

import com.sdk.base.framework.a.k;
/* loaded from: classes5.dex */
public abstract class b<T> {
    private int a = 1000;

    public final int a() {
        if (this.a < 200) {
            return 200;
        }
        return this.a;
    }

    public abstract void a(int i, Object obj);

    public abstract void a(k<T> kVar);
}
