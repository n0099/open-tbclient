package com.bytedance.tools.ui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.nnb;
import java.util.List;
/* loaded from: classes9.dex */
public abstract class c extends LinearLayout {
    public RadioGroup a;
    public TextView b;
    public RadioButton c;
    public LinearLayout d;
    public nnb e;
    public List<nnb> f;

    public abstract boolean d();

    public abstract nnb getConfigModel();

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

    public c(Context context, RadioGroup radioGroup, nnb nnbVar, List<nnb> list) {
        super(context);
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0855, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        b(radioGroup, nnbVar, list);
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

    public void b(RadioGroup radioGroup, nnb nnbVar, List<nnb> list) {
        this.a = radioGroup;
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f091e1c);
        this.c = (RadioButton) findViewById(R.id.obfuscated_res_0x7f091e1a);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091e1b);
        this.d = linearLayout;
        linearLayout.setVisibility(8);
        this.e = nnbVar;
        this.f = list;
        setOnClickListener(new a());
    }
}
