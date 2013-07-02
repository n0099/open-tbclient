package com.mofamulu.tieba.sign;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.ch.bg;
import java.util.List;
/* loaded from: classes.dex */
public class MoreSignActivity extends com.mofamulu.tieba.ch.aa {
    LinearLayout g;
    LinearLayout j;
    LinearLayout k;
    LinearLayout l;
    TextView m;
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
    protected bg x;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.x = bg.c();
        setContentView(R.layout.tbhp_sign_more);
        b();
        c();
        d();
    }

    protected void b() {
        this.g = (LinearLayout) findViewById(R.id.sign_more_ignored_tbs);
        this.j = (LinearLayout) findViewById(R.id.sign_more_fix_delay);
        this.k = (LinearLayout) findViewById(R.id.sign_more_rand_delay);
        this.l = (LinearLayout) findViewById(R.id.sign_more_auto_time);
        this.m = (TextView) findViewById(R.id.sign_ignore_tbs);
        this.n = (TextView) findViewById(R.id.sign_fix_delay);
        this.o = (TextView) findViewById(R.id.sign_rand_delay);
        this.p = (TextView) findViewById(R.id.sign_auto_time);
        this.q = (CheckBox) findViewById(R.id.sign_more_notif_done);
        this.w = (CheckBox) findViewById(R.id.sign_more_zhidao);
        this.r = (CheckBox) findViewById(R.id.sign_more_try_bouns);
        this.s = (CheckBox) findViewById(R.id.sign_more_auto_start);
        this.t = (CheckBox) findViewById(R.id.sign_more_second_channel);
        this.u = (CheckBox) findViewById(R.id.sign_more_bind_amx);
        this.v = (CheckBox) findViewById(R.id.sign_no_limit);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        List r = this.x.r();
        if (r != null) {
            this.m.setText(String.valueOf(r.size()) + "个");
        } else {
            this.m.setText("无忽略");
        }
        this.n.setText(String.valueOf(this.x.s()) + "秒");
        this.o.setText(String.valueOf(this.x.t()) + "秒");
        StringBuilder sb = new StringBuilder();
        if (this.x.k() < 10) {
            sb.append('0');
        }
        sb.append(this.x.k());
        sb.append(':');
        if (this.x.l() < 10) {
            sb.append('0');
        }
        sb.append(this.x.l());
        this.p.setText(sb.toString());
        this.q.setChecked(this.x.u());
        this.w.setChecked(this.x.o());
        this.r.setChecked(this.x.n());
        this.s.setChecked(this.x.i());
        this.t.setChecked(this.x.v());
        this.u.setChecked(this.x.w());
        this.v.setChecked(this.x.j());
    }

    protected void d() {
        ad adVar = new ad(this);
        this.q.setOnCheckedChangeListener(adVar);
        this.w.setOnCheckedChangeListener(adVar);
        this.r.setOnCheckedChangeListener(adVar);
        this.s.setOnCheckedChangeListener(adVar);
        this.t.setOnCheckedChangeListener(adVar);
        this.u.setOnCheckedChangeListener(adVar);
        this.v.setOnCheckedChangeListener(adVar);
        this.g.setOnClickListener(new ae(this));
        m();
    }

    protected void m() {
        this.j.setOnClickListener(new af(this));
        this.k.setOnClickListener(new ag(this));
        this.l.setOnClickListener(new ah(this));
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        if (i == R.id.sign_more_fix_delay || i == R.id.sign_more_rand_delay) {
            Dialog dialog = new Dialog(this);
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.seek_seconds_dialog, (ViewGroup) null);
            dialog.setContentView(inflate);
            SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.seekbar);
            seekBar.setOnSeekBarChangeListener(new ai(this, i, dialog, (TextView) inflate.findViewById(R.id.title)));
            seekBar.setMax(60);
            if (i == R.id.sign_more_fix_delay) {
                seekBar.setProgress(this.x.s());
                dialog.setTitle(R.string.sign_more_fix_delay);
            } else if (i == R.id.sign_more_rand_delay) {
                seekBar.setProgress(this.x.t());
                dialog.setTitle(R.string.sign_more_rand_delay);
            }
            return dialog;
        }
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new aj(this), this.x.k(), this.x.l(), true);
        timePickerDialog.setTitle(R.string.sign_more_auto_time);
        return timePickerDialog;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        c();
    }
}
