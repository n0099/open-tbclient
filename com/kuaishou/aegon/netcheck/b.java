package com.kuaishou.aegon.netcheck;
/* loaded from: classes6.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f32272a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32273b;

    public b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i2) {
        this.f32272a = netcheckTaskListenerWrapper;
        this.f32273b = i2;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i2) {
        return new b(netcheckTaskListenerWrapper, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32272a.f32263a.a(this.f32273b);
    }
}
