package com.mofamulu.tieba.sms;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.aa;
import com.mofamulu.tieba.ch.af;
import com.mofamulu.tieba.ch.be;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class SMSChatActivity extends aa {
    public static af g;
    public static f j;
    protected View k;
    ProgressBar l;
    b m;
    protected f n;
    protected BaseAdapter o;
    protected LinkedList p;
    protected e q = new j(this);
    Handler r = new k(this);
    private ListView s;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.tbhp_sms_chat_activity);
        this.m = new b(g, getIntent().getStringExtra("msgBdsToken"));
        this.n = j;
        g = null;
        j = null;
        b();
        c();
        super.onCreate(bundle);
    }

    protected void b() {
        ((TextView) findViewById(R.id.title_text)).setText(this.n.b);
        this.s = (ListView) findViewById(R.id.list);
        this.s.setClickable(false);
        this.s.setLongClickable(false);
        this.l = (ProgressBar) findViewById(R.id.progress);
        this.l.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.ch.aa, com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        if (this.e != null) {
            if (i == 1) {
                this.e.setDivider(null);
            } else {
                this.e.setDivider(null);
            }
        }
    }

    protected void c() {
        this.k = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.tbhp_sms_chat_footer, (ViewGroup) null);
        be.a(this.k);
        ((Button) this.k.findViewById(R.id.send)).setOnClickListener(new l(this, (EditText) this.k.findViewById(R.id.post_content)));
        this.k.setVisibility(4);
        this.s.addFooterView(this.k);
        this.o = new m(this);
        this.s.setAdapter((ListAdapter) this.o);
        this.s.setSelected(false);
        this.s.setLongClickable(false);
        this.s.setClickable(false);
        this.m.a(this.q, this.n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.l.setVisibility(8);
        this.s.setVisibility(4);
        this.o.notifyDataSetChanged();
        if (this.p != null && this.p.size() > 0) {
            this.s.setSelection(this.p.size() - 1);
        }
        this.k.setVisibility(0);
        this.s.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        Message message = new Message();
        message.what = 2;
        message.obj = str;
        this.r.sendMessage(message);
    }
}
