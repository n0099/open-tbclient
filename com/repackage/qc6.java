package com.repackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.x16;
/* loaded from: classes6.dex */
public class qc6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public NavigationBar b;
    public lb6 c;
    public Context d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public y16 j;
    public final Handler.Callback k;
    public final Handler l;
    public x16.b m;

    /* loaded from: classes6.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc6 a;

        public a(qc6 qc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc6Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if ((i == 1 || i == 2) && this.a.g()) {
                    this.a.l.sendEmptyMessageDelayed(message.what, 100L);
                    return true;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    this.a.s();
                    return true;
                } else if (i2 == 2) {
                    this.a.r();
                    return true;
                } else if (i2 != 3) {
                    return false;
                } else {
                    this.a.q();
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements x16.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc6 a;

        public b(qc6 qc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc6Var;
        }

        @Override // com.repackage.x16.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (e(i2)) {
                    this.a.k(true);
                    this.a.f();
                }
                if (this.a.c != null) {
                    this.a.c.q1(false);
                }
            }
        }

        @Override // com.repackage.x16.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                if (e(i2)) {
                    this.a.k(false);
                    this.a.m();
                }
                if (this.a.c != null) {
                    this.a.c.q1(true);
                }
            }
        }

        @Override // com.repackage.x16.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.repackage.x16.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public final boolean e(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) ? Math.abs(f) >= 1.0f : invokeF.booleanValue;
        }
    }

    public qc6(Context context, lb6 lb6Var, jo6 jo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, lb6Var, jo6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.f = 0;
        this.h = true;
        this.i = true;
        this.k = new a(this);
        this.l = new Handler(this.k);
        this.m = new b(this);
        this.d = context;
        this.c = lb6Var;
        this.b = lb6Var.g0();
        this.a = lb6Var.i0();
        this.g = UtilHelper.canUseStyleImmersiveSticky();
        c();
        y16 y16Var = new y16(context);
        this.j = y16Var;
        y16Var.d(this.m);
    }

    public final void c() {
        lb6 lb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (lb6Var = this.c) == null || lb6Var.p0() == null) {
            return;
        }
        View p0 = this.c.p0();
        if (this.g && p0.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = p0.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            p0.setLayoutParams(layoutParams);
            l(true);
            return;
        }
        l(false);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l.removeCallbacksAndMessages(null);
        }
    }

    public y16 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (y16) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.h && this.i && this.a != null && this.e >= this.f) {
            n();
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h(this.a) : invokeV.booleanValue;
    }

    public final boolean h(View view2) {
        InterceptResult invokeL;
        Animation animation;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) ? (view2 == null || (animation = view2.getAnimation()) == null || !animation.hasStarted() || animation.hasEnded()) ? false : true : invokeL.booleanValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.h = z;
        }
    }

    public final void j(boolean z, boolean z2) {
        lb6 lb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (lb6Var = this.c) == null) {
            return;
        }
        lb6Var.m1(z, z2);
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public final void l(boolean z) {
        lb6 lb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (lb6Var = this.c) == null || lb6Var.p0() == null) {
            return;
        }
        View p0 = this.c.p0();
        if (this.g && z && p0.getVisibility() != 0) {
            p0.setVisibility(0);
        } else if (z || p0.getVisibility() == 8) {
        } else {
            p0.setVisibility(8);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.h && this.i && this.a != null) {
            o();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.removeMessages(1);
            if (this.l.hasMessages(2)) {
                return;
            }
            this.l.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.l.removeMessages(2);
            if (this.l.hasMessages(1)) {
                return;
            }
            this.l.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void p(boolean z, boolean z2) {
        lb6 lb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.a == null || (lb6Var = this.c) == null || lb6Var.m0() == null || !this.c.m0().c()) {
            return;
        }
        j(false, true);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            p(false, true);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p(false, false);
        }
    }

    public void s() {
        lb6 lb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.a == null || (lb6Var = this.c) == null || lb6Var.m0() == null || this.c.m0().c()) {
            return;
        }
        j(true, true);
    }
}
