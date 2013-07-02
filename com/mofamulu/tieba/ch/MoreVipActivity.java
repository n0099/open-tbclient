package com.mofamulu.tieba.ch;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tieba.R;
import com.baidu.zeus.bouncycastle.DERTags;
import com.mofamulu.tieba.tail.FAQActivity;
import java.util.Iterator;
/* loaded from: classes.dex */
public class MoreVipActivity extends aa {
    Button g;
    Button j;
    Button k;
    Button l;
    Button m;
    ViewGroup n;
    TextView o;
    CheckBox p;
    ProgressBar q;
    protected bg r;
    protected u s;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.r = bg.c();
        this.s = new u(this.r);
        setContentView(R.layout.tbhp_vip_more);
        b();
        c();
        d();
    }

    protected void b() {
        this.o = (TextView) findViewById(R.id.vip_records);
        this.g = (Button) findViewById(R.id.vip_clear);
        this.j = (Button) findViewById(R.id.add);
        this.p = (CheckBox) findViewById(R.id.cloud_active_emotions);
        this.q = (ProgressBar) findViewById(R.id.progress);
        this.k = (Button) findViewById(R.id.upload_settings);
        this.l = (Button) findViewById(R.id.download_settings);
        this.m = (Button) findViewById(R.id.download_emotions);
        this.n = (ViewGroup) findViewById(R.id.to_faq_container);
    }

    protected void c() {
        Iterator b = this.r.x().b();
        StringBuilder sb = new StringBuilder((int) DERTags.TAGGED);
        while (b.hasNext()) {
            String str = (String) b.next();
            sb.append(str).append(" -- ");
            if (this.r.a(str, false)) {
                sb.append("VIP用户");
            } else {
                sb.append("普通用户");
            }
            sb.append("\n\n");
        }
        if (sb.length() > 3) {
            sb.setLength(sb.length() - 2);
        }
        this.o.setText(sb.toString());
        this.p.setChecked(this.r.C());
    }

    protected void d() {
        this.j.setOnClickListener(new an(this));
        this.n.setOnClickListener(new e(this, FAQActivity.class));
        this.g.setOnClickListener(new ao(this));
        boolean e = this.r.e(false);
        this.k.setOnClickListener(new ap(this, e));
        this.l.setOnClickListener(new aq(this, e));
        this.m.setOnClickListener(new ar(this, e));
    }

    public void c(String str) {
        this.q.setVisibility(8);
        Toast.makeText(this, str, 1).show();
    }
}
