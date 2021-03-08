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
public class BaiduNativeCpuAdSmallImgView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f5232a;
    public ImageView b;
    public TextView c;
    public ImageView d;
    public Button e;

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
        this.f5232a = (TextView) findViewById(R.id.ad_description);
        this.b = (ImageView) findViewById(R.id.ad_img);
        this.c = (TextView) findViewById(R.id.ad_title);
        this.d = (ImageView) findViewById(R.id.ad_logo);
        this.e = (Button) findViewById(R.id.ad_creative);
    }
}
