package com.mofamulu.tieba.tail;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ LovedBarListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LovedBarListActivity lovedBarListActivity) {
        this.a = lovedBarListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.d();
    }
}
