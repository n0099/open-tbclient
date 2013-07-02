package com.mofamulu.tieba.sign;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ AccountListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(AccountListActivity accountListActivity) {
        this.a = accountListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.g != null) {
            this.a.m = true;
            if (this.a.g.c()) {
                this.a.j.setText("签到停止中");
                this.a.j.setEnabled(false);
                this.a.g.a((Activity) this.a);
                this.a.d();
                return;
            }
            this.a.j.setText("签到系统加载中");
            this.a.j.setEnabled(false);
            com.mofamulu.tieba.ch.a.a(new s(this));
            if (this.a.k != null && this.a.k.isEmpty()) {
                Toast.makeText(this.a, (int) R.string.sign_empty_list_tips, 1).show();
            }
        }
    }
}
