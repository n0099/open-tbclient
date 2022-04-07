package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
/* loaded from: classes5.dex */
public class dt9 implements jq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final /* synthetic */ tt9 b;

    public dt9(tt9 tt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tt9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tt9Var;
        this.a = 0L;
    }

    @Override // com.repackage.jq9
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            rr9 a = vr9.a(this.b.a);
            zr9 zr9Var = new zr9(null);
            zr9Var.a = this.b.b;
            a.g(zr9Var, currentTimeMillis, i, 0);
            a.m();
            this.b.j.removeMessages(100101);
            this.b.d = false;
            this.b.d(this.b.a(i));
        }
    }

    @Override // com.repackage.jq9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis();
            tt9 tt9Var = this.b;
            tt9Var.j.sendEmptyMessageDelayed(100101, tt9Var.f * 1000);
        }
    }

    @Override // com.repackage.jq9
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            hp9 hp9Var = (hp9) obj;
            this.b.j.removeMessages(100101);
            this.b.d = false;
            int size = hp9Var.a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            Info info = size > 0 ? (Info) hp9Var.a.get(0) : null;
            rr9 a = vr9.a(this.b.a);
            zr9 zr9Var = new zr9(info);
            zr9Var.a = this.b.b;
            a.g(zr9Var, currentTimeMillis, 200, size);
            a.m();
            this.b.c(hp9Var);
            vs9 vs9Var = this.b.c;
            if (vs9Var != null && !vs9Var.d()) {
                tt9 tt9Var = this.b;
                if (tt9Var.h) {
                    return;
                }
                Info c = tt9Var.c.c();
                if (c != null) {
                    this.b.e(c);
                    return;
                }
            }
            this.b.d(PBError.NO_FILL);
        }
    }
}
