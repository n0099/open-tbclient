package com.fun.ad.sdk.ks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
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
/* loaded from: classes15.dex */
public class KSNativeAdSingleImgAppDownloadView extends o1 {

    /* renamed from: a  reason: collision with root package name */
    public TextView f8129a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f8130b;
    public ImageView c;
    public ImageView d;
    public TextView e;
    public Button f;
    public float g;

    public KSNativeAdSingleImgAppDownloadView(Context context) {
        this(context, null);
    }

    public KSNativeAdSingleImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdSingleImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 1.78f;
    }

    @Override // com.fun.ad.o1
    public void a(Activity activity, String str, String str2, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        arrayList.add(this.f);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        m.a("KSNativeAd Single getImageList: " + ksNativeAd.getImageList());
        if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
            KsImage ksImage = ksNativeAd.getImageList().get(0);
            m.a("KSNativeAd Single img: " + ksImage);
            if (ksImage != null && ksImage.isValid()) {
                this.g = (ksImage.getWidth() * 1.0f) / (ksImage.getHeight() * 1.0f);
                m.a("KSNativeAd Single img width: " + ksImage.getWidth() + ", height: " + ksImage.getHeight());
                ap.a.pJL.a(this, ksImage.getImageUrl(), this.f8130b);
            }
        }
        this.c.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f8129a.setText(ksNativeAd.getAdDescription());
        if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
            ap.a.pJL.a(getContext(), ksNativeAd.getAppIconUrl(), this.d);
        }
        this.e.setText(ksNativeAd.getAppName());
        this.f.setText(ksNativeAd.getActionDescription());
        ksNativeAd.setDownloadListener(new ai(ksNativeAd, this.f, str, FunAdType.KS_NATIVE, str2));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f8129a = (TextView) findViewById(R.id.ad_description);
        this.f8130b = (ImageView) findViewById(R.id.ad_img);
        this.c = (ImageView) findViewById(R.id.ad_logo);
        this.d = (ImageView) findViewById(R.id.ad_app_icon);
        this.e = (TextView) findViewById(R.id.ad_app_title);
        this.f = (Button) findViewById(R.id.ad_app_download);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m.a("KSNativeAd onSizeChanged w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8130b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (i5 / this.g);
        m.a("KSNativeAd onSizeChanged width: " + layoutParams.width + ", height: " + layoutParams.height);
        this.f8130b.setLayoutParams(layoutParams);
    }
}
