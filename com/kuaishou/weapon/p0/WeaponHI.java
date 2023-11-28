package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class WeaponHI {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean as = false;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";
    public static int ii = 0;
    public static List<Integer> isList = null;
    public static boolean isLoad = true;
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
            } catch (Throwable unused) {
            }
            try {
                db.a(mContext).a(100, 0);
                cx.a(mContext).a(100);
                dd.a(mContext).a(100);
                cz.a(mContext).a(100);
                de.a(mContext).a(100);
                da.a(mContext).a();
                cy.a(mContext).a(100);
                dc.a(mContext).a(100);
            } catch (Exception unused2) {
            }
        }
    }

    public static void iP(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            try {
                long b = df.a(context).b();
                long currentTimeMillis = (System.currentTimeMillis() - b) - (h.a(context, "re_po_rt").c(df.h, 12) * 3600000);
                if (b < 1 || currentTimeMillis > 0) {
                    n.a().a(new cw(context));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(Context context, IWeaponInitParams iWeaponInitParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, iWeaponInitParams) == null) {
            try {
                Context applicationContext = context.getApplicationContext();
                mContext = applicationContext;
                if (applicationContext instanceof Application) {
                    n.a().a(new Runnable(iWeaponInitParams) { // from class: com.kuaishou.weapon.p0.WeaponHI.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ IWeaponInitParams a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {iWeaponInitParams};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = iWeaponInitParams;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            int i;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    WeaponHI.mParams = this.a;
                                    WeaponHI.sKSAppkey = this.a.getAppKey();
                                    WeaponHI.sKSSecKey = this.a.getSecKey();
                                    WeaponHI.sKSSdkver = "5.3.0";
                                    WeaponHI.hostVersionName = bh.q(WeaponHI.mContext);
                                    WeaponHI.sKDeviceId = this.a.getDeviceId();
                                    WeaponHI.skProductName = this.a.getProductName();
                                    WeaponHI.sUserId = this.a.getUserId();
                                    WeaponHI.sChannel = this.a.getChannel();
                                    WeaponHI.as = this.a.getAPPLISTSwitch();
                                    WeaponHI.isLoad = this.a.isLoadSo();
                                    WeaponHI.cookieData = bh.z(WeaponHI.mContext);
                                    try {
                                        h a = h.a(WeaponHI.mContext, "re_po_rt");
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("k", cm.m());
                                        jSONObject.put("d", cm.b(WeaponHI.mContext));
                                        jSONObject.put("a", bh.q(WeaponHI.mContext));
                                        jSONObject.put("p", bh.s(WeaponHI.mContext));
                                        jSONObject.put("s", "5.3.0");
                                        if (TextUtils.isEmpty(a.a(df.g))) {
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                        jSONObject.put("n", i);
                                        WeaponHI.encryENV = new bn(WeaponHI.mContext).c(jSONObject.toString());
                                        String a2 = a.a(df.u);
                                        if (!TextUtils.isEmpty(a2)) {
                                            WeaponHI.isList = Arrays.asList(a2.split(WebChromeClient.PARAM_SEPARATOR));
                                            WeaponHI.ii = a.c(df.v, 5);
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, this.a.getPrivacySwitch());
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                    });
                } else {
                    Log.e("Risk", "context  is not application！！！");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void init(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65542, null, str, str2, z) == null) {
            try {
                h.a(mContext, "re_po_rt").a("a1_p_s_p_s", Boolean.valueOf(z));
                n.a();
                bt.a(mContext);
                bs.a(mContext);
            } catch (Exception unused) {
            }
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            q a = q.a(WeaponHI.mContext);
                            if (a == null) {
                                return;
                            }
                            a.a();
                        } catch (Exception unused2) {
                        }
                    }
                }
            });
        }
    }

    public static void setPS(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            try {
                n.a().a(new Runnable(z) { // from class: com.kuaishou.weapon.p0.WeaponHI.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = z;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Context context;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && (context = WeaponHI.mContext) != null) {
                            h a = h.a(context, "re_po_rt");
                            boolean z2 = this.a;
                            if (!z2) {
                                a.a("a1_p_s_p_s_c_b", Boolean.valueOf(z2));
                            } else if (!a.e("a1_p_s_p_s_c_b")) {
                                a.a("a1_p_s_p_s_c_b", Boolean.valueOf(this.a));
                                try {
                                    if (a.c(df.bq, 1) == 1) {
                                        dd.a(WeaponHI.mContext).a(103);
                                        db.a(WeaponHI.mContext).a(103, 0);
                                        cy.a(WeaponHI.mContext).a(103);
                                        dc.a(WeaponHI.mContext).a(103);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
