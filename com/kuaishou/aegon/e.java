package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final SignalStrengthListener f32000a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32001b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32002c;

    public e(SignalStrengthListener signalStrengthListener, int i, int i2) {
        this.f32000a = signalStrengthListener;
        this.f32001b = i;
        this.f32002c = i2;
    }

    public static Runnable a(SignalStrengthListener signalStrengthListener, int i, int i2) {
        return new e(signalStrengthListener, i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32000a.nativeOnSignalStrengthValueUpdate(this.f32001b, this.f32002c);
    }
}
