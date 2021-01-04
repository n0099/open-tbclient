package com.qq.e.comm.plugin.h.a;

import android.content.Context;
/* loaded from: classes3.dex */
public abstract class b implements com.qq.e.comm.plugin.h.a {

    /* renamed from: a  reason: collision with root package name */
    protected volatile String f12376a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f12377b = false;

    protected boolean a() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.h.a
    public String b(Context context) {
        if (a()) {
            if (this.f12377b) {
                return this.f12376a;
            }
            this.f12376a = c(context);
            this.f12377b = true;
            return this.f12376a;
        }
        return null;
    }

    protected abstract String c(Context context);
}
