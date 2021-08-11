package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class p1 implements T0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q1 f76757a;

    public p1(q1 q1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76757a = q1Var;
    }

    @Override // com.win.opensdk.T0
    public void a() {
        T0 t0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (t0 = this.f76757a.f76770a.f76778d) == null) {
            return;
        }
        t0.a();
    }

    @Override // com.win.opensdk.T0
    public void a(int i2, String str) {
        T0 t0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (t0 = this.f76757a.f76770a.f76778d) == null) {
            return;
        }
        t0.a(i2, str);
    }

    @Override // com.win.opensdk.T0
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            K a2 = s1.a(((t1) obj).f76797c);
            r1 r1Var = this.f76757a.f76770a;
            T0 t0 = r1Var.f76778d;
            if (t0 != null) {
                if (a2 == null) {
                    t0.a(101, "");
                } else if (TextUtils.isEmpty(r1Var.f76776b) || !this.f76757a.f76770a.f76776b.equalsIgnoreCase(a2.a())) {
                    this.f76757a.f76770a.f76778d.a(2003, "");
                } else {
                    this.f76757a.f76770a.f76778d.a(a2);
                }
            }
        }
    }
}
