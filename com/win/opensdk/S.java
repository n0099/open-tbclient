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
    public static final S f77227a;

    /* renamed from: b  reason: collision with root package name */
    public static final S f77228b;

    /* renamed from: c  reason: collision with root package name */
    public static final S f77229c;

    /* renamed from: d  reason: collision with root package name */
    public static final S f77230d;

    /* renamed from: e  reason: collision with root package name */
    public static final S f77231e;

    /* renamed from: f  reason: collision with root package name */
    public static final S f77232f;

    /* renamed from: g  reason: collision with root package name */
    public static final S f77233g;

    /* renamed from: h  reason: collision with root package name */
    public static final S f77234h;

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ S[] f77235i;
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
        f77227a = new S("UnknownHost", 0);
        f77228b = new S("Socket", 1);
        f77229c = new S("SocketTimeout", 2);
        f77230d = new S("ConnectTimeout", 3);
        f77231e = new S("IO", 4);
        f77232f = new S("HttpResponse", 5);
        f77233g = new S("JSON", 6);
        S s = new S("Interrupted", 7);
        f77234h = s;
        f77235i = new S[]{f77227a, f77228b, f77229c, f77230d, f77231e, f77232f, f77233g, s};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (S[]) f77235i.clone() : (S[]) invokeV.objValue;
    }
}
