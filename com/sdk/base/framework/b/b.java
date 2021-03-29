package com.sdk.base.framework.b;

import com.sdk.base.framework.a.l;
/* loaded from: classes6.dex */
public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f38500a = 1000;

    public final int a() {
        int i = this.f38500a;
        if (i < 200) {
            return 200;
        }
        return i;
    }

    public abstract void a(int i, Object obj);

    public abstract void a(l<T> lVar);
}
