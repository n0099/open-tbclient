package com.kuaishou.weapon.un;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d0 a;

        public a(d0 d0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    d dVar = new d(this.a.a);
                    if (dVar.a(d.p0, 1) == 1) {
                        long a = dVar.a();
                        long currentTimeMillis = System.currentTimeMillis();
                        long a2 = dVar.a(d.r0, 6) * 3600000;
                        long j = currentTimeMillis - a;
                        if (j >= a2) {
                            this.a.b();
                            dVar.a(currentTimeMillis);
                            context = this.a.a;
                        } else {
                            context = this.a.a;
                            a2 -= j;
                        }
                        j1.b(context, Long.valueOf(a2));
                    }
                } catch (Throwable th) {
                    l1.a(th);
                }
            }
        }
    }

    public d0(Context context) {
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
                t1.a().a(new f0(this.a));
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
