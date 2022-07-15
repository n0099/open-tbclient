package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʻˎ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0303 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final String f33 = "com.kuaishou.weapon";

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final String f34 = "5.0.0";

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final boolean f35 = false;

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final String f36 = "weapon";

    /* renamed from: ʿ  reason: contains not printable characters */
    public static final String f37 = "0.0.0";

    /* renamed from: ˆ  reason: contains not printable characters */
    public static final String f38 = "com.kuaishou.weapon.p0.env.action";

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final String f39 = "p0";
    public transient /* synthetic */ FieldHolder $fh;

    public C0303() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
