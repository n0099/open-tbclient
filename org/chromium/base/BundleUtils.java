package org.chromium.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.compat.ApiHelperForO;
import org.chromium.base.metrics.RecordHistogram;
/* loaded from: classes2.dex */
public final class BundleUtils {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static Boolean sIsBundle;
    public static final Object sSplitLock = new Object();
    public static final SimpleArrayMap<String, ClassLoader> sCachedClassLoaders = new SimpleArrayMap<>();

    public static Object getSplitContextLock() {
        return sSplitLock;
    }

    public static boolean isBundle() {
        if (!BuildConfig.BUNDLES_SUPPORTED) {
            return false;
        }
        return sIsBundle.booleanValue();
    }

    @CalledByNative
    public static boolean isBundleForNative() {
        return isBundle();
    }

    @CalledByNative
    public static boolean isolatedSplitsEnabled() {
        return BuildConfig.ISOLATED_SPLITS_ENABLED;
    }

    public static Context createIsolatedSplitContext(Context context, String str) {
        Context createContextForSplit;
        boolean z;
        if (Build.VERSION.SDK_INT < 26) {
            return context;
        }
        try {
            if (isApplicationContext(context)) {
                createContextForSplit = ApiHelperForO.createContextForSplit(context, str);
            } else {
                synchronized (getSplitContextLock()) {
                    createContextForSplit = ApiHelperForO.createContextForSplit(context, str);
                }
            }
            ClassLoader parent = createContextForSplit.getClassLoader().getParent();
            Context applicationContext = ContextUtils.getApplicationContext();
            boolean z2 = true;
            if (isolatedSplitsEnabled() && !parent.equals(BundleUtils.class.getClassLoader()) && applicationContext != null && !parent.equals(applicationContext.getClassLoader())) {
                z = true;
            } else {
                z = false;
            }
            synchronized (sCachedClassLoaders) {
                if (z && !sCachedClassLoaders.containsKey(str)) {
                    sCachedClassLoaders.put(str, new PathClassLoader(createContextForSplit.getApplicationInfo().splitSourceDirs[Arrays.binarySearch(ApiHelperForO.getSplitNames(createContextForSplit.getApplicationInfo()), str)], applicationContext.getClassLoader()));
                }
                ClassLoader classLoader = sCachedClassLoaders.get(str);
                if (classLoader != null) {
                    if (!classLoader.equals(createContextForSplit.getClassLoader())) {
                        replaceClassLoader(createContextForSplit, classLoader);
                    }
                } else {
                    sCachedClassLoaders.put(str, createContextForSplit.getClassLoader());
                }
                z2 = z;
            }
            RecordHistogram.recordBooleanHistogram("Android.IsolatedSplits.ClassLoaderReplaced." + str, z2);
            return createContextForSplit;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    public static String getNativeLibraryPath(String str) {
        return getNativeLibraryPath(str, "");
    }

    public static boolean isApplicationContext(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Application) {
                return true;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return false;
    }

    public static void setIsBundle(boolean z) {
        sIsBundle = Boolean.valueOf(z);
    }

    @Nullable
    @CalledByNative
    public static String getNativeLibraryPath(String str, String str2) {
        StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
        try {
            String findLibrary = ((BaseDexClassLoader) BundleUtils.class.getClassLoader()).findLibrary(str);
            if (findLibrary != null) {
                if (allowDiskReads != null) {
                    allowDiskReads.close();
                }
                return findLibrary;
            }
            String findLibrary2 = ((BaseDexClassLoader) ContextUtils.getApplicationContext().getClassLoader()).findLibrary(str);
            if (findLibrary2 != null) {
                if (allowDiskReads != null) {
                    allowDiskReads.close();
                }
                return findLibrary2;
            }
            String splitApkLibraryPath = getSplitApkLibraryPath(str, str2);
            if (allowDiskReads != null) {
                allowDiskReads.close();
            }
            return splitApkLibraryPath;
        } catch (Throwable th) {
            if (allowDiskReads != null) {
                try {
                    allowDiskReads.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Nullable
    public static String getSplitApkLibraryPath(String str, String str2) {
        ApplicationInfo applicationInfo;
        String[] splitNames;
        int binarySearch;
        if (Build.VERSION.SDK_INT < 26 || (splitNames = ApiHelperForO.getSplitNames((applicationInfo = ContextUtils.getApplicationContext().getApplicationInfo()))) == null || (binarySearch = Arrays.binarySearch(splitNames, str2)) < 0) {
            return null;
        }
        try {
            return applicationInfo.splitSourceDirs[binarySearch] + "!/lib/" + ((String) applicationInfo.getClass().getField("primaryCpuAbi").get(applicationInfo)) + "/" + System.mapLibraryName(str);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isIsolatedSplitInstalled(Context context, String str) {
        String[] splitNames;
        if (Build.VERSION.SDK_INT < 26 || (splitNames = ApiHelperForO.getSplitNames(context.getApplicationInfo())) == null || !Arrays.asList(splitNames).contains(str)) {
            return false;
        }
        return true;
    }

    public static void replaceClassLoader(Context context, ClassLoader classLoader) {
        while (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        try {
            Field declaredField = context.getClass().getDeclaredField("mClassLoader");
            declaredField.setAccessible(true);
            declaredField.set(context, classLoader);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Error setting ClassLoader.", e);
        }
    }
}
