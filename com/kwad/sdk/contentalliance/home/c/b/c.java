package com.kwad.sdk.contentalliance.home.c.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.contentalliance.home.c.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public SlidePlayViewPager f32741b;

    /* renamed from: c  reason: collision with root package name */
    public View f32742c;

    /* renamed from: d  reason: collision with root package name */
    public View f32743d;

    /* renamed from: e  reason: collision with root package name */
    public View f32744e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public View f32745f;

    /* renamed from: g  reason: collision with root package name */
    public int f32746g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.c.b f32747h;
    public AdTemplate i;
    public com.kwad.sdk.contentalliance.home.c.a j = new com.kwad.sdk.contentalliance.home.c.a() { // from class: com.kwad.sdk.contentalliance.home.c.b.c.1
        @Override // com.kwad.sdk.contentalliance.home.c.a
        public void a(int i, View view, boolean z) {
            View view2;
            int i2;
            c.this.f32745f = view;
            if (c.this.f32746g == i) {
                c.this.f32744e.setSelected(!z);
                view2 = c.this.f32744e;
                i2 = 0;
            } else {
                view2 = c.this.f32744e;
                i2 = 8;
            }
            view2.setVisibility(i2);
        }

        @Override // com.kwad.sdk.contentalliance.home.c.a
        public void a(int i, AdTemplate adTemplate) {
            if (c.this.f32746g == i) {
                c.this.f32743d.setSelected(true);
                com.kwad.sdk.contentalliance.detail.video.b c2 = c.this.f32747h.c();
                if (c2 != null) {
                    c.this.f32744e.setSelected(!c2.a());
                    return;
                }
            } else {
                c.this.f32743d.setSelected(false);
            }
            c.this.f32744e.setVisibility(8);
        }
    };

    private void e() {
        e.b((AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a).i, 1);
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36007a;
        this.f32741b = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f32728a;
        this.f32745f = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f32729b;
        this.f32746g = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f36006h;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).i;
        this.i = adTemplate;
        com.kwad.sdk.contentalliance.home.c.b bVar = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f32730c;
        this.f32747h = bVar;
        if (adTemplate == bVar.a()) {
            this.f32743d.setSelected(true);
            com.kwad.sdk.contentalliance.detail.video.b c2 = this.f32747h.c();
            if (c2 != null) {
                this.f32744e.setSelected(!c2.a());
                this.f32744e.setVisibility(0);
                this.f32747h.d().add(this.j);
            }
        } else {
            this.f32743d.setSelected(false);
        }
        this.f32744e.setVisibility(8);
        this.f32747h.d().add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32747h.d().remove(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32742c = b(R.id.ksad_slide_profile_container);
        this.f32743d = b(R.id.ksad_slide_profile_selected);
        this.f32744e = b(R.id.ksad_slide_profile_video_play_btn);
        this.f32742c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32742c) {
            if (this.i != this.f32747h.a()) {
                this.f32741b.a(this.i);
            } else {
                View view2 = this.f32745f;
                if (view2 != null) {
                    view2.performClick();
                }
            }
            e();
        }
    }
}
