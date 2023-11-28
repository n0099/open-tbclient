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
public class db {
    public static /* synthetic */ Interceptable $ic;
    public static volatile db b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public db(Context context) {
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

    public static db a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (db.class) {
                    if (b == null) {
                        b = new db(context);
                    }
                }
            }
            return b;
        }
        return (db) invokeL.objValue;
    }

    public void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            n.a().a(new Runnable(this, i, i2) { // from class: com.kuaishou.weapon.p0.db.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ int b;
                public final /* synthetic */ db c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i), Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = i;
                    this.b = i2;
                }

                /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v25 int)] */
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            h a = h.a(this.c.a, "re_po_rt");
                            if (a.b(df.P, 1) == 1) {
                                long a2 = df.a(this.c.a).a(df.bj);
                                long currentTimeMillis = System.currentTimeMillis();
                                long b2 = a.b(df.R, 1) * 3600000;
                                long b3 = a.b(df.S, 5) * 60000;
                                int b4 = a.b(df.f1203T, 0);
                                if (a2 > 0) {
                                    j = a2;
                                    if (currentTimeMillis - a2 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                        int hours = new Date(currentTimeMillis).getHours();
                                        List<Integer> list = WeaponHI.isList;
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
                                if (j2 >= b2 || ((this.a == 100 && b4 == 1) || this.a == 106 || (this.a != 100 && this.a > 0 && j2 >= b3))) {
                                    cp.a(this.c.a, new cl(this.c.a, this.a, this.b).a(ck.c), ck.c, true, true);
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
