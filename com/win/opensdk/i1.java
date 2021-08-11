package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
/* loaded from: classes10.dex */
public class i1 implements T0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f76673a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m1 f76674b;

    public i1(m1 m1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76674b = m1Var;
        this.f76673a = 0L;
    }

    @Override // com.win.opensdk.T0
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            Y0 a2 = Z0.a(this.f76674b.f76716a);
            a1 a1Var = new a1(null);
            a1Var.f76566a = this.f76674b.f76717b;
            a2.a(a1Var, System.currentTimeMillis() - this.f76673a, i2, 0).a();
            this.f76674b.f76725j.removeMessages(100101);
            this.f76674b.f76719d = false;
            this.f76674b.a(this.f76674b.a(i2));
        }
    }

    @Override // com.win.opensdk.T0
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f76673a = System.currentTimeMillis();
            m1 m1Var = this.f76674b;
            m1Var.f76725j.sendEmptyMessageDelayed(100101, m1Var.f76721f * 1000);
        }
    }

    @Override // com.win.opensdk.T0
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            K k = (K) obj;
            this.f76674b.f76725j.removeMessages(100101);
            this.f76674b.f76719d = false;
            int size = k.f76426a.size();
            long currentTimeMillis = System.currentTimeMillis() - this.f76673a;
            Info info = size > 0 ? (Info) k.f76426a.get(0) : null;
            Y0 a2 = Z0.a(this.f76674b.f76716a);
            a1 a1Var = new a1(info);
            a1Var.f76566a = this.f76674b.f76717b;
            a2.a(a1Var, currentTimeMillis, 200, size).a();
            this.f76674b.a(k);
            g1 g1Var = this.f76674b.f76718c;
            if (g1Var != null && !g1Var.c()) {
                m1 m1Var = this.f76674b;
                if (m1Var.f76723h) {
                    return;
                }
                Info b2 = m1Var.f76718c.b();
                if (b2 != null) {
                    this.f76674b.a(b2);
                    return;
                }
            }
            this.f76674b.a(PBError.NO_FILL);
        }
    }
}
