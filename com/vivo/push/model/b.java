package com.vivo.push.model;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f36716a;

    /* renamed from: d  reason: collision with root package name */
    public String f36719d;

    /* renamed from: b  reason: collision with root package name */
    public long f36717b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f36718c = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36720e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36721f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f36716a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.f36716a;
    }

    public final long b() {
        return this.f36717b;
    }

    public final boolean c() {
        return this.f36720e;
    }

    public final boolean d() {
        return this.f36721f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f36716a + ", mPushVersion=" + this.f36717b + ", mPackageVersion=" + this.f36718c + ", mInBlackList=" + this.f36720e + ", mPushEnable=" + this.f36721f + "}";
    }

    public final void a(long j) {
        this.f36717b = j;
    }

    public final void b(boolean z) {
        this.f36721f = z;
    }

    public final void a(boolean z) {
        this.f36720e = z;
    }

    public final void a(int i2) {
        this.f36718c = i2;
    }

    public final void a(String str) {
        this.f36719d = str;
    }
}
