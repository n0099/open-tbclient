package com.mofamulu.tieba.ch;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class MoreNickActivity extends aa {
    protected bg g;
    TextView j;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = bg.c();
        setContentView(R.layout.tbhp_ch_activity);
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        this.j = (TextView) findViewById(R.id.delay_outof_wifi_text);
        b();
        c();
        d();
        m();
    }

    protected void b() {
    }

    protected void c() {
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf((int) R.id.radio_4hours), Long.valueOf(4 * 3600000));
        hashMap.put(Integer.valueOf((int) R.id.radio_12hours), Long.valueOf(12 * 3600000));
        hashMap.put(Integer.valueOf((int) R.id.radio_24hours), Long.valueOf(3600000 * 24));
        hashMap.put(Integer.valueOf((int) R.id.radio_3days), Long.valueOf(3600000 * 24 * 3));
        hashMap.put(Integer.valueOf((int) R.id.radio_7days), Long.valueOf(3600000 * 24 * 7));
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.frequency_radio);
        long h = this.g.h();
        Iterator it = hashMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (((Long) entry.getValue()).longValue() == h) {
                radioGroup.check(((Integer) entry.getKey()).intValue());
                break;
            }
        }
        radioGroup.setOnCheckedChangeListener(new ah(this, hashMap));
    }

    protected void d() {
        ((Button) findViewById(R.id.chenghu_modify)).setOnClickListener(new ai(this));
        ((Button) findViewById(R.id.chenghu_clear)).setOnClickListener(new aj(this));
        ((ViewGroup) findViewById(R.id.delay_outof_wifi)).setOnClickListener(new ak(this));
    }

    public void m() {
        if (this.g.q() == 0) {
            this.j.setText("无限制");
        } else {
            this.j.setText(String.valueOf(this.g.q()) + "分钟1次");
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        Dialog dialog = new Dialog(this);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.seek_seconds_dialog, (ViewGroup) null);
        dialog.setContentView(inflate);
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new al(this, dialog, (TextView) inflate.findViewById(R.id.title)));
        seekBar.setMax(30);
        seekBar.setProgress(this.g.q());
        dialog.setTitle(R.string.delay_outof_wifi);
        return dialog;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        m();
    }
}
