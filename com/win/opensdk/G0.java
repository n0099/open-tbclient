package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class G0 implements r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f39363a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K0 f39364b;

    public G0(K0 k0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39364b = k0;
        this.f39363a = 0L;
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            w0 a2 = x0.a(this.f39364b.f39393a);
            y0 y0Var = new y0(null);
            y0Var.f39722a = this.f39364b.f39394b;
            a2.a(y0Var, System.currentTimeMillis() - this.f39363a, i2, 0).a();
            this.f39364b.j.removeMessages(100101);
            this.f39364b.f39396d = false;
            this.f39364b.a(this.f39364b.a(i2));
        }
    }

    @Override // com.win.opensdk.r0
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f39363a = System.currentTimeMillis();
            K0 k0 = this.f39364b;
            k0.j.sendEmptyMessageDelayed(100101, k0.f39398f * 1000);
        }
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            w wVar = (w) obj;
            this.f39364b.j.removeMessages(100101);
            this.f39364b.f39396d = false;
            int size = wVar.f39693a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.f39363a;
            Info info = size > 0 ? (Info) wVar.f39693a.get(0) : null;
            w0 a2 = x0.a(this.f39364b.f39393a);
            y0 y0Var = new y0(info);
            y0Var.f39722a = this.f39364b.f39394b;
            a2.a(y0Var, currentTimeMillis, 200, size).a();
            this.f39364b.a(wVar);
            E0 e0 = this.f39364b.f39395c;
            if (e0 != null && !e0.c()) {
                K0 k0 = this.f39364b;
                if (k0.f39400h) {
                    return;
                }
                Info b2 = k0.f39395c.b();
                if (b2 != null) {
                    this.f39364b.a(b2);
                    return;
                }
            }
            this.f39364b.a(PBError.NO_FILL);
        }
    }
}
