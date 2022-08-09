package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class rn0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a(JSONObject optStringCheckNonNull, String key) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, optStringCheckNonNull, key)) == null) {
            Intrinsics.checkNotNullParameter(optStringCheckNonNull, "$this$optStringCheckNonNull");
            Intrinsics.checkNotNullParameter(key, "key");
            return b(optStringCheckNonNull, key, "");
        }
        return (String) invokeLL.objValue;
    }

    public static final String b(JSONObject optStringCheckNonNull, String key, String fallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, optStringCheckNonNull, key, fallback)) == null) {
            Intrinsics.checkNotNullParameter(optStringCheckNonNull, "$this$optStringCheckNonNull");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(fallback, "fallback");
            if (optStringCheckNonNull.isNull(key)) {
                return fallback;
            }
            String optString = optStringCheckNonNull.optString(key, fallback);
            Intrinsics.checkNotNullExpressionValue(optString, "optString(key, fallback)");
            return optString;
        }
        return (String) invokeLLL.objValue;
    }
}
