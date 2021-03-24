package com.vivo.push.model;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f39483a;

    /* renamed from: d  reason: collision with root package name */
    public String f39486d;

    /* renamed from: b  reason: collision with root package name */
    public long f39484b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f39485c = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39487e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39488f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f39483a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.f39483a;
    }

    public final long b() {
        return this.f39484b;
    }

    public final boolean c() {
        return this.f39487e;
    }

    public final boolean d() {
        return this.f39488f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f39483a + ", mPushVersion=" + this.f39484b + ", mPackageVersion=" + this.f39485c + ", mInBlackList=" + this.f39487e + ", mPushEnable=" + this.f39488f + "}";
    }

    public final void a(long j) {
        this.f39484b = j;
    }

    public final void b(boolean z) {
        this.f39488f = z;
    }

    public final void a(boolean z) {
        this.f39487e = z;
    }

    public final void a(int i) {
        this.f39485c = i;
    }

    public final void a(String str) {
        this.f39486d = str;
    }
}
