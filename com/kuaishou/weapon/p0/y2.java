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
public class y2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y2 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ y2 b;

        public a(y2 y2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y2Var;
            this.a = i;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v23 int)] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    i a = i.a(this.b.a, "re_po_rt");
                    if (a.a(f3.y, 0) == 1) {
                        long a2 = f3.a(this.b.a).a(f3.S0);
                        long currentTimeMillis = System.currentTimeMillis();
                        long a3 = a.a(f3.z, 8) * 3600000;
                        int a4 = a.a(f3.q, 0);
                        if (a2 > 0 && currentTimeMillis - a2 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a2 >= a3 || this.a == 106 || (this.a == 100 && a4 == 1)) {
                            q2.a(this.b.a, new i2(this.b.a, this.a).a(l2.i), l2.i, false, true);
                            f3.a(this.b.a).a(f3.S0, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public y2(Context context) {
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

    public static y2 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (y2.class) {
                    if (b == null) {
                        b = new y2(context);
                    }
                }
            }
            return b;
        }
        return (y2) invokeL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            o.a().a(new a(this, i));
        }
    }
}
