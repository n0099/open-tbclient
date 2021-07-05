package d.a.q0.a.i1.g;

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
import d.a.q0.a.c1.d.j;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class a implements d.a.q0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f48899h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public j f48900a;

    /* renamed from: b  reason: collision with root package name */
    public String f48901b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.a.i1.g.c f48902c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f48903d;

    /* renamed from: e  reason: collision with root package name */
    public Context f48904e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48905f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.a.i1.g.b f48906g;

    /* renamed from: d.a.q0.a.i1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0835a implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48907a;

        public C0835a(a aVar) {
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
            this.f48907a = aVar;
        }

        @Override // d.a.q0.a.c1.d.j.a
        public void b(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f48907a.f48906g == null) {
                return;
            }
            this.f48907a.f48906g.b(jVar);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48908a;

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
            this.f48908a = aVar;
        }

        @Override // d.a.q0.a.c1.d.j.b
        public boolean f(j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jVar, i2, i3)) == null) ? this.f48908a.f48906g != null && this.f48908a.f48906g.f(jVar, i2, i3) : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48909a;

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
            this.f48909a = aVar;
        }

        @Override // d.a.q0.a.c1.d.j.d
        public void e(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f48909a.f48906g == null) {
                return;
            }
            this.f48909a.f48906g.e(jVar);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48910a;

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
            this.f48910a = aVar;
        }

        @Override // d.a.q0.a.c1.d.j.e
        public void a(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f48910a.f48906g == null) {
                return;
            }
            this.f48910a.f48906g.a(jVar);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements j.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48911a;

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
            this.f48911a = aVar;
        }

        @Override // d.a.q0.a.c1.d.j.f
        public void d(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f48911a.f48906g == null) {
                return;
            }
            this.f48911a.f48906g.d(jVar);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f48912a;

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
            this.f48912a = aVar;
        }

        @Override // d.a.q0.a.c1.d.j.c
        public void c(j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f48912a.f48906g == null) {
                return;
            }
            this.f48912a.f48906g.c(jVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1621550032, "Ld/a/q0/a/i1/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1621550032, "Ld/a/q0/a/i1/g/a;");
                return;
            }
        }
        f48899h = k.f49133a;
    }

    public a(Context context, @NonNull d.a.q0.a.i1.g.c cVar) {
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
        this.f48905f = true;
        this.f48904e = context;
        this.f48902c = cVar;
        this.f48901b = cVar.n;
        h();
        d();
    }

    @Override // d.a.q0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48902c.f46780g : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f48901b : (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || TextUtils.isEmpty(this.f48901b)) {
            return;
        }
        d.a.q0.a.i1.b.a(this);
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? h().getCurrentPosition() : invokeV.intValue;
    }

    @Override // d.a.q0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.q0.a.i1.g.c cVar = this.f48902c;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    public d.a.q0.a.i1.g.c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48902c : (d.a.q0.a.i1.g.c) invokeV.objValue;
    }

    public j h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f48900a == null) {
                d.a.q0.a.e0.d.g("video", "create player");
                j r0 = d.a.q0.a.c1.a.r0();
                r0.e(this.f48904e, this.f48902c);
                this.f48900a = r0;
                r0.g(new C0835a(this));
                this.f48900a.p(new b(this));
                this.f48900a.m(new c(this));
                this.f48900a.j(new d(this));
                this.f48900a.k(new e(this));
                this.f48900a.q(new f(this));
            }
            return this.f48900a;
        }
        return (j) invokeV.objValue;
    }

    @Override // d.a.q0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this : invokeV.objValue;
    }

    @Override // d.a.q0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    @Override // d.a.q0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f48905f = z;
            if (z) {
                if (this.f48903d) {
                    h().resume();
                }
                h().b();
            } else if (this.f48900a != null) {
                this.f48903d = h().isPlaying();
                h().pause();
                h().c();
            }
        }
    }

    public void l() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (jVar = this.f48900a) == null) {
            return;
        }
        jVar.f();
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            j jVar = this.f48900a;
            return jVar != null && jVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            j jVar = this.f48900a;
            return jVar != null && jVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void o(d.a.q0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            d.a.q0.a.e0.d.g("video", "Open Player " + cVar.n);
            j jVar = this.f48900a;
            if (jVar != null) {
                jVar.o(cVar);
            }
            this.f48902c = cVar;
        }
    }

    @Override // d.a.q0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            d.a.q0.a.e0.d.g("video", "onBackPressed");
            j jVar = this.f48900a;
            return jVar != null && jVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d.a.q0.a.e0.d.g("video", MissionEvent.MESSAGE_DESTROY);
            j jVar = this.f48900a;
            if (jVar != null) {
                jVar.stop();
                this.f48900a = null;
            }
            d.a.q0.a.i1.b.j(this);
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
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || (jVar = this.f48900a) == null) {
            return;
        }
        jVar.i(str);
    }

    public void r() {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && z() && !n() && this.f48905f && (jVar = this.f48900a) != null) {
            jVar.resume();
        }
    }

    public void s(int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i2) == null) && z() && (jVar = this.f48900a) != null) {
            jVar.seekTo(i2);
        }
    }

    public void t(boolean z, int i2) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (jVar = this.f48900a) == null) {
            return;
        }
        jVar.l(z, i2);
    }

    public void u(d.a.q0.a.i1.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bVar) == null) {
            this.f48906g = bVar;
        }
    }

    public void v(boolean z) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (jVar = this.f48900a) == null) {
            return;
        }
        jVar.d(z);
    }

    public void w(FrameLayout frameLayout) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frameLayout) == null) || (jVar = this.f48900a) == null) {
            return;
        }
        jVar.a(frameLayout);
    }

    public void x(d.a.q0.a.i1.g.c cVar) {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) || (jVar = this.f48900a) == null) {
            return;
        }
        jVar.n(cVar);
    }

    public void y(d.a.q0.a.i1.g.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            if (f48899h) {
                Log.e("SwanAppVideoPlayer", "update 接口");
            }
            j jVar = this.f48900a;
            if (jVar != null) {
                jVar.h(cVar, true);
            }
            this.f48902c = cVar;
        }
    }

    public final boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            d.a.q0.a.i1.g.c cVar = this.f48902c;
            return (cVar == null || TextUtils.isEmpty(cVar.C) || TextUtils.isEmpty(this.f48901b) || TextUtils.isEmpty(this.f48902c.f46779f)) ? false : true;
        }
        return invokeV.booleanValue;
    }
}
