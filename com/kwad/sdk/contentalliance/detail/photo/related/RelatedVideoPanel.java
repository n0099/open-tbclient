package com.kwad.sdk.contentalliance.detail.photo.related;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
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
/* loaded from: classes5.dex */
public class RelatedVideoPanel extends LinearLayout implements View.OnClickListener, com.kwad.sdk.contentalliance.a.c {

    /* renamed from: a  reason: collision with root package name */
    private Handler f8865a;

    /* renamed from: b  reason: collision with root package name */
    private View f8866b;
    private View c;
    private KSHalfPageLoadingView d;
    private com.kwad.sdk.contentalliance.widget.d e;
    private RecyclerView f;
    private b g;
    private com.kwad.sdk.lib.widget.recycler.d h;
    private com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> i;
    private a j;
    private AdTemplate k;
    private SceneImpl l;
    private boolean m;
    private KSPageLoadingView.a n;
    private f o;
    private RecyclerView.OnScrollListener p;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public RelatedVideoPanel(Context context) {
        super(context);
        this.f8865a = new Handler();
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
                RelatedVideoPanel.this.d.a();
                if (z) {
                    if (RelatedVideoPanel.this.g.i()) {
                        if (com.kwad.sdk.core.network.f.g.k == i) {
                            RelatedVideoPanel.this.d.e();
                        } else if (com.kwad.sdk.core.network.f.f9620a.k == i) {
                            RelatedVideoPanel.this.d.c();
                        } else {
                            RelatedVideoPanel.this.d.d();
                        }
                    }
                } else if (com.kwad.sdk.core.network.f.f9620a.k == i) {
                    p.a(RelatedVideoPanel.this.getContext());
                } else if (com.kwad.sdk.core.network.f.g.k != i) {
                    p.b(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.e.a(RelatedVideoPanel.this.i.j());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                if (!z) {
                    RelatedVideoPanel.this.e.a();
                } else if (RelatedVideoPanel.this.g.i()) {
                    RelatedVideoPanel.this.d.b();
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                RelatedVideoPanel.this.i();
                RelatedVideoPanel.this.d.a();
                if (z) {
                    if (RelatedVideoPanel.this.g.i()) {
                        RelatedVideoPanel.this.d.d();
                    } else if (!RelatedVideoPanel.this.h.d(RelatedVideoPanel.this.e)) {
                        RelatedVideoPanel.this.h.c(RelatedVideoPanel.this.e);
                    }
                }
                RelatedVideoPanel.this.e.a(RelatedVideoPanel.this.i.j());
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
        this.f8865a = new Handler();
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
                RelatedVideoPanel.this.d.a();
                if (z) {
                    if (RelatedVideoPanel.this.g.i()) {
                        if (com.kwad.sdk.core.network.f.g.k == i) {
                            RelatedVideoPanel.this.d.e();
                        } else if (com.kwad.sdk.core.network.f.f9620a.k == i) {
                            RelatedVideoPanel.this.d.c();
                        } else {
                            RelatedVideoPanel.this.d.d();
                        }
                    }
                } else if (com.kwad.sdk.core.network.f.f9620a.k == i) {
                    p.a(RelatedVideoPanel.this.getContext());
                } else if (com.kwad.sdk.core.network.f.g.k != i) {
                    p.b(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.e.a(RelatedVideoPanel.this.i.j());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                if (!z) {
                    RelatedVideoPanel.this.e.a();
                } else if (RelatedVideoPanel.this.g.i()) {
                    RelatedVideoPanel.this.d.b();
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                RelatedVideoPanel.this.i();
                RelatedVideoPanel.this.d.a();
                if (z) {
                    if (RelatedVideoPanel.this.g.i()) {
                        RelatedVideoPanel.this.d.d();
                    } else if (!RelatedVideoPanel.this.h.d(RelatedVideoPanel.this.e)) {
                        RelatedVideoPanel.this.h.c(RelatedVideoPanel.this.e);
                    }
                }
                RelatedVideoPanel.this.e.a(RelatedVideoPanel.this.i.j());
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
        this.f8865a = new Handler();
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
                RelatedVideoPanel.this.d.a();
                if (z) {
                    if (RelatedVideoPanel.this.g.i()) {
                        if (com.kwad.sdk.core.network.f.g.k == i2) {
                            RelatedVideoPanel.this.d.e();
                        } else if (com.kwad.sdk.core.network.f.f9620a.k == i2) {
                            RelatedVideoPanel.this.d.c();
                        } else {
                            RelatedVideoPanel.this.d.d();
                        }
                    }
                } else if (com.kwad.sdk.core.network.f.f9620a.k == i2) {
                    p.a(RelatedVideoPanel.this.getContext());
                } else if (com.kwad.sdk.core.network.f.g.k != i2) {
                    p.b(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.e.a(RelatedVideoPanel.this.i.j());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                if (!z) {
                    RelatedVideoPanel.this.e.a();
                } else if (RelatedVideoPanel.this.g.i()) {
                    RelatedVideoPanel.this.d.b();
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                RelatedVideoPanel.this.i();
                RelatedVideoPanel.this.d.a();
                if (z) {
                    if (RelatedVideoPanel.this.g.i()) {
                        RelatedVideoPanel.this.d.d();
                    } else if (!RelatedVideoPanel.this.h.d(RelatedVideoPanel.this.e)) {
                        RelatedVideoPanel.this.h.c(RelatedVideoPanel.this.e);
                    }
                }
                RelatedVideoPanel.this.e.a(RelatedVideoPanel.this.i.j());
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
        this.f8866b = findViewById(R.id.ksad_related_space);
        this.f8866b.setOnClickListener(this);
        this.c = findViewById(R.id.ksad_related_close_button);
        this.c.setOnClickListener(this);
        this.f = (RecyclerView) findViewById(R.id.ksad_related_recycler_view);
        this.f.setItemAnimator(null);
        this.f.addItemDecoration(new d(2, ao.a(getContext(), R.dimen.ksad_content_related_video_item_padding)));
        this.d = (KSHalfPageLoadingView) findViewById(R.id.ksad_page_loading);
        this.e = new com.kwad.sdk.contentalliance.widget.d(getContext());
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
        RecyclerView.LayoutManager layoutManager = this.f.getLayoutManager();
        if (layoutManager.getChildCount() <= 0 || !k()) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.g.getItemCount() - 6 || this.g.j()) {
            return;
        }
        this.i.m();
    }

    private boolean k() {
        return (this.i == null || this.i.f() == null || this.i.f().isEmpty()) ? false : true;
    }

    public void a() {
        setFocusableInTouchMode(false);
        clearFocus();
        setOnKeyListener(null);
        setVisibility(8);
        if (this.j != null) {
            this.j.b();
        }
        this.d.a();
        this.d.setRetryClickListener(null);
        b();
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void a(int i, int i2, Intent intent) {
        if (i == 1000 && i2 == -1) {
            final int intExtra = intent.getIntExtra("KEY_RELATED_VIDEO_DETAIL_POSITION", 0);
            if (this.i != null) {
                this.i.k();
                this.f8865a.postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.5
                    @Override // java.lang.Runnable
                    public void run() {
                        RelatedVideoPanel.this.f.scrollToPosition(intExtra);
                    }
                }, 100L);
            }
        }
    }

    public void a(KsFragment ksFragment, AdTemplate adTemplate) {
        this.k = adTemplate;
        this.l = adTemplate.mAdScene;
        this.i = new c(adTemplate);
        this.f.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        this.g = new b(ksFragment, this.f, this.k);
        this.g.a(this.i.g());
        this.g.a(this.i);
        this.h = new com.kwad.sdk.lib.widget.recycler.d(this.g);
        this.h.a(this.f);
        this.f.setAdapter(this.h);
        this.f.addOnScrollListener(this.p);
        this.i.a(this.o);
        this.i.k();
        this.d.setRetryClickListener(this.n);
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
        if (this.j != null) {
            this.j.a();
        }
    }

    public void b() {
        this.m = false;
        this.f8865a.removeCallbacksAndMessages(null);
        this.f.setLayoutManager(null);
        this.f.setAdapter(null);
        if (this.g != null) {
            this.g.k();
            this.g = null;
        }
        if (this.i != null) {
            this.i.h();
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
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
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
        if (view == this.f8866b) {
            a();
            a(3);
        } else if (view == this.c) {
            a();
            a(1);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        h();
    }

    public void setRelatedPanelListener(a aVar) {
        this.j = aVar;
    }
}
