package com.mofamulu.tieba.ch;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {
    final /* synthetic */ MoreNickActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MoreNickActivity moreNickActivity) {
        this.a = moreNickActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://book.mofamulu.com/")));
    }
}
