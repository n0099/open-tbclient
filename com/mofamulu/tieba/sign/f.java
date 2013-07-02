package com.mofamulu.tieba.sign;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ AccountAddActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountAddActivity accountAddActivity) {
        this.a = accountAddActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.r != null) {
            this.a.g.d(this.a.r.a);
        }
        this.a.setResult(0, null);
        this.a.finish();
    }
}
