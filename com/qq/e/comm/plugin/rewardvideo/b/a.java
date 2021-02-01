package com.qq.e.comm.plugin.rewardvideo.b;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ap;
/* loaded from: classes15.dex */
public class a extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f12387a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f12388b;

    public a(Context context) {
        super(context);
    }

    public LinearLayout a(Context context, String str, String str2, String str3) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ak.a(context, 137));
        linearLayout.setBackgroundDrawable(ap.a(ak.a(context, 10), -1, 255));
        linearLayout.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        textView.setText(str);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = ak.a(context, 40);
        layoutParams2.topMargin = ak.a(context, 40);
        layoutParams2.rightMargin = ak.a(context, 20);
        layoutParams2.leftMargin = ak.a(context, 20);
        linearLayout.addView(textView, layoutParams2);
        TextView textView2 = new TextView(context);
        textView2.setBackgroundColor(Color.parseColor("#ececec"));
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, ak.a(context, 1)));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, ak.a(context, 44)));
        if (!TextUtils.isEmpty(str3)) {
            this.f12388b = new TextView(context);
            this.f12388b.setText(str3);
            this.f12388b.setTextSize(16.0f);
            this.f12388b.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.f12388b.setGravity(17);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, ak.a(context, 44));
            layoutParams3.weight = 1.0f;
            linearLayout2.addView(this.f12388b, layoutParams3);
            TextView textView3 = new TextView(context);
            textView3.setBackgroundColor(Color.parseColor("#ececec"));
            linearLayout2.addView(textView3, new LinearLayout.LayoutParams(ak.a(context, 1), -1));
        }
        this.f12387a = new TextView(context);
        this.f12387a.setText(str2);
        this.f12387a.setTextSize(16.0f);
        this.f12387a.setTextColor(Color.parseColor("#3185FC"));
        this.f12387a.setGravity(17);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, ak.a(context, 44));
        layoutParams4.weight = 1.0f;
        linearLayout2.addView(this.f12387a, layoutParams4);
        return linearLayout;
    }

    public TextView a() {
        return this.f12388b;
    }

    public TextView b() {
        return this.f12387a;
    }
}
