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
import java.util.List;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.lib.widget.recycler.c<AdTemplate, com.kwad.sdk.feed.a.a.a.b> {

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.a.b.b f35515c;

    public b(KsFragment ksFragment, RecyclerView recyclerView, com.kwad.sdk.feed.a.b.b bVar) {
        super(ksFragment, recyclerView, new com.kwad.sdk.contentalliance.a());
        this.f35515c = bVar;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public View a(ViewGroup viewGroup, int i2) {
        int i3;
        if (i2 == 0) {
            i3 = R.layout.ksad_content_feed_home_item_photo;
        } else if (i2 == 1) {
            i3 = R.layout.ksad_content_feed_home_item_ad;
        } else if (i2 == 2) {
            i3 = R.layout.ksad_content_feed_home_item_photo_single_small;
        } else if (i2 == 3) {
            i3 = R.layout.ksad_content_feed_home_item_ad_single_small;
        } else if (i2 == 4) {
            i3 = R.layout.ksad_content_feed_home_item_photo_single_large;
        } else if (i2 != 5) {
            return new View(viewGroup.getContext());
        } else {
            i3 = R.layout.ksad_content_feed_home_item_ad_single_large;
        }
        return ao.a(viewGroup, i3, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: a */
    public com.kwad.sdk.feed.a.a.a.b b() {
        return new com.kwad.sdk.feed.a.a.a.b();
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public Presenter a(int i2) {
        Presenter aVar;
        Presenter presenter = new Presenter();
        if (i2 == 0) {
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.c());
            aVar = new com.kwad.sdk.feed.a.a.b.b.a();
        } else if (i2 == 1) {
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.b());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.c());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.a());
            aVar = new com.kwad.sdk.feed.a.a.b.a.c();
        } else if (i2 == 2) {
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
            presenter.a((Presenter) new f());
            aVar = new com.kwad.sdk.feed.a.a.b.b.b();
        } else if (i2 == 3) {
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.b());
            presenter.a((Presenter) new f());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.d());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.c());
            aVar = new com.kwad.sdk.feed.a.a.b.b();
        } else if (i2 != 4) {
            if (i2 == 5) {
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.b());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.e());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.d());
                presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a.c());
                aVar = new com.kwad.sdk.feed.a.a.b.b();
            }
            return presenter;
        } else {
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.d());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.a());
            presenter.a((Presenter) new com.kwad.sdk.feed.a.a.b.e());
            aVar = new com.kwad.sdk.feed.a.a.b.b.b();
        }
        presenter.a(aVar);
        return presenter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    public void a(com.kwad.sdk.feed.a.a.a.b bVar, int i2) {
        super.a((b) bVar, i2);
        AdTemplate adTemplate = (AdTemplate) this.f36675a.get(i2);
        if (com.kwad.sdk.core.response.b.c.b(adTemplate) || !com.kwad.sdk.core.response.b.a.y(com.kwad.sdk.core.response.b.c.j(adTemplate))) {
            bVar.f35454b = null;
        } else {
            bVar.f35454b = new com.kwad.sdk.core.download.b.b(adTemplate);
        }
        bVar.f35453a = this.f35515c;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public boolean a(boolean z, boolean z2) {
        return z && !z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        AdTemplate adTemplate;
        List<M> list = this.f36675a;
        if (list == 0 || i2 >= list.size() || (adTemplate = (AdTemplate) this.f36675a.get(i2)) == null) {
            return -1;
        }
        int i3 = adTemplate.mPageInfo.pageType;
        if (i3 == 0 || i3 == 1) {
            return !com.kwad.sdk.core.response.b.c.b(adTemplate) ? 1 : 0;
        }
        if (i3 == 2) {
            return com.kwad.sdk.core.response.b.c.b(adTemplate) ? 2 : 3;
        } else if (i3 != 3) {
            return -1;
        } else {
            return com.kwad.sdk.core.response.b.c.b(adTemplate) ? 4 : 5;
        }
    }
}
