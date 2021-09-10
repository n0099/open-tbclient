package com.bytedance.sdk.openadsdk.q;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
/* loaded from: classes9.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f68873a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Removed duplicated region for block: B:57:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Exception e2;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65536, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        StringBuilder sb = new StringBuilder();
        FileReader fileReader2 = null;
        try {
            File file = new File("data/data/com.union_test.toutiao/" + str);
            if (!file.exists()) {
                return null;
            }
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (Exception e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Throwable unused) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileReader2 = fileReader;
                        if (fileReader2 != null) {
                            try {
                                fileReader2.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        throw th;
                    }
                }
                String sb2 = sb.toString();
                try {
                    fileReader.close();
                } catch (Throwable unused5) {
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused6) {
                }
                return sb2;
            } catch (Exception e4) {
                bufferedReader = null;
                e2 = e4;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception e5) {
            bufferedReader = null;
            e2 = e5;
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (fileReader2 != null) {
            }
            if (bufferedReader != null) {
            }
            throw th;
        }
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                if (a()) {
                    String z = com.bytedance.sdk.openadsdk.core.h.d().z();
                    if (TextUtils.isEmpty(z)) {
                        return str;
                    }
                    String str2 = "AnyDoorId=" + z;
                    return Uri.parse(str).buildUpon().appendQueryParameter(b(), z).appendQueryParameter("aid", "5001121").toString();
                }
                return str;
            } catch (Throwable unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (TextUtils.isEmpty(f68873a)) {
                f68873a = new String(Base64.decode("ZGV2aWNlX2lk", 0));
            }
            return f68873a;
        }
        return (String) invokeV.objValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? com.bytedance.sdk.component.utils.k.c() && com.bytedance.sdk.openadsdk.core.h.d().x() && com.bytedance.sdk.openadsdk.core.h.d().y() : invokeV.booleanValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (str.contains("https://pangolin.snssdk.com")) {
                return str.replace("https://pangolin.snssdk.com", str2);
            }
            if (str.contains("https://is.snssdk.com")) {
                return str.replace("https://is.snssdk.com", str2);
            }
            if (str.contains("https://pangolin16.snssdk.com")) {
                return str.replace("https://pangolin16.snssdk.com", str2);
            }
            return str.contains("https://api-access.pangolin-sdk-toutiao.com") ? str.replace("https://api-access.pangolin-sdk-toutiao.com", str2) : str;
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, map) == null) && a()) {
            map.put("x-app-id", "5001121");
            String z = com.bytedance.sdk.openadsdk.core.h.d().z();
            if (TextUtils.isEmpty(z)) {
                return;
            }
            map.put("x-device-id", z);
        }
    }
}
