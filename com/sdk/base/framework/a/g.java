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
/* loaded from: classes7.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public static final g a;

    /* renamed from: b  reason: collision with root package name */
    public static final g f42527b;

    /* renamed from: c  reason: collision with root package name */
    public static final g f42528c;

    /* renamed from: d  reason: collision with root package name */
    public static final g f42529d;

    /* renamed from: e  reason: collision with root package name */
    public static final g f42530e;

    /* renamed from: f  reason: collision with root package name */
    public static final g f42531f;
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
        a = new g("WAITING", 0, 0);
        f42527b = new g("STARTED", 1, 1);
        f42528c = new g("LOADING", 2, 2);
        f42529d = new g("FAILURE", 3, 3);
        f42530e = new g("CANCELLED", 4, 4);
        f42531f = new g("SUCCESS", 5, 5);
    }

    public g(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
