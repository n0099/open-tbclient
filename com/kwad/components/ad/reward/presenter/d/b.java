package com.kwad.components.ad.reward.presenter.d;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.c.i;
import com.kwad.components.ad.reward.i.c;
import com.kwad.components.ad.reward.i.e;
import com.kwad.components.ad.reward.i.v;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.l.f;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.t;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes5.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a implements c.a, f.a, com.kwad.sdk.core.webview.a.kwai.a, com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static float b = 0.4548105f;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ViewGroup c;
    @Nullable
    public v d;
    public f e;
    public com.kwad.components.ad.reward.g.a.a f;
    public ViewGroup g;
    public e h;
    public c i;
    @Nullable
    public c j;
    public int k;
    public long l;
    public boolean m;
    public final i n;
    public com.kwad.sdk.core.lifecycle.b o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1857023214, "Lcom/kwad/components/ad/reward/presenter/d/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1857023214, "Lcom/kwad/components/ad/reward/presenter/d/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 15;
        this.l = -1L;
        this.m = false;
        this.n = new i(this) { // from class: com.kwad.components.ad.reward.presenter.d.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // com.kwad.components.ad.reward.c.i
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.i != null && l.c(((com.kwad.components.ad.reward.presenter.a) this.a).a.g)) {
                        this.a.i.b();
                    }
                    if (this.a.j != null) {
                        this.a.j.b();
                    }
                }
            }
        };
        this.o = new com.kwad.sdk.core.lifecycle.c(this) { // from class: com.kwad.components.ad.reward.presenter.d.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
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

            @Override // com.kwad.sdk.core.lifecycle.c, com.kwad.sdk.core.lifecycle.b
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.a();
                    this.a.b(true);
                }
            }

            @Override // com.kwad.sdk.core.lifecycle.c, com.kwad.sdk.core.lifecycle.b
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.b();
                    this.a.b(false);
                }
            }
        };
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, adBaseFrameLayout) == null) {
            if (!ae.e(u())) {
                com.kwad.sdk.core.d.b.a("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
                return;
            }
            ((ViewStub) b(R.id.obfuscated_res_0x7f0910f2)).inflate();
            ViewGroup viewGroup = (ViewGroup) b(R.id.obfuscated_res_0x7f0910e8);
            this.g = viewGroup;
            viewGroup.setClickable(true);
            new com.kwad.sdk.widget.f(this.g, this);
            KSFrameLayout kSFrameLayout = (KSFrameLayout) b(R.id.obfuscated_res_0x7f0910e9);
            kSFrameLayout.setRadius(u().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a9));
            kSFrameLayout.post(new Runnable(this, kSFrameLayout, u().getResources().getDimension(R.dimen.obfuscated_res_0x7f0703a4)) { // from class: com.kwad.components.ad.reward.presenter.d.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ KSFrameLayout a;
                public final /* synthetic */ float b;
                public final /* synthetic */ b c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, kSFrameLayout, Float.valueOf(r8)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = kSFrameLayout;
                    this.b = r8;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.getHeight();
                    }
                }
            });
            ViewGroup viewGroup2 = (ViewGroup) b(R.id.obfuscated_res_0x7f0910e8);
            this.g = viewGroup2;
            c cVar = new c(viewGroup2);
            this.i = cVar;
            cVar.a(((com.kwad.components.ad.reward.presenter.a) this).a.k);
            this.i.a(this);
            this.i.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, false);
            e eVar = new e((KsAdWebView) b(R.id.obfuscated_res_0x7f0910e7), this.g, ((com.kwad.components.ad.reward.presenter.a) this).a.k, this);
            this.h = eVar;
            eVar.a(new com.kwad.components.ad.reward.i.f(this) { // from class: com.kwad.components.ad.reward.presenter.d.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.ad.reward.i.f
                public final void a(String str, int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i) == null) {
                        int i2 = d.i(((com.kwad.components.ad.reward.presenter.a) this.a).a.g).status;
                        com.kwad.sdk.core.d.b.a("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + i2);
                        this.a.i.a(str, i);
                    }
                }
            });
            this.h.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, adBaseFrameLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        com.kwad.components.ad.reward.g.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, this, z) == null) {
            com.kwad.components.ad.reward.g.a.a.a(this.f, u(), ((com.kwad.components.ad.reward.presenter.a) this).a.g);
            if (!this.f.k()) {
                if (z) {
                    c(false);
                }
            } else if (!z) {
                this.l = System.currentTimeMillis();
            } else {
                boolean e = e();
                if (e && (aVar = this.f) != null) {
                    aVar.j();
                    com.kwad.components.ad.reward.c.a().b();
                    ((com.kwad.components.ad.reward.presenter.a) this).a.b.e();
                }
                c(e);
            }
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            com.kwad.sdk.core.d.b.a("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.m + " completed: " + z);
            if (this.m) {
                return;
            }
            t.a(u(), z ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
            if (z) {
                this.m = true;
            }
        }
    }

    private void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, this, z) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.a(u(), z ? 1 : 153, 1);
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            com.kwad.sdk.core.d.b.a("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.l);
            return this.l >= 0 && System.currentTimeMillis() - this.l > ((long) (this.k * 1000));
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.b.a("LaunchAppTaskPresenter", "onBind");
            AdTemplate adTemplate = ((com.kwad.components.ad.reward.presenter.a) this).a.g;
            if (d.a(adTemplate, com.kwad.components.ad.reward.kwai.b.d(d.i(adTemplate)))) {
                this.k = com.kwad.components.ad.reward.kwai.b.d();
                com.kwad.sdk.core.lifecycle.a.c();
                com.kwad.sdk.core.lifecycle.a.a(this.o);
                com.kwad.components.ad.reward.c.a().a(this.n);
                com.kwad.components.ad.reward.g.a.a a = com.kwad.components.ad.reward.g.d.a();
                this.f = a;
                ((com.kwad.components.ad.reward.presenter.a) this).a.B = a;
                com.kwad.components.ad.reward.g.a.a.a(a, u(), ((com.kwad.components.ad.reward.presenter.a) this).a.g);
                AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) b(R.id.obfuscated_res_0x7f091182);
                ViewGroup viewGroup = (ViewGroup) b(R.id.obfuscated_res_0x7f090fd8);
                this.c = viewGroup;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                    c cVar = new c(this.c);
                    this.j = cVar;
                    cVar.a(((com.kwad.components.ad.reward.presenter.a) this).a.k);
                    this.j.a(this);
                    this.j.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, false);
                    ((KSFrameLayout) b(R.id.obfuscated_res_0x7f09117f)).setWidthBasedRatio(false);
                    v vVar = new v((KsAdWebView) b(R.id.obfuscated_res_0x7f09117e), this.c, ((com.kwad.components.ad.reward.presenter.a) this).a.k, this);
                    this.d = vVar;
                    vVar.a(((com.kwad.components.ad.reward.presenter.a) this).a.g, adBaseFrameLayout);
                }
                AdInfo i = d.i(((com.kwad.components.ad.reward.presenter.a) this).a.g);
                f fVar = this.e;
                if (fVar == null) {
                    this.e = new f(com.kwad.sdk.core.response.a.a.C(i));
                } else {
                    fVar.a(com.kwad.sdk.core.response.a.a.C(i));
                }
                this.e.a(u(), this);
                a(adBaseFrameLayout);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
        }
    }

    @Override // com.kwad.components.ad.reward.i.c.a
    public final void a(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(u(), z ? 1 : 153, 1);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            d(true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && com.kwad.sdk.core.response.a.c.d(((com.kwad.components.ad.reward.presenter.a) this).a.g)) {
            d(false);
        }
    }

    @Override // com.kwad.components.core.l.f.a
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            if (lVar.B == null || !l.a(lVar.g)) {
                return;
            }
            ((com.kwad.components.ad.reward.presenter.a) this).a.B.i();
            com.kwad.sdk.core.lifecycle.a.c();
            if (com.kwad.sdk.core.lifecycle.a.d()) {
                return;
            }
            this.l = System.currentTimeMillis();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.k_();
            com.kwad.sdk.core.d.b.a("LaunchAppTaskPresenter", "onUnbind");
            com.kwad.sdk.core.lifecycle.a.c();
            com.kwad.sdk.core.lifecycle.a.b(this.o);
            com.kwad.components.ad.reward.c.a().b(this.n);
            f fVar = this.e;
            if (fVar != null) {
                fVar.a(u());
            }
            e eVar = this.h;
            if (eVar != null) {
                eVar.a();
                this.h = null;
            }
            c cVar = this.j;
            if (cVar != null) {
                cVar.a();
            }
            ((com.kwad.components.ad.reward.presenter.a) this).a.B = null;
        }
    }
}
