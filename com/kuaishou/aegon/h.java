package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes5.dex */
final /* synthetic */ class h implements Runnable {
    private final String c;
    private final f pQD;
    private final RequestFinishedInfo pQE;

    private h(f fVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.pQD = fVar;
        this.pQE = requestFinishedInfo;
        this.c = str;
    }

    public static Runnable b(f fVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new h(fVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pQD.a(this.pQE, this.c);
    }
}
