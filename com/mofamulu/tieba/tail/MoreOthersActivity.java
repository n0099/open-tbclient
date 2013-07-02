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
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.bg;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class MoreOthersActivity extends com.mofamulu.tieba.ch.aa {
    LinearLayout g;
    LinearLayout j;
    LinearLayout k;
    LinearLayout l;
    LinearLayout m;
    TextView n;
    TextView o;
    TextView p;
    CheckBox q;
    CheckBox r;
    CheckBox s;
    CheckBox t;
    CheckBox u;
    CheckBox v;
    CheckBox w;
    Button x;
    protected bg y;
    private String[] z = {"所有百度网页", "所有贴吧网页", "不使用", "所有网页"};
    private String[] A = {"关闭无图模式", "一直无图", "离开WIFI自动无图"};

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.y = bg.c();
        setContentView(R.layout.tbhp_other_more);
        b();
        c();
        d();
    }

    protected void b() {
        this.g = (LinearLayout) findViewById(R.id.broswer_policy_container);
        this.j = (LinearLayout) findViewById(R.id.emotions_container);
        this.k = (LinearLayout) findViewById(R.id.psw_mins_container);
        this.l = (LinearLayout) findViewById(R.id.psw_set_container);
        this.m = (LinearLayout) findViewById(R.id.no_image_mode_policy_container);
        this.n = (TextView) findViewById(R.id.broswer_policy);
        this.o = (TextView) findViewById(R.id.psw_mins);
        this.p = (TextView) findViewById(R.id.no_image_mode_policy);
        this.q = (CheckBox) findViewById(R.id.other_more_hide_recomm);
        this.r = (CheckBox) findViewById(R.id.other_check_sms);
        this.s = (CheckBox) findViewById(R.id.other_sms_bubble);
        this.t = (CheckBox) findViewById(R.id.other_lzl_refer);
        this.u = (CheckBox) findViewById(R.id.psw_on);
        this.v = (CheckBox) findViewById(R.id.other_no_image_mode_click_show);
        this.w = (CheckBox) findViewById(R.id.other_close_yi_cloud);
        this.x = (Button) findViewById(R.id.check_update_button);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        int P;
        int G = this.y.G();
        if (G >= this.z.length) {
            G = 0;
        }
        this.n.setText(this.z[G]);
        int J = this.y.J();
        this.p.setText(this.A[J < this.A.length ? J : 0]);
        this.o.setText(this.y.P() > 0 ? String.valueOf(P) + "分钟" : "无免输");
        this.q.setChecked(this.y.H());
        this.r.setChecked(this.y.M());
        this.s.setChecked(this.y.N());
        this.t.setChecked(this.y.R());
        this.u.setChecked(this.y.Q());
        this.v.setChecked(this.y.K());
        this.w.setChecked(this.y.L());
    }

    protected void d() {
        this.g.setOnClickListener(new u(this));
        this.m.setOnClickListener(new v(this));
        this.k.setOnClickListener(new w(this));
        this.j.setOnClickListener(new com.mofamulu.tieba.ch.e(this, MoreEmotionsActivity.class));
        x xVar = new x(this);
        this.q.setOnCheckedChangeListener(xVar);
        this.r.setOnCheckedChangeListener(xVar);
        this.s.setOnCheckedChangeListener(xVar);
        this.t.setOnCheckedChangeListener(xVar);
        this.u.setOnCheckedChangeListener(xVar);
        this.v.setOnCheckedChangeListener(xVar);
        this.w.setOnCheckedChangeListener(xVar);
        this.x.setOnClickListener(new y(this));
        this.l.setOnClickListener(new z(this));
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        String[] strArr;
        String[] strArr2;
        if (i == R.id.broswer_policy_container) {
            Dialog dialog = new Dialog(this);
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.tbhp_devices_dialog, (ViewGroup) null);
            dialog.setContentView(inflate);
            ListView listView = (ListView) inflate.findViewById(R.id.list);
            ((TextView) inflate.findViewById(R.id.recommend_app_text)).setText(getString(R.string.other_broswer_tips));
            ArrayList arrayList = new ArrayList();
            for (String str : this.z) {
                HashMap hashMap = new HashMap();
                hashMap.put("title", str);
                arrayList.add(hashMap);
            }
            listView.setAdapter((ListAdapter) new SimpleAdapter(this, arrayList, R.layout.tbhp_devices_item, new String[]{"title"}, new int[]{R.id.title}));
            listView.setSelection(this.y.G());
            listView.setOnItemClickListener(new aa(this, dialog));
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setTitle(R.string.other_broswer_policy);
            return dialog;
        } else if (i == R.id.psw_mins_container) {
            Dialog dialog2 = new Dialog(this);
            View inflate2 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.seek_seconds_dialog, (ViewGroup) null);
            dialog2.setContentView(inflate2);
            SeekBar seekBar = (SeekBar) inflate2.findViewById(R.id.seekbar);
            seekBar.setOnSeekBarChangeListener(new ab(this, dialog2, (TextView) inflate2.findViewById(R.id.title)));
            seekBar.setMax(15);
            seekBar.setProgress(this.y.P());
            dialog2.setTitle(R.string.psw_mins_title);
            return dialog2;
        } else if (i == R.id.no_image_mode_policy_container) {
            Dialog dialog3 = new Dialog(this);
            View inflate3 = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.tbhp_devices_dialog, (ViewGroup) null);
            dialog3.setContentView(inflate3);
            ListView listView2 = (ListView) inflate3.findViewById(R.id.list);
            ((TextView) inflate3.findViewById(R.id.recommend_app_text)).setVisibility(8);
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : this.A) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("title", str2);
                arrayList2.add(hashMap2);
            }
            listView2.setAdapter((ListAdapter) new SimpleAdapter(this, arrayList2, R.layout.tbhp_devices_item, new String[]{"title"}, new int[]{R.id.title}));
            listView2.setSelection(this.y.J());
            listView2.setOnItemClickListener(new ac(this, dialog3));
            dialog3.setCancelable(true);
            dialog3.setCanceledOnTouchOutside(true);
            dialog3.setTitle(R.string.other_no_image_mode);
            return dialog3;
        } else {
            return null;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        c();
    }
}
