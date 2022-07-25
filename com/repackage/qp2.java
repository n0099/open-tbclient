package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qp2 implements gn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public am1 a;
    public String b;
    public sp2 c;
    public boolean d;
    public Context e;

    public qp2(Context context, @NonNull sp2 sp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sp2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = context;
        this.c = sp2Var;
        this.b = sp2Var.j;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.b)) {
            return;
        }
        hn2.a(this);
    }

    @Override // com.repackage.gn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.gn2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public sp2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (sp2) invokeV.objValue;
    }

    public am1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                ix1.i("VrVideo", "create player");
                this.a = pj2.D0().create();
            }
            return this.a;
        }
        return (am1) invokeV.objValue;
    }

    @Override // com.repackage.gn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            sp2 sp2Var = this.c;
            return sp2Var != null ? sp2Var.t : "";
        }
        return (String) invokeV.objValue;
    }

    public void g(sp2 sp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sp2Var) == null) {
            ix1.i("VrVideo", "Open Player " + sp2Var.j);
            am1 am1Var = this.a;
            if (am1Var != null) {
                am1Var.e(sp2Var, this.e);
            }
            this.c = sp2Var;
        }
    }

    public void h(sp2 sp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sp2Var) == null) {
            ix1.b("VrVideo", "update 接口");
            am1 am1Var = this.a;
            if (am1Var != null) {
                am1Var.d(sp2Var, true);
            }
            this.c = sp2Var;
        }
    }

    @Override // com.repackage.gn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.gn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.repackage.gn2
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                if (this.d) {
                    e().resume();
                }
                e().b();
            } else if (this.a != null) {
                this.d = e().isPlaying();
                e().pause();
                e().c();
            }
        }
    }

    @Override // com.repackage.gn2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ix1.i("VrVideo", "onBackPressed");
            am1 am1Var = this.a;
            return am1Var != null && am1Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.gn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ix1.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
            am1 am1Var = this.a;
            if (am1Var != null) {
                am1Var.stop();
                this.a = null;
            }
            hn2.k(this);
        }
    }
}
