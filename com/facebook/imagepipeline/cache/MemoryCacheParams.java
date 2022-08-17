package com.facebook.imagepipeline.cache;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class MemoryCacheParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int maxCacheEntries;
    public final int maxCacheEntrySize;
    public final int maxCacheSize;
    public final int maxEvictionQueueEntries;
    public final int maxEvictionQueueSize;
    public final long paramsCheckIntervalMs;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemoryCacheParams(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, TimeUnit.MINUTES.toMillis(5L));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Long) objArr2[5]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public MemoryCacheParams(int i, int i2, int i3, int i4, int i5, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.maxCacheSize = i;
        this.maxCacheEntries = i2;
        this.maxEvictionQueueSize = i3;
        this.maxEvictionQueueEntries = i4;
        this.maxCacheEntrySize = i5;
        this.paramsCheckIntervalMs = j;
    }
}
