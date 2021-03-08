package com.kuaishou.aegon;
/* loaded from: classes3.dex */
final /* synthetic */ class g implements Runnable {
    private final String b;
    private final f pZe;

    private g(f fVar, String str) {
        this.pZe = fVar;
        this.b = str;
    }

    public static Runnable b(f fVar, String str) {
        return new g(fVar, str);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pZe.a(this.b);
    }
}
