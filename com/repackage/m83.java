package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.p53;
import com.repackage.s83;
import java.io.File;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public final class m83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;

        public a(int i, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = j;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p53.b bVar = new p53.b(CyberPlayerManager.MEDIA_INFO_DNS_EXCEPTION);
                bVar.k(String.valueOf(this.a));
                bVar.l(String.valueOf(this.b));
                bVar.j(String.valueOf(this.c));
                bVar.m();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Nullable
        public static SwanCoreVersion c(Bundle bundle, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bundle, i)) == null) {
                if (bundle == null) {
                    return null;
                }
                bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
                if (i == 1) {
                    return (SwanCoreVersion) bundle.getParcelable("aiapps_game_core");
                }
                return (SwanCoreVersion) bundle.getParcelable("aiapps_swan_core");
            }
            return (SwanCoreVersion) invokeLI.objValue;
        }

        public SwanCoreVersion b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                SwanCoreVersion e = m83.e(i);
                if (e.isAvailable()) {
                    return e;
                }
                q83.b().f(i);
                return m83.e(i);
            }
            return (SwanCoreVersion) invokeI.objValue;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("aiapps_swan_core", b(0));
                bundle2.putParcelable("aiapps_game_core", b(1));
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755545463, "Lcom/repackage/m83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755545463, "Lcom/repackage/m83;");
                return;
            }
        }
        a = rf1.a;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            r83.b(0);
            p83.b(0);
            r83.b(1);
            p83.b(1);
        }
    }

    public static void b(File file, List<Long> list) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, file, list) == null) || file == null) {
            return;
        }
        hw1.k("SwanAppSwanCoreManager", "deleteOldSwanCores dstFolder: " + file.getPath() + " ignoreVersions: " + Arrays.toString(list.toArray()));
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (a) {
                    Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores versionFolder: " + file2);
                }
                if (!k(file2, list)) {
                    if (a) {
                        Log.d("SwanAppSwanCoreManager", "deleteOldSwanCores deleteFolder: " + file2);
                    }
                    kf4.j(file2);
                }
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? o83.e() : invokeV.booleanValue;
    }

    public static File d(int i) {
        InterceptResult invokeI;
        File b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            if (i == 1 && (b2 = pi2.g().b()) != null) {
                return new File(b2, "game_core");
            }
            return new File(di2.g(), "swan_core");
        }
        return (File) invokeI.objValue;
    }

    public static SwanCoreVersion e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            boolean z = i == 0;
            if (j() && z) {
                SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
                swanCoreVersion.swanCorePath = o83.c().getPath();
                swanCoreVersion.swanCoreType = 2;
                long b2 = o83.b();
                swanCoreVersion.swanCoreVersionCode = b2;
                swanCoreVersion.swanCoreVersionName = wc3.d(b2);
                boolean isAvailable = swanCoreVersion.isAvailable();
                if (a) {
                    Log.d("SwanAppSwanCoreManager", "DebugSwanCoreMode-debugCoreAvailable:" + isAvailable);
                }
                if (isAvailable) {
                    return swanCoreVersion;
                }
                q(false);
            }
            SwanCoreVersion m = p83.m(i);
            SwanCoreVersion d = r83.d(i);
            if (a) {
                Log.d("SwanAppSwanCoreManager", "getSwanCoreVersion presetVerName=" + m.swanCoreVersionName + ", presetVerCode=" + m.swanCoreVersionCode + ", remoteVerName=" + d.swanCoreVersionName + ", remoteVerCode=" + d.swanCoreVersionCode);
            }
            return (m.swanCoreVersionCode >= d.swanCoreVersionCode || !d.isAvailable()) ? m : d;
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static long f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            SwanCoreVersion e = e(i);
            if (e != null) {
                return e.swanCoreVersionCode;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    @Nullable
    public static SwanCoreVersion g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            if (ProcessUtils.isMainProcess()) {
                return e(i);
            }
            wv2 c = uv2.c(b.class, null);
            if (a) {
                Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionIPC:" + ProcessUtils.getCurProcessName() + " swan core: " + b.c(c.a, i));
            }
            return b.c(c.a, i);
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) ? i(null, i) : (String) invokeI.objValue;
    }

    public static String i(SwanCoreVersion swanCoreVersion, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, swanCoreVersion, i)) == null) {
            if (swanCoreVersion == null) {
                swanCoreVersion = e(i);
            }
            if (swanCoreVersion.swanCoreVersionCode > 0) {
                return swanCoreVersion.swanCoreVersionName;
            }
            String e = p83.k(i).e();
            if (a) {
                Log.d("SwanAppSwanCoreManager", "getSwanCoreVersionName preset config: " + e);
            }
            return TextUtils.isEmpty(e) ? "0" : e;
        }
        return (String) invokeLI.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? v73.a().getBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", false) : invokeV.booleanValue;
    }

    public static boolean k(File file, List<Long> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, file, list)) == null) {
            if (list == null) {
                return false;
            }
            String name = file.getName();
            for (Long l : list) {
                if (TextUtils.equals(name, String.valueOf(l.longValue()))) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void l(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i, i2) == null) {
            if (a) {
                Log.d("SwanAppSwanCoreManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
            }
            if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
                a();
                p83.v(true, 0);
                p83.v(true, 1);
                p83.w(false, 0);
                di2.F(false);
            }
        }
    }

    public static void m(int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            bc3.k(new a(i2, j, i), "reportZipFileCheckFailed");
        }
    }

    public static void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, null, i) == null) {
            o(i, null);
        }
    }

    public static void o(int i, ae3<Exception> ae3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65551, null, i, ae3Var) == null) {
            s83.b b2 = s83.b.b();
            b2.c(true);
            b2.d("openSwanApp");
            p(b2.a(), i, ae3Var);
        }
    }

    public static void p(s83 s83Var, int i, ae3<Exception> ae3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65552, null, s83Var, i, ae3Var) == null) {
            ma4 ma4Var = new ma4(i);
            if (i == 0) {
                p64.l(ma4Var, new k22(ae3Var));
                return;
            }
            p22 p = pi2.i().p(ae3Var);
            if (p != null) {
                p64.m(ma4Var, new k22(null), p);
            } else if (ae3Var != null) {
                ae3Var.onCallback(null);
            }
        }
    }

    public static void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            v73.a().putBoolean("KEY_SWAN_APP_DEBUG_SWAN_CORE_MODE", z);
        }
    }
}
