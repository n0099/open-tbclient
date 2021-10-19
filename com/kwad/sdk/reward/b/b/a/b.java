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
/* loaded from: classes10.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f73665b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarAppLandscape f73666c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarAppPortrait f73667d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarH5 f73668e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f73669f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f73670g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f73671h;

    /* renamed from: i  reason: collision with root package name */
    public a f73672i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f73673j;
    public boolean k;
    @Nullable
    public ValueAnimator l;
    public a.InterfaceC2017a m;
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
        this.f73673j = false;
        this.m = new a.InterfaceC2017a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f73674a;

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
                this.f73674a = this;
            }

            @Override // com.kwad.sdk.reward.b.b.a.a.InterfaceC2017a
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    this.f73674a.k = true;
                    this.f73674a.a(z);
                }
            }
        };
        this.n = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.b.b.a.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f73675a;

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
                this.f73675a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.c();
                    this.f73675a.f73672i.a(((d) this.f73675a).f73944a.f73610i.j(), ((d) this.f73675a).f73944a.f73610i.k());
                }
            }
        };
        this.o = new f(this) { // from class: com.kwad.sdk.reward.b.b.a.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f73676a;

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
                this.f73676a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f73676a.k = false;
                    this.f73676a.b(false);
                }
            }
        };
        this.p = new e(this) { // from class: com.kwad.sdk.reward.b.b.a.b.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f73677a;

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
                this.f73677a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f73677a.b(true);
                }
            }

            @Override // com.kwad.sdk.reward.a.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f73677a.k) {
                    this.f73677a.a(true);
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
                public final /* synthetic */ View f73681a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f73682b;

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
                    this.f73682b = this;
                    this.f73681a = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f73681a.setVisibility(0);
                    }
                }
            });
            this.l.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65539, this, z) == null) || this.f73673j) {
            return;
        }
        this.f73673j = true;
        this.f73665b.setVisibility(0);
        if (!com.kwad.sdk.core.response.b.a.v(this.f73670g)) {
            e(z);
        } else if (((d) this).f73944a.f73606e == 1) {
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
                public final /* synthetic */ View f73683a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f73684b;

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
                    this.f73684b = this;
                    this.f73683a = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.f73683a.setVisibility(8);
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
        if ((interceptable == null || interceptable.invokeZ(65544, this, z) == null) && this.f73673j) {
            this.f73673j = false;
            this.f73665b.setVisibility(8);
            if (com.kwad.sdk.core.response.b.a.v(this.f73670g)) {
                if (((d) this).f73944a.f73606e == 1) {
                    if (!z) {
                        linearLayout = this.f73666c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view = this.f73666c;
                } else if (!z) {
                    linearLayout = this.f73667d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view = this.f73667d;
                }
            } else if (!z) {
                this.f73668e.setVisibility(8);
                return;
            } else {
                view = this.f73668e;
            }
            b(view, av.a(m(), 90.0f));
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, this, z) == null) {
            this.f73666c.a(this.f73669f, this.f73671h, new ActionBarAppLandscape.a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f73678a;

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
                    this.f73678a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f73678a.f();
                    }
                }
            });
            if (z) {
                a(this.f73666c, av.a(m(), 90.0f));
            } else {
                this.f73666c.setVisibility(0);
            }
        }
    }

    private void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            this.f73667d.a(this.f73669f, this.f73671h, new ActionBarAppPortrait.a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f73679a;

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
                    this.f73679a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f73679a.f();
                    }
                }
            });
            if (z) {
                a(this.f73667d, av.a(m(), 90.0f));
            } else {
                this.f73667d.setVisibility(0);
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
            this.f73668e.a(this.f73669f, new ActionBarH5.a(this) { // from class: com.kwad.sdk.reward.b.b.a.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f73680a;

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
                    this.f73680a = this;
                }

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f73680a.f();
                    }
                }
            });
            if (z) {
                a(this.f73668e, av.a(m(), 90.0f));
            } else {
                this.f73668e.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f73669f, 1, ((d) this).f73944a.f73609h.getTouchCoords(), ((d) this).f73944a.f73605d);
            ((d) this).f73944a.f73603b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((d) this).f73944a.f73607f;
            this.f73669f = adTemplate;
            this.f73670g = com.kwad.sdk.core.response.b.c.i(adTemplate);
            this.f73665b.a(this.f73669f);
            com.kwad.sdk.reward.a aVar = ((d) this).f73944a;
            this.f73671h = aVar.f73611j;
            a aVar2 = aVar.k;
            this.f73672i = aVar2;
            aVar2.a(this.m);
            ((d) this).f73944a.f73610i.a(this.n);
            ((d) this).f73944a.a(this.o);
            ((d) this).f73944a.o.add(this.p);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f73665b = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
            this.f73666c = (ActionBarAppLandscape) a(R.id.ksad_video_play_bar_app_landscape);
            this.f73667d = (ActionBarAppPortrait) a(R.id.ksad_video_play_bar_app_portrait);
            this.f73668e = (ActionBarH5) a(R.id.ksad_video_play_bar_h5);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f73672i.a((a.InterfaceC2017a) null);
            ((d) this).f73944a.f73610i.b(this.n);
            ((d) this).f73944a.b(this.o);
            ((d) this).f73944a.o.remove(this.p);
            e();
        }
    }
}
