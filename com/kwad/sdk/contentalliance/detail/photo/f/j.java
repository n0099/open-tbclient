package com.kwad.sdk.contentalliance.detail.photo.f;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class j extends a<View> {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f32765d;

    /* renamed from: e  reason: collision with root package name */
    public RelatedVideoPanel f32766e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32767f;

    /* renamed from: g  reason: collision with root package name */
    public SlidePlayViewPager f32768g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f32769h;

    public j(boolean z) {
        this.f32767f = z ? R.layout.ksad_content_photo_related_top_button : R.layout.ksad_content_photo_related_bottom_button;
    }

    private void e() {
        if (this.f32765d == null) {
            return;
        }
        RelatedVideoPanel relatedVideoPanel = this.f32766e;
        if (relatedVideoPanel == null || relatedVideoPanel.getVisibility() != 0) {
            if (this.f32765d.getParent() != null) {
                this.f32766e = (RelatedVideoPanel) this.f32765d.inflate();
            }
            RelatedVideoPanel relatedVideoPanel2 = (RelatedVideoPanel) b(R.id.ksad_related_panel);
            this.f32766e = relatedVideoPanel2;
            relatedVideoPanel2.setRelatedPanelListener(new RelatedVideoPanel.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.j.1
                @Override // com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.a
                public void a() {
                    j.this.f32768g.setEnabled(false);
                    ((com.kwad.sdk.contentalliance.detail.b) j.this).f32517a.n = true;
                }

                @Override // com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.a
                public void b() {
                    j.this.f32768g.setEnabled(true);
                    ((com.kwad.sdk.contentalliance.detail.b) j.this).f32517a.n = false;
                }
            });
            ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32538c.add(this.f32766e);
            RelatedVideoPanel relatedVideoPanel3 = this.f32766e;
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
            relatedVideoPanel3.a(cVar.k, cVar.j);
            this.f32768g.setEnabled(false);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
        this.f32768g = cVar.l;
        this.f32769h = cVar.j;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        RelatedVideoPanel relatedVideoPanel = this.f32766e;
        if (relatedVideoPanel != null) {
            ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.f32538c.remove(relatedVideoPanel);
            this.f32766e.setVisibility(8);
            this.f32766e.b();
        }
        this.f32768g.setEnabled(true);
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32765d = (ViewStub) b(R.id.ksad_related_panel_view_stub);
        ((a) this).f32743b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    public View g() {
        return ao.a((ViewGroup) ((a) this).f32744c, this.f32767f, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j)) {
            p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        } else {
            e();
        }
        com.kwad.sdk.core.report.e.p(this.f32769h);
    }
}
