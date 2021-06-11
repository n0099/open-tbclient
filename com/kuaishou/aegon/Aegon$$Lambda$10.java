package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$10 implements Runnable {
    public static final Aegon$$Lambda$10 instance = new Aegon$$Lambda$10();

    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.getCronetEngine():aegon.chrome.net.CronetEngine] */
    public static Runnable lambdaFactory$() {
        return instance;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.sSignalStrengthListener = new SignalStrengthListener(Aegon.sApplicationContext);
    }
}
