package com.win.opensdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class D {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final D f39332a;

    /* renamed from: b  reason: collision with root package name */
    public static final D f39333b;

    /* renamed from: c  reason: collision with root package name */
    public static final D f39334c;

    /* renamed from: d  reason: collision with root package name */
    public static final D f39335d;

    /* renamed from: e  reason: collision with root package name */
    public static final D f39336e;

    /* renamed from: f  reason: collision with root package name */
    public static final D f39337f;

    /* renamed from: g  reason: collision with root package name */
    public static final D f39338g;

    /* renamed from: h  reason: collision with root package name */
    public static final D f39339h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ D[] f39340i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1471125731, "Lcom/win/opensdk/D;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1471125731, "Lcom/win/opensdk/D;");
                return;
            }
        }
        f39332a = new D("UnknownHost", 0);
        f39333b = new D("Socket", 1);
        f39334c = new D("SocketTimeout", 2);
        f39335d = new D("ConnectTimeout", 3);
        f39336e = new D("IO", 4);
        f39337f = new D("HttpResponse", 5);
        f39338g = new D("JSON", 6);
        D d2 = new D("Interrupted", 7);
        f39339h = d2;
        f39340i = new D[]{f39332a, f39333b, f39334c, f39335d, f39336e, f39337f, f39338g, d2};
    }

    public D(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
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

    public static D valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (D) Enum.valueOf(D.class, str) : (D) invokeL.objValue;
    }

    public static D[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (D[]) f39340i.clone() : (D[]) invokeV.objValue;
    }
}
