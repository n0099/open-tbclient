package com.kuaishou.aegon.httpdns;
/* loaded from: classes6.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final ResolveFinishedInfo f31912a;

    public d(ResolveFinishedInfo resolveFinishedInfo) {
        this.f31912a = resolveFinishedInfo;
    }

    public static Runnable a(ResolveFinishedInfo resolveFinishedInfo) {
        return new d(resolveFinishedInfo);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.sLogger.onResolveFinish(this.f31912a);
    }
}
