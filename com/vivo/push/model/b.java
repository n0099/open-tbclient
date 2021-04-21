package com.vivo.push.model;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f39868a;

    /* renamed from: d  reason: collision with root package name */
    public String f39871d;

    /* renamed from: b  reason: collision with root package name */
    public long f39869b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f39870c = -1;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39872e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39873f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f39868a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.f39868a;
    }

    public final long b() {
        return this.f39869b;
    }

    public final boolean c() {
        return this.f39872e;
    }

    public final boolean d() {
        return this.f39873f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f39868a + ", mPushVersion=" + this.f39869b + ", mPackageVersion=" + this.f39870c + ", mInBlackList=" + this.f39872e + ", mPushEnable=" + this.f39873f + "}";
    }

    public final void a(long j) {
        this.f39869b = j;
    }

    public final void b(boolean z) {
        this.f39873f = z;
    }

    public final void a(boolean z) {
        this.f39872e = z;
    }

    public final void a(int i) {
        this.f39870c = i;
    }

    public final void a(String str) {
        this.f39871d = str;
    }
}
