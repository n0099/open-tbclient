package com.vivo.push.model;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f36645a;

    /* renamed from: d  reason: collision with root package name */
    public String f36648d;

    /* renamed from: b  reason: collision with root package name */
    public long f36646b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f36647c = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36649e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36650f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f36645a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.f36645a;
    }

    public final long b() {
        return this.f36646b;
    }

    public final boolean c() {
        return this.f36649e;
    }

    public final boolean d() {
        return this.f36650f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f36645a + ", mPushVersion=" + this.f36646b + ", mPackageVersion=" + this.f36647c + ", mInBlackList=" + this.f36649e + ", mPushEnable=" + this.f36650f + "}";
    }

    public final void a(long j) {
        this.f36646b = j;
    }

    public final void b(boolean z) {
        this.f36650f = z;
    }

    public final void a(boolean z) {
        this.f36649e = z;
    }

    public final void a(int i2) {
        this.f36647c = i2;
    }

    public final void a(String str) {
        this.f36648d = str;
    }
}
