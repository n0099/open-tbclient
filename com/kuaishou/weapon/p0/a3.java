package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.List;
/* loaded from: classes10.dex */
public class a3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a3 a;

        public a(a3 a3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a3Var;
        }

        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v6 int)] */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    i a = i.a(this.a.a, "re_po_rt");
                    if (a.a(f3.G, 1) == 1) {
                        long a2 = f3.a(this.a.a).a(f3.X0);
                        long currentTimeMillis = System.currentTimeMillis();
                        long a3 = a.a(f3.I, 12) * 3600000;
                        if (a2 > 0 && currentTimeMillis - a2 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                            int hours = new Date(currentTimeMillis).getHours();
                            List<Integer> list = WeaponHI.isList;
                            StringBuilder sb = new StringBuilder();
                            sb.append(hours);
                            if (list.contains(sb.toString())) {
                                return;
                            }
                        }
                        if (currentTimeMillis - a2 >= a3) {
                            q2.a(this.a.a, new k2(this.a.a).a(l2.g), l2.g, true, true);
                            f3.a(this.a.a).a(f3.X0, currentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public a3(Context context) {
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

    public static a3 a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (a3.class) {
                    if (b == null) {
                        b = new a3(context);
                    }
                }
            }
            return b;
        }
        return (a3) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o.a().a(new a(this));
        }
    }
}
