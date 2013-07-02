package com.mofamulu.tieba.tail;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class aa implements AdapterView.OnItemClickListener {
    final /* synthetic */ MoreOthersActivity a;
    private final /* synthetic */ Dialog b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MoreOthersActivity moreOthersActivity, Dialog dialog) {
        this.a = moreOthersActivity;
        this.b = dialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.y.e(i);
        this.b.dismiss();
        this.a.c();
    }
}
