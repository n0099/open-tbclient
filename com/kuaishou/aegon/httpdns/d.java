package com.kuaishou.aegon.httpdns;
/* loaded from: classes5.dex */
final /* synthetic */ class d implements Runnable {
    private final ResolveFinishedInfo pQG;

    private d(ResolveFinishedInfo resolveFinishedInfo) {
        this.pQG = resolveFinishedInfo;
    }

    public static Runnable a(ResolveFinishedInfo resolveFinishedInfo) {
        return new d(resolveFinishedInfo);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.sLogger.onResolveFinish(this.pQG);
    }
}
