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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class KSNativeAdSingleImgAppDownloadView extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f32923a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32924b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f32925c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f32926d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f32927e;

    /* renamed from: f  reason: collision with root package name */
    public Button f32928f;

    /* renamed from: g  reason: collision with root package name */
    public float f32929g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSNativeAdSingleImgAppDownloadView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSNativeAdSingleImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSNativeAdSingleImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f32929g = 1.78f;
    }

    @Override // a.a.a.a.r.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, ksNativeAd, adInteractionListener) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            arrayList.add(this.f32928f);
            ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
            d.b("KSNativeAd Single getImageList: " + ksNativeAd.getImageList(), new Object[0]);
            if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
                KsImage ksImage = ksNativeAd.getImageList().get(0);
                d.b("KSNativeAd Single img: " + ksImage, new Object[0]);
                if (ksImage != null && ksImage.isValid()) {
                    this.f32929g = (ksImage.getWidth() * 1.0f) / (ksImage.getHeight() * 1.0f);
                    d.b("KSNativeAd Single img width: " + ksImage.getWidth() + ", height: " + ksImage.getHeight(), new Object[0]);
                    c.a.f1397a.a(this, ksImage.getImageUrl(), this.f32924b);
                }
            }
            this.f32925c.setImageBitmap(ksNativeAd.getSdkLogo());
            this.f32923a.setText(ksNativeAd.getAdDescription());
            if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
                this.f32926d.setVisibility(8);
            } else {
                this.f32926d.setVisibility(0);
                Context context = getContext();
                String appIconUrl = ksNativeAd.getAppIconUrl();
                ImageView imageView = this.f32926d;
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
            this.f32927e.setText(ksNativeAd.getAppName());
            this.f32928f.setText(ksNativeAd.getActionDescription());
            ksNativeAd.setDownloadListener(new b(ksNativeAd.getActionDescription(), this.f32928f));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f32923a = (TextView) findViewById(R.id.ad_description);
            this.f32924b = (ImageView) findViewById(R.id.ad_img);
            this.f32925c = (ImageView) findViewById(R.id.ad_logo);
            this.f32926d = (ImageView) findViewById(R.id.ad_app_icon);
            this.f32927e = (TextView) findViewById(R.id.ad_app_title);
            this.f32928f = (Button) findViewById(R.id.ad_app_download);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            d.b("KSNativeAd onSizeChanged w: " + i2 + ", h: " + i3 + ", oldw: " + i4 + ", oldh: " + i5, new Object[0]);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f32924b.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            layoutParams.width = i6;
            layoutParams.height = (int) (((float) i6) / this.f32929g);
            d.b("KSNativeAd onSizeChanged width: " + layoutParams.width + ", height: " + layoutParams.height, new Object[0]);
            this.f32924b.setLayoutParams(layoutParams);
        }
    }
}
