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
public class cy {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cy b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public cy(Context context) {
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

    public static cy a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (cy.class) {
                    if (b == null) {
                        b = new cy(context);
                    }
                }
            }
            return b;
        }
        return (cy) invokeL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            try {
                h a = h.a(this.a, "re_po_rt");
                boolean e = a.e("a1_p_s_p_s");
                boolean e2 = a.e("a1_p_s_p_s_c_b");
                if ((!e && !e2) || !WeaponHI.as) {
                    return;
                }
                n.a().a(new Runnable(this, e, e2, i) { // from class: com.kuaishou.weapon.p0.cy.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean a;
                    public final /* synthetic */ boolean b;
                    public final /* synthetic */ int c;
                    public final /* synthetic */ cy d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(e), Boolean.valueOf(e2), Integer.valueOf(i)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.d = this;
                        this.a = e;
                        this.b = e2;
                        this.c = i;
                    }

                    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r1v22 int)] */
                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                h a2 = h.a(this.d.a, "re_po_rt");
                                if (a2.b(df.o, 0) == 1) {
                                    if (this.a || this.b) {
                                        long a3 = df.a(this.d.a).a(df.bi);
                                        long currentTimeMillis = System.currentTimeMillis();
                                        long b2 = a2.b(df.p, 8) * 3600000;
                                        int b3 = a2.b(df.q, 0);
                                        if (a3 > 0 && currentTimeMillis - a3 < WeaponHI.ii * 3600000 && WeaponHI.isList != null) {
                                            int hours = new Date(currentTimeMillis).getHours();
                                            List<Integer> list = WeaponHI.isList;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(hours);
                                            if (list.contains(sb.toString())) {
                                                return;
                                            }
                                        }
                                        if (currentTimeMillis - a3 >= b2 || ((this.c == 100 && b3 == 1) || this.c == 106)) {
                                            cp.a(this.d.a, new ci(this.d.a, this.c).a(ck.d), ck.d, true, true);
                                        }
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }
}
