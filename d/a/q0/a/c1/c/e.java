package d.a.q0.a.c1.c;

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
import d.a.q0.a.c1.d.j;
@Service
/* loaded from: classes8.dex */
public class e implements d.a.q0.f.i.m.b.c, d.a.q0.a.i1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.c1.d.j f46857a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q0.f.i.l.e f46858b;

    /* renamed from: c  reason: collision with root package name */
    public Context f46859c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a.i1.g.c f46860d;

    /* renamed from: e  reason: collision with root package name */
    public String f46861e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f46862f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46863g;

    /* loaded from: classes8.dex */
    public class a implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f46864a;

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
            this.f46864a = eVar;
        }

        @Override // d.a.q0.a.c1.d.j.a
        public void b(d.a.q0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f46864a.f46858b == null) {
                return;
            }
            this.f46864a.f46858b.onCompletion();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements j.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f46865a;

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
            this.f46865a = eVar;
        }

        @Override // d.a.q0.a.c1.d.j.b
        public boolean f(d.a.q0.a.c1.d.j jVar, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, jVar, i2, i3)) == null) ? this.f46865a.f46858b != null && this.f46865a.f46858b.onError() : invokeLII.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f46866a;

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
            this.f46866a = eVar;
        }

        @Override // d.a.q0.a.c1.d.j.d
        public void e(d.a.q0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f46866a.f46858b == null) {
                return;
            }
            this.f46866a.f46858b.onPrepared();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f46867a;

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
            this.f46867a = eVar;
        }

        @Override // d.a.q0.a.c1.d.j.e
        public void a(d.a.q0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f46867a.f46858b == null) {
                return;
            }
            this.f46867a.f46858b.onResume();
        }
    }

    /* renamed from: d.a.q0.a.c1.c.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0696e implements j.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f46868a;

        public C0696e(e eVar) {
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
            this.f46868a = eVar;
        }

        @Override // d.a.q0.a.c1.d.j.f
        public void d(d.a.q0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f46868a.f46858b == null) {
                return;
            }
            this.f46868a.f46858b.onStart();
        }
    }

    /* loaded from: classes8.dex */
    public class f implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f46869a;

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
            this.f46869a = eVar;
        }

        @Override // d.a.q0.a.c1.d.j.c
        public void c(d.a.q0.a.c1.d.j jVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) || this.f46869a.f46858b == null) {
                return;
            }
            this.f46869a.f46858b.onPause();
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
        this.f46862f = true;
    }

    @Override // d.a.q0.f.i.m.b.c
    public void a(FrameLayout frameLayout) {
        d.a.q0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) || (jVar = this.f46857a) == null) {
            return;
        }
        jVar.a(frameLayout);
    }

    @Override // d.a.q0.a.i1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f46860d.f46780g : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.i1.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46861e : (String) invokeV.objValue;
    }

    @Override // d.a.q0.f.i.m.b.c
    public void d(boolean z) {
        d.a.q0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (jVar = this.f46857a) == null) {
            return;
        }
        jVar.d(z);
    }

    @Override // d.a.q0.f.i.m.b.c
    public /* bridge */ /* synthetic */ d.a.q0.f.i.m.b.c e(Context context, @NonNull d.a.q0.f.i.j.b bVar) {
        n(context, bVar);
        return this;
    }

    @Override // d.a.q0.a.i1.a
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.q0.a.i1.g.c cVar = this.f46860d;
            return cVar != null ? cVar.D : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.f.i.m.b.c
    public void g(d.a.q0.f.i.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.f46858b = eVar;
        }
    }

    @Override // d.a.q0.f.i.m.b.c
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? o().getCurrentPosition() : invokeV.intValue;
    }

    @Override // d.a.q0.f.i.m.b.c
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? o().getDuration() : invokeV.intValue;
    }

    @Override // d.a.q0.f.i.m.b.c
    public void h(d.a.q0.f.i.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            d.a.q0.a.i1.g.c p = p(bVar);
            this.f46860d = p;
            d.a.q0.a.c1.d.j jVar = this.f46857a;
            if (jVar != null) {
                jVar.o(p);
            }
        }
    }

    @Override // d.a.q0.a.i1.a
    public Object i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this : invokeV.objValue;
    }

    @Override // d.a.q0.f.i.m.b.c
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            d.a.q0.a.c1.d.j jVar = this.f46857a;
            return jVar != null && jVar.isEnd();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.f.i.m.b.c
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            d.a.q0.a.c1.d.j jVar = this.f46857a;
            return jVar != null && jVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.i1.a
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    @Override // d.a.q0.a.i1.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f46862f = z;
            if (this.f46857a == null) {
                return;
            }
            if (z) {
                if (this.f46863g) {
                    o().resume();
                }
                o().b();
                return;
            }
            this.f46863g = o().isPlaying();
            o().pause();
            o().c();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || TextUtils.isEmpty(this.f46861e)) {
            return;
        }
        d.a.q0.a.i1.b.a(this);
    }

    @Override // d.a.q0.f.i.m.b.c
    public void mute(boolean z) {
        d.a.q0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || (jVar = this.f46857a) == null) {
            return;
        }
        jVar.mute(z);
    }

    public e n(Context context, @NonNull d.a.q0.f.i.j.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, bVar)) == null) {
            this.f46859c = context;
            d.a.q0.a.i1.g.c p = p(bVar);
            this.f46860d = p;
            this.f46861e = p.n;
            o();
            m();
            return this;
        }
        return (e) invokeLL.objValue;
    }

    public d.a.q0.a.c1.d.j o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f46857a == null) {
                d.a.q0.a.c1.d.j r0 = d.a.q0.a.c1.a.r0();
                r0.e(this.f46859c, this.f46860d);
                this.f46857a = r0;
                r0.g(new a(this));
                this.f46857a.p(new b(this));
                this.f46857a.m(new c(this));
                this.f46857a.j(new d(this));
                this.f46857a.k(new C0696e(this));
                this.f46857a.q(new f(this));
            }
            return this.f46857a;
        }
        return (d.a.q0.a.c1.d.j) invokeV.objValue;
    }

    @Override // d.a.q0.a.i1.a
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            d.a.q0.a.c1.d.j jVar = this.f46857a;
            return jVar != null && jVar.onBackPressed();
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.i1.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            d.a.q0.a.c1.d.j jVar = this.f46857a;
            if (jVar != null) {
                jVar.stop();
                this.f46857a = null;
            }
            d.a.q0.a.i1.b.j(this);
        }
    }

    public d.a.q0.a.i1.g.c p(d.a.q0.f.i.j.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, bVar)) == null) {
            d.a.q0.a.i1.g.c cVar = new d.a.q0.a.i1.g.c();
            cVar.n = "SwanAdPlayer";
            cVar.f46779f = "SwanAdPlayer";
            cVar.s = bVar.f52630f;
            cVar.o = bVar.f52626b;
            cVar.B = bVar.o;
            cVar.M = bVar.z;
            cVar.I = bVar.v;
            cVar.C = bVar.p;
            return cVar;
        }
        return (d.a.q0.a.i1.g.c) invokeL.objValue;
    }

    @Override // d.a.q0.f.i.m.b.c
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
            d.a.q0.a.i1.g.c cVar = this.f46860d;
            return (cVar == null || TextUtils.isEmpty(cVar.C)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.f.i.m.b.c
    public void resume() {
        d.a.q0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && q() && !isPlaying() && this.f46862f && (jVar = this.f46857a) != null) {
            jVar.resume();
        }
    }

    @Override // d.a.q0.f.i.m.b.c
    public void stop() {
        d.a.q0.a.c1.d.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (jVar = this.f46857a) == null) {
            return;
        }
        jVar.stop();
        this.f46857a = null;
    }
}
