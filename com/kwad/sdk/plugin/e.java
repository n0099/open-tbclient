package com.kwad.sdk.plugin;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, context, sdkConfig) == null) {
            d dVar = (d) c.class.newInstance();
            f.a(dVar.a(), dVar);
            dVar.a(context, sdkConfig);
            d dVar2 = (d) com.kwad.sdk.a.class.newInstance();
            f.a(dVar2.a(), dVar2);
            dVar2.a(context, sdkConfig);
        }
    }
}
