package com.mofamulu.tieba.sign;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.NickBinder;
import com.mofamulu.tieba.ch.bg;
import java.util.List;
/* loaded from: classes.dex */
public class AccountListActivity extends a implements am {
    protected Button j;
    protected List k;
    protected bg l;
    protected boolean m;
    protected volatile boolean n = false;
    protected BaseAdapter o = new n(this);
    Handler p = new o(this);
    private ListView q;
    private Button r;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a, com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.tbhp_sign_list);
        this.l = bg.c();
        c();
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        if (this.g != null) {
            this.g.b(this);
        }
        this.n = false;
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a, com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        if (!this.n && this.g != null) {
            this.n = true;
            this.g.a((am) this);
        }
        if (this.g != null && this.k != null) {
            com.mofamulu.tieba.ch.a.a(new p(this));
        }
        ((NotificationManager) getSystemService("notification")).cancelAll();
        super.onResume();
    }

    protected void c() {
        this.r = (Button) findViewById(R.id.add);
        this.q = (ListView) findViewById(R.id.list);
        this.j = (Button) findViewById(R.id.sign_start);
        if (NickBinder.b.b() == 0) {
            Toast.makeText(this, getString(R.string.auth_sync_failed_tip), 1).show();
            return;
        }
        this.r.setOnClickListener(new q(this));
        this.j.setOnClickListener(new r(this));
        this.q.setClickable(true);
        this.q.setLongClickable(true);
        this.q.setOnItemClickListener(new t(this));
        this.q.setOnItemLongClickListener(new u(this));
        this.q.setAdapter((ListAdapter) this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List list) {
        this.q.setVisibility(8);
        this.k = list;
        this.o.notifyDataSetChanged();
        this.q.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a
    public void b() {
        a();
        d();
        if (!this.n) {
            this.n = true;
            this.g.a((am) this);
        }
    }

    @Override // com.mofamulu.tieba.sign.am
    public void a(al alVar) {
        if (this.m && this.g != null) {
            this.m = false;
            b(this.g.e());
            return;
        }
        b(this.k);
    }

    @Override // com.mofamulu.tieba.sign.am
    public void b(al alVar) {
        if (this.m && this.g != null) {
            this.m = false;
            b(this.g.e());
        } else {
            b(this.k);
        }
        d();
    }

    @Override // com.mofamulu.tieba.sign.am
    public void a() {
        if (this.g != null) {
            b(this.g.e());
            d();
        }
    }

    protected void b(List list) {
        Message message = new Message();
        message.what = 1;
        message.obj = list;
        this.p.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.g != null && this.p != null) {
            try {
                boolean c = this.g.c();
                Message message = new Message();
                message.what = 2;
                message.obj = Boolean.valueOf(c);
                this.p.sendMessage(message);
            } catch (Throwable th) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
    }
}
