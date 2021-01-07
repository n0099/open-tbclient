package com.qq.e.comm.plugin.q;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
/* loaded from: classes4.dex */
public class b extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f12654a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f12655b;
    private a c;

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.c = new a(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 29.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 35.0f, getResources().getDisplayMetrics()));
        this.c.a(Color.parseColor("#2a2d33"));
        this.c.a(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        layoutParams.gravity = 19;
        layoutParams.leftMargin = (int) TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics());
        this.c.setLayoutParams(layoutParams);
        int applyDimension = (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
        this.c.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        addView(this.c);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#ffe4e5e7"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 0.67f, getResources().getDisplayMetrics()));
        layoutParams2.gravity = 80;
        view.setLayoutParams(layoutParams2);
        addView(view);
        this.f12655b = new ProgressBar(context, null, 16842872);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.34f, getResources().getDisplayMetrics()));
        layoutParams3.gravity = 80;
        this.f12655b.setLayoutParams(layoutParams3);
        this.f12655b.setMax(100);
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(0), 3, 1);
        ClipDrawable clipDrawable2 = new ClipDrawable(new ColorDrawable(Color.parseColor("#ff008de8")), 3, 1);
        clipDrawable.setLevel(10000);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{clipDrawable, clipDrawable2, clipDrawable2});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.f12655b.setProgressDrawable(layerDrawable);
        addView(this.f12655b);
        this.f12654a = new TextView(context);
        int applyDimension2 = (int) TypedValue.applyDimension(1, 55.0f, getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        layoutParams4.leftMargin = applyDimension2;
        layoutParams4.rightMargin = applyDimension2;
        this.f12654a.setLayoutParams(layoutParams4);
        this.f12654a.setTextSize(2, 15.33f);
        this.f12654a.setTextColor(Color.parseColor("#ff2a2d33"));
        this.f12654a.setSingleLine();
        this.f12654a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        addView(this.f12654a);
    }

    private void b(int i) {
        ProgressBar progressBar = this.f12655b;
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        progressBar.setProgress(i);
    }

    public void a() {
        if (this.f12655b.getVisibility() == 0) {
            this.f12655b.setVisibility(8);
            this.f12655b.setProgress(0);
        }
    }

    public void a(int i) {
        if (this.f12655b.getVisibility() != 0) {
            this.f12655b.setVisibility(0);
        }
        b(i);
    }

    public void a(View.OnClickListener onClickListener) {
        this.c.setClickable(true);
        this.c.setOnClickListener(onClickListener);
    }

    public void a(String str) {
        this.f12654a.setText(str);
    }
}
