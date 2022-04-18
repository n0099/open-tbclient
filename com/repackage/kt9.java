package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class kt9 implements qq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final /* synthetic */ au9 b;

    public kt9(au9 au9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {au9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = au9Var;
        this.a = 0L;
    }

    @Override // com.repackage.qq9
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            yr9 a = cs9.a(this.b.a);
            gs9 gs9Var = new gs9(null);
            gs9Var.a = this.b.b;
            a.g(gs9Var, currentTimeMillis, i, 0);
            a.m();
            this.b.j.removeMessages(100101);
            this.b.d = false;
            this.b.d(this.b.a(i));
        }
    }

    @Override // com.repackage.qq9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis();
            au9 au9Var = this.b;
            au9Var.j.sendEmptyMessageDelayed(100101, au9Var.f * 1000);
        }
    }

    @Override // com.repackage.qq9
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            op9 op9Var = (op9) obj;
            this.b.j.removeMessages(100101);
            this.b.d = false;
            int size = op9Var.a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            Info info = size > 0 ? (Info) op9Var.a.get(0) : null;
            yr9 a = cs9.a(this.b.a);
            gs9 gs9Var = new gs9(info);
            gs9Var.a = this.b.b;
            a.g(gs9Var, currentTimeMillis, 200, size);
            a.m();
            this.b.c(op9Var);
            ct9 ct9Var = this.b.c;
            if (ct9Var != null && !ct9Var.d()) {
                au9 au9Var = this.b;
                if (au9Var.h) {
                    return;
                }
                Info c = au9Var.c.c();
                if (c != null) {
                    this.b.e(c);
                    return;
                }
            }
            this.b.d(PBError.NO_FILL);
        }
    }
}
