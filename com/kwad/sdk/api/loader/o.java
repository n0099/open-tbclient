package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.api.loader.Reflect;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Resources> a;

    /* renamed from: b  reason: collision with root package name */
    public static final Object f57616b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, assetManager)) == null) {
                try {
                    Resources resources2 = (Resources) Reflect.a(resources.getClass()).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a();
                    if (resources2 != null) {
                        return resources2;
                    }
                    throw new RuntimeException("Can not create Resources");
                } catch (Exception unused) {
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
            return (Resources) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, assetManager)) == null) {
                try {
                    return c(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        return a.b(resources, assetManager);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    }
                }
            }
            return (Resources) invokeLL.objValue;
        }

        public static Resources c(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, resources, assetManager)) == null) {
                Resources resources2 = (Resources) Reflect.a("android.content.res.HwResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a();
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            }
            return (Resources) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, assetManager)) == null) {
                try {
                    return c(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        return a.b(resources, assetManager);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    }
                }
            }
            return (Resources) invokeLL.objValue;
        }

        public static Resources c(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, resources, assetManager)) == null) {
                Resources resources2 = (Resources) Reflect.a("android.content.res.MiuiResourcesImpl").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a();
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            }
            return (Resources) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, assetManager)) == null) {
                try {
                    return c(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        return a.b(resources, assetManager);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    }
                }
            }
            return (Resources) invokeLL.objValue;
        }

        public static Resources c(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, resources, assetManager)) == null) {
                Resources resources2 = (Resources) Reflect.a("android.content.res.MiuiResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a();
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            }
            return (Resources) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, assetManager)) == null) {
                try {
                    return c(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        return a.b(resources, assetManager);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    }
                }
            }
            return (Resources) invokeLL.objValue;
        }

        public static Resources c(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, resources, assetManager)) == null) {
                Resources resources2 = (Resources) Reflect.a("android.content.res.NubiaResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a();
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            }
            return (Resources) invokeLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Context context, Resources resources, AssetManager assetManager) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, resources, assetManager)) == null) {
                try {
                    return c(context, resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        return a.b(resources, assetManager);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    }
                }
            }
            return (Resources) invokeLLL.objValue;
        }

        public static Resources c(Context context, Resources resources, AssetManager assetManager) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, resources, assetManager)) == null) {
                Resources resources2 = (Resources) Reflect.a("android.content.res.VivoResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a();
                if (resources2 != null) {
                    try {
                        Reflect.a(resources2).a("init", new Class[]{String.class}, context.getPackageName());
                    } catch (Reflect.ReflectException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        Reflect.a(resources2).a("mThemeValues", Reflect.a(resources).b("mThemeValues"));
                    } catch (Reflect.ReflectException e3) {
                        e3.printStackTrace();
                    }
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            }
            return (Resources) invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1711378312, "Lcom/kwad/sdk/api/loader/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1711378312, "Lcom/kwad/sdk/api/loader/o;");
                return;
            }
        }
        a = new HashMap();
        f57616b = new Object();
    }

    public static Resources a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, assetManager, displayMetrics, configuration)) == null) {
            Resources resources = context.getResources();
            return a(resources) ? d.b(resources, assetManager) : b(resources) ? c.b(resources, assetManager) : e(resources) ? b.b(resources, assetManager) : c(resources) ? f.b(context, resources, assetManager) : d(resources) ? e.b(resources, assetManager) : f(resources) ? a.b(resources, assetManager) : new Resources(assetManager, displayMetrics, configuration);
        }
        return (Resources) invokeLLLL.objValue;
    }

    @NonNull
    public static Resources a(Context context, Resources resources, String str) {
        InterceptResult invokeLLL;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, resources, str)) == null) {
            synchronized (f57616b) {
                resources2 = a.get(str);
                if (resources2 == null) {
                    resources2 = b(context, resources, str);
                    if (resources2 == null) {
                        throw new RuntimeException("Can not createResources for " + str);
                    }
                    a.put(str, resources);
                }
            }
            return resources2;
        }
        return (Resources) invokeLLL.objValue;
    }

    public static void a(AssetManager assetManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, assetManager, str) == null) {
            try {
                Reflect.a(assetManager).a("addOverlayPath", new Class[]{String.class}, str);
            } catch (Throwable unused) {
                Reflect.a(assetManager).a(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
            }
        }
    }

    public static boolean a(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources)) == null) ? "android.content.res.MiuiResources".equals(resources.getClass().getName()) : invokeL.booleanValue;
    }

    public static int b(AssetManager assetManager, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, assetManager, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    Reflect.a(assetManager).a("addAssetPathAsSharedLibrary", new Class[]{String.class}, str);
                } else {
                    Reflect.a(assetManager).a(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
                }
            } catch (Throwable unused) {
                Reflect.a(assetManager).a(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static Resources b(Context context, Resources resources, String str) {
        InterceptResult invokeLLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, resources, str)) == null) {
            AssetManager assetManager = (AssetManager) Reflect.a((Class<?>) AssetManager.class).b().a();
            Reflect.a(assetManager).a(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
            if (Build.VERSION.SDK_INT >= 21) {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                try {
                    Object b2 = Reflect.a(applicationInfo).b("resourceDirs");
                    if (b2 != null && b2.getClass().isArray()) {
                        Object[] objArr = (Object[]) b2;
                        if (objArr.length > 0) {
                            for (Object obj : objArr) {
                                if (obj instanceof String) {
                                    a(assetManager, (String) obj);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    if (applicationInfo.sharedLibraryFiles != null && applicationInfo.sharedLibraryFiles.length > 0) {
                        for (String str2 : applicationInfo.sharedLibraryFiles) {
                            if (str2 != null && str2.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX)) {
                                b(assetManager, str2);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            return a(context, assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        }
        return (Resources) invokeLLL.objValue;
    }

    public static boolean b(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, resources)) == null) ? "android.content.res.MiuiResourcesImpl".equals(resources.getClass().getName()) : invokeL.booleanValue;
    }

    public static boolean c(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, resources)) == null) ? "android.content.res.VivoResources".equals(resources.getClass().getName()) : invokeL.booleanValue;
    }

    public static boolean d(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, resources)) == null) ? "android.content.res.NubiaResources".equals(resources.getClass().getName()) : invokeL.booleanValue;
    }

    public static boolean e(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, resources)) == null) ? "android.content.res.HwResources".equals(resources.getClass().getName()) : invokeL.booleanValue;
    }

    public static boolean f(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, resources)) == null) ? !"android.content.res.Resources".equals(resources.getClass().getName()) : invokeL.booleanValue;
    }
}
