package com.fun.ad.sdk.channel.model.ks;

import android.content.Context;
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
import com.fun.ad.sdk.channel.ks.R;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.module.ks.w;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class KSNativeAdGroupImgH5OpenView extends w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63686b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f63687c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f63688d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f63689e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f63690f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f63691g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63692h;

    /* renamed from: i  reason: collision with root package name */
    public Button f63693i;

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

    @Override // com.fun.module.ks.w
    public void a(KsNativeAd ksNativeAd) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ksNativeAd) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            this.f63783a.clear();
            this.f63783a.addAll(arrayList);
            List<KsImage> imageList = ksNativeAd.getImageList();
            if (imageList != null && imageList.size() >= 3) {
                KsImage ksImage = imageList.get(0);
                if (ksImage != null && ksImage.isValid()) {
                    GlideHelper.get().load(getContext(), ksImage.getImageUrl(), this.f63688d);
                }
                KsImage ksImage2 = imageList.get(1);
                if (ksImage2 != null && ksImage2.isValid()) {
                    GlideHelper.get().load(getContext(), ksImage2.getImageUrl(), this.f63689e);
                }
                KsImage ksImage3 = imageList.get(2);
                if (ksImage3 != null && ksImage3.isValid()) {
                    GlideHelper.get().load(getContext(), ksImage3.getImageUrl(), this.f63690f);
                }
            }
            this.f63691g.setImageBitmap(getSdkLogo());
            this.f63686b.setText(ksNativeAd.getAdDescription());
            this.f63692h.setText(ksNativeAd.getAdSource());
            this.f63693i.setText(ksNativeAd.getActionDescription());
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onFinishInflate();
            this.f63686b = (TextView) findViewById(R.id.ad_description);
            this.f63687c = (LinearLayout) findViewById(R.id.ad_img_container);
            this.f63688d = (ImageView) findViewById(R.id.ad_img_1);
            this.f63689e = (ImageView) findViewById(R.id.ad_img_2);
            this.f63690f = (ImageView) findViewById(R.id.ad_img_3);
            this.f63691g = (ImageView) findViewById(R.id.ad_logo);
            this.f63692h = (TextView) findViewById(R.id.ad_h5_description);
            this.f63693i = (Button) findViewById(R.id.ad_h5_open);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f63687c.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f63688d.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f63689e.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f63690f.getLayoutParams();
            layoutParams.width = i6;
            layoutParams.height = (int) (((((((i6 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.5f);
            this.f63687c.setLayoutParams(layoutParams);
        }
    }
}
