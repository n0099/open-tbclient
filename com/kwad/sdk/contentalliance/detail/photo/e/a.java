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
    public AdBaseFrameLayout f32289c;

    /* renamed from: d  reason: collision with root package name */
    public CommentListPanel f32290d;

    /* renamed from: e  reason: collision with root package name */
    public CommentBottomAdPanel f32291e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32292f;
    public List<g> l;

    /* renamed from: g  reason: collision with root package name */
    public int f32293g = 0;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f32294h = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void b() {
            a.this.e();
        }
    };
    public com.kwad.sdk.contentalliance.a.a i = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            ((com.kwad.sdk.contentalliance.detail.b) a.this).f32132a.f32158h = false;
            a.this.e();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public View.OnKeyListener f32288b = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.3
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
            ((com.kwad.sdk.contentalliance.detail.b) a.this).f32132a.f32158h = true;
            a.this.a(false);
        }
    };
    public f k = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.5
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.f
        public void a(final int i) {
            com.kwad.sdk.core.download.b.b.a(a.this.f32292f, true);
            com.kwad.sdk.core.download.b.a.a(a.this.f32291e.getContext(), ((com.kwad.sdk.contentalliance.detail.b) a.this).f32132a.j, new a.InterfaceC0378a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.5.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
                public void a() {
                    com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", "CommentPanelAdClickListener onAdClick itemClickType:" + i);
                    com.kwad.sdk.core.report.b.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32132a.j, i, a.this.f32289c.getTouchCoords());
                }
            }, a.this.f32292f);
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
            if (!z || ((com.kwad.sdk.contentalliance.detail.b) a.this).f32132a.f32158h) {
                if (a.this.f32293g == 1) {
                    return;
                }
                a.this.a(false);
            } else if (a.this.f32293g == 2) {
                return;
            } else {
                a.this.f32291e.a(((com.kwad.sdk.contentalliance.detail.b) a.this).f32132a.j, a.this.f32292f);
                com.kwad.sdk.core.report.b.d(((com.kwad.sdk.contentalliance.detail.b) a.this).f32132a.j, 89);
                a.this.f32291e.a(a.this.j);
                a.this.f32293g = 2;
                a.this.f32291e.a(true, false);
            }
            com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", " onShowBottomAdBanner + show:" + z + "  mHasCloseBottomAdBanner: " + ((com.kwad.sdk.contentalliance.detail.b) a.this).f32132a.f32158h);
        }
    };
    public f.a o = new f.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.8
        @Override // com.kwad.sdk.contentalliance.detail.photo.f.f.a
        public void a(@NonNull AdTemplate adTemplate, long j) {
            a.this.f32290d.a(adTemplate, j);
            a.this.f32290d.a();
            a.this.f();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.f32293g = 1;
        this.f32291e.b(this.j);
        this.f32291e.a();
        this.f32291e.a(false, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        cVar.f32157g = false;
        cVar.n = false;
        if (this.f32290d.getVisibility() == 0) {
            this.f32290d.setVisibility(8);
            this.f32290d.setFocusableInTouchMode(false);
            this.f32290d.setOnKeyListener(null);
            this.f32290d.c();
            h();
        }
        a(true);
        this.f32293g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f32290d.setVisibility(0);
        this.f32290d.setFocusableInTouchMode(true);
        this.f32290d.requestFocus();
        this.f32290d.setOnKeyListener(this.f32288b);
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        cVar.f32157g = true;
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
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        this.l = cVar.f32151a.f32793f;
        cVar.f32152b.add(this.i);
        com.kwad.sdk.contentalliance.detail.c cVar2 = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        this.f32292f = cVar2.o;
        com.kwad.sdk.contentalliance.detail.video.b bVar = cVar2.m;
        if (bVar != null) {
            bVar.a(this.f32294h);
        }
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32156f.add(this.o);
        this.f32290d.a(this.m);
        if (com.kwad.sdk.core.config.c.C() && com.kwad.sdk.core.response.b.c.c(((com.kwad.sdk.contentalliance.detail.b) this).f32132a.j)) {
            this.f32290d.a(this.n);
            this.f32290d.a(this.k);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.l = null;
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32152b.remove(this.i);
        ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.f32156f.remove(this.o);
        com.kwad.sdk.contentalliance.detail.video.b bVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a.m;
        if (bVar != null) {
            bVar.b(this.f32294h);
        }
        e();
        this.f32290d.b(this.m);
        this.f32290d.b(this.n);
        this.f32290d.b(this.k);
        this.f32290d.d();
        a(true);
        this.f32293g = 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32290d = (CommentListPanel) b(R.id.ksad_photo_comment_list_panel);
        this.f32289c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32291e = (CommentBottomAdPanel) b(R.id.ksad_photo_comment_bottom_ad_panel);
    }
}
