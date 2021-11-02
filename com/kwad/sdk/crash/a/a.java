package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f65418a;

    /* renamed from: b  reason: collision with root package name */
    public static String f65419b;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            File file = !TextUtils.isEmpty(f65419b) ? new File(f65419b) : new File(a(f65418a), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static File a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            File dataDir = Build.VERSION.SDK_INT >= 24 ? context.getDataDir() : null;
            if (dataDir == null) {
                File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
                if (file.exists()) {
                    return file;
                }
                return new File("/data/data/" + context.getPackageName());
            }
            return dataDir;
        }
        return (File) invokeL.objValue;
    }

    public static void a(@NonNull Context context, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            f65418a = context;
            f65419b = str;
        }
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new File(a(), "java_crash/dump") : (File) invokeV.objValue;
    }
}
