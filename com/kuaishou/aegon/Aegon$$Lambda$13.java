package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class Aegon$$Lambda$13 implements Runnable {
    public final long arg$1;
    public final boolean arg$2;

    public Aegon$$Lambda$13(long j, boolean z) {
        this.arg$1 = j;
        this.arg$2 = z;
    }

    public static Runnable lambdaFactory$(long j, boolean z) {
        return new Aegon$$Lambda$13(j, z);
    }

    @Override // java.lang.Runnable
    public void run() {
        Aegon.nativeSetLoggingCallback(this.arg$1, this.arg$2);
    }
}
