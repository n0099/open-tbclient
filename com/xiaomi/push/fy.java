package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
/* loaded from: classes8.dex */
public class fy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, th)) == null) {
            boolean z = th instanceof gh;
            if (z) {
                gh ghVar = (gh) th;
                if (ghVar.a() != null) {
                    th = ghVar.a();
                }
            }
            String message = th.getMessage();
            if (th.getCause() != null) {
                message = th.getCause().getMessage();
            }
            if (th instanceof SocketTimeoutException) {
                return 105;
            }
            if (!(th instanceof SocketException)) {
                if (th instanceof UnknownHostException) {
                    return 107;
                }
                return z ? 399 : 0;
            } else if (message.indexOf("Network is unreachable") != -1) {
                return 102;
            } else {
                if (message.indexOf("Connection refused") != -1) {
                    return 103;
                }
                if (message.indexOf("Connection timed out") != -1) {
                    return 105;
                }
                if (message.endsWith("EACCES (Permission denied)")) {
                    return 101;
                }
                if (message.indexOf("Connection reset by peer") != -1) {
                    return 109;
                }
                if (message.indexOf("Broken pipe") != -1) {
                    return 110;
                }
                if (message.indexOf("No route to host") != -1) {
                    return 104;
                }
                if (message.endsWith("EINVAL (Invalid argument)")) {
                    return 106;
                }
                return Constants.METHOD_IM_DEL_BUSINESS_SESSION_MSG;
            }
        }
        return invokeL.intValue;
    }
}
