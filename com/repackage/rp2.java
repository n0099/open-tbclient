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
public class rp2 implements hn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bm1 a;
    public String b;
    public tp2 c;
    public boolean d;
    public Context e;

    public rp2(Context context, @NonNull tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tp2Var};
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
        this.c = tp2Var;
        this.b = tp2Var.j;
        e();
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.b)) {
            return;
        }
        in2.a(this);
    }

    @Override // com.repackage.hn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.hn2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public tp2 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.c : (tp2) invokeV.objValue;
    }

    public bm1 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                jx1.i("VrVideo", "create player");
                this.a = qj2.D0().create();
            }
            return this.a;
        }
        return (bm1) invokeV.objValue;
    }

    @Override // com.repackage.hn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            tp2 tp2Var = this.c;
            return tp2Var != null ? tp2Var.t : "";
        }
        return (String) invokeV.objValue;
    }

    public void g(tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tp2Var) == null) {
            jx1.i("VrVideo", "Open Player " + tp2Var.j);
            bm1 bm1Var = this.a;
            if (bm1Var != null) {
                bm1Var.e(tp2Var, this.e);
            }
            this.c = tp2Var;
        }
    }

    public void h(tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tp2Var) == null) {
            jx1.b("VrVideo", "update 接口");
            bm1 bm1Var = this.a;
            if (bm1Var != null) {
                bm1Var.d(tp2Var, true);
            }
            this.c = tp2Var;
        }
    }

    @Override // com.repackage.hn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.hn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // com.repackage.hn2
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

    @Override // com.repackage.hn2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            jx1.i("VrVideo", "onBackPressed");
            bm1 bm1Var = this.a;
            return bm1Var != null && bm1Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.hn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            jx1.i("VrVideo", MissionEvent.MESSAGE_DESTROY);
            bm1 bm1Var = this.a;
            if (bm1Var != null) {
                bm1Var.stop();
                this.a = null;
            }
            in2.k(this);
        }
    }
}
