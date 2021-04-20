package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.os.Bundle;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
/* loaded from: classes6.dex */
public class b<T extends KsFragment> {

    /* renamed from: a  reason: collision with root package name */
    public Class<T> f36352a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f36353b;

    /* renamed from: c  reason: collision with root package name */
    public PagerSlidingTabStrip.c f36354c;

    public b() {
    }

    public b(PagerSlidingTabStrip.c cVar, Class<T> cls, Bundle bundle) {
        this.f36354c = cVar;
        this.f36352a = cls;
        this.f36353b = bundle;
    }

    public PagerSlidingTabStrip.c a() {
        return this.f36354c;
    }

    public void a(int i, T t) {
    }

    public Class<T> b() {
        return this.f36352a;
    }

    public Bundle c() {
        return this.f36353b;
    }
}
