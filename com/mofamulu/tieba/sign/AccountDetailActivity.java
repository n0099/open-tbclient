package com.mofamulu.tieba.sign;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AccountDetailActivity extends a implements am {
    protected TextView j;
    protected TextView k;
    protected TextView l;
    protected TextView m;
    protected Button n;
    protected Button o;
    protected String p;
    protected volatile boolean q = false;
    Handler r = new j(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a, com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.tbhp_sign_detail_activity);
        c();
        m();
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        if (this.g != null) {
            this.g.b(this);
        }
        this.q = false;
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a, com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        if (this.g != null) {
            d();
        }
        super.onResume();
    }

    protected void c() {
        this.j = (TextView) findViewById(R.id.sign_account);
        this.k = (TextView) findViewById(R.id.sign_status);
        this.l = (TextView) findViewById(R.id.sign_last_success_time);
        this.m = (TextView) findViewById(R.id.sign_detail);
        this.n = (Button) findViewById(R.id.sign_start);
        this.o = (Button) findViewById(R.id.sign_chose_tbs);
    }

    private void m() {
        this.o.setOnClickListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(al alVar) {
        this.j.setText(alVar.a);
        this.k.setText(alVar.i());
        int c = al.c();
        int i = alVar.g;
        if (c == i) {
            this.l.setText("今天");
        } else if (i == 0) {
            this.l.setText("尚未签完过");
        } else {
            this.l.setText(String.valueOf(i));
        }
        if (alVar.i == null) {
            this.m.setText("尚未完整签完过");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (as asVar : alVar.i) {
            sb.append(asVar.b).append(" - ");
            if (asVar.c == 0) {
                sb.append("等待中");
            } else if (asVar.c == 2) {
                sb.append("不支持签到");
            } else {
                sb.append(asVar.d);
            }
            sb.append("\n");
        }
        this.m.setText(sb.toString());
    }

    public void d(al alVar) {
        if (alVar != null && alVar.a.equals(this.p)) {
            Message message = new Message();
            message.what = 1;
            message.obj = alVar;
            this.r.sendMessage(message);
        }
    }

    @Override // com.mofamulu.tieba.sign.am
    public void a(al alVar) {
        d(alVar);
    }

    @Override // com.mofamulu.tieba.sign.am
    public void b(al alVar) {
        d(alVar);
    }

    @Override // com.mofamulu.tieba.sign.am
    public void a() {
    }

    protected void d() {
        this.p = getIntent().getExtras().getString("userName");
        al b = this.g.b(this.p);
        if (b != null) {
            d(b);
            if (!this.q) {
                this.q = true;
                this.g.a((am) this);
            }
            if (b.k()) {
                this.n.setVisibility(4);
                return;
            }
            this.n.setText("开始签到");
            this.n.setEnabled(true);
            this.n.setVisibility(0);
            this.n.setOnClickListener(new l(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a
    public void b() {
        d();
    }
}
