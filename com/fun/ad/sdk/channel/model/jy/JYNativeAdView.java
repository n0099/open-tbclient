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
/* loaded from: classes6.dex */
public final class JYNativeAdView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f30657a;

    /* renamed from: b  reason: collision with root package name */
    public PBMediaView f30658b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30659c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30660d;

    /* renamed from: e  reason: collision with root package name */
    public Button f30661e;

    /* renamed from: f  reason: collision with root package name */
    public float f30662f;

    public JYNativeAdView(Context context) {
        super(context);
        this.f30662f = 1.78f;
    }

    public JYNativeAdView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f30662f = 1.78f;
    }

    public JYNativeAdView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30662f = 1.78f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30657a = (TextView) findViewById(R.id.ad_description);
        this.f30658b = (PBMediaView) findViewById(R.id.ad_img);
        this.f30659c = (TextView) findViewById(R.id.ad_title);
        this.f30660d = (ImageView) findViewById(R.id.ad_icon);
        this.f30661e = (Button) findViewById(R.id.ad_creative);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30658b.getLayoutParams();
        int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i6;
        layoutParams.height = (int) (i6 / this.f30662f);
        this.f30658b.setLayoutParams(layoutParams);
    }
}
