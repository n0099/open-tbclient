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
/* loaded from: classes10.dex */
public final class r {
    public static Map<String, Resources> SH = new HashMap();
    public static final Object b = new Object();

    /* loaded from: classes10.dex */
    public static final class a {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) Reflect.a(resources.getClass()).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a;
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
                Resources resources2 = (Resources) Reflect.a(Reflect.be("android.content.res.HwResources")).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a;
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class c {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) Reflect.a(Reflect.be("android.content.res.MiuiResourcesImpl")).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a;
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class d {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) Reflect.a(Reflect.be("android.content.res.MiuiResources")).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a;
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class e {
        public static Resources a(Resources resources, AssetManager assetManager) {
            try {
                Resources resources2 = (Resources) Reflect.a(Reflect.be("android.content.res.NubiaResources")).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a;
                if (resources2 != null) {
                    return resources2;
                }
                throw new RuntimeException("Can not create Resources");
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    return a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
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
                    return a.a(resources, assetManager);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                }
            }
        }

        public static Resources b(Context context, Resources resources, AssetManager assetManager) {
            Resources resources2 = (Resources) Reflect.a(Reflect.be("android.content.res.VivoResources")).a(new Class[]{AssetManager.class, DisplayMetrics.class, Configuration.class}, assetManager, resources.getDisplayMetrics(), resources.getConfiguration()).a;
            if (resources2 != null) {
                try {
                    Reflect.b(resources2).a("init", new Class[]{String.class}, context.getPackageName());
                } catch (Reflect.ReflectException e) {
                    e.printStackTrace();
                }
                try {
                    Reflect.b(resources2).a("mThemeValues", Reflect.b(resources).ba("mThemeValues"));
                } catch (Reflect.ReflectException e2) {
                    e2.printStackTrace();
                }
                return resources2;
            }
            throw new RuntimeException("Can not create Resources");
        }
    }

    public static int a(AssetManager assetManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Reflect.b(assetManager).a("addAssetPathAsSharedLibrary", new Class[]{String.class}, str);
            } else {
                Reflect.b(assetManager).a(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
            }
        } catch (Throwable unused) {
            Reflect.b(assetManager).a(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
        }
        return 0;
    }

    @NonNull
    public static Resources a(Context context, Resources resources, String str) {
        Resources resources2;
        synchronized (b) {
            resources2 = SH.get(str);
            if (resources2 == null) {
                resources2 = b(context, resources, str);
                if (resources2 == null) {
                    throw new RuntimeException("Can not createResources for ".concat(String.valueOf(str)));
                }
                SH.put(str, resources);
            }
        }
        return resources2;
    }

    public static Resources b(Context context, Resources resources, String str) {
        String[] strArr;
        AssetManager assetManager = (AssetManager) Reflect.a(AssetManager.class).a(new Class[0], new Object[0]).a;
        Reflect.b(assetManager).a(V8Engine.ALTERNATIVE_ADD_ASSET_PATH_METHOD, new Class[]{String.class}, str);
        if (Build.VERSION.SDK_INT >= 21) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            try {
                Object ba = Reflect.b(applicationInfo).ba("resourceDirs");
                if (ba != null && ba.getClass().isArray()) {
                    Object[] objArr = (Object[]) ba;
                    if (objArr.length > 0) {
                        for (Object obj : objArr) {
                            if (obj instanceof String) {
                                Reflect.b(assetManager).a("addOverlayPath", new Class[]{String.class}, (String) obj);
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
                            a(assetManager, str2);
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        Resources resources2 = context.getResources();
        return "android.content.res.MiuiResources".equals(resources2.getClass().getName()) ? d.a(resources2, assetManager) : "android.content.res.MiuiResourcesImpl".equals(resources2.getClass().getName()) ? c.a(resources2, assetManager) : "android.content.res.HwResources".equals(resources2.getClass().getName()) ? b.a(resources2, assetManager) : "android.content.res.VivoResources".equals(resources2.getClass().getName()) ? f.a(context, resources2, assetManager) : "android.content.res.NubiaResources".equals(resources2.getClass().getName()) ? e.a(resources2, assetManager) : "android.content.res.Resources".equals(resources2.getClass().getName()) ^ true ? a.a(resources2, assetManager) : new Resources(assetManager, displayMetrics, configuration);
    }
}
