package com.kuaishou.aegon;
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    private static final c pXM = new c();

    private c() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.eCp():aegon.chrome.net.CronetEngine] */
    public static Runnable lambdaFactory$() {
        return pXM;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetInitialized(true);
    }
}
