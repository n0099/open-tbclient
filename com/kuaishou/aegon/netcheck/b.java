package com.kuaishou.aegon.netcheck;
/* loaded from: classes5.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final int f8418b;
    private final NetcheckTaskListenerWrapper pQI;

    private b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        this.pQI = netcheckTaskListenerWrapper;
        this.f8418b = i;
    }

    public static Runnable b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        return new b(netcheckTaskListenerWrapper, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pQI.pQH.a(this.f8418b);
    }
}
