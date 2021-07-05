package com.fun.ad.sdk.channel.model.gdt;

import a.a.a.a.u.b.b.b;
import a.a.a.a.y.d;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
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
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.R;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class GDTNativeUnifiedImg3View extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f32590d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f32591e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f32592f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f32593g;

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

    @Override // a.a.a.a.u.b.b.b
    public List<View> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f1307c);
            arrayList.add(((b) this).f1306b);
            arrayList.add(((b) this).f1305a);
            arrayList.add(this.f32590d);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // a.a.a.a.u.b.b.b
    public void a(Activity activity, NativeUnifiedADData nativeUnifiedADData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, nativeUnifiedADData) == null) {
            super.a(activity, nativeUnifiedADData);
            d.b("GDTNativeUnifiedAd image width: " + nativeUnifiedADData.getPictureWidth() + ", height: " + nativeUnifiedADData.getPictureHeight(), new Object[0]);
            Context context = getContext();
            String str = nativeUnifiedADData.getImgList().get(0);
            ImageView imageView = this.f32591e;
            if (context == null) {
                d.b("GlideHelper: context is null when load: " + str, new Object[0]);
            } else if (context instanceof Activity) {
                Activity activity2 = (Activity) context;
                if (activity2.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity2.isDestroyed())) {
                    d.b("GlideHelper: activity is destroyed when load: " + str, new Object[0]);
                } else {
                    Glide.with(activity2).load(str).into(imageView);
                }
            } else {
                Glide.with(context).load(str).into(imageView);
            }
            Context context2 = getContext();
            String str2 = nativeUnifiedADData.getImgList().get(1);
            ImageView imageView2 = this.f32592f;
            if (context2 == null) {
                d.b("GlideHelper: context is null when load: " + str2, new Object[0]);
            } else if (context2 instanceof Activity) {
                Activity activity3 = (Activity) context2;
                if (activity3.isFinishing() || (Build.VERSION.SDK_INT > 17 && activity3.isDestroyed())) {
                    d.b("GlideHelper: activity is destroyed when load: " + str2, new Object[0]);
                } else {
                    Glide.with(activity3).load(str2).into(imageView2);
                }
            } else {
                Glide.with(context2).load(str2).into(imageView2);
            }
            Context context3 = getContext();
            String str3 = nativeUnifiedADData.getImgList().get(2);
            ImageView imageView3 = this.f32593g;
            if (context3 == null) {
                d.b("GlideHelper: context is null when load: " + str3, new Object[0]);
            } else if (context3 instanceof Activity) {
                Activity activity4 = (Activity) context3;
                if (!activity4.isFinishing() && (Build.VERSION.SDK_INT <= 17 || !activity4.isDestroyed())) {
                    Glide.with(activity4).load(str3).into(imageView3);
                    return;
                }
                d.b("GlideHelper: activity is destroyed when load: " + str3, new Object[0]);
            } else {
                Glide.with(context3).load(str3).into(imageView3);
            }
        }
    }

    @Override // a.a.a.a.u.b.b.b, android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onFinishInflate();
            this.f32590d = (LinearLayout) findViewById(R.id.ad_img_container);
            this.f32591e = (ImageView) findViewById(R.id.ad_img_1);
            this.f32592f = (ImageView) findViewById(R.id.ad_img_2);
            this.f32593g = (ImageView) findViewById(R.id.ad_img_3);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f32590d.getLayoutParams();
            int i6 = (i2 - layoutParams.leftMargin) - layoutParams.rightMargin;
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f32591e.getLayoutParams();
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f32592f.getLayoutParams();
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f32593g.getLayoutParams();
            layoutParams.width = i6;
            layoutParams.height = (int) (((((((i6 - layoutParams2.leftMargin) - layoutParams2.rightMargin) - layoutParams3.leftMargin) - layoutParams3.rightMargin) - layoutParams4.leftMargin) - layoutParams4.rightMargin) / 1.52f);
            this.f32590d.setLayoutParams(layoutParams);
        }
    }
}
