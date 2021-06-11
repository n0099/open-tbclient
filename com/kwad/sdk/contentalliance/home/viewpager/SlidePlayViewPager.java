package com.kwad.sdk.contentalliance.home.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.refreshview.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;
/* loaded from: classes6.dex */
public class SlidePlayViewPager extends SlidePlayTouchViewPager {

    /* renamed from: g  reason: collision with root package name */
    public KsFragment f33415g;

    /* renamed from: h  reason: collision with root package name */
    public Presenter f33416h;

    /* renamed from: i  reason: collision with root package name */
    public d f33417i;
    public a j;
    public i k;
    public com.kwad.sdk.contentalliance.detail.b.b l;
    public h m;
    public f n;
    public int o;

    public SlidePlayViewPager(Context context) {
        this(context, null);
    }

    public SlidePlayViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = 0;
    }

    private void t() {
        d dVar = new d();
        this.f33417i = dVar;
        dVar.f33447a = this.k;
        dVar.f33448b = this.f33415g;
        dVar.f33449c = this;
        dVar.f33450d = this.f33410d;
    }

    private void u() {
        Presenter presenter = new Presenter();
        this.f33416h = presenter;
        presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.viewpager.a.b());
        this.f33416h.a((Presenter) new com.kwad.sdk.contentalliance.home.viewpager.a.a());
        this.f33416h.a((View) this);
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public final void a(int i2, boolean z) {
        a aVar = this.j;
        if (aVar != null) {
            super.a(aVar.c(i2), z);
        }
    }

    public void a(@NonNull f fVar, @NonNull e eVar) {
        this.n = fVar;
        this.f33415g = fVar.f33358a;
        this.f33410d = eVar;
        this.k = fVar.f33359b;
        this.l = fVar.f33361d;
        this.m = fVar.f33363f;
        this.o = 0;
        b();
        this.f33407a = fVar.k;
        ((SlidePlayTouchViewPager) this).f33408b = true;
        b bVar = new b(this.f33415g.getChildFragmentManager());
        this.j = bVar;
        bVar.a(this.l);
        this.j.a(this.m);
        this.j.a(this);
        u();
        t();
        this.f33416h.a(this.f33417i);
        setAdapter(this.j);
        setCurrentItem(this.n.j);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        int b2 = this.k.b(adTemplate);
        if (b2 > -1) {
            a(b2, false);
        }
    }

    public void a(@NonNull AdTemplate adTemplate, int i2) {
        this.o = i2;
        this.f33407a = i2 == 1 ? false : this.n.k;
        this.j.a(this.k.d(), adTemplate, i2, this.k.a(adTemplate), false);
    }

    public void a(@NonNull List<AdTemplate> list) {
        this.j.a(list);
    }

    public void a(boolean z) {
        int realPosition = getRealPosition();
        if (realPosition <= -1 || realPosition >= getAdapter().a() - 1) {
            return;
        }
        a(realPosition + 1, z);
    }

    public void b(@NonNull List<AdTemplate> list) {
        a aVar = this.j;
        if (aVar != null) {
            aVar.a(false);
        }
        if (this.f33415g.getHost() == null) {
            com.kwad.sdk.core.d.a.c("SlidePlayViewPager", "mFragment mHost is null");
            return;
        }
        b();
        b bVar = new b(this.f33415g.getChildFragmentManager());
        this.j = bVar;
        bVar.a(this.l);
        this.j.a(this.m);
        this.j.a(this);
        setAdapter(this.j);
        this.j.a(list);
        setCurrentItem(0);
    }

    public void g() {
        this.f33416h.j();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b.b
    public a getAdapter() {
        return this.j;
    }

    public List<AdTemplate> getData() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.d();
        }
        return null;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager
    public int getFirstValidItemPosition() {
        a aVar = this.j;
        return aVar != null ? aVar.b() : super.getFirstValidItemPosition();
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager
    public int getLastValidItemPosition() {
        a aVar = this.j;
        return aVar != null ? aVar.c() : super.getLastValidItemPosition();
    }

    public int getRealPosition() {
        a aVar = this.j;
        if (aVar != null) {
            return aVar.a(getCurrentItem());
        }
        return 0;
    }

    public int getSourceType() {
        return this.o;
    }

    public void h() {
        this.f33407a = false;
    }

    public void i() {
        this.f33407a = this.n.k;
    }

    public boolean j() {
        a aVar = this.j;
        return aVar == null || aVar.d().size() == 0;
    }

    public boolean k() {
        int realPosition = this.f33417i.f33449c.getRealPosition();
        return realPosition > -1 && realPosition < this.j.a() - 1;
    }

    @Override // com.kwad.sdk.contentalliance.b.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public final void setCurrentItem(int i2) {
        a aVar = this.j;
        if (aVar != null) {
            super.setCurrentItem(aVar.c(i2));
        }
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public void setInitStartPosition(int i2) {
        a aVar = this.j;
        if (aVar != null) {
            super.setInitStartPosition(aVar.c(i2));
        }
        super.setInitStartPosition(i2);
    }
}
