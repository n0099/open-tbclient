package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final int f8414b;
    private final int c;
    private final SignalStrengthListener pQF;

    private j(SignalStrengthListener signalStrengthListener, int i, int i2) {
        this.pQF = signalStrengthListener;
        this.f8414b = i;
        this.c = i2;
    }

    public static Runnable b(SignalStrengthListener signalStrengthListener, int i, int i2) {
        return new j(signalStrengthListener, i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pQF.nativeOnSignalStrengthValueUpdate(this.f8414b, this.c);
    }
}
