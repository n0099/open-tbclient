package com.kwad.sdk.contentalliance.home.c;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.lib.widget.recycler.c<AdTemplate, com.kwad.sdk.contentalliance.home.c.a.b> {
    private SlidePlayViewPager c;
    private c d;
    private int e;
    private List<a> f;
    private AdTemplate g;
    @Nullable
    private com.kwad.sdk.contentalliance.detail.video.b h;
    @Nullable
    private View i;

    public b(KsFragment ksFragment, RecyclerView recyclerView, SlidePlayViewPager slidePlayViewPager) {
        super(ksFragment, recyclerView);
        this.f = new LinkedList();
        this.c = slidePlayViewPager;
    }

    private void b(AdTemplate adTemplate, @Nullable View view, boolean z) {
        int indexOf = this.f10436a.indexOf(adTemplate);
        com.kwad.sdk.core.d.a.a("SlideProfileAdapter", "notifyVideoStateChange selectedPosition:" + indexOf);
        if (indexOf != -1) {
            for (a aVar : this.f) {
                aVar.a(indexOf, view, z);
            }
        }
    }

    private void l() {
        int indexOf = this.f10436a.indexOf(this.g);
        com.kwad.sdk.core.d.a.a("SlideProfileAdapter", "notifyOnSelectChanged selectedPosition:" + indexOf);
        if (indexOf != -1) {
            for (a aVar : this.f) {
                aVar.a(indexOf, this.g);
            }
        }
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    protected View a(ViewGroup viewGroup, int i) {
        return ao.a(viewGroup, R.layout.ksad_content_slide_home_profile_item, false);
    }

    public AdTemplate a() {
        return this.g;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    protected Presenter a(int i) {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.c.b.b());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.c.b.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.c.b.c());
        return presenter;
    }

    public void a(View view) {
        this.i = view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    public void a(com.kwad.sdk.contentalliance.home.c.a.b bVar, int i) {
        super.a((b) bVar, i);
        bVar.f8717a = this.c;
        bVar.f8718b = this.i;
        bVar.c = this;
    }

    public void a(c cVar) {
        this.d = cVar;
    }

    public void a(AdTemplate adTemplate, View view, boolean z) {
        b(adTemplate, view, z);
    }

    public void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.contentalliance.detail.video.b bVar) {
        this.g = adTemplate;
        this.h = bVar;
        l();
    }

    public void b(int i) {
        this.e = i;
    }

    public com.kwad.sdk.contentalliance.detail.video.b c() {
        return this.h;
    }

    public List<a> d() {
        return this.f;
    }

    public c e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: g */
    public com.kwad.sdk.contentalliance.home.c.a.b b() {
        return new com.kwad.sdk.contentalliance.home.c.a.b();
    }
}
