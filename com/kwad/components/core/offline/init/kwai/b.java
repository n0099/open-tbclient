package com.kwad.components.core.offline.init.kwai;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.sdk.KsAdSDKImpl;
import java.io.File;
/* loaded from: classes8.dex */
public final class b implements ICache {
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

    @Override // com.kwad.components.offline.api.core.api.ICache
    public final String getPreCacheUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int sc = com.kwad.sdk.core.config.d.sc();
            if (sc >= 0) {
                return sc == 0 ? str : com.kwad.sdk.core.videocache.b.a.bC(KsAdSDKImpl.get().getContext()).cA(str);
            }
            File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(str);
            if (ad == null || !ad.exists()) {
                return null;
            }
            return ad.getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }
}
