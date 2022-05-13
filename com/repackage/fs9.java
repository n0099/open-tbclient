package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class fs9 implements lp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final /* synthetic */ vs9 b;

    public fs9(vs9 vs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vs9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = vs9Var;
        this.a = 0L;
    }

    @Override // com.repackage.lp9
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            tq9 a = xq9.a(this.b.a);
            br9 br9Var = new br9(null);
            br9Var.a = this.b.b;
            a.g(br9Var, currentTimeMillis, i, 0);
            a.m();
            this.b.j.removeMessages(100101);
            this.b.d = false;
            this.b.d(this.b.a(i));
        }
    }

    @Override // com.repackage.lp9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis();
            vs9 vs9Var = this.b;
            vs9Var.j.sendEmptyMessageDelayed(100101, vs9Var.f * 1000);
        }
    }

    @Override // com.repackage.lp9
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            jo9 jo9Var = (jo9) obj;
            this.b.j.removeMessages(100101);
            this.b.d = false;
            int size = jo9Var.a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            Info info = size > 0 ? (Info) jo9Var.a.get(0) : null;
            tq9 a = xq9.a(this.b.a);
            br9 br9Var = new br9(info);
            br9Var.a = this.b.b;
            a.g(br9Var, currentTimeMillis, 200, size);
            a.m();
            this.b.c(jo9Var);
            xr9 xr9Var = this.b.c;
            if (xr9Var != null && !xr9Var.d()) {
                vs9 vs9Var = this.b;
                if (vs9Var.h) {
                    return;
                }
                Info c = vs9Var.c.c();
                if (c != null) {
                    this.b.e(c);
                    return;
                }
            }
            this.b.d(PBError.NO_FILL);
        }
    }
}
