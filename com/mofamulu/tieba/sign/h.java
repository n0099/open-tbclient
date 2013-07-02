package com.mofamulu.tieba.sign;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnClickListener {
    final /* synthetic */ AccountAddActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AccountAddActivity accountAddActivity) {
        this.a = accountAddActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.c(((EditText) ((AlertDialog) dialogInterface).findViewById(R.id.vcode)).getText().toString());
    }
}
