package com.bytedance.sdk.openadsdk.n.g;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.utils.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f68111a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            if (context != null) {
                f68111a = context;
                return;
            }
            throw null;
        }
    }

    public static File b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            File externalCacheDir = context.getExternalCacheDir();
            return externalCacheDir == null ? context.getCacheDir() : externalCacheDir;
        }
        return (File) invokeL.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                String externalStorageState = Environment.getExternalStorageState();
                if (!"mounted".equals(externalStorageState)) {
                    if (!"mounted_ro".equals(externalStorageState)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
                return c.a().b();
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                return "mounted".equals(Environment.getExternalStorageState());
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b(f68111a) : (File) invokeV.objValue;
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (c() && d()) {
                File file = new File(a(), "video");
                a(file);
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static File a(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, str)) == null) {
            if (c() && d() && !TextUtils.isEmpty(str)) {
                if (file == null) {
                    file = a();
                }
                File file2 = new File(file, str);
                a(file2);
                return file2;
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file) == null) || file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static String a(InputStream inputStream) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (Throwable th) {
                    th = th;
                    try {
                        k.a("FileHelper", "readStream error", th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                k.a("FileHelper", "br error", th2);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                k.a("FileHelper", "is error", th3);
                            }
                        }
                    }
                }
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Throwable th4) {
                k.a("FileHelper", "br error", th4);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th5) {
                    k.a("FileHelper", "is error", th5);
                }
            }
            return sb2;
        } catch (Throwable th6) {
            th = th6;
            bufferedReader = null;
        }
    }
}
