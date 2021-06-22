package com.vivo.push.model;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f40427a;

    /* renamed from: d  reason: collision with root package name */
    public String f40430d;

    /* renamed from: b  reason: collision with root package name */
    public long f40428b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f40429c = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40431e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40432f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f40427a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.f40427a;
    }

    public final long b() {
        return this.f40428b;
    }

    public final boolean c() {
        return this.f40431e;
    }

    public final boolean d() {
        return this.f40432f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f40427a + ", mPushVersion=" + this.f40428b + ", mPackageVersion=" + this.f40429c + ", mInBlackList=" + this.f40431e + ", mPushEnable=" + this.f40432f + "}";
    }

    public final void a(long j) {
        this.f40428b = j;
    }

    public final void b(boolean z) {
        this.f40432f = z;
    }

    public final void a(boolean z) {
        this.f40431e = z;
    }

    public final void a(int i2) {
        this.f40429c = i2;
    }

    public final void a(String str) {
        this.f40430d = str;
    }
}
