package com.kwad.components.ad.interstitial.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class TransViewPager extends com.kwad.sdk.widget.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, View> a;
    public float b;
    @SlideType
    public int c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransViewPager(@NonNull Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.a = new HashMap();
        this.c = 0;
    }

    private View a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) ? this.a.get(Integer.valueOf(i)) : (View) invokeI.objValue;
    }

    private void a(View view2, View view3, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{view2, view3, Float.valueOf(f)}) == null) {
            if (this.c == 0 && f != 0.0f) {
                float f2 = this.b;
                if (f2 != 0.0f) {
                    if (f > f2) {
                        this.c = 1;
                    } else {
                        this.c = 2;
                    }
                }
            }
            if (this.c == 1 && view3 != null) {
                if (f > 0.5d || f <= 0.0f) {
                    view3.setTranslationX((1.0f - f) * 240.0f);
                } else {
                    view3.setTranslationX(240.0f * f);
                }
            }
            if (this.c == 2 && view2 != null) {
                if (f > 0.5d || f < 0.0f) {
                    view2.setTranslationX((1.0f - f) * (-240.0f));
                } else {
                    view2.setTranslationX((-240.0f) * f);
                }
            }
            this.b = f;
            if (f == 0.0f) {
                this.c = 0;
            }
        }
    }

    public final void a(int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, view2) == null) {
            this.a.put(Integer.valueOf(i), view2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            a(a(i), a(i + 1), f);
            super.onPageScrolled(i, f, i2);
        }
    }
}
