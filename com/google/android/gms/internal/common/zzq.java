package com.google.android.gms.internal.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import javax.annotation.CheckForNull;
/* loaded from: classes7.dex */
public final class zzq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final CharSequence zza(@CheckForNull Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, obj, str)) == null) {
            obj.getClass();
            return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
        }
        return (CharSequence) invokeLL.objValue;
    }
}
