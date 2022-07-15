package com.kwad.components.ad.reward.b;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsInnerAd;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Object a;

    public c(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = obj;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = null;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || this.a == null || bVar == null || bVar.a() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.a).onAdClicked((KsInnerAd) bVar.a());
        } catch (Exception unused) {
        }
    }

    public void b(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || this.a == null || bVar == null || bVar.a() == null) {
            return;
        }
        try {
            ((KsInnerAd.KsInnerAdInteractionListener) this.a).onAdShow((KsInnerAd) bVar.a());
        } catch (Exception unused) {
        }
    }
}
