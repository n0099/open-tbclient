package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.baidu.ar.record.EncoderParams;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class DefaultNativeMemoryChunkPoolParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LARGE_BUCKET_LENGTH = 2;
    public static final int SMALL_BUCKET_LENGTH = 5;
    public transient /* synthetic */ FieldHolder $fh;

    public DefaultNativeMemoryChunkPoolParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            sparseIntArray.put(1024, 5);
            sparseIntArray.put(2048, 5);
            sparseIntArray.put(4096, 5);
            sparseIntArray.put(8192, 5);
            sparseIntArray.put(16384, 5);
            sparseIntArray.put(32768, 5);
            sparseIntArray.put(65536, 5);
            sparseIntArray.put(131072, 5);
            sparseIntArray.put(262144, 2);
            sparseIntArray.put(524288, 2);
            sparseIntArray.put(1048576, 2);
            return new PoolParams(getMaxSizeSoftCap(), getMaxSizeHardCap(), sparseIntArray);
        }
        return (PoolParams) invokeV.objValue;
    }

    public static int getMaxSizeHardCap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
            if (min < 16777216) {
                return min / 2;
            }
            return (min / 4) * 3;
        }
        return invokeV.intValue;
    }

    public static int getMaxSizeSoftCap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
            if (min < 16777216) {
                return EncoderParams.VIDEO_BIT_RATE;
            }
            if (min < 33554432) {
                return TbConfig.THREAD_GIF_MIN_USE_MEMORY;
            }
            return 12582912;
        }
        return invokeV.intValue;
    }
}
