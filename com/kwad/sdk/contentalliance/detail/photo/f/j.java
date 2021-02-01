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
/* loaded from: classes3.dex */
public class j extends a<View> {
    @Nullable
    private ViewStub d;
    private RelatedVideoPanel e;
    private final int f;
    private SlidePlayViewPager g;
    private AdTemplate h;

    public j(boolean z) {
        this.f = z ? R.layout.ksad_content_photo_related_top_button : R.layout.ksad_content_photo_related_bottom_button;
    }

    private void e() {
        if (this.d == null) {
            return;
        }
        if (this.e == null || this.e.getVisibility() != 0) {
            if (this.d.getParent() != null) {
                this.e = (RelatedVideoPanel) this.d.inflate();
            }
            this.e = (RelatedVideoPanel) b(R.id.ksad_related_panel);
            this.e.setRelatedPanelListener(new RelatedVideoPanel.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.j.1
                @Override // com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.a
                public void a() {
                    j.this.g.setEnabled(false);
                    j.this.f8395a.n = true;
                }

                @Override // com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.a
                public void b() {
                    j.this.g.setEnabled(true);
                    j.this.f8395a.n = false;
                }
            });
            this.f8395a.c.add(this.e);
            this.e.a(this.f8395a.k, this.f8395a.j);
            this.g.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.g = this.f8395a.l;
        this.h = this.f8395a.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.e != null) {
            this.f8395a.c.remove(this.e);
            this.e.setVisibility(8);
            this.e.b();
        }
        this.g.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.photo.f.a, com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d = (ViewStub) b(R.id.ksad_related_panel_view_stub);
        this.f8516b.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.contentalliance.detail.photo.f.d
    public View g() {
        return ao.a((ViewGroup) this.c, this.f, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f8395a.j)) {
            p.a(view.getContext(), view.getContext().getString(R.string.ksad_ad_function_disable));
        } else {
            e();
        }
        com.kwad.sdk.core.report.e.p(this.h);
    }
}
