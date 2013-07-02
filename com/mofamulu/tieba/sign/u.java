package com.mofamulu.tieba.sign;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ AccountListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(AccountListActivity accountListActivity) {
        this.a = accountListActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        Intent intent = new Intent(this.a, AccountAddActivity.class);
        intent.putExtra("userName", ((al) this.a.k.get(i)).a);
        this.a.startActivityForResult(intent, 1);
        return true;
    }
}
