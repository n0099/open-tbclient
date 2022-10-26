package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class GservicesValue {
    public static /* synthetic */ Interceptable $ic;
    public static final Object zzc;
    public transient /* synthetic */ FieldHolder $fh;
    public final String zza;
    public final Object zzb;
    public Object zzd;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1740763736, "Lcom/google/android/gms/common/config/GservicesValue;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1740763736, "Lcom/google/android/gms/common/config/GservicesValue;");
                return;
            }
        }
        zzc = new Object();
    }

    public GservicesValue(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zzd = null;
        this.zza = str;
        this.zzb = obj;
    }

    public static GservicesValue value(String str, Float f) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, f)) == null) ? new zzd(str, f) : (GservicesValue) invokeLL.objValue;
    }

    public static GservicesValue value(String str, Integer num) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, num)) == null) ? new zzc(str, num) : (GservicesValue) invokeLL.objValue;
    }

    public static GservicesValue value(String str, Long l) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, l)) == null) ? new zzb(str, l) : (GservicesValue) invokeLL.objValue;
    }

    public static GservicesValue value(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) ? new zze(str, str2) : (GservicesValue) invokeLL.objValue;
    }

    public void resetOverride() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.zzd = null;
        }
    }

    public abstract Object zza(String str);

    public static boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (zzc) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public final Object getBinderSafe() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return get();
        }
        return invokeV.objValue;
    }

    public static GservicesValue value(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, str, z)) == null) {
            return new zza(str, Boolean.valueOf(z));
        }
        return (GservicesValue) invokeLZ.objValue;
    }

    public final Object get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object obj = this.zzd;
            if (obj != null) {
                return obj;
            }
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            synchronized (zzc) {
            }
            synchronized (zzc) {
            }
            try {
                return zza(this.zza);
            } catch (SecurityException unused) {
                long clearCallingIdentity = Binder.clearCallingIdentity();
                Object zza = zza(this.zza);
                Binder.restoreCallingIdentity(clearCallingIdentity);
                return zza;
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        return invokeV.objValue;
    }

    public void override(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
            this.zzd = obj;
            synchronized (zzc) {
                synchronized (zzc) {
                }
            }
        }
    }
}
