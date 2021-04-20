package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.r.b.d.c;
import a.a.a.a.v.c;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class KSNativeAdSingleImgH5OpenView extends c {

    /* renamed from: a  reason: collision with root package name */
    public TextView f30484a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f30485b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30486c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30487d;

    /* renamed from: e  reason: collision with root package name */
    public Button f30488e;

    /* renamed from: f  reason: collision with root package name */
    public float f30489f;

    public KSNativeAdSingleImgH5OpenView(Context context) {
        this(context, null);
    }

    public KSNativeAdSingleImgH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdSingleImgH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30489f = 1.78f;
    }

    @Override // a.a.a.a.r.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        arrayList.add(this.f30488e);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        d.b("KSNativeAd Single getImageList: " + ksNativeAd.getImageList(), new Object[0]);
        if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
            KsImage ksImage = ksNativeAd.getImageList().get(0);
            d.b("KSNativeAd Single img: " + ksImage, new Object[0]);
            if (ksImage != null && ksImage.isValid()) {
                this.f30489f = (ksImage.getWidth() * 1.0f) / (ksImage.getHeight() * 1.0f);
                d.b("KSNativeAd Single img width: " + ksImage.getWidth() + ", height: " + ksImage.getHeight(), new Object[0]);
                c.a.f1346a.a(this, ksImage.getImageUrl(), this.f30485b);
            }
        }
        this.f30486c.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f30484a.setText(ksNativeAd.getAdDescription());
        this.f30487d.setText(ksNativeAd.getAdSource());
        this.f30488e.setText(ksNativeAd.getActionDescription());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30484a = (TextView) findViewById(R.id.ad_description);
        this.f30485b = (ImageView) findViewById(R.id.ad_img);
        this.f30486c = (ImageView) findViewById(R.id.ad_logo);
        this.f30487d = (TextView) findViewById(R.id.ad_h5_description);
        this.f30488e = (Button) findViewById(R.id.ad_h5_open);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d.b("KSNativeAd onSizeChanged w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4, new Object[0]);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30485b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (((float) i5) / this.f30489f);
        d.b("KSNativeAd onSizeChanged adView width: " + layoutParams.width + ", height: " + layoutParams.height, new Object[0]);
        this.f30485b.setLayoutParams(layoutParams);
    }
}
