package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fl2;
/* loaded from: classes7.dex */
public class rp2 implements xn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public fl2 a;
    public String b;
    public tp2 c;
    public boolean d;
    public Context e;
    public boolean f;
    public sp2 g;

    /* loaded from: classes7.dex */
    public class a implements fl2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp2 a;

        public a(rp2 rp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp2Var;
        }

        @Override // com.repackage.fl2.a
        public void b(fl2 fl2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fl2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.b(fl2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements fl2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp2 a;

        public b(rp2 rp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp2Var;
        }

        @Override // com.repackage.fl2.b
        public boolean f(fl2 fl2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, fl2Var, i, i2)) == null) ? this.a.g != null && this.a.g.f(fl2Var, i, i2) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements fl2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp2 a;

        public c(rp2 rp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp2Var;
        }

        @Override // com.repackage.fl2.d
        public void e(fl2 fl2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fl2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.e(fl2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements fl2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp2 a;

        public d(rp2 rp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp2Var;
        }

        @Override // com.repackage.fl2.e
        public void a(fl2 fl2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fl2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.a(fl2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements fl2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp2 a;

        public e(rp2 rp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp2Var;
        }

        @Override // com.repackage.fl2.f
        public void d(fl2 fl2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fl2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.d(fl2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements fl2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rp2 a;

        public f(rp2 rp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rp2Var;
        }

        @Override // com.repackage.fl2.c
        public void c(fl2 fl2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, fl2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.c(fl2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755342723, "Lcom/repackage/rp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755342723, "Lcom/repackage/rp2;");
                return;
            }
        }
        h = jh1.a;
    }

    public rp2(Context context, @NonNull tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tp2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = true;
        this.e = context;
        this.c = tp2Var;
        this.b = tp2Var.j;
        h();
        d();
    }

    public void A(tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tp2Var) == null) {
            if (h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            fl2 fl2Var = this.a;
            if (fl2Var != null) {
                fl2Var.h(tp2Var, true);
            }
            this.c = tp2Var;
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            tp2 tp2Var = this.c;
            return (tp2Var == null || TextUtils.isEmpty(tp2Var.y) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c.b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.xn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.xn2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || TextUtils.isEmpty(this.b)) {
            return;
        }
        yn2.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.xn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            tp2 tp2Var = this.c;
            return tp2Var != null ? tp2Var.z : "";
        }
        return (String) invokeV.objValue;
    }

    public tp2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (tp2) invokeV.objValue;
    }

    public fl2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null) {
                zx1.i("video", "create player");
                fl2 C0 = gk2.C0();
                C0.e(this.e, this.c);
                this.a = C0;
                C0.g(new a(this));
                this.a.p(new b(this));
                this.a.m(new c(this));
                this.a.j(new d(this));
                this.a.k(new e(this));
                this.a.r(new f(this));
            }
            return this.a;
        }
        return (fl2) invokeV.objValue;
    }

    @Override // com.repackage.xn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.xn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // com.repackage.xn2
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f = z;
            if (z) {
                if (this.d) {
                    h().resume();
                }
                h().b();
            } else if (this.a != null) {
                this.d = h().isPlaying();
                h().pause();
                h().c();
            }
        }
    }

    public void l() {
        fl2 fl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (fl2Var = this.a) == null) {
            return;
        }
        fl2Var.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            fl2 fl2Var = this.a;
            return fl2Var != null && fl2Var.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            fl2 fl2Var = this.a;
            return fl2Var != null && fl2Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(tp2 tp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, tp2Var) == null) {
            zx1.i("video", "Open Player " + tp2Var.j);
            fl2 fl2Var = this.a;
            if (fl2Var != null) {
                fl2Var.o(tp2Var);
            }
            this.c = tp2Var;
        }
    }

    @Override // com.repackage.xn2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            zx1.i("video", "onBackPressed");
            fl2 fl2Var = this.a;
            return fl2Var != null && fl2Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.xn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            zx1.i("video", MissionEvent.MESSAGE_DESTROY);
            fl2 fl2Var = this.a;
            if (fl2Var != null) {
                fl2Var.stop();
                this.a = null;
            }
            yn2.k(this);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && B()) {
            h().pause();
        }
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            fl2 fl2Var = this.a;
            if (fl2Var != null) {
                return fl2Var.q(str);
            }
            return 1001;
        }
        return invokeL.intValue;
    }

    public void r(String str) {
        fl2 fl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (fl2Var = this.a) == null) {
            return;
        }
        fl2Var.i(str);
    }

    public void s() {
        fl2 fl2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && B() && !n() && this.f && (fl2Var = this.a) != null) {
            fl2Var.resume();
        }
    }

    public void t(int i) {
        fl2 fl2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && B() && (fl2Var = this.a) != null) {
            fl2Var.seekTo(i);
        }
    }

    public void u(boolean z, int i) {
        fl2 fl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (fl2Var = this.a) == null) {
            return;
        }
        fl2Var.l(z, i);
    }

    public void v(sp2 sp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, sp2Var) == null) {
            this.g = sp2Var;
        }
    }

    public void w(boolean z) {
        fl2 fl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (fl2Var = this.a) == null) {
            return;
        }
        fl2Var.d(z);
    }

    public void x(FrameLayout frameLayout) {
        fl2 fl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, frameLayout) == null) || (fl2Var = this.a) == null) {
            return;
        }
        fl2Var.a(frameLayout);
    }

    public void y() {
        fl2 fl2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && B() && (fl2Var = this.a) != null) {
            fl2Var.seekTo(0);
            this.a.pause();
        }
    }

    public void z(tp2 tp2Var) {
        fl2 fl2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, tp2Var) == null) || (fl2Var = this.a) == null) {
            return;
        }
        fl2Var.n(tp2Var);
    }
}
