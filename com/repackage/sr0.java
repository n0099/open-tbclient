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
/* loaded from: classes7.dex */
public class sr0 implements kr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xo0 a;
    public ViewGroup b;

    public sr0(@NonNull xo0 xo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xo0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xo0Var;
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

    @Override // com.repackage.kr0
    public void switchToFullStyle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = this.a.n();
            this.a.Y0(true);
            Activity activity = this.a.getActivity();
            if (a()) {
                fw0.a(activity, this.a.X0());
            }
            b(activity);
            pw0.b(activity, this.a.v());
        }
    }

    @Override // com.repackage.kr0
    public void switchToNormalStyle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.b == null) {
            return;
        }
        this.b = this.a.n();
        this.a.Y0(false);
        fw0.b(this.a.getActivity());
        pw0.k(this.a.v());
        pw0.j(this.a.n());
        pw0.c(this.a.v(), this.b);
    }
}
