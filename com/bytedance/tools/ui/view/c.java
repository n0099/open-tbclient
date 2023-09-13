package com.bytedance.tools.ui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.vlb;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class c extends LinearLayout {
    public RadioGroup a;
    public TextView b;
    public RadioButton c;
    public LinearLayout d;
    public vlb e;
    public List<vlb> f;

    public abstract boolean d();

    public abstract vlb getConfigModel();

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            c.this.c.setChecked(true);
            c.this.a.check(c.this.getId());
        }
    }

    public c(Context context, RadioGroup radioGroup, vlb vlbVar, List<vlb> list) {
        super(context);
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0857, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        b(radioGroup, vlbVar, list);
    }

    public void setChecked(boolean z) {
        int i;
        LinearLayout linearLayout = this.d;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.c.setChecked(z);
    }

    public void setTitle(String str) {
        this.b.setText(str);
    }

    public void b(RadioGroup radioGroup, vlb vlbVar, List<vlb> list) {
        this.a = radioGroup;
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091e4f);
        this.c = (RadioButton) findViewById(R.id.obfuscated_res_0x7f091e4d);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091e4e);
        this.d = linearLayout;
        linearLayout.setVisibility(8);
        this.e = vlbVar;
        this.f = list;
        setOnClickListener(new a());
    }
}
