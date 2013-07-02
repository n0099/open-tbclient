package com.mofamulu.tieba.tail;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes.dex */
public class MoreMapActivity extends com.mofamulu.tieba.ch.aa {
    LinearLayout g;
    LinearLayout j;
    TextView k;
    TextView l;
    CheckBox m;
    CheckBox n;
    protected bg o;
    private String[] p = {"不要自动加载", "自动加载", "有WIFI时自动加载，没有时不要刷新"};
    private String[] q = {"网格线", "平面地图", "卫星地图", "地形图", "混合地图"};

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.o = bg.c();
        setContentView(R.layout.tbhp_map_more);
        b();
        c();
        d();
    }

    protected void b() {
        this.g = (LinearLayout) findViewById(R.id.map_op_posts_refresh_container);
        this.j = (LinearLayout) findViewById(R.id.map_gmap_type_container);
        this.k = (TextView) findViewById(R.id.map_op_posts_refresh);
        this.l = (TextView) findViewById(R.id.map_gmap_type);
        this.m = (CheckBox) findViewById(R.id.map_op_active_our_map);
        this.n = (CheckBox) findViewById(R.id.c_map_jump_real_place_on_startup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        int V = this.o.V();
        if (V >= this.p.length) {
            V = 0;
        }
        this.k.setText(this.p[V]);
        int W = this.o.W();
        this.l.setText(this.q[W < this.q.length ? W : 0]);
        this.m.setChecked(this.o.S());
        this.n.setChecked(this.o.T());
    }

    protected void d() {
        this.g.setOnClickListener(new p(this));
        this.j.setOnClickListener(new q(this));
        r rVar = new r(this);
        this.m.setOnCheckedChangeListener(rVar);
        this.n.setOnCheckedChangeListener(rVar);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        String[] strArr;
        String[] strArr2;
        if (i == R.id.map_op_posts_refresh_container) {
            Dialog dialog = new Dialog(this);
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.tbhp_devices_dialog, (ViewGroup) null);
            dialog.setContentView(inflate);
            ListView listView = (ListView) inflate.findViewById(R.id.list);
            ((TextView) inflate.findViewById(R.id.recommend_app_text)).setVisibility(8);
            ArrayList arrayList = new ArrayList();
            for (String str : this.p) {
                HashMap hashMap = new HashMap();
                hashMap.put("title", str);
                arrayList.add(hashMap);
            }
            listView.setAdapter((ListAdapter) new SimpleAdapter(this, arrayList, R.layout.tbhp_devices_item, new String[]{"title"}, new int[]{R.id.title}));
            listView.setSelection(this.o.V());
            listView.setOnItemClickListener(new s(this, dialog));
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setTitle(R.string.map_op_posts_refresh);
            return dialog;
        } else if (i == R.id.map_gmap_type_container) {
            Dialog dialog2 = new Dialog(this);
            View inflate2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.tbhp_devices_dialog, (ViewGroup) null);
            dialog2.setContentView(inflate2);
            ListView listView2 = (ListView) inflate2.findViewById(R.id.list);
            ((TextView) inflate2.findViewById(R.id.recommend_app_text)).setVisibility(8);
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : this.q) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("title", str2);
                arrayList2.add(hashMap2);
            }
            listView2.setAdapter((ListAdapter) new SimpleAdapter(this, arrayList2, R.layout.tbhp_devices_item, new String[]{"title"}, new int[]{R.id.title}));
            listView2.setSelection(this.o.W());
            listView2.setOnItemClickListener(new t(this, dialog2));
            dialog2.setCancelable(true);
            dialog2.setCanceledOnTouchOutside(true);
            dialog2.setTitle(R.string.map_gmap_type);
            return dialog2;
        } else {
            return null;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        c();
    }
}
