package com.mofamulu.tieba.tail;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ MoreEmotionsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MoreEmotionsActivity moreEmotionsActivity) {
        this.a = moreEmotionsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://code.google.com/p/tieba-helper/wiki/AndroidEmotions")));
    }
}
