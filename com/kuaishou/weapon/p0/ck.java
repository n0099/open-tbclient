package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class ck {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A = 101;
    public static final int B = 102;
    public static final int C = 106;
    public static String a = "1003001";
    public static String b = "1007001";
    public static String c = "1007002";
    public static String d = "1007004";
    public static String e = "1007005";
    public static String f = "1007017";
    public static String g = "1007009";
    public static String h = "1007010";
    public static String i = "1007016";
    public static String j = "1007019";
    public static String k = "1007014";
    public static String l = "ANDROID";
    public static String m = "Load so";
    public static String n = "so not found";
    public static String o = "init plugin apkInfo is null";
    public static String p = "init plugin apkPath is null";
    public static String q = "sync load plugin fails";
    public static String r = "upgrade plugin's apk decrypt fails";
    public static String s = "decrypt fails or md5 verify fails";
    public static String t = "upgradePlugin apkInfo is null";
    public static String u = "upgradePlugin file doesn't exist";
    public static String v = "upgradePlugin apkInfo doesn't exist";
    public static String w = "upgradePlugin syncPlugin errors";
    public static String x = "so not found";
    public static final int y = 100;
    public static final int z = 103;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(334585711, "Lcom/kuaishou/weapon/p0/ck;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(334585711, "Lcom/kuaishou/weapon/p0/ck;");
        }
    }

    public ck() {
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
