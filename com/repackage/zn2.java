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
import com.repackage.nj2;
/* loaded from: classes7.dex */
public class zn2 implements fm2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public nj2 a;
    public String b;
    public bo2 c;
    public boolean d;
    public Context e;
    public boolean f;
    public ao2 g;

    /* loaded from: classes7.dex */
    public class a implements nj2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn2 a;

        public a(zn2 zn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn2Var;
        }

        @Override // com.repackage.nj2.a
        public void b(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.b(nj2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nj2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn2 a;

        public b(zn2 zn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn2Var;
        }

        @Override // com.repackage.nj2.b
        public boolean f(nj2 nj2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, nj2Var, i, i2)) == null) ? this.a.g != null && this.a.g.f(nj2Var, i, i2) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nj2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn2 a;

        public c(zn2 zn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn2Var;
        }

        @Override // com.repackage.nj2.d
        public void e(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.e(nj2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements nj2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn2 a;

        public d(zn2 zn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn2Var;
        }

        @Override // com.repackage.nj2.e
        public void a(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.a(nj2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements nj2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn2 a;

        public e(zn2 zn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn2Var;
        }

        @Override // com.repackage.nj2.f
        public void d(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.d(nj2Var);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements nj2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zn2 a;

        public f(zn2 zn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zn2Var;
        }

        @Override // com.repackage.nj2.c
        public void c(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.c(nj2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755106317, "Lcom/repackage/zn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755106317, "Lcom/repackage/zn2;");
                return;
            }
        }
        h = rf1.a;
    }

    public zn2(Context context, @NonNull bo2 bo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bo2Var};
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
        this.c = bo2Var;
        this.b = bo2Var.j;
        h();
        d();
    }

    public void A(bo2 bo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bo2Var) == null) {
            if (h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            nj2 nj2Var = this.a;
            if (nj2Var != null) {
                nj2Var.h(bo2Var, true);
            }
            this.c = bo2Var;
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            bo2 bo2Var = this.c;
            return (bo2Var == null || TextUtils.isEmpty(bo2Var.y) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c.b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fm2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.fm2
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
        gm2.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.fm2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            bo2 bo2Var = this.c;
            return bo2Var != null ? bo2Var.z : "";
        }
        return (String) invokeV.objValue;
    }

    public bo2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (bo2) invokeV.objValue;
    }

    public nj2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null) {
                hw1.i("video", "create player");
                nj2 C0 = oi2.C0();
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
        return (nj2) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // com.repackage.fm2
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
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (nj2Var = this.a) == null) {
            return;
        }
        nj2Var.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            nj2 nj2Var = this.a;
            return nj2Var != null && nj2Var.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            nj2 nj2Var = this.a;
            return nj2Var != null && nj2Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(bo2 bo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bo2Var) == null) {
            hw1.i("video", "Open Player " + bo2Var.j);
            nj2 nj2Var = this.a;
            if (nj2Var != null) {
                nj2Var.o(bo2Var);
            }
            this.c = bo2Var;
        }
    }

    @Override // com.repackage.fm2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            hw1.i("video", "onBackPressed");
            nj2 nj2Var = this.a;
            return nj2Var != null && nj2Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fm2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            hw1.i("video", MissionEvent.MESSAGE_DESTROY);
            nj2 nj2Var = this.a;
            if (nj2Var != null) {
                nj2Var.stop();
                this.a = null;
            }
            gm2.k(this);
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
            nj2 nj2Var = this.a;
            if (nj2Var != null) {
                return nj2Var.q(str);
            }
            return 1001;
        }
        return invokeL.intValue;
    }

    public void r(String str) {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (nj2Var = this.a) == null) {
            return;
        }
        nj2Var.i(str);
    }

    public void s() {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && B() && !n() && this.f && (nj2Var = this.a) != null) {
            nj2Var.resume();
        }
    }

    public void t(int i) {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && B() && (nj2Var = this.a) != null) {
            nj2Var.seekTo(i);
        }
    }

    public void u(boolean z, int i) {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (nj2Var = this.a) == null) {
            return;
        }
        nj2Var.l(z, i);
    }

    public void v(ao2 ao2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ao2Var) == null) {
            this.g = ao2Var;
        }
    }

    public void w(boolean z) {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (nj2Var = this.a) == null) {
            return;
        }
        nj2Var.d(z);
    }

    public void x(FrameLayout frameLayout) {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, frameLayout) == null) || (nj2Var = this.a) == null) {
            return;
        }
        nj2Var.a(frameLayout);
    }

    public void y() {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && B() && (nj2Var = this.a) != null) {
            nj2Var.seekTo(0);
            this.a.pause();
        }
    }

    public void z(bo2 bo2Var) {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, bo2Var) == null) || (nj2Var = this.a) == null) {
            return;
        }
        nj2Var.n(bo2Var);
    }
}
