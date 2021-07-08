package com.kwad.sdk;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.export.proxy.AdDownloadProxy;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.export.proxy.AdInstallProxy;
import com.kwad.sdk.utils.al;
import java.io.File;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static AdDownloadProxy a(Context context, AdInstallProxy adInstallProxy, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65536, null, context, adInstallProxy, z)) == null) {
            try {
                return com.kwad.sdk.core.download.b.e.a(context, al.c(context), adInstallProxy, z);
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
                return com.kwad.sdk.core.network.a.b.a() != null ? new com.kwad.sdk.core.network.c.b() : new com.kwad.sdk.core.network.c.a();
            } catch (Throwable unused) {
                return new com.kwad.sdk.core.network.c.a();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new com.kwad.sdk.core.download.d.b() : (AdInstallProxy) invokeV.objValue;
    }
}
