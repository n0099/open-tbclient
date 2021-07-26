package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static File f34002a;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (f34002a == null) {
                f34002a = c(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
            }
            return f34002a;
        }
        return (File) invokeL.objValue;
    }

    public static File a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            File a2 = a(context);
            return new File(a2, "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
        }
        return (File) invokeLL.objValue;
    }

    public static void a(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            if (!file.isFile() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    a(file2);
                }
            }
            file.delete();
        }
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            File a2 = a(context);
            return c(new File(a2, "apk-" + str)).getPath();
        }
        return (String) invokeLL.objValue;
    }

    public static void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file) == null) {
            try {
                a(file);
            } catch (Exception unused) {
            }
        }
    }

    public static File c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
            File a2 = a(context);
            return c(new File(a2, "apk-" + str));
        }
        return (File) invokeLL.objValue;
    }

    public static File c(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, file)) == null) {
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            if (file.exists() && file.isDirectory()) {
                return file;
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists() && file.isDirectory()) {
                return file;
            }
            throw new RuntimeException("Can not ensureDir:" + file);
        }
        return (File) invokeL.objValue;
    }

    public static String d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) ? new File(b(context, str), "dynamic.apk").getPath() : (String) invokeLL.objValue;
    }

    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) ? c(new File(b(context, str), "dex")).getPath() : (String) invokeLL.objValue;
    }

    public static String f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) ? c(new File(b(context, str), "libs")).getPath() : (String) invokeLL.objValue;
    }

    public static void g(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        i.a(new Runnable(context, str) { // from class: com.kwad.sdk.api.loader.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f34003a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f34004b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {context, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f34003a = context;
                this.f34004b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        File[] listFiles = g.c(this.f34003a, this.f34004b).getParentFile().listFiles();
                        if (listFiles == null || listFiles.length <= 0) {
                            return;
                        }
                        for (File file : listFiles) {
                            if (f.a(this.f34004b, file.getName().substring(file.getName().indexOf("-") + 1))) {
                                g.a(file);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }
}
