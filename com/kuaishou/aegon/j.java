package com.kuaishou.aegon;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final int f8115b;
    private final int c;
    private final SignalStrengthListener pNO;

    private j(SignalStrengthListener signalStrengthListener, int i, int i2) {
        this.pNO = signalStrengthListener;
        this.f8115b = i;
        this.c = i2;
    }

    public static Runnable b(SignalStrengthListener signalStrengthListener, int i, int i2) {
        return new j(signalStrengthListener, i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pNO.nativeOnSignalStrengthValueUpdate(this.f8115b, this.c);
    }
}
