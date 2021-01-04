package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes5.dex */
public class CommentListPanel extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView.OnScrollListener f8738a;

    /* renamed from: b  reason: collision with root package name */
    private e f8739b;
    private KsRecyclerView c;
    private d d;
    private com.kwad.sdk.lib.widget.recycler.d e;
    private View f;
    private View g;
    private KSHalfPageLoadingView h;
    private AdTemplate i;
    private List<b> j;
    private List<c> k;
    private List<f> l;
    private boolean m;
    private CommentResponse n;
    private a o;
    private View.OnClickListener p;
    private View.OnClickListener q;
    private KSPageLoadingView.a r;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f8745a = -1;

        a() {
        }

        void a() {
            this.f8745a = SystemClock.elapsedRealtime();
        }

        long b() {
            long elapsedRealtime = this.f8745a > 0 ? SystemClock.elapsedRealtime() - this.f8745a : 0L;
            this.f8745a = -1L;
            return elapsedRealtime;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(boolean z);
    }

    public CommentListPanel(Context context) {
        super(context);
        this.f8739b = null;
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
        this.f8738a = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.4
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
        this.f8739b = null;
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
        this.f8738a = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.4
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
        this.c = (KsRecyclerView) findViewById(R.id.ksad_photo_comment_list_content);
        this.c.setVisibility(8);
        this.h = (KSHalfPageLoadingView) findViewById(R.id.ksad_comment_page_loading);
        this.h.setRetryClickListener(this.r);
        this.h.a();
        setOnClickListener(this.q);
    }

    private void f() {
        if (this.f == null) {
            this.f = LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_list_footer_2, (ViewGroup) this.c, false);
        }
        TextView textView = (TextView) this.f.findViewById(R.id.ksad_comment_list_footer_tip);
        if (!com.kwad.sdk.core.config.c.X()) {
            this.f.setVisibility(8);
            return;
        }
        if (!this.e.d(this.f)) {
            this.e.c(this.f);
        }
        this.f.setVisibility(0);
        textView.setText(q.a(getContext()));
    }

    private void g() {
        if (this.g == null) {
            this.g = LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_comment_list_header, (ViewGroup) this.c, false);
        }
        CommentAdItemView commentAdItemView = (CommentAdItemView) this.g.findViewById(R.id.ksad_comment_list_header_ad_item);
        if (this.e.e(this.g)) {
            return;
        }
        commentAdItemView.a(this.i, this.l);
        this.e.b(this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        for (b bVar : this.j) {
            bVar.a();
        }
    }

    public void a() {
        this.c.setVisibility(8);
        this.h.b();
        if (this.f8739b == null) {
            this.h.f();
        } else if (this.n != null) {
            a(this.n);
            this.h.a();
        } else if (this.m) {
        } else {
            this.m = true;
            new com.kwad.sdk.core.g.g().a(this.f8739b.b(), new g.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentListPanel.5
                @Override // com.kwad.sdk.core.g.g.a
                public void a(int i, String str) {
                    if (com.kwad.sdk.core.network.f.c.k == i) {
                        if (com.kwad.sdk.core.config.c.C()) {
                            CommentListPanel.this.h.a();
                            CommentListPanel.this.a(new CommentResponse());
                        } else {
                            CommentListPanel.this.h.f();
                        }
                        CommentListPanel.this.o.a();
                        com.kwad.sdk.core.report.e.g(CommentListPanel.this.f8739b.a());
                    } else if (com.kwad.sdk.core.network.f.f9620a.k == i) {
                        CommentListPanel.this.h.c();
                    } else {
                        CommentListPanel.this.h.d();
                    }
                    CommentListPanel.this.m = false;
                }

                @Override // com.kwad.sdk.core.g.g.a
                public void a(@NonNull CommentResponse commentResponse) {
                    CommentListPanel.this.h.a();
                    CommentListPanel.this.n = commentResponse;
                    CommentListPanel.this.a(commentResponse);
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
        this.f8739b = new e(adTemplate, j);
    }

    protected void a(@NonNull CommentResponse commentResponse) {
        this.c.setItemAnimator(null);
        this.c.setLayoutManager(b());
        this.e = b(commentResponse);
        f();
        this.c.setAdapter(this.e);
        this.c.setVisibility(0);
        if (com.kwad.sdk.core.config.c.C() && com.kwad.sdk.core.response.b.c.c(this.i)) {
            this.c.setOnScrollListener(this.f8738a);
            g();
        }
        this.o.a();
        com.kwad.sdk.core.report.e.g(this.f8739b.a());
    }

    protected RecyclerView.LayoutManager b() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        return linearLayoutManager;
    }

    protected com.kwad.sdk.lib.widget.recycler.d b(@NonNull CommentResponse commentResponse) {
        this.f8739b.a(commentResponse.rootComments);
        this.d = new d(getContext(), this.f8739b);
        return new com.kwad.sdk.lib.widget.recycler.d(this.d);
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
        long a2 = this.d != null ? this.d.a() : 0L;
        if (this.f8739b != null) {
            com.kwad.sdk.core.report.e.a(this.f8739b.a(), a2, this.o.b());
        }
    }

    public void d() {
        this.n = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case 2:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
