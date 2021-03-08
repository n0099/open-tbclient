package com.kuaishou.aegon.httpdns;
/* loaded from: classes3.dex */
final /* synthetic */ class d implements Runnable {
    private final ResolveFinishedInfo pZh;

    private d(ResolveFinishedInfo resolveFinishedInfo) {
        this.pZh = resolveFinishedInfo;
    }

    public static Runnable a(ResolveFinishedInfo resolveFinishedInfo) {
        return new d(resolveFinishedInfo);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.sLogger.onResolveFinish(this.pZh);
    }
}
