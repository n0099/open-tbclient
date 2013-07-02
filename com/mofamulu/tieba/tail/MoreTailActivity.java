package com.mofamulu.tieba.tail;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.bg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class MoreTailActivity extends com.mofamulu.tieba.ch.aa {
    LinearLayout g;
    LinearLayout j;
    LinearLayout k;
    LinearLayout l;
    LinearLayout m;
    TextView n;
    TextView o;
    TextView p;
    TextView q;
    TextView r;
    CheckBox s;
    CheckBox t;
    Button u;
    protected bg v;
    private String[] w = {"iPhone客户端", "Android客户端", "Windows Phone客户端", "Windows8客户端", "普通电脑"};

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.v = bg.c();
        setContentView(R.layout.tbhp_tail_more);
        b();
        c();
        d();
    }

    protected void b() {
        this.g = (LinearLayout) findViewById(R.id.tail_client_from_container);
        this.j = (LinearLayout) findViewById(R.id.tail_text_container);
        this.k = (LinearLayout) findViewById(R.id.tail_normal_tails);
        this.l = (LinearLayout) findViewById(R.id.tail_default_tail);
        this.m = (LinearLayout) findViewById(R.id.tail_lzl_tails);
        this.n = (TextView) findViewById(R.id.tail_client_from);
        this.o = (TextView) findViewById(R.id.tail_text);
        this.p = (TextView) findViewById(R.id.tail_normal_tails_text);
        this.q = (TextView) findViewById(R.id.tail_default_tail_text);
        this.r = (TextView) findViewById(R.id.tail_lzl_tails_text);
        this.s = (CheckBox) findViewById(R.id.tail_active);
        this.t = (CheckBox) findViewById(R.id.tail_active_in_lzl);
        this.u = (Button) findViewById(R.id.test_tail_button);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.s.setChecked(this.v.z());
        this.t.setChecked(this.v.A());
        String a = bg.a();
        LinkedList b = this.v.b(a);
        if (b == null) {
            this.p.setText("未设置");
        } else {
            this.p.setText(String.valueOf(b.size()) + "个");
        }
        int a2 = this.v.a(a);
        if (a2 == -2) {
            this.q.setText("不使用");
        } else if (a2 == -1) {
            this.q.setText("随机");
        } else if (b != null && b.size() > a2) {
            this.q.setText(((an) b.get(a2)).c);
        } else {
            this.q.setText("原默认尾巴已删除");
        }
        List c = this.v.c(a);
        if (c == null) {
            this.r.setText("未设置");
        } else {
            this.r.setText(String.valueOf(c.size()) + "个");
        }
        int y = this.v.y();
        if (y >= this.w.length) {
            y = 1;
        }
        this.n.setText(this.w[y]);
    }

    protected void d() {
        ad adVar = new ad(this);
        this.s.setOnCheckedChangeListener(adVar);
        this.t.setOnCheckedChangeListener(adVar);
        this.g.setOnClickListener(new ae(this));
        this.j.setClickable(false);
        this.k.setOnClickListener(new af(this));
        this.l.setOnClickListener(new ag(this));
        this.m.setOnClickListener(new ah(this));
        this.u.setOnClickListener(new ai(this));
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        String[] strArr;
        if (i == R.id.tail_client_from_container) {
            Dialog dialog = new Dialog(this);
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.tbhp_devices_dialog, (ViewGroup) null);
            dialog.setContentView(inflate);
            ListView listView = (ListView) inflate.findViewById(R.id.list);
            ArrayList arrayList = new ArrayList();
            for (String str : this.w) {
                HashMap hashMap = new HashMap();
                hashMap.put("title", str);
                arrayList.add(hashMap);
            }
            listView.setAdapter((ListAdapter) new SimpleAdapter(this, arrayList, R.layout.tbhp_devices_item, new String[]{"title"}, new int[]{R.id.title}));
            listView.setSelection(this.v.y());
            listView.setOnItemClickListener(new aj(this, dialog));
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setTitle(R.string.tail_client_from);
            return dialog;
        }
        Dialog dialog2 = new Dialog(this);
        String a = bg.a();
        View inflate2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.tbhp_tail_choser, (ViewGroup) null);
        dialog2.setContentView(inflate2);
        ListView listView2 = (ListView) inflate2.findViewById(R.id.list);
        listView2.setOnItemClickListener(new ak(this, a, dialog2));
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("title", "不使用");
        arrayList2.add(hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("title", "随机");
        arrayList2.add(hashMap3);
        LinkedList b = this.v.b(a);
        if (b != null) {
            Iterator it = b.iterator();
            while (it.hasNext()) {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("title", ((an) it.next()).c);
                arrayList2.add(hashMap4);
            }
        }
        listView2.setAdapter((ListAdapter) new SimpleAdapter(this, arrayList2, R.layout.tbhp_tail_choser_item, new String[]{"title"}, new int[]{R.id.title}));
        listView2.setSelection(this.v.a(a) + 2);
        dialog2.setTitle("选择默认使用的小尾巴");
        return dialog2;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        c();
    }
}
