package com.cmic.sso.sdk.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.a.b;
/* loaded from: classes12.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    public static j f54987b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            f54987b = new j(context);
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                b.C1963b b2 = com.cmic.sso.sdk.a.b.a().b();
                return b2.e(b2.d());
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                int e2 = com.cmic.sso.sdk.a.b.a().b().e();
                return e2 >= 0 ? Integer.toString(e2) : "";
            } catch (Exception e3) {
                e3.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                b.C1963b b2 = com.cmic.sso.sdk.a.b.a().b();
                String e2 = b2.e((b2.d() + 1) % 2);
                return e2 == null ? "" : e2;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.C1963b b2 = com.cmic.sso.sdk.a.b.a().b();
            return b2.a(b2.d());
        }
        return (String) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
            if (telephonyManager != null) {
                String simOperator = telephonyManager.getSimOperator();
                c.b("SIMUtils", "SysOperType = " + simOperator);
                return a(simOperator);
            }
            return "0";
        }
        return (String) invokeV.objValue;
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f54987b : (j) invokeV.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public String a(boolean z) {
        InterceptResult invokeZ;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            b.C1963b b2 = com.cmic.sso.sdk.a.b.a().b();
            String f2 = b2.f(b2.d());
            if (TextUtils.isEmpty(f2) && n.a(this.a) && (telephonyManager = (TelephonyManager) this.a.getSystemService("phone")) != null) {
                f2 = telephonyManager.getSimOperator();
                if (TextUtils.isEmpty(f2) && g.a(this.a, com.kuaishou.weapon.un.s.f56838c) && n.d()) {
                    String str = null;
                    try {
                        str = telephonyManager.getSubscriberId();
                    } catch (Exception unused) {
                        c.a("SIMUtils", "getOperator失败");
                    }
                    if (!TextUtils.isEmpty(str) && str.length() >= 5) {
                        f2 = str.substring(0, 5);
                    }
                }
            }
            c.b("SIMUtils", "operator: " + f2);
            if (TextUtils.isEmpty(f2)) {
                return z ? "0" : "";
            }
            return a(f2);
        }
        return (String) invokeZ.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String a(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 49679479) {
                if (str.equals("46009")) {
                    c2 = 6;
                }
                c2 = 65535;
            } else if (hashCode != 49679502) {
                switch (hashCode) {
                    case 49679470:
                        if (str.equals("46000")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 49679471:
                        if (str.equals("46001")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 49679472:
                        if (str.equals("46002")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 49679473:
                        if (str.equals("46003")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 49679474:
                        if (str.equals("46004")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 49679475:
                        if (str.equals("46005")) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 49679476:
                        if (str.equals("46006")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 49679477:
                        if (str.equals("46007")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
            } else {
                if (str.equals("46011")) {
                    c2 = '\t';
                }
                c2 = 65535;
            }
            switch (c2) {
                case 0:
                case 1:
                case 2:
                case 3:
                    c.a("SIMUtils", "中国移动");
                    return "1";
                case 4:
                case 5:
                case 6:
                    c.a("SIMUtils", "中国联通");
                    return "2";
                case 7:
                case '\b':
                case '\t':
                    c.a("SIMUtils", "中国电信");
                    return "3";
                default:
                    return "0";
            }
        }
        return (String) invokeL.objValue;
    }
}
