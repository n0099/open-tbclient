package com.mofamulu.tieba.sign;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.a.a;
        aVar.b();
    }
}
