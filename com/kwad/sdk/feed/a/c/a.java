package com.kwad.sdk.feed.a.c;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.d;
import com.kwad.sdk.lib.widget.recycler.e;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.feed.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f34860c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> f34861d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.OnScrollListener f34862e = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.feed.a.c.a.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            RecyclerView.Adapter adapter;
            int i3;
            super.onScrolled(recyclerView, i, i2);
            if (a.this.f34860c == null || a.this.f34861d == null || (adapter = a.this.f34860c.getAdapter()) == null || adapter.getItemCount() == 0) {
                return;
            }
            int a2 = e.a(a.this.f34860c);
            int b2 = e.b(a.this.f34860c);
            if (-1 == a2 || -1 == b2) {
                return;
            }
            com.kwad.sdk.core.d.a.a("FeedHomeItemVisiblePresenter", "firstVisible=" + a2 + "--lastVisible=" + b2);
            RecyclerView.LayoutManager layoutManager = a.this.f34860c.getLayoutManager();
            while (a2 <= b2) {
                if (adapter instanceof d) {
                    d dVar = (d) adapter;
                    if (a.this.a(a2, dVar)) {
                        a2++;
                    } else {
                        i3 = a2 - dVar.a();
                    }
                } else {
                    i3 = a2;
                }
                AdTemplate adTemplate = (AdTemplate) a.this.f34861d.c(i3);
                if (adTemplate != null) {
                    View findViewByPosition = layoutManager.findViewByPosition(a2);
                    Rect rect = new Rect();
                    if (findViewByPosition.getGlobalVisibleRect(rect)) {
                        a.this.a(adTemplate, rect.height() / (findViewByPosition.getHeight() * 1.0f));
                    }
                }
                a2++;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdTemplate adTemplate, float f2) {
        e.a aVar = ((com.kwad.sdk.feed.a.b.a) this).f34853a.f34856c.get(adTemplate.mUniqueId);
        if (aVar != null) {
            aVar.a(adTemplate, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, d dVar) {
        return i < dVar.a() || i >= dVar.a() + dVar.getItemCount();
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f34853a;
        this.f34861d = bVar.f35906h;
        RecyclerView recyclerView = bVar.f35904f;
        this.f34860c = recyclerView;
        recyclerView.addOnScrollListener(this.f34862e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f34860c.clearOnScrollListeners();
    }
}
