package com.fun.ad.sdk.channel.model.jy;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.R;
import com.win.opensdk.PBMediaView;
/* loaded from: classes4.dex */
public final class JYNativeAdView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f5234a;
    public PBMediaView b;
    public TextView c;
    public ImageView d;
    public Button e;
    public float f;

    public JYNativeAdView(Context context) {
        super(context);
        this.f = 1.78f;
    }

    public JYNativeAdView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 1.78f;
    }

    public JYNativeAdView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 1.78f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f5234a = (TextView) findViewById(R.id.ad_description);
        this.b = (PBMediaView) findViewById(R.id.ad_img);
        this.c = (TextView) findViewById(R.id.ad_title);
        this.d = (ImageView) findViewById(R.id.ad_icon);
        this.e = (Button) findViewById(R.id.ad_creative);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.f);
        this.b.setLayoutParams(layoutParams);
    }
}
