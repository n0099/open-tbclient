package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final a f32252a;

    /* renamed from: b  reason: collision with root package name */
    public final RequestFinishedInfo f32253b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32254c;

    public c(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.f32252a = aVar;
        this.f32253b = requestFinishedInfo;
        this.f32254c = str;
    }

    public static Runnable a(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new c(aVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32252a.a(this.f32253b, this.f32254c);
    }
}
