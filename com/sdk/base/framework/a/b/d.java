package com.sdk.base.framework.a.b;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.c.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes2.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Boolean f68096a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(922598098, "Lcom/sdk/base/framework/a/b/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(922598098, "Lcom/sdk/base/framework/a/b/d;");
                return;
            }
        }
        f68096a = Boolean.valueOf(f.f68205b);
    }

    public d() {
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

    /* JADX WARN: Removed duplicated region for block: B:31:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(HttpURLConnection httpURLConnection, c cVar, String str) {
        InterceptResult invokeLLL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, httpURLConnection, cVar, str)) == null) {
            if (httpURLConnection != null) {
                long j = 0;
                try {
                    long contentLength = httpURLConnection.getContentLength();
                    if (cVar != null && !cVar.a(contentLength, 0L, true)) {
                        return null;
                    }
                    sb = new StringBuilder();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), str));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append('\n');
                            j += com.sdk.base.framework.a.a.c.a(readLine, str);
                            if (cVar != null && !cVar.a(contentLength, j, false)) {
                                break;
                            }
                        }
                        long j2 = j;
                        if (cVar != null) {
                            cVar.a(contentLength, j2, true);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.sdk.base.framework.a.a.c.b("StringDownloadHandler", e.getMessage(), f68096a);
                        if (sb != null) {
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    sb = null;
                }
            } else {
                sb = null;
            }
            if (sb != null) {
                return null;
            }
            return sb.toString().trim();
        }
        return (String) invokeLLL.objValue;
    }
}
