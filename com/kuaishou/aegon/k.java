package com.kuaishou.aegon;
/* loaded from: classes3.dex */
final /* synthetic */ class k implements Runnable {
    private final SignalStrengthListener pXS;

    private k(SignalStrengthListener signalStrengthListener) {
        this.pXS = signalStrengthListener;
    }

    public static Runnable b(SignalStrengthListener signalStrengthListener) {
        return new k(signalStrengthListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pXS.nativeOnSignalStrengthChanged();
    }
}
