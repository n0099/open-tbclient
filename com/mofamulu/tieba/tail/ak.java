package com.mofamulu.tieba.tail;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class ak implements AdapterView.OnItemClickListener {
    final /* synthetic */ MoreTailActivity a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Dialog c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(MoreTailActivity moreTailActivity, String str, Dialog dialog) {
        this.a = moreTailActivity;
        this.b = str;
        this.c = dialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.v.b(this.b, i - 2);
        this.c.dismiss();
        this.a.c();
    }
}
