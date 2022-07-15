package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ﹶﹶ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0453 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final String f693 = "RISK_AUTH_FAILED";

    /* renamed from: ʻʻ  reason: contains not printable characters */
    public static final int f694 = 1;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final String f695 = "RISK_SERVICE_OBJECT_NULL";

    /* renamed from: ʼʼ  reason: contains not printable characters */
    public static final int f696 = 20;

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final String f697 = "RISK_GET_FIELD_EMPTY";

    /* renamed from: ʽʽ  reason: contains not printable characters */
    public static final int f698 = 5;

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final String f699 = "RISK_EXCEPTION_HAPPEN";

    /* renamed from: ʾʾ  reason: contains not printable characters */
    public static final int f700 = 12;

    /* renamed from: ʿ  reason: contains not printable characters */
    public static final String f701 = "RISK_SWITCH_CLOSED";

    /* renamed from: ʿʿ  reason: contains not printable characters */
    public static final int f702 = 8;

    /* renamed from: ˆ  reason: contains not printable characters */
    public static final String f703 = "RISK_NOT_ALLOWED";

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final int f704 = -2;

    /* renamed from: ˉ  reason: contains not printable characters */
    public static final int f705 = -1;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final int f706 = 0;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final String f707 = "/.";

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final String f708 = ".tmp";

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final int f709 = 16;

    /* renamed from: ˑ  reason: contains not printable characters */
    public static final String f710 = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";

    /* renamed from: י  reason: contains not printable characters */
    public static final String f711 = "OUROR1J1WjlNdnNieS93Mg==";

    /* renamed from: ـ  reason: contains not printable characters */
    public static final String f712 = "com.kuaishou.weapon";

    /* renamed from: ــ  reason: contains not printable characters */
    public static final int f713 = 6;

    /* renamed from: ٴ  reason: contains not printable characters */
    public static final String f714 = "w.db";

    /* renamed from: ᐧ  reason: contains not printable characters */
    public static final String f715 = "wp";

    /* renamed from: ᐧᐧ  reason: contains not printable characters */
    public static final int f716 = 12;

    /* renamed from: ᴵ  reason: contains not printable characters */
    public static final String f717 = "acbd";

    /* renamed from: ᴵᴵ  reason: contains not printable characters */
    public static final int f718 = 8;

    /* renamed from: ᵎ  reason: contains not printable characters */
    public static final String f719 = "OTUzc3E1N0w5NTIzMW80OUQxMGo3R1dFa0ZiandHT0w=";

    /* renamed from: ᵔ  reason: contains not printable characters */
    public static int f720 = -1;

    /* renamed from: ᵢ  reason: contains not printable characters */
    public static final int f721 = 1;

    /* renamed from: ⁱ  reason: contains not printable characters */
    public static final int f722 = 0;

    /* renamed from: ﹳ  reason: contains not printable characters */
    public static final String f723 = "su";

    /* renamed from: ﹶ  reason: contains not printable characters */
    public static final String[] f724;

    /* renamed from: ﾞ  reason: contains not printable characters */
    public static final String[] f725;

    /* renamed from: ﾞﾞ  reason: contains not printable characters */
    public static final int f726 = 2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(399108119, "Lcom/kuaishou/weapon/p0/ﹶﹶ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(399108119, "Lcom/kuaishou/weapon/p0/ﹶﹶ;");
                return;
            }
        }
        f724 = new String[]{"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su", "com.topjohnwu.magisk", "com.kingroot.kinguser", "com.kingo.root", "com.smedialink.oneclickroot"};
        f725 = new String[]{"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/failsafe/", "/system/xbin/"};
    }

    public C0453() {
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
