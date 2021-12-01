package com.sdk.base.framework.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public static final j a;

    /* renamed from: b  reason: collision with root package name */
    public static final j f60954b;

    /* renamed from: c  reason: collision with root package name */
    public static j f60955c;

    /* renamed from: d  reason: collision with root package name */
    public static j f60956d;

    /* renamed from: e  reason: collision with root package name */
    public static j f60957e;

    /* renamed from: f  reason: collision with root package name */
    public static j f60958f;

    /* renamed from: g  reason: collision with root package name */
    public static j f60959g;

    /* renamed from: h  reason: collision with root package name */
    public static j f60960h;

    /* renamed from: i  reason: collision with root package name */
    public static j f60961i;

    /* renamed from: j  reason: collision with root package name */
    public static j f60962j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: k  reason: collision with root package name */
    public final String f60963k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1040379329, "Lcom/sdk/base/framework/a/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1040379329, "Lcom/sdk/base/framework/a/j;");
                return;
            }
        }
        a = new j("GET", 0, "GET");
        f60954b = new j("POST", 1, "POST");
        f60955c = new j(HttpPut.METHOD_NAME, 2, HttpPut.METHOD_NAME);
        f60956d = new j("HEAD", 3, "HEAD");
        f60957e = new j("MOVE", 4, "MOVE");
        f60958f = new j("COPY", 5, "COPY");
        f60959g = new j(HttpDelete.METHOD_NAME, 6, HttpDelete.METHOD_NAME);
        f60960h = new j(HttpOptions.METHOD_NAME, 7, HttpOptions.METHOD_NAME);
        f60961i = new j(HttpTrace.METHOD_NAME, 8, HttpTrace.METHOD_NAME);
        f60962j = new j("CONNECT", 9, "CONNECT");
    }

    public j(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60963k = str2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60963k : (String) invokeV.objValue;
    }
}
