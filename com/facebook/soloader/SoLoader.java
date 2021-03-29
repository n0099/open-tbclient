package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class SoLoader {
    public static final boolean DEBUG = false;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final String SO_STORE_NAME_MAIN = "lib-main";
    public static final String SO_STORE_NAME_SPLIT = "lib-";
    public static final boolean SYSTRACE_LIBRARY_LOADING;
    public static final String TAG = "SoLoader";
    @GuardedBy("sSoSourcesLock")
    @Nullable
    public static ApplicationSoSource sApplicationSoSource;
    @GuardedBy("sSoSourcesLock")
    @Nullable
    public static UnpackingSoSource[] sBackupSoSources;
    @GuardedBy("sSoSourcesLock")
    public static int sFlags;
    @Nullable
    public static SoFileLoader sSoFileLoader;
    public static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    @GuardedBy("sSoSourcesLock")
    @Nullable
    public static SoSource[] sSoSources = null;
    public static int sSoSourcesVersion = 0;
    @GuardedBy("SoLoader.class")
    public static final HashSet<String> sLoadedLibraries = new HashSet<>();
    @GuardedBy("SoLoader.class")
    public static final Map<String, Object> sLoadingLibraries = new HashMap();
    public static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    @Nullable
    public static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    @DoNotOptimize
    @TargetApi(14)
    /* loaded from: classes6.dex */
    public static class Api14Utils {
        public static String getClassLoaderLdLoadLibrary() {
            ClassLoader classLoader = SoLoader.class.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e2) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e2);
                }
            }
            throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
        }
    }

    /* loaded from: classes6.dex */
    public static final class WrongAbiError extends UnsatisfiedLinkError {
        public WrongAbiError(Throwable th) {
            super("APK was built for a different platform");
            initCause(th);
        }
    }

    static {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        SYSTRACE_LIBRARY_LOADING = z;
    }

    public static boolean areSoSourcesAbisSupported() {
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                String[] supportedAbis = SysUtil.getSupportedAbis();
                for (int i = 0; i < sSoSources.length; i++) {
                    String[] soSourceAbis = sSoSources[i].getSoSourceAbis();
                    for (int i2 = 0; i2 < soSourceAbis.length; i2++) {
                        boolean z = false;
                        for (int i3 = 0; i3 < supportedAbis.length && !z; i3++) {
                            z = soSourceAbis[i2].equals(supportedAbis[i3]);
                        }
                        if (!z) {
                            Log.e("SoLoader", "abi not supported: " + soSourceAbis[i2]);
                        }
                    }
                }
                sSoSourcesLock.readLock().unlock();
                return true;
            }
            return false;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static void assertInitialized() {
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                return;
            }
            throw new RuntimeException("SoLoader.init() not yet called");
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static void deinitForTest() {
        setSoSources(null);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[SGET]}, finally: {[SGET, RETURN, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, INVOKE, RETURN, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, IF, INVOKE, RETURN, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, INVOKE, RETURN, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, IF, IF] complete} */
    public static void doLoadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        boolean z;
        UnsatisfiedLinkError unsatisfiedLinkError;
        boolean z2;
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                sSoSourcesLock.readLock().unlock();
                if (threadPolicy == null) {
                    threadPolicy = StrictMode.allowThreadDiskReads();
                    z = true;
                } else {
                    z = false;
                }
                if (SYSTRACE_LIBRARY_LOADING) {
                    Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[" + str + "]");
                }
                int i2 = 0;
                do {
                    try {
                        sSoSourcesLock.readLock().lock();
                        int i3 = sSoSourcesVersion;
                        int i4 = 0;
                        while (true) {
                            if (i2 != 0 || i4 >= sSoSources.length) {
                                break;
                            }
                            i2 = sSoSources[i4].loadLibrary(str, i, threadPolicy);
                            if (i2 == 3 && sBackupSoSources != null) {
                                Log.d("SoLoader", "Trying backup SoSource for " + str);
                                UnpackingSoSource[] unpackingSoSourceArr = sBackupSoSources;
                                int length = unpackingSoSourceArr.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        break;
                                    }
                                    UnpackingSoSource unpackingSoSource = unpackingSoSourceArr[i5];
                                    unpackingSoSource.prepare(str);
                                    int loadLibrary = unpackingSoSource.loadLibrary(str, i, threadPolicy);
                                    if (loadLibrary == 1) {
                                        i2 = loadLibrary;
                                        break;
                                    }
                                    i5++;
                                }
                            } else {
                                i4++;
                            }
                        }
                        sSoSourcesLock.readLock().unlock();
                        if ((i & 2) == 2 && i2 == 0) {
                            sSoSourcesLock.writeLock().lock();
                            if (sApplicationSoSource != null && sApplicationSoSource.checkAndMaybeUpdate()) {
                                sSoSourcesVersion++;
                            }
                            z2 = sSoSourcesVersion != i3;
                            sSoSourcesLock.writeLock().unlock();
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                    } finally {
                        if (i2 == 0 || i2 == r6) {
                        }
                    }
                } while (z2);
                if (SYSTRACE_LIBRARY_LOADING) {
                    Api18TraceUtils.endSection();
                }
                if (z) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                if (i2 == 0 || i2 == 3) {
                    String str2 = "couldn't find DSO to load: " + str;
                    Log.e("SoLoader", str2);
                    throw new UnsatisfiedLinkError(str2);
                }
                return;
            }
            Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
            throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    @Nullable
    public static Method getNativeLoadRuntimeMethod() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23 && i <= 27) {
            try {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException | SecurityException e2) {
                Log.w("SoLoader", "Cannot get nativeLoad method", e2);
            }
        }
        return null;
    }

    public static void init(Context context, int i) throws IOException {
        init(context, i, null);
    }

    public static synchronized void initSoLoader(@Nullable SoFileLoader soFileLoader) {
        synchronized (SoLoader.class) {
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            final boolean z = nativeLoadRuntimeMethod != null;
            final String classLoaderLdLoadLibrary = z ? Api14Utils.getClassLoaderLdLoadLibrary() : null;
            final String makeNonZipPath = makeNonZipPath(classLoaderLdLoadLibrary);
            sSoFileLoader = new SoFileLoader() { // from class: com.facebook.soloader.SoLoader.1
                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                private String getLibHash(String str) {
                    try {
                        File file = new File(str);
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        FileInputStream fileInputStream = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read > 0) {
                                    messageDigest.update(bArr, 0, read);
                                } else {
                                    String format = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                                    fileInputStream.close();
                                    return format;
                                }
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        }
                    } catch (IOException e2) {
                        return e2.toString();
                    } catch (SecurityException e3) {
                        return e3.toString();
                    } catch (NoSuchAlgorithmException e4) {
                        return e4.toString();
                    }
                }

                /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x009b */
                /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.lang.String */
                /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
                    if (r1 == null) goto L21;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
                    android.util.Log.e("SoLoader", "Error when loading lib: " + r1 + " lib hash: " + getLibHash(r9) + " search path is " + r10);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
                    return;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:45:0x009e  */
                /* JADX WARN: Type inference failed for: r1v0 */
                /* JADX WARN: Type inference failed for: r1v2 */
                @Override // com.facebook.soloader.SoFileLoader
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void load(String str, int i) {
                    Throwable th;
                    Throwable e2;
                    if (z) {
                        String str2 = 1;
                        String str3 = (i & 4) == 4 ? classLoaderLdLoadLibrary : makeNonZipPath;
                        try {
                            try {
                                try {
                                    synchronized (runtime) {
                                        try {
                                            String str4 = (String) nativeLoadRuntimeMethod.invoke(runtime, str, SoLoader.class.getClassLoader(), str3);
                                            if (str4 != null) {
                                                throw new UnsatisfiedLinkError(str4);
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                                try {
                                    throw th;
                                } catch (IllegalAccessException e3) {
                                    e2 = e3;
                                    throw new RuntimeException("Error: Cannot load " + str, e2);
                                } catch (IllegalArgumentException e4) {
                                    e2 = e4;
                                    throw new RuntimeException("Error: Cannot load " + str, e2);
                                } catch (InvocationTargetException e5) {
                                    e2 = e5;
                                    throw new RuntimeException("Error: Cannot load " + str, e2);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (str2 != 0) {
                                    Log.e("SoLoader", "Error when loading lib: " + str2 + " lib hash: " + getLibHash(str) + " search path is " + str3);
                                }
                                throw th;
                            }
                        } catch (IllegalAccessException e6) {
                            e = e6;
                            e2 = e;
                            throw new RuntimeException("Error: Cannot load " + str, e2);
                        } catch (IllegalArgumentException e7) {
                            e = e7;
                            e2 = e;
                            throw new RuntimeException("Error: Cannot load " + str, e2);
                        } catch (InvocationTargetException e8) {
                            e = e8;
                            e2 = e;
                            throw new RuntimeException("Error: Cannot load " + str, e2);
                        } catch (Throwable th5) {
                            str2 = 0;
                            th = th5;
                            if (str2 != 0) {
                            }
                            throw th;
                        }
                    }
                    System.load(str);
                }
            };
        }
    }

    public static void initSoSources(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        int i2;
        ApkSoSource apkSoSource;
        sSoSourcesLock.writeLock().lock();
        try {
            if (sSoSources == null) {
                Log.d("SoLoader", "init start");
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                String str = System.getenv("LD_LIBRARY_PATH");
                if (str == null) {
                    str = "/vendor/lib:/system/lib";
                }
                String[] split = str.split(":");
                for (int i3 = 0; i3 < split.length; i3++) {
                    Log.d("SoLoader", "adding system library source: " + split[i3]);
                    arrayList.add(new DirectorySoSource(new File(split[i3]), 2));
                }
                if (context != null) {
                    if ((i & 1) != 0) {
                        sBackupSoSources = null;
                        Log.d("SoLoader", "adding exo package source: lib-main");
                        arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                    } else {
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        if ((applicationInfo.flags & 1) != 0 && (applicationInfo.flags & 128) == 0) {
                            i2 = 0;
                        } else {
                            sApplicationSoSource = new ApplicationSoSource(context, Build.VERSION.SDK_INT <= 17 ? 1 : 0);
                            Log.d("SoLoader", "adding application source: " + sApplicationSoSource.toString());
                            arrayList.add(0, sApplicationSoSource);
                            i2 = 1;
                        }
                        if ((sFlags & 8) != 0) {
                            sBackupSoSources = null;
                        } else {
                            File file = new File(context.getApplicationInfo().sourceDir);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(new ApkSoSource(context, file, SO_STORE_NAME_MAIN, i2));
                            Log.d("SoLoader", "adding backup source from : " + apkSoSource.toString());
                            if (Build.VERSION.SDK_INT >= 21 && context.getApplicationInfo().splitSourceDirs != null) {
                                Log.d("SoLoader", "adding backup sources from split apks");
                                String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                int length = strArr.length;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < length) {
                                    File file2 = new File(strArr[i4]);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(SO_STORE_NAME_SPLIT);
                                    sb.append(i5);
                                    ApkSoSource apkSoSource2 = new ApkSoSource(context, file2, sb.toString(), i2);
                                    Log.d("SoLoader", "adding backup source: " + apkSoSource2.toString());
                                    arrayList2.add(apkSoSource2);
                                    i4++;
                                    i5++;
                                }
                            }
                            sBackupSoSources = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
                            arrayList.addAll(0, arrayList2);
                        }
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int makePrepareFlags = makePrepareFlags();
                int length2 = soSourceArr.length;
                while (true) {
                    int i6 = length2 - 1;
                    if (length2 <= 0) {
                        break;
                    }
                    Log.d("SoLoader", "Preparing SO source: " + soSourceArr[i6]);
                    soSourceArr[i6].prepare(makePrepareFlags);
                    length2 = i6;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion++;
                Log.d("SoLoader", "init finish: " + sSoSources.length + " SO sources prepared");
            }
        } finally {
            Log.d("SoLoader", "init exiting");
            sSoSourcesLock.writeLock().unlock();
        }
    }

    public static boolean loadLibrary(String str) {
        return loadLibrary(str, 0);
    }

    public static void loadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        loadLibraryBySoName(str, null, null, i, threadPolicy);
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            Log.d("SoLoader", "makeLdLibraryPath");
            ArrayList arrayList = new ArrayList();
            for (SoSource soSource : sSoSources) {
                soSource.addToLdLibraryPath(arrayList);
            }
            String join = TextUtils.join(":", arrayList);
            Log.d("SoLoader", "makeLdLibraryPath final path: " + join);
            return join;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @Nullable
    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(":", arrayList);
    }

    public static int makePrepareFlags() {
        sSoSourcesLock.writeLock().lock();
        try {
            return (sFlags & 2) != 0 ? 1 : 0;
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        sSoSourcesLock.writeLock().lock();
        try {
            Log.d("SoLoader", "Prepending to SO sources: " + soSource);
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = new SoSource[sSoSources.length + 1];
            soSourceArr[0] = soSource;
            System.arraycopy(sSoSources, 0, soSourceArr, 1, sSoSources.length);
            sSoSources = soSourceArr;
            sSoSourcesVersion++;
            Log.d("SoLoader", "Prepended to SO sources: " + soSource);
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    public static void resetStatus() {
        synchronized (SoLoader.class) {
            sLoadedLibraries.clear();
            sLoadingLibraries.clear();
            sSoFileLoader = null;
        }
        setSoSources(null);
    }

    public static void setInTestMode() {
        setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void setSoFileLoader(SoFileLoader soFileLoader) {
        sSoFileLoader = soFileLoader;
    }

    public static void setSoSources(SoSource[] soSourceArr) {
        sSoSourcesLock.writeLock().lock();
        try {
            sSoSources = soSourceArr;
            sSoSourcesVersion++;
        } finally {
            sSoSourcesLock.writeLock().unlock();
        }
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        for (int i = 0; i < sSoSources.length; i++) {
            try {
                File unpackLibrary = sSoSources[i].unpackLibrary(str);
                if (unpackLibrary != null) {
                    return unpackLibrary;
                }
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        sSoSourcesLock.readLock().unlock();
        throw new FileNotFoundException(str);
    }

    public static void init(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        try {
            initSoLoader(soFileLoader);
            initSoSources(context, i, soFileLoader);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
        }
    }

    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        boolean z;
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        z = !sLoadedLibraries.contains(str);
                        if (z) {
                            if (sSystemLoadLibraryWrapper != null) {
                                sSystemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                    }
                    return z;
                }
            }
            sSoSourcesLock.readLock().unlock();
            String mapLibName = MergedSoMapping.mapLibName(str);
            return loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), str, mapLibName, i | 2, null);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean loadLibraryBySoName(String str, @Nullable String str2, @Nullable String str3, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        Object obj;
        boolean z2 = false;
        if (TextUtils.isEmpty(str2) || !sLoadedAndMergedLibraries.contains(str2)) {
            synchronized (SoLoader.class) {
                if (!sLoadedLibraries.contains(str)) {
                    z = false;
                } else if (str3 == null) {
                    return false;
                } else {
                    z = true;
                }
                if (sLoadingLibraries.containsKey(str)) {
                    obj = sLoadingLibraries.get(str);
                } else {
                    obj = new Object();
                    sLoadingLibraries.put(str, obj);
                }
                synchronized (obj) {
                    if (!z) {
                        synchronized (SoLoader.class) {
                            if (sLoadedLibraries.contains(str)) {
                                if (str3 == null) {
                                    return false;
                                }
                                z = true;
                            }
                            if (!z) {
                                try {
                                    try {
                                        Log.d("SoLoader", "About to load: " + str);
                                        doLoadLibraryBySoName(str, i, threadPolicy);
                                        synchronized (SoLoader.class) {
                                            Log.d("SoLoader", "Loaded: " + str);
                                            sLoadedLibraries.add(str);
                                        }
                                    } catch (IOException e2) {
                                        throw new RuntimeException(e2);
                                    }
                                } catch (UnsatisfiedLinkError e3) {
                                    String message = e3.getMessage();
                                    if (message != null && message.contains("unexpected e_machine:")) {
                                        throw new WrongAbiError(e3);
                                    }
                                    throw e3;
                                }
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str2) && sLoadedAndMergedLibraries.contains(str2)) {
                        z2 = true;
                    }
                    if (str3 != null && !z2) {
                        if (SYSTRACE_LIBRARY_LOADING) {
                            Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[" + str2 + "]");
                        }
                        Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                        MergedSoMapping.invokeJniOnload(str2);
                        sLoadedAndMergedLibraries.add(str2);
                        if (SYSTRACE_LIBRARY_LOADING) {
                            Api18TraceUtils.endSection();
                        }
                    }
                    return !z;
                }
            }
        }
        return false;
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
