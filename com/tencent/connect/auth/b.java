package com.tencent.connect.auth;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.tauth.IUiListener;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static b a;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ boolean f62182d;

    /* renamed from: e  reason: collision with root package name */
    public static int f62183e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, a> f62184b;

    /* renamed from: c  reason: collision with root package name */
    public final String f62185c;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public IUiListener a;

        /* renamed from: b  reason: collision with root package name */
        public com.tencent.connect.auth.a f62186b;

        /* renamed from: c  reason: collision with root package name */
        public String f62187c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(231180439, "Lcom/tencent/connect/auth/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(231180439, "Lcom/tencent/connect/auth/b;");
                return;
            }
        }
        f62182d = !b.class.desiredAssertionStatus();
        f62183e = 0;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62184b = new HashMap<>();
        this.f62185c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                a = new b();
            }
            return a;
        }
        return (b) invokeV.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int i2 = f62183e + 1;
            f62183e = i2;
            return i2;
        }
        return invokeV.intValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
            char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
            int length = charArray.length;
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < ceil; i2++) {
                stringBuffer.append(charArray[(int) (Math.random() * length)]);
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public String a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            int b2 = b();
            try {
                HashMap<String, a> hashMap = this.f62184b;
                hashMap.put("" + b2, aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return "" + b2;
        }
        return (String) invokeL.objValue;
    }
}
