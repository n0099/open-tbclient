package com.qq.e.comm.plugin.n;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes4.dex */
public class k extends RelativeLayout {
    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    private void b() {
        GDTLogger.d("LoadingView init");
        setLayerType(1, null);
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
        String string = GDTADManager.getInstance().getSM().getString("endcardLoadingUrl");
        if (TextUtils.isEmpty(string)) {
            string = "http://qzs.qq.com/union/res/union_cdn/page/images/loading_2x.gif";
        }
        com.qq.e.comm.plugin.ac.f fVar = new com.qq.e.comm.plugin.ac.f(getContext(), string);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(128, 128);
        layoutParams2.addRule(13);
        fVar.setId(2131755010);
        addView(fVar, layoutParams2);
        TextView textView = new TextView(getContext());
        textView.setId(2131755011);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2131755010);
        layoutParams3.addRule(14);
        layoutParams3.topMargin = ak.a(getContext(), 16);
        textView.setLayoutParams(layoutParams3);
        textView.setText("正在加载游戏");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        addView(textView);
        TextView textView2 = new TextView(getContext());
        textView2.setId(2131755012);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, 2131755011);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = ak.a(getContext(), 8);
        textView2.setLayoutParams(layoutParams4);
        textView2.setText("即将开启试玩");
        textView2.setTextColor(-1);
        textView2.setTextSize(16.0f);
        addView(textView2);
        setVisibility(8);
    }

    public void a() {
        GDTLogger.d("LoadingView dismiss");
        clearAnimation();
        setVisibility(8);
    }
}
