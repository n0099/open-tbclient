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
import com.repackage.al2;
/* loaded from: classes6.dex */
public class mp2 implements sn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public al2 a;
    public String b;
    public op2 c;
    public boolean d;
    public Context e;
    public boolean f;
    public np2 g;

    /* loaded from: classes6.dex */
    public class a implements al2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp2 a;

        public a(mp2 mp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp2Var;
        }

        @Override // com.repackage.al2.a
        public void b(al2 al2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, al2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.b(al2Var);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements al2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp2 a;

        public b(mp2 mp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp2Var;
        }

        @Override // com.repackage.al2.b
        public boolean f(al2 al2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, al2Var, i, i2)) == null) ? this.a.g != null && this.a.g.f(al2Var, i, i2) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements al2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp2 a;

        public c(mp2 mp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp2Var;
        }

        @Override // com.repackage.al2.d
        public void e(al2 al2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, al2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.e(al2Var);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements al2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp2 a;

        public d(mp2 mp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp2Var;
        }

        @Override // com.repackage.al2.e
        public void a(al2 al2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, al2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.a(al2Var);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements al2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp2 a;

        public e(mp2 mp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp2Var;
        }

        @Override // com.repackage.al2.f
        public void d(al2 al2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, al2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.d(al2Var);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements al2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mp2 a;

        public f(mp2 mp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mp2Var;
        }

        @Override // com.repackage.al2.c
        public void c(al2 al2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, al2Var) == null) || this.a.g == null) {
                return;
            }
            this.a.g.c(al2Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755491678, "Lcom/repackage/mp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755491678, "Lcom/repackage/mp2;");
                return;
            }
        }
        h = eh1.a;
    }

    public mp2(Context context, @NonNull op2 op2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, op2Var};
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
        this.c = op2Var;
        this.b = op2Var.j;
        h();
        d();
    }

    public void A(op2 op2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, op2Var) == null) {
            if (h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            al2 al2Var = this.a;
            if (al2Var != null) {
                al2Var.h(op2Var, true);
            }
            this.c = op2Var;
        }
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            op2 op2Var = this.c;
            return (op2Var == null || TextUtils.isEmpty(op2Var.y) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c.b)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.sn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.sn2
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
        tn2.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.sn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            op2 op2Var = this.c;
            return op2Var != null ? op2Var.z : "";
        }
        return (String) invokeV.objValue;
    }

    public op2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (op2) invokeV.objValue;
    }

    public al2 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.a == null) {
                ux1.i("video", "create player");
                al2 C0 = bk2.C0();
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
        return (al2) invokeV.objValue;
    }

    @Override // com.repackage.sn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.sn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    @Override // com.repackage.sn2
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
        al2 al2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (al2Var = this.a) == null) {
            return;
        }
        al2Var.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            al2 al2Var = this.a;
            return al2Var != null && al2Var.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            al2 al2Var = this.a;
            return al2Var != null && al2Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(op2 op2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, op2Var) == null) {
            ux1.i("video", "Open Player " + op2Var.j);
            al2 al2Var = this.a;
            if (al2Var != null) {
                al2Var.o(op2Var);
            }
            this.c = op2Var;
        }
    }

    @Override // com.repackage.sn2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ux1.i("video", "onBackPressed");
            al2 al2Var = this.a;
            return al2Var != null && al2Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.sn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ux1.i("video", MissionEvent.MESSAGE_DESTROY);
            al2 al2Var = this.a;
            if (al2Var != null) {
                al2Var.stop();
                this.a = null;
            }
            tn2.k(this);
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
            al2 al2Var = this.a;
            if (al2Var != null) {
                return al2Var.q(str);
            }
            return 1001;
        }
        return invokeL.intValue;
    }

    public void r(String str) {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (al2Var = this.a) == null) {
            return;
        }
        al2Var.i(str);
    }

    public void s() {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && B() && !n() && this.f && (al2Var = this.a) != null) {
            al2Var.resume();
        }
    }

    public void t(int i) {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && B() && (al2Var = this.a) != null) {
            al2Var.seekTo(i);
        }
    }

    public void u(boolean z, int i) {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (al2Var = this.a) == null) {
            return;
        }
        al2Var.l(z, i);
    }

    public void v(np2 np2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, np2Var) == null) {
            this.g = np2Var;
        }
    }

    public void w(boolean z) {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (al2Var = this.a) == null) {
            return;
        }
        al2Var.d(z);
    }

    public void x(FrameLayout frameLayout) {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, frameLayout) == null) || (al2Var = this.a) == null) {
            return;
        }
        al2Var.a(frameLayout);
    }

    public void y() {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && B() && (al2Var = this.a) != null) {
            al2Var.seekTo(0);
            this.a.pause();
        }
    }

    public void z(op2 op2Var) {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, op2Var) == null) || (al2Var = this.a) == null) {
            return;
        }
        al2Var.n(op2Var);
    }
}
