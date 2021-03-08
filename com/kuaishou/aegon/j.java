package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Runnable {
    private final int b;
    private final int c;
    private final SignalStrengthListener pZg;

    private j(SignalStrengthListener signalStrengthListener, int i, int i2) {
        this.pZg = signalStrengthListener;
        this.b = i;
        this.c = i2;
    }

    public static Runnable b(SignalStrengthListener signalStrengthListener, int i, int i2) {
        return new j(signalStrengthListener, i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pZg.nativeOnSignalStrengthValueUpdate(this.b, this.c);
    }
}
