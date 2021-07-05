package com.kwad.sdk.lib.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.a.c;
import com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer;
/* loaded from: classes7.dex */
public class NestedScrollViewPager extends a implements CustomAppBarFlingConsumer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollViewPager(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            PagerAdapter adapter = getAdapter();
            if (adapter instanceof com.kwad.sdk.lib.widget.viewpager.tabstrip.a) {
                KsFragment a2 = ((com.kwad.sdk.lib.widget.viewpager.tabstrip.a) adapter).a();
                if (a2 instanceof c) {
                    ((c) a2).i().stopNestedScroll(1);
                }
            }
        }
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void consumeAppBarFling(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            PagerAdapter adapter = getAdapter();
            if (adapter instanceof com.kwad.sdk.lib.widget.viewpager.tabstrip.a) {
                KsFragment a2 = ((com.kwad.sdk.lib.widget.viewpager.tabstrip.a) adapter).a();
                if (a2 instanceof c) {
                    ((c) a2).i().scrollBy(i2, i3);
                }
            }
        }
    }

    @Override // com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer
    public void onAppBarTouchDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a();
        }
    }
}
