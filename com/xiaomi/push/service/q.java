package com.xiaomi.push.service;

import android.accounts.Account;
/* loaded from: classes3.dex */
class q implements Runnable {
    final /* synthetic */ Account[] a;
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, Account[] accountArr) {
        this.b = pVar;
        this.a = accountArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a.a(this.a);
    }
}
