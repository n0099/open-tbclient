package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.r.b.d.b;
import a.a.a.a.r.b.d.c;
import a.a.a.a.v.c;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class KSNativeAdSingleImgAppDownloadView extends c {

    /* renamed from: a  reason: collision with root package name */
    public TextView f30572a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f30573b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30574c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30575d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f30576e;

    /* renamed from: f  reason: collision with root package name */
    public Button f30577f;

    /* renamed from: g  reason: collision with root package name */
    public float f30578g;

    public KSNativeAdSingleImgAppDownloadView(Context context) {
        this(context, null);
    }

    public KSNativeAdSingleImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdSingleImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30578g = 1.78f;
    }

    @Override // a.a.a.a.r.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        arrayList.add(this.f30577f);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        d.b("KSNativeAd Single getImageList: " + ksNativeAd.getImageList(), new Object[0]);
        if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
            KsImage ksImage = ksNativeAd.getImageList().get(0);
            d.b("KSNativeAd Single img: " + ksImage, new Object[0]);
            if (ksImage != null && ksImage.isValid()) {
                this.f30578g = (ksImage.getWidth() * 1.0f) / (ksImage.getHeight() * 1.0f);
                d.b("KSNativeAd Single img width: " + ksImage.getWidth() + ", height: " + ksImage.getHeight(), new Object[0]);
                c.a.f1346a.a(this, ksImage.getImageUrl(), this.f30573b);
            }
        }
        this.f30574c.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f30572a.setText(ksNativeAd.getAdDescription());
        if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            this.f30575d.setVisibility(8);
        } else {
            this.f30575d.setVisibility(0);
            Context context = getContext();
            String appIconUrl = ksNativeAd.getAppIconUrl();
            ImageView imageView = this.f30575d;
            if (context == null) {
                d.b("GlideHelper: context is null when load: " + appIconUrl, new Object[0]);
            } else if (context instanceof Activity) {
                Activity activity2 = (Activity) context;
                if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                    d.b("GlideHelper: activity is destroyed when load: " + appIconUrl, new Object[0]);
                } else {
                    Glide.with(activity2).load(appIconUrl).into(imageView);
                }
            } else {
                Glide.with(context).load(appIconUrl).into(imageView);
            }
        }
        this.f30576e.setText(ksNativeAd.getAppName());
        this.f30577f.setText(ksNativeAd.getActionDescription());
        ksNativeAd.setDownloadListener(new b(ksNativeAd.getActionDescription(), this.f30577f));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30572a = (TextView) findViewById(R.id.ad_description);
        this.f30573b = (ImageView) findViewById(R.id.ad_img);
        this.f30574c = (ImageView) findViewById(R.id.ad_logo);
        this.f30575d = (ImageView) findViewById(R.id.ad_app_icon);
        this.f30576e = (TextView) findViewById(R.id.ad_app_title);
        this.f30577f = (Button) findViewById(R.id.ad_app_download);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d.b("KSNativeAd onSizeChanged w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4, new Object[0]);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30573b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i5;
        layoutParams.height = (int) (((float) i5) / this.f30578g);
        d.b("KSNativeAd onSizeChanged width: " + layoutParams.width + ", height: " + layoutParams.height, new Object[0]);
        this.f30573b.setLayoutParams(layoutParams);
    }
}
