package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.v8engine.V8Engine;
import com.kwad.sdk.api.loader.Reflect;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Resources> f31845a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f31846b = new Object();

    /* loaded from: classes6.dex */
    public static final class a {
        public static Resources b(Resources resources, AssetManager assetManager) {
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
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static Resources b(Resources resources, AssetManager assetManager) {
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

        public static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.a("android.content.res.HwResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static Resources b(Resources resources, AssetManager assetManager) {
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

        public static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.a("android.content.res.MiuiResourcesImpl").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: classes6.dex */
    public static final class d {
        public static Resources b(Resources resources, AssetManager assetManager) {
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

        public static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.a("android.content.res.MiuiResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: classes6.dex */
    public static final class e {
        public static Resources b(Resources resources, AssetManager assetManager) {
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

        public static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.a("android.content.res.NubiaResources").a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a();
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: classes6.dex */
    public static final class f {
        public static Resources b(Context context, Resources resources, AssetManager assetManager) {
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

        public static Resources c(Context context, Resources resources, AssetManager assetManager) {
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
    }

    public static Resources a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        Resources resources = context.getResources();
        return a(resources) ? d.b(resources, assetManager) : b(resources) ? c.b(resources, assetManager) : e(resources) ? b.b(resources, assetManager) : c(resources) ? f.b(context, resources, assetManager) : d(resources) ? e.b(resources, assetManager) : f(resources) ? a.b(resources, assetManager) : new Resources(assetManager, displayMetrics, configuration);
    }

    @NonNull
    public static Resources a(Context context, Resources resources, String str) {
        Resources resources2;
        synchronized (f31846b) {
            resources2 = f31845a.get(str);
            if (resources2 == null) {
                resources2 = b(context, resources, str);
                if (resources2 == null) {
                    throw new RuntimeException("Can not createResources for " + str);
                }
                f31845a.put(str, resources);
            }
        }
        return resources2;
    }

    public static void a(AssetManager assetManager, String str) {
        try {
            Reflect.a(assetManager).a("addOverlayPath", new Class[]{String.class}, str);
        } catch (Throwable unused) {
            Reflect.a(assetManager).a(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
        }
    }

    public static boolean a(Resources resources) {
        return "android.content.res.MiuiResources".equals(resources.getClass().getName());
    }

    public static int b(AssetManager assetManager, String str) {
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

    public static Resources b(Context context, Resources resources, String str) {
        String[] strArr;
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

    public static boolean b(Resources resources) {
        return "android.content.res.MiuiResourcesImpl".equals(resources.getClass().getName());
    }

    public static boolean c(Resources resources) {
        return "android.content.res.VivoResources".equals(resources.getClass().getName());
    }

    public static boolean d(Resources resources) {
        return "android.content.res.NubiaResources".equals(resources.getClass().getName());
    }

    public static boolean e(Resources resources) {
        return "android.content.res.HwResources".equals(resources.getClass().getName());
    }

    public static boolean f(Resources resources) {
        return !"android.content.res.Resources".equals(resources.getClass().getName());
    }
}
