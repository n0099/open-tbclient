package com.mofamulu.tieba.sign;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.zeus.bouncycastle.DERTags;
import com.mofamulu.tieba.ch.bg;
import java.util.List;
/* loaded from: classes.dex */
public class MoreIgnoredTiebasActivity extends com.mofamulu.tieba.ch.aa {
    EditText g;
    Button j;
    protected bg k;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k = bg.c();
        setContentView(R.layout.tbhp_sign_ignored_tbs);
        b();
        c();
        d();
    }

    protected void b() {
        this.g = (EditText) findViewById(R.id.ignored_tbs);
        this.j = (Button) findViewById(R.id.save);
    }

    protected void c() {
        List r = this.k.r();
        if (r != null) {
            StringBuilder sb = new StringBuilder((int) DERTags.TAGGED);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < r.size()) {
                    sb.append((String) r.get(i2)).append("\n");
                    if (i2 > 0 && i2 % 4 == 0) {
                        sb.append("\n");
                    }
                    i = i2 + 1;
                } else {
                    this.g.setText(sb.toString());
                    return;
                }
            }
        }
    }

    protected void d() {
        this.j.setOnClickListener(new ac(this));
    }
}
