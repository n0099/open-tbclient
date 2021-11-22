package com.fun.ad.sdk.channel.model.gdt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.channel.gdt.R;
import com.fun.ad.sdk.internal.api.utils.GlideHelper;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.module.gdt.x;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class GDTNativeUnifiedImg3View extends x {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f63660d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f63661e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f63662f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f63663g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GDTNativeUnifiedImg3View(Context context) {
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
    public GDTNativeUnifiedImg3View(Context context, @Nullable AttributeSet attributeSet) {
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
    public GDTNativeUnifiedImg3View(Context context, @Nullable AttributeSet attributeSet, int i2) {
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

    @Override // com.fun.module.gdt.x
    public List<View> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f63782c);
            arrayList.add(((x) this).f63781b);
            arrayList.add(((x) this).f63780a);
            arrayList.add(this.f63660d);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.fun.module.gdt.x
    public void a(NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nativeUnifiedADData) == null) {
            super.a(nativeUnifiedADData);
            LogPrinter.e("GDTNativeUnifiedAd image width: " + nativeUnifiedADData.getPictureWidth() + ", height: " + nativeUnifiedADData.getPictureHeight(), new Object[0]);
            GlideHelper.get().load(getContext(), nativeUnifiedADData.getImgList().get(0), this.f63661e);
            GlideHelper.get().load(getContext(), nativeUnifiedADData.getImgList().get(1), this.f63662f);
            GlideHelper.get().load(getContext(), nativeUnifiedADData.getImgList().get(2), this.f63663g);
        }
    }

    @Override // com.fun.module.gdt.x, android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onFinishInflate();
            this.f63660d = (LinearLayout) findViewById(R.id.ad_img_container);
            this.f63661e = (ImageView) findViewById(R.id.ad_img_1);
            this.f63662f = (ImageView) findViewById(R.id.ad_img_2);
            this.f63663g = (ImageView) findViewById(R.id.ad_img_3);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f63660d.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f63661e.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f63662f.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f63663g.getLayoutParams();
            layoutParams.width = i6;
            layoutParams.height = (int) (((((((i6 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.52f);
            this.f63660d.setLayoutParams(layoutParams);
        }
    }
}
