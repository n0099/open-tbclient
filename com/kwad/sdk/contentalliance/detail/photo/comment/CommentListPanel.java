package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentAdItemView;
import com.kwad.sdk.contentalliance.widget.KSHalfPageLoadingView;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.core.g.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CommentResponse;
import com.kwad.sdk.support.KsRecyclerView;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class CommentListPanel extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView.OnScrollListener f32610a;

    /* renamed from: b  reason: collision with root package name */
    public e f32611b;

    /* renamed from: c  reason: collision with root package name */
    public KsRecyclerView f32612c;

    /* renamed from: d  reason: collision with root package name */
    public d f32613d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f32614e;

    /* renamed from: f  reason: collision with root package name */
    public View f32615f;

    /* renamed from: g  reason: collision with root package name */
    public View f32616g;

    /* renamed from: h  reason: collision with root package name */
    public KSHalfPageLoadingView f32617h;
    public AdTemplate i;
    public List<b> j;
    public List<c> k;
    public List<f> l;
    public boolean m;
    public CommentResponse n;
    public a o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public KSPageLoadingView.a r;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f32623a = -1;

        public void a() {
            this.f32623a = SystemClock.elapsedRealtime();
        }

        public long b() {
            long elapsedRealtime = this.f32623a > 0 ? SystemClock.elapsedRealtime() - this.f32623a : 0L;
            this.f32623a = -1L;
            return elapsedRealtime;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(boolean z);
    }

    public CommentListPanel(Context context) {
        super(context);
        this.f32611b = null;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.o = new a();
        this.p = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentListPanel.this.h();
            }
        };
        this.q = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.r = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.3
            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                CommentListPanel.this.a();
            }
        };
        this.f32610a = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int a2 = com.kwad.sdk.lib.widget.recycler.e.a(recyclerView);
                for (c cVar : CommentListPanel.this.k) {
                    cVar.a(a2 > 0);
                }
            }
        };
        e();
    }

    public CommentListPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32611b = null;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.o = new a();
        this.p = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentListPanel.this.h();
            }
        };
        this.q = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        this.r = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.3
            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                CommentListPanel.this.a();
            }
        };
        this.f32610a = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int a2 = com.kwad.sdk.lib.widget.recycler.e.a(recyclerView);
                for (c cVar : CommentListPanel.this.k) {
                    cVar.a(a2 > 0);
                }
            }
        };
        e();
    }

    private void e() {
        ao.a((ViewGroup) this, R.layout.ksad_content_alliance_comment_list_panel_2, true);
        ((LinearLayout) findViewById(R.id.ksad_photo_comment_list_space)).setOnClickListener(this.p);
        ((ImageButton) findViewById(R.id.ksad_photo_comment_list_panel_close)).setOnClickListener(this.p);
        KsRecyclerView ksRecyclerView = (KsRecyclerView) findViewById(R.id.ksad_photo_comment_list_content);
        this.f32612c = ksRecyclerView;
        ksRecyclerView.setVisibility(8);
        KSHalfPageLoadingView kSHalfPageLoadingView = (KSHalfPageLoadingView) findViewById(R.id.ksad_comment_page_loading);
        this.f32617h = kSHalfPageLoadingView;
        kSHalfPageLoadingView.setRetryClickListener(this.r);
        this.f32617h.a();
        setOnClickListener(this.q);
    }

    private void f() {
        if (this.f32615f == null) {
            this.f32615f = LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_list_footer_2, (ViewGroup) this.f32612c, false);
        }
        TextView textView = (TextView) this.f32615f.findViewById(R.id.ksad_comment_list_footer_tip);
        if (!com.kwad.sdk.core.config.c.X()) {
            this.f32615f.setVisibility(8);
            return;
        }
        if (!this.f32614e.d(this.f32615f)) {
            this.f32614e.c(this.f32615f);
        }
        this.f32615f.setVisibility(0);
        textView.setText(q.a(getContext()));
    }

    private void g() {
        if (this.f32616g == null) {
            this.f32616g = LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_list_header, (ViewGroup) this.f32612c, false);
        }
        CommentAdItemView commentAdItemView = (CommentAdItemView) this.f32616g.findViewById(R.id.ksad_comment_list_header_ad_item);
        if (this.f32614e.e(this.f32616g)) {
            return;
        }
        commentAdItemView.a(this.i, this.l);
        this.f32614e.b(this.f32616g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        for (b bVar : this.j) {
            bVar.a();
        }
    }

    public void a() {
        this.f32612c.setVisibility(8);
        this.f32617h.b();
        e eVar = this.f32611b;
        if (eVar == null) {
            this.f32617h.f();
            return;
        }
        CommentResponse commentResponse = this.n;
        if (commentResponse != null) {
            a(commentResponse);
            this.f32617h.a();
        } else if (this.m) {
        } else {
            this.m = true;
            new com.kwad.sdk.core.g.g().a(eVar.b(), new g.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.5
                @Override // com.kwad.sdk.core.g.g.a
                public void a(int i, String str) {
                    if (com.kwad.sdk.core.network.f.f34255c.k == i) {
                        if (com.kwad.sdk.core.config.c.C()) {
                            CommentListPanel.this.f32617h.a();
                            CommentListPanel.this.a(new CommentResponse());
                        } else {
                            CommentListPanel.this.f32617h.f();
                        }
                        CommentListPanel.this.o.a();
                        com.kwad.sdk.core.report.e.g(CommentListPanel.this.f32611b.a());
                    } else if (com.kwad.sdk.core.network.f.f34253a.k == i) {
                        CommentListPanel.this.f32617h.c();
                    } else {
                        CommentListPanel.this.f32617h.d();
                    }
                    CommentListPanel.this.m = false;
                }

                @Override // com.kwad.sdk.core.g.g.a
                public void a(@NonNull CommentResponse commentResponse2) {
                    CommentListPanel.this.f32617h.a();
                    CommentListPanel.this.n = commentResponse2;
                    CommentListPanel.this.a(commentResponse2);
                    CommentListPanel.this.m = false;
                }
            });
        }
    }

    public void a(@NonNull b bVar) {
        this.j.add(bVar);
    }

    public void a(@NonNull c cVar) {
        this.k.add(cVar);
    }

    public void a(@NonNull f fVar) {
        this.l.add(fVar);
    }

    public void a(@NonNull AdTemplate adTemplate, long j) {
        this.i = adTemplate;
        this.f32611b = new e(adTemplate, j);
    }

    public void a(@NonNull CommentResponse commentResponse) {
        this.f32612c.setItemAnimator(null);
        this.f32612c.setLayoutManager(b());
        this.f32614e = b(commentResponse);
        f();
        this.f32612c.setAdapter(this.f32614e);
        this.f32612c.setVisibility(0);
        if (com.kwad.sdk.core.config.c.C() && com.kwad.sdk.core.response.b.c.c(this.i)) {
            this.f32612c.setOnScrollListener(this.f32610a);
            g();
        }
        this.o.a();
        com.kwad.sdk.core.report.e.g(this.f32611b.a());
    }

    public RecyclerView.LayoutManager b() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        return linearLayoutManager;
    }

    public com.kwad.sdk.lib.widget.recycler.d b(@NonNull CommentResponse commentResponse) {
        this.f32611b.a(commentResponse.rootComments);
        d dVar = new d(getContext(), this.f32611b);
        this.f32613d = dVar;
        return new com.kwad.sdk.lib.widget.recycler.d(dVar);
    }

    public void b(@NonNull b bVar) {
        if (this.j.contains(bVar)) {
            this.j.remove(bVar);
        }
    }

    public void b(@NonNull c cVar) {
        this.k.remove(cVar);
    }

    public void b(@NonNull f fVar) {
        this.l.remove(fVar);
    }

    public void c() {
        d dVar = this.f32613d;
        long a2 = dVar != null ? dVar.a() : 0L;
        if (this.f32611b != null) {
            com.kwad.sdk.core.report.e.a(this.f32611b.a(), a2, this.o.b());
        }
    }

    public void d() {
        this.n = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000a, code lost:
        if (r0 != 2) goto L6;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        int action = motionEvent.getAction();
        boolean z = true;
        if (action != 0) {
            if (action == 1) {
                parent = getParent();
                z = false;
                parent.requestDisallowInterceptTouchEvent(z);
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        parent = getParent();
        parent.requestDisallowInterceptTouchEvent(z);
        return super.dispatchTouchEvent(motionEvent);
    }
}
