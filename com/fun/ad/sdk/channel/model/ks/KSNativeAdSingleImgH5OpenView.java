package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.u.b.d.c;
import a.a.a.a.y.c;
import a.a.a.a.y.d;
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
    public TextView f30860a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f30861b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30862c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30863d;

    /* renamed from: e  reason: collision with root package name */
    public Button f30864e;

    /* renamed from: f  reason: collision with root package name */
    public float f30865f;

    public KSNativeAdSingleImgH5OpenView(Context context) {
        this(context, null);
    }

    public KSNativeAdSingleImgH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdSingleImgH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30865f = 1.78f;
    }

    @Override // a.a.a.a.u.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        arrayList.add(this.f30864e);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        d.b("KSNativeAd Single getImageList: " + ksNativeAd.getImageList(), new Object[0]);
        if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
            KsImage ksImage = ksNativeAd.getImageList().get(0);
            d.b("KSNativeAd Single img: " + ksImage, new Object[0]);
            if (ksImage != null && ksImage.isValid()) {
                this.f30865f = (ksImage.getWidth() * 1.0f) / (ksImage.getHeight() * 1.0f);
                d.b("KSNativeAd Single img width: " + ksImage.getWidth() + ", height: " + ksImage.getHeight(), new Object[0]);
                c.a.f1369a.a(this, ksImage.getImageUrl(), this.f30861b);
            }
        }
        this.f30862c.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f30860a.setText(ksNativeAd.getAdDescription());
        this.f30863d.setText(ksNativeAd.getAdSource());
        this.f30864e.setText(ksNativeAd.getActionDescription());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30860a = (TextView) findViewById(R.id.ad_description);
        this.f30861b = (ImageView) findViewById(R.id.ad_img);
        this.f30862c = (ImageView) findViewById(R.id.ad_logo);
        this.f30863d = (TextView) findViewById(R.id.ad_h5_description);
        this.f30864e = (Button) findViewById(R.id.ad_h5_open);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        d.b("KSNativeAd onSizeChanged w: " + i2 + ", h: " + i3 + ", oldw: " + i4 + ", oldh: " + i5, new Object[0]);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30861b.getLayoutParams();
        int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i6;
        layoutParams.height = (int) (((float) i6) / this.f30865f);
        d.b("KSNativeAd onSizeChanged adView width: " + layoutParams.width + ", height: " + layoutParams.height, new Object[0]);
        this.f30861b.setLayoutParams(layoutParams);
    }
}
