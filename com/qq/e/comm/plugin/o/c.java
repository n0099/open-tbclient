package com.qq.e.comm.plugin.o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.ao;
/* loaded from: classes15.dex */
class c extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f12338a;

    /* renamed from: b  reason: collision with root package name */
    private final View f12339b;
    private final View c;
    private final ImageView d;
    private final TextView e;

    /* JADX WARN: Removed duplicated region for block: B:9:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(Context context, HybridADSetting hybridADSetting) {
        super(context);
        int width;
        int height;
        int width2;
        int height2;
        setBackgroundColor(hybridADSetting.getTitleBarColor());
        this.f12338a = new ImageView(context);
        this.f12338a.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f12338a.setId(2131755009);
        float f = context.getResources().getDisplayMetrics().density / 2.0f;
        if (!TextUtils.isEmpty(hybridADSetting.getBackButtonImage())) {
            Drawable a2 = ao.a(context, hybridADSetting.getBackButtonImage());
            if (a2 instanceof BitmapDrawable) {
                width = a2.getIntrinsicWidth();
                height = a2.getIntrinsicHeight();
                this.f12338a.setImageDrawable(a2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                layoutParams.addRule(15, -1);
                layoutParams.addRule(9, -1);
                addView(this.f12338a, layoutParams);
                this.f12339b = new View(context);
                this.f12339b.setId(2131755010);
                this.f12339b.setBackgroundColor(hybridADSetting.getSeparatorColor());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ak.a(context, 1), ak.a(context, hybridADSetting.getBackSeparatorLength()));
                layoutParams2.addRule(15, -1);
                layoutParams2.addRule(1, 2131755009);
                addView(this.f12339b, layoutParams2);
                this.d = new ImageView(context);
                this.d.setId(2131755011);
                this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
                if (!TextUtils.isEmpty(hybridADSetting.getCloseButtonImage())) {
                    Drawable a3 = ao.a(context, hybridADSetting.getCloseButtonImage());
                    if (a3 instanceof BitmapDrawable) {
                        width2 = a3.getIntrinsicWidth();
                        height2 = a3.getIntrinsicHeight();
                        this.d.setImageDrawable(a3);
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(width2, height2);
                        layoutParams3.addRule(15, -1);
                        layoutParams3.addRule(1, 2131755010);
                        addView(this.d, layoutParams3);
                        this.e = new TextView(context);
                        this.e.setTextSize(hybridADSetting.getTitleSize());
                        this.e.setTextColor(hybridADSetting.getTitleColor());
                        this.e.setText(hybridADSetting.getTitle());
                        this.e.setGravity(17);
                        this.e.setMaxWidth(ak.a(context, 160));
                        this.e.setSingleLine(true);
                        this.e.setEllipsize(TextUtils.TruncateAt.END);
                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams4.addRule(13, -1);
                        addView(this.e, layoutParams4);
                        this.c = new View(context);
                        this.c.setBackgroundColor(hybridADSetting.getSeparatorColor());
                        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, ak.a(context, 1));
                        layoutParams5.addRule(12, -1);
                        addView(this.c, layoutParams5);
                        this.f12339b.setVisibility(4);
                        this.d.setVisibility(4);
                    }
                }
                Bitmap a4 = ao.a("iVBORw0KGgoAAAANSUhEUgAAAFgAAABYBAMAAACDuy0HAAAAKlBMVEUAAAAqLTQsMjMrLzMrLjMrLjQqLjMrLTQuLjMxMT2AgIAsLjMqLjQqLTM0qw1cAAAADXRSTlMAnSNB9eOqcTcVAoaFBOzX1gAAALFJREFUSMft0rENwlAMRVFDGqD6CyD9kgGyRppMwAJIVCzCAqzABqyQIqV3Aaqbys8D+HZujlw8q6qqquIu2+P5sqi9N45h+ljUwReO0ZuFnb0Br93CdtCjz0YxDaxpYE0DaxpY08ApGljTwAkaOEE7sKaBZYP71bKN7ksantabtzQ8Mz4Nd8anYcaXgQ1aw9AZGFrD0BqG1nCSPgL/6Xv8BfCPFnM6vbvRo1tVVVUV9QW8Pkx3bVKuuwAAAABJRU5ErkJggg==");
                width2 = (int) (a4.getWidth() * f);
                height2 = (int) (a4.getHeight() * f);
                this.d.setImageBitmap(a4);
                RelativeLayout.LayoutParams layoutParams32 = new RelativeLayout.LayoutParams(width2, height2);
                layoutParams32.addRule(15, -1);
                layoutParams32.addRule(1, 2131755010);
                addView(this.d, layoutParams32);
                this.e = new TextView(context);
                this.e.setTextSize(hybridADSetting.getTitleSize());
                this.e.setTextColor(hybridADSetting.getTitleColor());
                this.e.setText(hybridADSetting.getTitle());
                this.e.setGravity(17);
                this.e.setMaxWidth(ak.a(context, 160));
                this.e.setSingleLine(true);
                this.e.setEllipsize(TextUtils.TruncateAt.END);
                RelativeLayout.LayoutParams layoutParams42 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams42.addRule(13, -1);
                addView(this.e, layoutParams42);
                this.c = new View(context);
                this.c.setBackgroundColor(hybridADSetting.getSeparatorColor());
                RelativeLayout.LayoutParams layoutParams52 = new RelativeLayout.LayoutParams(-1, ak.a(context, 1));
                layoutParams52.addRule(12, -1);
                addView(this.c, layoutParams52);
                this.f12339b.setVisibility(4);
                this.d.setVisibility(4);
            }
        }
        Bitmap a5 = ao.a("iVBORw0KGgoAAAANSUhEUgAAAFgAAABYBAMAAACDuy0HAAAAMFBMVEUAAAArLTQqLTMyMjMuLjQrLjMrLTMsLzYrLzMuLkYsLzMrLTQrLzUsLzQrMDQqLTMf2TcfAAAAD3RSTlMA2OYYJ/rzUTwLRst+YjvhhJY4AAAAXklEQVRIx2MYBaNgFIyCkQw4V5Kg2PA38WqZ5T+RYPD/cBIM/lowavAQNZiTFIO5/v8hISHrf2sgXrXT/wziFbOMGj1ojc4jxeiPDCQYTYpi5ssMo2AUjIJRMAoIAQAD4S52zh4qlgAAAABJRU5ErkJggg==");
        width = (int) (a5.getWidth() * f);
        height = (int) (a5.getHeight() * f);
        this.f12338a.setImageBitmap(a5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(width, height);
        layoutParams6.addRule(15, -1);
        layoutParams6.addRule(9, -1);
        addView(this.f12338a, layoutParams6);
        this.f12339b = new View(context);
        this.f12339b.setId(2131755010);
        this.f12339b.setBackgroundColor(hybridADSetting.getSeparatorColor());
        RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(ak.a(context, 1), ak.a(context, hybridADSetting.getBackSeparatorLength()));
        layoutParams22.addRule(15, -1);
        layoutParams22.addRule(1, 2131755009);
        addView(this.f12339b, layoutParams22);
        this.d = new ImageView(context);
        this.d.setId(2131755011);
        this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (!TextUtils.isEmpty(hybridADSetting.getCloseButtonImage())) {
        }
        Bitmap a42 = ao.a("iVBORw0KGgoAAAANSUhEUgAAAFgAAABYBAMAAACDuy0HAAAAKlBMVEUAAAAqLTQsMjMrLzMrLjMrLjQqLjMrLTQuLjMxMT2AgIAsLjMqLjQqLTM0qw1cAAAADXRSTlMAnSNB9eOqcTcVAoaFBOzX1gAAALFJREFUSMft0rENwlAMRVFDGqD6CyD9kgGyRppMwAJIVCzCAqzABqyQIqV3Aaqbys8D+HZujlw8q6qqquIu2+P5sqi9N45h+ljUwReO0ZuFnb0Br93CdtCjz0YxDaxpYE0DaxpY08ApGljTwAkaOEE7sKaBZYP71bKN7ksantabtzQ8Mz4Nd8anYcaXgQ1aw9AZGFrD0BqG1nCSPgL/6Xv8BfCPFnM6vbvRo1tVVVUV9QW8Pkx3bVKuuwAAAABJRU5ErkJggg==");
        width2 = (int) (a42.getWidth() * f);
        height2 = (int) (a42.getHeight() * f);
        this.d.setImageBitmap(a42);
        RelativeLayout.LayoutParams layoutParams322 = new RelativeLayout.LayoutParams(width2, height2);
        layoutParams322.addRule(15, -1);
        layoutParams322.addRule(1, 2131755010);
        addView(this.d, layoutParams322);
        this.e = new TextView(context);
        this.e.setTextSize(hybridADSetting.getTitleSize());
        this.e.setTextColor(hybridADSetting.getTitleColor());
        this.e.setText(hybridADSetting.getTitle());
        this.e.setGravity(17);
        this.e.setMaxWidth(ak.a(context, 160));
        this.e.setSingleLine(true);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams422 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams422.addRule(13, -1);
        addView(this.e, layoutParams422);
        this.c = new View(context);
        this.c.setBackgroundColor(hybridADSetting.getSeparatorColor());
        RelativeLayout.LayoutParams layoutParams522 = new RelativeLayout.LayoutParams(-1, ak.a(context, 1));
        layoutParams522.addRule(12, -1);
        addView(this.c, layoutParams522);
        this.f12339b.setVisibility(4);
        this.d.setVisibility(4);
    }

    public ImageView a() {
        return this.f12338a;
    }

    public ImageView b() {
        return this.d;
    }

    public TextView c() {
        return this.e;
    }

    public View d() {
        return this.f12339b;
    }
}
