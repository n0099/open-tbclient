package com.kwad.sdk.contentalliance.home.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ap;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.home.e implements ap.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35082b;

    /* renamed from: c  reason: collision with root package name */
    public AnimatorSet f35083c;

    /* renamed from: d  reason: collision with root package name */
    public ap f35084d;

    /* renamed from: e  reason: collision with root package name */
    public View f35085e;

    /* renamed from: f  reason: collision with root package name */
    public View f35086f;

    /* renamed from: g  reason: collision with root package name */
    public View f35087g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f35088h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f35089i;
    public ImageView j;
    public ViewStub k;
    public int l;
    public HandlerThread m;

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
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void a(AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65539, this, adTemplate, z) == null) && adTemplate != null && com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            if (this.f35085e == null) {
                this.f35085e = this.k.inflate();
            }
            this.f35086f = this.f35085e.findViewById(R.id.ksad_home_banner_close_btn);
            this.f35088h = (TextView) this.f35085e.findViewById(R.id.ksad_home_banner_ad_content);
            this.f35089i = (TextView) this.f35085e.findViewById(R.id.ksad_home_banner_ad_link_btn);
            this.f35087g = this.f35085e.findViewById(R.id.ksad_home_banner_ad_link_btn_layout);
            this.j = (ImageView) this.f35085e.findViewById(R.id.ksad_home_banner_ad_img);
            com.kwad.sdk.glide.c.b(o()).a(com.kwad.sdk.core.response.b.c.q(adTemplate)).a(com.kwad.sdk.glide.load.engine.h.f38085a).a((com.kwad.sdk.glide.load.h<Bitmap>) new com.kwad.sdk.contentalliance.widget.a(o(), ao.a(o(), 4.0f), 0, 1, Color.parseColor("#eaeaea"), 15)).a(this.j);
            this.f35088h.setText(String.format(o().getString(z ? R.string.ksad_home_banner_installed_format : R.string.ksad_home_banner_uninstalled_format), com.kwad.sdk.core.response.b.a.q(com.kwad.sdk.core.response.b.c.j(adTemplate))));
            this.f35089i.setText(z ? "立即体验" : "安装");
            this.f35085e.setTranslationY(this.l);
            this.f35082b = new com.kwad.sdk.core.download.b.b(adTemplate);
            this.f35087g.setOnClickListener(new View.OnClickListener(this, z, adTemplate) { // from class: com.kwad.sdk.contentalliance.home.b.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f35096a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f35097b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f35098c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35098c = this;
                    this.f35096a = z;
                    this.f35097b = adTemplate;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdTemplate adTemplate2;
                    int i2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f35096a) {
                            com.kwad.sdk.core.download.b.b bVar = this.f35098c.f35082b;
                            if (bVar != null) {
                                bVar.d();
                            }
                            adTemplate2 = this.f35097b;
                            i2 = 47;
                        } else {
                            com.kwad.sdk.core.download.b.b bVar2 = this.f35098c.f35082b;
                            if (bVar2 != null) {
                                bVar2.e();
                            }
                            adTemplate2 = this.f35097b;
                            i2 = 45;
                        }
                        com.kwad.sdk.core.report.b.c(adTemplate2, i2);
                        this.f35098c.e();
                    }
                }
            });
            this.f35086f.setOnClickListener(new View.OnClickListener(this, adTemplate, z) { // from class: com.kwad.sdk.contentalliance.home.b.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f35099a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f35100b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ b f35101c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adTemplate, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35101c = this;
                    this.f35099a = adTemplate;
                    this.f35100b = z;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        com.kwad.sdk.core.report.b.c(this.f35099a, this.f35100b ? 48 : 46);
                        this.f35101c.e();
                    }
                }
            });
            a(true);
            com.kwad.sdk.core.report.b.d(adTemplate, z ? 93 : 92, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            a(false);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            HandlerThread handlerThread = new HandlerThread("HomeAdBannerPresenter");
            this.m = handlerThread;
            handlerThread.start();
            ap apVar = new ap(this, this.m.getLooper());
            this.f35084d = apVar;
            apVar.sendEmptyMessageDelayed(6666, c.a.ad.f());
        }
    }

    @Override // com.kwad.sdk.utils.ap.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            int i2 = message.what;
            if (i2 != 6666) {
                if (i2 == 8888) {
                    ak.a(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.b.b.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ b f35095a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35095a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f35095a.e();
                            }
                        }
                    });
                    com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "handleMsg MSG_BANNER_SHOW_DURATION hideBanner");
                }
            } else if (com.kwad.sdk.home.download.a.a().e()) {
            } else {
                com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "handleMsg MSG_CHECK_DELAY");
                AdTemplate b2 = com.kwad.sdk.home.download.a.a().b();
                if (b2 != null) {
                    ak.a(new Runnable(this, b2) { // from class: com.kwad.sdk.contentalliance.home.b.b.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdTemplate f35091a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f35092b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, b2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35092b = this;
                            this.f35091a = b2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f35092b.a(this.f35091a, false);
                            }
                        }
                    });
                    com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "handleMsg MSG_CHECK_DELAY downloadData not null, showBanner");
                    com.kwad.sdk.home.download.a.a().a(com.kwad.sdk.core.response.b.a.s(com.kwad.sdk.core.response.b.c.j(b2)));
                    this.f35084d.sendEmptyMessageDelayed(8888, c.a.ad.g());
                    return;
                }
                AdTemplate c2 = com.kwad.sdk.home.download.a.a().c();
                if (c2 != null) {
                    ak.a(new Runnable(this, c2) { // from class: com.kwad.sdk.contentalliance.home.b.b.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdTemplate f35093a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f35094b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, c2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35094b = this;
                            this.f35093a = c2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f35094b.a(this.f35093a, true);
                            }
                        }
                    });
                    com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "handleMsg MSG_CHECK_DELAY installedData not null, showBanner");
                    com.kwad.sdk.home.download.a.a().a(com.kwad.sdk.core.response.b.a.s(com.kwad.sdk.core.response.b.c.j(c2)));
                    this.f35084d.sendEmptyMessageDelayed(8888, c.a.ad.g());
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            AnimatorSet animatorSet = this.f35083c;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.f35083c.removeAllListeners();
                this.f35083c.cancel();
            }
            this.f35083c = new AnimatorSet();
            com.kwad.sdk.core.d.a.a("HomeAdBannerPresenter", "bottomViewAnimate + isShow : " + z);
            View view = this.f35085e;
            String name = View.TRANSLATION_Y.getName();
            float[] fArr = new float[1];
            fArr[0] = z ? 0.0f : this.l;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, name, fArr);
            ofFloat.setDuration(z ? 300L : 260L);
            this.f35083c.playTogether(ofFloat);
            this.f35083c.removeAllListeners();
            this.f35083c.addListener(new AnimatorListenerAdapter(this, z) { // from class: com.kwad.sdk.contentalliance.home.b.b.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f35102a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f35103b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35103b = this;
                    this.f35102a = z;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationCancel(animator);
                        this.f35103b.f35085e.setVisibility(this.f35102a ? 4 : 0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        if (this.f35102a) {
                            return;
                        }
                        this.f35103b.f35085e.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
                public void onAnimationPause(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        super.onAnimationPause(animator);
                        this.f35103b.f35085e.setVisibility(this.f35102a ? 4 : 0);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                        super.onAnimationStart(animator);
                        if (this.f35102a) {
                            this.f35103b.f35085e.setVisibility(0);
                        }
                    }
                }
            });
            this.f35083c.start();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.b_();
            this.f35084d.removeCallbacksAndMessages(null);
            com.kwad.sdk.core.download.b.b bVar = this.f35082b;
            if (bVar != null) {
                bVar.f();
            }
            com.kwad.sdk.utils.f.a(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.b.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35090a;

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
                    this.f35090a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.home.download.a.a().d();
                    }
                }
            });
            this.m.quit();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.c();
            this.k = (ViewStub) b(R.id.ksad_home_banner_layout_vs);
            this.l = -ao.a(o(), 100.0f);
        }
    }
}
