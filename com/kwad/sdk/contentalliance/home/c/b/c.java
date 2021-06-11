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
    public SlidePlayViewPager f33329b;

    /* renamed from: c  reason: collision with root package name */
    public View f33330c;

    /* renamed from: d  reason: collision with root package name */
    public View f33331d;

    /* renamed from: e  reason: collision with root package name */
    public View f33332e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public View f33333f;

    /* renamed from: g  reason: collision with root package name */
    public int f33334g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.c.b f33335h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f33336i;
    public com.kwad.sdk.contentalliance.home.c.a j = new com.kwad.sdk.contentalliance.home.c.a() { // from class: com.kwad.sdk.contentalliance.home.c.b.c.1
        @Override // com.kwad.sdk.contentalliance.home.c.a
        public void a(int i2, View view, boolean z) {
            View view2;
            int i3;
            c.this.f33333f = view;
            if (c.this.f33334g == i2) {
                c.this.f33332e.setSelected(!z);
                view2 = c.this.f33332e;
                i3 = 0;
            } else {
                view2 = c.this.f33332e;
                i3 = 8;
            }
            view2.setVisibility(i3);
        }

        @Override // com.kwad.sdk.contentalliance.home.c.a
        public void a(int i2, AdTemplate adTemplate) {
            if (c.this.f33334g == i2) {
                c.this.f33331d.setSelected(true);
                com.kwad.sdk.contentalliance.detail.video.b c2 = c.this.f33335h.c();
                if (c2 != null) {
                    c.this.f33332e.setSelected(!c2.a());
                    return;
                }
            } else {
                c.this.f33331d.setSelected(false);
            }
            c.this.f33332e.setVisibility(8);
        }
    };

    private void e() {
        e.b((AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36713a).f36712i, 1);
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36713a;
        this.f33329b = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f33315a;
        this.f33333f = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f33316b;
        this.f33334g = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f36711h;
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f36712i;
        this.f33336i = adTemplate;
        com.kwad.sdk.contentalliance.home.c.b bVar = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f33317c;
        this.f33335h = bVar;
        if (adTemplate == bVar.a()) {
            this.f33331d.setSelected(true);
            com.kwad.sdk.contentalliance.detail.video.b c2 = this.f33335h.c();
            if (c2 != null) {
                this.f33332e.setSelected(!c2.a());
                this.f33332e.setVisibility(0);
                this.f33335h.d().add(this.j);
            }
        } else {
            this.f33331d.setSelected(false);
        }
        this.f33332e.setVisibility(8);
        this.f33335h.d().add(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f33335h.d().remove(this.j);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33330c = b(R.id.ksad_slide_profile_container);
        this.f33331d = b(R.id.ksad_slide_profile_selected);
        this.f33332e = b(R.id.ksad_slide_profile_video_play_btn);
        this.f33330c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f33330c) {
            if (this.f33336i != this.f33335h.a()) {
                this.f33329b.a(this.f33336i);
            } else {
                View view2 = this.f33333f;
                if (view2 != null) {
                    view2.performClick();
                }
            }
            e();
        }
    }
}
