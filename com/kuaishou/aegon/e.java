package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final /* synthetic */ class e implements Runnable {
    private final boolean pNK;

    private e(boolean z) {
        this.pNK = z;
    }

    public static Runnable Bm(boolean z) {
        return new e(z);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetDebug(this.pNK);
    }
}
