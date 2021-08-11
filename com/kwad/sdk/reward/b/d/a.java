package com.kwad.sdk.reward.b.d;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.b.c;
import com.kwad.sdk.core.webview.b.d;
import com.kwad.sdk.core.webview.b.g;
import com.kwad.sdk.core.webview.b.h;
import com.kwad.sdk.core.webview.b.k;
import com.kwad.sdk.core.webview.b.l;
import com.kwad.sdk.core.webview.b.m;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.c;
import com.kwad.sdk.core.webview.jshandler.f;
import com.kwad.sdk.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.m;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.q;
import com.kwad.sdk.plugin.h;
import com.kwad.sdk.reward.e;
import com.kwad.sdk.utils.ab;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes10.dex */
public abstract class a extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f73129b;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void a(h hVar, ViewGroup viewGroup) {
        com.kwad.sdk.core.webview.b.a.b bVar;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, hVar, viewGroup) == null) {
            com.kwad.sdk.core.download.b.b bVar2 = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.reward.d) this).f73210a.f72873f);
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f73210a;
            aVar.f72043b = aVar2.f72873f;
            aVar.f72042a = !ab.e(aVar2.f72874g) ? 1 : 0;
            aVar.f72044c = ((com.kwad.sdk.reward.d) this).f73210a.f72875h;
            aVar.f72046e = viewGroup;
            aVar.f72047f = null;
            hVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            hVar.a(new g());
            hVar.a(new com.kwad.sdk.core.webview.jshandler.a(aVar, bVar2, new a.b(this) { // from class: com.kwad.sdk.reward.b.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73130a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73130a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(@Nullable a.C1996a c1996a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1996a) == null) {
                    }
                }
            }));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.e(aVar));
            hVar.a(new f(aVar));
            com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(aVar);
            cVar.a(new c.b(this) { // from class: com.kwad.sdk.reward.b.d.a.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73150a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73150a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.c.b
                public void a(c.a aVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar3) == null) {
                        this.f73150a.a(aVar3);
                    }
                }
            });
            hVar.a(cVar);
            hVar.a(new i(aVar, new i.b(this) { // from class: com.kwad.sdk.reward.b.d.a.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73151a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73151a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.i.b
                public void a(i.a aVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar3) == null) {
                    }
                }
            }));
            hVar.a(new m(new m.b(this) { // from class: com.kwad.sdk.reward.b.d.a.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73131a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73131a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.m.b
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    }
                }
            }));
            hVar.a(new p());
            hVar.a(new q(aVar, bVar2));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.h(new h.a(this) { // from class: com.kwad.sdk.reward.b.d.a.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73132a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73132a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f73132a).f73210a.f72875h.findViewById(this.f73132a.f()).setVisibility(8);
                    }
                }
            }));
            hVar.a(new j(aVar));
            hVar.a(new com.kwad.sdk.core.webview.b.f());
            k kVar = new k();
            hVar.a(kVar);
            ((com.kwad.sdk.reward.d) this).f73210a.f72876i.a(new com.kwad.sdk.contentalliance.detail.video.d(this, new com.kwad.sdk.core.webview.b.a.f(), kVar, aVar) { // from class: com.kwad.sdk.reward.b.d.a.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.webview.b.a.f f73133a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ k f73134b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.webview.a f73135c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ a f73136d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7, kVar, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73136d = this;
                    this.f73133a = r7;
                    this.f73134b = kVar;
                    this.f73135c = aVar;
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f73133a;
                        fVar.f72074b = false;
                        fVar.f72075c = false;
                        fVar.f72073a = 0;
                        this.f73134b.a(fVar);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f73133a;
                        fVar.f72074b = true;
                        fVar.f72075c = false;
                        this.f73134b.a(fVar);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(long j2, long j3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                        this.f73136d.f73129b = j3;
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f73133a;
                        fVar.f72074b = false;
                        fVar.f72075c = false;
                        fVar.f72073a = (int) Math.ceil(((float) j3) / 1000.0f);
                        this.f73134b.a(this.f73133a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f73133a;
                        fVar.f72074b = false;
                        fVar.f72075c = false;
                        this.f73134b.a(fVar);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f73133a;
                        fVar.f72074b = false;
                        fVar.f72075c = false;
                        this.f73134b.a(fVar);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void e() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f73133a;
                        fVar.f72074b = false;
                        fVar.f72075c = true;
                        long l = com.kwad.sdk.core.response.b.a.l(com.kwad.sdk.core.response.b.c.i(this.f73135c.f72043b));
                        this.f73133a.f72073a = (int) Math.ceil(((float) l) / 1000.0f);
                        this.f73134b.a(this.f73133a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void g() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void h() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                    }
                }
            });
            l lVar = new l();
            lVar.a(new l.a(this) { // from class: com.kwad.sdk.reward.b.d.a.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73137a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73137a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.l.a
                public void a(com.kwad.sdk.core.webview.b.a.e eVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, eVar) == null) {
                        if (eVar.f72070a) {
                            this.f73137a.p();
                        } else {
                            ((com.kwad.sdk.reward.d) this.f73137a).f73210a.f72876i.h();
                        }
                    }
                }
            });
            hVar.a(lVar);
            com.kwad.sdk.core.webview.b.m mVar = new com.kwad.sdk.core.webview.b.m();
            mVar.a(new m.a(this) { // from class: com.kwad.sdk.reward.b.d.a.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73138a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73138a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.m.a
                public void a(com.kwad.sdk.core.webview.b.a.b bVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar3) == null) {
                        ((com.kwad.sdk.reward.d) this.f73138a).f73210a.f72876i.a(!bVar3.f72067a, true);
                    }
                }
            });
            hVar.a(mVar);
            com.kwad.sdk.core.webview.b.j jVar = new com.kwad.sdk.core.webview.b.j();
            hVar.a(jVar);
            if (com.kwad.sdk.utils.b.a(m()).a()) {
                bVar = new com.kwad.sdk.core.webview.b.a.b();
                bVar.f72067a = true;
            } else {
                if (((com.kwad.sdk.reward.d) this).f73210a.f72870c != null) {
                    bVar = new com.kwad.sdk.core.webview.b.a.b();
                    z = !((com.kwad.sdk.reward.d) this).f73210a.f72870c.isVideoSoundEnable();
                } else {
                    bVar = new com.kwad.sdk.core.webview.b.a.b();
                    z = false;
                }
                bVar.f72067a = z;
            }
            jVar.a(bVar);
            com.kwad.sdk.core.webview.b.c cVar2 = new com.kwad.sdk.core.webview.b.c();
            cVar2.a(new c.a(this) { // from class: com.kwad.sdk.reward.b.d.a.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73139a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73139a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.c.a
                public void a(com.kwad.sdk.core.webview.b.a.c cVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar3) == null) {
                        com.kwad.sdk.core.download.b.a.a(((com.kwad.sdk.reward.d) this.f73139a).f73210a.f72874g, ((com.kwad.sdk.reward.d) this.f73139a).f73210a.f72873f, new a.InterfaceC1982a(this, cVar3) { // from class: com.kwad.sdk.reward.b.d.a.15.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.kwad.sdk.core.webview.b.a.c f73140a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f73141b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, cVar3};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f73141b = this;
                                this.f73140a = cVar3;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1982a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.f73140a.f72068a) {
                                        this.f73141b.f73139a.s();
                                    } else {
                                        this.f73141b.f73139a.t();
                                    }
                                }
                            }
                        }, ((com.kwad.sdk.reward.d) this.f73139a).f73210a.f72877j, false);
                    }
                }
            });
            hVar.a(cVar2);
            com.kwad.sdk.core.webview.b.d dVar = new com.kwad.sdk.core.webview.b.d();
            dVar.a(new d.a(this) { // from class: com.kwad.sdk.reward.b.d.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73142a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73142a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.d.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.download.b.a.a(((com.kwad.sdk.reward.d) this.f73142a).f73210a.f72874g, ((com.kwad.sdk.reward.d) this.f73142a).f73210a.f72873f, new a.InterfaceC1982a(this) { // from class: com.kwad.sdk.reward.b.d.a.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f73143a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f73143a = this;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1982a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f73143a.f73142a.u();
                                }
                            }
                        }, ((com.kwad.sdk.reward.d) this.f73142a).f73210a.f72877j, false);
                    }
                }
            });
            hVar.a(dVar);
            com.kwad.sdk.core.webview.b.h hVar2 = new com.kwad.sdk.core.webview.b.h();
            hVar2.a(new h.a(this) { // from class: com.kwad.sdk.reward.b.d.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73144a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73144a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f73144a).f73210a.f72869b.e();
                    }
                }
            });
            hVar.a(hVar2);
            hVar.a(new com.kwad.sdk.core.webview.b.b(this) { // from class: com.kwad.sdk.reward.b.d.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73145a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73145a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f73145a.r();
                    }
                }
            });
            hVar.a(new com.kwad.sdk.core.webview.b.e(this) { // from class: com.kwad.sdk.reward.b.d.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73146a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73146a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.e
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f73146a.y();
                        this.f73146a.x();
                        this.f73146a.w();
                    }
                }
            });
            hVar.a(new com.kwad.sdk.core.webview.b.a(this) { // from class: com.kwad.sdk.reward.b.d.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f73147a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73147a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f73147a.q();
                    }
                }
            });
        }
    }

    private boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65558, this)) != null) {
            return invokeV.booleanValue;
        }
        if (k() == null) {
            return false;
        }
        FrameLayout frameLayout = (FrameLayout) ((com.kwad.sdk.reward.d) this).f73210a.f72875h.findViewById(f());
        com.kwad.sdk.plugin.g gVar = (com.kwad.sdk.plugin.g) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.g.class);
        if (gVar == null) {
            return true;
        }
        String b2 = gVar.b(m());
        File file = new File(b2, e());
        com.kwad.sdk.plugin.h a2 = gVar.a(k());
        a(a2, frameLayout);
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                String inputStreamToString = IoUtils.inputStreamToString(fileInputStream2);
                if (inputStreamToString != null) {
                    File file2 = new File(b2);
                    a2.a(inputStreamToString, file2.getAbsolutePath() + "/");
                    View a3 = a2.a();
                    a3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    frameLayout.addView(a3);
                }
                try {
                    fileInputStream2.close();
                    return true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return true;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.reward.d) this).f73210a.f72873f, "1.0", gVar.d(), e(), th.getMessage());
                    gVar.c();
                    com.kwad.sdk.core.a.a.a(th);
                    com.kwad.sdk.core.d.a.a(th);
                    return false;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.reward.d) this).f73210a.f72873f);
            long b2 = com.kwad.sdk.core.response.b.a.b(i2) * 1000;
            int i3 = i2.adBaseInfo.skipSecond;
            String str = "观看完整视频即可获取奖励";
            if (i3 > 0 && !com.kwad.sdk.core.response.b.a.k(i2) && b2 > i3) {
                str = "观看视频" + i3 + "s即可获取奖励";
            }
            com.kwad.sdk.reward.e.a(((com.kwad.sdk.reward.d) this).f73210a.f72874g, str, new e.a(this, i2) { // from class: com.kwad.sdk.reward.b.d.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f73148a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f73149b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, i2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73149b = this;
                    this.f73148a = i2;
                }

                @Override // com.kwad.sdk.reward.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f73149b).f73210a.f72876i.g();
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.reward.d) this.f73149b).f73210a.f72873f, ((com.kwad.sdk.reward.d) this.f73149b).f73210a.f72871d);
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (com.kwad.sdk.core.config.c.a(this.f73148a, this.f73149b.m()) && ((com.kwad.sdk.reward.d) this.f73149b).f73210a.u) {
                            this.f73149b.w();
                        } else {
                            this.f73149b.v();
                        }
                        com.kwad.sdk.core.report.a.a(((com.kwad.sdk.reward.d) this.f73149b).f73210a.f72873f, 5, (int) (this.f73149b.f73129b / 1000));
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f73149b).f73210a.f72876i.f();
                        com.kwad.sdk.core.report.a.k(((com.kwad.sdk.reward.d) this.f73149b).f73210a.f72873f, ((com.kwad.sdk.reward.d) this.f73149b).f73210a.f72871d);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73210a;
            com.kwad.sdk.core.report.a.c(aVar.f72873f, 17, aVar.f72871d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73210a;
            com.kwad.sdk.core.report.a.c(aVar.f72873f, 18, aVar.f72871d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73210a;
            com.kwad.sdk.core.report.a.a(aVar.f72873f, 39, aVar.f72875h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f73210a.f72871d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73210a;
            com.kwad.sdk.core.report.a.a(aVar.f72873f, 40, aVar.f72875h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f73210a.f72871d);
            ((com.kwad.sdk.reward.d) this).f73210a.f72869b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73210a;
            com.kwad.sdk.core.report.a.a(aVar.f72873f, 41, aVar.f72875h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f73210a.f72871d);
            ((com.kwad.sdk.reward.d) this).f73210a.f72869b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            ((com.kwad.sdk.reward.d) this).f73210a.f72876i.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65574, this) == null) || (activity = ((com.kwad.sdk.reward.d) this).f73210a.f72874g) == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            ((com.kwad.sdk.reward.d) this).f73210a.f72869b.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            ((com.kwad.sdk.reward.d) this).f73210a.f72869b.e();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (o()) {
                return;
            }
            n();
        }
    }

    public abstract void a(c.a aVar);

    public abstract String e();

    @IdRes
    public abstract int f();

    public abstract void n();
}
