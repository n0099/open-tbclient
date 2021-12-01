package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.sdk.reward.widget.actionbar.ActionBarH5;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes2.dex */
public class a extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KsLogoView f59213b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarAppLandscape f59214c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarAppPortrait f59215d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarH5 f59216e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f59217f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f59218g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f59219h;

    /* renamed from: i  reason: collision with root package name */
    public RewardActionBarControl f59220i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f59221j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f59222k;
    @Nullable
    public ValueAnimator l;
    public RewardActionBarControl.b m;
    public com.kwad.sdk.contentalliance.detail.video.d n;
    public f o;

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
        this.f59221j = false;
        this.m = new RewardActionBarControl.b(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.1
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

            @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
            public void a(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                    this.a.f59222k = true;
                    this.a.b(z);
                }
            }
        };
        this.n = new e(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.2
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

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.c();
                    this.a.f59220i.a(((g) this.a).a.f58878k.f(), ((g) this.a).a.f58878k.g());
                }
            }
        };
        this.o = new f(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.3
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
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.f59222k = false;
                    this.a.c(false);
                }
            }
        };
    }

    private void a(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, view, i2) == null) {
            e();
            view.setVisibility(0);
            ValueAnimator a = az.a(view, 0, i2);
            this.l = a;
            a.setInterpolator(new DecelerateInterpolator(2.0f));
            this.l.setDuration(300L);
            this.l.addListener(new AnimatorListenerAdapter(this, view) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f59223b;

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
                    this.f59223b = this;
                    this.a = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.setVisibility(0);
                    }
                }
            });
            this.l.start();
        }
    }

    private void b(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, this, view, i2) == null) {
            e();
            view.setVisibility(0);
            ValueAnimator a = az.a(view, i2, 0);
            this.l = a;
            a.setInterpolator(new DecelerateInterpolator(2.0f));
            this.l.setDuration(300L);
            this.l.addListener(new AnimatorListenerAdapter(this, view) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f59224b;

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
                    this.f59224b = this;
                    this.a = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.setVisibility(8);
                    }
                }
            });
            this.l.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65543, this, z) == null) || this.f59221j) {
            return;
        }
        this.f59221j = true;
        this.f59213b.setVisibility(0);
        if (!com.kwad.sdk.core.response.a.a.B(this.f59218g)) {
            f(z);
        } else if (((g) this).a.f58873f == 1) {
            d(z);
        } else {
            e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        View view;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65546, this, z) == null) && this.f59221j) {
            this.f59221j = false;
            this.f59213b.setVisibility(8);
            if (com.kwad.sdk.core.response.a.a.B(this.f59218g)) {
                if (((g) this).a.f58873f == 1) {
                    if (!z) {
                        linearLayout = this.f59214c;
                        linearLayout.setVisibility(8);
                        return;
                    }
                    view = this.f59214c;
                } else if (!z) {
                    linearLayout = this.f59215d;
                    linearLayout.setVisibility(8);
                    return;
                } else {
                    view = this.f59215d;
                }
            } else if (!z) {
                this.f59216e.setVisibility(8);
                return;
            } else {
                view = this.f59216e;
            }
            b(view, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
        }
    }

    private void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            this.f59214c.a(this.f59217f, this.f59219h, new ActionBarAppLandscape.a(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.4
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

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppLandscape.a
                public void a(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.a.a(z2);
                    }
                }
            });
            if (z) {
                a(this.f59214c, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
            } else {
                this.f59214c.setVisibility(0);
            }
        }
    }

    private void e() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (valueAnimator = this.l) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.l.cancel();
    }

    private void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, this, z) == null) {
            this.f59215d.a(this.f59217f, this.f59219h, new ActionBarAppPortrait.a(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.5
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

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarAppPortrait.a
                public void a(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.a.a(z2);
                    }
                }
            });
            if (z) {
                a(this.f59215d, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
            } else {
                this.f59215d.setVisibility(0);
            }
        }
    }

    private void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, this, z) == null) {
            this.f59216e.a(this.f59217f, new ActionBarH5.a(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.a.6
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

                @Override // com.kwad.sdk.reward.widget.actionbar.ActionBarH5.a
                public void a(boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                        this.a.a(z2);
                    }
                }
            });
            if (z) {
                a(this.f59216e, com.kwad.sdk.a.kwai.a.a(q(), 90.0f));
            } else {
                this.f59216e.setVisibility(0);
            }
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((g) this).a.f58874g;
            this.f59217f = adTemplate;
            this.f59218g = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f59213b.a(this.f59217f);
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            this.f59219h = aVar.l;
            RewardActionBarControl rewardActionBarControl = aVar.n;
            this.f59220i = rewardActionBarControl;
            rewardActionBarControl.a(this.m);
            ((g) this).a.f58878k.a(this.n);
            ((g) this).a.a(this.o);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f59220i.a((RewardActionBarControl.b) null);
            ((g) this).a.f58878k.b(this.n);
            ((g) this).a.b(this.o);
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f59213b = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
            this.f59214c = (ActionBarAppLandscape) a(R.id.ksad_video_play_bar_app_landscape);
            this.f59215d = (ActionBarAppPortrait) a(R.id.ksad_video_play_bar_app_portrait);
            this.f59216e = (ActionBarH5) a(R.id.ksad_video_play_bar_h5);
        }
    }
}
