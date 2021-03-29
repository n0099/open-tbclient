package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final a f31613a;

    /* renamed from: b  reason: collision with root package name */
    public final RequestFinishedInfo f31614b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31615c;

    public c(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.f31613a = aVar;
        this.f31614b = requestFinishedInfo;
        this.f31615c = str;
    }

    public static Runnable a(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new c(aVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31613a.a(this.f31614b, this.f31615c);
    }
}
