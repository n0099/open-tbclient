package com.kuaishou.aegon;
/* loaded from: classes5.dex */
final /* synthetic */ class k implements Runnable {
    private final SignalStrengthListener pSn;

    private k(SignalStrengthListener signalStrengthListener) {
        this.pSn = signalStrengthListener;
    }

    public static Runnable b(SignalStrengthListener signalStrengthListener) {
        return new k(signalStrengthListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pSn.nativeOnSignalStrengthChanged();
    }
}
