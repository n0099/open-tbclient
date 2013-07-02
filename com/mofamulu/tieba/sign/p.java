package com.mofamulu.tieba.sign;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ AccountListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(AccountListActivity accountListActivity) {
        this.a = accountListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a();
    }
}
