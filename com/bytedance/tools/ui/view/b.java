package com.bytedance.tools.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.mnb;
/* loaded from: classes9.dex */
public class b extends FoldSpinnerView {
    public mnb f;
    public Context g;

    public b(Context context, String str, mnb mnbVar, boolean z) {
        super(context, str, z);
        this.f = mnbVar;
        this.g = context;
        e();
    }

    private void e() {
        for (int i = 0; i < this.f.i().size(); i++) {
            mnb mnbVar = this.f.i().get(i);
            View inflate = LayoutInflater.from(this.g).inflate(R.layout.obfuscated_res_0x7f0d05ad, (ViewGroup) this, false);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0911e5)).setText(mnbVar.f());
            if ("1".equals(mnbVar.h())) {
                ((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0926d4)).setImageResource(R.drawable.obfuscated_res_0x7f080e3a);
            } else {
                ((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0926d4)).setImageResource(R.drawable.obfuscated_res_0x7f080e3b);
            }
            addView(inflate);
        }
        a();
    }

    @Override // com.bytedance.tools.ui.view.FoldSpinnerView
    public void b(boolean z) {
        this.f.e(z);
    }

    public void f(String str, mnb mnbVar, boolean z) {
        this.f = mnbVar;
        setIsFold(z);
        setTitleText(str);
        for (int childCount = getChildCount() - 1; childCount >= 1; childCount--) {
            removeView(getChildAt(childCount));
        }
        e();
    }
}
