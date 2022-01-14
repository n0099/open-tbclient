package com.win.opensdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class Q {
    public static /* synthetic */ Interceptable $ic;
    public static final Q a;

    /* renamed from: b  reason: collision with root package name */
    public static final Q f60806b;

    /* renamed from: c  reason: collision with root package name */
    public static final Q f60807c;

    /* renamed from: d  reason: collision with root package name */
    public static final Q f60808d;

    /* renamed from: e  reason: collision with root package name */
    public static final Q f60809e;

    /* renamed from: f  reason: collision with root package name */
    public static final Q f60810f;

    /* renamed from: g  reason: collision with root package name */
    public static final Q f60811g;

    /* renamed from: h  reason: collision with root package name */
    public static final Q f60812h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ Q[] f60813i;
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
        f60806b = new Q("Socket", 1);
        f60807c = new Q("SocketTimeout", 2);
        f60808d = new Q("ConnectTimeout", 3);
        f60809e = new Q("IO", 4);
        f60810f = new Q("HttpResponse", 5);
        f60811g = new Q("JSON", 6);
        Q q = new Q("Interrupted", 7);
        f60812h = q;
        f60813i = new Q[]{a, f60806b, f60807c, f60808d, f60809e, f60810f, f60811g, q};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Q[]) f60813i.clone() : (Q[]) invokeV.objValue;
    }
}
