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
import com.repackage.al2;
@Service
/* loaded from: classes6.dex */
public class hk2 implements op3, sn2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public al2 a;
    public ip3 b;
    public Context c;
    public op2 d;
    public String e;
    public boolean f;
    public boolean g;

    /* loaded from: classes6.dex */
    public class a implements al2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk2 a;

        public a(hk2 hk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk2Var;
        }

        @Override // com.repackage.al2.a
        public void b(al2 al2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, al2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCompletion();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements al2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk2 a;

        public b(hk2 hk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk2Var;
        }

        @Override // com.repackage.al2.b
        public boolean f(al2 al2Var, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, al2Var, i, i2)) == null) ? this.a.b != null && this.a.b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements al2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk2 a;

        public c(hk2 hk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk2Var;
        }

        @Override // com.repackage.al2.d
        public void e(al2 al2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, al2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onPrepared();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements al2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk2 a;

        public d(hk2 hk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk2Var;
        }

        @Override // com.repackage.al2.e
        public void a(al2 al2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, al2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onResume();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements al2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk2 a;

        public e(hk2 hk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk2Var;
        }

        @Override // com.repackage.al2.f
        public void d(al2 al2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, al2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onStart();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements al2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk2 a;

        public f(hk2 hk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk2Var;
        }

        @Override // com.repackage.al2.c
        public void c(al2 al2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, al2Var) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onPause();
        }
    }

    public hk2() {
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

    @Override // com.repackage.op3
    public void a(FrameLayout frameLayout) {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (al2Var = this.a) == null) {
            return;
        }
        al2Var.a(frameLayout);
    }

    @Override // com.repackage.sn2
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d.c : (String) invokeV.objValue;
    }

    @Override // com.repackage.sn2
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.repackage.op3
    public void d(boolean z) {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (al2Var = this.a) == null) {
            return;
        }
        al2Var.d(z);
    }

    @Override // com.repackage.op3
    public /* bridge */ /* synthetic */ op3 e(Context context, @NonNull ko3 ko3Var) {
        n(context, ko3Var);
        return this;
    }

    @Override // com.repackage.sn2
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            op2 op2Var = this.d;
            return op2Var != null ? op2Var.z : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.op3
    public void g(ip3 ip3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ip3Var) == null) {
            this.b = ip3Var;
        }
    }

    @Override // com.repackage.op3
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.op3
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // com.repackage.op3
    public void h(ko3 ko3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ko3Var) == null) {
            op2 p = p(ko3Var);
            this.d = p;
            al2 al2Var = this.a;
            if (al2Var != null) {
                al2Var.o(p);
            }
        }
    }

    @Override // com.repackage.sn2
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // com.repackage.op3
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            al2 al2Var = this.a;
            return al2Var != null && al2Var.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.op3
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            al2 al2Var = this.a;
            return al2Var != null && al2Var.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.sn2
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // com.repackage.sn2
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
        tn2.a(this);
    }

    @Override // com.repackage.op3
    public void mute(boolean z) {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (al2Var = this.a) == null) {
            return;
        }
        al2Var.mute(z);
    }

    public hk2 n(Context context, @NonNull ko3 ko3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, ko3Var)) == null) {
            this.c = context;
            op2 p = p(ko3Var);
            this.d = p;
            this.e = p.j;
            o();
            m();
            return this;
        }
        return (hk2) invokeLL.objValue;
    }

    public al2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a == null) {
                al2 C0 = bk2.C0();
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
        return (al2) invokeV.objValue;
    }

    @Override // com.repackage.sn2
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            al2 al2Var = this.a;
            return al2Var != null && al2Var.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.sn2
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            al2 al2Var = this.a;
            if (al2Var != null) {
                al2Var.stop();
                this.a = null;
            }
            tn2.k(this);
        }
    }

    public op2 p(ko3 ko3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, ko3Var)) == null) {
            op2 op2Var = new op2();
            op2Var.j = "SwanAdPlayer";
            op2Var.b = "SwanAdPlayer";
            op2Var.o = ko3Var.f;
            op2Var.k = ko3Var.b;
            op2Var.x = ko3Var.o;
            op2Var.I = ko3Var.z;
            op2Var.E = ko3Var.v;
            op2Var.y = ko3Var.p;
            return op2Var;
        }
        return (op2) invokeL.objValue;
    }

    @Override // com.repackage.op3
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
            op2 op2Var = this.d;
            return (op2Var == null || TextUtils.isEmpty(op2Var.y)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.op3
    public void resume() {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f && (al2Var = this.a) != null) {
            al2Var.resume();
        }
    }

    @Override // com.repackage.op3
    public void stop() {
        al2 al2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (al2Var = this.a) == null) {
            return;
        }
        al2Var.stop();
        this.a = null;
    }
}
