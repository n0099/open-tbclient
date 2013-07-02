package com.mofamulu.tieba.tail;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.bf;
import com.mofamulu.tieba.ch.bg;
import java.util.List;
/* loaded from: classes.dex */
public class LovedBarListActivity extends com.mofamulu.tieba.ch.aa {
    protected Button g;
    ProgressBar j;
    List k;
    protected BaseAdapter l = new h(this);
    Handler m = new i(this);
    private ListView n;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        setContentView(R.layout.edit_bar_activity);
        b();
        c();
        super.onCreate(bundle);
        d();
    }

    protected void b() {
        this.g = (Button) findViewById(R.id.edit);
        this.n = (ListView) findViewById(R.id.list);
        this.j = (ProgressBar) findViewById(R.id.progress);
        this.g.setText(getString(R.string.refresh));
        this.g.setVisibility(0);
        this.g.setClickable(true);
    }

    protected void c() {
        this.g.setOnClickListener(new j(this));
        this.n.setAdapter((ListAdapter) this.l);
        this.n.setClickable(false);
        this.n.setOnItemClickListener(new k(this));
    }

    public static String b(int i) {
        if (i < 1) {
            return new StringBuilder(String.valueOf(i)).toString();
        }
        if (i < 5) {
            return String.valueOf(i) + "/5";
        }
        if (i < 15) {
            return String.valueOf(i) + "/15";
        }
        if (i < 30) {
            return String.valueOf(i) + "/30";
        }
        if (i < 50) {
            return String.valueOf(i) + "/50";
        }
        if (i < 100) {
            return String.valueOf(i) + "/100";
        }
        if (i < 200) {
            return String.valueOf(i) + "/200";
        }
        if (i < 500) {
            return String.valueOf(i) + "/500";
        }
        if (i < 1000) {
            return String.valueOf(i) + "/1000";
        }
        if (i < 2000) {
            return String.valueOf(i) + "/2000";
        }
        if (i < 3000) {
            return String.valueOf(i) + "/3000";
        }
        if (i < 6000) {
            return String.valueOf(i) + "/6000";
        }
        if (i < 10000) {
            return String.valueOf(i) + "/10000";
        }
        if (i < 18000) {
            return String.valueOf(i) + "/18000";
        }
        if (i < 30000) {
            return String.valueOf(i) + "/30000";
        }
        if (i < 60000) {
            return String.valueOf(i) + "/60000";
        }
        if (i < 100000) {
            return String.valueOf(i) + "/100000";
        }
        if (i < 300000) {
            return String.valueOf(i) + "/300000";
        }
        return String.valueOf(i) + "/?";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(List list) {
        this.j.setVisibility(8);
        this.k = list;
        this.l.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.j.setVisibility(0);
        this.g.setEnabled(false);
        com.mofamulu.tieba.ch.a.a(new l(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        String a = bg.a();
        if (bf.b(a)) {
            try {
                com.mofamulu.tieba.sign.ar a2 = com.mofamulu.tieba.sign.ar.a(bg.c(), new com.mofamulu.tieba.sign.al(), a, "", "no-code");
                if (a2.a().c()) {
                    List n = a2.n();
                    if (n.isEmpty()) {
                        n = a2.m();
                    }
                    Message message = new Message();
                    message.what = 1;
                    message.obj = n;
                    this.m.sendMessage(message);
                    return;
                }
                c("使用此功能请先登录。");
                return;
            } catch (Throwable th) {
                c("读取贴吧信息错误：" + th.getMessage());
                return;
            }
        }
        c("使用此功能请先登录。");
    }

    protected void c(String str) {
        Message message = new Message();
        message.what = 2;
        message.obj = str;
        this.m.sendMessage(message);
    }
}
