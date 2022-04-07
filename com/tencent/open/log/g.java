package com.tencent.open.log;

import android.text.format.Time;
import android.util.Log;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes8.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public static final g a;
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
        a = new g();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? "-" : "A" : "E" : "W" : "I" : "D" : "V" : (String) invokeI.objValue;
    }

    public String a(int i, Thread thread, long j, String str, String str2, Throwable th) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), thread, Long.valueOf(j), str, str2, th})) == null) {
            long j2 = j % 1000;
            Time time = new Time();
            time.set(j);
            StringBuilder sb = new StringBuilder();
            sb.append(a(i));
            sb.append(WebvttCueParser.CHAR_SLASH);
            sb.append(time.format("%Y-%m-%d %H:%M:%S"));
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            if (j2 < 10) {
                sb.append("00");
            } else if (j2 < 100) {
                sb.append('0');
            }
            sb.append(j2);
            sb.append(WebvttCueParser.CHAR_SPACE);
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
            sb.append(WebvttCueParser.CHAR_SPACE);
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
