package com.kwad.sdk.glide.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
/* loaded from: classes7.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static <T> T a(@Nullable T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, t)) == null) ? (T) a(t, "Argument must not be null") : (T) invokeL.objValue;
    }

    @NonNull
    public static <T> T a(@Nullable T t, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, str)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(str);
        }
        return (T) invokeLL.objValue;
    }

    @NonNull
    public static String a(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Must not be null or empty");
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T a(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            if (t.isEmpty()) {
                throw new IllegalArgumentException("Must not be empty.");
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public static void a(boolean z, @NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65540, null, z, str) == null) && !z) {
            throw new IllegalArgumentException(str);
        }
    }
}
