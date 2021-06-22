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
    public Handler f33138a;

    /* renamed from: b  reason: collision with root package name */
    public View f33139b;

    /* renamed from: c  reason: collision with root package name */
    public View f33140c;

    /* renamed from: d  reason: collision with root package name */
    public KSHalfPageLoadingView f33141d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f33142e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f33143f;

    /* renamed from: g  reason: collision with root package name */
    public b f33144g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.d f33145h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> f33146i;
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
        this.f33138a = new Handler();
        this.n = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.2
            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                if (RelatedVideoPanel.this.f33146i != null) {
                    RelatedVideoPanel.this.f33146i.k();
                }
            }
        };
        this.o = new g() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.3
            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i2, String str) {
                RelatedVideoPanel.this.f33141d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f33144g.i()) {
                        if (com.kwad.sdk.core.network.f.f34601g.k == i2) {
                            RelatedVideoPanel.this.f33141d.e();
                        } else if (com.kwad.sdk.core.network.f.f34595a.k == i2) {
                            RelatedVideoPanel.this.f33141d.c();
                        } else {
                            RelatedVideoPanel.this.f33141d.d();
                        }
                    }
                } else if (com.kwad.sdk.core.network.f.f34595a.k == i2) {
                    p.a(RelatedVideoPanel.this.getContext());
                } else if (com.kwad.sdk.core.network.f.f34601g.k != i2) {
                    p.b(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.f33142e.a(RelatedVideoPanel.this.f33146i.j());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                if (!z) {
                    RelatedVideoPanel.this.f33142e.a();
                } else if (RelatedVideoPanel.this.f33144g.i()) {
                    RelatedVideoPanel.this.f33141d.b();
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                RelatedVideoPanel.this.i();
                RelatedVideoPanel.this.f33141d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f33144g.i()) {
                        RelatedVideoPanel.this.f33141d.d();
                    } else if (!RelatedVideoPanel.this.f33145h.d(RelatedVideoPanel.this.f33142e)) {
                        RelatedVideoPanel.this.f33145h.c(RelatedVideoPanel.this.f33142e);
                    }
                }
                RelatedVideoPanel.this.f33142e.a(RelatedVideoPanel.this.f33146i.j());
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
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                if (i2 > 0 || i3 > 0) {
                    RelatedVideoPanel.this.j();
                }
            }
        };
    }

    public RelatedVideoPanel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33138a = new Handler();
        this.n = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.2
            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                if (RelatedVideoPanel.this.f33146i != null) {
                    RelatedVideoPanel.this.f33146i.k();
                }
            }
        };
        this.o = new g() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.3
            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i2, String str) {
                RelatedVideoPanel.this.f33141d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f33144g.i()) {
                        if (com.kwad.sdk.core.network.f.f34601g.k == i2) {
                            RelatedVideoPanel.this.f33141d.e();
                        } else if (com.kwad.sdk.core.network.f.f34595a.k == i2) {
                            RelatedVideoPanel.this.f33141d.c();
                        } else {
                            RelatedVideoPanel.this.f33141d.d();
                        }
                    }
                } else if (com.kwad.sdk.core.network.f.f34595a.k == i2) {
                    p.a(RelatedVideoPanel.this.getContext());
                } else if (com.kwad.sdk.core.network.f.f34601g.k != i2) {
                    p.b(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.f33142e.a(RelatedVideoPanel.this.f33146i.j());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                if (!z) {
                    RelatedVideoPanel.this.f33142e.a();
                } else if (RelatedVideoPanel.this.f33144g.i()) {
                    RelatedVideoPanel.this.f33141d.b();
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                RelatedVideoPanel.this.i();
                RelatedVideoPanel.this.f33141d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f33144g.i()) {
                        RelatedVideoPanel.this.f33141d.d();
                    } else if (!RelatedVideoPanel.this.f33145h.d(RelatedVideoPanel.this.f33142e)) {
                        RelatedVideoPanel.this.f33145h.c(RelatedVideoPanel.this.f33142e);
                    }
                }
                RelatedVideoPanel.this.f33142e.a(RelatedVideoPanel.this.f33146i.j());
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
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
                if (i2 > 0 || i3 > 0) {
                    RelatedVideoPanel.this.j();
                }
            }
        };
    }

    public RelatedVideoPanel(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33138a = new Handler();
        this.n = new KSPageLoadingView.a() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.2
            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                if (RelatedVideoPanel.this.f33146i != null) {
                    RelatedVideoPanel.this.f33146i.k();
                }
            }
        };
        this.o = new g() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.3
            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i22, String str) {
                RelatedVideoPanel.this.f33141d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f33144g.i()) {
                        if (com.kwad.sdk.core.network.f.f34601g.k == i22) {
                            RelatedVideoPanel.this.f33141d.e();
                        } else if (com.kwad.sdk.core.network.f.f34595a.k == i22) {
                            RelatedVideoPanel.this.f33141d.c();
                        } else {
                            RelatedVideoPanel.this.f33141d.d();
                        }
                    }
                } else if (com.kwad.sdk.core.network.f.f34595a.k == i22) {
                    p.a(RelatedVideoPanel.this.getContext());
                } else if (com.kwad.sdk.core.network.f.f34601g.k != i22) {
                    p.b(RelatedVideoPanel.this.getContext());
                }
                RelatedVideoPanel.this.f33142e.a(RelatedVideoPanel.this.f33146i.j());
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                if (!z) {
                    RelatedVideoPanel.this.f33142e.a();
                } else if (RelatedVideoPanel.this.f33144g.i()) {
                    RelatedVideoPanel.this.f33141d.b();
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                RelatedVideoPanel.this.i();
                RelatedVideoPanel.this.f33141d.a();
                if (z) {
                    if (RelatedVideoPanel.this.f33144g.i()) {
                        RelatedVideoPanel.this.f33141d.d();
                    } else if (!RelatedVideoPanel.this.f33145h.d(RelatedVideoPanel.this.f33142e)) {
                        RelatedVideoPanel.this.f33145h.c(RelatedVideoPanel.this.f33142e);
                    }
                }
                RelatedVideoPanel.this.f33142e.a(RelatedVideoPanel.this.f33146i.j());
            }
        };
        this.p = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i22) {
                super.onScrollStateChanged(recyclerView, i22);
                if (i22 == 1) {
                    RelatedVideoPanel.this.j();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i22, int i3) {
                super.onScrolled(recyclerView, i22, i3);
                if (i22 > 0 || i3 > 0) {
                    RelatedVideoPanel.this.j();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        e.a(this.l, i2);
    }

    private void h() {
        View findViewById = findViewById(R.id.ksad_related_space);
        this.f33139b = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.ksad_related_close_button);
        this.f33140c = findViewById2;
        findViewById2.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ksad_related_recycler_view);
        this.f33143f = recyclerView;
        recyclerView.setItemAnimator(null);
        this.f33143f.addItemDecoration(new d(2, ao.a(getContext(), R.dimen.ksad_content_related_video_item_padding)));
        this.f33141d = (KSHalfPageLoadingView) findViewById(R.id.ksad_page_loading);
        this.f33142e = new com.kwad.sdk.contentalliance.widget.d(getContext());
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
        RecyclerView.LayoutManager layoutManager = this.f33143f.getLayoutManager();
        if (layoutManager.getChildCount() <= 0 || !k()) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.f33144g.getItemCount() - 6 || this.f33144g.j()) {
            return;
        }
        this.f33146i.m();
    }

    private boolean k() {
        com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> cVar = this.f33146i;
        return (cVar == null || cVar.f() == null || this.f33146i.f().isEmpty()) ? false : true;
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
        this.f33141d.a();
        this.f33141d.setRetryClickListener(null);
        b();
    }

    @Override // com.kwad.sdk.contentalliance.a.c
    public void a(int i2, int i3, Intent intent) {
        if (i2 == 1000 && i3 == -1) {
            final int intExtra = intent.getIntExtra("KEY_RELATED_VIDEO_DETAIL_POSITION", 0);
            com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> cVar = this.f33146i;
            if (cVar != null) {
                cVar.k();
                this.f33138a.postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.5
                    @Override // java.lang.Runnable
                    public void run() {
                        RelatedVideoPanel.this.f33143f.scrollToPosition(intExtra);
                    }
                }, 100L);
            }
        }
    }

    public void a(KsFragment ksFragment, AdTemplate adTemplate) {
        this.k = adTemplate;
        this.l = adTemplate.mAdScene;
        this.f33146i = new c(adTemplate);
        this.f33143f.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        b bVar = new b(ksFragment, this.f33143f, this.k);
        this.f33144g = bVar;
        bVar.a(this.f33146i.g());
        this.f33144g.a(this.f33146i);
        com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(this.f33144g);
        this.f33145h = dVar;
        dVar.a(this.f33143f);
        this.f33143f.setAdapter(this.f33145h);
        this.f33143f.addOnScrollListener(this.p);
        this.f33146i.a(this.o);
        this.f33146i.k();
        this.f33141d.setRetryClickListener(this.n);
        setVisibility(0);
        setFocusableInTouchMode(true);
        requestFocus();
        setOnKeyListener(new View.OnKeyListener() { // from class: com.kwad.sdk.contentalliance.detail.photo.related.RelatedVideoPanel.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1 && i2 == 4) {
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
        this.f33138a.removeCallbacksAndMessages(null);
        this.f33143f.setLayoutManager(null);
        this.f33143f.setAdapter(null);
        b bVar = this.f33144g;
        if (bVar != null) {
            bVar.k();
            this.f33144g = null;
        }
        com.kwad.sdk.lib.b.c<AdResultData, AdTemplate> cVar = this.f33146i;
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
        int i2;
        if (view == this.f33139b) {
            a();
            i2 = 3;
        } else if (view != this.f33140c) {
            return;
        } else {
            a();
            i2 = 1;
        }
        a(i2);
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
