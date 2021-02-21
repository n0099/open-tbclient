package com.kuaishou.aegon;
/* loaded from: classes3.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final String f8113b;
    private final f pYq;

    private g(f fVar, String str) {
        this.pYq = fVar;
        this.f8113b = str;
    }

    public static Runnable b(f fVar, String str) {
        return new g(fVar, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pYq.a(this.f8113b);
    }
}
