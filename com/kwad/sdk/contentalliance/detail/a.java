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
    public SlidePlayViewPager f31923d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public h f31924e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31925f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f31926g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f31927h;

    @Override // com.kwad.sdk.contentalliance.b
    public void a() {
        super.a();
    }

    public void a(h hVar) {
        this.f31924e = hVar;
    }

    public final void e() {
        if (o() && !this.f31925f) {
            this.f31925f = true;
            j();
        }
    }

    public final void f() {
        if (o() && this.f31925f) {
            this.f31925f = false;
            k();
        }
    }

    public final void g() {
        if (o() && !this.f31926g) {
            this.f31926g = true;
            l();
        }
    }

    public final void h() {
        if (o() && this.f31926g) {
            this.f31926g = false;
            m();
        }
    }

    public final void i() {
        int i = getArguments() != null ? getArguments().getInt("KEY_INDEX_IN_VIEW_PAGER") : -1;
        SlidePlayViewPager slidePlayViewPager = this.f31923d;
        if (slidePlayViewPager == null || i != slidePlayViewPager.getRealPosition()) {
            return;
        }
        e();
        g();
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void j() {
        T t = this.f31885b;
        if (t == 0 || ((c) t).f32153b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32153b) {
            aVar.j();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void k() {
        T t = this.f31885b;
        if (t == 0 || ((c) t).f32153b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32153b) {
            aVar.k();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void l() {
        T t = this.f31885b;
        if (t == 0 || ((c) t).f32153b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32153b) {
            aVar.l();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void m() {
        T t = this.f31885b;
        if (t == 0 || ((c) t).f32153b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32153b) {
            aVar.m();
        }
    }

    public boolean n() {
        return this.f31927h;
    }

    public boolean o() {
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f31927h = true;
        i();
        T t = this.f31885b;
        if (t == 0 || ((c) t).f32154c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32154c) {
            cVar.e();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        T t = this.f31885b;
        if (t == 0 || ((c) t).f32154c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32154c) {
            cVar.a(i, i2, intent);
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (viewGroup instanceof SlidePlayViewPager) {
            this.f31923d = (SlidePlayViewPager) viewGroup;
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        T t = this.f31885b;
        if (t == 0 || ((c) t).f32154c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32154c) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        T t = this.f31885b;
        if (t != 0) {
            ((c) t).a();
        }
        this.f31927h = false;
        f();
        h();
        T t2 = this.f31885b;
        if (t2 == 0 || ((c) t2).f32154c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t2).f32154c) {
            cVar.f();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        T t = this.f31885b;
        if (t == 0 || ((c) t).f32154c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32154c) {
            cVar.d();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        T t = this.f31885b;
        if (t == 0 || ((c) t).f32154c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32154c) {
            cVar.c();
        }
    }
}
