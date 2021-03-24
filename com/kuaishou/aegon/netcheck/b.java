package com.kuaishou.aegon.netcheck;
/* loaded from: classes6.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetcheckTaskListenerWrapper f31632a;

    /* renamed from: b  reason: collision with root package name */
    public final int f31633b;

    public b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        this.f31632a = netcheckTaskListenerWrapper;
        this.f31633b = i;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        return new b(netcheckTaskListenerWrapper, i);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f31632a.f31623a.a(this.f31633b);
    }
}
