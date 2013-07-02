package com.mofamulu.tieba.tail;

import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
class af implements View.OnClickListener {
    final /* synthetic */ MoreTailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(MoreTailActivity moreTailActivity) {
        this.a = moreTailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.a, TailListActivity.class);
        intent.putExtra("lzl", false);
        this.a.startActivityForResult(intent, 0);
    }
}
