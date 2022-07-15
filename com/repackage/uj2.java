package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nk2;
@Service
/* loaded from: classes7.dex */
public class uj2 implements bp3, fn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nk2 a;
    public vo3 b;
    public Context c;
    public bp2 d;
    public String e;
    public boolean f;
    public boolean g;

    /* loaded from: classes7.dex */
    public class a implements nk2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uj2 a;

        public a(uj2 uj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uj2Var;
        }

        @Override // com.repackage.nk2.a
        public void b(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nk2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCompletion();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nk2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uj2 a;

        public b(uj2 uj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uj2Var;
        }

        @Override // com.repackage.nk2.b
        public boolean f(nk2 nk2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, nk2Var, i, i2)) == null) ? this.a.b != null && this.a.b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nk2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uj2 a;

        public c(uj2 uj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uj2Var;
        }

        @Override // com.repackage.nk2.d
        public void e(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nk2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onPrepared();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements nk2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uj2 a;

        public d(uj2 uj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uj2Var;
        }

        @Override // com.repackage.nk2.e
        public void a(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nk2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onResume();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements nk2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uj2 a;

        public e(uj2 uj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uj2Var;
        }

        @Override // com.repackage.nk2.f
        public void d(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nk2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onStart();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements nk2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uj2 a;

        public f(uj2 uj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uj2Var;
        }

        @Override // com.repackage.nk2.c
        public void c(nk2 nk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nk2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onPause();
        }
    }

    public uj2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = true;
    }

    @Override // com.repackage.bp3
    public void a(FrameLayout frameLayout) {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (nk2Var = this.a) == null) {
            return;
        }
        nk2Var.a(frameLayout);
    }

    @Override // com.repackage.fn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.fn2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.repackage.bp3
    public void d(boolean z) {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (nk2Var = this.a) == null) {
            return;
        }
        nk2Var.d(z);
    }

    @Override // com.repackage.bp3
    public /* bridge */ /* synthetic */ bp3 e(Context context, @NonNull xn3 xn3Var) {
        n(context, xn3Var);
        return this;
    }

    @Override // com.repackage.fn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            bp2 bp2Var = this.d;
            return bp2Var != null ? bp2Var.z : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.bp3
    public void g(vo3 vo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vo3Var) == null) {
            this.b = vo3Var;
        }
    }

    @Override // com.repackage.bp3
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.bp3
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // com.repackage.bp3
    public void h(xn3 xn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, xn3Var) == null) {
            bp2 p = p(xn3Var);
            this.d = p;
            nk2 nk2Var = this.a;
            if (nk2Var != null) {
                nk2Var.o(p);
            }
        }
    }

    @Override // com.repackage.fn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.bp3
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            nk2 nk2Var = this.a;
            return nk2Var != null && nk2Var.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.bp3
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            nk2 nk2Var = this.a;
            return nk2Var != null && nk2Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // com.repackage.fn2
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f = z;
            if (this.a == null) {
                return;
            }
            if (z) {
                if (this.g) {
                    o().resume();
                }
                o().b();
                return;
            }
            this.g = o().isPlaying();
            o().pause();
            o().c();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || TextUtils.isEmpty(this.e)) {
            return;
        }
        gn2.a(this);
    }

    @Override // com.repackage.bp3
    public void mute(boolean z) {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (nk2Var = this.a) == null) {
            return;
        }
        nk2Var.mute(z);
    }

    public uj2 n(Context context, @NonNull xn3 xn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, xn3Var)) == null) {
            this.c = context;
            bp2 p = p(xn3Var);
            this.d = p;
            this.e = p.j;
            o();
            m();
            return this;
        }
        return (uj2) invokeLL.objValue;
    }

    public nk2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                nk2 C0 = oj2.C0();
                C0.e(this.c, this.d);
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
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            nk2 nk2Var = this.a;
            return nk2Var != null && nk2Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            nk2 nk2Var = this.a;
            if (nk2Var != null) {
                nk2Var.stop();
                this.a = null;
            }
            gn2.k(this);
        }
    }

    public bp2 p(xn3 xn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, xn3Var)) == null) {
            bp2 bp2Var = new bp2();
            bp2Var.j = "SwanAdPlayer";
            bp2Var.b = "SwanAdPlayer";
            bp2Var.o = xn3Var.f;
            bp2Var.k = xn3Var.b;
            bp2Var.x = xn3Var.o;
            bp2Var.I = xn3Var.z;
            bp2Var.E = xn3Var.v;
            bp2Var.y = xn3Var.p;
            return bp2Var;
        }
        return (bp2) invokeL.objValue;
    }

    @Override // com.repackage.bp3
    public void pause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && q()) {
            o().pause();
        }
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            bp2 bp2Var = this.d;
            return (bp2Var == null || TextUtils.isEmpty(bp2Var.y)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.bp3
    public void resume() {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f && (nk2Var = this.a) != null) {
            nk2Var.resume();
        }
    }

    @Override // com.repackage.bp3
    public void stop() {
        nk2 nk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (nk2Var = this.a) == null) {
            return;
        }
        nk2Var.stop();
        this.a = null;
    }
}
