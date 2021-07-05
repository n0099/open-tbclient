package com.kwad.sdk.emotion.b;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.utils.z;
/* loaded from: classes7.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f37204a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, str) == null) {
            z.a(str);
            f37204a = str;
        }
    }
}
