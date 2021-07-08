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
/* loaded from: classes6.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final j f38168a;

    /* renamed from: b  reason: collision with root package name */
    public static final j f38169b;

    /* renamed from: c  reason: collision with root package name */
    public static j f38170c;

    /* renamed from: d  reason: collision with root package name */
    public static j f38171d;

    /* renamed from: e  reason: collision with root package name */
    public static j f38172e;

    /* renamed from: f  reason: collision with root package name */
    public static j f38173f;

    /* renamed from: g  reason: collision with root package name */
    public static j f38174g;

    /* renamed from: h  reason: collision with root package name */
    public static j f38175h;

    /* renamed from: i  reason: collision with root package name */
    public static j f38176i;
    public static j j;
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
        f38168a = new j("GET", 0, "GET");
        f38169b = new j("POST", 1, "POST");
        f38170c = new j(HttpPut.METHOD_NAME, 2, HttpPut.METHOD_NAME);
        f38171d = new j("HEAD", 3, "HEAD");
        f38172e = new j("MOVE", 4, "MOVE");
        f38173f = new j("COPY", 5, "COPY");
        f38174g = new j(HttpDelete.METHOD_NAME, 6, HttpDelete.METHOD_NAME);
        f38175h = new j(HttpOptions.METHOD_NAME, 7, HttpOptions.METHOD_NAME);
        f38176i = new j(HttpTrace.METHOD_NAME, 8, HttpTrace.METHOD_NAME);
        j = new j("CONNECT", 9, "CONNECT");
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
