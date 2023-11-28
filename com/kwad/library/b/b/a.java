package com.kwad.library.b.b;

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
import com.kwad.sdk.utils.s;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class a {
    public static Map<String, Resources> ais = new HashMap();
    public static final Object ait = new Object();

    /* renamed from: com.kwad.library.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0687a {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) s.a(resources.getClass(), assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception unused) {
                return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return c(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C0687a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        public static Resources c(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.g("android.content.res.HwResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: classes10.dex */
    public static final class c {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return e(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C0687a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        public static Resources e(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.g("android.content.res.MiuiResourcesImpl", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: classes10.dex */
    public static final class d {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                try {
                    return g(resources, assetManager);
                } catch (Exception unused) {
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            } catch (Exception unused2) {
                return C0687a.a(resources, assetManager);
            }
        }

        public static Resources g(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.g("android.content.res.MiuiResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: classes10.dex */
    public static final class e {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                return i(resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C0687a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        public static Resources i(Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.g("android.content.res.NubiaResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    /* loaded from: classes10.dex */
    public static final class f {
        public static Resources a(Context context, Resources resources, AssetManager assetManager) {
            try {
                return b(context, resources, assetManager);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return C0687a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        public static Resources b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) s.g("android.content.res.VivoResources", assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
            if (resources2 != null) {
                try {
                    s.g(resources2, "init", context.getPackageName());
                } catch (Exception e) {
                    com.kwad.library.solder.lib.a.e("ResourcesManager", "createVivoResources init failed", e);
                }
                try {
                    s.b(resources2, "mThemeValues", s.f(resources, "mThemeValues"));
                } catch (Exception e2) {
                    com.kwad.library.solder.lib.a.e("ResourcesManager", "createVivoResources set mThemeValues failed", e2);
                }
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    public static Resources a(Context context, AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        Resources resources = context.getResources();
        if (a(resources)) {
            return d.a(resources, assetManager);
        }
        if (b(resources)) {
            return c.a(resources, assetManager);
        }
        if (e(resources)) {
            return b.a(resources, assetManager);
        }
        if (c(resources)) {
            return f.a(context, resources, assetManager);
        }
        if (d(resources)) {
            return e.a(resources, assetManager);
        }
        if (f(resources)) {
            return C0687a.a(resources, assetManager);
        }
        return new Resources(assetManager, displayMetrics, configuration);
    }

    @NonNull
    public static Resources a(Context context, Resources resources, String str) {
        Resources resources2;
        synchronized (ait) {
            resources2 = ais.get(str);
            if (resources2 == null) {
                resources2 = b(context, resources, str);
                if (resources2 != null) {
                    ais.put(str, resources);
                } else {
                    throw new RuntimeException("Can not createResources for " + str);
                }
            }
        }
        return resources2;
    }

    public static void a(AssetManager assetManager, String str) {
        try {
            s.g(assetManager, "addOverlayPath", str);
        } catch (Throwable unused) {
            s.g(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, str);
        }
    }

    public static int b(AssetManager assetManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                s.g(assetManager, "addAssetPathAsSharedLibrary", str);
            } else {
                s.g(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, str);
            }
        } catch (Throwable unused) {
            s.g(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, str);
        }
        return 0;
    }

    public static boolean a(Resources resources) {
        return "android.content.res.MiuiResources".equals(resources.getClass().getName());
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
        if (!"android.content.res.Resources".equals(resources.getClass().getName())) {
            return true;
        }
        return false;
    }

    public static Resources b(Context context, Resources resources, String str) {
        String[] strArr;
        AssetManager assetManager = (AssetManager) s.i(AssetManager.class);
        s.g(assetManager, V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, str);
        if (Build.VERSION.SDK_INT >= 21) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            try {
                Object field = s.getField(applicationInfo, "resourceDirs");
                if (field != null && field.getClass().isArray()) {
                    Object[] objArr = (Object[]) field;
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
}
