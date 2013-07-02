package com.mofamulu.tieba.sign;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountListActivity accountListActivity;
        AccountListActivity accountListActivity2;
        AccountListActivity accountListActivity3;
        accountListActivity = this.a.a;
        if (accountListActivity.g != null) {
            accountListActivity2 = this.a.a;
            accountListActivity2.g.g();
            accountListActivity3 = this.a.a;
            accountListActivity3.d();
        }
    }
}
