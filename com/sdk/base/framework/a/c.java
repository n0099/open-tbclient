package com.sdk.base.framework.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private long f13071a;

    /* renamed from: b  reason: collision with root package name */
    private long f13072b = System.currentTimeMillis();

    public c(a aVar, long j) {
        this.f13071a = 1500L;
        this.f13071a = 2000L;
    }

    public final boolean a() {
        return System.currentTimeMillis() - this.f13072b > this.f13071a;
    }
}
