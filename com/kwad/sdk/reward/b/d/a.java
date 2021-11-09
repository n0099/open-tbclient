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
    public long f66262b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f66263c;

    /* renamed from: d  reason: collision with root package name */
    public k f66264d;

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
            com.kwad.sdk.core.download.b.b bVar2 = new com.kwad.sdk.core.download.b.b(((com.kwad.sdk.reward.d) this).f66342a.f66015f);
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f66263c = aVar;
            com.kwad.sdk.reward.a aVar2 = ((com.kwad.sdk.reward.d) this).f66342a;
            aVar.f65226b = aVar2.f66015f;
            aVar.f65225a = !ab.e(aVar2.f66016g) ? 1 : 0;
            com.kwad.sdk.core.webview.a aVar3 = this.f66263c;
            aVar3.f65227c = ((com.kwad.sdk.reward.d) this).f66342a.f66017h;
            aVar3.f65229e = viewGroup;
            aVar3.f65230f = null;
            hVar.a(new com.kwad.sdk.core.webview.jshandler.d());
            hVar.a(new g());
            hVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f66263c, bVar2, new a.b(this) { // from class: com.kwad.sdk.reward.b.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66265a;

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
                    this.f66265a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.a.b
                public void a(@Nullable a.C1916a c1916a) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, c1916a) == null) {
                    }
                }
            }));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.e(this.f66263c));
            hVar.a(new f(this.f66263c));
            com.kwad.sdk.core.webview.jshandler.c cVar = new com.kwad.sdk.core.webview.jshandler.c(this.f66263c);
            cVar.a(new c.b(this) { // from class: com.kwad.sdk.reward.b.d.a.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66283a;

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
                    this.f66283a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.c.b
                public void a(c.a aVar4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar4) == null) {
                        this.f66283a.a(aVar4);
                    }
                }
            });
            hVar.a(cVar);
            hVar.a(new i(this.f66263c, new i.b(this) { // from class: com.kwad.sdk.reward.b.d.a.9
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

                @Override // com.kwad.sdk.core.webview.jshandler.m.b
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    }
                }
            }));
            hVar.a(new p());
            hVar.a(new q(this.f66263c, bVar2));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.h(new h.a(this) { // from class: com.kwad.sdk.reward.b.d.a.11
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

                @Override // com.kwad.sdk.core.webview.jshandler.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f66267a).f66342a.f66017h.findViewById(this.f66267a.f()).setVisibility(8);
                    }
                }
            }));
            hVar.a(new j(this.f66263c));
            hVar.a(new com.kwad.sdk.core.webview.b.f());
            k kVar = new k();
            this.f66264d = kVar;
            hVar.a(kVar);
            ((com.kwad.sdk.reward.d) this).f66342a.f66018i.a(new com.kwad.sdk.contentalliance.detail.video.d(this, new com.kwad.sdk.core.webview.b.a.f()) { // from class: com.kwad.sdk.reward.b.d.a.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.core.webview.b.a.f f66268a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66269b;

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
                    this.f66269b = this;
                    this.f66268a = r7;
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f66268a;
                        fVar.f65257b = false;
                        fVar.f65258c = false;
                        fVar.f65256a = 0;
                        this.f66269b.f66264d.a(this.f66268a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f66268a;
                        fVar.f65257b = true;
                        fVar.f65258c = false;
                        this.f66269b.f66264d.a(this.f66268a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void a(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        this.f66269b.f66262b = j2;
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f66268a;
                        fVar.f65257b = false;
                        fVar.f65258c = false;
                        fVar.f65256a = (int) Math.ceil(((float) j2) / 1000.0f);
                        this.f66269b.f66264d.a(this.f66268a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f66268a;
                        fVar.f65257b = false;
                        fVar.f65258c = false;
                        this.f66269b.f66264d.a(this.f66268a);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.d
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        com.kwad.sdk.core.webview.b.a.f fVar = this.f66268a;
                        fVar.f65257b = false;
                        fVar.f65258c = false;
                        this.f66269b.f66264d.a(this.f66268a);
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
                        a aVar4 = this.f66269b;
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
                public final /* synthetic */ a f66270a;

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
                    this.f66270a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.l.a
                public void a(com.kwad.sdk.core.webview.b.a.e eVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, eVar) == null) {
                        if (eVar.f65253a) {
                            this.f66270a.q();
                        } else {
                            ((com.kwad.sdk.reward.d) this.f66270a).f66342a.f66018i.h();
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

                @Override // com.kwad.sdk.core.webview.b.m.a
                public void a(com.kwad.sdk.core.webview.b.a.b bVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar3) == null) {
                        ((com.kwad.sdk.reward.d) this.f66271a).f66342a.f66018i.a(!bVar3.f65250a, true);
                    }
                }
            });
            hVar.a(mVar);
            com.kwad.sdk.core.webview.b.j jVar = new com.kwad.sdk.core.webview.b.j();
            hVar.a(jVar);
            if (com.kwad.sdk.utils.b.a(m()).a()) {
                bVar = new com.kwad.sdk.core.webview.b.a.b();
                bVar.f65250a = true;
            } else {
                if (((com.kwad.sdk.reward.d) this).f66342a.f66012c != null) {
                    bVar = new com.kwad.sdk.core.webview.b.a.b();
                    z = !((com.kwad.sdk.reward.d) this).f66342a.f66012c.isVideoSoundEnable();
                } else {
                    bVar = new com.kwad.sdk.core.webview.b.a.b();
                    z = false;
                }
                bVar.f65250a = z;
            }
            jVar.a(bVar);
            com.kwad.sdk.core.webview.b.c cVar2 = new com.kwad.sdk.core.webview.b.c();
            cVar2.a(new c.a(this) { // from class: com.kwad.sdk.reward.b.d.a.15
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

                @Override // com.kwad.sdk.core.webview.b.c.a
                public void a(com.kwad.sdk.core.webview.b.a.c cVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar3) == null) {
                        com.kwad.sdk.core.download.b.a.a(((com.kwad.sdk.reward.d) this.f66272a).f66342a.f66016g, ((com.kwad.sdk.reward.d) this.f66272a).f66342a.f66015f, new a.InterfaceC1901a(this, cVar3) { // from class: com.kwad.sdk.reward.b.d.a.15.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ com.kwad.sdk.core.webview.b.a.c f66273a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass15 f66274b;

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
                                this.f66274b = this;
                                this.f66273a = cVar3;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1901a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.f66273a.f65251a) {
                                        this.f66274b.f66272a.t();
                                    } else {
                                        this.f66274b.f66272a.u();
                                    }
                                }
                            }
                        }, ((com.kwad.sdk.reward.d) this.f66272a).f66342a.j, false);
                    }
                }
            });
            hVar.a(cVar2);
            com.kwad.sdk.core.webview.b.d dVar = new com.kwad.sdk.core.webview.b.d();
            dVar.a(new d.a(this) { // from class: com.kwad.sdk.reward.b.d.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66275a;

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
                    this.f66275a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.d.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.download.b.a.a(((com.kwad.sdk.reward.d) this.f66275a).f66342a.f66016g, ((com.kwad.sdk.reward.d) this.f66275a).f66342a.f66015f, new a.InterfaceC1901a(this) { // from class: com.kwad.sdk.reward.b.d.a.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f66276a;

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
                                this.f66276a = this;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1901a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f66276a.f66275a.v();
                                }
                            }
                        }, ((com.kwad.sdk.reward.d) this.f66275a).f66342a.j, false);
                    }
                }
            });
            hVar.a(dVar);
            com.kwad.sdk.core.webview.b.h hVar2 = new com.kwad.sdk.core.webview.b.h();
            hVar2.a(new h.a(this) { // from class: com.kwad.sdk.reward.b.d.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f66277a;

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
                    this.f66277a = this;
                }

                @Override // com.kwad.sdk.core.webview.b.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f66277a).f66342a.f66011b.e();
                    }
                }
            });
            hVar.a(hVar2);
            hVar.a(new com.kwad.sdk.core.webview.b.b(this) { // from class: com.kwad.sdk.reward.b.d.a.4
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

                @Override // com.kwad.sdk.core.webview.b.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f66278a.s();
                    }
                }
            });
            hVar.a(new com.kwad.sdk.core.webview.b.e(this) { // from class: com.kwad.sdk.reward.b.d.a.5
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

                @Override // com.kwad.sdk.core.webview.b.e
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f66279a.z();
                        this.f66279a.y();
                        this.f66279a.x();
                    }
                }
            });
            hVar.a(new com.kwad.sdk.core.webview.b.a(this) { // from class: com.kwad.sdk.reward.b.d.a.6
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

                @Override // com.kwad.sdk.core.webview.b.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.f66280a.r();
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
        FrameLayout frameLayout = (FrameLayout) ((com.kwad.sdk.reward.d) this).f66342a.f66017h.findViewById(f());
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
                    com.kwad.sdk.core.report.d.a(((com.kwad.sdk.reward.d) this).f66342a.f66015f, "1.0", gVar.d(), e(), th.getMessage());
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
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(((com.kwad.sdk.reward.d) this).f66342a.f66015f);
            long b2 = com.kwad.sdk.core.response.b.a.b(i2) * 1000;
            int i3 = i2.adBaseInfo.skipSecond;
            String str = "观看完整视频即可获取奖励";
            if (i3 > 0 && !com.kwad.sdk.core.response.b.a.k(i2) && b2 > i3) {
                str = "观看视频" + i3 + "s即可获取奖励";
            }
            com.kwad.sdk.reward.e.a(((com.kwad.sdk.reward.d) this).f66342a.f66016g, str, new e.a(this, i2) { // from class: com.kwad.sdk.reward.b.d.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f66281a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f66282b;

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
                    this.f66282b = this;
                    this.f66281a = i2;
                }

                @Override // com.kwad.sdk.reward.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f66282b).f66342a.f66018i.g();
                        com.kwad.sdk.core.report.a.j(((com.kwad.sdk.reward.d) this.f66282b).f66342a.f66015f, ((com.kwad.sdk.reward.d) this.f66282b).f66342a.f66013d);
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (com.kwad.sdk.core.config.c.a(this.f66281a, this.f66282b.m()) && ((com.kwad.sdk.reward.d) this.f66282b).f66342a.u) {
                            this.f66282b.x();
                        } else {
                            this.f66282b.w();
                        }
                        com.kwad.sdk.core.report.a.a(((com.kwad.sdk.reward.d) this.f66282b).f66342a.f66015f, 5, (int) (this.f66282b.f66262b / 1000));
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f66282b).f66342a.f66018i.f();
                        com.kwad.sdk.core.report.a.k(((com.kwad.sdk.reward.d) this.f66282b).f66342a.f66015f, ((com.kwad.sdk.reward.d) this.f66282b).f66342a.f66013d);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66342a;
            com.kwad.sdk.core.report.a.c(aVar.f66015f, 17, aVar.f66013d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66342a;
            com.kwad.sdk.core.report.a.c(aVar.f66015f, 18, aVar.f66013d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66342a;
            com.kwad.sdk.core.report.a.a(aVar.f66015f, 39, aVar.f66017h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f66342a.f66013d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66342a;
            com.kwad.sdk.core.report.a.a(aVar.f66015f, 40, aVar.f66017h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f66342a.f66013d);
            ((com.kwad.sdk.reward.d) this).f66342a.f66011b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66342a;
            com.kwad.sdk.core.report.a.a(aVar.f66015f, 41, aVar.f66017h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f66342a.f66013d);
            ((com.kwad.sdk.reward.d) this).f66342a.f66011b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            ((com.kwad.sdk.reward.d) this).f66342a.f66018i.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65576, this) == null) || (activity = ((com.kwad.sdk.reward.d) this).f66342a.f66016g) == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            ((com.kwad.sdk.reward.d) this).f66342a.f66011b.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            ((com.kwad.sdk.reward.d) this).f66342a.f66011b.e();
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || (kVar = this.f66264d) == null || fVar == null) {
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
            fVar.f65257b = false;
            fVar.f65258c = true;
            fVar.f65256a = (int) Math.ceil(((float) com.kwad.sdk.core.response.b.a.l(com.kwad.sdk.core.response.b.c.i(this.f66263c.f65226b))) / 1000.0f);
            return fVar;
        }
        return (com.kwad.sdk.core.webview.b.a.f) invokeV.objValue;
    }
}
