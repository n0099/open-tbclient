package d.a.o0.a.i1.g;

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
import d.a.o0.a.c1.d.j;
import d.a.o0.a.k;
/* loaded from: classes7.dex */
public class a implements d.a.o0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f46101h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j f46102a;

    /* renamed from: b  reason: collision with root package name */
    public String f46103b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.a.i1.g.c f46104c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46105d;

    /* renamed from: e  reason: collision with root package name */
    public Context f46106e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46107f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.a.i1.g.b f46108g;

    /* renamed from: d.a.o0.a.i1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0793a implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46109a;

        public C0793a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46109a = aVar;
        }

        @Override // d.a.o0.a.c1.d.j.a
        public void b(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f46109a.f46108g == null) {
                return;
            }
            this.f46109a.f46108g.b(jVar);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46110a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46110a = aVar;
        }

        @Override // d.a.o0.a.c1.d.j.b
        public boolean f(j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jVar, i2, i3)) == null) ? this.f46110a.f46108g != null && this.f46110a.f46108g.f(jVar, i2, i3) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46111a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46111a = aVar;
        }

        @Override // d.a.o0.a.c1.d.j.d
        public void e(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f46111a.f46108g == null) {
                return;
            }
            this.f46111a.f46108g.e(jVar);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46112a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46112a = aVar;
        }

        @Override // d.a.o0.a.c1.d.j.e
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f46112a.f46108g == null) {
                return;
            }
            this.f46112a.f46108g.a(jVar);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements j.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46113a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46113a = aVar;
        }

        @Override // d.a.o0.a.c1.d.j.f
        public void d(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f46113a.f46108g == null) {
                return;
            }
            this.f46113a.f46108g.d(jVar);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46114a;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46114a = aVar;
        }

        @Override // d.a.o0.a.c1.d.j.c
        public void c(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f46114a.f46108g == null) {
                return;
            }
            this.f46114a.f46108g.c(jVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1363384594, "Ld/a/o0/a/i1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1363384594, "Ld/a/o0/a/i1/g/a;");
                return;
            }
        }
        f46101h = k.f46335a;
    }

    public a(Context context, @NonNull d.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46107f = true;
        this.f46106e = context;
        this.f46104c = cVar;
        this.f46103b = cVar.n;
        h();
        d();
    }

    @Override // d.a.o0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f46104c.f43982g : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f46103b : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f46103b)) {
            return;
        }
        d.a.o0.a.i1.b.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // d.a.o0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.o0.a.i1.g.c cVar = this.f46104c;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    public d.a.o0.a.i1.g.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f46104c : (d.a.o0.a.i1.g.c) invokeV.objValue;
    }

    public j h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f46102a == null) {
                d.a.o0.a.e0.d.g("video", "create player");
                j r0 = d.a.o0.a.c1.a.r0();
                r0.e(this.f46106e, this.f46104c);
                this.f46102a = r0;
                r0.g(new C0793a(this));
                this.f46102a.p(new b(this));
                this.f46102a.m(new c(this));
                this.f46102a.j(new d(this));
                this.f46102a.k(new e(this));
                this.f46102a.q(new f(this));
            }
            return this.f46102a;
        }
        return (j) invokeV.objValue;
    }

    @Override // d.a.o0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : invokeV.objValue;
    }

    @Override // d.a.o0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // d.a.o0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f46107f = z;
            if (z) {
                if (this.f46105d) {
                    h().resume();
                }
                h().b();
            } else if (this.f46102a != null) {
                this.f46105d = h().isPlaying();
                h().pause();
                h().c();
            }
        }
    }

    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (jVar = this.f46102a) == null) {
            return;
        }
        jVar.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            j jVar = this.f46102a;
            return jVar != null && jVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            j jVar = this.f46102a;
            return jVar != null && jVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(d.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            d.a.o0.a.e0.d.g("video", "Open Player " + cVar.n);
            j jVar = this.f46102a;
            if (jVar != null) {
                jVar.o(cVar);
            }
            this.f46104c = cVar;
        }
    }

    @Override // d.a.o0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d.a.o0.a.e0.d.g("video", "onBackPressed");
            j jVar = this.f46102a;
            return jVar != null && jVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.o0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d.a.o0.a.e0.d.g("video", MissionEvent.MESSAGE_DESTROY);
            j jVar = this.f46102a;
            if (jVar != null) {
                jVar.stop();
                this.f46102a = null;
            }
            d.a.o0.a.i1.b.j(this);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && z()) {
            h().pause();
        }
    }

    public void q(String str) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (jVar = this.f46102a) == null) {
            return;
        }
        jVar.i(str);
    }

    public void r() {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && z() && !n() && this.f46107f && (jVar = this.f46102a) != null) {
            jVar.resume();
        }
    }

    public void s(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i2) == null) && z() && (jVar = this.f46102a) != null) {
            jVar.seekTo(i2);
        }
    }

    public void t(boolean z, int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (jVar = this.f46102a) == null) {
            return;
        }
        jVar.l(z, i2);
    }

    public void u(d.a.o0.a.i1.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.f46108g = bVar;
        }
    }

    public void v(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (jVar = this.f46102a) == null) {
            return;
        }
        jVar.d(z);
    }

    public void w(FrameLayout frameLayout) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frameLayout) == null) || (jVar = this.f46102a) == null) {
            return;
        }
        jVar.a(frameLayout);
    }

    public void x(d.a.o0.a.i1.g.c cVar) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) || (jVar = this.f46102a) == null) {
            return;
        }
        jVar.n(cVar);
    }

    public void y(d.a.o0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            if (f46101h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            j jVar = this.f46102a;
            if (jVar != null) {
                jVar.h(cVar, true);
            }
            this.f46104c = cVar;
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            d.a.o0.a.i1.g.c cVar = this.f46104c;
            return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f46103b) || TextUtils.isEmpty(this.f46104c.f43981f)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
