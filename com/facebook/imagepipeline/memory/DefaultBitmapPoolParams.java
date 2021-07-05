package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class DefaultBitmapPoolParams {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseIntArray DEFAULT_BUCKETS;
    public static final int MAX_SIZE_SOFT_CAP = 0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1167930678, "Lcom/facebook/imagepipeline/memory/DefaultBitmapPoolParams;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1167930678, "Lcom/facebook/imagepipeline/memory/DefaultBitmapPoolParams;");
                return;
            }
        }
        DEFAULT_BUCKETS = new SparseIntArray(0);
    }

    public DefaultBitmapPoolParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static PoolParams get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new PoolParams(0, getMaxSizeHardCap(), DEFAULT_BUCKETS) : (PoolParams) invokeV.objValue;
    }

    public static int getMaxSizeHardCap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
            if (min > 16777216) {
                return (min / 4) * 3;
            }
            return min / 2;
        }
        return invokeV.intValue;
    }
}
