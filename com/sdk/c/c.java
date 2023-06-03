package com.sdk.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.e;
import com.sdk.f.f;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final Boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593256653, "Lcom/sdk/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593256653, "Lcom/sdk/c/c;");
                return;
            }
        }
        a = Boolean.valueOf(f.a);
    }

    public c() {
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

    /* JADX WARN: Removed duplicated region for block: B:57:0x00c0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(HttpURLConnection httpURLConnection, b bVar, String str) {
        InterceptResult invokeLLL;
        StringBuilder sb;
        StringBuilder sb2;
        long j;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, httpURLConnection, bVar, str)) == null) {
            if (httpURLConnection != null) {
                long j2 = 0;
                try {
                    long contentLength = httpURLConnection.getContentLength();
                    if (bVar != null && !((e) bVar).a(contentLength, 0L, true)) {
                        return null;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), str));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                sb3.append(readLine);
                                sb3.append('\n');
                                long j3 = 0;
                                if (!TextUtils.isEmpty(readLine)) {
                                    int length = readLine.length();
                                    if (length < 100) {
                                        j3 = readLine.getBytes(str).length;
                                    } else {
                                        int i2 = 0;
                                        while (i2 < length) {
                                            int i3 = i2 + 100;
                                            if (i3 < length) {
                                                i = i3;
                                            } else {
                                                i = length;
                                            }
                                            j3 += new String(readLine.substring(i2, i)).getBytes(str).length;
                                            i2 = i3;
                                            sb3 = sb3;
                                        }
                                    }
                                }
                                sb2 = sb3;
                                j2 += j3;
                                if (bVar != null) {
                                    j = contentLength;
                                    try {
                                        if (!((e) bVar).a(contentLength, j2, false)) {
                                            break;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        sb = sb2;
                                        com.sdk.o.a.a("StringDownloadHandler", e.getMessage(), a);
                                        if (sb != null) {
                                        }
                                    }
                                } else {
                                    j = contentLength;
                                }
                                contentLength = j;
                                sb3 = sb2;
                            } else {
                                sb2 = sb3;
                                j = contentLength;
                                break;
                            }
                        }
                        long j4 = j2;
                        if (bVar != null) {
                            ((e) bVar).a(j, j4, true);
                        }
                        sb = sb2;
                    } catch (Exception e2) {
                        e = e2;
                        sb2 = sb3;
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
