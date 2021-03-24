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
    public ViewStub f32380d;

    /* renamed from: e  reason: collision with root package name */
    public RelatedVideoPanel f32381e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32382f;

    /* renamed from: g  reason: collision with root package name */
    public SlidePlayViewPager f32383g;

    /* renamed from: h  reason: collision with root package name */
    public AdTemplate f32384h;

    public j(boolean z) {
        this.f32382f = z ? R.layout.ksad_content_photo_related_top_button : R.layout.ksad_content_photo_related_bottom_button;
    }

    private void e() {
        if (this.f32380d == null) {
            return;
        }
        RelatedVideoPanel relatedVideoPanel = this.f32381e;
        if (relatedVideoPanel == null || relatedVideoPanel.getVisibility() != 0) {
            if (this.f32380d.getParent() != null) {
                this.f32381e = (RelatedVideoPanel) this.f32380d.inflate();
            }
            RelatedVideoPanel relatedVideoPanel2 = (RelatedVideoPanel) b(R.id.ksad_related_panel);
            this.f32381e = relatedVideoPanel2;
            relatedVideoPanel2.setRelatedPanelListener(new RelatedVideoPanel.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.j.1
                @Override // com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.a
                public void a() {
                    j.this.f32383g.setEnabled(false);
                    ((com.kwad.sdk.contentalliance.detail.b) j.this).f32132a.n = true;
                }

                @Override // com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.a
                public void b() {
                    j.this.f32383g.setEnabled(true);
                    ((com.kwad.sdk.contentalliance.detail.b) j.this).f32132a.n = false;
                }
            });
            ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32153c.add(this.f32381e);
            RelatedVideoPanel relatedVideoPanel3 = this.f32381e;
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
            relatedVideoPanel3.a(cVar.k, cVar.j);
            this.f32383g.setEnabled(false);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        this.f32383g = cVar.l;
        this.f32384h = cVar.j;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        RelatedVideoPanel relatedVideoPanel = this.f32381e;
        if (relatedVideoPanel != null) {
            ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32153c.remove(relatedVideoPanel);
            this.f32381e.setVisibility(8);
            this.f32381e.b();
        }
        this.f32383g.setEnabled(true);
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32380d = (ViewStub) b(R.id.ksad_related_panel_view_stub);
        ((a) this).f32358b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    public View g() {
        return ao.a((ViewGroup) ((a) this).f32359c, this.f32382f, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j)) {
            p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        } else {
            e();
        }
        com.kwad.sdk.core.report.e.p(this.f32384h);
    }
}
