package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final int f8117b;
    private final int c;
    private final SignalStrengthListener pYs;

    private j(SignalStrengthListener signalStrengthListener, int i, int i2) {
        this.pYs = signalStrengthListener;
        this.f8117b = i;
        this.c = i2;
    }

    public static Runnable b(SignalStrengthListener signalStrengthListener, int i, int i2) {
        return new j(signalStrengthListener, i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pYs.nativeOnSignalStrengthValueUpdate(this.f8117b, this.c);
    }
}
