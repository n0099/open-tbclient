package com.mofamulu.tieba.tail;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ TailListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(TailListActivity tailListActivity) {
        this.a = tailListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.b(-1);
    }
}
