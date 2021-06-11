package com.kuaishou.aegon.netcheck;
/* loaded from: classes6.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f32174a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32175b;

    public b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i2) {
        this.f32174a = netcheckTaskListenerWrapper;
        this.f32175b = i2;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i2) {
        return new b(netcheckTaskListenerWrapper, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32174a.f32165a.a(this.f32175b);
    }
}
