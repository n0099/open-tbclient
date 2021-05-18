package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.t.b.d.c;
import a.a.a.a.x.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
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
public class KSNativeAdGroupImgH5OpenView extends c {

    /* renamed from: a  reason: collision with root package name */
    public TextView f30743a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f30744b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f30745c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30746d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f30747e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f30748f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f30749g;

    /* renamed from: h  reason: collision with root package name */
    public Button f30750h;

    public KSNativeAdGroupImgH5OpenView(Context context) {
        this(context, null);
    }

    public KSNativeAdGroupImgH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdGroupImgH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // a.a.a.a.t.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
        List<KsImage> imageList = ksNativeAd.getImageList();
        if (imageList != null && imageList.size() >= 3) {
            KsImage ksImage = imageList.get(0);
            if (ksImage != null && ksImage.isValid()) {
                Context context = getContext();
                String imageUrl = ksImage.getImageUrl();
                ImageView imageView = this.f30745c;
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
                ImageView imageView2 = this.f30746d;
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
                ImageView imageView3 = this.f30747e;
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
        this.f30748f.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f30743a.setText(ksNativeAd.getAdDescription());
        this.f30749g.setText(ksNativeAd.getAdSource());
        this.f30750h.setText(ksNativeAd.getActionDescription());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f30743a = (TextView) findViewById(R.id.ad_description);
        this.f30744b = (LinearLayout) findViewById(R.id.ad_img_container);
        this.f30745c = (ImageView) findViewById(R.id.ad_img_1);
        this.f30746d = (ImageView) findViewById(R.id.ad_img_2);
        this.f30747e = (ImageView) findViewById(R.id.ad_img_3);
        this.f30748f = (ImageView) findViewById(R.id.ad_logo);
        this.f30749g = (TextView) findViewById(R.id.ad_h5_description);
        this.f30750h = (Button) findViewById(R.id.ad_h5_open);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30744b.getLayoutParams();
        int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f30745c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f30746d.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f30747e.getLayoutParams();
        layoutParams.width = i6;
        layoutParams.height = (int) (((((((i6 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.5f);
        this.f30744b.setLayoutParams(layoutParams);
    }
}
