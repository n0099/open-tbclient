package com.cmic.sso.sdk.e;

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
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static j b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    public j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            b = new j(context);
        }
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b;
        }
        return (j) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                int a = com.cmic.sso.sdk.b.a.a().b().a();
                if (a >= 0) {
                    return Integer.toString(a);
                }
                return "";
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String b(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode != 49679479) {
                if (hashCode != 49679502) {
                    switch (hashCode) {
                        case 49679470:
                            if (str.equals("46000")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 49679471:
                            if (str.equals("46001")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 49679472:
                            if (str.equals("46002")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 49679473:
                            if (str.equals("46003")) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 49679474:
                            if (str.equals("46004")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 49679475:
                            if (str.equals("46005")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case 49679476:
                            if (str.equals("46006")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case 49679477:
                            if (str.equals("46007")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                } else {
                    if (str.equals("46011")) {
                        c = '\t';
                    }
                    c = 65535;
                }
            } else {
                if (str.equals("46009")) {
                    c = 6;
                }
                c = 65535;
            }
            switch (c) {
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

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = c();
            }
            return b(str);
        }
        return (String) invokeL.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
            if (telephonyManager != null) {
                String simOperator = telephonyManager.getSimOperator();
                c.b("SIMUtils", "SysOperator= " + simOperator);
                return simOperator;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
