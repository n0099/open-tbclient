package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes3.dex */
final /* synthetic */ class h implements Runnable {
    private final String c;
    private final f pXQ;
    private final RequestFinishedInfo pXR;

    private h(f fVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.pXQ = fVar;
        this.pXR = requestFinishedInfo;
        this.c = str;
    }

    public static Runnable b(f fVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new h(fVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pXQ.a(this.pXR, this.c);
    }
}
