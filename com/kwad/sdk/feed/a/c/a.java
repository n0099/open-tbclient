package com.kwad.sdk.feed.a.c;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.d;
import com.kwad.sdk.lib.widget.recycler.e;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.feed.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f35523c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> f35524d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView.OnScrollListener f35525e = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.feed.a.c.a.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            RecyclerView.Adapter adapter;
            int i4;
            super.onScrolled(recyclerView, i2, i3);
            if (a.this.f35523c == null || a.this.f35524d == null || (adapter = a.this.f35523c.getAdapter()) == null || adapter.getItemCount() == 0) {
                return;
            }
            int a2 = e.a(a.this.f35523c);
            int b2 = e.b(a.this.f35523c);
            if (-1 == a2 || -1 == b2) {
                return;
            }
            com.kwad.sdk.core.d.a.a("FeedHomeItemVisiblePresenter", "firstVisible=" + a2 + "--lastVisible=" + b2);
            RecyclerView.LayoutManager layoutManager = a.this.f35523c.getLayoutManager();
            while (a2 <= b2) {
                if (adapter instanceof d) {
                    d dVar = (d) adapter;
                    if (a.this.a(a2, dVar)) {
                        a2++;
                    } else {
                        i4 = a2 - dVar.a();
                    }
                } else {
                    i4 = a2;
                }
                AdTemplate adTemplate = (AdTemplate) a.this.f35524d.c(i4);
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
        e.a aVar = ((com.kwad.sdk.feed.a.b.a) this).f35516a.f35519c.get(adTemplate.mUniqueId);
        if (aVar != null) {
            aVar.a(adTemplate, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, d dVar) {
        return i2 < dVar.a() || i2 >= dVar.a() + dVar.getItemCount();
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f35516a;
        this.f35524d = bVar.f36609h;
        RecyclerView recyclerView = bVar.f36607f;
        this.f35523c = recyclerView;
        recyclerView.addOnScrollListener(this.f35525e);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f35523c.clearOnScrollListeners();
    }
}
