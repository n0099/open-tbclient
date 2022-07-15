package com.kwad.components.ad.interstitial.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends Presenter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public void d() {
        List<Presenter> r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (r = r()) == null) {
            return;
        }
        for (Presenter presenter : r) {
            if (presenter instanceof b) {
                ((b) presenter).d();
            }
        }
    }

    public void e() {
        List<Presenter> r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (r = r()) == null) {
            return;
        }
        for (Presenter presenter : r) {
            if (presenter instanceof b) {
                ((b) presenter).e();
            }
        }
    }
}
