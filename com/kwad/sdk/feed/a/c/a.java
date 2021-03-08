package com.kwad.sdk.feed.a.c;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.widget.recycler.d;
import com.kwad.sdk.lib.widget.recycler.e;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.feed.a.b.a {
    private RecyclerView c;
    private com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> d;
    private RecyclerView.OnScrollListener e = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.feed.a.c.a.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            RecyclerView.Adapter adapter;
            int i3;
            super.onScrolled(recyclerView, i, i2);
            if (a.this.c == null || a.this.d == null || (adapter = a.this.c.getAdapter()) == null || adapter.getItemCount() == 0) {
                return;
            }
            int a2 = e.a(a.this.c);
            int b = e.b(a.this.c);
            if (-1 == a2 || -1 == b) {
                return;
            }
            com.kwad.sdk.core.d.a.a("FeedHomeItemVisiblePresenter", "firstVisible=" + a2 + "--lastVisible=" + b);
            RecyclerView.LayoutManager layoutManager = a.this.c.getLayoutManager();
            while (a2 <= b) {
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
                AdTemplate adTemplate = (AdTemplate) a.this.d.c(i3);
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
    public void a(AdTemplate adTemplate, float f) {
        e.a aVar = this.f6505a.c.get(adTemplate.mUniqueId);
        if (aVar != null) {
            aVar.a(adTemplate, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, d dVar) {
        return i < dVar.a() || i >= dVar.a() + dVar.getItemCount();
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = this.f6505a.h;
        this.c = this.f6505a.f;
        this.c.addOnScrollListener(this.e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.c.clearOnScrollListeners();
    }
}
