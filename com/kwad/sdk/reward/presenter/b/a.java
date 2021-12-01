package com.kwad.sdk.reward.presenter.b;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.report.CommercialAction;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.core.webview.a.d;
import com.kwad.sdk.core.webview.a.h;
import com.kwad.sdk.core.webview.a.j;
import com.kwad.sdk.core.webview.a.k;
import com.kwad.sdk.core.webview.a.kwai.f;
import com.kwad.sdk.core.webview.a.l;
import com.kwad.sdk.core.webview.a.m;
import com.kwad.sdk.core.webview.a.n;
import com.kwad.sdk.core.webview.jshandler.b;
import com.kwad.sdk.core.webview.jshandler.d;
import com.kwad.sdk.core.webview.jshandler.i;
import com.kwad.sdk.core.webview.jshandler.j;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.core.webview.jshandler.s;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.plugin.h;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes2.dex */
public abstract class a extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f59080b;

    /* renamed from: c  reason: collision with root package name */
    public long f59081c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59082d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59083e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a f59084f;

    /* renamed from: g  reason: collision with root package name */
    public k f59085g;

    /* renamed from: h  reason: collision with root package name */
    public h f59086h;

    /* renamed from: i  reason: collision with root package name */
    public f f59087i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.plugin.g f59088j;

    /* renamed from: k  reason: collision with root package name */
    public j f59089k;
    public long l;
    public final com.kwad.sdk.reward.a.f m;
    public j.a n;

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
                return;
            }
        }
        this.m = new com.kwad.sdk.reward.a.f(this) { // from class: com.kwad.sdk.reward.presenter.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.f59082d) {
                    com.kwad.sdk.reward.k.a(((g) this.a).a);
                }
            }
        };
        this.n = new j.a(this) { // from class: com.kwad.sdk.reward.presenter.b.a.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.utils.j.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f59089k == null) {
                    return;
                }
                com.kwad.sdk.core.webview.a.kwai.b bVar = new com.kwad.sdk.core.webview.a.kwai.b();
                bVar.a = true;
                this.a.f59089k.a(bVar);
            }

            @Override // com.kwad.sdk.utils.j.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            com.kwad.sdk.core.report.a.a(aVar.f58874g, 40, aVar.f58877j.getTouchCoords(), ((g) this).a.f58872e);
            ((g) this).a.f58869b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            com.kwad.sdk.core.report.a.a(aVar.f58874g, 41, aVar.f58877j.getTouchCoords(), ((g) this).a.f58872e);
            ((g) this).a.f58869b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            ((g) this).a.f58869b.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            ((g) this).a.f58869b.e();
        }
    }

    private void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.l = SystemClock.elapsedRealtime();
            i.a("ad_client_apm_log", new CommercialAction.TKPerformMsg().setRenderState(0).setTemplateId(e()).setVersionCode(this.f59088j.d()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            i.a("ad_client_apm_log", new CommercialAction.TKPerformMsg().setRenderState(1).setRenderTime(this.l > 0 ? SystemClock.elapsedRealtime() - this.l : 0L).setTemplateId(e()).setVersionCode(this.f59088j.d()));
        }
    }

    private void a(h hVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, this, hVar, viewGroup) == null) {
            com.kwad.sdk.core.download.a.b bVar = new com.kwad.sdk.core.download.a.b(((g) this).a.f58874g);
            com.kwad.sdk.core.webview.a aVar = new com.kwad.sdk.core.webview.a();
            this.f59084f = aVar;
            aVar.a(((g) this).a.f58874g);
            this.f59084f.a = !af.e(q()) ? 1 : 0;
            com.kwad.sdk.core.webview.a aVar2 = this.f59084f;
            aVar2.f57955b = ((g) this).a.f58877j;
            aVar2.f57957d = viewGroup;
            aVar2.f57958e = null;
            hVar.a(new l());
            hVar.a(new com.kwad.sdk.core.webview.jshandler.e());
            hVar.a(new com.kwad.sdk.core.webview.a.g());
            hVar.a(new com.kwad.sdk.core.webview.jshandler.b(this.f59084f, bVar, w()));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.a(this.f59084f, bVar, w()));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.f(this.f59084f));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.g(this.f59084f));
            com.kwad.sdk.core.webview.jshandler.d dVar = new com.kwad.sdk.core.webview.jshandler.d(this.f59084f);
            dVar.a(new d.b(this) { // from class: com.kwad.sdk.reward.presenter.b.a.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.d.b
                public void a(d.a aVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar3) == null) {
                        this.a.a(aVar3);
                    }
                }
            });
            hVar.a(dVar);
            hVar.a(new com.kwad.sdk.core.webview.jshandler.j(this.f59084f, new j.b(this) { // from class: com.kwad.sdk.reward.presenter.b.a.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.j.b
                public void a(j.a aVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar3) == null) {
                        this.a.a(aVar3);
                    }
                }
            }));
            hVar.a(new p(new p.b(this) { // from class: com.kwad.sdk.reward.presenter.b.a.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.p.b
                public void a(p.a aVar3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar3) == null) {
                        if (aVar3.a == 1) {
                            this.a.F();
                        } else {
                            this.a.a(aVar3.f58056b);
                        }
                    }
                }
            }));
            hVar.a(new s());
            hVar.a(new t(this.f59084f, bVar));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.i(new i.b(this) { // from class: com.kwad.sdk.reward.presenter.b.a.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.jshandler.i.b
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        ((g) this.a).a.f58877j.findViewById(this.a.i()).setVisibility(8);
                    }
                }
            }));
            hVar.a(new com.kwad.sdk.core.webview.jshandler.k(this.f59084f));
            hVar.a(new com.kwad.sdk.core.webview.a.f());
            k kVar = new k();
            this.f59085g = kVar;
            hVar.a(kVar);
            com.kwad.sdk.contentalliance.detail.video.e eVar = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.presenter.b.a.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a(0.0d);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(int i2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
                        this.a.t();
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void a(long j2, long j3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                        this.a.f59081c = j3;
                        this.a.f59082d = j2 - j3 < 800;
                        this.a.a(j3);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.a.a(0.0d);
                    }
                }

                @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
                public void f() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                        if (((g) this.a).a.u) {
                            this.a.t();
                        } else {
                            this.a.s();
                        }
                    }
                }
            };
            this.f59083e = eVar;
            ((g) this).a.f58878k.a(eVar);
            m mVar = new m();
            mVar.a(new m.a(this) { // from class: com.kwad.sdk.reward.presenter.b.a.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.a.m.a
                public void a(com.kwad.sdk.core.webview.a.kwai.e eVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, eVar2) == null) {
                        com.kwad.sdk.core.report.a.a(((g) this.a).a.f58874g, 69, (int) (com.kwad.sdk.core.response.a.a.o(this.a.f59080b) / 1000), (int) (this.a.f59081c / 1000));
                        boolean z = !((g) this.a).a.r || (!((g) this.a).a.v && com.kwad.sdk.core.config.b.R());
                        if (eVar2.a && z) {
                            com.kwad.sdk.reward.widget.a.a(((g) this.a).a);
                            return;
                        }
                        com.kwad.sdk.core.report.a.a(((g) this.a).a.f58874g, (int) (com.kwad.sdk.core.response.a.a.o(this.a.f59080b) / 1000), (int) (this.a.f59081c / 1000));
                        ((g) this.a).a.u = true;
                        ((g) this.a).a.f58878k.a(true);
                        com.kwad.sdk.reward.k.a(((g) this.a).a);
                    }
                }
            });
            hVar.a(mVar);
            n nVar = new n();
            nVar.a(new n.a(this) { // from class: com.kwad.sdk.reward.presenter.b.a.18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.a.n.a
                public void a(com.kwad.sdk.core.webview.a.kwai.b bVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar2) == null) {
                        ((g) this.a).a.f58878k.a(!bVar2.a, true);
                    }
                }
            });
            hVar.a(nVar);
            com.kwad.sdk.core.webview.a.j jVar = new com.kwad.sdk.core.webview.a.j();
            this.f59089k = jVar;
            hVar.a(jVar);
            ((g) this).a.f58878k.a(this.n);
            ax.a(com.kwad.sdk.utils.b.a(q()).a() ? new Runnable(this) { // from class: com.kwad.sdk.reward.presenter.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.webview.a.kwai.b bVar2 = new com.kwad.sdk.core.webview.a.kwai.b();
                        bVar2.a = true;
                        this.a.f59089k.a(bVar2);
                    }
                }
            } : new Runnable(this) { // from class: com.kwad.sdk.reward.presenter.b.a.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.webview.a.kwai.b bVar2 = new com.kwad.sdk.core.webview.a.kwai.b();
                        bVar2.a = !((g) this.a).a.f58871d.isVideoSoundEnable();
                        this.a.f59089k.a(bVar2);
                    }
                }
            }, 0L);
            com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c();
            cVar.a(new c.a(this) { // from class: com.kwad.sdk.reward.presenter.b.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.a.c.a
                public void a(com.kwad.sdk.core.webview.a.kwai.c cVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, cVar2) == null) {
                        com.kwad.sdk.core.download.a.a.a(new a.C2015a(this.a.q()).a(((g) this.a).a.f58874g).a(((g) this.a).a.l).a(2).a(new a.b(this, cVar2) { // from class: com.kwad.sdk.reward.presenter.b.a.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ com.kwad.sdk.core.webview.a.kwai.c a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f59090b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, cVar2};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f59090b = this;
                                this.a = cVar2;
                            }

                            @Override // com.kwad.sdk.core.download.a.a.b
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.a.a) {
                                        this.f59090b.a.z();
                                    } else {
                                        this.f59090b.a.A();
                                    }
                                }
                            }
                        }));
                    }
                }
            });
            hVar.a(cVar);
            com.kwad.sdk.core.webview.a.d dVar2 = new com.kwad.sdk.core.webview.a.d();
            dVar2.a(new d.a(this) { // from class: com.kwad.sdk.reward.presenter.b.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.a.d.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.download.a.a.a(new a.C2015a(this.a.q()).a(((g) this.a).a.f58874g).a(((g) this.a).a.l).a(2).a(new a.b(this) { // from class: com.kwad.sdk.reward.presenter.b.a.5.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass5 a;

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
                                this.a = this;
                            }

                            @Override // com.kwad.sdk.core.download.a.a.b
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.a.B();
                                }
                            }
                        }));
                    }
                }
            });
            hVar.a(dVar2);
            com.kwad.sdk.core.webview.a.h hVar2 = new com.kwad.sdk.core.webview.a.h();
            hVar2.a(new h.a(this) { // from class: com.kwad.sdk.reward.presenter.b.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.a.h.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((g) this.a).a.f58869b.e();
                    }
                }
            });
            hVar.a(hVar2);
            hVar.a(new com.kwad.sdk.core.webview.a.b(this) { // from class: com.kwad.sdk.reward.presenter.b.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.a.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.a.y();
                    }
                }
            });
            hVar.a(new com.kwad.sdk.core.webview.a.e(this) { // from class: com.kwad.sdk.reward.presenter.b.a.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.a.e
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.a.D();
                        this.a.C();
                        this.a.h();
                    }
                }
            });
            hVar.a(new com.kwad.sdk.core.webview.a.a(this) { // from class: com.kwad.sdk.reward.presenter.b.a.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

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
                    this.a = this;
                }

                @Override // com.kwad.sdk.core.webview.a.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        super.c();
                        this.a.x();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, str) == null) {
            com.kwad.sdk.core.report.i.a("ad_client_error_log", new CommercialAction.TKPerformMsg().setRenderState(2).setErrorReason(str).setTemplateId(e()).setVersionCode(this.f59088j.d()));
        }
    }

    private void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, th) == null) {
            com.kwad.sdk.core.kwai.a.a(th);
            com.kwad.sdk.core.d.a.a(th);
            com.kwad.sdk.core.report.i.a("ad_client_error_log", new CommercialAction.TKPerformMsg().setRenderState(3).setErrorReason(th.getMessage()).setTemplateId(e()).setVersionCode(this.f59088j.d()));
        }
    }

    private boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65579, this)) != null) {
            return invokeV.booleanValue;
        }
        if (o() == null) {
            return false;
        }
        FrameLayout frameLayout = (FrameLayout) ((g) this).a.f58877j.findViewById(i());
        com.kwad.sdk.plugin.g gVar = (com.kwad.sdk.plugin.g) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.g.class);
        this.f59088j = gVar;
        if (gVar == null) {
            return true;
        }
        FileInputStream fileInputStream = null;
        try {
            E();
            String a = this.f59088j.a(q());
            File file = new File(a, e());
            com.kwad.sdk.plugin.h a2 = this.f59088j.a(q(), e());
            a(a2, frameLayout);
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                String inputStreamToString = IoUtils.inputStreamToString(fileInputStream2);
                if (inputStreamToString != null) {
                    File file2 = new File(a);
                    a2.a(inputStreamToString, file2.getAbsolutePath() + "/");
                    View view = a2.getView();
                    view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    frameLayout.addView(view);
                    this.f59086h = a2;
                }
                q.a(fileInputStream2);
                return true;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                try {
                    this.f59088j.c();
                    a(th);
                    return false;
                } finally {
                    q.a(fileInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @NonNull
    private b.c w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) ? new b.c(this) { // from class: com.kwad.sdk.reward.presenter.b.a.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.webview.jshandler.b.c
            public void a(@Nullable b.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) {
                    ((g) this.a).a.f58869b.a();
                }
            }
        } : (b.c) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            com.kwad.sdk.core.report.a.c(aVar.f58874g, 17, aVar.f58872e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            com.kwad.sdk.core.report.a.c(aVar.f58874g, 18, aVar.f58872e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            com.kwad.sdk.core.report.a.a(aVar.f58874g, 39, aVar.f58877j.getTouchCoords(), ((g) this).a.f58872e);
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.l = 0L;
            this.f59080b = com.kwad.sdk.core.response.a.d.j(((g) this).a.f58874g);
            ((g) this).a.a(this.m);
            this.f59087i = new f();
            if (v()) {
                return;
            }
            r();
        }
    }

    public void a(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Double.valueOf(d2)}) == null) {
            f fVar = this.f59087i;
            fVar.f57967b = false;
            fVar.f57968c = false;
            fVar.a = (int) Math.ceil(d2 / 1000.0d);
            u();
        }
    }

    public abstract void a(d.a aVar);

    public void a(j.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.c();
            com.kwad.sdk.contentalliance.detail.video.d dVar = this.f59083e;
            if (dVar != null) {
                ((g) this).a.f58878k.b(dVar);
            }
            ((g) this).a.b(this.m);
            j.a aVar = this.n;
            if (aVar != null) {
                ((g) this).a.f58878k.b(aVar);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.d_();
            com.kwad.sdk.plugin.h hVar = this.f59086h;
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    public abstract String e();

    @IdRes
    public abstract int i();

    public abstract void r();

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            f fVar = this.f59087i;
            fVar.f57968c = true;
            fVar.f57967b = false;
            fVar.a = com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.j(this.f59084f.a()));
            u();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f fVar = this.f59087i;
            fVar.f57967b = true;
            fVar.f57968c = false;
            u();
        }
    }

    public void u() {
        k kVar;
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (kVar = this.f59085g) == null || (fVar = this.f59087i) == null) {
            return;
        }
        kVar.a(fVar);
    }
}
