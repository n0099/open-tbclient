package com.kuaishou.aegon;
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    private static final c pZa = new c();

    private c() {
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.eCD():aegon.chrome.net.CronetEngine] */
    public static Runnable lambdaFactory$() {
        return pZa;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetInitialized(true);
    }
}
