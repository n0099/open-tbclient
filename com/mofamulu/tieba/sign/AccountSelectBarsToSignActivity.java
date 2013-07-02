package com.mofamulu.tieba.sign;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AccountSelectBarsToSignActivity extends a {
    protected Button j;
    ProgressBar k;
    List l;
    protected BaseAdapter m = new v(this);
    Handler n = new x(this);
    private ListView o;
    private String p;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a, com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.p = getIntent().getExtras().getString("userName");
        setContentView(R.layout.edit_bar_activity);
        d();
        m();
        super.onCreate(bundle);
    }

    protected void c() {
        a(this.g.a(this.p));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mofamulu.tieba.sign.a
    public void b() {
        c();
    }

    protected void d() {
        this.j = (Button) findViewById(R.id.edit);
        this.o = (ListView) findViewById(R.id.list);
        this.o.setAdapter((ListAdapter) this.m);
        this.k = (ProgressBar) findViewById(R.id.progress);
        this.k.setVisibility(0);
        this.j.setText(getString(R.string.save));
        this.j.setVisibility(0);
        this.j.setEnabled(false);
        this.j.setBackgroundResource(R.drawable.title_comm);
        ((TextView) findViewById(R.id.title_text)).setText(String.valueOf(this.p) + "要签到的吧");
    }

    protected void m() {
        this.j.setOnClickListener(new y(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List list) {
        this.k.setVisibility(8);
        this.l = list;
        this.m.notifyDataSetChanged();
        this.j.setEnabled(true);
    }

    protected void a(ar arVar) {
        boolean z = false;
        try {
            List<au> n = arVar.n();
            if (n.isEmpty()) {
                n = arVar.m();
            }
            List u = arVar.u();
            if (u != null && !u.isEmpty()) {
                z = true;
            }
            for (au auVar : n) {
                if (z) {
                    if (u.contains(auVar.b)) {
                        auVar.e = true;
                    } else {
                        auVar.e = false;
                    }
                }
            }
            Collections.sort(n, new z(this));
            Message message = new Message();
            message.what = 1;
            message.obj = n;
            this.n.sendMessage(message);
        } catch (Throwable th) {
            c("读取贴吧信息错误：" + th.getMessage());
        }
    }

    protected void c(String str) {
        Message message = new Message();
        message.what = 2;
        message.obj = str;
        this.n.sendMessage(message);
    }
}
