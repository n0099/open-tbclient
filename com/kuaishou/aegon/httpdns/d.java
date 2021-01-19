package com.kuaishou.aegon.httpdns;
/* loaded from: classes4.dex */
final /* synthetic */ class d implements Runnable {
    private final ResolveFinishedInfo pNP;

    private d(ResolveFinishedInfo resolveFinishedInfo) {
        this.pNP = resolveFinishedInfo;
    }

    public static Runnable a(ResolveFinishedInfo resolveFinishedInfo) {
        return new d(resolveFinishedInfo);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.sLogger.onResolveFinish(this.pNP);
    }
}
