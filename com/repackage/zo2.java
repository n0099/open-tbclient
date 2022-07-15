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
import com.repackage.nk2;
/* loaded from: classes7.dex */
public class zo2 implements fn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public nk2 a;
    public String b;
    public bp2 c;
    public boolean d;
    public Context e;
    public boolean f;
    public ap2 g;

    /* loaded from: classes7.dex */
    public class a implements nk2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo2 a;

        public a(zo2 zo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo2Var;
        }

        @Override // com.repackage.nk2.a
        public void b(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nk2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.b(nk2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nk2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo2 a;

        public b(zo2 zo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo2Var;
        }

        @Override // com.repackage.nk2.b
        public boolean f(nk2 nk2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, nk2Var, i, i2)) == null) ? this.a.g != null && this.a.g.f(nk2Var, i, i2) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nk2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo2 a;

        public c(zo2 zo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo2Var;
        }

        @Override // com.repackage.nk2.d
        public void e(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nk2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.e(nk2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements nk2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo2 a;

        public d(zo2 zo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo2Var;
        }

        @Override // com.repackage.nk2.e
        public void a(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nk2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.a(nk2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements nk2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo2 a;

        public e(zo2 zo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo2Var;
        }

        @Override // com.repackage.nk2.f
        public void d(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nk2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.d(nk2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements nk2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zo2 a;

        public f(zo2 zo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zo2Var;
        }

        @Override // com.repackage.nk2.c
        public void c(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nk2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.c(nk2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755105356, "Lcom/repackage/zo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755105356, "Lcom/repackage/zo2;");
                return;
            }
        }
        h = rg1.a;
    }

    public zo2(Context context, @NonNull bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bp2Var};
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
        this.c = bp2Var;
        this.b = bp2Var.j;
        h();
        d();
    }

    public void A(bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bp2Var) == null) {
            if (h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            nk2 nk2Var = this.a;
            if (nk2Var != null) {
                nk2Var.h(bp2Var, true);
            }
            this.c = bp2Var;
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            bp2 bp2Var = this.c;
            return (bp2Var == null || TextUtils.isEmpty(bp2Var.y) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c.b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.fn2
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
        gn2.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.fn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            bp2 bp2Var = this.c;
            return bp2Var != null ? bp2Var.z : "";
        }
        return (String) invokeV.objValue;
    }

    public bp2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (bp2) invokeV.objValue;
    }

    public nk2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null) {
                hx1.i("video", "create player");
                nk2 C0 = oj2.C0();
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
        return (nk2) invokeV.objValue;
    }

    @Override // com.repackage.fn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.fn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // com.repackage.fn2
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
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (nk2Var = this.a) == null) {
            return;
        }
        nk2Var.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            nk2 nk2Var = this.a;
            return nk2Var != null && nk2Var.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            nk2 nk2Var = this.a;
            return nk2Var != null && nk2Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(bp2 bp2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bp2Var) == null) {
            hx1.i("video", "Open Player " + bp2Var.j);
            nk2 nk2Var = this.a;
            if (nk2Var != null) {
                nk2Var.o(bp2Var);
            }
            this.c = bp2Var;
        }
    }

    @Override // com.repackage.fn2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            hx1.i("video", "onBackPressed");
            nk2 nk2Var = this.a;
            return nk2Var != null && nk2Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            hx1.i("video", MissionEvent.MESSAGE_DESTROY);
            nk2 nk2Var = this.a;
            if (nk2Var != null) {
                nk2Var.stop();
                this.a = null;
            }
            gn2.k(this);
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
            nk2 nk2Var = this.a;
            if (nk2Var != null) {
                return nk2Var.q(str);
            }
            return 1001;
        }
        return invokeL.intValue;
    }

    public void r(String str) {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (nk2Var = this.a) == null) {
            return;
        }
        nk2Var.i(str);
    }

    public void s() {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && B() && !n() && this.f && (nk2Var = this.a) != null) {
            nk2Var.resume();
        }
    }

    public void t(int i) {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && B() && (nk2Var = this.a) != null) {
            nk2Var.seekTo(i);
        }
    }

    public void u(boolean z, int i) {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (nk2Var = this.a) == null) {
            return;
        }
        nk2Var.l(z, i);
    }

    public void v(ap2 ap2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ap2Var) == null) {
            this.g = ap2Var;
        }
    }

    public void w(boolean z) {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (nk2Var = this.a) == null) {
            return;
        }
        nk2Var.d(z);
    }

    public void x(FrameLayout frameLayout) {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, frameLayout) == null) || (nk2Var = this.a) == null) {
            return;
        }
        nk2Var.a(frameLayout);
    }

    public void y() {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && B() && (nk2Var = this.a) != null) {
            nk2Var.seekTo(0);
            this.a.pause();
        }
    }

    public void z(bp2 bp2Var) {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, bp2Var) == null) || (nk2Var = this.a) == null) {
            return;
        }
        nk2Var.n(bp2Var);
    }
}
