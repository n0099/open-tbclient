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
/* loaded from: classes10.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final j f75508a;

    /* renamed from: b  reason: collision with root package name */
    public static final j f75509b;

    /* renamed from: c  reason: collision with root package name */
    public static j f75510c;

    /* renamed from: d  reason: collision with root package name */
    public static j f75511d;

    /* renamed from: e  reason: collision with root package name */
    public static j f75512e;

    /* renamed from: f  reason: collision with root package name */
    public static j f75513f;

    /* renamed from: g  reason: collision with root package name */
    public static j f75514g;

    /* renamed from: h  reason: collision with root package name */
    public static j f75515h;

    /* renamed from: i  reason: collision with root package name */
    public static j f75516i;

    /* renamed from: j  reason: collision with root package name */
    public static j f75517j;
    public transient /* synthetic */ FieldHolder $fh;
    public final String k;

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
        f75508a = new j("GET", 0, "GET");
        f75509b = new j("POST", 1, "POST");
        f75510c = new j(HttpPut.METHOD_NAME, 2, HttpPut.METHOD_NAME);
        f75511d = new j("HEAD", 3, "HEAD");
        f75512e = new j("MOVE", 4, "MOVE");
        f75513f = new j("COPY", 5, "COPY");
        f75514g = new j(HttpDelete.METHOD_NAME, 6, HttpDelete.METHOD_NAME);
        f75515h = new j(HttpOptions.METHOD_NAME, 7, HttpOptions.METHOD_NAME);
        f75516i = new j(HttpTrace.METHOD_NAME, 8, HttpTrace.METHOD_NAME);
        f75517j = new j("CONNECT", 9, "CONNECT");
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
        this.k = str2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (String) invokeV.objValue;
    }
}
