package com.fun.ad.sdk.channel.model.ks;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.module.ks.x;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class KSNativeAdGroupImgH5OpenView extends x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public LinearLayout c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public TextView h;
    public Button i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSNativeAdGroupImgH5OpenView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KSNativeAdGroupImgH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0900a5);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0900b5);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900b2);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900b3);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900b4);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900e1);
            this.h = (TextView) findViewById(R.id.ad_h5_description);
            this.i = (Button) findViewById(R.id.ad_h5_open);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.e.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            layoutParams.width = i5;
            layoutParams.height = (int) (((((((i5 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.5f);
            this.c.setLayoutParams(layoutParams);
        }
    }

    @Override // com.fun.module.ks.x
    public void a(KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksNativeAd) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            this.a.clear();
            this.a.addAll(arrayList);
            List<KsImage> imageList = ksNativeAd.getImageList();
            if (imageList != null && imageList.size() >= 3) {
                KsImage ksImage = imageList.get(0);
                if (ksImage != null && ksImage.isValid()) {
                    GlideHelper.get().load(getContext(), ksImage.getImageUrl(), this.d);
                }
                KsImage ksImage2 = imageList.get(1);
                if (ksImage2 != null && ksImage2.isValid()) {
                    GlideHelper.get().load(getContext(), ksImage2.getImageUrl(), this.e);
                }
                KsImage ksImage3 = imageList.get(2);
                if (ksImage3 != null && ksImage3.isValid()) {
                    GlideHelper.get().load(getContext(), ksImage3.getImageUrl(), this.f);
                }
            }
            this.g.setImageBitmap(getSdkLogo());
            this.b.setText(ksNativeAd.getAdDescription());
            String adSource = ksNativeAd.getAdSource();
            if (TextUtils.isEmpty(adSource)) {
                adSource = "快手广告";
            }
            this.h.setText(adSource);
            this.i.setText(ksNativeAd.getActionDescription());
        }
    }
}
