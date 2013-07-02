package com.mofamulu.tieba.sign;

import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ MoreSignActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MoreSignActivity moreSignActivity) {
        this.a = moreSignActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.startActivityForResult(new Intent(this.a, MoreIgnoredTiebasActivity.class), 0);
    }
}
