package com.kuaishou.aegon.netcheck;
/* loaded from: classes6.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f32017a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32018b;

    public b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        this.f32017a = netcheckTaskListenerWrapper;
        this.f32018b = i;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        return new b(netcheckTaskListenerWrapper, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f32017a.f32008a.a(this.f32018b);
    }
}
