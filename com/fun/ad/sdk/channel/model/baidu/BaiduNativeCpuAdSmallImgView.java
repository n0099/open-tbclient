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
public class BaiduNativeCpuAdSmallImgView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f30751a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f30752b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30753c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30754d;

    /* renamed from: e  reason: collision with root package name */
    public Button f30755e;

    public BaiduNativeCpuAdSmallImgView(Context context) {
        super(context);
    }

    public BaiduNativeCpuAdSmallImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaiduNativeCpuAdSmallImgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30751a = (TextView) findViewById(R.id.ad_description);
        this.f30752b = (ImageView) findViewById(R.id.ad_img);
        this.f30753c = (TextView) findViewById(R.id.ad_title);
        this.f30754d = (ImageView) findViewById(R.id.ad_logo);
        this.f30755e = (Button) findViewById(R.id.ad_creative);
    }
}
