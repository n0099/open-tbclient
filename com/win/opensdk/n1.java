package com.win.opensdk;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes10.dex */
public class n1 implements S0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final /* synthetic */ r1 b;

    public n1(r1 r1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = r1Var;
        this.a = 0L;
    }

    @Override // com.win.opensdk.S0
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis();
            r1 r1Var = this.b;
            r1Var.j.sendEmptyMessageDelayed(100101, r1Var.f * 1000);
        }
    }

    @Override // com.win.opensdk.S0
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            d1 a = e1.a(this.b.a);
            f1 f1Var = new f1(null);
            f1Var.a = this.b.b;
            a.a(f1Var, System.currentTimeMillis() - this.a, i, 0).a();
            this.b.j.removeMessages(100101);
            this.b.d = false;
            this.b.a(this.b.a(i));
        }
    }

    @Override // com.win.opensdk.S0
    public void a(Object obj) {
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            J j = (J) obj;
            Log.e("traceid", j.b());
            this.b.j.removeMessages(100101);
            this.b.d = false;
            int size = j.a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            if (size > 0) {
                info = (Info) j.a.get(0);
            } else {
                info = null;
            }
            d1 a = e1.a(this.b.a);
            f1 f1Var = new f1(info);
            f1Var.a = this.b.b;
            a.a(f1Var, currentTimeMillis, 200, size).a();
            this.b.a(j);
            l1 l1Var = this.b.c;
            if (l1Var != null && !l1Var.c()) {
                r1 r1Var = this.b;
                if (!r1Var.h) {
                    Info b = r1Var.c.b();
                    if (b != null) {
                        this.b.a(b);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.b.a(PBError.NO_FILL);
        }
    }
}
