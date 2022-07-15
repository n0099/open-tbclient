package com.kwad.components.ad.reward.presenter.a.kwai;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.c.f;
import com.kwad.components.ad.reward.c.i;
import com.kwad.components.ad.reward.i.l;
import com.kwad.components.ad.reward.i.r;
import com.kwad.components.ad.reward.i.s;
import com.kwad.components.ad.reward.i.w;
import com.kwad.components.ad.reward.p;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements u.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TailFrameView b;
    public AdTemplate c;
    public AdInfo d;
    @Nullable
    public com.kwad.components.ad.h.b e;
    public boolean f;
    public boolean g;
    public p.b h;
    public l i;
    public s j;
    public com.kwad.components.ad.reward.i.p k;
    public DetailVideoView l;
    public int m;
    public int n;
    public Drawable o;
    public final i p;
    public f q;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.m = Integer.MIN_VALUE;
        this.n = Integer.MIN_VALUE;
        this.p = new i(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.b != null && com.kwad.components.ad.reward.l.c(this.a.c)) {
                    this.a.b.c();
                }
            }
        };
        this.q = new f(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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

            @Override // com.kwad.components.ad.reward.c.f
            public final void d_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (com.kwad.components.ad.reward.kwai.b.c(this.a.d) || com.kwad.components.ad.reward.kwai.b.d(this.a.d) || com.kwad.sdk.core.response.a.a.b(this.a.c)) {
                        com.kwad.components.ad.reward.l.a(((com.kwad.components.ad.reward.presenter.a) this.a).a, this.a.s(), this.a.c, this.a.h);
                    } else if ((!com.kwad.sdk.core.response.a.d.x(this.a.c) && this.a.g && !((com.kwad.components.ad.reward.presenter.a) this.a).a.k()) || ((com.kwad.components.ad.reward.presenter.a) this.a).a.z || ((com.kwad.components.ad.reward.presenter.a) this.a).a.A) {
                    } else {
                        boolean z = com.kwad.sdk.core.response.a.b.A(this.a.c) && com.kwad.components.ad.b.a.a(this.a.c.mPlayAgain) && ((com.kwad.components.ad.reward.presenter.a) this.a).a.w && ((com.kwad.components.ad.reward.presenter.a) this.a).a.d() == 1;
                        this.a.f = true;
                        com.kwad.sdk.core.d.b.a("RewardPlayEndNativeCardPresenter", "onPlayEndPageShow " + z);
                        if (z) {
                            com.kwad.components.ad.h.b bVar = ((com.kwad.components.ad.reward.presenter.a) this.a).a.o;
                            if (bVar != null && bVar.e()) {
                                ((com.kwad.components.ad.reward.presenter.a) this.a).a.b(true);
                                this.a.f = false;
                            }
                            this.a.e();
                        } else if (this.a.e != null && this.a.e.e()) {
                            this.a.f = false;
                        }
                        if (this.a.f) {
                            this.a.b(z);
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65542, this, i) == null) || (layoutParams = this.l.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i;
        this.l.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            s sVar = this.j;
            if (sVar != null) {
                sVar.e();
            } else if (z) {
                this.k.c();
                this.k.b(w.a(this.c));
                ((com.kwad.components.ad.reward.presenter.a) this).a.b(true);
            } else if (!com.kwad.sdk.core.response.a.a.aV(this.d)) {
                this.b.a(new com.kwad.components.ad.reward.widget.tailframe.b(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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

                    @Override // com.kwad.components.ad.reward.widget.tailframe.b
                    public final void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                            this.a.c(z2);
                        }
                    }
                });
                this.b.setVisibility(0);
            } else {
                this.i.c();
                this.i.b(w.a(this.c));
                com.kwad.sdk.core.report.a.c(this.c, 19, (JSONObject) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, this, z) == null) {
            com.kwad.sdk.core.report.a.a(this.c, z ? 2 : 153, ((com.kwad.components.ad.reward.presenter.a) this).a.h.getTouchCoords(), ((com.kwad.components.ad.reward.presenter.a) this).a.e);
            ((com.kwad.components.ad.reward.presenter.a) this).a.b.a();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            boolean ar = com.kwad.sdk.core.response.a.a.ar(this.d);
            boolean v = com.kwad.sdk.core.response.a.d.v(this.c);
            if (ar && v) {
                s sVar = new s(R.id.obfuscated_res_0x7f0910c3);
                this.j = sVar;
                sVar.a(new r.a(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

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

                    @Override // com.kwad.components.ad.reward.i.r.a
                    public final void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.components.ad.reward.b.a().a(PlayableSource.ENDCARD_CLICK, new com.kwad.components.ad.reward.d.a(this.a.u()));
                            com.kwad.sdk.core.report.a.a(((com.kwad.components.ad.reward.presenter.a) this.a).a.g, new com.kwad.sdk.core.report.f().c(67).h(6));
                        }
                    }

                    @Override // com.kwad.components.ad.reward.i.r.a
                    public final void c() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            ((com.kwad.components.ad.reward.presenter.a) this.a).a.a(this.a.u(), 2, 1);
                        }
                    }

                    @Override // com.kwad.components.ad.reward.i.r.a
                    public final void d() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            ((com.kwad.components.ad.reward.presenter.a) this.a).a.a(this.a.u(), 2, 2);
                        }
                    }

                    @Override // com.kwad.components.ad.reward.i.r.a
                    public final void l_() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            new u.b().L = 6;
                        }
                    }
                });
                this.j.a((ViewGroup) q());
                this.j.b(w.a(((com.kwad.components.ad.reward.presenter.a) this).a.g));
                this.j.a(this.d, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.l.post(new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.a.kwai.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

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

                @Override // java.lang.Runnable
                public final void run() {
                    DetailVideoView detailVideoView;
                    int i;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.l == null || ae.e(this.a.u())) {
                        return;
                    }
                    boolean T = com.kwad.sdk.core.response.a.a.T(this.a.d);
                    int c = com.kwad.sdk.b.kwai.a.c(this.a.u());
                    c cVar = this.a;
                    cVar.m = cVar.l.getLayoutParams().width;
                    com.kwad.sdk.core.d.b.a("RewardPlayEndNativeCardPresenter", "setPlayAgainDetailView:  videoOriginalWidth :" + this.a.m);
                    this.a.a(c / 2);
                    c cVar2 = this.a;
                    cVar2.n = cVar2.l.getTextureViewGravity();
                    if (T) {
                        detailVideoView = this.a.l;
                        i = 21;
                    } else {
                        detailVideoView = this.a.l;
                        i = 17;
                    }
                    detailVideoView.a(i);
                    c cVar3 = this.a;
                    cVar3.o = cVar3.l.getBackground();
                    this.a.l.setBackgroundColor(this.a.u().getResources().getColor(R.color.obfuscated_res_0x7f06075b));
                    this.a.g();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (imageView = (ImageView) b(R.id.obfuscated_res_0x7f091005)) == null) {
            return;
        }
        imageView.setVisibility(0);
        com.kwad.components.ad.reward.presenter.b.a(imageView, com.kwad.sdk.core.response.a.a.k(this.d));
    }

    private void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65560, this) == null) && this.f) {
            this.b.d();
            this.b.setVisibility(8);
            this.i.d();
            this.k.d();
        }
    }

    private boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            AdInfo.AdMaterialInfo.MaterialFeature Q = com.kwad.sdk.core.response.a.a.Q(this.d);
            return Q.height > Q.width;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.components.core.playable.a aVar = ((com.kwad.components.ad.reward.presenter.a) this).a.l;
            if (aVar != null) {
                aVar.a(this);
            }
            AdTemplate adTemplate = ((com.kwad.components.ad.reward.presenter.a) this).a.g;
            this.c = adTemplate;
            this.d = com.kwad.sdk.core.response.a.d.i(adTemplate);
            com.kwad.components.ad.reward.l lVar = ((com.kwad.components.ad.reward.presenter.a) this).a;
            this.e = lVar.n;
            lVar.a(this.q);
            com.kwad.components.ad.reward.c.a().a(this.p);
            this.b.setCallerContext(((com.kwad.components.ad.reward.presenter.a) this).a);
            this.b.a(u(), ((com.kwad.components.ad.reward.presenter.a) this).a.f == 0, i());
            ViewStub viewStub = (ViewStub) b(R.id.obfuscated_res_0x7f0910c9);
            this.i = viewStub != null ? new l(((com.kwad.components.ad.reward.presenter.a) this).a, viewStub) : new l(((com.kwad.components.ad.reward.presenter.a) this).a, (ViewGroup) b(R.id.obfuscated_res_0x7f091127));
            ViewStub viewStub2 = (ViewStub) b(R.id.obfuscated_res_0x7f0910ca);
            this.k = viewStub2 != null ? new com.kwad.components.ad.reward.i.p(this.c, ((com.kwad.components.ad.reward.presenter.a) this).a, viewStub2, this.l) : new com.kwad.components.ad.reward.i.p(this.c, ((com.kwad.components.ad.reward.presenter.a) this).a, (ViewGroup) b(R.id.obfuscated_res_0x7f0910aa), this.l);
            d();
        }
    }

    public final void a(p.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.h = bVar;
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.u.b
    public final void a(u.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.g = aVar.a();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i_();
            this.b = (TailFrameView) b(R.id.obfuscated_res_0x7f0911de);
            DetailVideoView detailVideoView = (DetailVideoView) b(R.id.obfuscated_res_0x7f0911da);
            this.l = detailVideoView;
            if (detailVideoView.getLayoutTransition() != null) {
                this.l.getLayoutTransition().enableTransitionType(4);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.k_();
            com.kwad.components.core.playable.a aVar = ((com.kwad.components.ad.reward.presenter.a) this).a.l;
            if (aVar != null) {
                aVar.b(this);
            }
            com.kwad.components.ad.reward.c.a().b(this.p);
            h();
            ((com.kwad.components.ad.reward.presenter.a) this).a.b(this.q);
            DetailVideoView detailVideoView = this.l;
            if (detailVideoView != null) {
                int i = this.n;
                if (i != Integer.MIN_VALUE) {
                    detailVideoView.a(i);
                }
                com.kwad.sdk.core.d.b.a("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.m);
                int i2 = this.m;
                if (i2 != Integer.MIN_VALUE) {
                    a(i2);
                }
                Drawable drawable = this.o;
                if (drawable != null) {
                    this.l.setBackground(drawable);
                }
            }
            com.kwad.components.ad.reward.i.p pVar = this.k;
            if (pVar != null) {
                pVar.e();
            }
        }
    }
}
