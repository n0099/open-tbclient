package com.mofamulu.tieba.sign;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnClickListener {
    final /* synthetic */ AccountAddActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AccountAddActivity accountAddActivity) {
        this.a = accountAddActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.d("您取消了账户的保存");
    }
}
