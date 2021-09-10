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
    public static final S f76873a;

    /* renamed from: b  reason: collision with root package name */
    public static final S f76874b;

    /* renamed from: c  reason: collision with root package name */
    public static final S f76875c;

    /* renamed from: d  reason: collision with root package name */
    public static final S f76876d;

    /* renamed from: e  reason: collision with root package name */
    public static final S f76877e;

    /* renamed from: f  reason: collision with root package name */
    public static final S f76878f;

    /* renamed from: g  reason: collision with root package name */
    public static final S f76879g;

    /* renamed from: h  reason: collision with root package name */
    public static final S f76880h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ S[] f76881i;
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
        f76873a = new S("UnknownHost", 0);
        f76874b = new S("Socket", 1);
        f76875c = new S("SocketTimeout", 2);
        f76876d = new S("ConnectTimeout", 3);
        f76877e = new S("IO", 4);
        f76878f = new S("HttpResponse", 5);
        f76879g = new S("JSON", 6);
        S s = new S("Interrupted", 7);
        f76880h = s;
        f76881i = new S[]{f76873a, f76874b, f76875c, f76876d, f76877e, f76878f, f76879g, s};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (S[]) f76881i.clone() : (S[]) invokeV.objValue;
    }
}
