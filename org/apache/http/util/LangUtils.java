package org.apache.http.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes3.dex */
public final class LangUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HASH_OFFSET = 37;
    public static final int HASH_SEED = 17;
    public transient /* synthetic */ FieldHolder $fh;

    public LangUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    public static boolean equals(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, obj2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLL.booleanValue;
    }

    public static int hashCode(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeII.intValue;
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, objArr, objArr2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLL.booleanValue;
    }

    public static int hashCode(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeCommon.intValue;
    }

    public static int hashCode(int i2, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, obj)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeIL.intValue;
    }
}
