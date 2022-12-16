package com.kwad.components.ad.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes8.dex */
public class b implements i.a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b BK;
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

    public static b kO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (BK == null) {
                synchronized (b.class) {
                    if (BK == null) {
                        BK = new b();
                    }
                }
            }
            return BK;
        }
        return (b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.i.a
    public final void a(g gVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, gVar, i) == null) && (gVar instanceof com.kwad.components.core.k.a) && i != f.Yd.errorCode) {
            int i2 = 21004;
            SceneImpl scene = gVar.getScene();
            if (scene != null) {
                long posId = scene.getPosId();
                if (i == f.XY.errorCode) {
                    i2 = 21001;
                } else if (i == f.Yc.errorCode) {
                    i2 = 21003;
                } else if (i > 0 && i < 1000) {
                    i2 = 21002;
                }
                com.kwad.components.core.j.a.og().a(posId, i2);
            }
        }
    }

    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i.tB().a(this);
        }
    }
}
