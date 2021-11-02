package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.loader.Wrapper;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes2.dex */
public abstract class AbstractKsDrawAd implements KsDrawAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbstractKsDrawAd() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getDrawView(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? getDrawView2(Wrapper.wrapContextIfNeed(context)) : (View) invokeL.objValue;
    }

    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public abstract View getDrawView2(Context context);
}
