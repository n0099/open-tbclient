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
/* loaded from: classes6.dex */
public class pp2 implements fn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zl1 a;
    public String b;
    public rp2 c;
    public boolean d;
    public Context e;

    public pp2(Context context, @NonNull rp2 rp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, rp2Var};
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
        this.c = rp2Var;
        this.b = rp2Var.j;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.b)) {
            return;
        }
        gn2.a(this);
    }

    @Override // com.repackage.fn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.fn2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public rp2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (rp2) invokeV.objValue;
    }

    public zl1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                hx1.i("VrVideo", "create player");
                this.a = oj2.D0().create();
            }
            return this.a;
        }
        return (zl1) invokeV.objValue;
    }

    @Override // com.repackage.fn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            rp2 rp2Var = this.c;
            return rp2Var != null ? rp2Var.t : "";
        }
        return (String) invokeV.objValue;
    }

    public void g(rp2 rp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rp2Var) == null) {
            hx1.i("VrVideo", "Open Player " + rp2Var.j);
            zl1 zl1Var = this.a;
            if (zl1Var != null) {
                zl1Var.e(rp2Var, this.e);
            }
            this.c = rp2Var;
        }
    }

    public void h(rp2 rp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rp2Var) == null) {
            hx1.b("VrVideo", "update 接口");
            zl1 zl1Var = this.a;
            if (zl1Var != null) {
                zl1Var.d(rp2Var, true);
            }
            this.c = rp2Var;
        }
    }

    @Override // com.repackage.fn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.fn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.repackage.fn2
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

    @Override // com.repackage.fn2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            hx1.i("VrVideo", "onBackPressed");
            zl1 zl1Var = this.a;
            return zl1Var != null && zl1Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            hx1.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
            zl1 zl1Var = this.a;
            if (zl1Var != null) {
                zl1Var.stop();
                this.a = null;
            }
            gn2.k(this);
        }
    }
}
