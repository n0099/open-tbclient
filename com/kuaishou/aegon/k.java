package com.kuaishou.aegon;
/* loaded from: classes3.dex */
final /* synthetic */ class k implements Runnable {
    private final SignalStrengthListener pYs;

    private k(SignalStrengthListener signalStrengthListener) {
        this.pYs = signalStrengthListener;
    }

    public static Runnable b(SignalStrengthListener signalStrengthListener) {
        return new k(signalStrengthListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pYs.nativeOnSignalStrengthChanged();
    }
}
