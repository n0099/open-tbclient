package com.fun.ad.sdk.channel.model.baidu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.R;
/* loaded from: classes4.dex */
public class BaiduNativeCpuAdLargeImgView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f5231a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public ImageView e;
    public Button f;
    public float g;

    public BaiduNativeCpuAdLargeImgView(Context context) {
        super(context);
        this.g = 1.78f;
    }

    public BaiduNativeCpuAdLargeImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 1.78f;
    }

    public BaiduNativeCpuAdLargeImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 1.78f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f5231a = (TextView) findViewById(R.id.ad_description);
        this.b = (ImageView) findViewById(R.id.ad_img);
        this.c = (ImageView) findViewById(R.id.ad_icon);
        this.d = (TextView) findViewById(R.id.ad_title);
        this.e = (ImageView) findViewById(R.id.ad_logo);
        this.f = (Button) findViewById(R.id.ad_creative);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.g);
        this.b.setLayoutParams(layoutParams);
    }
}
