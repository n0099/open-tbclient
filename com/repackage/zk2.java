package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oi2;
import com.yy.hiidostatis.inner.FlushManager;
import java.io.File;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class zk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements le3<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.le3
        /* renamed from: b */
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) && pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                c23.L(pMSAppInfo.appKey, pMSAppInfo.appStatus);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends r22 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
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
        }

        @Override // com.repackage.l74, com.repackage.i74
        public void n(String str, String str2) {
            List<UbcFlowEvent> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                super.n(str, str2);
                if (TextUtils.isEmpty(str2) || !TextUtils.equals(str, "770") || (list = this.p) == null) {
                    return;
                }
                list.add(new UbcFlowEvent(str2));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755109200, "Lcom/repackage/zk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755109200, "Lcom/repackage/zk2;");
                return;
            }
        }
        a = cg1.a;
    }

    public static void a(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bundle) == null) {
            if (a) {
                Log.i("SwanAppLaunchUtils", "asyncUpdatePkg: swanAsyncUpdate -> 异步更新小程序包 开始");
            }
            String string = bundle.getString("mAppId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            int i = bundle.getInt("appFrameType");
            if (1 != i) {
                i = 0;
            }
            sa4 sa4Var = new sa4(string, i);
            if (bundle.containsKey("pms_update_expect_pkg_ver")) {
                sa4Var.q(bundle.getLong("pms_update_expect_pkg_ver"));
            }
            if (a) {
                Log.i("SwanAppLaunchUtils", String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i), Long.valueOf(sa4Var.i())));
            }
            sa4Var.d("4");
            b bVar = new b(string);
            bVar.e0(new a());
            bVar.L(3);
            a74.c(sa4Var, bVar);
        }
    }

    public static boolean b(@Nullable PMSAppInfo pMSAppInfo, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pMSAppInfo, bundle)) == null) {
            boolean z = false;
            if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                long j = pMSAppInfo.versionCode;
                if (j == 0 || bundle == null || pMSAppInfo.appCategory == 1) {
                    return false;
                }
                File i = oi2.e.i(pMSAppInfo.appId, String.valueOf(j));
                if (i.exists()) {
                    String string = bundle.getString("mPage");
                    if (TextUtils.isEmpty(string)) {
                        boolean exists = new File(i, "app.json").exists();
                        sw1.k("SwanAppLaunchUtils", "checkSwanAppPageDirExist app.json exists: " + exists);
                        return exists;
                    }
                    String g = kd3.g(string);
                    int lastIndexOf = g.lastIndexOf(File.separator);
                    if (lastIndexOf >= 0) {
                        g = g.substring(0, lastIndexOf);
                    }
                    boolean exists2 = new File(i, g).exists();
                    if (exists2) {
                        if (new File(i, "app.json").exists()) {
                            return System.currentTimeMillis() - new File(i, g).lastModified() > FlushManager.ReportTimer.DEFAULT_INTERVAL;
                        }
                        int lastIndexOf2 = g.lastIndexOf(File.separator);
                        while (true) {
                            if (lastIndexOf2 < 0) {
                                break;
                            }
                            g = g.substring(0, lastIndexOf2);
                            if (new File(i, g + File.separator + "app.json").exists()) {
                                z = true;
                                break;
                            }
                            lastIndexOf2 = g.lastIndexOf(File.separator);
                        }
                        if (a) {
                            Log.d("SwanAppLaunchUtils", "isInDependentPkg=" + z + ", pagePath=" + g);
                        }
                        if (z && !TextUtils.isEmpty(g)) {
                            bundle.putBoolean("swan_app_independent", true);
                            bundle.putString("swan_app_sub_root_path", g);
                        }
                    }
                    return exists2;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String c(PMSAppInfo pMSAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, pMSAppInfo, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String g = kd3.g(str);
            int lastIndexOf = g.lastIndexOf(File.separator);
            while (lastIndexOf != -1) {
                g = g.substring(0, lastIndexOf);
                if (oi2.B(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g)) {
                    return g;
                }
                lastIndexOf = g.lastIndexOf(File.separator);
            }
            return oi2.B(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g) ? g : "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean d(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return e(n74.i().u(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean e(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                long j = pMSAppInfo.versionCode;
                if (j != 0) {
                    if (pMSAppInfo.appCategory == 1) {
                        File a2 = aj2.g().a(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
                        if (a2 != null) {
                            return a2.exists();
                        }
                        return false;
                    }
                    return oi2.z(oi2.e.i(pMSAppInfo.appId, String.valueOf(j)));
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(PMSAppInfo pMSAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, pMSAppInfo, str)) == null) {
            if (pMSAppInfo == null || TextUtils.isEmpty(str)) {
                return false;
            }
            String g = kd3.g(str);
            if (g.lastIndexOf(File.separator) != -1) {
                g = g.substring(0, g.lastIndexOf(File.separator));
            }
            return oi2.p(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g).exists();
        }
        return invokeLL.booleanValue;
    }
}
