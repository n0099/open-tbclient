package com.kwai.filedownloader.e;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwai.filedownloader.exception.PathConflictException;
import com.kwai.filedownloader.y;
import java.io.File;
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static Context awK;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface a {
        int V(long j);
    }

    /* loaded from: classes8.dex */
    public interface b {
        com.kwai.filedownloader.kwai.b r(String str);
    }

    /* renamed from: com.kwai.filedownloader.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0645c {
        com.kwai.filedownloader.a.a EK();
    }

    /* loaded from: classes8.dex */
    public interface d {
        int j(String str, String str2, boolean z);

        int k(String str, String str2, boolean z);
    }

    /* loaded from: classes8.dex */
    public interface e {
        com.kwai.filedownloader.d.a ae(File file);
    }

    public static void D(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            awK = context;
        }
    }

    public static Context EJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? awK : (Context) invokeV.objValue;
    }

    public static boolean a(int i, long j, String str, String str2, y yVar) {
        InterceptResult invokeCommon;
        int p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, str2, yVar})) == null) {
            if (str2 == null || str == null || (p = yVar.p(str, i)) == 0) {
                return false;
            }
            com.kwai.filedownloader.message.e.Eg().s(com.kwai.filedownloader.message.f.a(i, j, new PathConflictException(p, str, str2)));
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(int i, com.kwai.filedownloader.c.c cVar, y yVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), cVar, yVar, Boolean.valueOf(z)})) == null) {
            if (yVar.a(cVar)) {
                com.kwai.filedownloader.message.e.Eg().s(com.kwai.filedownloader.message.f.a(i, cVar.Em(), cVar.getTotal(), z));
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean a(int i, String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (!z && str != null) {
                File file = new File(str);
                if (file.exists()) {
                    com.kwai.filedownloader.message.e.Eg().s(com.kwai.filedownloader.message.f.a(i, file, z2));
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
