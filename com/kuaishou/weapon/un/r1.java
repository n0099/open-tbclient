package com.kuaishou.weapon.un;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class r1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "123456";

    /* renamed from: b  reason: collision with root package name */
    public static final String f56827b = "2.8.3";

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f56828c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final String f56829d = "com.kuaishou.weapon";

    /* renamed from: e  reason: collision with root package name */
    public static final String f56830e = "com.kuaishou.weapon";

    /* renamed from: f  reason: collision with root package name */
    public static final String f56831f = ".WeaponEngineImpl";

    /* renamed from: g  reason: collision with root package name */
    public static final String f56832g = ".WeaponExt";

    /* renamed from: h  reason: collision with root package name */
    public static final String f56833h = "wp_local.cfg";

    /* renamed from: i  reason: collision with root package name */
    public static final String f56834i = ".tmp";

    /* renamed from: j  reason: collision with root package name */
    public static final String f56835j = ".bud";

    /* renamed from: k  reason: collision with root package name */
    public static final String f56836k = "/.";
    public static final String l = "w.db";
    public static final String m = "wp";
    public static final String n = "wc";
    public static final String o = "wcfg";
    public static final String p = "re_po_rt";
    public static final String q = "w";
    public static int r = -1;
    public static final int s = 16;
    public static final String t = "a3NyaXNrY3RsYnVzaW5zc3Z4cHprd3NwYWlvcXBrc3M=";
    public static final String u = "OUROR1J1WjlNdnNieS93Mg==";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(535002385, "Lcom/kuaishou/weapon/un/r1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(535002385, "Lcom/kuaishou/weapon/un/r1;");
        }
    }

    public r1() {
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
