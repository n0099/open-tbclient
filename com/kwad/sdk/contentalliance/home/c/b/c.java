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
    public SlidePlayViewPager f33031b;

    /* renamed from: c  reason: collision with root package name */
    public View f33032c;

    /* renamed from: d  reason: collision with root package name */
    public View f33033d;

    /* renamed from: e  reason: collision with root package name */
    public View f33034e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public View f33035f;

    /* renamed from: g  reason: collision with root package name */
    public int f33036g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.c.b f33037h;
    public AdTemplate i;
    public com.kwad.sdk.contentalliance.home.c.a j = new com.kwad.sdk.contentalliance.home.c.a() { // from class: com.kwad.sdk.contentalliance.home.c.b.c.1
        @Override // com.kwad.sdk.contentalliance.home.c.a
        public void a(int i, View view, boolean z) {
            View view2;
            int i2;
            c.this.f33035f = view;
            if (c.this.f33036g == i) {
                c.this.f33034e.setSelected(!z);
                view2 = c.this.f33034e;
                i2 = 0;
            } else {
                view2 = c.this.f33034e;
                i2 = 8;
            }
            view2.setVisibility(i2);
        }

        @Override // com.kwad.sdk.contentalliance.home.c.a
        public void a(int i, AdTemplate adTemplate) {
            if (c.this.f33036g == i) {
                c.this.f33033d.setSelected(true);
                com.kwad.sdk.contentalliance.detail.video.b c2 = c.this.f33037h.c();
                if (c2 != null) {
                    c.this.f33034e.setSelected(!c2.a());
                    return;
                }
            } else {
                c.this.f33033d.setSelected(false);
            }
            c.this.f33034e.setVisibility(8);
        }
    };

    private void e() {
        e.b((AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).i, 1);
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a;
        this.f33031b = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f33018a;
        this.f33035f = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f33019b;
        this.f33036g = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f36296h;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).i;
        this.i = adTemplate;
        com.kwad.sdk.contentalliance.home.c.b bVar = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f33020c;
        this.f33037h = bVar;
        if (adTemplate == bVar.a()) {
            this.f33033d.setSelected(true);
            com.kwad.sdk.contentalliance.detail.video.b c2 = this.f33037h.c();
            if (c2 != null) {
                this.f33034e.setSelected(!c2.a());
                this.f33034e.setVisibility(0);
                this.f33037h.d().add(this.j);
            }
        } else {
            this.f33033d.setSelected(false);
        }
        this.f33034e.setVisibility(8);
        this.f33037h.d().add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33037h.d().remove(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33032c = b(R.id.ksad_slide_profile_container);
        this.f33033d = b(R.id.ksad_slide_profile_selected);
        this.f33034e = b(R.id.ksad_slide_profile_video_play_btn);
        this.f33032c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33032c) {
            if (this.i != this.f33037h.a()) {
                this.f33031b.a(this.i);
            } else {
                View view2 = this.f33035f;
                if (view2 != null) {
                    view2.performClick();
                }
            }
            e();
        }
    }
}
