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
import com.repackage.pk2;
@Service
/* loaded from: classes7.dex */
public class wj2 implements dp3, hn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pk2 a;
    public xo3 b;
    public Context c;
    public dp2 d;
    public String e;
    public boolean f;
    public boolean g;

    /* loaded from: classes7.dex */
    public class a implements pk2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj2 a;

        public a(wj2 wj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj2Var;
        }

        @Override // com.repackage.pk2.a
        public void b(pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pk2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCompletion();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements pk2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj2 a;

        public b(wj2 wj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj2Var;
        }

        @Override // com.repackage.pk2.b
        public boolean f(pk2 pk2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, pk2Var, i, i2)) == null) ? this.a.b != null && this.a.b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements pk2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj2 a;

        public c(wj2 wj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj2Var;
        }

        @Override // com.repackage.pk2.d
        public void e(pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pk2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onPrepared();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements pk2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj2 a;

        public d(wj2 wj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj2Var;
        }

        @Override // com.repackage.pk2.e
        public void a(pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pk2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onResume();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements pk2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj2 a;

        public e(wj2 wj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj2Var;
        }

        @Override // com.repackage.pk2.f
        public void d(pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pk2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onStart();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements pk2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj2 a;

        public f(wj2 wj2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj2Var;
        }

        @Override // com.repackage.pk2.c
        public void c(pk2 pk2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, pk2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onPause();
        }
    }

    public wj2() {
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

    @Override // com.repackage.dp3
    public void a(FrameLayout frameLayout) {
        pk2 pk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (pk2Var = this.a) == null) {
            return;
        }
        pk2Var.a(frameLayout);
    }

    @Override // com.repackage.hn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.hn2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.repackage.dp3
    public void d(boolean z) {
        pk2 pk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (pk2Var = this.a) == null) {
            return;
        }
        pk2Var.d(z);
    }

    @Override // com.repackage.dp3
    public /* bridge */ /* synthetic */ dp3 e(Context context, @NonNull zn3 zn3Var) {
        n(context, zn3Var);
        return this;
    }

    @Override // com.repackage.hn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            dp2 dp2Var = this.d;
            return dp2Var != null ? dp2Var.z : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.dp3
    public void g(xo3 xo3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xo3Var) == null) {
            this.b = xo3Var;
        }
    }

    @Override // com.repackage.dp3
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.dp3
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // com.repackage.dp3
    public void h(zn3 zn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, zn3Var) == null) {
            dp2 p = p(zn3Var);
            this.d = p;
            pk2 pk2Var = this.a;
            if (pk2Var != null) {
                pk2Var.o(p);
            }
        }
    }

    @Override // com.repackage.hn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.dp3
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            pk2 pk2Var = this.a;
            return pk2Var != null && pk2Var.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.dp3
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            pk2 pk2Var = this.a;
            return pk2Var != null && pk2Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.hn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // com.repackage.hn2
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
        in2.a(this);
    }

    @Override // com.repackage.dp3
    public void mute(boolean z) {
        pk2 pk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (pk2Var = this.a) == null) {
            return;
        }
        pk2Var.mute(z);
    }

    public wj2 n(Context context, @NonNull zn3 zn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, zn3Var)) == null) {
            this.c = context;
            dp2 p = p(zn3Var);
            this.d = p;
            this.e = p.j;
            o();
            m();
            return this;
        }
        return (wj2) invokeLL.objValue;
    }

    public pk2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                pk2 C0 = qj2.C0();
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
        return (pk2) invokeV.objValue;
    }

    @Override // com.repackage.hn2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            pk2 pk2Var = this.a;
            return pk2Var != null && pk2Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.hn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            pk2 pk2Var = this.a;
            if (pk2Var != null) {
                pk2Var.stop();
                this.a = null;
            }
            in2.k(this);
        }
    }

    public dp2 p(zn3 zn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, zn3Var)) == null) {
            dp2 dp2Var = new dp2();
            dp2Var.j = "SwanAdPlayer";
            dp2Var.b = "SwanAdPlayer";
            dp2Var.o = zn3Var.f;
            dp2Var.k = zn3Var.b;
            dp2Var.x = zn3Var.o;
            dp2Var.I = zn3Var.z;
            dp2Var.E = zn3Var.v;
            dp2Var.y = zn3Var.p;
            return dp2Var;
        }
        return (dp2) invokeL.objValue;
    }

    @Override // com.repackage.dp3
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
            dp2 dp2Var = this.d;
            return (dp2Var == null || TextUtils.isEmpty(dp2Var.y)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.dp3
    public void resume() {
        pk2 pk2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f && (pk2Var = this.a) != null) {
            pk2Var.resume();
        }
    }

    @Override // com.repackage.dp3
    public void stop() {
        pk2 pk2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (pk2Var = this.a) == null) {
            return;
        }
        pk2Var.stop();
        this.a = null;
    }
}
