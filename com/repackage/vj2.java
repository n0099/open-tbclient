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
import com.repackage.ok2;
@Service
/* loaded from: classes7.dex */
public class vj2 implements cp3, gn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ok2 a;
    public wo3 b;
    public Context c;
    public cp2 d;
    public String e;
    public boolean f;
    public boolean g;

    /* loaded from: classes7.dex */
    public class a implements ok2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj2 a;

        public a(vj2 vj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj2Var;
        }

        @Override // com.repackage.ok2.a
        public void b(ok2 ok2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ok2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCompletion();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ok2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj2 a;

        public b(vj2 vj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj2Var;
        }

        @Override // com.repackage.ok2.b
        public boolean f(ok2 ok2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, ok2Var, i, i2)) == null) ? this.a.b != null && this.a.b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ok2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj2 a;

        public c(vj2 vj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj2Var;
        }

        @Override // com.repackage.ok2.d
        public void e(ok2 ok2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ok2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onPrepared();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements ok2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj2 a;

        public d(vj2 vj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj2Var;
        }

        @Override // com.repackage.ok2.e
        public void a(ok2 ok2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ok2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onResume();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements ok2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj2 a;

        public e(vj2 vj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj2Var;
        }

        @Override // com.repackage.ok2.f
        public void d(ok2 ok2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ok2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onStart();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ok2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vj2 a;

        public f(vj2 vj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vj2Var;
        }

        @Override // com.repackage.ok2.c
        public void c(ok2 ok2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ok2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onPause();
        }
    }

    public vj2() {
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

    @Override // com.repackage.cp3
    public void a(FrameLayout frameLayout) {
        ok2 ok2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (ok2Var = this.a) == null) {
            return;
        }
        ok2Var.a(frameLayout);
    }

    @Override // com.repackage.gn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.gn2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.repackage.cp3
    public void d(boolean z) {
        ok2 ok2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (ok2Var = this.a) == null) {
            return;
        }
        ok2Var.d(z);
    }

    @Override // com.repackage.cp3
    public /* bridge */ /* synthetic */ cp3 e(Context context, @NonNull yn3 yn3Var) {
        n(context, yn3Var);
        return this;
    }

    @Override // com.repackage.gn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            cp2 cp2Var = this.d;
            return cp2Var != null ? cp2Var.z : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.cp3
    public void g(wo3 wo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wo3Var) == null) {
            this.b = wo3Var;
        }
    }

    @Override // com.repackage.cp3
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.cp3
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // com.repackage.cp3
    public void h(yn3 yn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yn3Var) == null) {
            cp2 p = p(yn3Var);
            this.d = p;
            ok2 ok2Var = this.a;
            if (ok2Var != null) {
                ok2Var.o(p);
            }
        }
    }

    @Override // com.repackage.gn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.cp3
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ok2 ok2Var = this.a;
            return ok2Var != null && ok2Var.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.cp3
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ok2 ok2Var = this.a;
            return ok2Var != null && ok2Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.gn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // com.repackage.gn2
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
        hn2.a(this);
    }

    @Override // com.repackage.cp3
    public void mute(boolean z) {
        ok2 ok2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (ok2Var = this.a) == null) {
            return;
        }
        ok2Var.mute(z);
    }

    public vj2 n(Context context, @NonNull yn3 yn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, yn3Var)) == null) {
            this.c = context;
            cp2 p = p(yn3Var);
            this.d = p;
            this.e = p.j;
            o();
            m();
            return this;
        }
        return (vj2) invokeLL.objValue;
    }

    public ok2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                ok2 C0 = pj2.C0();
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
        return (ok2) invokeV.objValue;
    }

    @Override // com.repackage.gn2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ok2 ok2Var = this.a;
            return ok2Var != null && ok2Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.gn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ok2 ok2Var = this.a;
            if (ok2Var != null) {
                ok2Var.stop();
                this.a = null;
            }
            hn2.k(this);
        }
    }

    public cp2 p(yn3 yn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, yn3Var)) == null) {
            cp2 cp2Var = new cp2();
            cp2Var.j = "SwanAdPlayer";
            cp2Var.b = "SwanAdPlayer";
            cp2Var.o = yn3Var.f;
            cp2Var.k = yn3Var.b;
            cp2Var.x = yn3Var.o;
            cp2Var.I = yn3Var.z;
            cp2Var.E = yn3Var.v;
            cp2Var.y = yn3Var.p;
            return cp2Var;
        }
        return (cp2) invokeL.objValue;
    }

    @Override // com.repackage.cp3
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
            cp2 cp2Var = this.d;
            return (cp2Var == null || TextUtils.isEmpty(cp2Var.y)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.cp3
    public void resume() {
        ok2 ok2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f && (ok2Var = this.a) != null) {
            ok2Var.resume();
        }
    }

    @Override // com.repackage.cp3
    public void stop() {
        ok2 ok2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (ok2Var = this.a) == null) {
            return;
        }
        ok2Var.stop();
        this.a = null;
    }
}
