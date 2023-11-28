package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.searchbox.download.center.clearcache.util.ClearCacheUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class dc {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dc b;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public dc(Context context) {
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

    public static dc a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b == null) {
                synchronized (dc.class) {
                    if (b == null) {
                        b = new dc(context);
                    }
                }
            }
            return b;
        }
        return (dc) invokeL.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            n.a().a(new Runnable(this, i) { // from class: com.kuaishou.weapon.p0.dc.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ dc b;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            h a = h.a(this.b.a, "re_po_rt");
                            if (a.b(df.ap, 1) == 1) {
                                long a2 = df.a(this.b.a).a(df.bl);
                                long currentTimeMillis = System.currentTimeMillis();
                                int b2 = a.b(df.as, 0);
                                long j = currentTimeMillis - a2;
                                if (j >= a.b(df.ar, 6) * 3600000 || (this.a == 100 && b2 == 1 && j >= ClearCacheUtils.DO_CLEAR_PERIOD)) {
                                    cg.a(this.b.a, new bw(this.b.a, this.a, false).a(ck.e), ck.e, true);
                                    df.a(this.b.a).a(df.bl, currentTimeMillis);
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
