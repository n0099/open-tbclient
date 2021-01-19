package com.kuaishou.aegon;
/* loaded from: classes4.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final String f8111b;
    private final f pNM;

    private g(f fVar, String str) {
        this.pNM = fVar;
        this.f8111b = str;
    }

    public static Runnable b(f fVar, String str) {
        return new g(fVar, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pNM.a(this.f8111b);
    }
}
