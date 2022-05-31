package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class zo9 implements fm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final /* synthetic */ pp9 b;

    public zo9(pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pp9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = pp9Var;
        this.a = 0L;
    }

    @Override // com.repackage.fm9
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            nn9 a = rn9.a(this.b.a);
            vn9 vn9Var = new vn9(null);
            vn9Var.a = this.b.b;
            a.g(vn9Var, currentTimeMillis, i, 0);
            a.m();
            this.b.j.removeMessages(100101);
            this.b.d = false;
            this.b.d(this.b.a(i));
        }
    }

    @Override // com.repackage.fm9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = System.currentTimeMillis();
            pp9 pp9Var = this.b;
            pp9Var.j.sendEmptyMessageDelayed(100101, pp9Var.f * 1000);
        }
    }

    @Override // com.repackage.fm9
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            dl9 dl9Var = (dl9) obj;
            this.b.j.removeMessages(100101);
            this.b.d = false;
            int size = dl9Var.a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            Info info = size > 0 ? (Info) dl9Var.a.get(0) : null;
            nn9 a = rn9.a(this.b.a);
            vn9 vn9Var = new vn9(info);
            vn9Var.a = this.b.b;
            a.g(vn9Var, currentTimeMillis, 200, size);
            a.m();
            this.b.c(dl9Var);
            ro9 ro9Var = this.b.c;
            if (ro9Var != null && !ro9Var.d()) {
                pp9 pp9Var = this.b;
                if (pp9Var.h) {
                    return;
                }
                Info c = pp9Var.c.c();
                if (c != null) {
                    this.b.e(c);
                    return;
                }
            }
            this.b.d(PBError.NO_FILL);
        }
    }
}
