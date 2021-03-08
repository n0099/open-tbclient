package com.kuaishou.aegon;

import aegon.chrome.net.RequestFinishedInfo;
/* loaded from: classes3.dex */
final /* synthetic */ class h implements Runnable {
    private final String c;
    private final f pZe;
    private final RequestFinishedInfo pZf;

    private h(f fVar, RequestFinishedInfo requestFinishedInfo, String str) {
        this.pZe = fVar;
        this.pZf = requestFinishedInfo;
        this.c = str;
    }

    public static Runnable b(f fVar, RequestFinishedInfo requestFinishedInfo, String str) {
        return new h(fVar, requestFinishedInfo, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pZe.a(this.pZf, this.c);
    }
}
