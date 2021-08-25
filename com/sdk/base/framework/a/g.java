package com.sdk.base.framework.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final g f75316a;

    /* renamed from: b  reason: collision with root package name */
    public static final g f75317b;

    /* renamed from: c  reason: collision with root package name */
    public static final g f75318c;

    /* renamed from: d  reason: collision with root package name */
    public static final g f75319d;

    /* renamed from: e  reason: collision with root package name */
    public static final g f75320e;

    /* renamed from: f  reason: collision with root package name */
    public static final g f75321f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1040379422, "Lcom/sdk/base/framework/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1040379422, "Lcom/sdk/base/framework/a/g;");
                return;
            }
        }
        f75316a = new g("WAITING", 0, 0);
        f75317b = new g("STARTED", 1, 1);
        f75318c = new g("LOADING", 2, 2);
        f75319d = new g("FAILURE", 3, 3);
        f75320e = new g("CANCELLED", 4, 4);
        f75321f = new g(com.alipay.security.mobile.module.http.model.c.f36090g, 5, 5);
    }

    public g(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
