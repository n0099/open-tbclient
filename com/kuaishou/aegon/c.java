package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final a f31997a;

    /* renamed from: b  reason: collision with root package name */
    public final RequestFinishedInfo f31998b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31999c;

    public c(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.f31997a = aVar;
        this.f31998b = requestFinishedInfo;
        this.f31999c = str;
    }

    public static Runnable a(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new c(aVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31997a.a(this.f31998b, this.f31999c);
    }
}
