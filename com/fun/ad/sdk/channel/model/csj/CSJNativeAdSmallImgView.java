package com.fun.ad.sdk.channel.model.csj;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.module.csj.g0;
import java.util.List;
/* loaded from: classes7.dex */
public final class CSJNativeAdSmallImgView extends g0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView f;
    public float g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSJNativeAdSmallImgView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 1.78f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSJNativeAdSmallImgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = 1.78f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSJNativeAdSmallImgView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = 1.78f;
    }

    @Override // com.fun.module.csj.g0
    public void a(TTNativeAd tTNativeAd) {
        TTImage tTImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tTNativeAd) == null) {
            super.a(tTNativeAd);
            List imageList = tTNativeAd.getImageList();
            if (imageList == null || imageList.isEmpty() || (tTImage = (TTImage) imageList.get(0)) == null || !tTImage.isValid()) {
                return;
            }
            LogPrinter.e("CSJNativeAdView ttImage width: " + tTImage.getWidth() + ", height: " + tTImage.getHeight(), new Object[0]);
            this.g = (((float) tTImage.getWidth()) * 1.0f) / (((float) tTImage.getHeight()) * 1.0f);
            GlideHelper.get().load(getContext(), tTImage.getImageUrl(), this.f);
            LogPrinter.e("CSJNativeAdView ttImage url: " + tTImage.getImageUrl(), new Object[0]);
        }
    }

    @Override // com.fun.module.csj.g0, android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900ad);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
            layoutParams.width = i5;
            layoutParams.height = (int) (i5 / this.g);
            this.f.setLayoutParams(layoutParams);
        }
    }
}
