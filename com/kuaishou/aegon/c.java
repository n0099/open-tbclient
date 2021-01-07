package com.kuaishou.aegon;
/* loaded from: classes5.dex */
public final /* synthetic */ class c implements Runnable {
    private static final c pSh = new c();

    private c() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.eDQ():aegon.chrome.net.CronetEngine] */
    public static Runnable lambdaFactory$() {
        return pSh;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetInitialized(true);
    }
}
