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
    public SlidePlayViewPager f33126b;

    /* renamed from: c  reason: collision with root package name */
    public View f33127c;

    /* renamed from: d  reason: collision with root package name */
    public View f33128d;

    /* renamed from: e  reason: collision with root package name */
    public View f33129e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public View f33130f;

    /* renamed from: g  reason: collision with root package name */
    public int f33131g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.c.b f33132h;
    public AdTemplate i;
    public com.kwad.sdk.contentalliance.home.c.a j = new com.kwad.sdk.contentalliance.home.c.a() { // from class: com.kwad.sdk.contentalliance.home.c.b.c.1
        @Override // com.kwad.sdk.contentalliance.home.c.a
        public void a(int i, View view, boolean z) {
            View view2;
            int i2;
            c.this.f33130f = view;
            if (c.this.f33131g == i) {
                c.this.f33129e.setSelected(!z);
                view2 = c.this.f33129e;
                i2 = 0;
            } else {
                view2 = c.this.f33129e;
                i2 = 8;
            }
            view2.setVisibility(i2);
        }

        @Override // com.kwad.sdk.contentalliance.home.c.a
        public void a(int i, AdTemplate adTemplate) {
            if (c.this.f33131g == i) {
                c.this.f33128d.setSelected(true);
                com.kwad.sdk.contentalliance.detail.video.b c2 = c.this.f33132h.c();
                if (c2 != null) {
                    c.this.f33129e.setSelected(!c2.a());
                    return;
                }
            } else {
                c.this.f33128d.setSelected(false);
            }
            c.this.f33129e.setVisibility(8);
        }
    };

    private void e() {
        e.b((AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36392a).i, 1);
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36392a;
        this.f33126b = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f33113a;
        this.f33130f = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f33114b;
        this.f33131g = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f36391h;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).i;
        this.i = adTemplate;
        com.kwad.sdk.contentalliance.home.c.b bVar = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f33115c;
        this.f33132h = bVar;
        if (adTemplate == bVar.a()) {
            this.f33128d.setSelected(true);
            com.kwad.sdk.contentalliance.detail.video.b c2 = this.f33132h.c();
            if (c2 != null) {
                this.f33129e.setSelected(!c2.a());
                this.f33129e.setVisibility(0);
                this.f33132h.d().add(this.j);
            }
        } else {
            this.f33128d.setSelected(false);
        }
        this.f33129e.setVisibility(8);
        this.f33132h.d().add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33132h.d().remove(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33127c = b(R.id.ksad_slide_profile_container);
        this.f33128d = b(R.id.ksad_slide_profile_selected);
        this.f33129e = b(R.id.ksad_slide_profile_video_play_btn);
        this.f33127c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33127c) {
            if (this.i != this.f33132h.a()) {
                this.f33126b.a(this.i);
            } else {
                View view2 = this.f33130f;
                if (view2 != null) {
                    view2.performClick();
                }
            }
            e();
        }
    }
}
