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
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.b.b.a.a;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.sdk.reward.widget.actionbar.ActionBarH5;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes7.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f38866b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarAppLandscape f38867c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarAppPortrait f38868d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarH5 f38869e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f38870f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f38871g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f38872h;

    /* renamed from: i  reason: collision with root package name */
    public a f38873i;
    public boolean j;
    public boolean k;
    @Nullable
    public ValueAnimator l;
    public a.InterfaceC0479a m;
    public e n;
    public com.kwad.sdk.reward.a.e o;
    public com.kwad.sdk.reward.a.d p;

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
        this.m = new a.InterfaceC0479a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f38874a;

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
                this.f38874a = this;
            }

            @Override // com.kwad.sdk.reward.b.b.a.a.InterfaceC0479a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    this.f38874a.k = true;
                    this.f38874a.a(z);
                }
            }
        };
        this.n = new f(this) { // from class: com.kwad.sdk.reward.b.b.a.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f38875a;

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
                this.f38875a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.b();
                    this.f38875a.f38873i.a(((d) this.f38875a).f39062a.f38819i.i(), ((d) this.f38875a).f39062a.f38819i.j());
                }
            }
        };
        this.o = new com.kwad.sdk.reward.a.e(this) { // from class: com.kwad.sdk.reward.b.b.a.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f38876a;

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
                this.f38876a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f38876a.k = false;
                    this.f38876a.b(false);
                }
            }
        };
        this.p = new com.kwad.sdk.reward.a.d(this) { // from class: com.kwad.sdk.reward.b.b.a.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f38877a;

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
                this.f38877a = this;
            }

            @Override // com.kwad.sdk.reward.a.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f38877a.b(true);
                }
            }

            @Override // com.kwad.sdk.reward.a.d
            public void b() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f38877a.k) {
                    this.f38877a.a(true);
                }
            }
        };
    }

    private void a(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, view, i2) == null) {
            e();
            view.setVisibility(0);
            ValueAnimator a2 = am.a(view, 0, i2);
            this.l = a2;
            a2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.l.setDuration(300L);
            this.l.addListener(new AnimatorListenerAdapter(this, view) { // from class: com.kwad.sdk.reward.b.b.a.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View f38881a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f38882b;

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
                    this.f38882b = this;
                    this.f38881a = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f38881a.setVisibility(0);
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
        this.f38866b.setVisibility(0);
        if (!com.kwad.sdk.core.response.b.a.y(this.f38871g)) {
            e(z);
        } else if (((d) this).f39062a.f38815e == 1) {
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
            ValueAnimator a2 = am.a(view, i2, 0);
            this.l = a2;
            a2.setInterpolator(new DecelerateInterpolator(2.0f));
            this.l.setDuration(300L);
            this.l.addListener(new AnimatorListenerAdapter(this, view) { // from class: com.kwad.sdk.reward.b.b.a.b.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View f38883a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f38884b;

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
                    this.f38884b = this;
                    this.f38883a = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f38883a.setVisibility(8);
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
            this.f38866b.setVisibility(8);
            if (com.kwad.sdk.core.response.b.a.y(this.f38871g)) {
                if (((d) this).f39062a.f38815e == 1) {
                    if (!z) {
                        linearLayout = this.f38867c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view = this.f38867c;
                } else if (!z) {
                    linearLayout = this.f38868d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view = this.f38868d;
                }
            } else if (!z) {
                this.f38869e.setVisibility(8);
                return;
            } else {
                view = this.f38869e;
            }
            b(view, ao.a(o(), 90.0f));
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            this.f38867c.a(this.f38870f, this.f38872h, new ActionBarAppLandscape.a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f38878a;

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
                    this.f38878a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38878a.f();
                    }
                }
            });
            if (z) {
                a(this.f38867c, ao.a(o(), 90.0f));
            } else {
                this.f38867c.setVisibility(0);
            }
        }
    }

    private void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            this.f38868d.a(this.f38870f, this.f38872h, new ActionBarAppPortrait.a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f38879a;

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
                    this.f38879a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38879a.f();
                    }
                }
            });
            if (z) {
                a(this.f38868d, ao.a(o(), 90.0f));
            } else {
                this.f38868d.setVisibility(0);
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
            this.f38869e.a(this.f38870f, new ActionBarH5.a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f38880a;

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
                    this.f38880a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f38880a.f();
                    }
                }
            });
            if (z) {
                a(this.f38869e, ao.a(o(), 90.0f));
            } else {
                this.f38869e.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f38870f, 1, ((d) this).f39062a.f38818h.getTouchCoords(), ((d) this).f39062a.f38814d);
            ((d) this).f39062a.f38812b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((d) this).f39062a.f38816f;
            this.f38870f = adTemplate;
            this.f38871g = com.kwad.sdk.core.response.b.c.j(adTemplate);
            this.f38866b.a(this.f38870f);
            com.kwad.sdk.reward.a aVar = ((d) this).f39062a;
            this.f38872h = aVar.j;
            a aVar2 = aVar.k;
            this.f38873i = aVar2;
            aVar2.a(this.m);
            ((d) this).f39062a.f38819i.a(this.n);
            ((d) this).f39062a.n.add(this.o);
            ((d) this).f39062a.o.add(this.p);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f38873i.a((a.InterfaceC0479a) null);
            ((d) this).f39062a.f38819i.b(this.n);
            ((d) this).f39062a.n.remove(this.o);
            ((d) this).f39062a.o.remove(this.p);
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f38866b = (KsLogoView) b(R.id.ksad_ad_label_play_bar);
            this.f38867c = (ActionBarAppLandscape) b(R.id.ksad_video_play_bar_app_landscape);
            this.f38868d = (ActionBarAppPortrait) b(R.id.ksad_video_play_bar_app_portrait);
            this.f38869e = (ActionBarH5) b(R.id.ksad_video_play_bar_h5);
        }
    }
}
