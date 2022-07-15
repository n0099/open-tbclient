package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c90 {
    public static /* synthetic */ Interceptable $ic;
    public static c90 w;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public float j;
    public int k;
    public int l;
    public int m;
    public int n;
    public float o;
    public float p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;
    public float v;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final c90 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-515193318, "Lcom/repackage/c90$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-515193318, "Lcom/repackage/c90$a;");
                    return;
                }
            }
            a = new c90();
        }
    }

    public c90() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static c90 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (w == null) {
                w = a.a;
            }
            return w;
        }
        return (c90) invokeV.objValue;
    }

    public void b(int i, int i2, int i3, int i4, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.e = i;
            this.f = i2;
            this.g = i3;
            this.h = i4;
            this.i = f;
            this.j = f2;
        }
    }

    public void c(int i, int i2, int i3, int i4, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.k = i;
            this.l = i2;
            this.m = i3;
            this.n = i4;
            this.o = f;
            this.p = f2;
        }
    }

    public void d(int i, int i2, int i3, int i4, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.q = i;
            this.r = i2;
            this.s = i3;
            this.t = i4;
            this.u = f;
            this.v = f2;
        }
    }

    public void e(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }
}
