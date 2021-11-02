package com.facebook.imagepipeline.cache;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
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
    public MemoryCacheParams(int i2, int i3, int i4, int i5, int i6) {
        this(i2, i3, i4, i5, i6, TimeUnit.MINUTES.toMillis(5L));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Long) objArr2[5]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public MemoryCacheParams(int i2, int i3, int i4, int i5, int i6, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.maxCacheSize = i2;
        this.maxCacheEntries = i3;
        this.maxEvictionQueueSize = i4;
        this.maxEvictionQueueEntries = i5;
        this.maxCacheEntrySize = i6;
        this.paramsCheckIntervalMs = j;
    }
}
