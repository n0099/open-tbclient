package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes4.dex */
final /* synthetic */ class h implements Runnable {
    private final String c;
    private final f pNL;
    private final RequestFinishedInfo pNM;

    private h(f fVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.pNL = fVar;
        this.pNM = requestFinishedInfo;
        this.c = str;
    }

    public static Runnable b(f fVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new h(fVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pNL.a(this.pNM, this.c);
    }
}
