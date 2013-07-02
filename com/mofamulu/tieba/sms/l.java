package com.mofamulu.tieba.sms;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.mofamulu.tieba.ch.bf;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ SMSChatActivity a;
    private final /* synthetic */ EditText b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SMSChatActivity sMSChatActivity, EditText editText) {
        this.a = sMSChatActivity;
        this.b = editText;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String editable = this.b.getText().toString();
        if (bf.a(editable)) {
            Toast.makeText(this.a, "说点什么吧～", 0).show();
            return;
        }
        this.a.l.setVisibility(0);
        this.a.m.a(this.a.q, this.a.n, this.a.p, editable);
    }
}
