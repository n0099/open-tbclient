package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$11 implements Runnable {
    public static final Aegon$$Lambda$11 instance = new Aegon$$Lambda$11();

    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.getCronetEngine():aegon.chrome.net.CronetEngine] */
    public static Runnable lambdaFactory$() {
        return instance;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetInitialized(true);
    }
}
