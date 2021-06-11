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
    public SlidePlayViewPager f33318c;

    /* renamed from: d  reason: collision with root package name */
    public c f33319d;

    /* renamed from: e  reason: collision with root package name */
    public int f33320e;

    /* renamed from: f  reason: collision with root package name */
    public List<a> f33321f;

    /* renamed from: g  reason: collision with root package name */
    public AdTemplate f33322g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f33323h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public View f33324i;

    public b(KsFragment ksFragment, RecyclerView recyclerView, SlidePlayViewPager slidePlayViewPager) {
        super(ksFragment, recyclerView);
        this.f33321f = new LinkedList();
        this.f33318c = slidePlayViewPager;
    }

    private void b(AdTemplate adTemplate, @Nullable View view, boolean z) {
        int indexOf = this.f36675a.indexOf(adTemplate);
        com.kwad.sdk.core.d.a.a("SlideProfileAdapter", "notifyVideoStateChange selectedPosition:" + indexOf);
        if (indexOf != -1) {
            for (a aVar : this.f33321f) {
                aVar.a(indexOf, view, z);
            }
        }
    }

    private void l() {
        int indexOf = this.f36675a.indexOf(this.f33322g);
        com.kwad.sdk.core.d.a.a("SlideProfileAdapter", "notifyOnSelectChanged selectedPosition:" + indexOf);
        if (indexOf != -1) {
            for (a aVar : this.f33321f) {
                aVar.a(indexOf, this.f33322g);
            }
        }
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public View a(ViewGroup viewGroup, int i2) {
        return ao.a(viewGroup, R.layout.ksad_content_slide_home_profile_item, false);
    }

    public AdTemplate a() {
        return this.f33322g;
    }

    @Override // com.kwad.sdk.lib.widget.recycler.c
    public Presenter a(int i2) {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.c.b.b());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.c.b.a());
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.c.b.c());
        return presenter;
    }

    public void a(View view) {
        this.f33324i = view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    public void a(com.kwad.sdk.contentalliance.home.c.a.b bVar, int i2) {
        super.a((b) bVar, i2);
        bVar.f33315a = this.f33318c;
        bVar.f33316b = this.f33324i;
        bVar.f33317c = this;
    }

    public void a(c cVar) {
        this.f33319d = cVar;
    }

    public void a(AdTemplate adTemplate, View view, boolean z) {
        b(adTemplate, view, z);
    }

    public void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.contentalliance.detail.video.b bVar) {
        this.f33322g = adTemplate;
        this.f33323h = bVar;
        l();
    }

    public void b(int i2) {
        this.f33320e = i2;
    }

    public com.kwad.sdk.contentalliance.detail.video.b c() {
        return this.f33323h;
    }

    public List<a> d() {
        return this.f33321f;
    }

    public c e() {
        return this.f33319d;
    }

    public int f() {
        return this.f33320e;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.lib.widget.recycler.c
    /* renamed from: g */
    public com.kwad.sdk.contentalliance.home.c.a.b b() {
        return new com.kwad.sdk.contentalliance.home.c.a.b();
    }
}
