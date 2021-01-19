package com.kuaishou.aegon;
/* loaded from: classes4.dex */
final /* synthetic */ class k implements Runnable {
    private final SignalStrengthListener pNO;

    private k(SignalStrengthListener signalStrengthListener) {
        this.pNO = signalStrengthListener;
    }

    public static Runnable b(SignalStrengthListener signalStrengthListener) {
        return new k(signalStrengthListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pNO.nativeOnSignalStrengthChanged();
    }
}
