package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.s.b.d.c;
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
import b.a.a.a.t.b.d.b;
import b.a.a.a.x.d;
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
import java.util.List;
/* loaded from: classes9.dex */
public class KSNativeAdGroupImgAppDownloadView extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f69795a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f69796b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f69797c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f69798d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f69799e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f69800f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f69801g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f69802h;

    /* renamed from: i  reason: collision with root package name */
    public Button f69803i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSNativeAdGroupImgAppDownloadView(Context context) {
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
    public KSNativeAdGroupImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
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
    public KSNativeAdGroupImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
    }

    @Override // a.a.a.a.s.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, ksNativeAd, adInteractionListener) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            arrayList.add(this.f69803i);
            ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
            List<KsImage> imageList = ksNativeAd.getImageList();
            if (imageList != null && imageList.size() >= 3) {
                KsImage ksImage = imageList.get(0);
                if (ksImage != null && ksImage.isValid()) {
                    Context context = getContext();
                    String imageUrl = ksImage.getImageUrl();
                    ImageView imageView = this.f69797c;
                    if (context == null) {
                        d.f("GlideHelper: context is null when load: " + imageUrl, new Object[0]);
                    } else if (context instanceof Activity) {
                        Activity activity2 = (Activity) context;
                        if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                            d.f("GlideHelper: activity is destroyed when load: " + imageUrl, new Object[0]);
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
                    ImageView imageView2 = this.f69798d;
                    if (context2 == null) {
                        d.f("GlideHelper: context is null when load: " + imageUrl2, new Object[0]);
                    } else if (context2 instanceof Activity) {
                        Activity activity3 = (Activity) context2;
                        if (activity3.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity3.isDestroyed())) {
                            d.f("GlideHelper: activity is destroyed when load: " + imageUrl2, new Object[0]);
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
                    ImageView imageView3 = this.f69799e;
                    if (context3 == null) {
                        d.f("GlideHelper: context is null when load: " + imageUrl3, new Object[0]);
                    } else if (context3 instanceof Activity) {
                        Activity activity4 = (Activity) context3;
                        if (activity4.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity4.isDestroyed())) {
                            d.f("GlideHelper: activity is destroyed when load: " + imageUrl3, new Object[0]);
                        } else {
                            Glide.with(activity4).load(imageUrl3).into(imageView3);
                        }
                    } else {
                        Glide.with(context3).load(imageUrl3).into(imageView3);
                    }
                }
            }
            this.f69800f.setImageBitmap(ksNativeAd.getSdkLogo());
            this.f69795a.setText(ksNativeAd.getAdDescription());
            if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
                this.f69801g.setVisibility(8);
            } else {
                this.f69801g.setVisibility(0);
                Context context4 = getContext();
                String appIconUrl = ksNativeAd.getAppIconUrl();
                ImageView imageView4 = this.f69801g;
                if (context4 == null) {
                    d.f("GlideHelper: context is null when load: " + appIconUrl, new Object[0]);
                } else if (context4 instanceof Activity) {
                    Activity activity5 = (Activity) context4;
                    if (activity5.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity5.isDestroyed())) {
                        d.f("GlideHelper: activity is destroyed when load: " + appIconUrl, new Object[0]);
                    } else {
                        Glide.with(activity5).load(appIconUrl).into(imageView4);
                    }
                } else {
                    Glide.with(context4).load(appIconUrl).into(imageView4);
                }
            }
            this.f69802h.setText(ksNativeAd.getAppName());
            this.f69803i.setText(ksNativeAd.getActionDescription());
            ksNativeAd.setDownloadListener(new b(ksNativeAd.getActionDescription(), this.f69803i));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f69795a = (TextView) findViewById(R.id.ad_description);
            this.f69796b = (LinearLayout) findViewById(R.id.ad_img_container);
            this.f69797c = (ImageView) findViewById(R.id.ad_img_1);
            this.f69798d = (ImageView) findViewById(R.id.ad_img_2);
            this.f69799e = (ImageView) findViewById(R.id.ad_img_3);
            this.f69800f = (ImageView) findViewById(R.id.ad_logo);
            this.f69801g = (ImageView) findViewById(R.id.ad_app_icon);
            this.f69802h = (TextView) findViewById(R.id.ad_app_title);
            this.f69803i = (Button) findViewById(R.id.ad_app_download);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f69796b.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f69797c.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f69798d.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f69799e.getLayoutParams();
            layoutParams.width = i6;
            layoutParams.height = (int) (((((((i6 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.5f);
            this.f69796b.setLayoutParams(layoutParams);
        }
    }
}
