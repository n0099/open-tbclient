package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.List;
import java.util.Random;
/* loaded from: classes8.dex */
public class b3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ b3 c;

        public a(b3 b3Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b3Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = b3Var;
            this.a = i;
            this.b = i2;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v24 int)] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    i a = i.a(this.c.a, "re_po_rt");
                    if (a.a(f3.P, 1) == 1) {
                        long a2 = f3.a(this.c.a).a(f3.U0);
                        long currentTimeMillis = System.currentTimeMillis();
                        long a3 = a.a(f3.R, 1) * 3600000;
                        long a4 = a.a(f3.S, 5) * 60000;
                        int a5 = a.a(f3.T, 0);
                        if (a2 > 0 && currentTimeMillis - a2 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                int nextInt = new Random().nextInt(60) + 1;
                                c.a(this.c.a, q1.f, Integer.valueOf(l2.c).intValue(), (nextInt * 60000) + 3600000, "env://");
                                return;
                            }
                        }
                        long j = currentTimeMillis - a2;
                        if (j < a3 && ((this.a != 100 || a5 != 1) && this.a != 106 && (this.a == 100 || this.a <= 0 || j < a4))) {
                            c.a(this.c.a, q1.f, Integer.valueOf(l2.c).intValue(), a3 - j, "env://");
                            return;
                        }
                        q2.a(this.c.a, new m2(this.c.a, this.a, this.b).a(l2.c), l2.c, true, true);
                        f3.a(this.c.a).a(f3.U0, currentTimeMillis);
                        c.a(this.c.a, q1.f, Integer.valueOf(l2.c).intValue(), a3, "env://");
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public b3(Context context) {
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

    public static b3 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (b3.class) {
                    if (b == null) {
                        b = new b3(context);
                    }
                }
            }
            return b;
        }
        return (b3) invokeL.objValue;
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            o.a().a(new a(this, i, i2));
        }
    }
}
