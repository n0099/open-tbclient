package com.kwad.sdk.contentalliance.tube.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.profile.TubeProfileParam;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ag;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f33411b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33412c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33413d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33414e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33415f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33416g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f33417h;
    public AtomicBoolean i = new AtomicBoolean(false);
    public com.kwad.sdk.core.i.c j = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.tube.a.a.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            boolean z = true;
            if (a.this.i.getAndSet(true)) {
                return;
            }
            z = (!com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(a.this.f33415f)) || ((com.kwad.sdk.contentalliance.detail.b) a.this).f32422a.j.mIsTubeEpisodeList) ? false : false;
            com.kwad.sdk.core.d.a.a("PhotoTubeEnterPresenter", ">> isShowTubeEnter() isShowTubeEnter =" + z);
            if (z) {
                e.k(a.this.f33415f);
            }
        }
    };
    public com.kwad.sdk.contentalliance.a.a k = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.tube.a.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            a.this.i.set(false);
        }
    };

    private void a(long j) {
        this.f33414e.setText(String.format(o().getString(R.string.ksad_tube_enter_paly_count), ag.b(j)));
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        FrameLayout frameLayout;
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j;
        this.f33415f = adTemplate;
        int i = 0;
        if (com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(adTemplate)) && !((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j.mIsTubeEpisodeList) {
            b(com.kwad.sdk.core.response.b.d.B(com.kwad.sdk.core.response.b.c.k(this.f33415f)));
            a(com.kwad.sdk.core.response.b.d.C(com.kwad.sdk.core.response.b.c.k(this.f33415f)));
            TranslateAnimation translateAnimation = new TranslateAnimation(-5.0f, 5.0f, 0.0f, 0.0f);
            this.f33417h = translateAnimation;
            translateAnimation.setDuration(250L);
            this.f33416g.setAnimation(this.f33417h);
            this.f33417h.setRepeatCount(Integer.MAX_VALUE);
            this.f33417h.setRepeatMode(2);
            this.f33417h.startNow();
            a(com.kwad.sdk.core.response.b.d.A(com.kwad.sdk.core.response.b.c.k(this.f33415f)));
            this.f33411b.setOnClickListener(this);
            frameLayout = this.f33411b;
        } else {
            frameLayout = this.f33411b;
            i = 8;
        }
        frameLayout.setVisibility(i);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.m;
        if (bVar != null) {
            bVar.a(this.j);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.add(this.k);
    }

    public void a(String str) {
        this.f33412c.setText(str);
    }

    public void b(String str) {
        this.f33413d.setText(str);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Animation animation = this.f33417h;
        if (animation != null) {
            animation.cancel();
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.f32442b.remove(this.k);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.m;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33411b = (FrameLayout) b(R.id.ksad_tube_enter_container);
        this.f33412c = (TextView) b(R.id.ksad_tube_enter_name);
        this.f33413d = (TextView) b(R.id.ksad_tube_enter_episode_name);
        this.f33414e = (TextView) b(R.id.ksad_tube_enter_play_count);
        this.f33416g = (ImageView) b(R.id.ksad_tube_enter_arrow);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SceneImpl sceneImpl;
        if (o() != null) {
            e.l(this.f33415f);
            PhotoInfo.TubeEpisode y = com.kwad.sdk.core.response.b.d.y(com.kwad.sdk.core.response.b.c.k(this.f33415f));
            TubeProfileParam tubeProfileParam = new TubeProfileParam();
            tubeProfileParam.mTubeEpisode = y;
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j;
            if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                tubeProfileParam.mEntryScene = sceneImpl.entryScene;
            }
            tubeProfileParam.mAdTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a.j;
            com.kwad.sdk.contentalliance.tube.profile.b.a(o(), tubeProfileParam);
        }
    }
}
