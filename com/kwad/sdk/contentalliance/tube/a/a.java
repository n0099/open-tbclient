package com.kwad.sdk.contentalliance.tube.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.profile.TubeProfileParam;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ag;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private FrameLayout f9203b;
    private TextView c;
    private TextView d;
    private TextView e;
    private AdTemplate f;
    private ImageView g;
    private Animation h;
    private AtomicBoolean i = new AtomicBoolean(false);
    private com.kwad.sdk.core.i.c j = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.tube.a.a.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void c_() {
            boolean z = true;
            if (a.this.i.getAndSet(true)) {
                return;
            }
            z = (!com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(a.this.f)) || a.this.f8692a.j.mIsTubeEpisodeList) ? false : false;
            com.kwad.sdk.core.d.a.a("PhotoTubeEnterPresenter", ">> isShowTubeEnter() isShowTubeEnter =" + z);
            if (z) {
                e.k(a.this.f);
            }
        }
    };
    private com.kwad.sdk.contentalliance.a.a k = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.tube.a.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            a.this.i.set(false);
        }
    };

    private void a(long j) {
        this.e.setText(String.format(o().getString(R.string.ksad_tube_enter_paly_count), ag.b(j)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f = this.f8692a.j;
        if (com.kwad.sdk.core.response.b.d.x(com.kwad.sdk.core.response.b.c.k(this.f)) && !this.f8692a.j.mIsTubeEpisodeList) {
            b(com.kwad.sdk.core.response.b.d.B(com.kwad.sdk.core.response.b.c.k(this.f)));
            a(com.kwad.sdk.core.response.b.d.C(com.kwad.sdk.core.response.b.c.k(this.f)));
            this.h = new TranslateAnimation(-5.0f, 5.0f, 0.0f, 0.0f);
            this.h.setDuration(250L);
            this.g.setAnimation(this.h);
            this.h.setRepeatCount(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.h.setRepeatMode(2);
            this.h.startNow();
            a(com.kwad.sdk.core.response.b.d.A(com.kwad.sdk.core.response.b.c.k(this.f)));
            this.f9203b.setOnClickListener(this);
            this.f9203b.setVisibility(0);
        } else {
            this.f9203b.setVisibility(8);
        }
        if (this.f8692a.m != null) {
            this.f8692a.m.a(this.j);
        }
        this.f8692a.f8702b.add(this.k);
    }

    public void a(String str) {
        this.c.setText(str);
    }

    public void b(String str) {
        this.d.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.h != null) {
            this.h.cancel();
        }
        this.f8692a.f8702b.remove(this.k);
        if (this.f8692a.m != null) {
            this.f8692a.m.b(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f9203b = (FrameLayout) b(R.id.ksad_tube_enter_container);
        this.c = (TextView) b(R.id.ksad_tube_enter_name);
        this.d = (TextView) b(R.id.ksad_tube_enter_episode_name);
        this.e = (TextView) b(R.id.ksad_tube_enter_play_count);
        this.g = (ImageView) b(R.id.ksad_tube_enter_arrow);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (o() != null) {
            e.l(this.f);
            PhotoInfo.TubeEpisode y = com.kwad.sdk.core.response.b.d.y(com.kwad.sdk.core.response.b.c.k(this.f));
            TubeProfileParam tubeProfileParam = new TubeProfileParam();
            tubeProfileParam.mTubeEpisode = y;
            if (this.f8692a.j != null && this.f8692a.j.mAdScene != null) {
                tubeProfileParam.mEntryScene = this.f8692a.j.mAdScene.entryScene;
            }
            tubeProfileParam.mAdTemplate = this.f8692a.j;
            com.kwad.sdk.contentalliance.tube.profile.b.a(o(), tubeProfileParam);
        }
    }
}
