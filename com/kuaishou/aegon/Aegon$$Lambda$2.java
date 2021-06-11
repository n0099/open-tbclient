package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$2 implements Runnable {
    public static final Aegon$$Lambda$2 instance = new Aegon$$Lambda$2();

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.initialize(android.content.Context, java.lang.String, java.lang.String, com.kuaishou.aegon.Aegon$LibraryLoader):void] */
    public static Runnable lambdaFactory$() {
        return instance;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.getCronetEngine();
    }
}
