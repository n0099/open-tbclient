package com.kuaishou.aegon.netcheck;
/* loaded from: classes3.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final int f8121b;
    private final NetcheckTaskListenerWrapper pYv;

    private b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        this.pYv = netcheckTaskListenerWrapper;
        this.f8121b = i;
    }

    public static Runnable b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        return new b(netcheckTaskListenerWrapper, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pYv.pYu.a(this.f8121b);
    }
}
