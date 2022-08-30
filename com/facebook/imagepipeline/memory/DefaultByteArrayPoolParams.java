package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class DefaultByteArrayPoolParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BUCKET_SIZE = 5;
    public static final int DEFAULT_IO_BUFFER_SIZE = 16384;
    public static final int MAX_SIZE_HARD_CAP = 1048576;
    public static final int MAX_SIZE_SOFT_CAP = 81920;
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultByteArrayPoolParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static PoolParams get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            SparseIntArray sparseIntArray = new SparseIntArray();
            sparseIntArray.put(16384, 5);
            return new PoolParams(MAX_SIZE_SOFT_CAP, 1048576, sparseIntArray);
        }
        return (PoolParams) invokeV.objValue;
    }
}
