package com.fun.ad.sdk.channel.model.csj;

import a.a.a.a.u.b.a.b;
import a.a.a.a.y.d;
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
/* loaded from: classes6.dex */
public final class CSJNativeAdGroupImgView extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f32574f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f32575g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f32576h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f32577i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSJNativeAdGroupImgView(Context context) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSJNativeAdGroupImgView(Context context, @Nullable AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSJNativeAdGroupImgView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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

    @Override // a.a.a.a.u.b.a.b
    public void a(Activity activity, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, tTNativeAd, adInteractionListener) == null) {
            super.a(activity, tTNativeAd, adInteractionListener);
            List<TTImage> imageList = tTNativeAd.getImageList();
            if (imageList == null || imageList.size() < 3) {
                return;
            }
            TTImage tTImage = imageList.get(0);
            if (tTImage != null && tTImage.isValid()) {
                Context context = getContext();
                String imageUrl = tTImage.getImageUrl();
                ImageView imageView = this.f32575g;
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
            TTImage tTImage2 = imageList.get(1);
            if (tTImage2 != null && tTImage2.isValid()) {
                Context context2 = getContext();
                String imageUrl2 = tTImage2.getImageUrl();
                ImageView imageView2 = this.f32576h;
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
            TTImage tTImage3 = imageList.get(2);
            if (tTImage3 == null || !tTImage3.isValid()) {
                return;
            }
            Context context3 = getContext();
            String imageUrl3 = tTImage3.getImageUrl();
            ImageView imageView3 = this.f32577i;
            if (context3 == null) {
                d.b("GlideHelper: context is null when load: " + imageUrl3, new Object[0]);
            } else if (context3 instanceof Activity) {
                Activity activity4 = (Activity) context3;
                if (!activity4.isFinishing() && (Build.VERSION.SDK_INT <= 17 || !activity4.isDestroyed())) {
                    Glide.with(activity4).load(imageUrl3).into(imageView3);
                    return;
                }
                d.b("GlideHelper: activity is destroyed when load: " + imageUrl3, new Object[0]);
            } else {
                Glide.with(context3).load(imageUrl3).into(imageView3);
            }
        }
    }

    @Override // a.a.a.a.u.b.a.b, android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f32574f = (LinearLayout) findViewById(R.id.ad_img_container);
            this.f32575g = (ImageView) findViewById(R.id.ad_img_1);
            this.f32576h = (ImageView) findViewById(R.id.ad_img_2);
            this.f32577i = (ImageView) findViewById(R.id.ad_img_3);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f32574f.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f32575g.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f32576h.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f32577i.getLayoutParams();
            layoutParams.width = i6;
            layoutParams.height = (int) (((((((i6 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.52f);
            this.f32574f.setLayoutParams(layoutParams);
        }
    }
}
