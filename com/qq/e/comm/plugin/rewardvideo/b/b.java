package com.qq.e.comm.plugin.rewardvideo.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ao;
import com.qq.e.comm.plugin.util.g;
/* loaded from: classes3.dex */
public class b extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f12387a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f12388b;
    private ImageView c;

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
        int a2 = ak.a(context, 14);
        linearLayout.setPadding(a2, 0, a2, 0);
        this.c = new ImageView(context);
        this.c.setImageBitmap(ao.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
        this.c.setScaleType(ImageView.ScaleType.FIT_CENTER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ak.a(context, 30), ak.a(context, 30));
        layoutParams.rightMargin = ak.a(context, 7);
        layoutParams.gravity = 16;
        this.c.setVisibility(8);
        linearLayout.addView(this.c, layoutParams);
        View view = new View(context);
        view.setId(-1894776829);
        view.setBackgroundColor(Color.parseColor("#ffe4e5e7"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 0.67f, getResources().getDisplayMetrics()));
        layoutParams2.addRule(12, -1);
        layoutParams2.addRule(6, -1894776828);
        view.setLayoutParams(layoutParams2);
        addView(view);
        this.f12388b = new ProgressBar(context, null, 16842872);
        this.f12388b.setId(-1894776828);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.34f, getResources().getDisplayMetrics()));
        layoutParams3.addRule(12, -1);
        this.f12388b.setLayoutParams(layoutParams3);
        this.f12388b.setMax(100);
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(0), 3, 1);
        ClipDrawable clipDrawable2 = new ClipDrawable(new ColorDrawable(Color.parseColor("#ff008de8")), 3, 1);
        clipDrawable.setLevel(10000);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{clipDrawable, clipDrawable2, clipDrawable2});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.f12388b.setProgressDrawable(layerDrawable);
        addView(this.f12388b);
        this.f12387a = new TextView(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 16;
        layoutParams4.weight = 1.0E-6f;
        this.f12387a.setLayoutParams(layoutParams4);
        this.f12387a.setTextSize(2, 15.33f);
        this.f12387a.setTextColor(-1);
        this.f12387a.setSingleLine();
        this.f12387a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        linearLayout.addView(this.f12387a, layoutParams4);
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(ak.a(context, 40), ak.a(context, 14));
        layoutParams5.gravity = 21;
        linearLayout.addView(imageView, layoutParams5);
        g.a(imageView);
    }

    private void b(int i) {
        ProgressBar progressBar = this.f12388b;
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        progressBar.setProgress(i);
    }

    public ImageView a() {
        return this.c;
    }

    public void a(int i) {
        if (this.f12388b.getVisibility() != 0) {
            this.f12388b.setVisibility(0);
        }
        b(i);
    }

    public void a(View.OnClickListener onClickListener) {
        this.c.setClickable(true);
        this.c.setOnClickListener(onClickListener);
    }

    public void a(String str) {
        this.f12387a.setText(str);
    }

    public void b() {
        if (this.f12388b.getVisibility() == 0) {
            this.f12388b.setVisibility(8);
            this.f12388b.setProgress(0);
        }
    }
}
