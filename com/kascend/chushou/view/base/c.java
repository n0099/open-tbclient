package com.kascend.chushou.view.base;

import android.support.annotation.NonNull;
/* loaded from: classes4.dex */
public abstract class c<T> {
    protected final String a = getClass().getSimpleName();
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
