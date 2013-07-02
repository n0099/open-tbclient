package com.mofamulu.tieba.sign;

import android.content.Intent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ AccountListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AccountListActivity accountListActivity) {
        this.a = accountListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.startActivityForResult(new Intent(this.a, AccountAddActivity.class), 0);
    }
}
