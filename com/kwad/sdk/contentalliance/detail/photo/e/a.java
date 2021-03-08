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
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b {
    private AdBaseFrameLayout c;
    private CommentListPanel d;
    private CommentBottomAdPanel e;
    @Nullable
    private com.kwad.sdk.core.download.b.b f;
    private List<g> l;
    private int g = 0;
    private com.kwad.sdk.core.i.c h = new com.kwad.sdk.core.i.d() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.1
        @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
        public void b() {
            a.this.e();
        }
    };
    private com.kwad.sdk.contentalliance.a.a i = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.2
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            a.this.f5594a.h = false;
            a.this.e();
        }
    };
    View.OnKeyListener b = new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.3
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1) {
                a.this.e();
                return true;
            }
            return false;
        }
    };
    private CommentBottomAdPanel.a j = new CommentBottomAdPanel.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.4
        @Override // com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.a
        public void a() {
            com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", " mCommentBottomAdPanel PanelCloseListener close");
            a.this.f5594a.h = true;
            a.this.a(false);
        }
    };
    private f k = new f() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.5
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.f
        public void a(final int i) {
            com.kwad.sdk.core.download.b.b.a(a.this.f, true);
            com.kwad.sdk.core.download.b.a.a(a.this.e.getContext(), a.this.f5594a.j, new a.InterfaceC1111a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.5.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1111a
                public void a() {
                    com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", "CommentPanelAdClickListener onAdClick itemClickType:" + i);
                    com.kwad.sdk.core.report.b.a(a.this.f5594a.j, i, a.this.c.getTouchCoords());
                }
            }, a.this.f);
        }
    };
    private CommentListPanel.b m = new CommentListPanel.b() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.6
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.b
        public void a() {
            a.this.e();
        }
    };
    private CommentListPanel.c n = new CommentListPanel.c() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.7
        @Override // com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.c
        public void a(boolean z) {
            if (!z || a.this.f5594a.h) {
                if (a.this.g == 1) {
                    return;
                }
                a.this.a(false);
            } else if (a.this.g == 2) {
                return;
            } else {
                a.this.e.a(a.this.f5594a.j, a.this.f);
                com.kwad.sdk.core.report.b.d(a.this.f5594a.j, 89);
                a.this.e.a(a.this.j);
                a.this.g = 2;
                a.this.e.a(true, false);
            }
            com.kwad.sdk.core.d.a.a("PhotoCommentListPresenter", " onShowBottomAdBanner + show:" + z + "  mHasCloseBottomAdBanner: " + a.this.f5594a.h);
        }
    };
    private f.a o = new f.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.e.a.8
        @Override // com.kwad.sdk.contentalliance.detail.photo.f.f.a
        public void a(@NonNull AdTemplate adTemplate, long j) {
            a.this.d.a(adTemplate, j);
            a.this.d.a();
            a.this.f();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.g = 1;
        this.e.b(this.j);
        this.e.a();
        this.e.a(false, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f5594a.g = false;
        this.f5594a.n = false;
        if (this.d.getVisibility() == 0) {
            this.d.setVisibility(8);
            this.d.setFocusableInTouchMode(false);
            this.d.setOnKeyListener(null);
            this.d.c();
            h();
        }
        a(true);
        this.g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.d.setVisibility(0);
        this.d.setFocusableInTouchMode(true);
        this.d.requestFocus();
        this.d.setOnKeyListener(this.b);
        this.f5594a.g = true;
        this.f5594a.n = true;
        g();
    }

    private void g() {
        if (this.l != null) {
            for (g gVar : this.l) {
                gVar.a();
            }
        }
    }

    private void h() {
        if (this.l != null) {
            for (g gVar : this.l) {
                gVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.l = this.f5594a.f5600a.f;
        this.f5594a.b.add(this.i);
        this.f = this.f5594a.o;
        if (this.f5594a.m != null) {
            this.f5594a.m.a(this.h);
        }
        this.f5594a.f.add(this.o);
        this.d.a(this.m);
        if (com.kwad.sdk.core.config.c.C() && com.kwad.sdk.core.response.b.c.c(this.f5594a.j)) {
            this.d.a(this.n);
            this.d.a(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.l = null;
        this.f5594a.b.remove(this.i);
        this.f5594a.f.remove(this.o);
        if (this.f5594a.m != null) {
            this.f5594a.m.b(this.h);
        }
        e();
        this.d.b(this.m);
        this.d.b(this.n);
        this.d.b(this.k);
        this.d.d();
        a(true);
        this.g = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d = (CommentListPanel) b(R.id.ksad_photo_comment_list_panel);
        this.c = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.e = (CommentBottomAdPanel) b(R.id.ksad_photo_comment_bottom_ad_panel);
    }
}
