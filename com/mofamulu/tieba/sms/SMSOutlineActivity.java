package com.mofamulu.tieba.sms;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.aa;
import com.mofamulu.tieba.ch.be;
/* loaded from: classes.dex */
public class SMSOutlineActivity extends aa {
    protected Button g;
    protected View j;
    ProgressBar k;
    g l;
    protected BaseAdapter m;
    protected i n = new n(this);
    Handler o = new o(this);
    private ListView p;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.tbhp_sms_activity);
        b();
        c();
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.l.b.isEmpty()) {
            m();
        }
    }

    protected void b() {
        this.g = (Button) findViewById(R.id.add);
        this.p = (ListView) findViewById(R.id.list);
        this.k = (ProgressBar) findViewById(R.id.progress);
        this.k.setVisibility(0);
    }

    protected void c() {
        this.g.setOnClickListener(new p(this));
        this.l = new g();
        this.m = new q(this);
        this.j = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.tbhp_sms_footer, (ViewGroup) null);
        be.a(this.j);
        this.j.setVisibility(4);
        this.j.setClickable(false);
        this.j.setOnClickListener(new r(this));
        this.p.addFooterView(this.j);
        this.p.setAdapter((ListAdapter) this.m);
        this.p.setOnItemClickListener(new s(this));
        this.l.a(this.n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        if (this.l.a()) {
            ((TextView) this.j.findViewById(R.id.more)).setText(getString(R.string.load_more));
            this.j.setFocusable(true);
            this.j.setClickable(true);
            this.j.setVisibility(0);
            return;
        }
        this.j.setClickable(false);
        this.j.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        this.p.setVisibility(4);
        this.m.notifyDataSetChanged();
        d();
        this.p.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        Message message = new Message();
        message.what = 2;
        message.obj = str;
        this.o.sendMessage(message);
    }
}
