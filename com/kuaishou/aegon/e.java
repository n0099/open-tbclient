package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final SignalStrengthListener f32255a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32256b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32257c;

    public e(SignalStrengthListener signalStrengthListener, int i2, int i3) {
        this.f32255a = signalStrengthListener;
        this.f32256b = i2;
        this.f32257c = i3;
    }

    public static Runnable a(SignalStrengthListener signalStrengthListener, int i2, int i3) {
        return new e(signalStrengthListener, i2, i3);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32255a.nativeOnSignalStrengthValueUpdate(this.f32256b, this.f32257c);
    }
}
