package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.r.b.e.b;
import a.a.a.a.r.b.e.c;
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
import java.util.List;
/* loaded from: classes6.dex */
public class KSNativeAdGroupImgAppDownloadView extends c {

    /* renamed from: a  reason: collision with root package name */
    public TextView f30787a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f30788b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30789c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30790d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f30791e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f30792f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f30793g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f30794h;
    public Button i;

    public KSNativeAdGroupImgAppDownloadView(Context context) {
        this(context, null);
    }

    public KSNativeAdGroupImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdGroupImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // a.a.a.a.r.b.e.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        arrayList.add(this.i);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        List<KsImage> imageList = ksNativeAd.getImageList();
        if (imageList != null && imageList.size() >= 3) {
            KsImage ksImage = imageList.get(0);
            if (ksImage != null && ksImage.isValid()) {
                Context context = getContext();
                String imageUrl = ksImage.getImageUrl();
                ImageView imageView = this.f30789c;
                if (context == null) {
                    d.b("GlideHelper: context is null when load: " + imageUrl, new Object[0]);
                } else if (context instanceof Activity) {
                    Activity activity2 = (Activity) context;
                    if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                        d.b("GlideHelper: activity is destroyed when load: " + imageUrl, new Object[0]);
                    } else {
                        Glide.with(activity2).load(imageUrl).into(imageView);
                    }
                } else {
                    Glide.with(context).load(imageUrl).into(imageView);
                }
            }
            KsImage ksImage2 = imageList.get(1);
            if (ksImage2 != null && ksImage2.isValid()) {
                Context context2 = getContext();
                String imageUrl2 = ksImage2.getImageUrl();
                ImageView imageView2 = this.f30790d;
                if (context2 == null) {
                    d.b("GlideHelper: context is null when load: " + imageUrl2, new Object[0]);
                } else if (context2 instanceof Activity) {
                    Activity activity3 = (Activity) context2;
                    if (activity3.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity3.isDestroyed())) {
                        d.b("GlideHelper: activity is destroyed when load: " + imageUrl2, new Object[0]);
                    } else {
                        Glide.with(activity3).load(imageUrl2).into(imageView2);
                    }
                } else {
                    Glide.with(context2).load(imageUrl2).into(imageView2);
                }
            }
            KsImage ksImage3 = imageList.get(2);
            if (ksImage3 != null && ksImage3.isValid()) {
                Context context3 = getContext();
                String imageUrl3 = ksImage3.getImageUrl();
                ImageView imageView3 = this.f30791e;
                if (context3 == null) {
                    d.b("GlideHelper: context is null when load: " + imageUrl3, new Object[0]);
                } else if (context3 instanceof Activity) {
                    Activity activity4 = (Activity) context3;
                    if (activity4.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity4.isDestroyed())) {
                        d.b("GlideHelper: activity is destroyed when load: " + imageUrl3, new Object[0]);
                    } else {
                        Glide.with(activity4).load(imageUrl3).into(imageView3);
                    }
                } else {
                    Glide.with(context3).load(imageUrl3).into(imageView3);
                }
            }
        }
        this.f30792f.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f30787a.setText(ksNativeAd.getAdDescription());
        if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            this.f30793g.setVisibility(8);
        } else {
            this.f30793g.setVisibility(0);
            Context context4 = getContext();
            String appIconUrl = ksNativeAd.getAppIconUrl();
            ImageView imageView4 = this.f30793g;
            if (context4 == null) {
                d.b("GlideHelper: context is null when load: " + appIconUrl, new Object[0]);
            } else if (context4 instanceof Activity) {
                Activity activity5 = (Activity) context4;
                if (activity5.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity5.isDestroyed())) {
                    d.b("GlideHelper: activity is destroyed when load: " + appIconUrl, new Object[0]);
                } else {
                    Glide.with(activity5).load(appIconUrl).into(imageView4);
                }
            } else {
                Glide.with(context4).load(appIconUrl).into(imageView4);
            }
        }
        this.f30794h.setText(ksNativeAd.getAppName());
        this.i.setText(ksNativeAd.getActionDescription());
        ksNativeAd.setDownloadListener(new b(ksNativeAd.getActionDescription(), this.i));
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30787a = (TextView) findViewById(R.id.ad_description);
        this.f30788b = (LinearLayout) findViewById(R.id.ad_img_container);
        this.f30789c = (ImageView) findViewById(R.id.ad_img_1);
        this.f30790d = (ImageView) findViewById(R.id.ad_img_2);
        this.f30791e = (ImageView) findViewById(R.id.ad_img_3);
        this.f30792f = (ImageView) findViewById(R.id.ad_logo);
        this.f30793g = (ImageView) findViewById(R.id.ad_app_icon);
        this.f30794h = (TextView) findViewById(R.id.ad_app_title);
        this.i = (Button) findViewById(R.id.ad_app_download);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30788b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f30789c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f30790d.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f30791e.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = (int) (((((((i5 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.5f);
        this.f30788b.setLayoutParams(layoutParams);
    }
}
