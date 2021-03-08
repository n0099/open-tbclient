package com.kuaishou.aegon;
/* loaded from: classes3.dex */
final /* synthetic */ class k implements Runnable {
    private final SignalStrengthListener pZg;

    private k(SignalStrengthListener signalStrengthListener) {
        this.pZg = signalStrengthListener;
    }

    public static Runnable b(SignalStrengthListener signalStrengthListener) {
        return new k(signalStrengthListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pZg.nativeOnSignalStrengthChanged();
    }
}
