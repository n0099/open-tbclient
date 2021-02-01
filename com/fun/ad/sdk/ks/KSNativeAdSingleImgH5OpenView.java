package com.fun.ad.sdk.ks;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fun.ad.ai;
import com.fun.ad.ap;
import com.fun.ad.m;
import com.fun.ad.o1;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class KSNativeAdSingleImgH5OpenView extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public TextView f7833a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f7834b;
    public TextView c;
    public Button d;
    public float e;

    public KSNativeAdSingleImgH5OpenView(Context context) {
        this(context, null);
    }

    public KSNativeAdSingleImgH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdSingleImgH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 1.78f;
    }

    @Override // com.fun.ad.o1
    public void a(Activity activity, String str, String str2, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        m.a("KSNativeAd Single getImageList: " + ksNativeAd.getImageList());
        if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
            KsImage ksImage = ksNativeAd.getImageList().get(0);
            m.a("KSNativeAd Single img: " + ksImage);
            if (ksImage != null && ksImage.isValid()) {
                this.e = (ksImage.getWidth() * 1.0f) / (ksImage.getHeight() * 1.0f);
                m.a("KSNativeAd Single img width: " + ksImage.getWidth() + ", height: " + ksImage.getHeight());
                ap.a.pPq.a(this, ksImage.getImageUrl(), this.f7834b);
            }
        }
        this.f7833a.setText(ksNativeAd.getAdDescription());
        this.c.setText(ksNativeAd.getAdSource());
        this.d.setText(ksNativeAd.getActionDescription());
        ksNativeAd.setDownloadListener(new ai(ksNativeAd, this.d, str, FunAdType.KS_NATIVE, str2));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f7833a = (TextView) findViewById(R.id.ad_description);
        this.f7834b = (ImageView) findViewById(R.id.ad_img);
        ImageView imageView = (ImageView) findViewById(R.id.ad_logo);
        this.c = (TextView) findViewById(R.id.ad_h5_description);
        this.d = (Button) findViewById(R.id.ad_h5_open);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m.a("KSNativeAd onSizeChanged w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7834b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.e);
        m.a("KSNativeAd onSizeChanged adView width: " + layoutParams.width + ", height: " + layoutParams.height);
        this.f7834b.setLayoutParams(layoutParams);
    }
}
