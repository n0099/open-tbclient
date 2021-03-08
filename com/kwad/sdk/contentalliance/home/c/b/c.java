package com.kwad.sdk.contentalliance.home.c.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class c extends com.kwad.sdk.contentalliance.home.c.a.a implements View.OnClickListener {
    private SlidePlayViewPager b;
    private View c;
    private View d;
    private View e;
    @Nullable
    private View f;
    private int g;
    private com.kwad.sdk.contentalliance.home.c.b h;
    private AdTemplate i;
    private com.kwad.sdk.contentalliance.home.c.a j = new com.kwad.sdk.contentalliance.home.c.a() { // from class: com.kwad.sdk.contentalliance.home.c.b.c.1
        @Override // com.kwad.sdk.contentalliance.home.c.a
        public void a(int i, View view, boolean z) {
            c.this.f = view;
            if (c.this.g != i) {
                c.this.e.setVisibility(8);
                return;
            }
            c.this.e.setSelected(!z);
            c.this.e.setVisibility(0);
        }

        @Override // com.kwad.sdk.contentalliance.home.c.a
        public void a(int i, AdTemplate adTemplate) {
            if (c.this.g != i) {
                c.this.d.setSelected(false);
                c.this.e.setVisibility(8);
                return;
            }
            c.this.d.setSelected(true);
            com.kwad.sdk.contentalliance.detail.video.b c = c.this.h.c();
            if (c == null) {
                c.this.e.setVisibility(8);
            } else {
                c.this.e.setSelected(c.a() ? false : true);
            }
        }
    };

    private void e() {
        e.b((AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) this.f6892a).i, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b = ((com.kwad.sdk.contentalliance.home.c.a.b) this.f6892a).f5811a;
        this.f = ((com.kwad.sdk.contentalliance.home.c.a.b) this.f6892a).b;
        this.g = ((com.kwad.sdk.contentalliance.home.c.a.b) this.f6892a).h;
        this.i = (AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) this.f6892a).i;
        this.h = ((com.kwad.sdk.contentalliance.home.c.a.b) this.f6892a).c;
        if (this.i == this.h.a()) {
            this.d.setSelected(true);
            com.kwad.sdk.contentalliance.detail.video.b c = this.h.c();
            if (c == null) {
                this.e.setVisibility(8);
            } else {
                this.e.setSelected(!c.a());
                this.e.setVisibility(0);
            }
        } else {
            this.d.setSelected(false);
            this.e.setVisibility(8);
        }
        this.h.d().add(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.h.d().remove(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.c = b(R.id.ksad_slide_profile_container);
        this.d = b(R.id.ksad_slide_profile_selected);
        this.e = b(R.id.ksad_slide_profile_video_play_btn);
        this.c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c) {
            if (this.i != this.h.a()) {
                this.b.a(this.i);
            } else if (this.f != null) {
                this.f.performClick();
            }
            e();
        }
    }
}
