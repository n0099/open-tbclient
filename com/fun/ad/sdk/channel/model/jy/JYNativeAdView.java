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
    public TextView f30550a;

    /* renamed from: b  reason: collision with root package name */
    public PBMediaView f30551b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30552c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30553d;

    /* renamed from: e  reason: collision with root package name */
    public Button f30554e;

    /* renamed from: f  reason: collision with root package name */
    public float f30555f;

    public JYNativeAdView(Context context) {
        super(context);
        this.f30555f = 1.78f;
    }

    public JYNativeAdView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f30555f = 1.78f;
    }

    public JYNativeAdView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30555f = 1.78f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30550a = (TextView) findViewById(R.id.ad_description);
        this.f30551b = (PBMediaView) findViewById(R.id.ad_img);
        this.f30552c = (TextView) findViewById(R.id.ad_title);
        this.f30553d = (ImageView) findViewById(R.id.ad_icon);
        this.f30554e = (Button) findViewById(R.id.ad_creative);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30551b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.f30555f);
        this.f30551b.setLayoutParams(layoutParams);
    }
}
