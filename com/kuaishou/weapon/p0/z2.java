package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.List;
/* loaded from: classes7.dex */
public class z2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z2 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ z2 d;

        public a(z2 z2Var, boolean z, boolean z2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z2Var, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = z2Var;
            this.a = z;
            this.b = z2;
            this.c = i;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v20 int)] */
        @Override // java.lang.Runnable
        public void run() {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    i a = i.a(this.d.a, "re_po_rt");
                    if (a.a(f3.o, 1) == 1) {
                        if (this.a || this.b) {
                            long a2 = f3.a(this.d.a).a(f3.T0);
                            long currentTimeMillis = System.currentTimeMillis();
                            long a3 = a.a(f3.p, 8) * 3600000;
                            int a4 = a.a(f3.q, 0);
                            long a5 = a.a(f3.s, 20) * 60000;
                            if (a2 > 0) {
                                j = a2;
                                if (currentTimeMillis - a2 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                    int hours = new Date(currentTimeMillis).getHours();
                                    List list = WeaponHI.isList;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(hours);
                                    if (list.contains(sb.toString())) {
                                        return;
                                    }
                                }
                            } else {
                                j = a2;
                            }
                            long j2 = currentTimeMillis - j;
                            if (j2 >= a3 || ((this.c == 100 && a4 == 1) || ((this.c == 101 || this.c == 102) && j2 >= a5))) {
                                q2.a(this.d.a, new j2(this.d.a, this.c).a(l2.d), l2.d, true, true);
                                f3.a(this.d.a).a(f3.T0, currentTimeMillis);
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public z2(Context context) {
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

    public static z2 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (z2.class) {
                    if (b == null) {
                        b = new z2(context);
                    }
                }
            }
            return b;
        }
        return (z2) invokeL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            try {
                i a2 = i.a(this.a, "re_po_rt");
                boolean b2 = a2.b("a1_p_s_p_s");
                boolean b3 = a2.b("a1_p_s_p_s_c_b");
                if (b2 || b3) {
                    o.a().a(new a(this, b2, b3, i));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
