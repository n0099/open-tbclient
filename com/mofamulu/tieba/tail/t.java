package com.mofamulu.tieba.tail;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ MoreMapActivity a;
    private final /* synthetic */ Dialog b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MoreMapActivity moreMapActivity, Dialog dialog) {
        this.a = moreMapActivity;
        this.b = dialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.o.i(i);
        this.b.dismiss();
        this.a.c();
    }
}
