package com.win.opensdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class S {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final S f77192a;

    /* renamed from: b  reason: collision with root package name */
    public static final S f77193b;

    /* renamed from: c  reason: collision with root package name */
    public static final S f77194c;

    /* renamed from: d  reason: collision with root package name */
    public static final S f77195d;

    /* renamed from: e  reason: collision with root package name */
    public static final S f77196e;

    /* renamed from: f  reason: collision with root package name */
    public static final S f77197f;

    /* renamed from: g  reason: collision with root package name */
    public static final S f77198g;

    /* renamed from: h  reason: collision with root package name */
    public static final S f77199h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ S[] f77200i;
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
        f77192a = new S("UnknownHost", 0);
        f77193b = new S("Socket", 1);
        f77194c = new S("SocketTimeout", 2);
        f77195d = new S("ConnectTimeout", 3);
        f77196e = new S("IO", 4);
        f77197f = new S("HttpResponse", 5);
        f77198g = new S("JSON", 6);
        S s = new S("Interrupted", 7);
        f77199h = s;
        f77200i = new S[]{f77192a, f77193b, f77194c, f77195d, f77196e, f77197f, f77198g, s};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (S[]) f77200i.clone() : (S[]) invokeV.objValue;
    }
}
