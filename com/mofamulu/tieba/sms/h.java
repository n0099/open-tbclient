package com.mofamulu.tieba.sms;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ g a;
    private final /* synthetic */ i b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, i iVar, int i) {
        this.a = gVar;
        this.b = iVar;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.b, this.c);
    }
}
