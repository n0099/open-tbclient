package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final /* synthetic */ class e implements Runnable {
    private final boolean pQB;

    private e(boolean z) {
        this.pQB = z;
    }

    public static Runnable Bq(boolean z) {
        return new e(z);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetDebug(this.pQB);
    }
}
