package com.kwad.sdk.contentalliance.detail.photo.newui.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.newui.d.b;
import com.kwad.sdk.contentalliance.detail.photo.newui.d.c;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveStatusResultData;
import com.kwad.sdk.plugin.g;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.photo.f.a<View> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f34861d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34862e;

    /* renamed from: f  reason: collision with root package name */
    public View f34863f;

    /* renamed from: g  reason: collision with root package name */
    public View f34864g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34865h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f34866i;
    public LottieAnimationView j;
    public ImageView k;
    public AnimatorSet l;
    public boolean m;
    public Handler n;
    public i<com.kwad.sdk.live.a.c, LiveStatusResultData> o;
    public LiveStatusResultData.LiveStatus p;
    public boolean q;
    public boolean r;
    public boolean s;
    @Nullable
    public com.kwad.sdk.core.i.a t;
    public ImageView u;
    public b v;
    public volatile boolean w;
    public int x;
    public com.kwad.sdk.contentalliance.a.a y;
    public com.kwad.sdk.core.i.c z;

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
        this.n = new Handler(Looper.getMainLooper());
        this.y = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34868a;

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
                this.f34868a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.j();
                    this.f34868a.m = true;
                    this.f34868a.r();
                    this.f34868a.u.setVisibility(8);
                    com.kwad.sdk.core.d.a.a("PhotoAuthorIconPresenter", "becomesAttachedOnPageSelected");
                    if (this.f34868a.t != null) {
                        this.f34868a.t.a(this.f34868a.z);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.k();
                    this.f34868a.m = false;
                    this.f34868a.p();
                    if (this.f34868a.t != null) {
                        this.f34868a.t.b(this.f34868a.z);
                    }
                }
            }
        };
        this.z = new com.kwad.sdk.core.i.c(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34869a;

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
                this.f34869a = this;
            }

            @Override // com.kwad.sdk.core.i.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f34869a.w) {
                    return;
                }
                this.f34869a.w = true;
                com.kwad.sdk.core.d.a.a("PhotoAuthorIconPresenter", "mTryShowProfileGuider");
                this.f34869a.h();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, this, j) == null) {
            this.f34864g.clearAnimation();
            AnimatorSet animatorSet = new AnimatorSet();
            this.l = animatorSet;
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            this.l.addListener(new AnimatorListenerAdapter(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34878a;

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
                    this.f34878a = this;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        this.f34878a.f34864g.setScaleX(1.0f);
                        this.f34878a.f34864g.setScaleY(1.0f);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) && this.f34878a.m) {
                        this.f34878a.a(0L);
                    }
                }
            });
            this.l.playSequentially(b(this.f34864g));
            this.l.setStartDelay(j);
            this.l.setDuration(1000L);
            this.l.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveStatusResultData.LiveStatus liveStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, liveStatus) == null) {
            this.p = liveStatus;
            this.k.setVisibility(0);
            String q = com.kwad.sdk.core.response.b.c.q(this.f34862e);
            ImageView imageView = this.f34865h;
            KSImageLoader.loadCircleIconWithoutStroke(imageView, q, imageView.getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon_2));
            s();
            a(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65545, this, z) == null) && this.s) {
            PhotoInfo k = com.kwad.sdk.core.response.b.c.k(this.f34862e);
            AdTemplate adTemplate = this.f34862e;
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null) {
                if (z) {
                    e.f(adTemplate, this.x);
                } else {
                    c(3);
                }
                ProfileHomeParam profileHomeParam = new ProfileHomeParam();
                profileHomeParam.mEntryScene = sceneImpl.entryScene;
                profileHomeParam.mAuthorId = d.o(k);
                profileHomeParam.mAuthorIcon = d.r(k);
                profileHomeParam.mAuthorName = d.p(k);
                profileHomeParam.mCurrentPhotoId = d.k(k);
                com.kwad.sdk.contentalliance.profile.home.a.a(o(), profileHomeParam);
                b bVar = this.v;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    private AnimatorSet b(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, view)) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.8f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.8f, 1.0f));
            return animatorSet;
        }
        return (AnimatorSet) invokeL.objValue;
    }

    private void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65550, this, i2) == null) {
            e.a(this.f34862e, 5, i2, this.x);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65559, this) == null) && !this.r && ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.l.getSourceType() == 0) {
            c a2 = c.a();
            AdTemplate adTemplate = this.f34862e;
            a2.a(adTemplate, adTemplate.getShowPosition(), ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34574a.f35248i, new c.a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34870a;

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
                    this.f34870a = this;
                }

                @Override // com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a
                public void a(AdTemplate adTemplate2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, adTemplate2, i2) == null) {
                        com.kwad.sdk.core.d.a.a("PhotoAuthorIconPresenter", "onCall currentPosition = " + i2);
                        a aVar = this.f34870a;
                        aVar.v = new b(aVar.f34865h, this.f34870a.u, this.f34870a.n, new b.a(this, i2) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f34871a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f34872b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i2)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f34872b = this;
                                this.f34871a = i2;
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.photo.newui.d.b.a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f34872b.f34870a.a(-65437);
                                    c.a().a(this.f34871a);
                                    this.f34872b.f34870a.x = c.a().c();
                                    e.e(this.f34872b.f34870a.f34862e, this.f34872b.f34870a.x);
                                }
                            }

                            @Override // com.kwad.sdk.contentalliance.detail.photo.newui.d.b.a
                            public void b() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                    this.f34872b.f34870a.a(-1);
                                }
                            }
                        });
                        this.f34870a.v.a(c.a.ac.d());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            if (this.l != null) {
                this.f34864g.clearAnimation();
                this.l.cancel();
            }
            LottieAnimationView lottieAnimationView = this.j;
            if (lottieAnimationView != null) {
                lottieAnimationView.d();
                this.j.setVisibility(8);
            }
            this.w = false;
            b bVar = this.v;
            if (bVar != null) {
                bVar.a();
            }
            this.x = 0;
            this.k.setVisibility(8);
            this.p = null;
            this.r = false;
            i<com.kwad.sdk.live.a.c, LiveStatusResultData> iVar = this.o;
            if (iVar != null) {
                iVar.e();
            }
            this.n.removeCallbacksAndMessages(null);
        }
    }

    private boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) ? com.kwad.sdk.core.config.c.A() && com.kwad.sdk.core.response.b.c.b(this.f34862e) : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65569, this) == null) && q() && !this.q && this.m) {
            this.q = true;
            i<com.kwad.sdk.live.a.c, LiveStatusResultData> iVar = new i<com.kwad.sdk.live.a.c, LiveStatusResultData>(this, d.o(com.kwad.sdk.core.response.b.c.k(this.f34862e))) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f34873a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f34874b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f34874b = this;
                    this.f34873a = r7;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.sdk.live.a.c b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new com.kwad.sdk.live.a.c(this.f34873a) : (com.kwad.sdk.live.a.c) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public LiveStatusResultData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        LiveStatusResultData liveStatusResultData = new LiveStatusResultData();
                        liveStatusResultData.parseJson(new JSONObject(str));
                        return liveStatusResultData;
                    }
                    return (LiveStatusResultData) invokeL.objValue;
                }
            };
            this.o = iVar;
            iVar.a(new j<com.kwad.sdk.live.a.c, LiveStatusResultData>(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34875a;

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
                    this.f34875a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.live.a.c cVar, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, cVar, i2, str) == null) {
                        this.f34875a.q = false;
                        this.f34875a.r = false;
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.live.a.c cVar, @NonNull LiveStatusResultData liveStatusResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048579, this, cVar, liveStatusResultData) == null) {
                        this.f34875a.n.post(new Runnable(this, liveStatusResultData) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.6.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ LiveStatusResultData f34876a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass6 f34877b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, liveStatusResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f34877b = this;
                                this.f34876a = liveStatusResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f34877b.f34875a.r = true;
                                    this.f34877b.f34875a.a(this.f34876a.liveStatus);
                                    this.f34877b.f34875a.q = false;
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            if (!this.j.c()) {
                this.j.b();
            }
            this.j.setVisibility(0);
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65571, this) == null) || ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j.mAdScene == null || this.p == null || !this.r) {
            return;
        }
        c(9);
        com.kwad.sdk.plugin.d dVar = (com.kwad.sdk.plugin.d) g.a(com.kwad.sdk.plugin.d.class);
        if (dVar != null) {
            dVar.a(o(), this.f34862e, this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f34862e, 13, this.f34861d.getTouchCoords());
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            h hVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34574a;
            if (hVar != null) {
                this.t = hVar.f35240a;
            }
            this.f34862e = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            a(-1);
            e();
            this.f34863f.setOnClickListener(this);
            this.u.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34867a;

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
                    this.f34867a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || ao.a()) {
                        return;
                    }
                    this.f34867a.a(true);
                }
            });
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.y);
        }
    }

    public void a(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f34865h == null) {
            return;
        }
        String q = com.kwad.sdk.core.response.b.c.q(this.f34862e);
        int i3 = com.kwad.sdk.core.response.b.c.c(this.f34862e) ? R.drawable.ksad_default_ad_author_icon : R.drawable.ksad_photo_default_author_icon_2;
        ImageView imageView = this.f34865h;
        KSImageLoader.loadCircleIcon(imageView, q, imageView.getResources().getDrawable(i3));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.y);
            p();
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            this.f34861d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
            this.f34863f = b(R.id.ksad_author_button_container);
            this.f34864g = b(R.id.ksad_author_icon_container);
            this.f34865h = (ImageView) b(R.id.ksad_author_icon);
            this.f34866i = (ImageView) b(R.id.ksad_author_guide_icon);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_live_border_anim);
            this.j = lottieAnimationView;
            lottieAnimationView.setRepeatMode(1);
            this.j.setRepeatCount(-1);
            this.j.setAnimation(R.raw.ksad_live_author_icon);
            this.k = (ImageView) b(R.id.ksad_live_tip_icon);
            this.s = com.kwad.sdk.core.config.c.B();
            ImageView imageView = (ImageView) b(R.id.ksad_profile_guider_img);
            this.u = imageView;
            imageView.setVisibility(8);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String r = com.kwad.sdk.core.response.b.c.r(this.f34862e);
            if (ag.a(r)) {
                this.f34866i.setVisibility(8);
            } else if (!com.kwad.sdk.core.response.b.c.b(this.f34862e) ? !com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.f34862e)) || com.kwad.sdk.core.config.c.T() : this.s) {
                this.f34866i.setVisibility(8);
            } else {
                KSImageLoader.loadImage(this.f34866i, r, this.f34862e);
                this.f34866i.setVisibility(0);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? LayoutInflater.from(o()).inflate(R.layout.ksad_photo_newui_author_icon_view, (ViewGroup) ((com.kwad.sdk.contentalliance.detail.photo.f.a) this).f34793c, false) : (View) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || ao.a()) {
            return;
        }
        if (com.kwad.sdk.core.response.b.c.c(this.f34862e)) {
            if (!com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(this.f34862e)) || com.kwad.sdk.core.config.c.T()) {
                com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f34862e, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.d.a.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f34879a;

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
                        this.f34879a = this;
                    }

                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f34879a.u();
                        }
                    }
                }, ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.o);
            }
            c(0);
        } else if (this.r) {
            t();
        } else {
            a(false);
        }
    }
}
