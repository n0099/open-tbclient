package com.mofamulu.tieba.sign;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountDetailActivity accountDetailActivity;
        AccountDetailActivity accountDetailActivity2;
        accountDetailActivity = this.a.a;
        SignServiceBinder signServiceBinder = accountDetailActivity.g;
        accountDetailActivity2 = this.a.a;
        signServiceBinder.e(accountDetailActivity2.p);
    }
}
