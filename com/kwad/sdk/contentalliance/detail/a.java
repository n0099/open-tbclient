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
    public SlidePlayViewPager f32307d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public h f32308e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f32309f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32310g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32311h;

    @Override // com.kwad.sdk.contentalliance.b
    public void a() {
        super.a();
    }

    public void a(h hVar) {
        this.f32308e = hVar;
    }

    public final void e() {
        if (o() && !this.f32309f) {
            this.f32309f = true;
            j();
        }
    }

    public final void f() {
        if (o() && this.f32309f) {
            this.f32309f = false;
            k();
        }
    }

    public final void g() {
        if (o() && !this.f32310g) {
            this.f32310g = true;
            l();
        }
    }

    public final void h() {
        if (o() && this.f32310g) {
            this.f32310g = false;
            m();
        }
    }

    public final void i() {
        int i = getArguments() != null ? getArguments().getInt("KEY_INDEX_IN_VIEW_PAGER") : -1;
        SlidePlayViewPager slidePlayViewPager = this.f32307d;
        if (slidePlayViewPager == null || i != slidePlayViewPager.getRealPosition()) {
            return;
        }
        e();
        g();
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void j() {
        T t = this.f32269b;
        if (t == 0 || ((c) t).f32537b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32537b) {
            aVar.j();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void k() {
        T t = this.f32269b;
        if (t == 0 || ((c) t).f32537b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32537b) {
            aVar.k();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void l() {
        T t = this.f32269b;
        if (t == 0 || ((c) t).f32537b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32537b) {
            aVar.l();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void m() {
        T t = this.f32269b;
        if (t == 0 || ((c) t).f32537b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f32537b) {
            aVar.m();
        }
    }

    public boolean n() {
        return this.f32311h;
    }

    public boolean o() {
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f32311h = true;
        i();
        T t = this.f32269b;
        if (t == 0 || ((c) t).f32538c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32538c) {
            cVar.e();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        T t = this.f32269b;
        if (t == 0 || ((c) t).f32538c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32538c) {
            cVar.a(i, i2, intent);
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (viewGroup instanceof SlidePlayViewPager) {
            this.f32307d = (SlidePlayViewPager) viewGroup;
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        T t = this.f32269b;
        if (t == 0 || ((c) t).f32538c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32538c) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        T t = this.f32269b;
        if (t != 0) {
            ((c) t).a();
        }
        this.f32311h = false;
        f();
        h();
        T t2 = this.f32269b;
        if (t2 == 0 || ((c) t2).f32538c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t2).f32538c) {
            cVar.f();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        T t = this.f32269b;
        if (t == 0 || ((c) t).f32538c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32538c) {
            cVar.d();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        T t = this.f32269b;
        if (t == 0 || ((c) t).f32538c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f32538c) {
            cVar.c();
        }
    }
}
