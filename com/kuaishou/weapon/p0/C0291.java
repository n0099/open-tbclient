package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʻ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public final class C0291 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final boolean f8 = false;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final String f9 = "com.kuaishou.weapon";
    @Deprecated

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final String f10 = "com.kuaishou.weapon";

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final String f11 = "release";

    /* renamed from: ʿ  reason: contains not printable characters */
    public static final String f12 = "";

    /* renamed from: ˆ  reason: contains not printable characters */
    public static final int f13 = 1;

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final String f14 = "5.0.0";
    public transient /* synthetic */ FieldHolder $fh;

    public C0291() {
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
