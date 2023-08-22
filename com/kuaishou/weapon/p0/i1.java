package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class i1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A = 8;
    public static final int B = 1;
    public static final int C = 5;
    public static final int D = 20;
    public static final int E = 8;
    public static final int F = 12;
    public static final int G = 6;
    public static final String a = "RISK_AUTH_FAILED";
    public static final String b = "RISK_SERVICE_OBJECT_NULL";
    public static final String c = "RISK_GET_FIELD_EMPTY";
    public static final String d = "RISK_EXCEPTION_HAPPEN";
    public static final String e = "RISK_SWITCH_CLOSED";
    public static final String f = "RISK_NOT_ALLOWED";
    public static final int g = -2;
    public static final int h = -1;
    public static final int i = 0;
    public static final String j = "/.";
    public static final String k = ".tmp";
    public static final int l = 16;
    public static final String m = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";
    public static final String n = "OUROR1J1WjlNdnNieS93Mg==";
    public static final String o = "com.kuaishou.weapon";
    public static final String p = "w.db";
    public static final String q = "wp";
    public static final String r = "acbd";
    public static final String s = "OTUzc3E1N0w5NTIzMW80OUQxMGo3R1dFa0ZiandHT0w=";
    public static int t = -1;
    public static final int u = 1;
    public static final int v = 0;
    public static final String w = "su";
    public static final String[] x;
    public static final int y = 2;
    public static final int z = 12;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334589679, "Lcom/kuaishou/weapon/p0/i1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334589679, "Lcom/kuaishou/weapon/p0/i1;");
                return;
            }
        }
        x = new String[]{"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/failsafe/", "/system/xbin/"};
    }

    public i1() {
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
}
