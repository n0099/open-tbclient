package com.kuaishou.weapon.un;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class q0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String A = "decrypt fails or md5 verify fails";
    public static String B = "upgradePlugin apkInfo is null";
    public static String C = "upgradePlugin file doesn't exist";
    public static String D = "upgradePlugin apkInfo doesn't exist";
    public static String E = "upgradePlugin syncPlugin errors";
    public static String F = "clazz is null";
    public static String G = "imple is null";
    public static String H = "executeCallStatus fails";
    public static String a = "1001001";

    /* renamed from: b  reason: collision with root package name */
    public static String f55255b = "1001002";

    /* renamed from: c  reason: collision with root package name */
    public static String f55256c = "1001003";

    /* renamed from: d  reason: collision with root package name */
    public static String f55257d = "1001004";

    /* renamed from: e  reason: collision with root package name */
    public static String f55258e = "1001005";

    /* renamed from: f  reason: collision with root package name */
    public static String f55259f = "ANDROID";

    /* renamed from: g  reason: collision with root package name */
    public static String f55260g = "CBH ak or sk is null";

    /* renamed from: h  reason: collision with root package name */
    public static String f55261h = "SDK has been initialized by host";

    /* renamed from: i  reason: collision with root package name */
    public static String f55262i = "Plugins will be loaded";

    /* renamed from: j  reason: collision with root package name */
    public static String f55263j = "T run has exit: ";
    public static String k = "SDK will execute Plugins Upgrade handler interval: ";
    public static String l = "Pull Plugins Setting Response = ";
    public static String m = "Response is null = ";
    public static String n = "Cloud Version higher than Client Plugins";
    public static String o = "ak or sk errors";
    public static String p = "mIN/mOUT/sLastCheckTime errors";
    public static String q = "kuaishou risk pluginloader response json is null";
    public static String r = "network unused";
    public static String s = "unload unused plugin engine implement object is null";
    public static String t = "unload unused plugin exception happened";
    public static String u = "init plugin apkInfo is null";
    public static String v = "init plugin apkPath is null";
    public static String w = "sync load plugin fails";
    public static String x = "classLoader is null";
    public static String y = "callTargetMethodOfTargetClass init fails";
    public static String z = "upgrade plugin's apk decrypt fails";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(535001393, "Lcom/kuaishou/weapon/un/q0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(535001393, "Lcom/kuaishou/weapon/un/q0;");
        }
    }

    public q0() {
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
