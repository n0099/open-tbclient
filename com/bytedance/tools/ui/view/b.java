package com.bytedance.tools.ui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.ulb;
/* loaded from: classes9.dex */
public class b extends FoldSpinnerView {
    public ulb f;
    public Context g;

    public b(Context context, String str, ulb ulbVar, boolean z) {
        super(context, str, z);
        this.f = ulbVar;
        this.g = context;
        e();
    }

    private void e() {
        for (int i = 0; i < this.f.i().size(); i++) {
            ulb ulbVar = this.f.i().get(i);
            View inflate = LayoutInflater.from(this.g).inflate(R.layout.obfuscated_res_0x7f0d05a9, (ViewGroup) this, false);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0911f4)).setText(ulbVar.f());
            if ("1".equals(ulbVar.h())) {
                ((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092708)).setImageResource(R.drawable.obfuscated_res_0x7f080e3f);
            } else {
                ((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092708)).setImageResource(R.drawable.obfuscated_res_0x7f080e40);
            }
            addView(inflate);
        }
        a();
    }

    @Override // com.bytedance.tools.ui.view.FoldSpinnerView
    public void b(boolean z) {
        this.f.e(z);
    }

    public void f(String str, ulb ulbVar, boolean z) {
        this.f = ulbVar;
        setIsFold(z);
        setTitleText(str);
        for (int childCount = getChildCount() - 1; childCount >= 1; childCount--) {
            removeView(getChildAt(childCount));
        }
        e();
    }
}
