package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static Context D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static ThreadPoolExecutor H;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-950597281, "Lcom/tencent/mm/opensdk/utils/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-950597281, "Lcom/tencent/mm/opensdk/utils/d;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        E = availableProcessors;
        F = availableProcessors + 1;
        G = (availableProcessors * 2) + 1;
        H = new ThreadPoolExecutor(F, G, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    public static int a(ContentResolver contentResolver, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, contentResolver, uri)) == null) {
            Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
            if (contentResolver == null || uri == null) {
                Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
                return 0;
            }
            InputStream inputStream = null;
            try {
                try {
                    InputStream openInputStream = contentResolver.openInputStream(uri);
                    if (openInputStream == null) {
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        return 0;
                    }
                    int available = openInputStream.available();
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return available;
                } catch (Exception e2) {
                    Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e2.getMessage());
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return 0;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        return invokeLL.intValue;
    }

    public static boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 36 || i == 46 : invokeI.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str == null || str.length() <= 0 : invokeL.booleanValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str != null) {
                try {
                    if (str.length() > 0) {
                        return Integer.parseInt(str);
                    }
                } catch (Exception unused) {
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getFileSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            File file = new File(str);
            if (file.exists()) {
                return (int) file.length();
            }
            if (D != null && str.startsWith("content")) {
                try {
                    return a(D.getContentResolver(), Uri.parse(str));
                } catch (Exception unused) {
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
