package com.mofamulu.tieba.sign;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ AccountListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(AccountListActivity accountListActivity) {
        this.a = accountListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intent intent = new Intent(this.a, AccountDetailActivity.class);
        intent.putExtra("userName", ((al) this.a.k.get(i)).a);
        this.a.startActivity(intent);
    }
}
