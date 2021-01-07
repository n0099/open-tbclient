package com.kuaishou.aegon;
/* loaded from: classes5.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private final String f8411b;
    private final f pSl;

    private g(f fVar, String str) {
        this.pSl = fVar;
        this.f8411b = str;
    }

    public static Runnable b(f fVar, String str) {
        return new g(fVar, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pSl.a(this.f8411b);
    }
}
