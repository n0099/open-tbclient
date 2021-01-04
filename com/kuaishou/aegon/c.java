package com.kuaishou.aegon;
/* loaded from: classes5.dex */
public final /* synthetic */ class c implements Runnable {
    private static final c pQz = new c();

    private c() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.eDm():aegon.chrome.net.CronetEngine] */
    public static Runnable lambdaFactory$() {
        return pQz;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetInitialized(true);
    }
}
