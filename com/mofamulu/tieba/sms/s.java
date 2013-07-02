package com.mofamulu.tieba.sms;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class s implements AdapterView.OnItemClickListener {
    final /* synthetic */ SMSOutlineActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(SMSOutlineActivity sMSOutlineActivity) {
        this.a = sMSOutlineActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.a.l.b.size() > i) {
            f fVar = (f) this.a.l.b.get(i);
            fVar.j = 0;
            this.a.m();
            SMSChatActivity.j = fVar;
            SMSChatActivity.g = this.a.l.b();
            Intent intent = new Intent(this.a, SMSChatActivity.class);
            intent.putExtra("msgBdsToken", this.a.l.c());
            this.a.startActivity(intent);
        }
    }
}
