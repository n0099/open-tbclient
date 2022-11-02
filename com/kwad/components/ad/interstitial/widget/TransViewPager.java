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
/* loaded from: classes7.dex */
public class TransViewPager extends com.kwad.sdk.widget.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float jd;
    @SlideType
    public int je;
    public Map<Integer, e> map;

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
        this.map = new HashMap();
        this.je = 0;
    }

    private void a(View view2, View view3, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{view2, view3, Float.valueOf(f)}) == null) {
            if (this.je == 0 && f != 0.0f) {
                float f2 = this.jd;
                if (f2 != 0.0f) {
                    if (f > f2) {
                        this.je = 1;
                    } else {
                        this.je = 2;
                    }
                }
            }
            if (this.je == 1 && view3 != null) {
                if (f > 0.5d || f <= 0.0f) {
                    view3.setTranslationX((1.0f - f) * 240.0f);
                } else {
                    view3.setTranslationX(240.0f * f);
                }
            }
            if (this.je == 2 && view2 != null) {
                if (f > 0.5d || f < 0.0f) {
                    view2.setTranslationX((1.0f - f) * (-240.0f));
                } else {
                    view2.setTranslationX((-240.0f) * f);
                }
            }
            this.jd = f;
            if (f == 0.0f) {
                this.je = 0;
            }
        }
    }

    public final e F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.map.get(Integer.valueOf(i)) : (e) invokeI.objValue;
    }

    public final void a(int i, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, eVar) == null) {
            this.map.put(Integer.valueOf(i), eVar);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i, float f, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            a(F(i), F(i + 1), f);
            super.onPageScrolled(i, f, i2);
        }
    }
}
