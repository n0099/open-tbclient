package com.kuaishou.weapon.un;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f57190b = "com.kuaishou.weapon";
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final String f57191c = "com.kuaishou.weapon";

    /* renamed from: d  reason: collision with root package name */
    public static final String f57192d = "release";

    /* renamed from: e  reason: collision with root package name */
    public static final String f57193e = "";

    /* renamed from: f  reason: collision with root package name */
    public static final int f57194f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final String f57195g = "2.8.3";
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
