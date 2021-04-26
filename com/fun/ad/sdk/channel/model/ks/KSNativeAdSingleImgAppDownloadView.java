package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.t.b.d.b;
import a.a.a.a.t.b.d.c;
import a.a.a.a.x.c;
import a.a.a.a.x.d;
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
    public TextView f31506a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f31507b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f31508c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f31509d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31510e;

    /* renamed from: f  reason: collision with root package name */
    public Button f31511f;

    /* renamed from: g  reason: collision with root package name */
    public float f31512g;

    public KSNativeAdSingleImgAppDownloadView(Context context) {
        this(context, null);
    }

    public KSNativeAdSingleImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdSingleImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f31512g = 1.78f;
    }

    @Override // a.a.a.a.t.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        arrayList.add(this.f31511f);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        d.b("KSNativeAd Single getImageList: " + ksNativeAd.getImageList(), new Object[0]);
        if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
            KsImage ksImage = ksNativeAd.getImageList().get(0);
            d.b("KSNativeAd Single img: " + ksImage, new Object[0]);
            if (ksImage != null && ksImage.isValid()) {
                this.f31512g = (ksImage.getWidth() * 1.0f) / (ksImage.getHeight() * 1.0f);
                d.b("KSNativeAd Single img width: " + ksImage.getWidth() + ", height: " + ksImage.getHeight(), new Object[0]);
                c.a.f1361a.a(this, ksImage.getImageUrl(), this.f31507b);
            }
        }
        this.f31508c.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f31506a.setText(ksNativeAd.getAdDescription());
        if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            this.f31509d.setVisibility(8);
        } else {
            this.f31509d.setVisibility(0);
            Context context = getContext();
            String appIconUrl = ksNativeAd.getAppIconUrl();
            ImageView imageView = this.f31509d;
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
        this.f31510e.setText(ksNativeAd.getAppName());
        this.f31511f.setText(ksNativeAd.getActionDescription());
        ksNativeAd.setDownloadListener(new b(ksNativeAd.getActionDescription(), this.f31511f));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f31506a = (TextView) findViewById(R.id.ad_description);
        this.f31507b = (ImageView) findViewById(R.id.ad_img);
        this.f31508c = (ImageView) findViewById(R.id.ad_logo);
        this.f31509d = (ImageView) findViewById(R.id.ad_app_icon);
        this.f31510e = (TextView) findViewById(R.id.ad_app_title);
        this.f31511f = (Button) findViewById(R.id.ad_app_download);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        d.b("KSNativeAd onSizeChanged w: " + i2 + ", h: " + i3 + ", oldw: " + i4 + ", oldh: " + i5, new Object[0]);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f31507b.getLayoutParams();
        int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
        layoutParams.width = i6;
        layoutParams.height = (int) (((float) i6) / this.f31512g);
        d.b("KSNativeAd onSizeChanged width: " + layoutParams.width + ", height: " + layoutParams.height, new Object[0]);
        this.f31507b.setLayoutParams(layoutParams);
    }
}
