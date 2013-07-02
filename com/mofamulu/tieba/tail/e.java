package com.mofamulu.tieba.tail;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ FAQActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FAQActivity fAQActivity) {
        this.a = fAQActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c();
    }
}
