package com.facebook.soloader;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.soloader.nativeloader.NativeLoader;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class SoLoader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    public static final String SO_STORE_NAME_MAIN = "lib-main";
    public static final String SO_STORE_NAME_SPLIT = "lib-";
    public static final boolean SYSTRACE_LIBRARY_LOADING;
    public static final String TAG = "SoLoader";
    public static boolean isSystemApp;
    @Nullable
    public static ApplicationSoSource sApplicationSoSource;
    @Nullable
    public static UnpackingSoSource[] sBackupSoSources;
    public static int sFlags;
    public static final Set sLoadedAndMergedLibraries;
    public static final HashSet sLoadedLibraries;
    public static final Map sLoadingLibraries;
    @Nullable
    public static SoFileLoader sSoFileLoader;
    @Nullable
    public static SoSource[] sSoSources;
    public static final ReentrantReadWriteLock sSoSourcesLock;
    public static volatile int sSoSourcesVersion;
    @Nullable
    public static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class Api14Utils {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Api14Utils() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (classLoader != null && !(classLoader instanceof BaseDexClassLoader)) {
                    throw new IllegalStateException("ClassLoader " + classLoader.getClass().getName() + " should be of type BaseDexClassLoader");
                }
                try {
                    return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot call getLdLibraryPath", e);
                }
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class TestOnlyUtils {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public TestOnlyUtils() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void resetStatus() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                synchronized (SoLoader.class) {
                    SoLoader.sLoadedLibraries.clear();
                    SoLoader.sLoadingLibraries.clear();
                    SoLoader.sSoFileLoader = null;
                }
                setSoSources(null);
            }
        }

        public static void setSoFileLoader(SoFileLoader soFileLoader) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, soFileLoader) == null) {
                SoLoader.sSoFileLoader = soFileLoader;
            }
        }

        public static void setSoSources(SoSource[] soSourceArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, soSourceArr) == null) {
                SoLoader.sSoSourcesLock.writeLock().lock();
                try {
                    SoSource[] unused = SoLoader.sSoSources = soSourceArr;
                    SoLoader.access$208();
                } finally {
                    SoLoader.sSoSourcesLock.writeLock().unlock();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class WrongAbiError extends UnsatisfiedLinkError {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WrongAbiError(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.getSupportedAbis()) + " error: " + str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        sLoadedLibraries = new HashSet();
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

    @Nullable
    public static Method getNativeLoadRuntimeMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && i <= 27) {
                try {
                    Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class, String.class);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (NoSuchMethodException | SecurityException e) {
                    Log.w("SoLoader", "Cannot get nativeLoad method", e);
                }
            }
            return null;
        }
        return (Method) invokeV.objValue;
    }

    public SoLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static /* synthetic */ int access$208() {
        int i = sSoSourcesVersion;
        sSoSourcesVersion = i + 1;
        return i;
    }

    public static void assertInitialized() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65544, null) != null) || isInitialized()) {
            return;
        }
        throw new RuntimeException("SoLoader.init() not yet called");
    }

    public static void deinitForTest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            TestOnlyUtils.setSoSources(null);
        }
    }

    public static int getSoSourcesVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return sSoSourcesVersion;
        }
        return invokeV.intValue;
    }

    public static void setInTestMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            TestOnlyUtils.setSoSources(new SoSource[]{new NoopSoSource()});
        }
    }

    public static boolean loadLibrary(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            return loadLibrary(str, 0);
        }
        return invokeL.booleanValue;
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, systemLoadLibraryWrapper) == null) {
            sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
        }
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            assertInitialized();
            try {
                return unpackLibraryBySoName(System.mapLibraryName(str));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return (File) invokeL.objValue;
    }

    public static boolean areSoSourcesAbisSupported() {
        InterceptResult invokeV;
        String[] soSourceAbis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            sSoSourcesLock.readLock().lock();
            try {
                if (sSoSources != null) {
                    String[] supportedAbis = SysUtil.getSupportedAbis();
                    for (SoSource soSource : sSoSources) {
                        for (String str : soSource.getSoSourceAbis()) {
                            boolean z = false;
                            for (int i = 0; i < supportedAbis.length && !z; i++) {
                                z = str.equals(supportedAbis[i]);
                            }
                            if (!z) {
                                Log.e("SoLoader", "abi not supported: " + str);
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

    public static String makeLdLibraryPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            sSoSourcesLock.readLock().lock();
            try {
                assertInitialized();
                Log.d("SoLoader", "makeLdLibraryPath");
                ArrayList arrayList = new ArrayList();
                SoSource[] soSourceArr = sSoSources;
                if (soSourceArr != null) {
                    for (SoSource soSource : soSourceArr) {
                        soSource.addToLdLibraryPath(arrayList);
                    }
                }
                String join = TextUtils.join(":", arrayList);
                Log.d("SoLoader", "makeLdLibraryPath final path: " + join);
                return join;
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean checkIfSystemApp(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i)) == null) {
            if ((i & 32) != 0 || context == null || (context.getApplicationInfo().flags & 129) == 0) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static void init(Context context, int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65552, null, context, i) == null) {
            init(context, i, null);
        }
    }

    public static void doLoadLibraryBySoName(String str, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) throws UnsatisfiedLinkError {
        boolean z;
        UnpackingSoSource[] unpackingSoSourceArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65547, null, str, i, threadPolicy) == null) {
            sSoSourcesLock.readLock().lock();
            try {
                if (sSoSources != null) {
                    sSoSourcesLock.readLock().unlock();
                    int i2 = 0;
                    if (threadPolicy == null) {
                        threadPolicy = StrictMode.allowThreadDiskReads();
                        z = true;
                    } else {
                        z = false;
                    }
                    if (SYSTRACE_LIBRARY_LOADING) {
                        Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[", str, PreferencesUtil.RIGHT_MOUNT);
                    }
                    try {
                        sSoSourcesLock.readLock().lock();
                        int i3 = 0;
                        for (int i4 = 0; i3 == 0 && i4 < sSoSources.length; i4++) {
                            i3 = sSoSources[i4].loadLibrary(str, i, threadPolicy);
                            if (i3 == 3 && sBackupSoSources != null) {
                                Log.d("SoLoader", "Trying backup SoSource for " + str);
                                for (UnpackingSoSource unpackingSoSource : sBackupSoSources) {
                                    unpackingSoSource.prepare(str);
                                    int loadLibrary = unpackingSoSource.loadLibrary(str, i, threadPolicy);
                                    if (loadLibrary == 1) {
                                        i3 = loadLibrary;
                                        break;
                                    }
                                }
                            }
                        }
                        try {
                            if (SYSTRACE_LIBRARY_LOADING) {
                                Api18TraceUtils.endSection();
                            }
                            if (z) {
                                StrictMode.setThreadPolicy(threadPolicy);
                            }
                            if (i3 == 0 || i3 == 3) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("couldn't find DSO to load: ");
                                sb.append(str);
                                sSoSourcesLock.readLock().lock();
                                while (i2 < sSoSources.length) {
                                    sb.append("\n\tSoSource ");
                                    sb.append(i2);
                                    sb.append(": ");
                                    sb.append(sSoSources[i2].toString());
                                    i2++;
                                }
                                ApplicationSoSource applicationSoSource = sApplicationSoSource;
                                if (applicationSoSource != null) {
                                    File nativeLibDirFromContext = ApplicationSoSource.getNativeLibDirFromContext(applicationSoSource.getUpdatedContext());
                                    sb.append("\n\tNative lib dir: ");
                                    sb.append(nativeLibDirFromContext.getAbsolutePath());
                                    sb.append("\n");
                                }
                                sSoSourcesLock.readLock().unlock();
                                sb.append(" result: ");
                                sb.append(i3);
                                String sb2 = sb.toString();
                                Log.e("SoLoader", sb2);
                                throw new UnsatisfiedLinkError(sb2);
                            }
                        } catch (Throwable th) {
                            th = th;
                            i2 = i3;
                            if (SYSTRACE_LIBRARY_LOADING) {
                                Api18TraceUtils.endSection();
                            }
                            if (z) {
                                StrictMode.setThreadPolicy(threadPolicy);
                            }
                            if (i2 != 0 && i2 != 3) {
                                return;
                            }
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("couldn't find DSO to load: ");
                            sb3.append(str);
                            String message = th.getMessage();
                            if (message == null) {
                                message = th.toString();
                            }
                            sb3.append(" caused by: ");
                            sb3.append(message);
                            th.printStackTrace();
                            sb3.append(" result: ");
                            sb3.append(i2);
                            String sb4 = sb3.toString();
                            Log.e("SoLoader", sb4);
                            throw new UnsatisfiedLinkError(sb4);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    Log.e("SoLoader", "Could not load: " + str + " because no SO source exists");
                    throw new UnsatisfiedLinkError("couldn't find DSO to load: " + str);
                }
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
    }

    public static void initSoSources(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        String[] split;
        int i2;
        int i3;
        ApkSoSource apkSoSource;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65556, null, context, i, soFileLoader) == null) {
            sSoSourcesLock.writeLock().lock();
            try {
                if (sSoSources == null) {
                    Log.d("SoLoader", "init start");
                    sFlags = i;
                    ArrayList arrayList = new ArrayList();
                    String str = System.getenv("LD_LIBRARY_PATH");
                    if (str == null) {
                        if (SysUtil.is64Bit()) {
                            str = "/vendor/lib64:/system/lib64";
                        } else {
                            str = "/vendor/lib:/system/lib";
                        }
                    }
                    for (String str2 : str.split(":")) {
                        Log.d("SoLoader", "adding system library source: " + str2);
                        arrayList.add(new DirectorySoSource(new File(str2), 2));
                    }
                    if (context != null) {
                        if ((i & 1) != 0) {
                            sBackupSoSources = null;
                            Log.d("SoLoader", "adding exo package source: lib-main");
                            arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                        } else {
                            if (isSystemApp) {
                                i3 = 0;
                            } else {
                                if (Build.VERSION.SDK_INT <= 17) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                sApplicationSoSource = new ApplicationSoSource(context, i2);
                                Log.d("SoLoader", "adding application source: " + sApplicationSoSource.toString());
                                arrayList.add(0, sApplicationSoSource);
                                i3 = 1;
                            }
                            if ((sFlags & 8) != 0) {
                                sBackupSoSources = null;
                            } else {
                                File file = new File(context.getApplicationInfo().sourceDir);
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(new ApkSoSource(context, file, SO_STORE_NAME_MAIN, i3));
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
                                        ApkSoSource apkSoSource2 = new ApkSoSource(context, file2, sb.toString(), i3);
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
    }

    @Nullable
    public static String[] getLibraryDependencies(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            sSoSourcesLock.readLock().lock();
            try {
                String[] strArr = null;
                if (sSoSources != null) {
                    int i = 0;
                    while (strArr == null) {
                        if (i >= sSoSources.length) {
                            break;
                        }
                        strArr = sSoSources[i].getLibraryDependencies(str);
                        i++;
                    }
                }
                return strArr;
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        return (String[]) invokeL.objValue;
    }

    @Nullable
    public static String getLibraryPath(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            sSoSourcesLock.readLock().lock();
            try {
                String str2 = null;
                if (sSoSources != null) {
                    int i = 0;
                    while (str2 == null) {
                        if (i >= sSoSources.length) {
                            break;
                        }
                        str2 = sSoSources[i].getLibraryPath(str);
                        i++;
                    }
                }
                return str2;
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        return (String) invokeL.objValue;
    }

    public static File unpackLibraryBySoName(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            sSoSourcesLock.readLock().lock();
            try {
                for (SoSource soSource : sSoSources) {
                    File unpackLibrary = soSource.unpackLibrary(str);
                    if (unpackLibrary != null) {
                        return unpackLibrary;
                    }
                }
                sSoSourcesLock.readLock().unlock();
                throw new FileNotFoundException(str);
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        return (File) invokeL.objValue;
    }

    public static void init(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65553, null, context, i, soFileLoader) == null) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            try {
                isSystemApp = checkIfSystemApp(context, i);
                initSoLoader(soFileLoader);
                initSoSources(context, i, soFileLoader);
                if (!NativeLoader.isInitialized()) {
                    NativeLoader.init(new NativeLoaderToSoLoaderDelegate());
                }
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
            }
        }
    }

    public static void init(Context context, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65554, null, context, z) == null) {
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            try {
                init(context, i);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static synchronized void initSoLoader(@Nullable SoFileLoader soFileLoader) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, soFileLoader) == null) {
            synchronized (SoLoader.class) {
                if (soFileLoader != null) {
                    sSoFileLoader = soFileLoader;
                    return;
                }
                Runtime runtime = Runtime.getRuntime();
                Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
                if (nativeLoadRuntimeMethod != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    str = Api14Utils.getClassLoaderLdLoadLibrary();
                } else {
                    str = null;
                }
                String str2 = str;
                sSoFileLoader = new SoFileLoader(z, str2, makeNonZipPath(str2), runtime, nativeLoadRuntimeMethod) { // from class: com.facebook.soloader.SoLoader.1
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
                            Object[] objArr = {Boolean.valueOf(z), str2, r8, runtime, nativeLoadRuntimeMethod};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$hasNativeLoadMethod = z;
                        this.val$localLdLibraryPath = str2;
                        this.val$localLdLibraryPathNoZips = r8;
                        this.val$runtime = runtime;
                        this.val$nativeLoadRuntimeMethod = nativeLoadRuntimeMethod;
                    }

                    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
                    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                    private String getLibHash(String str3) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, str3)) == null) {
                            try {
                                File file = new File(str3);
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
                            } catch (IOException e) {
                                return e.toString();
                            } catch (SecurityException e2) {
                                return e2.toString();
                            } catch (NoSuchAlgorithmException e3) {
                                return e3.toString();
                            }
                        } else {
                            return (String) invokeL.objValue;
                        }
                    }

                    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x009f */
                    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.lang.String */
                    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
                        if (r1 == null) goto L23;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
                        android.util.Log.e("SoLoader", "Error when loading lib: " + r1 + " lib hash: " + getLibHash(r9) + " search path is " + r10);
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
                        return;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
                        return;
                     */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
                    /* JADX WARN: Type inference failed for: r1v0 */
                    /* JADX WARN: Type inference failed for: r1v2 */
                    @Override // com.facebook.soloader.SoFileLoader
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void load(String str3, int i) {
                        boolean z2;
                        String str4;
                        Throwable th;
                        Throwable e;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str3, i) == null) {
                            if (this.val$hasNativeLoadMethod) {
                                String str5 = 1;
                                if ((i & 4) == 4) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    str4 = this.val$localLdLibraryPath;
                                } else {
                                    str4 = this.val$localLdLibraryPathNoZips;
                                }
                                try {
                                    try {
                                        try {
                                            synchronized (this.val$runtime) {
                                                try {
                                                    String str6 = (String) this.val$nativeLoadRuntimeMethod.invoke(this.val$runtime, str3, SoLoader.class.getClassLoader(), str4);
                                                    if (str6 != null) {
                                                        throw new UnsatisfiedLinkError(str6);
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
                                        } catch (IllegalAccessException e2) {
                                            e = e2;
                                            throw new RuntimeException("Error: Cannot load " + str3, e);
                                        } catch (IllegalArgumentException e3) {
                                            e = e3;
                                            throw new RuntimeException("Error: Cannot load " + str3, e);
                                        } catch (InvocationTargetException e4) {
                                            e = e4;
                                            throw new RuntimeException("Error: Cannot load " + str3, e);
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        if (str5 != 0) {
                                            Log.e("SoLoader", "Error when loading lib: " + str5 + " lib hash: " + getLibHash(str3) + " search path is " + str4);
                                        }
                                        throw th;
                                    }
                                } catch (IllegalAccessException e5) {
                                    e = e5;
                                    e = e;
                                    throw new RuntimeException("Error: Cannot load " + str3, e);
                                } catch (IllegalArgumentException e6) {
                                    e = e6;
                                    e = e;
                                    throw new RuntimeException("Error: Cannot load " + str3, e);
                                } catch (InvocationTargetException e7) {
                                    e = e7;
                                    e = e;
                                    throw new RuntimeException("Error: Cannot load " + str3, e);
                                } catch (Throwable th5) {
                                    str5 = 0;
                                    th = th5;
                                    if (str5 != 0) {
                                    }
                                    throw th;
                                }
                            }
                            System.load(str3);
                        }
                    }
                };
            }
        }
    }

    @Nullable
    public static String makeNonZipPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
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

    public static boolean isInitialized() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            sSoSourcesLock.readLock().lock();
            try {
                if (sSoSources != null) {
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        return invokeV.booleanValue;
    }

    public static int makePrepareFlags() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            sSoSourcesLock.writeLock().lock();
            try {
                if ((sFlags & 2) != 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                return i;
            } finally {
                sSoSourcesLock.writeLock().unlock();
            }
        }
        return invokeV.intValue;
    }

    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        InterceptResult invokeLI;
        String str2;
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, null, str, i)) == null) {
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
                if (isSystemApp && (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) != null) {
                    systemLoadLibraryWrapper.loadLibrary(str);
                    return true;
                }
                String mapLibName = MergedSoMapping.mapLibName(str);
                if (mapLibName != null) {
                    str2 = mapLibName;
                } else {
                    str2 = str;
                }
                return loadLibraryBySoName(System.mapLibraryName(str2), str, mapLibName, i, null);
            } finally {
                sSoSourcesLock.readLock().unlock();
            }
        }
        return invokeLI.booleanValue;
    }

    public static void loadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65560, null, str, i, threadPolicy) == null) {
            loadLibraryBySoNameImpl(str, null, null, i, threadPolicy);
        }
    }

    public static boolean loadLibraryBySoName(String str, @Nullable String str2, @Nullable String str3, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, null, new Object[]{str, str2, str3, Integer.valueOf(i), threadPolicy})) == null) {
            boolean z2 = false;
            do {
                try {
                    z2 = loadLibraryBySoNameImpl(str, str2, str3, i, threadPolicy);
                    z = false;
                    continue;
                } catch (UnsatisfiedLinkError e) {
                    int i2 = sSoSourcesVersion;
                    sSoSourcesLock.writeLock().lock();
                    try {
                        try {
                            z = true;
                            if (sApplicationSoSource != null && sApplicationSoSource.checkAndMaybeUpdate()) {
                                Log.w("SoLoader", "sApplicationSoSource updated during load: " + str + ", attempting load again.");
                                sSoSourcesVersion = sSoSourcesVersion + 1;
                            } else {
                                z = false;
                            }
                            sSoSourcesLock.writeLock().unlock();
                            if (sSoSourcesVersion == i2) {
                                throw e;
                            }
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        }
                    } catch (Throwable th) {
                        sSoSourcesLock.writeLock().unlock();
                        throw th;
                    }
                }
            } while (z);
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean loadLibraryBySoNameImpl(String str, @Nullable String str2, @Nullable String str3, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        InterceptResult invokeCommon;
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65562, null, new Object[]{str, str2, str3, Integer.valueOf(i), threadPolicy})) == null) {
            boolean z2 = false;
            if (!TextUtils.isEmpty(str2) && sLoadedAndMergedLibraries.contains(str2)) {
                return false;
            }
            synchronized (SoLoader.class) {
                if (sLoadedLibraries.contains(str)) {
                    if (str3 == null) {
                        return false;
                    }
                    z = true;
                } else {
                    z = false;
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
                                    Log.d("SoLoader", "About to load: " + str);
                                    doLoadLibraryBySoName(str, i, threadPolicy);
                                    synchronized (SoLoader.class) {
                                        Log.d("SoLoader", "Loaded: " + str);
                                        sLoadedLibraries.add(str);
                                    }
                                } catch (UnsatisfiedLinkError e) {
                                    String message = e.getMessage();
                                    if (message != null && message.contains("unexpected e_machine:")) {
                                        throw new WrongAbiError(e, message.substring(message.lastIndexOf("unexpected e_machine:")));
                                    }
                                    throw e;
                                }
                            }
                        }
                    }
                    if ((i & 16) == 0) {
                        if (!TextUtils.isEmpty(str2) && sLoadedAndMergedLibraries.contains(str2)) {
                            z2 = true;
                        }
                        if (str3 != null && !z2) {
                            if (SYSTRACE_LIBRARY_LOADING) {
                                Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", str2, PreferencesUtil.RIGHT_MOUNT);
                            }
                            try {
                                Log.d("SoLoader", "About to merge: " + str2 + " / " + str);
                                MergedSoMapping.invokeJniOnload(str2);
                                sLoadedAndMergedLibraries.add(str2);
                                if (SYSTRACE_LIBRARY_LOADING) {
                                    Api18TraceUtils.endSection();
                                }
                            } catch (UnsatisfiedLinkError e2) {
                                throw new RuntimeException("Failed to call JNI_OnLoad from '" + str2 + "', which has been merged into '" + str + "'.  See comment for details.", e2);
                            }
                        }
                    }
                    return !z;
                }
            }
        }
        return invokeCommon.booleanValue;
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, soSource) == null) {
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
    }
}
