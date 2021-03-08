package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.r.b.e.c;
import a.a.a.a.v.d;
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
/* loaded from: classes4.dex */
public class KSNativeAdGroupImgH5OpenView extends c {

    /* renamed from: a  reason: collision with root package name */
    public TextView f5236a;
    public LinearLayout b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public Button h;

    public KSNativeAdGroupImgH5OpenView(Context context) {
        this(context, null);
    }

    public KSNativeAdGroupImgH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSNativeAdGroupImgH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // a.a.a.a.r.b.e.c
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
                ImageView imageView = this.c;
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
                ImageView imageView2 = this.d;
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
                ImageView imageView3 = this.e;
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
        this.f.setImageBitmap(ksNativeAd.getSdkLogo());
        this.f5236a.setText(ksNativeAd.getAdDescription());
        this.g.setText(ksNativeAd.getAdSource());
        this.h.setText(ksNativeAd.getActionDescription());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f5236a = (TextView) findViewById(R.id.ad_description);
        this.b = (LinearLayout) findViewById(R.id.ad_img_container);
        this.c = (ImageView) findViewById(R.id.ad_img_1);
        this.d = (ImageView) findViewById(R.id.ad_img_2);
        this.e = (ImageView) findViewById(R.id.ad_img_3);
        this.f = (ImageView) findViewById(R.id.ad_logo);
        this.g = (TextView) findViewById(R.id.ad_h5_description);
        this.h = (Button) findViewById(R.id.ad_h5_open);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
        int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams.width = i5;
        layoutParams.height = (int) (((((((i5 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.5f);
        this.b.setLayoutParams(layoutParams);
    }
}
