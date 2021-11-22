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
/* loaded from: classes2.dex */
public abstract class a extends com.kwad.sdk.reward.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f67175b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f67176c;

    /* renamed from: d  reason: collision with root package name */
    public k f67177d;

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
        if (interceptable == null || interceptable.invokeLL(65544, this, hVar, viewGroup) == null) {
            com.kwad.sdk.core.download.b.b bVar2 = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.reward.d) this).f67255a.f66928f);
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f67176c = aVar;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f67255a;
            aVar.f66139b = aVar2.f66928f;
            aVar.f66138a = !ab.e(aVar2.f66929g) ? 1 : 0;
            com.kwad.sdk.core.webview.a aVar3 = this.f67176c;
            aVar3.f66140c = ((com.kwad.sdk.reward.d) this).f67255a.f66930h;
            aVar3.f66142e = viewGroup;
            aVar3.f66143f = null;
            hVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            hVar.a(new g());
            hVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f67176c, bVar2, new a.b(this) { // from class: com.kwad.sdk.reward.b.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67178a;

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
                    this.f67178a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(@Nullable a.C1956a c1956a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1956a) == null) {
                    }
                }
            }));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f67176c));
            hVar.a(new f(this.f67176c));
            com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(this.f67176c);
            cVar.a(new c.b(this) { // from class: com.kwad.sdk.reward.b.d.a.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67196a;

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
                    this.f67196a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.c.b
                public void a(c.a aVar4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar4) == null) {
                        this.f67196a.a(aVar4);
                    }
                }
            });
            hVar.a(cVar);
            hVar.a(new i(this.f67176c, new i.b(this) { // from class: com.kwad.sdk.reward.b.d.a.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67197a;

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
                    this.f67197a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.i.b
                public void a(i.a aVar4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar4) == null) {
                    }
                }
            }));
            hVar.a(new m(new m.b(this) { // from class: com.kwad.sdk.reward.b.d.a.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67179a;

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
                    this.f67179a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.m.b
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    }
                }
            }));
            hVar.a(new p());
            hVar.a(new q(this.f67176c, bVar2));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.h(new h.a(this) { // from class: com.kwad.sdk.reward.b.d.a.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67180a;

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
                    this.f67180a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f67180a).f67255a.f66930h.findViewById(this.f67180a.f()).setVisibility(8);
                    }
                }
            }));
            hVar.a(new j(this.f67176c));
            hVar.a(new com.kwad.sdk.core.webview.b.f());
            k kVar = new k();
            this.f67177d = kVar;
            hVar.a(kVar);
            ((com.kwad.sdk.reward.d) this).f67255a.f66931i.a(new com.kwad.sdk.contentalliance.detail.video.d(this, new com.kwad.sdk.core.webview.b.a.f()) { // from class: com.kwad.sdk.reward.b.d.a.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.webview.b.a.f f67181a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f67182b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67182b = this;
                    this.f67181a = r7;
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f67181a;
                        fVar.f66170b = false;
                        fVar.f66171c = false;
                        fVar.f66169a = 0;
                        this.f67182b.f67177d.a(this.f67181a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f67181a;
                        fVar.f66170b = true;
                        fVar.f66171c = false;
                        this.f67182b.f67177d.a(this.f67181a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        this.f67182b.f67175b = j2;
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f67181a;
                        fVar.f66170b = false;
                        fVar.f66171c = false;
                        fVar.f66169a = (int) Math.ceil(((float) j2) / 1000.0f);
                        this.f67182b.f67177d.a(this.f67181a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f67181a;
                        fVar.f66170b = false;
                        fVar.f66171c = false;
                        this.f67182b.f67177d.a(this.f67181a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f67181a;
                        fVar.f66170b = false;
                        fVar.f66171c = false;
                        this.f67182b.f67177d.a(this.f67181a);
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
                        a aVar4 = this.f67182b;
                        aVar4.a(aVar4.o());
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
                public final /* synthetic */ a f67183a;

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
                    this.f67183a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.l.a
                public void a(com.kwad.sdk.core.webview.b.a.e eVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, eVar) == null) {
                        if (eVar.f66166a) {
                            this.f67183a.q();
                        } else {
                            ((com.kwad.sdk.reward.d) this.f67183a).f67255a.f66931i.h();
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
                public final /* synthetic */ a f67184a;

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
                    this.f67184a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.m.a
                public void a(com.kwad.sdk.core.webview.b.a.b bVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar3) == null) {
                        ((com.kwad.sdk.reward.d) this.f67184a).f67255a.f66931i.a(!bVar3.f66163a, true);
                    }
                }
            });
            hVar.a(mVar);
            com.kwad.sdk.core.webview.b.j jVar = new com.kwad.sdk.core.webview.b.j();
            hVar.a(jVar);
            if (com.kwad.sdk.utils.b.a(m()).a()) {
                bVar = new com.kwad.sdk.core.webview.b.a.b();
                bVar.f66163a = true;
            } else {
                if (((com.kwad.sdk.reward.d) this).f67255a.f66925c != null) {
                    bVar = new com.kwad.sdk.core.webview.b.a.b();
                    z = !((com.kwad.sdk.reward.d) this).f67255a.f66925c.isVideoSoundEnable();
                } else {
                    bVar = new com.kwad.sdk.core.webview.b.a.b();
                    z = false;
                }
                bVar.f66163a = z;
            }
            jVar.a(bVar);
            com.kwad.sdk.core.webview.b.c cVar2 = new com.kwad.sdk.core.webview.b.c();
            cVar2.a(new c.a(this) { // from class: com.kwad.sdk.reward.b.d.a.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67185a;

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
                    this.f67185a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.c.a
                public void a(com.kwad.sdk.core.webview.b.a.c cVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar3) == null) {
                        com.kwad.sdk.core.download.b.a.a(((com.kwad.sdk.reward.d) this.f67185a).f67255a.f66929g, ((com.kwad.sdk.reward.d) this.f67185a).f67255a.f66928f, new a.InterfaceC1941a(this, cVar3) { // from class: com.kwad.sdk.reward.b.d.a.15.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.kwad.sdk.core.webview.b.a.c f67186a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f67187b;

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
                                this.f67187b = this;
                                this.f67186a = cVar3;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1941a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.f67186a.f66164a) {
                                        this.f67187b.f67185a.t();
                                    } else {
                                        this.f67187b.f67185a.u();
                                    }
                                }
                            }
                        }, ((com.kwad.sdk.reward.d) this.f67185a).f67255a.j, false);
                    }
                }
            });
            hVar.a(cVar2);
            com.kwad.sdk.core.webview.b.d dVar = new com.kwad.sdk.core.webview.b.d();
            dVar.a(new d.a(this) { // from class: com.kwad.sdk.reward.b.d.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67188a;

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
                    this.f67188a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.d.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.download.b.a.a(((com.kwad.sdk.reward.d) this.f67188a).f67255a.f66929g, ((com.kwad.sdk.reward.d) this.f67188a).f67255a.f66928f, new a.InterfaceC1941a(this) { // from class: com.kwad.sdk.reward.b.d.a.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f67189a;

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
                                this.f67189a = this;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1941a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f67189a.f67188a.v();
                                }
                            }
                        }, ((com.kwad.sdk.reward.d) this.f67188a).f67255a.j, false);
                    }
                }
            });
            hVar.a(dVar);
            com.kwad.sdk.core.webview.b.h hVar2 = new com.kwad.sdk.core.webview.b.h();
            hVar2.a(new h.a(this) { // from class: com.kwad.sdk.reward.b.d.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67190a;

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
                    this.f67190a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f67190a).f67255a.f66924b.e();
                    }
                }
            });
            hVar.a(hVar2);
            hVar.a(new com.kwad.sdk.core.webview.b.b(this) { // from class: com.kwad.sdk.reward.b.d.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67191a;

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
                    this.f67191a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f67191a.s();
                    }
                }
            });
            hVar.a(new com.kwad.sdk.core.webview.b.e(this) { // from class: com.kwad.sdk.reward.b.d.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67192a;

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
                    this.f67192a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.e
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f67192a.z();
                        this.f67192a.y();
                        this.f67192a.x();
                    }
                }
            });
            hVar.a(new com.kwad.sdk.core.webview.b.a(this) { // from class: com.kwad.sdk.reward.b.d.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f67193a;

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
                    this.f67193a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f67193a.r();
                    }
                }
            });
        }
    }

    private boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65560, this)) != null) {
            return invokeV.booleanValue;
        }
        if (k() == null) {
            return false;
        }
        FrameLayout frameLayout = (FrameLayout) ((com.kwad.sdk.reward.d) this).f67255a.f66930h.findViewById(f());
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
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.reward.d) this).f67255a.f66928f, "1.0", gVar.d(), e(), th.getMessage());
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
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.reward.d) this).f67255a.f66928f);
            long b2 = com.kwad.sdk.core.response.b.a.b(i2) * 1000;
            int i3 = i2.adBaseInfo.skipSecond;
            String str = "观看完整视频即可获取奖励";
            if (i3 > 0 && !com.kwad.sdk.core.response.b.a.k(i2) && b2 > i3) {
                str = "观看视频" + i3 + "s即可获取奖励";
            }
            com.kwad.sdk.reward.e.a(((com.kwad.sdk.reward.d) this).f67255a.f66929g, str, new e.a(this, i2) { // from class: com.kwad.sdk.reward.b.d.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f67194a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f67195b;

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
                    this.f67195b = this;
                    this.f67194a = i2;
                }

                @Override // com.kwad.sdk.reward.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f67195b).f67255a.f66931i.g();
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.reward.d) this.f67195b).f67255a.f66928f, ((com.kwad.sdk.reward.d) this.f67195b).f67255a.f66926d);
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (com.kwad.sdk.core.config.c.a(this.f67194a, this.f67195b.m()) && ((com.kwad.sdk.reward.d) this.f67195b).f67255a.u) {
                            this.f67195b.x();
                        } else {
                            this.f67195b.w();
                        }
                        com.kwad.sdk.core.report.a.a(((com.kwad.sdk.reward.d) this.f67195b).f67255a.f66928f, 5, (int) (this.f67195b.f67175b / 1000));
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f67195b).f67255a.f66931i.f();
                        com.kwad.sdk.core.report.a.k(((com.kwad.sdk.reward.d) this.f67195b).f67255a.f66928f, ((com.kwad.sdk.reward.d) this.f67195b).f67255a.f66926d);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f67255a;
            com.kwad.sdk.core.report.a.c(aVar.f66928f, 17, aVar.f66926d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f67255a;
            com.kwad.sdk.core.report.a.c(aVar.f66928f, 18, aVar.f66926d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f67255a;
            com.kwad.sdk.core.report.a.a(aVar.f66928f, 39, aVar.f66930h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f67255a.f66926d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f67255a;
            com.kwad.sdk.core.report.a.a(aVar.f66928f, 40, aVar.f66930h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f67255a.f66926d);
            ((com.kwad.sdk.reward.d) this).f67255a.f66924b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f67255a;
            com.kwad.sdk.core.report.a.a(aVar.f66928f, 41, aVar.f66930h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f67255a.f66926d);
            ((com.kwad.sdk.reward.d) this).f67255a.f66924b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            ((com.kwad.sdk.reward.d) this).f67255a.f66931i.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65576, this) == null) || (activity = ((com.kwad.sdk.reward.d) this).f67255a.f66929g) == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            ((com.kwad.sdk.reward.d) this).f67255a.f66924b.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            ((com.kwad.sdk.reward.d) this).f67255a.f66924b.e();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (p()) {
                return;
            }
            n();
        }
    }

    public void a(com.kwad.sdk.core.webview.b.a.f fVar) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || (kVar = this.f67177d) == null || fVar == null) {
            return;
        }
        kVar.a(fVar);
    }

    public abstract void a(c.a aVar);

    public abstract String e();

    @IdRes
    public abstract int f();

    public abstract void n();

    public com.kwad.sdk.core.webview.b.a.f o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            com.kwad.sdk.core.webview.b.a.f fVar = new com.kwad.sdk.core.webview.b.a.f();
            fVar.f66170b = false;
            fVar.f66171c = true;
            fVar.f66169a = (int) Math.ceil(((float) com.kwad.sdk.core.response.b.a.l(com.kwad.sdk.core.response.b.c.i(this.f67176c.f66139b))) / 1000.0f);
            return fVar;
        }
        return (com.kwad.sdk.core.webview.b.a.f) invokeV.objValue;
    }
}
