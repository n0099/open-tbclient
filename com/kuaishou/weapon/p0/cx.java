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
public class cx {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cx b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public cx(Context context) {
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

    public static cx a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (cx.class) {
                    if (b == null) {
                        b = new cx(context);
                    }
                }
            }
            return b;
        }
        return (cx) invokeL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            n.a().a(new Runnable(this, i) { // from class: com.kuaishou.weapon.p0.cx.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ cx b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = i;
                }

                /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v23 int)] */
                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            h a = h.a(this.b.a, "re_po_rt");
                            if (a.b(df.y, 0) == 1) {
                                long a2 = df.a(this.b.a).a(df.bh);
                                long currentTimeMillis = System.currentTimeMillis();
                                long b2 = a.b(df.z, 8) * 3600000;
                                int b3 = a.b(df.q, 0);
                                if (a2 > 0 && currentTimeMillis - a2 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                    int hours = new Date(currentTimeMillis).getHours();
                                    List<Integer> list = WeaponHI.isList;
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(hours);
                                    if (list.contains(sb.toString())) {
                                        return;
                                    }
                                }
                                if (currentTimeMillis - a2 >= b2 || this.a == 106 || (this.a == 100 && b3 == 1)) {
                                    cp.a(this.b.a, new ch(this.b.a, this.a).a(ck.i), ck.i, false, true);
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        }
    }
}
