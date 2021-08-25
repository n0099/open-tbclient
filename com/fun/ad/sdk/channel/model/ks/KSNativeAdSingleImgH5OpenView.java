package com.fun.ad.sdk.channel.model.ks;

import a.a.a.a.s.b.d.c;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import b.a.a.a.x.c;
import b.a.a.a.x.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.R;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class KSNativeAdSingleImgH5OpenView extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f69819a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f69820b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f69821c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f69822d;

    /* renamed from: e  reason: collision with root package name */
    public Button f69823e;

    /* renamed from: f  reason: collision with root package name */
    public float f69824f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KSNativeAdSingleImgH5OpenView(Context context) {
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
    public KSNativeAdSingleImgH5OpenView(Context context, @Nullable AttributeSet attributeSet) {
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
    public KSNativeAdSingleImgH5OpenView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f69824f = 1.78f;
    }

    @Override // a.a.a.a.s.b.d.c
    public void a(Activity activity, KsNativeAd ksNativeAd, KsNativeAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, ksNativeAd, adInteractionListener) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            arrayList.add(this.f69823e);
            ksNativeAd.registerViewForInteraction(this, arrayList, adInteractionListener);
            d.f("KSNativeAd Single getImageList: " + ksNativeAd.getImageList(), new Object[0]);
            if (ksNativeAd.getImageList() != null && !ksNativeAd.getImageList().isEmpty()) {
                KsImage ksImage = ksNativeAd.getImageList().get(0);
                d.f("KSNativeAd Single img: " + ksImage, new Object[0]);
                if (ksImage != null && ksImage.isValid()) {
                    this.f69824f = (ksImage.getWidth() * 1.0f) / (ksImage.getHeight() * 1.0f);
                    d.f("KSNativeAd Single img width: " + ksImage.getWidth() + ", height: " + ksImage.getHeight(), new Object[0]);
                    c.a.f1485a.b(this, ksImage.getImageUrl(), this.f69820b);
                }
            }
            this.f69821c.setImageBitmap(ksNativeAd.getSdkLogo());
            this.f69819a.setText(ksNativeAd.getAdDescription());
            this.f69822d.setText(ksNativeAd.getAdSource());
            this.f69823e.setText(ksNativeAd.getActionDescription());
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f69819a = (TextView) findViewById(R.id.ad_description);
            this.f69820b = (ImageView) findViewById(R.id.ad_img);
            this.f69821c = (ImageView) findViewById(R.id.ad_logo);
            this.f69822d = (TextView) findViewById(R.id.ad_h5_description);
            this.f69823e = (Button) findViewById(R.id.ad_h5_open);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            d.f("KSNativeAd onSizeChanged w: " + i2 + ", h: " + i3 + ", oldw: " + i4 + ", oldh: " + i5, new Object[0]);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f69820b.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            layoutParams.width = i6;
            layoutParams.height = (int) (((float) i6) / this.f69824f);
            d.f("KSNativeAd onSizeChanged adView width: " + layoutParams.width + ", height: " + layoutParams.height, new Object[0]);
            this.f69820b.setLayoutParams(layoutParams);
        }
    }
}
