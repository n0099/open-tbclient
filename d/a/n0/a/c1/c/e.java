package d.a.n0.a.c1.c;

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
import d.a.n0.a.c1.d.j;
@Service
/* loaded from: classes7.dex */
public class e implements d.a.n0.f.i.m.b.c, d.a.n0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.a.c1.d.j f43555a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.f.i.l.e f43556b;

    /* renamed from: c  reason: collision with root package name */
    public Context f43557c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.a.i1.g.c f43558d;

    /* renamed from: e  reason: collision with root package name */
    public String f43559e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43560f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f43561g;

    /* loaded from: classes7.dex */
    public class a implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f43562a;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43562a = eVar;
        }

        @Override // d.a.n0.a.c1.d.j.a
        public void b(d.a.n0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f43562a.f43556b == null) {
                return;
            }
            this.f43562a.f43556b.onCompletion();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f43563a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43563a = eVar;
        }

        @Override // d.a.n0.a.c1.d.j.b
        public boolean f(d.a.n0.a.c1.d.j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jVar, i2, i3)) == null) ? this.f43563a.f43556b != null && this.f43563a.f43556b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f43564a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43564a = eVar;
        }

        @Override // d.a.n0.a.c1.d.j.d
        public void e(d.a.n0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f43564a.f43556b == null) {
                return;
            }
            this.f43564a.f43556b.onPrepared();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f43565a;

        public d(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43565a = eVar;
        }

        @Override // d.a.n0.a.c1.d.j.e
        public void a(d.a.n0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f43565a.f43556b == null) {
                return;
            }
            this.f43565a.f43556b.onResume();
        }
    }

    /* renamed from: d.a.n0.a.c1.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0645e implements j.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f43566a;

        public C0645e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43566a = eVar;
        }

        @Override // d.a.n0.a.c1.d.j.f
        public void d(d.a.n0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f43566a.f43556b == null) {
                return;
            }
            this.f43566a.f43556b.onStart();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f43567a;

        public f(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43567a = eVar;
        }

        @Override // d.a.n0.a.c1.d.j.c
        public void c(d.a.n0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f43567a.f43556b == null) {
                return;
            }
            this.f43567a.f43556b.onPause();
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43560f = true;
    }

    @Override // d.a.n0.f.i.m.b.c
    public void a(FrameLayout frameLayout) {
        d.a.n0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (jVar = this.f43555a) == null) {
            return;
        }
        jVar.a(frameLayout);
    }

    @Override // d.a.n0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43558d.f43478g : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43559e : (String) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.c
    public void d(boolean z) {
        d.a.n0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (jVar = this.f43555a) == null) {
            return;
        }
        jVar.d(z);
    }

    @Override // d.a.n0.f.i.m.b.c
    public /* bridge */ /* synthetic */ d.a.n0.f.i.m.b.c e(Context context, @NonNull d.a.n0.f.i.j.b bVar) {
        n(context, bVar);
        return this;
    }

    @Override // d.a.n0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.n0.a.i1.g.c cVar = this.f43558d;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.c
    public void g(d.a.n0.f.i.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f43556b = eVar;
        }
    }

    @Override // d.a.n0.f.i.m.b.c
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // d.a.n0.f.i.m.b.c
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // d.a.n0.f.i.m.b.c
    public void h(d.a.n0.f.i.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            d.a.n0.a.i1.g.c p = p(bVar);
            this.f43558d = p;
            d.a.n0.a.c1.d.j jVar = this.f43555a;
            if (jVar != null) {
                jVar.o(p);
            }
        }
    }

    @Override // d.a.n0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // d.a.n0.f.i.m.b.c
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d.a.n0.a.c1.d.j jVar = this.f43555a;
            return jVar != null && jVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.f.i.m.b.c
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d.a.n0.a.c1.d.j jVar = this.f43555a;
            return jVar != null && jVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // d.a.n0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f43560f = z;
            if (this.f43555a == null) {
                return;
            }
            if (z) {
                if (this.f43561g) {
                    o().resume();
                }
                o().b();
                return;
            }
            this.f43561g = o().isPlaying();
            o().pause();
            o().c();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || TextUtils.isEmpty(this.f43559e)) {
            return;
        }
        d.a.n0.a.i1.b.a(this);
    }

    @Override // d.a.n0.f.i.m.b.c
    public void mute(boolean z) {
        d.a.n0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (jVar = this.f43555a) == null) {
            return;
        }
        jVar.mute(z);
    }

    public e n(Context context, @NonNull d.a.n0.f.i.j.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, bVar)) == null) {
            this.f43557c = context;
            d.a.n0.a.i1.g.c p = p(bVar);
            this.f43558d = p;
            this.f43559e = p.n;
            o();
            m();
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public d.a.n0.a.c1.d.j o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f43555a == null) {
                d.a.n0.a.c1.d.j r0 = d.a.n0.a.c1.a.r0();
                r0.e(this.f43557c, this.f43558d);
                this.f43555a = r0;
                r0.g(new a(this));
                this.f43555a.p(new b(this));
                this.f43555a.m(new c(this));
                this.f43555a.j(new d(this));
                this.f43555a.k(new C0645e(this));
                this.f43555a.q(new f(this));
            }
            return this.f43555a;
        }
        return (d.a.n0.a.c1.d.j) invokeV.objValue;
    }

    @Override // d.a.n0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            d.a.n0.a.c1.d.j jVar = this.f43555a;
            return jVar != null && jVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            d.a.n0.a.c1.d.j jVar = this.f43555a;
            if (jVar != null) {
                jVar.stop();
                this.f43555a = null;
            }
            d.a.n0.a.i1.b.j(this);
        }
    }

    public d.a.n0.a.i1.g.c p(d.a.n0.f.i.j.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bVar)) == null) {
            d.a.n0.a.i1.g.c cVar = new d.a.n0.a.i1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f43477f = "SwanAdPlayer";
            cVar.s = bVar.f49328f;
            cVar.o = bVar.f49324b;
            cVar.B = bVar.o;
            cVar.M = bVar.z;
            cVar.I = bVar.v;
            cVar.C = bVar.p;
            return cVar;
        }
        return (d.a.n0.a.i1.g.c) invokeL.objValue;
    }

    @Override // d.a.n0.f.i.m.b.c
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
            d.a.n0.a.i1.g.c cVar = this.f43558d;
            return (cVar == null || TextUtils.isEmpty(cVar.C)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.f.i.m.b.c
    public void resume() {
        d.a.n0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f43560f && (jVar = this.f43555a) != null) {
            jVar.resume();
        }
    }

    @Override // d.a.n0.f.i.m.b.c
    public void stop() {
        d.a.n0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (jVar = this.f43555a) == null) {
            return;
        }
        jVar.stop();
        this.f43555a = null;
    }
}
