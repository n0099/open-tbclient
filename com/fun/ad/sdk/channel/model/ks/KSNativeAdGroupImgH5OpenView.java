package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.s.b.d.c;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
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
public class KSNativeAdGroupImgH5OpenView extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f69604a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f69605b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f69606c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f69607d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f69608e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f69609f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f69610g;

    /* renamed from: h  reason: collision with root package name */
    public Button f69611h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSNativeAdGroupImgH5OpenView(Context context) {
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
    public KSNativeAdGroupImgH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
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
    public KSNativeAdGroupImgH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
            ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
            List<KsImage> imageList = ksNativeAd.getImageList();
            if (imageList != null && imageList.size() >= 3) {
                KsImage ksImage = imageList.get(0);
                if (ksImage != null && ksImage.isValid()) {
                    Context context = getContext();
                    String imageUrl = ksImage.getImageUrl();
                    ImageView imageView = this.f69606c;
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
                    ImageView imageView2 = this.f69607d;
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
                    ImageView imageView3 = this.f69608e;
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
            this.f69609f.setImageBitmap(ksNativeAd.getSdkLogo());
            this.f69604a.setText(ksNativeAd.getAdDescription());
            this.f69610g.setText(ksNativeAd.getAdSource());
            this.f69611h.setText(ksNativeAd.getActionDescription());
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f69604a = (TextView) findViewById(R.id.ad_description);
            this.f69605b = (LinearLayout) findViewById(R.id.ad_img_container);
            this.f69606c = (ImageView) findViewById(R.id.ad_img_1);
            this.f69607d = (ImageView) findViewById(R.id.ad_img_2);
            this.f69608e = (ImageView) findViewById(R.id.ad_img_3);
            this.f69609f = (ImageView) findViewById(R.id.ad_logo);
            this.f69610g = (TextView) findViewById(R.id.ad_h5_description);
            this.f69611h = (Button) findViewById(R.id.ad_h5_open);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f69605b.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f69606c.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f69607d.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f69608e.getLayoutParams();
            layoutParams.width = i6;
            layoutParams.height = (int) (((((((i6 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.5f);
            this.f69605b.setLayoutParams(layoutParams);
        }
    }
}
