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
    public TextView f30744a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f30745b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30746c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30747d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f30748e;

    /* renamed from: f  reason: collision with root package name */
    public Button f30749f;

    /* renamed from: g  reason: collision with root package name */
    public float f30750g;

    public BaiduNativeCpuAdLargeImgView(Context context) {
        super(context);
        this.f30750g = 1.78f;
    }

    public BaiduNativeCpuAdLargeImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f30750g = 1.78f;
    }

    public BaiduNativeCpuAdLargeImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30750g = 1.78f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30744a = (TextView) findViewById(R.id.ad_description);
        this.f30745b = (ImageView) findViewById(R.id.ad_img);
        this.f30746c = (ImageView) findViewById(R.id.ad_icon);
        this.f30747d = (TextView) findViewById(R.id.ad_title);
        this.f30748e = (ImageView) findViewById(R.id.ad_logo);
        this.f30749f = (Button) findViewById(R.id.ad_creative);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30745b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.f30750g);
        this.f30745b.setLayoutParams(layoutParams);
    }
}
