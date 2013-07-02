package com.mofamulu.tieba.ch;

import android.app.AlertDialog;
import android.view.View;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonInfoActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnLongClickListener {
    private final /* synthetic */ PersonInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonInfoActivity personInfoActivity) {
        this.a = personInfoActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        String[] strArr = {this.a.getString(R.string.person_modify_logo), this.a.getString(R.string.person_open_vip), this.a.getString(R.string.other_faq_settings)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setTitle(this.a.getString(R.string.operation));
        builder.setItems(strArr, new h(this, this.a));
        builder.create().show();
        return true;
    }
}
