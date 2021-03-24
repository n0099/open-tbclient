package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final a f31612a;

    /* renamed from: b  reason: collision with root package name */
    public final RequestFinishedInfo f31613b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31614c;

    public c(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.f31612a = aVar;
        this.f31613b = requestFinishedInfo;
        this.f31614c = str;
    }

    public static Runnable a(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new c(aVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31612a.a(this.f31613b, this.f31614c);
    }
}
