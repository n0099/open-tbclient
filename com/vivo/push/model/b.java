package com.vivo.push.model;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f40324a;

    /* renamed from: d  reason: collision with root package name */
    public String f40327d;

    /* renamed from: b  reason: collision with root package name */
    public long f40325b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f40326c = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40328e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40329f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f40324a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.f40324a;
    }

    public final long b() {
        return this.f40325b;
    }

    public final boolean c() {
        return this.f40328e;
    }

    public final boolean d() {
        return this.f40329f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f40324a + ", mPushVersion=" + this.f40325b + ", mPackageVersion=" + this.f40326c + ", mInBlackList=" + this.f40328e + ", mPushEnable=" + this.f40329f + "}";
    }

    public final void a(long j) {
        this.f40325b = j;
    }

    public final void b(boolean z) {
        this.f40329f = z;
    }

    public final void a(boolean z) {
        this.f40328e = z;
    }

    public final void a(int i2) {
        this.f40326c = i2;
    }

    public final void a(String str) {
        this.f40327d = str;
    }
}
