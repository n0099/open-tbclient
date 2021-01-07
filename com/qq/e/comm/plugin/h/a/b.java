package com.qq.e.comm.plugin.h.a;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class b implements com.qq.e.comm.plugin.h.a {

    /* renamed from: a  reason: collision with root package name */
    protected volatile String f12377a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f12378b = false;

    protected boolean a() {
        return true;
    }

    @Override // com.qq.e.comm.plugin.h.a
    public String b(Context context) {
        if (a()) {
            if (this.f12378b) {
                return this.f12377a;
            }
            this.f12377a = c(context);
            this.f12378b = true;
            return this.f12377a;
        }
        return null;
    }

    protected abstract String c(Context context);
}
