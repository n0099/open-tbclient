package com.kuaishou.aegon;
/* loaded from: classes5.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final String f8410b;
    private final f pQD;

    private g(f fVar, String str) {
        this.pQD = fVar;
        this.f8410b = str;
    }

    public static Runnable b(f fVar, String str) {
        return new g(fVar, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pQD.a(this.f8410b);
    }
}
