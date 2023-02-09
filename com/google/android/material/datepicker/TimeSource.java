package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.TimeZone;
/* loaded from: classes8.dex */
public class TimeSource {
    public static /* synthetic */ Interceptable $ic;
    public static final TimeSource SYSTEM_TIME_SOURCE;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final Long fixedTimeMs;
    @Nullable
    public final TimeZone fixedTimeZone;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(238167052, "Lcom/google/android/material/datepicker/TimeSource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(238167052, "Lcom/google/android/material/datepicker/TimeSource;");
                return;
            }
        }
        SYSTEM_TIME_SOURCE = new TimeSource(null, null);
    }

    public static TimeSource system() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return SYSTEM_TIME_SOURCE;
        }
        return (TimeSource) invokeV.objValue;
    }

    public Calendar now() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return now(this.fixedTimeZone);
        }
        return (Calendar) invokeV.objValue;
    }

    public TimeSource(@Nullable Long l, @Nullable TimeZone timeZone) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l, timeZone};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.fixedTimeMs = l;
        this.fixedTimeZone = timeZone;
    }

    public static TimeSource fixed(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            return new TimeSource(Long.valueOf(j), null);
        }
        return (TimeSource) invokeJ.objValue;
    }

    public Calendar now(@Nullable TimeZone timeZone) {
        InterceptResult invokeL;
        Calendar calendar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, timeZone)) == null) {
            if (timeZone == null) {
                calendar = Calendar.getInstance();
            } else {
                calendar = Calendar.getInstance(timeZone);
            }
            Long l = this.fixedTimeMs;
            if (l != null) {
                calendar.setTimeInMillis(l.longValue());
            }
            return calendar;
        }
        return (Calendar) invokeL.objValue;
    }

    public static TimeSource fixed(long j, @Nullable TimeZone timeZone) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, timeZone)) == null) {
            return new TimeSource(Long.valueOf(j), timeZone);
        }
        return (TimeSource) invokeJL.objValue;
    }
}
