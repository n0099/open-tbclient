package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l2 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A = 106;
    public static String a = "1003001";
    public static String b = "1007001";
    public static String c = "1007002";
    public static String d = "1007004";
    public static String e = "1007005";
    public static String f = "1007017";
    public static String g = "1007009";
    public static String h = "1007010";
    public static String i = "1007016";
    public static String j = "ANDROID";
    public static String k = "Load so";
    public static String l = "so not found";
    public static String m = "init plugin apkInfo is null";
    public static String n = "init plugin apkPath is null";
    public static String o = "sync load plugin fails";
    public static String p = "upgrade plugin's apk decrypt fails";
    public static String q = "decrypt fails or md5 verify fails";
    public static String r = "upgradePlugin apkInfo is null";
    public static String s = "upgradePlugin file doesn't exist";
    public static String t = "upgradePlugin apkInfo doesn't exist";
    public static String u = "upgradePlugin syncPlugin errors";
    public static String v = "so not found";
    public static final int w = 100;
    public static final int x = 103;
    public static final int y = 101;
    public static final int z = 102;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(334592593, "Lcom/kuaishou/weapon/p0/l2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(334592593, "Lcom/kuaishou/weapon/p0/l2;");
        }
    }

    public l2() {
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
