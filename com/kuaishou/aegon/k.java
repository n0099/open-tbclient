package com.kuaishou.aegon;
/* loaded from: classes4.dex */
final /* synthetic */ class k implements Runnable {
    private final SignalStrengthListener pNN;

    private k(SignalStrengthListener signalStrengthListener) {
        this.pNN = signalStrengthListener;
    }

    public static Runnable b(SignalStrengthListener signalStrengthListener) {
        return new k(signalStrengthListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pNN.nativeOnSignalStrengthChanged();
    }
}
