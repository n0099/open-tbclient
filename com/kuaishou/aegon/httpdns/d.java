package com.kuaishou.aegon.httpdns;
/* loaded from: classes6.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final ResolveFinishedInfo f32164a;

    public d(ResolveFinishedInfo resolveFinishedInfo) {
        this.f32164a = resolveFinishedInfo;
    }

    public static Runnable a(ResolveFinishedInfo resolveFinishedInfo) {
        return new d(resolveFinishedInfo);
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDnsResolver.sLogger.onResolveFinish(this.f32164a);
    }
}
