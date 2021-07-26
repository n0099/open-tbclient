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
public final class S {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final S f39654a;

    /* renamed from: b  reason: collision with root package name */
    public static final S f39655b;

    /* renamed from: c  reason: collision with root package name */
    public static final S f39656c;

    /* renamed from: d  reason: collision with root package name */
    public static final S f39657d;

    /* renamed from: e  reason: collision with root package name */
    public static final S f39658e;

    /* renamed from: f  reason: collision with root package name */
    public static final S f39659f;

    /* renamed from: g  reason: collision with root package name */
    public static final S f39660g;

    /* renamed from: h  reason: collision with root package name */
    public static final S f39661h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ S[] f39662i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1471126196, "Lcom/win/opensdk/S;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1471126196, "Lcom/win/opensdk/S;");
                return;
            }
        }
        f39654a = new S("UnknownHost", 0);
        f39655b = new S("Socket", 1);
        f39656c = new S("SocketTimeout", 2);
        f39657d = new S("ConnectTimeout", 3);
        f39658e = new S("IO", 4);
        f39659f = new S("HttpResponse", 5);
        f39660g = new S("JSON", 6);
        S s = new S("Interrupted", 7);
        f39661h = s;
        f39662i = new S[]{f39654a, f39655b, f39656c, f39657d, f39658e, f39659f, f39660g, s};
    }

    public S(String str, int i2) {
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

    public static S valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (S) Enum.valueOf(S.class, str) : (S) invokeL.objValue;
    }

    public static S[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (S[]) f39662i.clone() : (S[]) invokeV.objValue;
    }
}
