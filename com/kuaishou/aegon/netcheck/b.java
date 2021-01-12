package com.kuaishou.aegon.netcheck;
/* loaded from: classes4.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final int f8119b;
    private final NetcheckTaskListenerWrapper pNQ;

    private b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        this.pNQ = netcheckTaskListenerWrapper;
        this.f8119b = i;
    }

    public static Runnable b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        return new b(netcheckTaskListenerWrapper, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pNQ.pNP.a(this.f8119b);
    }
}
