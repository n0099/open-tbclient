package com.kwad.components.ad.reward.h;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class a implements com.kwad.components.core.g.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public AdTemplate b;
    public DetailVideoView c;
    public b d;
    public KsVideoPlayConfig e;
    public VideoPlayerStatus f;
    public h g;
    public Context h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public List<InterfaceC0483a> m;
    public l n;
    public final List<h.a> o;
    public h.a p;

    /* renamed from: com.kwad.components.ad.reward.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0483a {
        boolean handledOnResume();
    }

    public a(l lVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = new CopyOnWriteArrayList();
        this.o = new ArrayList();
        this.p = new h.a(this) { // from class: com.kwad.components.ad.reward.h.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.k = true;
                    if (this.a.d != null) {
                        this.a.d.a(false);
                    }
                    synchronized (this.a.o) {
                        for (h.a aVar : this.a.o) {
                            aVar.a();
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    synchronized (this.a.o) {
                        for (h.a aVar : this.a.o) {
                            aVar.b();
                        }
                    }
                }
            }
        };
        this.n = lVar;
        this.h = lVar.M;
        AdTemplate adTemplate = lVar.g;
        this.b = adTemplate;
        this.e = lVar.d;
        this.f = adTemplate.mVideoPlayerStatus;
        this.j = z;
        this.a = l();
        this.c = lVar.i;
        this.d = new b(this.c);
        m();
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.reward.h.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(1048576, this, i3, i4) == null) {
                    super.a(i3, i4);
                    com.kwad.components.core.i.a.a().b(this.a.b, i3, i4);
                }
            }
        };
        this.g = hVar;
        this.d.a(hVar);
        this.d.a(new c.e(this) { // from class: com.kwad.components.ad.reward.h.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar) == null) {
                    this.a.d.d();
                }
            }
        });
        com.kwad.components.core.l.b.a(this.h).a(this.p);
    }

    private String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            String b = com.kwad.sdk.core.response.a.a.b(d.i(this.b));
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(b);
            return (b2 == null || !b2.exists()) ? com.kwad.sdk.core.config.d.J() > 0 ? com.kwad.sdk.core.videocache.b.a.a(this.h).a(b) : b : b2.getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.d.a(new b.a(this.b).a(this.a).b(f.b(d.j(this.b))).a(this.f).a(com.kwad.sdk.contentalliance.kwai.kwai.a.a(this.b)).a(), this.c);
            KsVideoPlayConfig ksVideoPlayConfig = this.e;
            if (ksVideoPlayConfig != null) {
                a(ksVideoPlayConfig.isVideoSoundEnable(), false);
            }
            this.d.c();
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            c();
            this.l = true;
        }
    }

    public final void a(InterfaceC0483a interfaceC0483a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0483a) == null) {
            this.m.add(interfaceC0483a);
        }
    }

    @MainThread
    public final void a(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null) {
            return;
        }
        this.d.a(gVar);
    }

    public final void a(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.o.add(aVar);
        }
    }

    public final void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.i = z;
            if (!z) {
                this.d.a(0.0f, 0.0f);
                return;
            }
            this.d.a(1.0f, 1.0f);
            if (z2) {
                com.kwad.components.core.l.b.a(this.h).a(true);
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l = false;
            if (l.d(this.n)) {
                return;
            }
            this.d.e();
        }
    }

    public final void b(InterfaceC0483a interfaceC0483a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0483a) == null) {
            this.m.remove(interfaceC0483a);
        }
    }

    @MainThread
    public final void b(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) || gVar == null) {
            return;
        }
        this.d.b(gVar);
    }

    public final void b(h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.o.remove(aVar);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || l.d(this.n)) {
            return;
        }
        this.d.f();
    }

    @Deprecated
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.a(9);
            n();
        }
    }

    @MainThread
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            com.kwad.components.core.video.b bVar = this.d;
            if (bVar != null) {
                bVar.k();
                this.d.g();
            }
            com.kwad.components.core.l.b.a(this.h).b(this.p);
        }
    }

    @WorkerThread
    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.kwad.components.core.video.b bVar = this.d;
            if (bVar != null) {
                bVar.k();
                this.d.h();
            }
            com.kwad.components.core.l.b.a(this.h).b(this.p);
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k = false;
            if (this.d.a() == null) {
                m();
            }
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void h() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            loop0: while (true) {
                for (InterfaceC0483a interfaceC0483a : this.m) {
                    z = z || interfaceC0483a.handledOnResume();
                }
            }
            if (!z && !this.l) {
                b();
            }
            if (this.i || (com.kwad.components.ad.reward.kwai.b.e() && this.k)) {
                com.kwad.components.core.l.b.a(this.h).a(com.kwad.components.ad.reward.kwai.b.e());
                if (com.kwad.components.ad.reward.kwai.b.e() && this.k) {
                    this.k = false;
                    this.i = true;
                    a(true, false);
                } else if (!this.j && com.kwad.components.core.l.b.a(this.h).a()) {
                    this.i = false;
                    a(false, false);
                }
            }
        }
    }

    public final long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            com.kwad.components.core.video.b bVar = this.d;
            if (bVar != null) {
                return bVar.i();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c();
        }
    }

    @Override // com.kwad.components.core.g.kwai.a
    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.k = false;
            com.kwad.components.core.video.b bVar = this.d;
            if (bVar != null) {
                bVar.b(this.g);
                this.d.g();
            }
        }
    }
}
