package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.searchbox.download.center.clearcache.util.ClearCacheUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ c3 b;

        public a(c3 c3Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c3Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c3Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    i a = i.a(this.b.a, "re_po_rt");
                    if (a.a(f3.j0, 1) == 1) {
                        long a2 = f3.a(this.b.a).a(f3.W0);
                        long currentTimeMillis = System.currentTimeMillis();
                        int a3 = a.a(f3.m0, 0);
                        long j = currentTimeMillis - a2;
                        if (j >= a.a(f3.l0, 6) * 3600000 || (this.a == 100 && a3 == 1 && j >= ClearCacheUtils.DO_CLEAR_PERIOD)) {
                            h2.a(this.b.a, new w1(this.b.a, this.a, false).a(l2.e), l2.e, true);
                            f3.a(this.b.a).a(f3.W0, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public c3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static c3 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (c3.class) {
                    if (b == null) {
                        b = new c3(context);
                    }
                }
            }
            return b;
        }
        return (c3) invokeL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            o.a().a(new a(this, i));
        }
    }
}
