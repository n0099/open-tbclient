package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    private final boolean pYo;

    private e(boolean z) {
        this.pYo = z;
    }

    public static Runnable BF(boolean z) {
        return new e(z);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetDebug(this.pYo);
    }
}
