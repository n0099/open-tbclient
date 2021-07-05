package d.a.q0.a.f1.h;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a1.e;
import d.a.q0.a.e0.d;
import d.a.q0.a.h0.m.e;
import d.a.q0.a.k;
import d.a.q0.a.v2.o0;
import d.a.q0.n.i.m.c;
import java.io.File;
import java.util.List;
import java.util.Locale;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47803a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.f1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0755a implements d.a.q0.a.v2.e1.b<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0755a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) && pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                d.a.q0.a.c2.f.g0.a.h(pMSAppInfo.appKey, pMSAppInfo.appStatus);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // d.a.q0.n.f.g, d.a.q0.n.f.d
        public void n(String str, String str2) {
            List<UbcFlowEvent> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                super.n(str, str2);
                if (TextUtils.isEmpty(str2) || !TextUtils.equals(str, "770") || (list = this.s) == null) {
                    return;
                }
                list.add(new UbcFlowEvent(str2));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1040931220, "Ld/a/q0/a/f1/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1040931220, "Ld/a/q0/a/f1/h/a;");
                return;
            }
        }
        f47803a = k.f49133a;
    }

    public static void a(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bundle) == null) {
            if (f47803a) {
                Log.i("SwanAppLaunchUtils", "asyncUpdatePkg: swanAsyncUpdate -> 异步更新小程序包 开始");
            }
            String string = bundle.getString("mAppId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            int i2 = bundle.getInt("appFrameType");
            if (1 != i2) {
                i2 = 0;
            }
            c cVar = new c(string, i2);
            if (bundle.containsKey("pms_update_expect_pkg_ver")) {
                cVar.o(bundle.getLong("pms_update_expect_pkg_ver"));
            }
            if (f47803a) {
                Log.i("SwanAppLaunchUtils", String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i2), Long.valueOf(cVar.h())));
            }
            cVar.d("4");
            b bVar = new b(string);
            bVar.b0(new C0755a());
            bVar.K(3);
            d.a.q0.n.b.b(cVar, bVar);
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
                File i2 = e.C0680e.i(pMSAppInfo.appId, String.valueOf(j));
                if (i2.exists()) {
                    String string = bundle.getString("mPage");
                    if (TextUtils.isEmpty(string)) {
                        boolean exists = new File(i2, "app.json").exists();
                        d.h("SwanAppLaunchUtils", "checkSwanAppPageDirExist app.json exists: " + exists);
                        return exists;
                    }
                    String g2 = o0.g(string);
                    int lastIndexOf = g2.lastIndexOf(File.separator);
                    if (lastIndexOf >= 0) {
                        g2 = g2.substring(0, lastIndexOf);
                    }
                    boolean exists2 = new File(i2, g2).exists();
                    if (exists2) {
                        if (new File(i2, "app.json").exists()) {
                            return System.currentTimeMillis() - new File(i2, g2).lastModified() > 1800000;
                        }
                        int lastIndexOf2 = g2.lastIndexOf(File.separator);
                        while (true) {
                            if (lastIndexOf2 < 0) {
                                break;
                            }
                            g2 = g2.substring(0, lastIndexOf2);
                            if (new File(i2, g2 + File.separator + "app.json").exists()) {
                                z = true;
                                break;
                            }
                            lastIndexOf2 = g2.lastIndexOf(File.separator);
                        }
                        if (f47803a) {
                            Log.d("SwanAppLaunchUtils", "isInDependentPkg=" + z + ", pagePath=" + g2);
                        }
                        if (z && !TextUtils.isEmpty(g2)) {
                            bundle.putBoolean("swan_app_independent", true);
                            bundle.putString("swan_app_sub_root_path", g2);
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
            String g2 = o0.g(str);
            int lastIndexOf = g2.lastIndexOf(File.separator);
            while (lastIndexOf != -1) {
                g2 = g2.substring(0, lastIndexOf);
                if (d.a.q0.a.a1.e.B(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g2)) {
                    return g2;
                }
                lastIndexOf = g2.lastIndexOf(File.separator);
            }
            return d.a.q0.a.a1.e.B(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g2) ? g2 : "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean d(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return e(d.a.q0.n.g.a.h().s(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean e(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, pMSAppInfo)) == null) {
            if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                long j = pMSAppInfo.versionCode;
                if (j != 0) {
                    if (pMSAppInfo.appCategory == 1) {
                        File a2 = d.a.q0.a.c1.b.g().a(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
                        if (a2 != null) {
                            return a2.exists();
                        }
                        return false;
                    }
                    return d.a.q0.a.a1.e.z(e.C0680e.i(pMSAppInfo.appId, String.valueOf(j)));
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(PMSAppInfo pMSAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, pMSAppInfo, str)) == null) {
            if (pMSAppInfo == null || TextUtils.isEmpty(str)) {
                return false;
            }
            String g2 = o0.g(str);
            if (g2.lastIndexOf(File.separator) != -1) {
                g2 = g2.substring(0, g2.lastIndexOf(File.separator));
            }
            return d.a.q0.a.a1.e.p(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g2).exists();
        }
        return invokeLL.booleanValue;
    }
}
