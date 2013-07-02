package com.mofamulu.tieba.sign;

import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ AccountDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AccountDetailActivity accountDetailActivity) {
        this.a = accountDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.a, AccountSelectBarsToSignActivity.class);
        intent.putExtra("userName", this.a.p);
        this.a.startActivity(intent);
    }
}
