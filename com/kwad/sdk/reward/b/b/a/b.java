package com.kwad.sdk.reward.b.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.e;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.b.b.a.a;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.sdk.reward.widget.actionbar.ActionBarH5;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes6.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f36132b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarAppLandscape f36133c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarAppPortrait f36134d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarH5 f36135e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f36136f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f36137g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f36138h;

    /* renamed from: i  reason: collision with root package name */
    public a f36139i;
    public boolean j;
    public boolean k;
    @Nullable
    public ValueAnimator l;
    public a.InterfaceC0440a m;
    public com.kwad.sdk.contentalliance.detail.video.d n;
    public f o;
    public e p;

    public b() {
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
        this.j = false;
        this.m = new a.InterfaceC0440a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36140a;

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
                this.f36140a = this;
            }

            @Override // com.kwad.sdk.reward.b.b.a.a.InterfaceC0440a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    this.f36140a.k = true;
                    this.f36140a.a(z);
                }
            }
        };
        this.n = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.b.b.a.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36141a;

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
                this.f36141a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.c();
                    this.f36141a.f36139i.a(((d) this.f36141a).f36403a.f36080i.j(), ((d) this.f36141a).f36403a.f36080i.k());
                }
            }
        };
        this.o = new f(this) { // from class: com.kwad.sdk.reward.b.b.a.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36142a;

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
                this.f36142a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36142a.k = false;
                    this.f36142a.b(false);
                }
            }
        };
        this.p = new e(this) { // from class: com.kwad.sdk.reward.b.b.a.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36143a;

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
                this.f36143a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36143a.b(true);
                }
            }

            @Override // com.kwad.sdk.reward.a.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f36143a.k) {
                    this.f36143a.a(true);
                }
            }
        };
    }

    private void a(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, view, i2) == null) {
            e();
            view.setVisibility(0);
            ValueAnimator a2 = at.a(view, 0, i2);
            this.l = a2;
            a2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.l.setDuration(300L);
            this.l.addListener(new AnimatorListenerAdapter(this, view) { // from class: com.kwad.sdk.reward.b.b.a.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View f36147a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f36148b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36148b = this;
                    this.f36147a = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f36147a.setVisibility(0);
                    }
                }
            });
            this.l.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65539, this, z) == null) || this.j) {
            return;
        }
        this.j = true;
        this.f36132b.setVisibility(0);
        if (!com.kwad.sdk.core.response.b.a.v(this.f36137g)) {
            e(z);
        } else if (((d) this).f36403a.f36076e == 1) {
            c(z);
        } else {
            d(z);
        }
    }

    private void b(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, this, view, i2) == null) {
            e();
            view.setVisibility(0);
            ValueAnimator a2 = at.a(view, i2, 0);
            this.l = a2;
            a2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.l.setDuration(300L);
            this.l.addListener(new AnimatorListenerAdapter(this, view) { // from class: com.kwad.sdk.reward.b.b.a.b.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View f36149a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f36150b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36150b = this;
                    this.f36149a = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f36149a.setVisibility(8);
                    }
                }
            });
            this.l.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        View view;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65544, this, z) == null) && this.j) {
            this.j = false;
            this.f36132b.setVisibility(8);
            if (com.kwad.sdk.core.response.b.a.v(this.f36137g)) {
                if (((d) this).f36403a.f36076e == 1) {
                    if (!z) {
                        linearLayout = this.f36133c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view = this.f36133c;
                } else if (!z) {
                    linearLayout = this.f36134d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view = this.f36134d;
                }
            } else if (!z) {
                this.f36135e.setVisibility(8);
                return;
            } else {
                view = this.f36135e;
            }
            b(view, av.a(m(), 90.0f));
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            this.f36133c.a(this.f36136f, this.f36138h, new ActionBarAppLandscape.a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f36144a;

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
                    this.f36144a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36144a.f();
                    }
                }
            });
            if (z) {
                a(this.f36133c, av.a(m(), 90.0f));
            } else {
                this.f36133c.setVisibility(0);
            }
        }
    }

    private void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            this.f36134d.a(this.f36136f, this.f36138h, new ActionBarAppPortrait.a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f36145a;

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
                    this.f36145a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36145a.f();
                    }
                }
            });
            if (z) {
                a(this.f36134d, av.a(m(), 90.0f));
            } else {
                this.f36134d.setVisibility(0);
            }
        }
    }

    private void e() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (valueAnimator = this.l) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.l.cancel();
    }

    private void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, this, z) == null) {
            this.f36135e.a(this.f36136f, new ActionBarH5.a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f36146a;

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
                    this.f36146a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36146a.f();
                    }
                }
            });
            if (z) {
                a(this.f36135e, av.a(m(), 90.0f));
            } else {
                this.f36135e.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f36136f, 1, ((d) this).f36403a.f36079h.getTouchCoords(), ((d) this).f36403a.f36075d);
            ((d) this).f36403a.f36073b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((d) this).f36403a.f36077f;
            this.f36136f = adTemplate;
            this.f36137g = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f36132b.a(this.f36136f);
            com.kwad.sdk.reward.a aVar = ((d) this).f36403a;
            this.f36138h = aVar.j;
            a aVar2 = aVar.k;
            this.f36139i = aVar2;
            aVar2.a(this.m);
            ((d) this).f36403a.f36080i.a(this.n);
            ((d) this).f36403a.a(this.o);
            ((d) this).f36403a.o.add(this.p);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f36132b = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
            this.f36133c = (ActionBarAppLandscape) a(R.id.ksad_video_play_bar_app_landscape);
            this.f36134d = (ActionBarAppPortrait) a(R.id.ksad_video_play_bar_app_portrait);
            this.f36135e = (ActionBarH5) a(R.id.ksad_video_play_bar_h5);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f36139i.a((a.InterfaceC0440a) null);
            ((d) this).f36403a.f36080i.b(this.n);
            ((d) this).f36403a.b(this.o);
            ((d) this).f36403a.o.remove(this.p);
            e();
        }
    }
}
