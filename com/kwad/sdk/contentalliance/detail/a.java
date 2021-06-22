package com.kwad.sdk.contentalliance.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
/* loaded from: classes6.dex */
public abstract class a extends com.kwad.sdk.contentalliance.b<c> implements com.kwad.sdk.contentalliance.a.a {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f32569d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public h f32570e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32571f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32572g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32573h;

    @Override // com.kwad.sdk.contentalliance.b
    public void a() {
        super.a();
    }

    public void a(h hVar) {
        this.f32570e = hVar;
    }

    public final void e() {
        if (o() && !this.f32571f) {
            this.f32571f = true;
            j();
        }
    }

    public final void f() {
        if (o() && this.f32571f) {
            this.f32571f = false;
            k();
        }
    }

    public final void g() {
        if (o() && !this.f32572g) {
            this.f32572g = true;
            l();
        }
    }

    public final void h() {
        if (o() && this.f32572g) {
            this.f32572g = false;
            m();
        }
    }

    public final void i() {
        int i2 = getArguments() != null ? getArguments().getInt("KEY_INDEX_IN_VIEW_PAGER") : -1;
        SlidePlayViewPager slidePlayViewPager = this.f32569d;
        if (slidePlayViewPager == null || i2 != slidePlayViewPager.getRealPosition()) {
            return;
        }
        e();
        g();
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void j() {
        T t = this.f32530b;
        if (t == 0 || ((c) t).f32812b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32812b) {
            aVar.j();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void k() {
        T t = this.f32530b;
        if (t == 0 || ((c) t).f32812b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32812b) {
            aVar.k();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void l() {
        T t = this.f32530b;
        if (t == 0 || ((c) t).f32812b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32812b) {
            aVar.l();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void m() {
        T t = this.f32530b;
        if (t == 0 || ((c) t).f32812b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32812b) {
            aVar.m();
        }
    }

    public boolean n() {
        return this.f32573h;
    }

    public boolean o() {
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f32573h = true;
        i();
        T t = this.f32530b;
        if (t == 0 || ((c) t).f32813c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32813c) {
            cVar.e();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        T t = this.f32530b;
        if (t == 0 || ((c) t).f32813c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32813c) {
            cVar.a(i2, i3, intent);
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (viewGroup instanceof SlidePlayViewPager) {
            this.f32569d = (SlidePlayViewPager) viewGroup;
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        T t = this.f32530b;
        if (t == 0 || ((c) t).f32813c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32813c) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        T t = this.f32530b;
        if (t != 0) {
            ((c) t).a();
        }
        this.f32573h = false;
        f();
        h();
        T t2 = this.f32530b;
        if (t2 == 0 || ((c) t2).f32813c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t2).f32813c) {
            cVar.f();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        T t = this.f32530b;
        if (t == 0 || ((c) t).f32813c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32813c) {
            cVar.d();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        T t = this.f32530b;
        if (t == 0 || ((c) t).f32813c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32813c) {
            cVar.c();
        }
    }
}
