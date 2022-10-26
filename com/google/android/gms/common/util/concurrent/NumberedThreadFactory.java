package com.google.android.gms.common.util.concurrent;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public class NumberedThreadFactory implements ThreadFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String zza;
    public final AtomicInteger zzb;
    public final ThreadFactory zzc;

    public NumberedThreadFactory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzb = new AtomicInteger();
        this.zzc = Executors.defaultThreadFactory();
        Preconditions.checkNotNull(str, "Name must not be null");
        this.zza = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            Thread newThread = this.zzc.newThread(new zza(runnable, 0));
            String str = this.zza;
            int andIncrement = this.zzb.getAndIncrement();
            StringBuilder sb = new StringBuilder(str.length() + 13);
            sb.append(str);
            sb.append(PreferencesUtil.LEFT_MOUNT);
            sb.append(andIncrement);
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            newThread.setName(sb.toString());
            return newThread;
        }
        return (Thread) invokeL.objValue;
    }
}
