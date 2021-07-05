package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSCoordinatorLayout;
@Keep
/* loaded from: classes7.dex */
public class CustomScrollingViewBehavior extends KSAppBarLayout.ScrollingViewBehavior {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.kwad.sdk.lib.desigin.KSAppBarLayout.ScrollingViewBehavior, com.kwad.sdk.lib.desigin.KSHeaderScrollingViewBehavior
    @Keep
    public int getScrollRange(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
            if (view instanceof KSAppBarLayout) {
                KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) view.getLayoutParams()).getBehavior();
                boolean z = behavior instanceof CustomAppBarCustomAttrListener;
                int totalScrollRange = ((KSAppBarLayout) view).getTotalScrollRange();
                return z ? totalScrollRange - ((CustomAppBarCustomAttrListener) behavior).getExtraFixedSize() : totalScrollRange;
            }
            return super.getScrollRange(view);
        }
        return invokeL.intValue;
    }
}
