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
import com.repackage.nj2;
@Service
/* loaded from: classes7.dex */
public class ui2 implements bo3, fm2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nj2 a;
    public vn3 b;
    public Context c;
    public bo2 d;
    public String e;
    public boolean f;
    public boolean g;

    /* loaded from: classes7.dex */
    public class a implements nj2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui2 a;

        public a(ui2 ui2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui2Var;
        }

        @Override // com.repackage.nj2.a
        public void b(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCompletion();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements nj2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui2 a;

        public b(ui2 ui2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui2Var;
        }

        @Override // com.repackage.nj2.b
        public boolean f(nj2 nj2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, nj2Var, i, i2)) == null) ? this.a.b != null && this.a.b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements nj2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui2 a;

        public c(ui2 ui2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui2Var;
        }

        @Override // com.repackage.nj2.d
        public void e(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onPrepared();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements nj2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui2 a;

        public d(ui2 ui2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui2Var;
        }

        @Override // com.repackage.nj2.e
        public void a(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onResume();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements nj2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui2 a;

        public e(ui2 ui2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui2Var;
        }

        @Override // com.repackage.nj2.f
        public void d(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onStart();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements nj2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ui2 a;

        public f(ui2 ui2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ui2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ui2Var;
        }

        @Override // com.repackage.nj2.c
        public void c(nj2 nj2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nj2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onPause();
        }
    }

    public ui2() {
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

    @Override // com.repackage.bo3
    public void a(FrameLayout frameLayout) {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (nj2Var = this.a) == null) {
            return;
        }
        nj2Var.a(frameLayout);
    }

    @Override // com.repackage.fm2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.repackage.bo3
    public void d(boolean z) {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (nj2Var = this.a) == null) {
            return;
        }
        nj2Var.d(z);
    }

    @Override // com.repackage.bo3
    public /* bridge */ /* synthetic */ bo3 e(Context context, @NonNull xm3 xm3Var) {
        n(context, xm3Var);
        return this;
    }

    @Override // com.repackage.fm2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            bo2 bo2Var = this.d;
            return bo2Var != null ? bo2Var.z : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.bo3
    public void g(vn3 vn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vn3Var) == null) {
            this.b = vn3Var;
        }
    }

    @Override // com.repackage.bo3
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.bo3
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // com.repackage.bo3
    public void h(xm3 xm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, xm3Var) == null) {
            bo2 p = p(xm3Var);
            this.d = p;
            nj2 nj2Var = this.a;
            if (nj2Var != null) {
                nj2Var.o(p);
            }
        }
    }

    @Override // com.repackage.fm2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.bo3
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            nj2 nj2Var = this.a;
            return nj2Var != null && nj2Var.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.bo3
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            nj2 nj2Var = this.a;
            return nj2Var != null && nj2Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fm2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // com.repackage.fm2
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
        gm2.a(this);
    }

    @Override // com.repackage.bo3
    public void mute(boolean z) {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (nj2Var = this.a) == null) {
            return;
        }
        nj2Var.mute(z);
    }

    public ui2 n(Context context, @NonNull xm3 xm3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, xm3Var)) == null) {
            this.c = context;
            bo2 p = p(xm3Var);
            this.d = p;
            this.e = p.j;
            o();
            m();
            return this;
        }
        return (ui2) invokeLL.objValue;
    }

    public nj2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                nj2 C0 = oi2.C0();
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
        return (nj2) invokeV.objValue;
    }

    @Override // com.repackage.fm2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            nj2 nj2Var = this.a;
            return nj2Var != null && nj2Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.fm2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            nj2 nj2Var = this.a;
            if (nj2Var != null) {
                nj2Var.stop();
                this.a = null;
            }
            gm2.k(this);
        }
    }

    public bo2 p(xm3 xm3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, xm3Var)) == null) {
            bo2 bo2Var = new bo2();
            bo2Var.j = "SwanAdPlayer";
            bo2Var.b = "SwanAdPlayer";
            bo2Var.o = xm3Var.f;
            bo2Var.k = xm3Var.b;
            bo2Var.x = xm3Var.o;
            bo2Var.I = xm3Var.z;
            bo2Var.E = xm3Var.v;
            bo2Var.y = xm3Var.p;
            return bo2Var;
        }
        return (bo2) invokeL.objValue;
    }

    @Override // com.repackage.bo3
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
            bo2 bo2Var = this.d;
            return (bo2Var == null || TextUtils.isEmpty(bo2Var.y)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.bo3
    public void resume() {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f && (nj2Var = this.a) != null) {
            nj2Var.resume();
        }
    }

    @Override // com.repackage.bo3
    public void stop() {
        nj2 nj2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (nj2Var = this.a) == null) {
            return;
        }
        nj2Var.stop();
        this.a = null;
    }
}
