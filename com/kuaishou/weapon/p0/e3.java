package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
/* loaded from: classes9.dex */
public class e3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e3 a;

        public a(e3 e3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    i a = i.a(this.a.a, "re_po_rt");
                    if (a.a(f3.B, 0) == 1) {
                        long a2 = f3.a(this.a.a).a(f3.Y0);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - a2 >= a.a(f3.E, 2) * 3600000) {
                            try {
                                String b = new p2(this.a.a).b(l2.h);
                                int intValue = Integer.valueOf(l2.h).intValue();
                                if (b != null && b.length() > 10) {
                                    new c1(this.a.a, b, intValue).a(Constants.DEFAULT_UIN);
                                }
                            } catch (Throwable unused) {
                            }
                            f3.a(this.a.a).a(f3.Y0, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        }
    }

    public e3(Context context) {
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

    public static e3 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (e3.class) {
                    if (b == null) {
                        b = new e3(context);
                    }
                }
            }
            return b;
        }
        return (e3) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o.a().a(new a(this));
        }
    }
}
