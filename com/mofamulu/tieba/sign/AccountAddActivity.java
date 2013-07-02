package com.mofamulu.tieba.sign;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AccountAddActivity extends a {
    protected TextView j;
    protected TextView k;
    protected EditText l;
    protected EditText m;
    protected ProgressBar n;
    protected TextView o;
    protected TextView p;
    protected Button q;
    protected al r;
    protected boolean s;
    Handler t = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a, com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.tbhp_add_sign_activity);
        c();
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        this.s = false;
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a, com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        this.s = true;
        super.onResume();
    }

    protected void c() {
        this.j = (TextView) findViewById(R.id.text_error);
        this.k = (TextView) findViewById(R.id.text_info);
        this.p = (TextView) findViewById(R.id.sign_nav2amx);
        this.l = (EditText) findViewById(R.id.login_edit_account);
        this.m = (EditText) findViewById(R.id.login_edit_password);
        this.n = (ProgressBar) findViewById(R.id.progress_login);
        this.o = (TextView) findViewById(R.id.text_login);
        this.q = (Button) findViewById(R.id.delete);
        this.q.setOnClickListener(new f(this));
        this.o.setOnClickListener(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        this.n.setVisibility(0);
        this.g.a(this, this.r, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a
    public void b() {
        String string;
        Message message = new Message();
        message.what = 1;
        if (getIntent() != null && getIntent().getExtras() != null && (string = getIntent().getExtras().getString("userName")) != null) {
            message.obj = this.g.b(string);
        }
        this.t.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        this.j.setText(str);
        this.j.setVisibility(0);
        this.n.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bitmap bitmap) {
        if (this.s) {
            View inflate = getLayoutInflater().inflate(R.layout.tbhp_vcode_dialog, (ViewGroup) null);
            ((ImageView) inflate.findViewById(R.id.vcode_image)).setImageBitmap(bitmap);
            new AlertDialog.Builder(this).setTitle("请输入验证码").setView(inflate).setPositiveButton("确定", new h(this)).setNegativeButton("取消", new i(this)).show();
        }
    }
}
