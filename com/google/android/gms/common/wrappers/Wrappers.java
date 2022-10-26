package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class Wrappers {
    public static /* synthetic */ Interceptable $ic;
    public static Wrappers zza;
    public transient /* synthetic */ FieldHolder $fh;
    public PackageManagerWrapper zzb;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1797607250, "Lcom/google/android/gms/common/wrappers/Wrappers;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1797607250, "Lcom/google/android/gms/common/wrappers/Wrappers;");
                return;
            }
        }
        zza = new Wrappers();
    }

    public Wrappers() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zzb = null;
    }

    public static PackageManagerWrapper packageManager(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return zza.zza(context);
        }
        return (PackageManagerWrapper) invokeL.objValue;
    }

    public final synchronized PackageManagerWrapper zza(Context context) {
        InterceptResult invokeL;
        PackageManagerWrapper packageManagerWrapper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            synchronized (this) {
                if (this.zzb == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    this.zzb = new PackageManagerWrapper(context);
                }
                packageManagerWrapper = this.zzb;
            }
            return packageManagerWrapper;
        }
        return (PackageManagerWrapper) invokeL.objValue;
    }
}
