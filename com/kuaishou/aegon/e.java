package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final SignalStrengthListener f31905a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31906b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31907c;

    public e(SignalStrengthListener signalStrengthListener, int i, int i2) {
        this.f31905a = signalStrengthListener;
        this.f31906b = i;
        this.f31907c = i2;
    }

    public static Runnable a(SignalStrengthListener signalStrengthListener, int i, int i2) {
        return new e(signalStrengthListener, i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31905a.nativeOnSignalStrengthValueUpdate(this.f31906b, this.f31907c);
    }
}
