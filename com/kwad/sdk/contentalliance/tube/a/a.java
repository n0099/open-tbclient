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
    public FrameLayout f33122b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33123c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33124d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33125e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33126f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f33127g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f33128h;
    public AtomicBoolean i = new AtomicBoolean(false);
    public com.kwad.sdk.core.i.c j = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.tube.a.a.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            boolean z = true;
            if (a.this.i.getAndSet(true)) {
                return;
            }
            z = (!com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(a.this.f33126f)) || ((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.j.mIsTubeEpisodeList) ? false : false;
            com.kwad.sdk.core.d.a.a("PhotoTubeEnterPresenter", ">> isShowTubeEnter() isShowTubeEnter =" + z);
            if (z) {
                e.k(a.this.f33126f);
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
        this.f33125e.setText(String.format(o().getString(R.string.ksad_tube_enter_paly_count), ag.b(j)));
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        FrameLayout frameLayout;
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j;
        this.f33126f = adTemplate;
        int i = 0;
        if (com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(adTemplate)) && !((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j.mIsTubeEpisodeList) {
            b(com.kwad.sdk.core.response.b.d.B(com.kwad.sdk.core.response.b.c.k(this.f33126f)));
            a(com.kwad.sdk.core.response.b.d.C(com.kwad.sdk.core.response.b.c.k(this.f33126f)));
            TranslateAnimation translateAnimation = new TranslateAnimation(-5.0f, 5.0f, 0.0f, 0.0f);
            this.f33128h = translateAnimation;
            translateAnimation.setDuration(250L);
            this.f33127g.setAnimation(this.f33128h);
            this.f33128h.setRepeatCount(Integer.MAX_VALUE);
            this.f33128h.setRepeatMode(2);
            this.f33128h.startNow();
            a(com.kwad.sdk.core.response.b.d.A(com.kwad.sdk.core.response.b.c.k(this.f33126f)));
            this.f33122b.setOnClickListener(this);
            frameLayout = this.f33122b;
        } else {
            frameLayout = this.f33122b;
            i = 8;
        }
        frameLayout.setVisibility(i);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.m;
        if (bVar != null) {
            bVar.a(this.j);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.add(this.k);
    }

    public void a(String str) {
        this.f33123c.setText(str);
    }

    public void b(String str) {
        this.f33124d.setText(str);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        Animation animation = this.f33128h;
        if (animation != null) {
            animation.cancel();
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.remove(this.k);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.m;
        if (bVar != null) {
            bVar.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33122b = (FrameLayout) b(R.id.ksad_tube_enter_container);
        this.f33123c = (TextView) b(R.id.ksad_tube_enter_name);
        this.f33124d = (TextView) b(R.id.ksad_tube_enter_episode_name);
        this.f33125e = (TextView) b(R.id.ksad_tube_enter_play_count);
        this.f33127g = (ImageView) b(R.id.ksad_tube_enter_arrow);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SceneImpl sceneImpl;
        if (o() != null) {
            e.l(this.f33126f);
            PhotoInfo.TubeEpisode y = com.kwad.sdk.core.response.b.d.y(com.kwad.sdk.core.response.b.c.k(this.f33126f));
            TubeProfileParam tubeProfileParam = new TubeProfileParam();
            tubeProfileParam.mTubeEpisode = y;
            AdTemplate adTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j;
            if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                tubeProfileParam.mEntryScene = sceneImpl.entryScene;
            }
            tubeProfileParam.mAdTemplate = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j;
            com.kwad.sdk.contentalliance.tube.profile.b.a(o(), tubeProfileParam);
        }
    }
}
