package com.kwad.sdk.contentalliance.detail.photo.e;

import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel;
import com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel;
import com.kwad.sdk.contentalliance.detail.photo.comment.f;
import com.kwad.sdk.contentalliance.detail.photo.comment.g;
import com.kwad.sdk.contentalliance.detail.photo.f.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.List;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: c  reason: collision with root package name */
    public AdBaseFrameLayout f32290c;

    /* renamed from: d  reason: collision with root package name */
    public CommentListPanel f32291d;

    /* renamed from: e  reason: collision with root package name */
    public CommentBottomAdPanel f32292e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32293f;
    public List<g> l;

    /* renamed from: g  reason: collision with root package name */
    public int f32294g = 0;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f32295h = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void b() {
            a.this.e();
        }
    };
    public com.kwad.sdk.contentalliance.a.a i = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            ((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.f32159h = false;
            a.this.e();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public View.OnKeyListener f32289b = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.3
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                a.this.e();
                return true;
            }
            return false;
        }
    };
    public CommentBottomAdPanel.a j = new CommentBottomAdPanel.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.4
        @Override // com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.a
        public void a() {
            com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", " mCommentBottomAdPanel PanelCloseListener close");
            ((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.f32159h = true;
            a.this.a(false);
        }
    };
    public f k = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.5
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.f
        public void a(final int i) {
            com.kwad.sdk.core.download.b.b.a(a.this.f32293f, true);
            com.kwad.sdk.core.download.b.a.a(a.this.f32292e.getContext(), ((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.j, new a.InterfaceC0379a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.5.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", "CommentPanelAdClickListener onAdClick itemClickType:" + i);
                    com.kwad.sdk.core.report.b.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.j, i, a.this.f32290c.getTouchCoords());
                }
            }, a.this.f32293f);
        }
    };
    public CommentListPanel.b m = new CommentListPanel.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.6
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.b
        public void a() {
            a.this.e();
        }
    };
    public CommentListPanel.c n = new CommentListPanel.c() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.7
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.c
        public void a(boolean z) {
            if (!z || ((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.f32159h) {
                if (a.this.f32294g == 1) {
                    return;
                }
                a.this.a(false);
            } else if (a.this.f32294g == 2) {
                return;
            } else {
                a.this.f32292e.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.j, a.this.f32293f);
                com.kwad.sdk.core.report.b.d(((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.j, 89);
                a.this.f32292e.a(a.this.j);
                a.this.f32294g = 2;
                a.this.f32292e.a(true, false);
            }
            com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", " onShowBottomAdBanner + show:" + z + "  mHasCloseBottomAdBanner: " + ((com.kwad.sdk.contentalliance.detail.b) a.this).f32133a.f32159h);
        }
    };
    public f.a o = new f.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.8
        @Override // com.kwad.sdk.contentalliance.detail.photo.f.f.a
        public void a(@NonNull AdTemplate adTemplate, long j) {
            a.this.f32291d.a(adTemplate, j);
            a.this.f32291d.a();
            a.this.f();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f32294g = 1;
        this.f32292e.b(this.j);
        this.f32292e.a();
        this.f32292e.a(false, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        cVar.f32158g = false;
        cVar.n = false;
        if (this.f32291d.getVisibility() == 0) {
            this.f32291d.setVisibility(8);
            this.f32291d.setFocusableInTouchMode(false);
            this.f32291d.setOnKeyListener(null);
            this.f32291d.c();
            h();
        }
        a(true);
        this.f32294g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f32291d.setVisibility(0);
        this.f32291d.setFocusableInTouchMode(true);
        this.f32291d.requestFocus();
        this.f32291d.setOnKeyListener(this.f32289b);
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        cVar.f32158g = true;
        cVar.n = true;
        g();
    }

    private void g() {
        List<g> list = this.l;
        if (list != null) {
            for (g gVar : list) {
                gVar.a();
            }
        }
    }

    private void h() {
        List<g> list = this.l;
        if (list != null) {
            for (g gVar : list) {
                gVar.b();
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        this.l = cVar.f32152a.f32794f;
        cVar.f32153b.add(this.i);
        com.kwad.sdk.contentalliance.detail.c cVar2 = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        this.f32293f = cVar2.o;
        com.kwad.sdk.contentalliance.detail.video.b bVar = cVar2.m;
        if (bVar != null) {
            bVar.a(this.f32295h);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32157f.add(this.o);
        this.f32291d.a(this.m);
        if (com.kwad.sdk.core.config.c.C() && com.kwad.sdk.core.response.b.c.c(((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j)) {
            this.f32291d.a(this.n);
            this.f32291d.a(this.k);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.l = null;
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32153b.remove(this.i);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.f32157f.remove(this.o);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.m;
        if (bVar != null) {
            bVar.b(this.f32295h);
        }
        e();
        this.f32291d.b(this.m);
        this.f32291d.b(this.n);
        this.f32291d.b(this.k);
        this.f32291d.d();
        a(true);
        this.f32294g = 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32291d = (CommentListPanel) b(R.id.ksad_photo_comment_list_panel);
        this.f32290c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32292e = (CommentBottomAdPanel) b(R.id.ksad_photo_comment_bottom_ad_panel);
    }
}
