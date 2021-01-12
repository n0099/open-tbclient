package com.vivo.push.model;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f13657a;
    private String d;

    /* renamed from: b  reason: collision with root package name */
    private long f13658b = -1;
    private int c = -1;
    private boolean e = false;
    private boolean f = false;

    public b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
        }
        this.f13657a = str;
    }

    public final String a() {
        return this.f13657a;
    }

    public final long b() {
        return this.f13658b;
    }

    public final void a(long j) {
        this.f13658b = j;
    }

    public final boolean c() {
        return this.e;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final boolean d() {
        return this.f;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f13657a + ", mPushVersion=" + this.f13658b + ", mPackageVersion=" + this.c + ", mInBlackList=" + this.e + ", mPushEnable=" + this.f + "}";
    }
}
