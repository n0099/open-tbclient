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
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.lib.widget.recycler.c<AdTemplate, com.kwad.sdk.contentalliance.home.c.a.b> {

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f33116c;

    /* renamed from: d  reason: collision with root package name */
    public c f33117d;

    /* renamed from: e  reason: collision with root package name */
    public int f33118e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f33119f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f33120g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f33121h;
    @Nullable
    public View i;

    public b(KsFragment ksFragment, RecyclerView recyclerView, SlidePlayViewPager slidePlayViewPager) {
        super(ksFragment, recyclerView);
        this.f33119f = new LinkedList();
        this.f33116c = slidePlayViewPager;
    }

    private void b(AdTemplate adTemplate, @Nullable View view, boolean z) {
        int indexOf = this.f36355a.indexOf(adTemplate);
        com.kwad.sdk.core.d.a.a("SlideProfileAdapter", "notifyVideoStateChange selectedPosition:" + indexOf);
        if (indexOf != -1) {
            for (a aVar : this.f33119f) {
                aVar.a(indexOf, view, z);
            }
        }
    }

    private void l() {
        int indexOf = this.f36355a.indexOf(this.f33120g);
        com.kwad.sdk.core.d.a.a("SlideProfileAdapter", "notifyOnSelectChanged selectedPosition:" + indexOf);
        if (indexOf != -1) {
            for (a aVar : this.f33119f) {
                aVar.a(indexOf, this.f33120g);
            }
        }
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public View a(ViewGroup viewGroup, int i) {
        return ao.a(viewGroup, R.layout.ksad_content_slide_home_profile_item, false);
    }

    public AdTemplate a() {
        return this.f33120g;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public Presenter a(int i) {
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
    @Override // com.kwad.sdk.lib.widget.recycler.c
    public void a(com.kwad.sdk.contentalliance.home.c.a.b bVar, int i) {
        super.a((b) bVar, i);
        bVar.f33113a = this.f33116c;
        bVar.f33114b = this.i;
        bVar.f33115c = this;
    }

    public void a(c cVar) {
        this.f33117d = cVar;
    }

    public void a(AdTemplate adTemplate, View view, boolean z) {
        b(adTemplate, view, z);
    }

    public void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.contentalliance.detail.video.b bVar) {
        this.f33120g = adTemplate;
        this.f33121h = bVar;
        l();
    }

    public void b(int i) {
        this.f33118e = i;
    }

    public com.kwad.sdk.contentalliance.detail.video.b c() {
        return this.f33121h;
    }

    public List<a> d() {
        return this.f33119f;
    }

    public c e() {
        return this.f33117d;
    }

    public int f() {
        return this.f33118e;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: g */
    public com.kwad.sdk.contentalliance.home.c.a.b b() {
        return new com.kwad.sdk.contentalliance.home.c.a.b();
    }
}
