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
/* loaded from: classes5.dex */
public abstract class a extends com.kwad.sdk.contentalliance.b<c> implements com.kwad.sdk.contentalliance.a.a {
    @Nullable
    protected SlidePlayViewPager d;
    @Nullable
    protected h e;
    protected boolean f;
    protected boolean g;
    private boolean h;

    @Override // com.kwad.sdk.contentalliance.b
    public void a() {
        super.a();
    }

    public void a(h hVar) {
        this.e = hVar;
    }

    public final void e() {
        if (o() && !this.f) {
            this.f = true;
            j();
        }
    }

    public final void f() {
        if (o() && this.f) {
            this.f = false;
            k();
        }
    }

    public final void g() {
        if (o() && !this.g) {
            this.g = true;
            l();
        }
    }

    public final void h() {
        if (o() && this.g) {
            this.g = false;
            m();
        }
    }

    protected final void i() {
        int i = getArguments() != null ? getArguments().getInt("KEY_INDEX_IN_VIEW_PAGER") : -1;
        if (this.d == null || i != this.d.getRealPosition()) {
            return;
        }
        e();
        g();
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void j() {
        if (this.f8563b == 0 || ((c) this.f8563b).f8702b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) this.f8563b).f8702b) {
            aVar.j();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void k() {
        if (this.f8563b == 0 || ((c) this.f8563b).f8702b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) this.f8563b).f8702b) {
            aVar.k();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void l() {
        if (this.f8563b == 0 || ((c) this.f8563b).f8702b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) this.f8563b).f8702b) {
            aVar.l();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void m() {
        if (this.f8563b == 0 || ((c) this.f8563b).f8702b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) this.f8563b).f8702b) {
            aVar.m();
        }
    }

    public boolean n() {
        return this.h;
    }

    protected boolean o() {
        return true;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.h = true;
        i();
        if (this.f8563b == 0 || ((c) this.f8563b).c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) this.f8563b).c) {
            cVar.e();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f8563b == 0 || ((c) this.f8563b).c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) this.f8563b).c) {
            cVar.a(i, i2, intent);
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (viewGroup instanceof SlidePlayViewPager) {
            this.d = (SlidePlayViewPager) viewGroup;
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (this.f8563b == 0 || ((c) this.f8563b).c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) this.f8563b).c) {
            cVar.g();
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        if (this.f8563b != 0) {
            ((c) this.f8563b).a();
        }
        this.h = false;
        f();
        h();
        if (this.f8563b == 0 || ((c) this.f8563b).c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) this.f8563b).c) {
            cVar.f();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        if (this.f8563b == 0 || ((c) this.f8563b).c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) this.f8563b).c) {
            cVar.d();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        if (this.f8563b == 0 || ((c) this.f8563b).c == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.c cVar : ((c) this.f8563b).c) {
            cVar.c();
        }
    }
}
