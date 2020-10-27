package com.kascend.chushou.view.base;

import android.support.annotation.NonNull;
/* loaded from: classes6.dex */
public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final String f4228a = getClass().getSimpleName();
    protected T b;

    public void a(@NonNull T t) {
        this.b = (T) tv.chushou.a.a.a.c.checkNotNull(t);
    }

    public void a() {
        this.b = null;
    }

    public boolean b() {
        return this.b != null;
    }
}
