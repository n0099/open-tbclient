package com.win.opensdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class Q {
    public static /* synthetic */ Interceptable $ic;
    public static final Q a;

    /* renamed from: b  reason: collision with root package name */
    public static final Q f62609b;

    /* renamed from: c  reason: collision with root package name */
    public static final Q f62610c;

    /* renamed from: d  reason: collision with root package name */
    public static final Q f62611d;

    /* renamed from: e  reason: collision with root package name */
    public static final Q f62612e;

    /* renamed from: f  reason: collision with root package name */
    public static final Q f62613f;

    /* renamed from: g  reason: collision with root package name */
    public static final Q f62614g;

    /* renamed from: h  reason: collision with root package name */
    public static final Q f62615h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ Q[] f62616i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1471126134, "Lcom/win/opensdk/Q;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1471126134, "Lcom/win/opensdk/Q;");
                return;
            }
        }
        a = new Q("UnknownHost", 0);
        f62609b = new Q("Socket", 1);
        f62610c = new Q("SocketTimeout", 2);
        f62611d = new Q("ConnectTimeout", 3);
        f62612e = new Q("IO", 4);
        f62613f = new Q("HttpResponse", 5);
        f62614g = new Q("JSON", 6);
        Q q = new Q("Interrupted", 7);
        f62615h = q;
        f62616i = new Q[]{a, f62609b, f62610c, f62611d, f62612e, f62613f, f62614g, q};
    }

    public Q(String str, int i2) {
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

    public static Q valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Q) Enum.valueOf(Q.class, str) : (Q) invokeL.objValue;
    }

    public static Q[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Q[]) f62616i.clone() : (Q[]) invokeV.objValue;
    }
}
