package com.tencent.open.log;

import android.text.format.Time;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final g f76029a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1617044384, "Lcom/tencent/open/log/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1617044384, "Lcom/tencent/open/log/g;");
                return;
            }
        }
        f76029a = new g();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? i2 != 16 ? i2 != 32 ? "-" : "A" : "E" : "W" : "I" : "D" : "V" : (String) invokeI.objValue;
    }

    public String a(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), thread, Long.valueOf(j2), str, str2, th})) == null) {
            long j3 = j2 % 1000;
            Time time = new Time();
            time.set(j2);
            StringBuilder sb = new StringBuilder();
            sb.append(a(i2));
            sb.append('/');
            sb.append(time.format("%Y-%m-%d %H:%M:%S"));
            sb.append('.');
            if (j3 < 10) {
                sb.append("00");
            } else if (j3 < 100) {
                sb.append('0');
            }
            sb.append(j3);
            sb.append(' ');
            sb.append('[');
            if (thread == null) {
                sb.append("N/A");
            } else {
                sb.append(thread.getName());
            }
            sb.append(']');
            sb.append('[');
            sb.append(str);
            sb.append(']');
            sb.append(' ');
            sb.append(str2);
            sb.append('\n');
            if (th != null) {
                sb.append("* Exception : \n");
                sb.append(Log.getStackTraceString(th));
                sb.append('\n');
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }
}
