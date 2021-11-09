package com.fun.ad.sdk.channel.model.ks;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import b.g.a0.d.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.channel.ks.R;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.module.ks.w;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class KSNativeAdSingleImgAppDownloadView extends w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f62794b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f62795c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f62796d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f62797e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62798f;

    /* renamed from: g  reason: collision with root package name */
    public Button f62799g;

    /* renamed from: h  reason: collision with root package name */
    public float f62800h;

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
        this.f62800h = 1.78f;
    }

    @Override // com.fun.module.ks.w
    public void a(KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksNativeAd) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            arrayList.add(this.f62799g);
            this.f62883a.clear();
            this.f62883a.addAll(arrayList);
            LogPrinter.e("KSNativeAd Single getImageList: " + ksNativeAd.getImageList(), new Object[0]);
            if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
                KsImage ksImage = ksNativeAd.getImageList().get(0);
                LogPrinter.e("KSNativeAd Single img: " + ksImage, new Object[0]);
                if (ksImage != null && ksImage.isValid()) {
                    this.f62800h = (ksImage.getWidth() * 1.0f) / (ksImage.getHeight() * 1.0f);
                    LogPrinter.e("KSNativeAd Single img width: " + ksImage.getWidth() + ", height: " + ksImage.getHeight(), new Object[0]);
                    GlideHelper.get().load(this, ksImage.getImageUrl(), this.f62795c);
                }
            }
            this.f62796d.setImageBitmap(getSdkLogo());
            this.f62794b.setText(ksNativeAd.getAdDescription());
            if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
                this.f62797e.setVisibility(8);
            } else {
                this.f62797e.setVisibility(0);
                GlideHelper.get().load(getContext(), ksNativeAd.getAppIconUrl(), this.f62797e);
            }
            this.f62798f.setText(ksNativeAd.getAppName());
            this.f62799g.setText(ksNativeAd.getActionDescription());
            ksNativeAd.setDownloadListener(new x(ksNativeAd.getActionDescription(), this.f62799g));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f62794b = (TextView) findViewById(R.id.ad_description);
            this.f62795c = (ImageView) findViewById(R.id.ad_img);
            this.f62796d = (ImageView) findViewById(R.id.ad_logo);
            this.f62797e = (ImageView) findViewById(R.id.ad_app_icon);
            this.f62798f = (TextView) findViewById(R.id.ad_app_title);
            this.f62799g = (Button) findViewById(R.id.ad_app_download);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            LogPrinter.e("KSNativeAd onSizeChanged w: " + i2 + ", h: " + i3 + ", oldw: " + i4 + ", oldh: " + i5, new Object[0]);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f62795c.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            layoutParams.width = i6;
            layoutParams.height = (int) (((float) i6) / this.f62800h);
            LogPrinter.e("KSNativeAd onSizeChanged width: " + layoutParams.width + ", height: " + layoutParams.height, new Object[0]);
            this.f62795c.setLayoutParams(layoutParams);
        }
    }
}
