package com.kuaishou.aegon.netcheck;
/* loaded from: classes3.dex */
final /* synthetic */ class b implements Runnable {
    private final int b;
    private final NetcheckTaskListenerWrapper pZj;

    private b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        this.pZj = netcheckTaskListenerWrapper;
        this.b = i;
    }

    public static Runnable b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        return new b(netcheckTaskListenerWrapper, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pZj.pZi.a(this.b);
    }
}
