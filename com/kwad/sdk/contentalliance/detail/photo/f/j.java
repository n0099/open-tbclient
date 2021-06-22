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
    public ViewStub f33051d;

    /* renamed from: e  reason: collision with root package name */
    public RelatedVideoPanel f33052e;

    /* renamed from: f  reason: collision with root package name */
    public final int f33053f;

    /* renamed from: g  reason: collision with root package name */
    public SlidePlayViewPager f33054g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f33055h;

    public j(boolean z) {
        this.f33053f = z ? R.layout.ksad_content_photo_related_top_button : R.layout.ksad_content_photo_related_bottom_button;
    }

    private void e() {
        if (this.f33051d == null) {
            return;
        }
        RelatedVideoPanel relatedVideoPanel = this.f33052e;
        if (relatedVideoPanel == null || relatedVideoPanel.getVisibility() != 0) {
            if (this.f33051d.getParent() != null) {
                this.f33052e = (RelatedVideoPanel) this.f33051d.inflate();
            }
            RelatedVideoPanel relatedVideoPanel2 = (RelatedVideoPanel) b(R.id.ksad_related_panel);
            this.f33052e = relatedVideoPanel2;
            relatedVideoPanel2.setRelatedPanelListener(new RelatedVideoPanel.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.j.1
                @Override // com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.a
                public void a() {
                    j.this.f33054g.setEnabled(false);
                    ((com.kwad.sdk.contentalliance.detail.b) j.this).f32790a.n = true;
                }

                @Override // com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.a
                public void b() {
                    j.this.f33054g.setEnabled(true);
                    ((com.kwad.sdk.contentalliance.detail.b) j.this).f32790a.n = false;
                }
            });
            ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32813c.add(this.f33052e);
            RelatedVideoPanel relatedVideoPanel3 = this.f33052e;
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a;
            relatedVideoPanel3.a(cVar.k, cVar.j);
            this.f33054g.setEnabled(false);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32790a;
        this.f33054g = cVar.l;
        this.f33055h = cVar.j;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        RelatedVideoPanel relatedVideoPanel = this.f33052e;
        if (relatedVideoPanel != null) {
            ((com.kwad.sdk.contentalliance.detail.b) this).f32790a.f32813c.remove(relatedVideoPanel);
            this.f33052e.setVisibility(8);
            this.f33052e.b();
        }
        this.f33054g.setEnabled(true);
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33051d = (ViewStub) b(R.id.ksad_related_panel_view_stub);
        ((a) this).f33029b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    public View g() {
        return ao.a((ViewGroup) ((a) this).f33030c, this.f33053f, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(((com.kwad.sdk.contentalliance.detail.b) this).f32790a.j)) {
            p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        } else {
            e();
        }
        com.kwad.sdk.core.report.e.p(this.f33055h);
    }
}
