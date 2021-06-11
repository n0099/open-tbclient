package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final SignalStrengthListener f32157a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32158b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32159c;

    public e(SignalStrengthListener signalStrengthListener, int i2, int i3) {
        this.f32157a = signalStrengthListener;
        this.f32158b = i2;
        this.f32159c = i3;
    }

    public static Runnable a(SignalStrengthListener signalStrengthListener, int i2, int i3) {
        return new e(signalStrengthListener, i2, i3);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32157a.nativeOnSignalStrengthValueUpdate(this.f32158b, this.f32159c);
    }
}
