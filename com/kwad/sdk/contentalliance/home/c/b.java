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
    public SlidePlayViewPager f32732c;

    /* renamed from: d  reason: collision with root package name */
    public c f32733d;

    /* renamed from: e  reason: collision with root package name */
    public int f32734e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f32735f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f32736g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f32737h;
    @Nullable
    public View i;

    public b(KsFragment ksFragment, RecyclerView recyclerView, SlidePlayViewPager slidePlayViewPager) {
        super(ksFragment, recyclerView);
        this.f32735f = new LinkedList();
        this.f32732c = slidePlayViewPager;
    }

    private void b(AdTemplate adTemplate, @Nullable View view, boolean z) {
        int indexOf = this.f35971a.indexOf(adTemplate);
        com.kwad.sdk.core.d.a.a("SlideProfileAdapter", "notifyVideoStateChange selectedPosition:" + indexOf);
        if (indexOf != -1) {
            for (a aVar : this.f32735f) {
                aVar.a(indexOf, view, z);
            }
        }
    }

    private void l() {
        int indexOf = this.f35971a.indexOf(this.f32736g);
        com.kwad.sdk.core.d.a.a("SlideProfileAdapter", "notifyOnSelectChanged selectedPosition:" + indexOf);
        if (indexOf != -1) {
            for (a aVar : this.f32735f) {
                aVar.a(indexOf, this.f32736g);
            }
        }
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public View a(ViewGroup viewGroup, int i) {
        return ao.a(viewGroup, R.layout.ksad_content_slide_home_profile_item, false);
    }

    public AdTemplate a() {
        return this.f32736g;
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
        bVar.f32729a = this.f32732c;
        bVar.f32730b = this.i;
        bVar.f32731c = this;
    }

    public void a(c cVar) {
        this.f32733d = cVar;
    }

    public void a(AdTemplate adTemplate, View view, boolean z) {
        b(adTemplate, view, z);
    }

    public void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.contentalliance.detail.video.b bVar) {
        this.f32736g = adTemplate;
        this.f32737h = bVar;
        l();
    }

    public void b(int i) {
        this.f32734e = i;
    }

    public com.kwad.sdk.contentalliance.detail.video.b c() {
        return this.f32737h;
    }

    public List<a> d() {
        return this.f32735f;
    }

    public c e() {
        return this.f32733d;
    }

    public int f() {
        return this.f32734e;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: g */
    public com.kwad.sdk.contentalliance.home.c.a.b b() {
        return new com.kwad.sdk.contentalliance.home.c.a.b();
    }
}
