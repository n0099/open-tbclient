package com.win.opensdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class Q {
    public static /* synthetic */ Interceptable $ic;
    public static final Q a;

    /* renamed from: b  reason: collision with root package name */
    public static final Q f59368b;

    /* renamed from: c  reason: collision with root package name */
    public static final Q f59369c;

    /* renamed from: d  reason: collision with root package name */
    public static final Q f59370d;

    /* renamed from: e  reason: collision with root package name */
    public static final Q f59371e;

    /* renamed from: f  reason: collision with root package name */
    public static final Q f59372f;

    /* renamed from: g  reason: collision with root package name */
    public static final Q f59373g;

    /* renamed from: h  reason: collision with root package name */
    public static final Q f59374h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ Q[] f59375i;
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
        f59368b = new Q("Socket", 1);
        f59369c = new Q("SocketTimeout", 2);
        f59370d = new Q("ConnectTimeout", 3);
        f59371e = new Q("IO", 4);
        f59372f = new Q("HttpResponse", 5);
        f59373g = new Q("JSON", 6);
        Q q = new Q("Interrupted", 7);
        f59374h = q;
        f59375i = new Q[]{a, f59368b, f59369c, f59370d, f59371e, f59372f, f59373g, q};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Q[]) f59375i.clone() : (Q[]) invokeV.objValue;
    }
}
