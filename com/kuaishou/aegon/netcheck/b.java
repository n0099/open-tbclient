package com.kuaishou.aegon.netcheck;
/* loaded from: classes5.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final int f8419b;
    private final NetcheckTaskListenerWrapper pSq;

    private b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        this.pSq = netcheckTaskListenerWrapper;
        this.f8419b = i;
    }

    public static Runnable b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        return new b(netcheckTaskListenerWrapper, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pSq.pSp.a(this.f8419b);
    }
}
