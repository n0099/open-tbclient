package com.kuaishou.weapon.un;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        public a(t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d dVar = new d(this.a.a);
                    if (dVar.a(d.t0, 1) == 1) {
                        long i = dVar.i();
                        long currentTimeMillis = System.currentTimeMillis();
                        long a = dVar.a(d.v0, 6) * 3600000;
                        String str = " sdk lastReportTime : " + y1.a(i);
                        long j = currentTimeMillis - i;
                        if (j >= a) {
                            this.a.b();
                            if (TextUtils.isEmpty(dVar.e(d.R0))) {
                                String h2 = l1.h();
                                if (!TextUtils.isEmpty(h2)) {
                                    dVar.g(h2);
                                }
                            }
                            dVar.f(currentTimeMillis);
                            context = this.a.a;
                        } else {
                            context = this.a.a;
                            a -= j;
                        }
                        j1.c(context, Long.valueOf(a));
                    }
                } catch (Throwable th) {
                    l1.a(th);
                }
            }
        }
    }

    public t0(Context context) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                t1.a().a(new p0(this.a));
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                t1.a().a(new a(this));
            } catch (Throwable th) {
                l1.a(th);
            }
        }
    }
}
