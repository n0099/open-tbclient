package com.kwad.sdk.glide.load.resource.d;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.glide.load.DecodeFormat;
/* loaded from: classes7.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<DecodeFormat> f38297a;

    /* renamed from: b  reason: collision with root package name */
    public static final com.kwad.sdk.glide.load.d<Boolean> f38298b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1242149626, "Lcom/kwad/sdk/glide/load/resource/d/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1242149626, "Lcom/kwad/sdk/glide/load/resource/d/i;");
                return;
            }
        }
        f38297a = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.gif.GifOptions.DecodeFormat", DecodeFormat.DEFAULT);
        f38298b = com.kwad.sdk.glide.load.d.a("com.kwad.sdk.glide.load.resource.gif.GifOptions.DisableAnimation", Boolean.FALSE);
    }
}
