package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final /* synthetic */ class d implements Runnable {
    private static final d pQA = new d();

    private d() {
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kuaishou.aegon.Aegon.a(android.content.Context, java.lang.String, java.lang.String, com.kuaishou.aegon.Aegon$a):void] */
    public static Runnable lambdaFactory$() {
        return pQA;
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.eDm();
    }
}
