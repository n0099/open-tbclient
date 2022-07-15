package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Process;
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
/* loaded from: classes5.dex */
public class WeaponHI {
    public static /* synthetic */ Interceptable $ic = null;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";
    public static int ii = 0;
    public static List<Integer> isList = null;
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

    /* renamed from: com.kuaishou.weapon.p0.WeaponHI$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class RunnableC0287 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ boolean f3;

        public RunnableC0287(boolean z) {
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
            this.f3 = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (context = WeaponHI.mContext) == null) {
                return;
            }
            C0374 m389 = C0374.m389(context);
            boolean z = this.f3;
            if (!z) {
                m389.m401("a1_p_s_p_s_c_b", Boolean.valueOf(z));
            } else if (m389.m408("a1_p_s_p_s_c_b")) {
            } else {
                m389.m401("a1_p_s_p_s_c_b", Boolean.valueOf(this.f3));
                try {
                    if (C0374.m389(WeaponHI.mContext).m402(C0374.f281, 1) == 1) {
                        C0368.m381(WeaponHI.mContext).m382(103);
                        C0370.m384(WeaponHI.mContext).m385(103);
                        C0366.m378(WeaponHI.mContext).m379(103, 0);
                        C0362.m372(WeaponHI.mContext).m373(103);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.WeaponHI$ʼ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class RunnableC0288 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public final /* synthetic */ IWeaponInitParams f4;

        public RunnableC0288(IWeaponInitParams iWeaponInitParams) {
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
            this.f4 = iWeaponInitParams;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    String m192 = C0308.m192(Process.myPid());
                    if (TextUtils.isEmpty(m192) || !m192.contains(":")) {
                        if (TextUtils.isEmpty(m192) || m192.equals(WeaponHI.mContext.getPackageName())) {
                            WeaponHI.mParams = this.f4;
                            WeaponHI.sKSAppkey = this.f4.getAppKey();
                            WeaponHI.sKSSecKey = this.f4.getSecKey();
                            WeaponHI.sKSSdkver = "5.0.0";
                            WeaponHI.hostVersionName = C0433.m891(WeaponHI.mContext);
                            WeaponHI.sKDeviceId = this.f4.getDeviceId();
                            WeaponHI.skProductName = this.f4.getProductName();
                            WeaponHI.sUserId = this.f4.getUserId();
                            WeaponHI.sChannel = this.f4.getChannel();
                            WeaponHI.cookieData = C0433.m881(WeaponHI.mContext);
                            try {
                                C0374 m389 = C0374.m389(WeaponHI.mContext);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("k", C0333.m251());
                                jSONObject.put("d", C0333.m249(WeaponHI.mContext));
                                jSONObject.put("a", C0433.m891(WeaponHI.mContext));
                                jSONObject.put("p", C0433.m892(WeaponHI.mContext));
                                jSONObject.put("s", "5.0.0");
                                jSONObject.put("n", TextUtils.isEmpty(m389.m421(C0374.f301)) ? 1 : 0);
                                WeaponHI.encryENV = new C0297(WeaponHI.mContext).m150(jSONObject.toString());
                                String m421 = m389.m421(C0374.f325);
                                if (!TextUtils.isEmpty(m421)) {
                                    WeaponHI.isList = Arrays.asList(m421.split(WebChromeClient.PARAM_SEPARATOR));
                                    WeaponHI.ii = m389.m402(C0374.f327, 5);
                                }
                            } catch (Throwable unused) {
                            }
                            WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, this.f4.getPrivacySwitch());
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.WeaponHI$ʽ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class RunnableC0289 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public RunnableC0289() {
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
                    C0392 m492 = C0392.m492(WeaponHI.mContext);
                    if (m492 == null) {
                        return;
                    }
                    m492.m496();
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
                    IntentFilter intentFilter = new IntentFilter(C0303.f38);
                    intentFilter.addDataScheme("env");
                    application.registerReceiver(weaponRECE, intentFilter);
                }
            } catch (Throwable unused) {
            }
            try {
                C0368.m381(mContext).m382(100);
                C0360.m369(mContext).m370(100);
                C0370.m384(mContext).m385(100);
                C0366.m378(mContext).m379(100, 0);
                C0362.m372(mContext).m373(100);
                C0364.m375(mContext).m376();
                C0372.m387(mContext).m388();
            } catch (Exception unused2) {
            }
        }
    }

    public static void iP(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            try {
                C0374 m389 = C0374.m389(context);
                long m410 = m389.m410();
                long currentTimeMillis = (System.currentTimeMillis() - m410) - (m389.m402(C0374.f303, 12) * 3600000);
                if (m410 < 1 || currentTimeMillis > 0) {
                    C0358.m366().m367(new RunnableC0356(context));
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
                C0358.m366().m367(new RunnableC0288(iWeaponInitParams));
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, str, str2, z) == null) {
            try {
                C0374.m389(mContext).m401("a1_p_s_p_s", Boolean.valueOf(z));
                C0358.m366();
                C0310.m205(mContext);
                C0309.m196(mContext);
            } catch (Exception unused) {
            }
            C0358.m366().m367(new RunnableC0289());
        }
    }

    public static void setPS(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            try {
                C0358.m366().m367(new RunnableC0287(z));
            } catch (Exception unused) {
            }
        }
    }
}
