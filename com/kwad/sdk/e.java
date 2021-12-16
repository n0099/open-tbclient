package com.kwad.sdk;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdInstallProxy;
import com.kwad.sdk.utils.aq;
import java.io.File;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static AdDownloadProxy a(Context context, AdInstallProxy adInstallProxy, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, context, adInstallProxy, z)) == null) {
            try {
                return com.kwad.sdk.core.download.a.f.a(context, aq.c(context), adInstallProxy, z && b(context));
            } catch (Throwable unused) {
                return null;
            }
        }
        return (AdDownloadProxy) invokeLLZ.objValue;
    }

    @NonNull
    public static AdHttpProxy a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                return com.kwad.sdk.core.network.kwai.b.a() != null ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
            } catch (Throwable unused) {
                return new com.kwad.sdk.core.network.b.a();
            }
        }
        return (AdHttpProxy) invokeV.objValue;
    }

    public static File a(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String str = "";
            try {
                str = Environment.getExternalStorageState();
            } catch (IncompatibleClassChangeError | NullPointerException unused) {
            }
            String str2 = null;
            if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
                try {
                    file = context.getExternalCacheDir();
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    file = null;
                }
                if (file != null) {
                    str2 = file.getPath();
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getCacheDir().getPath();
            }
            return new File(str2 + File.separator + "ksadsdk");
        }
        return (File) invokeL.objValue;
    }

    @NonNull
    public static AdInstallProxy b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new com.kwad.sdk.core.download.c.b() : (AdInstallProxy) invokeV.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                new NotificationCompat.Builder(context, "");
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
