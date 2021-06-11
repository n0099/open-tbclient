package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$16 implements Runnable {
    public final boolean arg$1;

    public Aegon$$Lambda$16(boolean z) {
        this.arg$1 = z;
    }

    public static Runnable lambdaFactory$(boolean z) {
        return new Aegon$$Lambda$16(z);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetAutonomousNetworkAccessAllowed(this.arg$1);
    }
}
