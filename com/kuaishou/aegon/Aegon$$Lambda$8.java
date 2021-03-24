package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$8 implements Runnable {
    public static final Aegon$$Lambda$8 instance = new Aegon$$Lambda$8();

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.onBackground():void] */
    public static Runnable lambdaFactory$() {
        return instance;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeOnBackground();
    }
}
