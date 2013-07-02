package com.mofamulu.tieba.sms;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b a;
    private final /* synthetic */ e b;
    private final /* synthetic */ f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, e eVar, f fVar) {
        this.a = bVar;
        this.b = eVar;
        this.c = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.b(this.b, this.c);
    }
}
