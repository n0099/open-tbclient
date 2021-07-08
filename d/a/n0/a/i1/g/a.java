package d.a.n0.a.i1.g;

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
import d.a.n0.a.c1.d.j;
import d.a.n0.a.k;
/* loaded from: classes7.dex */
public class a implements d.a.n0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f45597h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j f45598a;

    /* renamed from: b  reason: collision with root package name */
    public String f45599b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.a.i1.g.c f45600c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45601d;

    /* renamed from: e  reason: collision with root package name */
    public Context f45602e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45603f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.a.i1.g.b f45604g;

    /* renamed from: d.a.n0.a.i1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0784a implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45605a;

        public C0784a(a aVar) {
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
            this.f45605a = aVar;
        }

        @Override // d.a.n0.a.c1.d.j.a
        public void b(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f45605a.f45604g == null) {
                return;
            }
            this.f45605a.f45604g.b(jVar);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45606a;

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
            this.f45606a = aVar;
        }

        @Override // d.a.n0.a.c1.d.j.b
        public boolean f(j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jVar, i2, i3)) == null) ? this.f45606a.f45604g != null && this.f45606a.f45604g.f(jVar, i2, i3) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45607a;

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
            this.f45607a = aVar;
        }

        @Override // d.a.n0.a.c1.d.j.d
        public void e(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f45607a.f45604g == null) {
                return;
            }
            this.f45607a.f45604g.e(jVar);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45608a;

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
            this.f45608a = aVar;
        }

        @Override // d.a.n0.a.c1.d.j.e
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f45608a.f45604g == null) {
                return;
            }
            this.f45608a.f45604g.a(jVar);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements j.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45609a;

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
            this.f45609a = aVar;
        }

        @Override // d.a.n0.a.c1.d.j.f
        public void d(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f45609a.f45604g == null) {
                return;
            }
            this.f45609a.f45604g.d(jVar);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45610a;

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
            this.f45610a = aVar;
        }

        @Override // d.a.n0.a.c1.d.j.c
        public void c(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f45610a.f45604g == null) {
                return;
            }
            this.f45610a.f45604g.c(jVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1234301875, "Ld/a/n0/a/i1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1234301875, "Ld/a/n0/a/i1/g/a;");
                return;
            }
        }
        f45597h = k.f45831a;
    }

    public a(Context context, @NonNull d.a.n0.a.i1.g.c cVar) {
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
        this.f45603f = true;
        this.f45602e = context;
        this.f45600c = cVar;
        this.f45599b = cVar.n;
        h();
        d();
    }

    @Override // d.a.n0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45600c.f43478g : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45599b : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f45599b)) {
            return;
        }
        d.a.n0.a.i1.b.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // d.a.n0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.n0.a.i1.g.c cVar = this.f45600c;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    public d.a.n0.a.i1.g.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f45600c : (d.a.n0.a.i1.g.c) invokeV.objValue;
    }

    public j h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f45598a == null) {
                d.a.n0.a.e0.d.g("video", "create player");
                j r0 = d.a.n0.a.c1.a.r0();
                r0.e(this.f45602e, this.f45600c);
                this.f45598a = r0;
                r0.g(new C0784a(this));
                this.f45598a.p(new b(this));
                this.f45598a.m(new c(this));
                this.f45598a.j(new d(this));
                this.f45598a.k(new e(this));
                this.f45598a.q(new f(this));
            }
            return this.f45598a;
        }
        return (j) invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // d.a.n0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f45603f = z;
            if (z) {
                if (this.f45601d) {
                    h().resume();
                }
                h().b();
            } else if (this.f45598a != null) {
                this.f45601d = h().isPlaying();
                h().pause();
                h().c();
            }
        }
    }

    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (jVar = this.f45598a) == null) {
            return;
        }
        jVar.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            j jVar = this.f45598a;
            return jVar != null && jVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            j jVar = this.f45598a;
            return jVar != null && jVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(d.a.n0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            d.a.n0.a.e0.d.g("video", "Open Player " + cVar.n);
            j jVar = this.f45598a;
            if (jVar != null) {
                jVar.o(cVar);
            }
            this.f45600c = cVar;
        }
    }

    @Override // d.a.n0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d.a.n0.a.e0.d.g("video", "onBackPressed");
            j jVar = this.f45598a;
            return jVar != null && jVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d.a.n0.a.e0.d.g("video", MissionEvent.MESSAGE_DESTROY);
            j jVar = this.f45598a;
            if (jVar != null) {
                jVar.stop();
                this.f45598a = null;
            }
            d.a.n0.a.i1.b.j(this);
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
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (jVar = this.f45598a) == null) {
            return;
        }
        jVar.i(str);
    }

    public void r() {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && z() && !n() && this.f45603f && (jVar = this.f45598a) != null) {
            jVar.resume();
        }
    }

    public void s(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i2) == null) && z() && (jVar = this.f45598a) != null) {
            jVar.seekTo(i2);
        }
    }

    public void t(boolean z, int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (jVar = this.f45598a) == null) {
            return;
        }
        jVar.l(z, i2);
    }

    public void u(d.a.n0.a.i1.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.f45604g = bVar;
        }
    }

    public void v(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (jVar = this.f45598a) == null) {
            return;
        }
        jVar.d(z);
    }

    public void w(FrameLayout frameLayout) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frameLayout) == null) || (jVar = this.f45598a) == null) {
            return;
        }
        jVar.a(frameLayout);
    }

    public void x(d.a.n0.a.i1.g.c cVar) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) || (jVar = this.f45598a) == null) {
            return;
        }
        jVar.n(cVar);
    }

    public void y(d.a.n0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            if (f45597h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            j jVar = this.f45598a;
            if (jVar != null) {
                jVar.h(cVar, true);
            }
            this.f45600c = cVar;
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            d.a.n0.a.i1.g.c cVar = this.f45600c;
            return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f45599b) || TextUtils.isEmpty(this.f45600c.f43477f)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
