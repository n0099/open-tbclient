package com.kuaishou.weapon.un;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class w {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final String f53844c = "plc001_c_h_c";

    /* renamed from: d  reason: collision with root package name */
    public static final int f53845d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f53846e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f53847f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static final int f53848g = 8;

    /* renamed from: h  reason: collision with root package name */
    public static final int f53849h = 16;

    /* renamed from: i  reason: collision with root package name */
    public static final int f53850i = 32;

    /* renamed from: j  reason: collision with root package name */
    public static final int f53851j = 64;
    public static final int k = 128;
    public static final int l = 256;
    public static final int m = 512;
    public static final int n = 1024;
    public static final int o = 2048;
    public static final int p = 4096;
    public static final int q = 8192;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public d f53852b;

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
            this.f53852b = dVar;
            this.a = dVar.b(f53844c, 0);
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
                    this.f53852b.c(f53844c, i2);
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
