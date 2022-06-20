package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class gp9 implements mm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final /* synthetic */ wp9 b;

    public gp9(wp9 wp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wp9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = wp9Var;
        this.a = 0L;
    }

    @Override // com.repackage.mm9
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            un9 a = yn9.a(this.b.a);
            co9 co9Var = new co9(null);
            co9Var.a = this.b.b;
            a.g(co9Var, currentTimeMillis, i, 0);
            a.m();
            this.b.j.removeMessages(100101);
            this.b.d = false;
            this.b.d(this.b.a(i));
        }
    }

    @Override // com.repackage.mm9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis();
            wp9 wp9Var = this.b;
            wp9Var.j.sendEmptyMessageDelayed(100101, wp9Var.f * 1000);
        }
    }

    @Override // com.repackage.mm9
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            kl9 kl9Var = (kl9) obj;
            this.b.j.removeMessages(100101);
            this.b.d = false;
            int size = kl9Var.a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            Info info = size > 0 ? (Info) kl9Var.a.get(0) : null;
            un9 a = yn9.a(this.b.a);
            co9 co9Var = new co9(info);
            co9Var.a = this.b.b;
            a.g(co9Var, currentTimeMillis, 200, size);
            a.m();
            this.b.c(kl9Var);
            yo9 yo9Var = this.b.c;
            if (yo9Var != null && !yo9Var.d()) {
                wp9 wp9Var = this.b;
                if (wp9Var.h) {
                    return;
                }
                Info c = wp9Var.c.c();
                if (c != null) {
                    this.b.e(c);
                    return;
                }
            }
            this.b.d(PBError.NO_FILL);
        }
    }
}
