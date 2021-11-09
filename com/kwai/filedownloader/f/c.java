package com.kwai.filedownloader.f;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwai.filedownloader.exception.PathConflictException;
import com.kwai.filedownloader.x;
import java.io.File;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f66972a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface a {
        int a(int i2, String str, String str2, long j);
    }

    /* loaded from: classes2.dex */
    public interface b {
        com.kwai.filedownloader.a.b a(String str);
    }

    /* renamed from: com.kwai.filedownloader.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1944c {
        com.kwai.filedownloader.b.a a();
    }

    /* loaded from: classes2.dex */
    public interface d {
        int a(int i2, String str, String str2, boolean z);

        int a(String str, String str2, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface e {
        com.kwai.filedownloader.e.a a(File file);

        boolean a();
    }

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f66972a : (Context) invokeV.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            f66972a = context;
        }
    }

    public static boolean a(int i2, long j, String str, String str2, x xVar) {
        InterceptResult invokeCommon;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, str2, xVar})) == null) {
            if (str2 == null || str == null || (a2 = xVar.a(str, i2)) == 0) {
                return false;
            }
            com.kwai.filedownloader.message.e.a().a(com.kwai.filedownloader.message.f.a(i2, j, new PathConflictException(a2, str, str2)));
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(int i2, com.kwai.filedownloader.d.c cVar, x xVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), cVar, xVar, Boolean.valueOf(z)})) == null) {
            if (xVar.a(cVar)) {
                com.kwai.filedownloader.message.e.a().a(com.kwai.filedownloader.message.f.a(i2, cVar.g(), cVar.h(), z));
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(int i2, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!z && str != null) {
                File file = new File(str);
                if (file.exists()) {
                    com.kwai.filedownloader.message.e.a().a(com.kwai.filedownloader.message.f.a(i2, file, z2));
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
