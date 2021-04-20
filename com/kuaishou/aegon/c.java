package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final a f31902a;

    /* renamed from: b  reason: collision with root package name */
    public final RequestFinishedInfo f31903b;

    /* renamed from: c  reason: collision with root package name */
    public final String f31904c;

    public c(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.f31902a = aVar;
        this.f31903b = requestFinishedInfo;
        this.f31904c = str;
    }

    public static Runnable a(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new c(aVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31902a.a(this.f31903b, this.f31904c);
    }
}
