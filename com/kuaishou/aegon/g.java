package com.kuaishou.aegon;
/* loaded from: classes3.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final String f8113b;
    private final f pXQ;

    private g(f fVar, String str) {
        this.pXQ = fVar;
        this.f8113b = str;
    }

    public static Runnable b(f fVar, String str) {
        return new g(fVar, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pXQ.a(this.f8113b);
    }
}
