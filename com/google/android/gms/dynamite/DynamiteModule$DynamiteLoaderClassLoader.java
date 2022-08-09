package com.google.android.gms.dynamite;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.util.DynamiteApi;
import javax.annotation.concurrent.GuardedBy;
@DynamiteApi
/* loaded from: classes5.dex */
public class DynamiteModule$DynamiteLoaderClassLoader {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    @GuardedBy("DynamiteLoaderClassLoader.class")
    public static ClassLoader sClassLoader;
    public transient /* synthetic */ FieldHolder $fh;

    public DynamiteModule$DynamiteLoaderClassLoader() {
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
}
