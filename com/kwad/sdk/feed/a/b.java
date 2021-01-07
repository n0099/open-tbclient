package com.kwad.sdk.feed.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.a.a.b.f;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.lib.widget.recycler.c<AdTemplate, com.kwad.sdk.feed.a.a.a.b> {
    private com.kwad.sdk.feed.a.b.b c;

    public b(KsFragment ksFragment, RecyclerView recyclerView, com.kwad.sdk.feed.a.b.b bVar) {
        super(ksFragment, recyclerView, new com.kwad.sdk.contentalliance.a());
        this.c = bVar;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    protected View a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return ao.a(viewGroup, R.layout.ksad_content_feed_home_item_photo, false);
            case 1:
                return ao.a(viewGroup, R.layout.ksad_content_feed_home_item_ad, false);
            case 2:
                return ao.a(viewGroup, R.layout.ksad_content_feed_home_item_photo_single_small, false);
            case 3:
                return ao.a(viewGroup, R.layout.ksad_content_feed_home_item_ad_single_small, false);
            case 4:
                return ao.a(viewGroup, R.layout.ksad_content_feed_home_item_photo_single_large, false);
            case 5:
                return ao.a(viewGroup, R.layout.ksad_content_feed_home_item_ad_single_large, false);
            default:
                return new View(viewGroup.getContext());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: a */
    public com.kwad.sdk.feed.a.a.a.b b() {
        return new com.kwad.sdk.feed.a.a.a.b();
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    protected Presenter a(int i) {
        Presenter presenter = new Presenter();
        switch (i) {
            case 0:
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.c());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.b.a());
                break;
            case 1:
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.b());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.c());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.c());
                break;
            case 2:
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new f());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.b.b());
                break;
            case 3:
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.b());
                presenter.a((Presenter) new f());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.c());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.b());
                break;
            case 4:
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.e());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.b.b());
                break;
            case 5:
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.b());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.e());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.c());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.b());
                break;
        }
        return presenter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    public void a(com.kwad.sdk.feed.a.a.a.b bVar, int i) {
        super.a((b) bVar, i);
        AdTemplate adTemplate = (AdTemplate) this.f10734a.get(i);
        if (com.kwad.sdk.core.response.b.c.b(adTemplate) || !com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(adTemplate))) {
            bVar.f10110b = null;
        } else {
            bVar.f10110b = new com.kwad.sdk.core.download.b.b(adTemplate);
        }
        bVar.f10109a = this.c;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    protected boolean a(boolean z, boolean z2) {
        return z && !z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        AdTemplate adTemplate;
        int i2;
        if (this.f10734a == null || i >= this.f10734a.size() || (adTemplate = (AdTemplate) this.f10734a.get(i)) == null) {
            return -1;
        }
        switch (adTemplate.mPageInfo.pageType) {
            case 0:
            case 1:
                if (!com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                    i2 = 1;
                    break;
                } else {
                    i2 = 0;
                    break;
                }
            case 2:
                if (!com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                    i2 = 3;
                    break;
                } else {
                    i2 = 2;
                    break;
                }
            case 3:
                if (!com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                    i2 = 5;
                    break;
                } else {
                    i2 = 4;
                    break;
                }
            default:
                i2 = -1;
                break;
        }
        return i2;
    }
}
