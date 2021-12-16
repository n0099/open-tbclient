package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes3.dex */
public class aq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static String a(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String str = "";
            try {
                str = Environment.getExternalStorageState();
            } catch (IncompatibleClassChangeError | NullPointerException unused) {
            }
            String str2 = null;
            if ("mounted".equals(str) || !Environment.isExternalStorageRemovable()) {
                try {
                    file = context.getExternalFilesDir(null);
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    file = null;
                }
                if (file != null) {
                    str2 = file.getPath();
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getFilesDir().getPath();
            }
            return str2 + File.separator + "ksadsdk";
        }
        return (String) invokeL.objValue;
    }

    public static File b(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
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

    public static File c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String a = a(context);
            return new File(a + File.separator + "Download");
        }
        return (File) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context == null) {
                return "";
            }
            String path = context.getFilesDir().getPath();
            return path + File.separator + "ksadsdk";
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context == null) {
                return "";
            }
            String a = a(context);
            return a + File.separator + "ksad/download/js";
        }
        return (String) invokeL.objValue;
    }
}
