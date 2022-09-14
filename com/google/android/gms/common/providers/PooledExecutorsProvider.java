package com.google.android.gms.common.providers;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ScheduledExecutorService;
@KeepForSdk
@Deprecated
/* loaded from: classes7.dex */
public class PooledExecutorsProvider {
    public static /* synthetic */ Interceptable $ic;
    public static PooledExecutorFactory zza;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface PooledExecutorFactory {
        @NonNull
        @KeepForSdk
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    public PooledExecutorsProvider() {
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

    @NonNull
    @KeepForSdk
    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        InterceptResult invokeV;
        PooledExecutorFactory pooledExecutorFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (PooledExecutorsProvider.class) {
                if (zza == null) {
                    zza = new zza();
                }
                pooledExecutorFactory = zza;
            }
            return pooledExecutorFactory;
        }
        return (PooledExecutorFactory) invokeV.objValue;
    }
}
