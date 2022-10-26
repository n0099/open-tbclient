package com.google.android.gms.common.logging;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;
/* loaded from: classes7.dex */
public class Logger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String zza;
    public final String zzb;
    public final GmsLogger zzc;
    public final int zzd;

    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.zza : (String) invokeV.objValue;
    }

    public boolean isLoggable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? this.zzd <= i : invokeI.booleanValue;
    }

    public Logger(String str, String... strArr) {
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, strArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (strArr.length == 0) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            sb = sb2.toString();
        }
        this.zzb = sb;
        this.zza = str;
        this.zzc = new GmsLogger(str);
        int i3 = 2;
        while (i3 <= 7 && !Log.isLoggable(this.zza, i3)) {
            i3++;
        }
        this.zzd = i3;
    }

    public void d(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, objArr) == null) && isLoggable(3)) {
            Log.d(this.zza, format(str, objArr));
        }
    }

    public void e(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, objArr) == null) {
            Log.e(this.zza, format(str, objArr));
        }
    }

    public String format(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, objArr)) == null) {
            if (objArr != null && objArr.length > 0) {
                str = String.format(Locale.US, str, objArr);
            }
            return this.zzb.concat(str);
        }
        return (String) invokeLL.objValue;
    }

    public void i(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, objArr) == null) {
            Log.i(this.zza, format(str, objArr));
        }
    }

    public void v(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, objArr) == null) && isLoggable(2)) {
            Log.v(this.zza, format(str, objArr));
        }
    }

    public void w(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, objArr) == null) {
            Log.w(this.zza, format(str, objArr));
        }
    }

    public void e(String str, Throwable th, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, th, objArr) == null) {
            Log.e(this.zza, format(str, objArr), th);
        }
    }

    public void v(String str, Throwable th, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048583, this, str, th, objArr) == null) && isLoggable(2)) {
            Log.v(this.zza, format(str, objArr), th);
        }
    }

    public void wtf(String str, Throwable th, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, th, objArr) == null) {
            Log.wtf(this.zza, format(str, objArr), th);
        }
    }

    public void wtf(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, th) == null) {
            Log.wtf(this.zza, th);
        }
    }
}
