package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʼˏ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0331 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String f76 = "1003001";

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String f77 = "1007001";

    /* renamed from: ʽ  reason: contains not printable characters */
    public static String f78 = "1007002";

    /* renamed from: ʾ  reason: contains not printable characters */
    public static String f79 = "1007004";

    /* renamed from: ʿ  reason: contains not printable characters */
    public static String f80 = "1007005";

    /* renamed from: ˆ  reason: contains not printable characters */
    public static String f81 = "1007017";

    /* renamed from: ˈ  reason: contains not printable characters */
    public static String f82 = "1007009";

    /* renamed from: ˉ  reason: contains not printable characters */
    public static String f83 = "1007010";

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String f84 = "1007016";

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String f85 = "ANDROID";

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String f86 = "Load so";

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String f87 = "so not found";

    /* renamed from: ˑ  reason: contains not printable characters */
    public static String f88 = "init plugin apkInfo is null";

    /* renamed from: י  reason: contains not printable characters */
    public static String f89 = "init plugin apkPath is null";

    /* renamed from: ـ  reason: contains not printable characters */
    public static String f90 = "sync load plugin fails";

    /* renamed from: ٴ  reason: contains not printable characters */
    public static String f91 = "upgrade plugin's apk decrypt fails";

    /* renamed from: ᐧ  reason: contains not printable characters */
    public static String f92 = "decrypt fails or md5 verify fails";

    /* renamed from: ᐧᐧ  reason: contains not printable characters */
    public static final int f93 = 106;

    /* renamed from: ᴵ  reason: contains not printable characters */
    public static String f94 = "upgradePlugin apkInfo is null";

    /* renamed from: ᵎ  reason: contains not printable characters */
    public static String f95 = "upgradePlugin file doesn't exist";

    /* renamed from: ᵔ  reason: contains not printable characters */
    public static String f96 = "upgradePlugin apkInfo doesn't exist";

    /* renamed from: ᵢ  reason: contains not printable characters */
    public static String f97 = "upgradePlugin syncPlugin errors";

    /* renamed from: ⁱ  reason: contains not printable characters */
    public static String f98 = "so not found";

    /* renamed from: ﹳ  reason: contains not printable characters */
    public static final int f99 = 100;

    /* renamed from: ﹶ  reason: contains not printable characters */
    public static final int f100 = 103;

    /* renamed from: ﾞ  reason: contains not printable characters */
    public static final int f101 = 101;

    /* renamed from: ﾞﾞ  reason: contains not printable characters */
    public static final int f102 = 102;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(335182244, "Lcom/kuaishou/weapon/p0/ʼˏ;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(335182244, "Lcom/kuaishou/weapon/p0/ʼˏ;");
        }
    }

    public C0331() {
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
}
