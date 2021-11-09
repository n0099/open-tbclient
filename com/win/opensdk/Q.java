package com.win.opensdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class Q {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Q f70467a;

    /* renamed from: b  reason: collision with root package name */
    public static final Q f70468b;

    /* renamed from: c  reason: collision with root package name */
    public static final Q f70469c;

    /* renamed from: d  reason: collision with root package name */
    public static final Q f70470d;

    /* renamed from: e  reason: collision with root package name */
    public static final Q f70471e;

    /* renamed from: f  reason: collision with root package name */
    public static final Q f70472f;

    /* renamed from: g  reason: collision with root package name */
    public static final Q f70473g;

    /* renamed from: h  reason: collision with root package name */
    public static final Q f70474h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ Q[] f70475i;
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
        f70467a = new Q("UnknownHost", 0);
        f70468b = new Q("Socket", 1);
        f70469c = new Q("SocketTimeout", 2);
        f70470d = new Q("ConnectTimeout", 3);
        f70471e = new Q("IO", 4);
        f70472f = new Q("HttpResponse", 5);
        f70473g = new Q("JSON", 6);
        Q q = new Q("Interrupted", 7);
        f70474h = q;
        f70475i = new Q[]{f70467a, f70468b, f70469c, f70470d, f70471e, f70472f, f70473g, q};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Q[]) f70475i.clone() : (Q[]) invokeV.objValue;
    }
}
