package com.sdk.base.framework.b;

import com.sdk.base.framework.a.l;
/* loaded from: classes7.dex */
public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f39419a = 1000;

    public final int a() {
        int i2 = this.f39419a;
        if (i2 < 200) {
            return 200;
        }
        return i2;
    }

    public abstract void a(int i2, Object obj);

    public abstract void a(l<T> lVar);
}
