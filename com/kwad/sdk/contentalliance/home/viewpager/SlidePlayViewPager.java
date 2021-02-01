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
/* loaded from: classes3.dex */
public class SlidePlayViewPager extends SlidePlayTouchViewPager {
    private KsFragment g;
    private Presenter h;
    private d i;
    private a j;
    private i k;
    private com.kwad.sdk.contentalliance.detail.b.b l;
    private h m;
    private f n;
    private int o;

    public SlidePlayViewPager(Context context) {
        this(context, null);
    }

    public SlidePlayViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = 0;
    }

    private void t() {
        this.i = new d();
        this.i.f8769a = this.k;
        this.i.f8770b = this.g;
        this.i.c = this;
        this.i.d = this.d;
    }

    private void u() {
        this.h = new Presenter();
        this.h.a((Presenter) new com.kwad.sdk.contentalliance.home.viewpager.a.b());
        this.h.a((Presenter) new com.kwad.sdk.contentalliance.home.viewpager.a.a());
        this.h.a((View) this);
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public final void a(int i, boolean z) {
        if (this.j != null) {
            super.a(this.j.c(i), z);
        }
    }

    public void a(@NonNull f fVar, @NonNull e eVar) {
        this.n = fVar;
        this.g = fVar.f8737a;
        this.d = eVar;
        this.k = fVar.f8738b;
        this.l = fVar.d;
        this.m = fVar.f;
        this.o = 0;
        b();
        this.f8754a = fVar.k;
        this.f8755b = true;
        this.j = new b(this.g.getChildFragmentManager());
        this.j.a(this.l);
        this.j.a(this.m);
        this.j.a(this);
        u();
        t();
        this.h.a(this.i);
        setAdapter(this.j);
        setCurrentItem(this.n.j);
    }

    public void a(@NonNull AdTemplate adTemplate) {
        int b2 = this.k.b(adTemplate);
        if (b2 > -1) {
            a(b2, false);
        }
    }

    public void a(@NonNull AdTemplate adTemplate, int i) {
        this.o = i;
        if (this.o == 1) {
            this.f8754a = false;
        } else {
            this.f8754a = this.n.k;
        }
        this.j.a(this.k.d(), adTemplate, i, this.k.a(adTemplate), false);
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
        if (this.j != null) {
            this.j.a(false);
        }
        if (this.g.getHost() == null) {
            com.kwad.sdk.core.d.a.c("SlidePlayViewPager", "mFragment mHost is null");
            return;
        }
        b();
        this.j = new b(this.g.getChildFragmentManager());
        this.j.a(this.l);
        this.j.a(this.m);
        this.j.a(this);
        setAdapter(this.j);
        this.j.a(list);
        setCurrentItem(0);
    }

    public void g() {
        this.h.j();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b.b
    public a getAdapter() {
        return this.j;
    }

    public List<AdTemplate> getData() {
        if (this.j != null) {
            return this.j.d();
        }
        return null;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager
    protected int getFirstValidItemPosition() {
        return this.j != null ? this.j.b() : super.getFirstValidItemPosition();
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager
    protected int getLastValidItemPosition() {
        return this.j != null ? this.j.c() : super.getLastValidItemPosition();
    }

    public int getRealPosition() {
        if (this.j != null) {
            return this.j.a(getCurrentItem());
        }
        return 0;
    }

    public int getSourceType() {
        return this.o;
    }

    public void h() {
        this.f8754a = false;
    }

    public void i() {
        this.f8754a = this.n.k;
    }

    public boolean j() {
        return this.j == null || this.j.d().size() == 0;
    }

    public boolean k() {
        int realPosition = this.i.c.getRealPosition();
        return realPosition > -1 && realPosition < this.j.a() + (-1);
    }

    @Override // com.kwad.sdk.contentalliance.b.b, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    protected final void setCurrentItem(int i) {
        if (this.j != null) {
            super.setCurrentItem(this.j.c(i));
        }
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public void setInitStartPosition(int i) {
        if (this.j != null) {
            super.setInitStartPosition(this.j.c(i));
        }
        super.setInitStartPosition(i);
    }
}
