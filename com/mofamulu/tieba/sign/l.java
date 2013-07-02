package com.mofamulu.tieba.sign;

import android.view.View;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ AccountDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AccountDetailActivity accountDetailActivity) {
        this.a = accountDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.n.setEnabled(false);
        this.a.n.setText("签到中……");
        com.mofamulu.tieba.ch.a.a(new m(this));
    }
}
