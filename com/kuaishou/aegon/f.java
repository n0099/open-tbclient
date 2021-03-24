package com.kuaishou.aegon;
/* loaded from: classes6.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final SignalStrengthListener f31618a;

    public f(SignalStrengthListener signalStrengthListener) {
        this.f31618a = signalStrengthListener;
    }

    public static Runnable a(SignalStrengthListener signalStrengthListener) {
        return new f(signalStrengthListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31618a.nativeOnSignalStrengthChanged();
    }
}
