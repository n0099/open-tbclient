package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public long b;
    public int c;
    public String d;
    public boolean e;
    public byte[] f;
    public long g;
    public long h;
    public long i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public long n;
    public boolean o;

    public e80() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new byte[0];
        this.b = 15000L;
        this.c = -1;
        this.d = "";
        this.e = false;
        this.f = new byte[0];
        this.g = 60000L;
        this.h = -1L;
        this.i = -1L;
        this.j = -1;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = -1L;
        this.o = false;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.m) {
                return "Request correlationId :" + this.n + ", serviceId :" + this.h + ", methodId :" + this.i + ", connectState :" + this.j + ", isNotify :" + this.e + ", bodySize :" + this.a.length;
            }
            return "Response correlationId " + this.n + ", serviceId :" + this.h + ", methodId :" + this.i + ", errorCode :" + this.c + ", errorMsg :" + this.d + ", intervalMs :" + this.g + ", isNotify :" + this.e + ", bodySize :" + this.f.length;
        }
        return (String) invokeV.objValue;
    }
}
