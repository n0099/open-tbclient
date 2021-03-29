package com.vivo.push.model;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f39484a;

    /* renamed from: d  reason: collision with root package name */
    public String f39487d;

    /* renamed from: b  reason: collision with root package name */
    public long f39485b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f39486c = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39488e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39489f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f39484a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.f39484a;
    }

    public final long b() {
        return this.f39485b;
    }

    public final boolean c() {
        return this.f39488e;
    }

    public final boolean d() {
        return this.f39489f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f39484a + ", mPushVersion=" + this.f39485b + ", mPackageVersion=" + this.f39486c + ", mInBlackList=" + this.f39488e + ", mPushEnable=" + this.f39489f + "}";
    }

    public final void a(long j) {
        this.f39485b = j;
    }

    public final void b(boolean z) {
        this.f39489f = z;
    }

    public final void a(boolean z) {
        this.f39488e = z;
    }

    public final void a(int i) {
        this.f39486c = i;
    }

    public final void a(String str) {
        this.f39487d = str;
    }
}
