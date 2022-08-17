package com.kwai.sodler.lib.kwai.a;

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
import com.kwad.sdk.utils.q;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Resources> axH;
    public static final Object axI;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwai.sodler.lib.kwai.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0420a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, resources, assetManager)) == null) {
                try {
                    Resources resources2 = (Resources) q.a(resources.getClass(), assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
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

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, resources, assetManager)) == null) {
                try {
                    return d(resources, assetManager);
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        return C0420a.b(resources, assetManager);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    }
                }
            }
            return (Resources) invokeLL.objValue;
        }

        public static Resources d(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, assetManager)) == null) {
                Resources resources2 = (Resources) q.b("android.content.res.HwResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            }
            return (Resources) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, resources, assetManager)) == null) {
                try {
                    return f(resources, assetManager);
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        return C0420a.b(resources, assetManager);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    }
                }
            }
            return (Resources) invokeLL.objValue;
        }

        public static Resources f(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, assetManager)) == null) {
                Resources resources2 = (Resources) q.b("android.content.res.MiuiResourcesImpl", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            }
            return (Resources) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, resources, assetManager)) == null) {
                try {
                    return h(resources, assetManager);
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        return C0420a.b(resources, assetManager);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    }
                }
            }
            return (Resources) invokeLL.objValue;
        }

        public static Resources h(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, assetManager)) == null) {
                Resources resources2 = (Resources) q.b("android.content.res.MiuiResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            }
            return (Resources) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources b(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, resources, assetManager)) == null) {
                try {
                    return j(resources, assetManager);
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        return C0420a.b(resources, assetManager);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    }
                }
            }
            return (Resources) invokeLL.objValue;
        }

        public static Resources j(Resources resources, AssetManager assetManager) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, assetManager)) == null) {
                Resources resources2 = (Resources) q.b("android.content.res.NubiaResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            }
            return (Resources) invokeLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Resources c(Context context, Resources resources, AssetManager assetManager) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, resources, assetManager)) == null) {
                try {
                    return d(context, resources, assetManager);
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        return C0420a.b(resources, assetManager);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    }
                }
            }
            return (Resources) invokeLLL.objValue;
        }

        public static Resources d(Context context, Resources resources, AssetManager assetManager) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, resources, assetManager)) == null) {
                Resources resources2 = (Resources) q.b("android.content.res.VivoResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                if (resources2 != null) {
                    try {
                        q.b((Object) resources2, "init", context.getPackageName());
                    } catch (Exception e) {
                        com.kwai.sodler.lib.a.e("ResourcesManager", "createVivoResources init failed", e);
                    }
                    try {
                        q.b(resources2, "mThemeValues", q.d(resources, "mThemeValues"));
                    } catch (Exception e2) {
                        com.kwai.sodler.lib.a.e("ResourcesManager", "createVivoResources set mThemeValues failed", e2);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2108306108, "Lcom/kwai/sodler/lib/kwai/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2108306108, "Lcom/kwai/sodler/lib/kwai/a/a;");
                return;
            }
        }
        axH = new HashMap();
        axI = new Object();
    }

    public static Resources a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, assetManager, displayMetrics, configuration)) == null) {
            Resources resources = context.getResources();
            return a(resources) ? d.b(resources, assetManager) : b(resources) ? c.b(resources, assetManager) : e(resources) ? b.b(resources, assetManager) : c(resources) ? f.c(context, resources, assetManager) : d(resources) ? e.b(resources, assetManager) : f(resources) ? C0420a.b(resources, assetManager) : new Resources(assetManager, displayMetrics, configuration);
        }
        return (Resources) invokeLLLL.objValue;
    }

    public static boolean a(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, resources)) == null) ? "android.content.res.MiuiResources".equals(resources.getClass().getName()) : invokeL.booleanValue;
    }

    public static void b(AssetManager assetManager, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, assetManager, str) == null) {
            try {
                q.b((Object) assetManager, "addOverlayPath", str);
            } catch (Throwable unused) {
                q.b((Object) assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, str);
            }
        }
    }

    public static boolean b(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources)) == null) ? "android.content.res.MiuiResourcesImpl".equals(resources.getClass().getName()) : invokeL.booleanValue;
    }

    public static int c(AssetManager assetManager, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, assetManager, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    q.b((Object) assetManager, "addAssetPathAsSharedLibrary", str);
                } else {
                    q.b((Object) assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, str);
                }
            } catch (Throwable unused) {
                q.b((Object) assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, str);
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    @NonNull
    public static Resources c(Context context, Resources resources, String str) {
        InterceptResult invokeLLL;
        Resources resources2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, resources, str)) == null) {
            synchronized (axI) {
                resources2 = axH.get(str);
                if (resources2 == null) {
                    resources2 = d(context, resources, str);
                    if (resources2 == null) {
                        throw new RuntimeException("Can not createResources for " + str);
                    }
                    axH.put(str, resources);
                }
            }
            return resources2;
        }
        return (Resources) invokeLLL.objValue;
    }

    public static boolean c(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, resources)) == null) ? "android.content.res.VivoResources".equals(resources.getClass().getName()) : invokeL.booleanValue;
    }

    public static Resources d(Context context, Resources resources, String str) {
        InterceptResult invokeLLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, resources, str)) == null) {
            AssetManager assetManager = (AssetManager) q.g(AssetManager.class);
            q.b((Object) assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, str);
            if (Build.VERSION.SDK_INT >= 21) {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                try {
                    Object c2 = q.c(applicationInfo, "resourceDirs");
                    if (c2 != null && c2.getClass().isArray()) {
                        Object[] objArr = (Object[]) c2;
                        if (objArr.length > 0) {
                            for (Object obj : objArr) {
                                if (obj instanceof String) {
                                    b(assetManager, (String) obj);
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
                                c(assetManager, str2);
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
