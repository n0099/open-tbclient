package com.mofamulu.tieba.tail;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements AdapterView.OnItemClickListener {
    final /* synthetic */ TailListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(TailListActivity tailListActivity) {
        this.a = tailListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.b(i);
    }
}
