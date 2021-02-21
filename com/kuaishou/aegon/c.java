package com.kuaishou.aegon;
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    private static final c pYm = new c();

    private c() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.eCx():aegon.chrome.net.CronetEngine] */
    public static Runnable lambdaFactory$() {
        return pYm;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetInitialized(true);
    }
}
