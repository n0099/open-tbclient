package com.qq.e.comm.plugin.h.a;

import android.content.Context;
/* loaded from: classes15.dex */
public abstract class b implements com.qq.e.comm.plugin.h.a {

    /* renamed from: a  reason: collision with root package name */
    protected volatile String f12079a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f12080b = false;

    protected boolean a() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.h.a
    public String b(Context context) {
        if (a()) {
            if (this.f12080b) {
                return this.f12079a;
            }
            this.f12079a = c(context);
            this.f12080b = true;
            return this.f12079a;
        }
        return null;
    }

    protected abstract String c(Context context);
}
