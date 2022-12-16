package com.kwad.components.ad.reward.k;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class v extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup pV;

    public v() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a(ViewGroup viewGroup, @IdRes int i, @IdRes int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048576, this, viewGroup, i, i2) == null) && this.pV == null) {
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
            this.pV = (ViewGroup) (viewStub != null ? viewStub.inflate() : viewGroup.findViewById(i2));
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public ViewGroup fR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.pV : (ViewGroup) invokeV.objValue;
    }
}
