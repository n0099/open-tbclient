package com.sdk.base.framework.b;

import com.sdk.base.framework.a.k;
/* loaded from: classes14.dex */
public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f12807a = 1000;

    public final int a() {
        if (this.f12807a < 200) {
            return 200;
        }
        return this.f12807a;
    }

    public abstract void a(int i, Object obj);

    public abstract void a(k<T> kVar);
}
