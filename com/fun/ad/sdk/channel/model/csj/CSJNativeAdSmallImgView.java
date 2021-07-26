package com.fun.ad.sdk.channel.model.csj;

import a.a.a.a.r.b.a.b;
import a.a.a.a.v.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.R;
import java.util.List;
/* loaded from: classes5.dex */
public final class CSJNativeAdSmallImgView extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f32882f;

    /* renamed from: g  reason: collision with root package name */
    public float f32883g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSJNativeAdSmallImgView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32883g = 1.78f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSJNativeAdSmallImgView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32883g = 1.78f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSJNativeAdSmallImgView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f32883g = 1.78f;
    }

    @Override // a.a.a.a.r.b.a.b
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        TTImage tTImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, tTNativeAd, adInteractionListener) == null) {
            super.a(activity, tTNativeAd, adInteractionListener);
            List<TTImage> imageList = tTNativeAd.getImageList();
            if (imageList == null || imageList.isEmpty() || (tTImage = imageList.get(0)) == null || !tTImage.isValid()) {
                return;
            }
            d.b("CSJNativeAdView ttImage width: " + tTImage.getWidth() + ", height: " + tTImage.getHeight(), new Object[0]);
            this.f32883g = (((float) tTImage.getWidth()) * 1.0f) / (((float) tTImage.getHeight()) * 1.0f);
            Context context = getContext();
            String imageUrl = tTImage.getImageUrl();
            ImageView imageView = this.f32882f;
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
            d.b("CSJNativeAdView ttImage url: " + tTImage.getImageUrl(), new Object[0]);
        }
    }

    @Override // a.a.a.a.r.b.a.b, android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f32882f = (ImageView) findViewById(R.id.ad_img);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f32882f.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            layoutParams.width = i6;
            layoutParams.height = (int) (i6 / this.f32883g);
            this.f32882f.setLayoutParams(layoutParams);
        }
    }
}
