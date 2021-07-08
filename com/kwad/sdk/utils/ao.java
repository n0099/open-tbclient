package com.kwad.sdk.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class ao {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Class f36507a;
    public transient /* synthetic */ FieldHolder $fh;

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, str, clsArr, objArr)) == null) {
            try {
                if (f36507a == null) {
                    f36507a = Class.forName("android.os.SystemProperties");
                }
                Method declaredMethod = f36507a.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Object a2 = a("get", new Class[]{String.class}, new Object[]{str});
            return a2 instanceof String ? (String) a2 : b(str);
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0005 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x0036 */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r1 == null) goto L12;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) {
        ?? r1;
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = (r1 = interceptable).invokeL(65538, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        BufferedReader bufferedReader2 = null;
        r0 = null;
        String str2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    str2 = bufferedReader.readLine();
                    r1 = bufferedReader;
                } catch (IOException e2) {
                    e = e2;
                    com.kwad.sdk.core.d.a.a(e);
                    r1 = bufferedReader;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = r1;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        try {
            r1.close();
        } catch (Throwable unused2) {
            return str2;
        }
    }
}
