package com.kwad.sdk.contentalliance.detail.photo.related;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.widget.KSHalfPageLoadingView;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class RelatedVideoPanel extends LinearLayout implements View.OnClickListener, com.kwad.sdk.contentalliance.a.c {

    /* renamed from: a  reason: collision with root package name */
    public Handler f32847a;

    /* renamed from: b  reason: collision with root package name */
    public View f32848b;

    /* renamed from: c  reason: collision with root package name */
    public View f32849c;

    /* renamed from: d  reason: collision with root package name */
    public KSHalfPageLoadingView f32850d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f32851e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f32852f;

    /* renamed from: g  reason: collision with root package name */
    public b f32853g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f32854h;
    public com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> i;
    public a j;
    public AdTemplate k;
    public SceneImpl l;
    public boolean m;
    public KSPageLoadingView.a n;
    public f o;
    public RecyclerView.OnScrollListener p;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void b();
    }

    public RelatedVideoPanel(Context context) {
        super(context);
        this.f32847a = new Handler();
        this.n = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.2
            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                if (RelatedVideoPanel.this.i != null) {
                    RelatedVideoPanel.this.i.k();
                }
            }
        };
        this.o = new g() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.3
            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i, String str) {
                RelatedVideoPanel.this.f32850d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f32853g.i()) {
                        if (com.kwad.sdk.core.network.f.f34259g.k == i) {
                            RelatedVideoPanel.this.f32850d.e();
                        } else if (com.kwad.sdk.core.network.f.f34253a.k == i) {
                            RelatedVideoPanel.this.f32850d.c();
                        } else {
                            RelatedVideoPanel.this.f32850d.d();
                        }
                    }
                } else if (com.kwad.sdk.core.network.f.f34253a.k == i) {
                    p.a(RelatedVideoPanel.this.getContext());
                } else if (com.kwad.sdk.core.network.f.f34259g.k != i) {
                    p.b(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.f32851e.a(RelatedVideoPanel.this.i.j());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                if (!z) {
                    RelatedVideoPanel.this.f32851e.a();
                } else if (RelatedVideoPanel.this.f32853g.i()) {
                    RelatedVideoPanel.this.f32850d.b();
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                RelatedVideoPanel.this.i();
                RelatedVideoPanel.this.f32850d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f32853g.i()) {
                        RelatedVideoPanel.this.f32850d.d();
                    } else if (!RelatedVideoPanel.this.f32854h.d(RelatedVideoPanel.this.f32851e)) {
                        RelatedVideoPanel.this.f32854h.c(RelatedVideoPanel.this.f32851e);
                    }
                }
                RelatedVideoPanel.this.f32851e.a(RelatedVideoPanel.this.i.j());
            }
        };
        this.p = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    RelatedVideoPanel.this.j();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (i > 0 || i2 > 0) {
                    RelatedVideoPanel.this.j();
                }
            }
        };
    }

    public RelatedVideoPanel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32847a = new Handler();
        this.n = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.2
            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                if (RelatedVideoPanel.this.i != null) {
                    RelatedVideoPanel.this.i.k();
                }
            }
        };
        this.o = new g() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.3
            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i, String str) {
                RelatedVideoPanel.this.f32850d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f32853g.i()) {
                        if (com.kwad.sdk.core.network.f.f34259g.k == i) {
                            RelatedVideoPanel.this.f32850d.e();
                        } else if (com.kwad.sdk.core.network.f.f34253a.k == i) {
                            RelatedVideoPanel.this.f32850d.c();
                        } else {
                            RelatedVideoPanel.this.f32850d.d();
                        }
                    }
                } else if (com.kwad.sdk.core.network.f.f34253a.k == i) {
                    p.a(RelatedVideoPanel.this.getContext());
                } else if (com.kwad.sdk.core.network.f.f34259g.k != i) {
                    p.b(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.f32851e.a(RelatedVideoPanel.this.i.j());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                if (!z) {
                    RelatedVideoPanel.this.f32851e.a();
                } else if (RelatedVideoPanel.this.f32853g.i()) {
                    RelatedVideoPanel.this.f32850d.b();
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                RelatedVideoPanel.this.i();
                RelatedVideoPanel.this.f32850d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f32853g.i()) {
                        RelatedVideoPanel.this.f32850d.d();
                    } else if (!RelatedVideoPanel.this.f32854h.d(RelatedVideoPanel.this.f32851e)) {
                        RelatedVideoPanel.this.f32854h.c(RelatedVideoPanel.this.f32851e);
                    }
                }
                RelatedVideoPanel.this.f32851e.a(RelatedVideoPanel.this.i.j());
            }
        };
        this.p = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1) {
                    RelatedVideoPanel.this.j();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (i > 0 || i2 > 0) {
                    RelatedVideoPanel.this.j();
                }
            }
        };
    }

    public RelatedVideoPanel(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32847a = new Handler();
        this.n = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.2
            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                if (RelatedVideoPanel.this.i != null) {
                    RelatedVideoPanel.this.i.k();
                }
            }
        };
        this.o = new g() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.3
            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i2, String str) {
                RelatedVideoPanel.this.f32850d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f32853g.i()) {
                        if (com.kwad.sdk.core.network.f.f34259g.k == i2) {
                            RelatedVideoPanel.this.f32850d.e();
                        } else if (com.kwad.sdk.core.network.f.f34253a.k == i2) {
                            RelatedVideoPanel.this.f32850d.c();
                        } else {
                            RelatedVideoPanel.this.f32850d.d();
                        }
                    }
                } else if (com.kwad.sdk.core.network.f.f34253a.k == i2) {
                    p.a(RelatedVideoPanel.this.getContext());
                } else if (com.kwad.sdk.core.network.f.f34259g.k != i2) {
                    p.b(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.f32851e.a(RelatedVideoPanel.this.i.j());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                if (!z) {
                    RelatedVideoPanel.this.f32851e.a();
                } else if (RelatedVideoPanel.this.f32853g.i()) {
                    RelatedVideoPanel.this.f32850d.b();
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                RelatedVideoPanel.this.i();
                RelatedVideoPanel.this.f32850d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f32853g.i()) {
                        RelatedVideoPanel.this.f32850d.d();
                    } else if (!RelatedVideoPanel.this.f32854h.d(RelatedVideoPanel.this.f32851e)) {
                        RelatedVideoPanel.this.f32854h.c(RelatedVideoPanel.this.f32851e);
                    }
                }
                RelatedVideoPanel.this.f32851e.a(RelatedVideoPanel.this.i.j());
            }
        };
        this.p = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1) {
                    RelatedVideoPanel.this.j();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                if (i2 > 0 || i22 > 0) {
                    RelatedVideoPanel.this.j();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        e.a(this.l, i);
    }

    private void h() {
        View findViewById = findViewById(R.id.ksad_related_space);
        this.f32848b = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.ksad_related_close_button);
        this.f32849c = findViewById2;
        findViewById2.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ksad_related_recycler_view);
        this.f32852f = recyclerView;
        recyclerView.setItemAnimator(null);
        this.f32852f.addItemDecoration(new d(2, ao.a(getContext(), R.dimen.ksad_content_related_video_item_padding)));
        this.f32850d = (KSHalfPageLoadingView) findViewById(R.id.ksad_page_loading);
        this.f32851e = new com.kwad.sdk.contentalliance.widget.d(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.m) {
            return;
        }
        this.m = true;
        e.q(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        RecyclerView.LayoutManager layoutManager = this.f32852f.getLayoutManager();
        if (layoutManager.getChildCount() <= 0 || !k()) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.f32853g.getItemCount() - 6 || this.f32853g.j()) {
            return;
        }
        this.i.m();
    }

    private boolean k() {
        com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> cVar = this.i;
        return (cVar == null || cVar.f() == null || this.i.f().isEmpty()) ? false : true;
    }

    public void a() {
        setFocusableInTouchMode(false);
        clearFocus();
        setOnKeyListener(null);
        setVisibility(8);
        a aVar = this.j;
        if (aVar != null) {
            aVar.b();
        }
        this.f32850d.a();
        this.f32850d.setRetryClickListener(null);
        b();
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void a(int i, int i2, Intent intent) {
        if (i == 1000 && i2 == -1) {
            final int intExtra = intent.getIntExtra("KEY_RELATED_VIDEO_DETAIL_POSITION", 0);
            com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> cVar = this.i;
            if (cVar != null) {
                cVar.k();
                this.f32847a.postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.5
                    @Override // java.lang.Runnable
                    public void run() {
                        RelatedVideoPanel.this.f32852f.scrollToPosition(intExtra);
                    }
                }, 100L);
            }
        }
    }

    public void a(KsFragment ksFragment, AdTemplate adTemplate) {
        this.k = adTemplate;
        this.l = adTemplate.mAdScene;
        this.i = new c(adTemplate);
        this.f32852f.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        b bVar = new b(ksFragment, this.f32852f, this.k);
        this.f32853g = bVar;
        bVar.a(this.i.g());
        this.f32853g.a(this.i);
        com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(this.f32853g);
        this.f32854h = dVar;
        dVar.a(this.f32852f);
        this.f32852f.setAdapter(this.f32854h);
        this.f32852f.addOnScrollListener(this.p);
        this.i.a(this.o);
        this.i.k();
        this.f32850d.setRetryClickListener(this.n);
        setVisibility(0);
        setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener(new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && i == 4) {
                    RelatedVideoPanel.this.a();
                    RelatedVideoPanel.this.a(5);
                    return true;
                }
                return false;
            }
        });
        a aVar = this.j;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b() {
        this.m = false;
        this.f32847a.removeCallbacksAndMessages(null);
        this.f32852f.setLayoutManager(null);
        this.f32852f.setAdapter(null);
        b bVar = this.f32853g;
        if (bVar != null) {
            bVar.k();
            this.f32853g = null;
        }
        com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> cVar = this.i;
        if (cVar != null) {
            cVar.h();
        }
        this.j = null;
        com.kwad.sdk.contentalliance.detail.photo.related.a.a().e();
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void c() {
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        int action = motionEvent.getAction();
        boolean z = true;
        if (action != 0) {
            if (action == 1 || action == 3) {
                parent = getParent();
                z = false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        parent = getParent();
        parent.requestDisallowInterceptTouchEvent(z);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void e() {
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void f() {
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void g() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view == this.f32848b) {
            a();
            i = 3;
        } else if (view != this.f32849c) {
            return;
        } else {
            a();
            i = 1;
        }
        a(i);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        h();
    }

    public void setRelatedPanelListener(a aVar) {
        this.j = aVar;
    }
}
