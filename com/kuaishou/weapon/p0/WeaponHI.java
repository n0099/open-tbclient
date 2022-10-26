package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.kuaishou.weapon.p0.receiver.WeaponRECE;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class WeaponHI {
    public static /* synthetic */ Interceptable $ic = null;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";
    public static int ii = 0;
    public static List isList = null;
    public static Context mContext = null;
    public static IWeaponInitParams mParams = null;
    public static String sChannel = "";
    public static String sKDeviceId = "";
    public static String sKSAppkey = "";
    public static String sKSSdkver = "";
    public static String sKSSecKey = "";
    public static String sUserId = "";
    public static String skProductName = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (context = WeaponHI.mContext) == null) {
                return;
            }
            i a = i.a(context, "re_po_rt");
            boolean z = this.a;
            if (!z) {
                a.a("a1_p_s_p_s_c_b", Boolean.valueOf(z));
            } else if (a.b("a1_p_s_p_s_c_b")) {
            } else {
                a.a("a1_p_s_p_s_c_b", Boolean.valueOf(this.a));
                try {
                    if (a.b(f3.b1, 1) == 1) {
                        c3.a(WeaponHI.mContext).a(103);
                        d3.a(WeaponHI.mContext).a(103);
                        b3.a(WeaponHI.mContext).a(103, 0);
                        z2.a(WeaponHI.mContext).a(103);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IWeaponInitParams a;

        public b(IWeaponInitParams iWeaponInitParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iWeaponInitParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iWeaponInitParams;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    WeaponHI.mParams = this.a;
                    WeaponHI.sKSAppkey = this.a.getAppKey();
                    WeaponHI.sKSSecKey = this.a.getSecKey();
                    WeaponHI.sKSSdkver = "5.0.1";
                    WeaponHI.hostVersionName = h1.m(WeaponHI.mContext);
                    WeaponHI.sKDeviceId = this.a.getDeviceId();
                    WeaponHI.skProductName = this.a.getProductName();
                    WeaponHI.sUserId = this.a.getUserId();
                    WeaponHI.sChannel = this.a.getChannel();
                    WeaponHI.cookieData = h1.h(WeaponHI.mContext);
                    try {
                        i a = i.a(WeaponHI.mContext, "re_po_rt");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("k", n2.n());
                        jSONObject.put("d", n2.b(WeaponHI.mContext));
                        jSONObject.put("a", h1.m(WeaponHI.mContext));
                        jSONObject.put("p", h1.n(WeaponHI.mContext));
                        jSONObject.put("s", "5.0.1");
                        jSONObject.put("n", TextUtils.isEmpty(a.e(f3.i)) ? 1 : 0);
                        WeaponHI.encryENV = new n1(WeaponHI.mContext).b(jSONObject.toString());
                        String e = a.e(f3.u);
                        if (!TextUtils.isEmpty(e)) {
                            WeaponHI.isList = Arrays.asList(e.split(WebChromeClient.PARAM_SEPARATOR));
                            WeaponHI.ii = a.b(f3.v, 5);
                        }
                    } catch (Throwable unused) {
                    }
                    WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, this.a.getPrivacySwitch());
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    r a = r.a(WeaponHI.mContext);
                    if (a == null) {
                        return;
                    }
                    a.a();
                } catch (Exception unused) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(941648186, "Lcom/kuaishou/weapon/p0/WeaponHI;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(941648186, "Lcom/kuaishou/weapon/p0/WeaponHI;");
        }
    }

    public WeaponHI() {
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

    public static void iD() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                iP(mContext);
                WeaponRECE weaponRECE = new WeaponRECE();
                Application application = mContext instanceof Application ? (Application) mContext : null;
                if (application != null) {
                    IntentFilter intentFilter = new IntentFilter(q1.f);
                    intentFilter.addDataScheme("env");
                    application.registerReceiver(weaponRECE, intentFilter);
                }
            } catch (Throwable unused) {
            }
            try {
                c3.a(mContext).a(100);
                y2.a(mContext).a(100);
                d3.a(mContext).a(100);
                b3.a(mContext).a(100, 0);
                z2.a(mContext).a(100);
                a3.a(mContext).a();
                e3.a(mContext).a();
            } catch (Exception unused2) {
            }
        }
    }

    public static void iP(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            try {
                long b2 = f3.a(context).b();
                long currentTimeMillis = (System.currentTimeMillis() - b2) - (i.a(context, "re_po_rt").b(f3.j, 12) * 3600000);
                if (b2 < 1 || currentTimeMillis > 0) {
                    o.a().a(new x2(context));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(Context context, IWeaponInitParams iWeaponInitParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, iWeaponInitParams) == null) {
            try {
                mContext = context.getApplicationContext();
                o.a().a(new b(iWeaponInitParams));
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, str, str2, z) == null) {
            try {
                i.a(mContext, "re_po_rt").a("a1_p_s_p_s", Boolean.valueOf(z));
                o.a();
                t1.a(mContext);
                s1.b(mContext);
            } catch (Exception unused) {
            }
            o.a().a(new c());
        }
    }

    public static void setPS(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            try {
                o.a().a(new a(z));
            } catch (Exception unused) {
            }
        }
    }
}
