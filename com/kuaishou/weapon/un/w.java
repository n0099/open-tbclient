package com.kuaishou.weapon.un;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class w {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String c = "plc001_c_h_c";
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 4;
    public static final int g = 8;
    public static final int h = 16;
    public static final int i = 32;
    public static final int j = 64;
    public static final int k = 128;
    public static final int l = 256;
    public static final int m = 512;
    public static final int n = 1024;
    public static final int o = 2048;
    public static final int p = 4096;
    public static final int q = 8192;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public d b;

    public w(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        try {
            this.b = dVar;
            this.a = dVar.b(c, 0);
            a();
        } catch (Throwable th) {
            x0.a(th);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                int i2 = l1.i();
                if (this.a != i2) {
                    this.a = i2;
                    this.b.c(c, i2);
                }
            } catch (Throwable th) {
                x0.a(th);
            }
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            a();
            return (this.a & i2) != i2;
        }
        return invokeI.booleanValue;
    }
}
