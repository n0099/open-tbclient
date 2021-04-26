package com.vivo.push.model;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f37471a;

    /* renamed from: d  reason: collision with root package name */
    public String f37474d;

    /* renamed from: b  reason: collision with root package name */
    public long f37472b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f37473c = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37475e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37476f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f37471a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.f37471a;
    }

    public final long b() {
        return this.f37472b;
    }

    public final boolean c() {
        return this.f37475e;
    }

    public final boolean d() {
        return this.f37476f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f37471a + ", mPushVersion=" + this.f37472b + ", mPackageVersion=" + this.f37473c + ", mInBlackList=" + this.f37475e + ", mPushEnable=" + this.f37476f + "}";
    }

    public final void a(long j) {
        this.f37472b = j;
    }

    public final void b(boolean z) {
        this.f37476f = z;
    }

    public final void a(boolean z) {
        this.f37475e = z;
    }

    public final void a(int i2) {
        this.f37473c = i2;
    }

    public final void a(String str) {
        this.f37474d = str;
    }
}
