package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    private final boolean pZc;

    private e(boolean z) {
        this.pZc = z;
    }

    public static Runnable BD(boolean z) {
        return new e(z);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetDebug(this.pZc);
    }
}
