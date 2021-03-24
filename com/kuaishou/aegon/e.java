package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final SignalStrengthListener f31615a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31616b;

    /* renamed from: c  reason: collision with root package name */
    public final int f31617c;

    public e(SignalStrengthListener signalStrengthListener, int i, int i2) {
        this.f31615a = signalStrengthListener;
        this.f31616b = i;
        this.f31617c = i2;
    }

    public static Runnable a(SignalStrengthListener signalStrengthListener, int i, int i2) {
        return new e(signalStrengthListener, i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31615a.nativeOnSignalStrengthValueUpdate(this.f31616b, this.f31617c);
    }
}
