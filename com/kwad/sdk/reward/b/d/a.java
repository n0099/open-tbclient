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
    public long f66263b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f66264c;

    /* renamed from: d  reason: collision with root package name */
    public k f66265d;

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
            com.kwad.sdk.core.download.b.b bVar2 = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.reward.d) this).f66343a.f66016f);
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f66264c = aVar;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f66343a;
            aVar.f65227b = aVar2.f66016f;
            aVar.f65226a = !ab.e(aVar2.f66017g) ? 1 : 0;
            com.kwad.sdk.core.webview.a aVar3 = this.f66264c;
            aVar3.f65228c = ((com.kwad.sdk.reward.d) this).f66343a.f66018h;
            aVar3.f65230e = viewGroup;
            aVar3.f65231f = null;
            hVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            hVar.a(new g());
            hVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f66264c, bVar2, new a.b(this) { // from class: com.kwad.sdk.reward.b.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66266a;

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
                    this.f66266a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(@Nullable a.C1916a c1916a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1916a) == null) {
                    }
                }
            }));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f66264c));
            hVar.a(new f(this.f66264c));
            com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(this.f66264c);
            cVar.a(new c.b(this) { // from class: com.kwad.sdk.reward.b.d.a.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66284a;

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
                    this.f66284a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.c.b
                public void a(c.a aVar4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar4) == null) {
                        this.f66284a.a(aVar4);
                    }
                }
            });
            hVar.a(cVar);
            hVar.a(new i(this.f66264c, new i.b(this) { // from class: com.kwad.sdk.reward.b.d.a.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66285a;

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
                    this.f66285a = this;
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
                public final /* synthetic */ a f66267a;

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
                    this.f66267a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.m.b
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    }
                }
            }));
            hVar.a(new p());
            hVar.a(new q(this.f66264c, bVar2));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.h(new h.a(this) { // from class: com.kwad.sdk.reward.b.d.a.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66268a;

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
                    this.f66268a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f66268a).f66343a.f66018h.findViewById(this.f66268a.f()).setVisibility(8);
                    }
                }
            }));
            hVar.a(new j(this.f66264c));
            hVar.a(new com.kwad.sdk.core.webview.b.f());
            k kVar = new k();
            this.f66265d = kVar;
            hVar.a(kVar);
            ((com.kwad.sdk.reward.d) this).f66343a.f66019i.a(new com.kwad.sdk.contentalliance.detail.video.d(this, new com.kwad.sdk.core.webview.b.a.f()) { // from class: com.kwad.sdk.reward.b.d.a.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.webview.b.a.f f66269a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66270b;

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
                    this.f66270b = this;
                    this.f66269a = r7;
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f66269a;
                        fVar.f65258b = false;
                        fVar.f65259c = false;
                        fVar.f65257a = 0;
                        this.f66270b.f66265d.a(this.f66269a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f66269a;
                        fVar.f65258b = true;
                        fVar.f65259c = false;
                        this.f66270b.f66265d.a(this.f66269a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        this.f66270b.f66263b = j2;
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f66269a;
                        fVar.f65258b = false;
                        fVar.f65259c = false;
                        fVar.f65257a = (int) Math.ceil(((float) j2) / 1000.0f);
                        this.f66270b.f66265d.a(this.f66269a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f66269a;
                        fVar.f65258b = false;
                        fVar.f65259c = false;
                        this.f66270b.f66265d.a(this.f66269a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f66269a;
                        fVar.f65258b = false;
                        fVar.f65259c = false;
                        this.f66270b.f66265d.a(this.f66269a);
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
                        a aVar4 = this.f66270b;
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
                public final /* synthetic */ a f66271a;

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
                    this.f66271a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.l.a
                public void a(com.kwad.sdk.core.webview.b.a.e eVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, eVar) == null) {
                        if (eVar.f65254a) {
                            this.f66271a.q();
                        } else {
                            ((com.kwad.sdk.reward.d) this.f66271a).f66343a.f66019i.h();
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
                public final /* synthetic */ a f66272a;

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
                    this.f66272a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.m.a
                public void a(com.kwad.sdk.core.webview.b.a.b bVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar3) == null) {
                        ((com.kwad.sdk.reward.d) this.f66272a).f66343a.f66019i.a(!bVar3.f65251a, true);
                    }
                }
            });
            hVar.a(mVar);
            com.kwad.sdk.core.webview.b.j jVar = new com.kwad.sdk.core.webview.b.j();
            hVar.a(jVar);
            if (com.kwad.sdk.utils.b.a(m()).a()) {
                bVar = new com.kwad.sdk.core.webview.b.a.b();
                bVar.f65251a = true;
            } else {
                if (((com.kwad.sdk.reward.d) this).f66343a.f66013c != null) {
                    bVar = new com.kwad.sdk.core.webview.b.a.b();
                    z = !((com.kwad.sdk.reward.d) this).f66343a.f66013c.isVideoSoundEnable();
                } else {
                    bVar = new com.kwad.sdk.core.webview.b.a.b();
                    z = false;
                }
                bVar.f65251a = z;
            }
            jVar.a(bVar);
            com.kwad.sdk.core.webview.b.c cVar2 = new com.kwad.sdk.core.webview.b.c();
            cVar2.a(new c.a(this) { // from class: com.kwad.sdk.reward.b.d.a.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66273a;

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
                    this.f66273a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.c.a
                public void a(com.kwad.sdk.core.webview.b.a.c cVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar3) == null) {
                        com.kwad.sdk.core.download.b.a.a(((com.kwad.sdk.reward.d) this.f66273a).f66343a.f66017g, ((com.kwad.sdk.reward.d) this.f66273a).f66343a.f66016f, new a.InterfaceC1901a(this, cVar3) { // from class: com.kwad.sdk.reward.b.d.a.15.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.kwad.sdk.core.webview.b.a.c f66274a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f66275b;

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
                                this.f66275b = this;
                                this.f66274a = cVar3;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1901a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.f66274a.f65252a) {
                                        this.f66275b.f66273a.t();
                                    } else {
                                        this.f66275b.f66273a.u();
                                    }
                                }
                            }
                        }, ((com.kwad.sdk.reward.d) this.f66273a).f66343a.j, false);
                    }
                }
            });
            hVar.a(cVar2);
            com.kwad.sdk.core.webview.b.d dVar = new com.kwad.sdk.core.webview.b.d();
            dVar.a(new d.a(this) { // from class: com.kwad.sdk.reward.b.d.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66276a;

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
                    this.f66276a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.d.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.download.b.a.a(((com.kwad.sdk.reward.d) this.f66276a).f66343a.f66017g, ((com.kwad.sdk.reward.d) this.f66276a).f66343a.f66016f, new a.InterfaceC1901a(this) { // from class: com.kwad.sdk.reward.b.d.a.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f66277a;

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
                                this.f66277a = this;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1901a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f66277a.f66276a.v();
                                }
                            }
                        }, ((com.kwad.sdk.reward.d) this.f66276a).f66343a.j, false);
                    }
                }
            });
            hVar.a(dVar);
            com.kwad.sdk.core.webview.b.h hVar2 = new com.kwad.sdk.core.webview.b.h();
            hVar2.a(new h.a(this) { // from class: com.kwad.sdk.reward.b.d.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66278a;

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
                    this.f66278a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f66278a).f66343a.f66012b.e();
                    }
                }
            });
            hVar.a(hVar2);
            hVar.a(new com.kwad.sdk.core.webview.b.b(this) { // from class: com.kwad.sdk.reward.b.d.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66279a;

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
                    this.f66279a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f66279a.s();
                    }
                }
            });
            hVar.a(new com.kwad.sdk.core.webview.b.e(this) { // from class: com.kwad.sdk.reward.b.d.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66280a;

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
                    this.f66280a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.e
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f66280a.z();
                        this.f66280a.y();
                        this.f66280a.x();
                    }
                }
            });
            hVar.a(new com.kwad.sdk.core.webview.b.a(this) { // from class: com.kwad.sdk.reward.b.d.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66281a;

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
                    this.f66281a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f66281a.r();
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
        FrameLayout frameLayout = (FrameLayout) ((com.kwad.sdk.reward.d) this).f66343a.f66018h.findViewById(f());
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
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.reward.d) this).f66343a.f66016f, "1.0", gVar.d(), e(), th.getMessage());
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
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.reward.d) this).f66343a.f66016f);
            long b2 = com.kwad.sdk.core.response.b.a.b(i2) * 1000;
            int i3 = i2.adBaseInfo.skipSecond;
            String str = "观看完整视频即可获取奖励";
            if (i3 > 0 && !com.kwad.sdk.core.response.b.a.k(i2) && b2 > i3) {
                str = "观看视频" + i3 + "s即可获取奖励";
            }
            com.kwad.sdk.reward.e.a(((com.kwad.sdk.reward.d) this).f66343a.f66017g, str, new e.a(this, i2) { // from class: com.kwad.sdk.reward.b.d.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f66282a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66283b;

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
                    this.f66283b = this;
                    this.f66282a = i2;
                }

                @Override // com.kwad.sdk.reward.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f66283b).f66343a.f66019i.g();
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.reward.d) this.f66283b).f66343a.f66016f, ((com.kwad.sdk.reward.d) this.f66283b).f66343a.f66014d);
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (com.kwad.sdk.core.config.c.a(this.f66282a, this.f66283b.m()) && ((com.kwad.sdk.reward.d) this.f66283b).f66343a.u) {
                            this.f66283b.x();
                        } else {
                            this.f66283b.w();
                        }
                        com.kwad.sdk.core.report.a.a(((com.kwad.sdk.reward.d) this.f66283b).f66343a.f66016f, 5, (int) (this.f66283b.f66263b / 1000));
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f66283b).f66343a.f66019i.f();
                        com.kwad.sdk.core.report.a.k(((com.kwad.sdk.reward.d) this.f66283b).f66343a.f66016f, ((com.kwad.sdk.reward.d) this.f66283b).f66343a.f66014d);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66343a;
            com.kwad.sdk.core.report.a.c(aVar.f66016f, 17, aVar.f66014d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66343a;
            com.kwad.sdk.core.report.a.c(aVar.f66016f, 18, aVar.f66014d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66343a;
            com.kwad.sdk.core.report.a.a(aVar.f66016f, 39, aVar.f66018h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f66343a.f66014d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66343a;
            com.kwad.sdk.core.report.a.a(aVar.f66016f, 40, aVar.f66018h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f66343a.f66014d);
            ((com.kwad.sdk.reward.d) this).f66343a.f66012b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66343a;
            com.kwad.sdk.core.report.a.a(aVar.f66016f, 41, aVar.f66018h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f66343a.f66014d);
            ((com.kwad.sdk.reward.d) this).f66343a.f66012b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            ((com.kwad.sdk.reward.d) this).f66343a.f66019i.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65576, this) == null) || (activity = ((com.kwad.sdk.reward.d) this).f66343a.f66017g) == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            ((com.kwad.sdk.reward.d) this).f66343a.f66012b.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            ((com.kwad.sdk.reward.d) this).f66343a.f66012b.e();
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || (kVar = this.f66265d) == null || fVar == null) {
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
            fVar.f65258b = false;
            fVar.f65259c = true;
            fVar.f65257a = (int) Math.ceil(((float) com.kwad.sdk.core.response.b.a.l(com.kwad.sdk.core.response.b.c.i(this.f66264c.f65227b))) / 1000.0f);
            return fVar;
        }
        return (com.kwad.sdk.core.webview.b.a.f) invokeV.objValue;
    }
}
