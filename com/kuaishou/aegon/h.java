package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes3.dex */
final /* synthetic */ class h implements Runnable {
    private final String c;
    private final f pYq;
    private final RequestFinishedInfo pYr;

    private h(f fVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.pYq = fVar;
        this.pYr = requestFinishedInfo;
        this.c = str;
    }

    public static Runnable b(f fVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new h(fVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pYq.a(this.pYr, this.c);
    }
}
