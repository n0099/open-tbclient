package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final a f32154a;

    /* renamed from: b  reason: collision with root package name */
    public final RequestFinishedInfo f32155b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32156c;

    public c(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.f32154a = aVar;
        this.f32155b = requestFinishedInfo;
        this.f32156c = str;
    }

    public static Runnable a(a aVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new c(aVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32154a.a(this.f32155b, this.f32156c);
    }
}
