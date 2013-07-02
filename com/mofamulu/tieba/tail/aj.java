package com.mofamulu.tieba.tail;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class aj implements AdapterView.OnItemClickListener {
    final /* synthetic */ MoreTailActivity a;
    private final /* synthetic */ Dialog b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MoreTailActivity moreTailActivity, Dialog dialog) {
        this.a = moreTailActivity;
        this.b = dialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.v.d(i);
        this.b.dismiss();
        this.a.c();
    }
}
