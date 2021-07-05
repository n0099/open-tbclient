package com.kwad.sdk.plugin;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, sdkConfig) == null) {
            e eVar = (e) c.class.newInstance();
            g.a(eVar.b(), eVar);
            eVar.a(context, sdkConfig);
            e eVar2 = (e) com.kwad.sdk.contentalliance.d.class.newInstance();
            g.a(eVar2.b(), eVar2);
            eVar2.a(context, sdkConfig);
        }
    }
}
