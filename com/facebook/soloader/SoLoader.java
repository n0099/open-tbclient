package com.facebook.soloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes11.dex */
public class SoLoader {
    public static /* synthetic */ Interceptable $ic = null;
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
    public static final Set<String> sLoadedAndMergedLibraries;
    @GuardedBy("SoLoader.class")
    public static final HashSet<String> sLoadedLibraries;
    @GuardedBy("SoLoader.class")
    public static final Map<String, Object> sLoadingLibraries;
    @Nullable
    public static SoFileLoader sSoFileLoader;
    @GuardedBy("sSoSourcesLock")
    @Nullable
    public static SoSource[] sSoSources;
    public static final ReentrantReadWriteLock sSoSourcesLock;
    public static int sSoSourcesVersion;
    @Nullable
    public static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper;
    public transient /* synthetic */ FieldHolder $fh;

    @DoNotOptimize
    @TargetApi(14)
    /* loaded from: classes11.dex */
    public static class Api14Utils {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api14Utils() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static String getClassLoaderLdLoadLibrary() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
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
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class WrongAbiError extends UnsatisfiedLinkError {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WrongAbiError(Throwable th) {
            super("APK was built for a different platform");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            initCause(th);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1633503323, "Lcom/facebook/soloader/SoLoader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1633503323, "Lcom/facebook/soloader/SoLoader;");
                return;
            }
        }
        sSoSourcesLock = new ReentrantReadWriteLock();
        sSoSources = null;
        boolean z = false;
        sSoSourcesVersion = 0;
        sLoadedLibraries = new HashSet<>();
        sLoadingLibraries = new HashMap();
        sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
        sSystemLoadLibraryWrapper = null;
        try {
            if (Build.VERSION.SDK_INT >= 18) {
                z = true;
            }
        } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
        }
        SYSTRACE_LIBRARY_LOADING = z;
    }

    public SoLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean areSoSourcesAbisSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            sSoSourcesLock.readLock().lock();
            try {
                if (sSoSources != null) {
                    String[] supportedAbis = SysUtil.getSupportedAbis();
                    for (int i2 = 0; i2 < sSoSources.length; i2++) {
                        String[] soSourceAbis = sSoSources[i2].getSoSourceAbis();
                        for (int i3 = 0; i3 < soSourceAbis.length; i3++) {
                            boolean z = false;
                            for (int i4 = 0; i4 < supportedAbis.length && !z; i4++) {
                                z = soSourceAbis[i3].equals(supportedAbis[i4]);
                            }
                            if (!z) {
                                String str = "abi not supported: " + soSourceAbis[i3];
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
        return invokeV.booleanValue;
    }

    public static void assertInitialized() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
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
    }

    public static void deinitForTest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            setSoSources(null);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[SGET]}, finally: {[SGET, RETURN, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, INVOKE, RETURN, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, IF, INVOKE, RETURN, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, INVOKE, RETURN, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, INVOKE, CONSTRUCTOR, INVOKE, CONST_STR, INVOKE, INVOKE, INVOKE, CONSTRUCTOR, IF, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, IF, IF, IF] complete} */
    public static void doLoadLibraryBySoName(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        boolean z;
        UnsatisfiedLinkError unsatisfiedLinkError;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(AdIconUtil.AD_TEXT_ID, null, str, i2, threadPolicy) == null) {
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
                        Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[" + str + PreferencesUtil.RIGHT_MOUNT);
                    }
                    int i3 = 0;
                    do {
                        try {
                            sSoSourcesLock.readLock().lock();
                            int i4 = sSoSourcesVersion;
                            int i5 = 0;
                            while (true) {
                                if (i3 != 0 || i5 >= sSoSources.length) {
                                    break;
                                }
                                i3 = sSoSources[i5].loadLibrary(str, i2, threadPolicy);
                                if (i3 == 3 && sBackupSoSources != null) {
                                    String str2 = "Trying backup SoSource for " + str;
                                    UnpackingSoSource[] unpackingSoSourceArr = sBackupSoSources;
                                    int length = unpackingSoSourceArr.length;
                                    int i6 = 0;
                                    while (true) {
                                        if (i6 >= length) {
                                            break;
                                        }
                                        UnpackingSoSource unpackingSoSource = unpackingSoSourceArr[i6];
                                        unpackingSoSource.prepare(str);
                                        int loadLibrary = unpackingSoSource.loadLibrary(str, i2, threadPolicy);
                                        if (loadLibrary == 1) {
                                            i3 = loadLibrary;
                                            break;
                                        }
                                        i6++;
                                    }
                                } else {
                                    i5++;
                                }
                            }
                            sSoSourcesLock.readLock().unlock();
                            if ((i2 & 2) == 2 && i3 == 0) {
                                sSoSourcesLock.writeLock().lock();
                                if (sApplicationSoSource != null && sApplicationSoSource.checkAndMaybeUpdate()) {
                                    sSoSourcesVersion++;
                                }
                                z2 = sSoSourcesVersion != i4;
                                sSoSourcesLock.writeLock().unlock();
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                        } finally {
                            if (i3 == 0 || i3 == r5) {
                            }
                        }
                    } while (z2);
                    if (SYSTRACE_LIBRARY_LOADING) {
                        Api18TraceUtils.endSection();
                    }
                    if (z) {
                        StrictMode.setThreadPolicy(threadPolicy);
                    }
                    if (i3 == 0 || i3 == 3) {
                        throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
                    }
                    return;
                }
                String str3 = "Could not load: " + str + " because no SO source exists";
                throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
            } catch (Throwable th) {
                sSoSourcesLock.readLock().unlock();
                throw th;
            }
        }
    }

    @Nullable
    public static Method getNativeLoadRuntimeMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23 && i2 <= 27) {
                try {
                    Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (NoSuchMethodException | SecurityException unused) {
                }
            }
            return null;
        }
        return (Method) invokeV.objValue;
    }

    public static void init(Context context, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, context, i2) == null) {
            init(context, i2, null);
        }
    }

    public static synchronized void initSoLoader(@Nullable SoFileLoader soFileLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, soFileLoader) == null) {
            synchronized (SoLoader.class) {
                if (soFileLoader != null) {
                    sSoFileLoader = soFileLoader;
                    return;
                }
                Runtime runtime = Runtime.getRuntime();
                Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
                boolean z = nativeLoadRuntimeMethod != null;
                String classLoaderLdLoadLibrary = z ? Api14Utils.getClassLoaderLdLoadLibrary() : null;
                sSoFileLoader = new SoFileLoader(z, classLoaderLdLoadLibrary, makeNonZipPath(classLoaderLdLoadLibrary), runtime, nativeLoadRuntimeMethod) { // from class: com.facebook.soloader.SoLoader.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean val$hasNativeLoadMethod;
                    public final /* synthetic */ String val$localLdLibraryPath;
                    public final /* synthetic */ String val$localLdLibraryPathNoZips;
                    public final /* synthetic */ Method val$nativeLoadRuntimeMethod;
                    public final /* synthetic */ Runtime val$runtime;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Boolean.valueOf(z), classLoaderLdLoadLibrary, r8, runtime, nativeLoadRuntimeMethod};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$hasNativeLoadMethod = z;
                        this.val$localLdLibraryPath = classLoaderLdLoadLibrary;
                        this.val$localLdLibraryPathNoZips = r8;
                        this.val$runtime = runtime;
                        this.val$nativeLoadRuntimeMethod = nativeLoadRuntimeMethod;
                    }

                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
                    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                    private String getLibHash(String str) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeL = interceptable2.invokeL(65537, this, str)) != null) {
                            return (String) invokeL.objValue;
                        }
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

                    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x0099 */
                    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.lang.String */
                    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
                        if (r1 == null) goto L23;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
                        r0 = "Error when loading lib: " + r1 + " lib hash: " + getLibHash(r9) + " search path is " + r10;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
                        return;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
                        return;
                     */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:47:0x009c  */
                    /* JADX WARN: Type inference failed for: r1v0 */
                    /* JADX WARN: Type inference failed for: r1v2 */
                    @Override // com.facebook.soloader.SoFileLoader
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void load(String str, int i2) {
                        Throwable th;
                        Throwable e2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i2) == null) {
                            if (this.val$hasNativeLoadMethod) {
                                String str2 = 1;
                                String str3 = (i2 & 4) == 4 ? this.val$localLdLibraryPath : this.val$localLdLibraryPathNoZips;
                                try {
                                    try {
                                        try {
                                            synchronized (this.val$runtime) {
                                                try {
                                                    String str4 = (String) this.val$nativeLoadRuntimeMethod.invoke(this.val$runtime, str, SoLoader.class.getClassLoader(), str3);
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
                                            String str5 = "Error when loading lib: " + str2 + " lib hash: " + getLibHash(str) + " search path is " + str3;
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
                    }
                };
            }
        }
    }

    public static void initSoSources(Context context, int i2, @Nullable SoFileLoader soFileLoader) throws IOException {
        int i3;
        ApkSoSource apkSoSource;
        ApkSoSource apkSoSource2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65547, null, context, i2, soFileLoader) == null) {
            sSoSourcesLock.writeLock().lock();
            try {
                if (sSoSources == null) {
                    sFlags = i2;
                    ArrayList arrayList = new ArrayList();
                    String str = System.getenv("LD_LIBRARY_PATH");
                    if (str == null) {
                        str = "/vendor/lib:/system/lib";
                    }
                    String[] split = str.split(":");
                    for (int i4 = 0; i4 < split.length; i4++) {
                        String str2 = "adding system library source: " + split[i4];
                        arrayList.add(new DirectorySoSource(new File(split[i4]), 2));
                    }
                    if (context != null) {
                        if ((i2 & 1) != 0) {
                            sBackupSoSources = null;
                            arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                        } else {
                            ApplicationInfo applicationInfo = context.getApplicationInfo();
                            if ((applicationInfo.flags & 1) != 0 && (applicationInfo.flags & 128) == 0) {
                                i3 = 0;
                            } else {
                                sApplicationSoSource = new ApplicationSoSource(context, Build.VERSION.SDK_INT <= 17 ? 1 : 0);
                                String str3 = "adding application source: " + sApplicationSoSource.toString();
                                arrayList.add(0, sApplicationSoSource);
                                i3 = 1;
                            }
                            if ((sFlags & 8) != 0) {
                                sBackupSoSources = null;
                            } else {
                                File file = new File(context.getApplicationInfo().sourceDir);
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(new ApkSoSource(context, file, SO_STORE_NAME_MAIN, i3));
                                String str4 = "adding backup source from : " + apkSoSource.toString();
                                if (Build.VERSION.SDK_INT >= 21 && context.getApplicationInfo().splitSourceDirs != null) {
                                    String[] strArr = context.getApplicationInfo().splitSourceDirs;
                                    int length = strArr.length;
                                    int i5 = 0;
                                    int i6 = 0;
                                    while (i5 < length) {
                                        File file2 = new File(strArr[i5]);
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(SO_STORE_NAME_SPLIT);
                                        sb.append(i6);
                                        String str5 = "adding backup source: " + apkSoSource2.toString();
                                        arrayList2.add(new ApkSoSource(context, file2, sb.toString(), i3));
                                        i5++;
                                        i6++;
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
                        int i7 = length2 - 1;
                        if (length2 <= 0) {
                            break;
                        }
                        String str6 = "Preparing SO source: " + soSourceArr[i7];
                        soSourceArr[i7].prepare(makePrepareFlags);
                        length2 = i7;
                    }
                    sSoSources = soSourceArr;
                    sSoSourcesVersion++;
                    String str7 = "init finish: " + sSoSources.length + " SO sources prepared";
                }
            } finally {
                sSoSourcesLock.writeLock().unlock();
            }
        }
    }

    public static boolean loadLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? loadLibrary(str, 0) : invokeL.booleanValue;
    }

    public static void loadLibraryBySoName(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65550, null, str, i2, threadPolicy) == null) {
            loadLibraryBySoName(str, null, null, i2, threadPolicy);
        }
    }

    public static String makeLdLibraryPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            sSoSourcesLock.readLock().lock();
            try {
                assertInitialized();
                ArrayList arrayList = new ArrayList();
                for (SoSource soSource : sSoSources) {
                    soSource.addToLdLibraryPath(arrayList);
                }
                String join = TextUtils.join(":", arrayList);
                String str = "makeLdLibraryPath final path: " + join;
                return join;
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public static String makeNonZipPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static int makePrepareFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            sSoSourcesLock.writeLock().lock();
            try {
                return (sFlags & 2) != 0 ? 1 : 0;
            } finally {
                sSoSourcesLock.writeLock().unlock();
            }
        }
        return invokeV.intValue;
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, soSource) == null) {
            sSoSourcesLock.writeLock().lock();
            try {
                String str = "Prepending to SO sources: " + soSource;
                assertInitialized();
                soSource.prepare(makePrepareFlags());
                SoSource[] soSourceArr = new SoSource[sSoSources.length + 1];
                soSourceArr[0] = soSource;
                System.arraycopy(sSoSources, 0, soSourceArr, 1, sSoSources.length);
                sSoSources = soSourceArr;
                sSoSourcesVersion++;
                String str2 = "Prepended to SO sources: " + soSource;
            } finally {
                sSoSourcesLock.writeLock().unlock();
            }
        }
    }

    public static void resetStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, null) == null) {
            synchronized (SoLoader.class) {
                sLoadedLibraries.clear();
                sLoadingLibraries.clear();
                sSoFileLoader = null;
            }
            setSoSources(null);
        }
    }

    public static void setInTestMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, null) == null) {
            setSoSources(new SoSource[]{new NoopSoSource()});
        }
    }

    public static void setSoFileLoader(SoFileLoader soFileLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, soFileLoader) == null) {
            sSoFileLoader = soFileLoader;
        }
    }

    public static void setSoSources(SoSource[] soSourceArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, soSourceArr) == null) {
            sSoSourcesLock.writeLock().lock();
            try {
                sSoSources = soSourceArr;
                sSoSourcesVersion++;
            } finally {
                sSoSourcesLock.writeLock().unlock();
            }
        }
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, systemLoadLibraryWrapper) == null) {
            sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
        }
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            assertInitialized();
            try {
                return unpackLibraryBySoName(System.mapLibraryName(str));
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (File) invokeL.objValue;
    }

    public static File unpackLibraryBySoName(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            sSoSourcesLock.readLock().lock();
            for (int i2 = 0; i2 < sSoSources.length; i2++) {
                try {
                    File unpackLibrary = sSoSources[i2].unpackLibrary(str);
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
        return (File) invokeL.objValue;
    }

    public static void init(Context context, int i2, @Nullable SoFileLoader soFileLoader) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65544, null, context, i2, soFileLoader) == null) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            try {
                initSoLoader(soFileLoader);
                initSoSources(context, i2, soFileLoader);
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
            }
        }
    }

    public static boolean loadLibrary(String str, int i2) throws UnsatisfiedLinkError {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, str, i2)) == null) {
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
                return loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), str, mapLibName, i2 | 2, null);
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        return invokeLI.booleanValue;
    }

    public static boolean loadLibraryBySoName(String str, @Nullable String str2, @Nullable String str3, int i2, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        InterceptResult invokeCommon;
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{str, str2, str3, Integer.valueOf(i2), threadPolicy})) == null) {
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
                                        String str4 = "About to load: " + str;
                                        doLoadLibraryBySoName(str, i2, threadPolicy);
                                        synchronized (SoLoader.class) {
                                            String str5 = "Loaded: " + str;
                                            sLoadedLibraries.add(str);
                                        }
                                    } catch (IOException e2) {
                                        throw new RuntimeException(e2);
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
                                Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[" + str2 + PreferencesUtil.RIGHT_MOUNT);
                            }
                            String str6 = "About to merge: " + str2 + " / " + str;
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
        return invokeCommon.booleanValue;
    }

    public static void init(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, context, z) == null) {
            try {
                init(context, z ? 1 : 0);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
