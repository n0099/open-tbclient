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
import com.baidu.tieba.rqb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.module.ks.y;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class KSNativeAdSingleImgAppDownloadView extends y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public TextView f;
    public Button g;
    public TextView h;
    public float i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSNativeAdSingleImgAppDownloadView(Context context) {
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
    public KSNativeAdSingleImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet) {
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
    public KSNativeAdSingleImgAppDownloadView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.i = 1.78f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f0900b2);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900bf);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f0900ef);
            this.h = (TextView) findViewById(R.id.ad_app_source);
            this.e = (ImageView) findViewById(R.id.ad_app_icon);
            this.f = (TextView) findViewById(R.id.ad_app_title);
            this.g = (Button) findViewById(R.id.ad_app_download);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            LogPrinter.e("KSNativeAd onSizeChanged w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4, new Object[0]);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
            int i5 = (i - layoutParams.leftMargin) - layoutParams.rightMargin;
            layoutParams.width = i5;
            layoutParams.height = (int) (((float) i5) / this.i);
            LogPrinter.e("KSNativeAd onSizeChanged width: " + layoutParams.width + ", height: " + layoutParams.height, new Object[0]);
            this.c.setLayoutParams(layoutParams);
        }
    }

    @Override // com.fun.module.ks.y
    public void a(KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksNativeAd) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            arrayList.add(this.g);
            this.a.clear();
            this.a.addAll(arrayList);
            LogPrinter.e("KSNativeAd Single getImageList: " + ksNativeAd.getImageList(), new Object[0]);
            if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
                KsImage ksImage = ksNativeAd.getImageList().get(0);
                LogPrinter.e("KSNativeAd Single img: " + ksImage, new Object[0]);
                if (ksImage != null && ksImage.isValid()) {
                    this.i = (ksImage.getWidth() * 1.0f) / (ksImage.getHeight() * 1.0f);
                    LogPrinter.e("KSNativeAd Single img width: " + ksImage.getWidth() + ", height: " + ksImage.getHeight(), new Object[0]);
                    GlideHelper.get().load(this, ksImage.getImageUrl(), this.c);
                }
            }
            this.d.setImageBitmap(getSdkLogo());
            this.b.setText(ksNativeAd.getAdDescription());
            String adSource = ksNativeAd.getAdSource();
            if (TextUtils.isEmpty(adSource)) {
                adSource = "快手广告";
            }
            this.h.setText(adSource);
            if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                GlideHelper.get().load(getContext(), ksNativeAd.getAppIconUrl(), this.e);
            }
            this.f.setText(ksNativeAd.getAppName());
            this.g.setText(ksNativeAd.getActionDescription());
            ksNativeAd.setDownloadListener(new rqb(ksNativeAd.getActionDescription(), this.g));
        }
    }
}
