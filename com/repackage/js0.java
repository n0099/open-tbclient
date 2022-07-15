package com.repackage;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class js0 implements bs0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final op0 a;
    public ViewGroup b;

    public js0(@NonNull op0 op0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {op0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = op0Var;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int M = this.a.M();
            int J = this.a.J();
            return M <= 0 || J <= 0 || M > J;
        }
        return invokeV.booleanValue;
    }

    public final void b(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) || activity == null) {
            return;
        }
        activity.getWindow().addFlags(128);
    }

    @Override // com.repackage.bs0
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = this.a.n();
            this.a.Y0(true);
            Activity activity = this.a.getActivity();
            if (a()) {
                ww0.a(activity, this.a.X0());
            }
            b(activity);
            gx0.b(activity, this.a.v());
        }
    }

    @Override // com.repackage.bs0
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.b == null) {
            return;
        }
        this.b = this.a.n();
        this.a.Y0(false);
        ww0.b(this.a.getActivity());
        gx0.k(this.a.v());
        gx0.j(this.a.n());
        gx0.c(this.a.v(), this.b);
    }
}
