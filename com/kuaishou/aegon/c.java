package com.kuaishou.aegon;
/* loaded from: classes4.dex */
public final /* synthetic */ class c implements Runnable {
    private static final c pNH = new c();

    private c() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.ezY():aegon.chrome.net.CronetEngine] */
    public static Runnable lambdaFactory$() {
        return pNH;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetInitialized(true);
    }
}
