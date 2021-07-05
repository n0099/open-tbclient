package com.kwad.sdk.api.core;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsFeedPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes7.dex */
public abstract class AbstractKsFeedPage implements KsFeedPage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbstractKsFeedPage() {
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

    @Override // com.kwad.sdk.api.KsFeedPage
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public Fragment getFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getFragment2().getBase() : (Fragment) invokeV.objValue;
    }

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public abstract KsFragment getFragment2();
}
