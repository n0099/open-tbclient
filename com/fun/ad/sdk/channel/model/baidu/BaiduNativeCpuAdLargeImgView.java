package com.fun.ad.sdk.channel.model.baidu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.R;
/* loaded from: classes6.dex */
public class BaiduNativeCpuAdLargeImgView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f30743a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f30744b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30745c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30746d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f30747e;

    /* renamed from: f  reason: collision with root package name */
    public Button f30748f;

    /* renamed from: g  reason: collision with root package name */
    public float f30749g;

    public BaiduNativeCpuAdLargeImgView(Context context) {
        super(context);
        this.f30749g = 1.78f;
    }

    public BaiduNativeCpuAdLargeImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f30749g = 1.78f;
    }

    public BaiduNativeCpuAdLargeImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30749g = 1.78f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30743a = (TextView) findViewById(R.id.ad_description);
        this.f30744b = (ImageView) findViewById(R.id.ad_img);
        this.f30745c = (ImageView) findViewById(R.id.ad_icon);
        this.f30746d = (TextView) findViewById(R.id.ad_title);
        this.f30747e = (ImageView) findViewById(R.id.ad_logo);
        this.f30748f = (Button) findViewById(R.id.ad_creative);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30744b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.f30749g);
        this.f30744b.setLayoutParams(layoutParams);
    }
}
