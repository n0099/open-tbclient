package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class d1 implements T0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e1 f76627a;

    public d1(e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76627a = e1Var;
    }

    @Override // com.win.opensdk.T0
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.win.opensdk.T0
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            f1 f1Var = this.f76627a.f76638a;
            long currentTimeMillis = System.currentTimeMillis();
            f1 f1Var2 = this.f76627a.f76638a;
            f1Var.f76645c = currentTimeMillis - f1Var2.f76644b;
            Z0.a(f1Var2.f76643a).a(i2, this.f76627a.f76638a.f76645c).a();
        }
    }

    @Override // com.win.opensdk.T0
    public void a(Object obj) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            f1 f1Var = this.f76627a.f76638a;
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.f76627a.f76638a.f76644b;
            f1Var.f76645c = currentTimeMillis - j2;
            this.f76627a.f76638a.a((t1) obj);
        }
    }
}
