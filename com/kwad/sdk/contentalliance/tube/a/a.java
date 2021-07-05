package com.kwad.sdk.contentalliance.tube.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.profile.TubeProfileParam;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ag;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f35592b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35593c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f35594d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35595e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f35596f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35597g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f35598h;

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f35599i;
    public com.kwad.sdk.core.i.c j;
    public com.kwad.sdk.contentalliance.a.a k;

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
        this.f35599i = new AtomicBoolean(false);
        this.j = new com.kwad.sdk.core.i.d(this) { // from class: com.kwad.sdk.contentalliance.tube.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35600a;

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
                this.f35600a = this;
            }

            @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    boolean z = true;
                    if (this.f35600a.f35599i.getAndSet(true)) {
                        return;
                    }
                    z = (!com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(this.f35600a.f35596f)) || ((com.kwad.sdk.contentalliance.detail.b) this.f35600a).f34553a.j.mIsTubeEpisodeList) ? false : false;
                    com.kwad.sdk.core.d.a.a("PhotoTubeEnterPresenter", ">> isShowTubeEnter() isShowTubeEnter =" + z);
                    if (z) {
                        e.k(this.f35600a.f35596f);
                    }
                }
            }
        };
        this.k = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.tube.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35601a;

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
                this.f35601a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35601a.f35599i.set(false);
                }
            }
        };
    }

    private void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            this.f35595e.setText(String.format(o().getString(R.string.ksad_tube_enter_paly_count), ag.b(j)));
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
            this.f35596f = adTemplate;
            int i2 = 0;
            if (com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(adTemplate)) && !((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j.mIsTubeEpisodeList) {
                b(com.kwad.sdk.core.response.b.d.B(com.kwad.sdk.core.response.b.c.k(this.f35596f)));
                a(com.kwad.sdk.core.response.b.d.C(com.kwad.sdk.core.response.b.c.k(this.f35596f)));
                TranslateAnimation translateAnimation = new TranslateAnimation(-5.0f, 5.0f, 0.0f, 0.0f);
                this.f35598h = translateAnimation;
                translateAnimation.setDuration(250L);
                this.f35597g.setAnimation(this.f35598h);
                this.f35598h.setRepeatCount(Integer.MAX_VALUE);
                this.f35598h.setRepeatMode(2);
                this.f35598h.startNow();
                a(com.kwad.sdk.core.response.b.d.A(com.kwad.sdk.core.response.b.c.k(this.f35596f)));
                this.f35592b.setOnClickListener(this);
                frameLayout = this.f35592b;
            } else {
                frameLayout = this.f35592b;
                i2 = 8;
            }
            frameLayout.setVisibility(i2);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                bVar.a(this.j);
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.k);
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f35593c.setText(str);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f35594d.setText(str);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.b_();
            Animation animation = this.f35598h;
            if (animation != null) {
                animation.cancel();
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.k);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.m;
            if (bVar != null) {
                bVar.b(this.j);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.c();
            this.f35592b = (FrameLayout) b(R.id.ksad_tube_enter_container);
            this.f35593c = (TextView) b(R.id.ksad_tube_enter_name);
            this.f35594d = (TextView) b(R.id.ksad_tube_enter_episode_name);
            this.f35595e = (TextView) b(R.id.ksad_tube_enter_play_count);
            this.f35597g = (ImageView) b(R.id.ksad_tube_enter_arrow);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SceneImpl sceneImpl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view) == null) || o() == null) {
            return;
        }
        e.l(this.f35596f);
        PhotoInfo.TubeEpisode y = com.kwad.sdk.core.response.b.d.y(com.kwad.sdk.core.response.b.c.k(this.f35596f));
        TubeProfileParam tubeProfileParam = new TubeProfileParam();
        tubeProfileParam.mTubeEpisode = y;
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
        if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
            tubeProfileParam.mEntryScene = sceneImpl.entryScene;
        }
        tubeProfileParam.mAdTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j;
        com.kwad.sdk.contentalliance.tube.profile.b.a(o(), tubeProfileParam);
    }
}
