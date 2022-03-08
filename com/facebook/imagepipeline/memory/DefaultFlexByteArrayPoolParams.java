package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DefaultFlexByteArrayPoolParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_MAX_BYTE_ARRAY_SIZE = 4194304;
    public static final int DEFAULT_MAX_NUM_THREADS;
    public static final int DEFAULT_MIN_BYTE_ARRAY_SIZE = 131072;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-574588235, "Lcom/facebook/imagepipeline/memory/DefaultFlexByteArrayPoolParams;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-574588235, "Lcom/facebook/imagepipeline/memory/DefaultFlexByteArrayPoolParams;");
                return;
            }
        }
        DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
    }

    public DefaultFlexByteArrayPoolParams() {
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

    public static SparseIntArray generateBuckets(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) {
            SparseIntArray sparseIntArray = new SparseIntArray();
            while (i2 <= i3) {
                sparseIntArray.put(i2, i4);
                i2 *= 2;
            }
            return sparseIntArray;
        }
        return (SparseIntArray) invokeIII.objValue;
    }

    public static PoolParams get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int i2 = DEFAULT_MAX_NUM_THREADS;
            return new PoolParams(4194304, i2 * 4194304, generateBuckets(131072, 4194304, i2), 131072, 4194304, DEFAULT_MAX_NUM_THREADS);
        }
        return (PoolParams) invokeV.objValue;
    }
}
