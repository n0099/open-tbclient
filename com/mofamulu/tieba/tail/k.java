package com.mofamulu.tieba.tail;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AdapterView.OnItemClickListener {
    final /* synthetic */ LovedBarListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LovedBarListActivity lovedBarListActivity) {
        this.a = lovedBarListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intent intent = new Intent(this.a, FrsActivity.class);
        intent.putExtra("name", ((com.mofamulu.tieba.sign.au) this.a.k.get(i)).b);
        this.a.startActivity(intent);
    }
}
