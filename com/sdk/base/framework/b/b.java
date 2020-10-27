package com.sdk.base.framework.b;

import com.sdk.base.framework.a.k;
/* loaded from: classes16.dex */
public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f4477a = 1000;

    public final int a() {
        if (this.f4477a < 200) {
            return 200;
        }
        return this.f4477a;
    }

    public abstract void a(int i, Object obj);

    public abstract void a(k<T> kVar);
}
