package com.mofamulu.tieba.sign;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ AccountAddActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountAddActivity accountAddActivity) {
        this.a = accountAddActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String editable = this.a.l.getText().toString();
        String editable2 = this.a.m.getText().toString();
        if (this.a.r == null) {
            this.a.r = new al();
        }
        this.a.r.a = editable;
        this.a.r.b = editable2;
        this.a.c((String) null);
    }
}
