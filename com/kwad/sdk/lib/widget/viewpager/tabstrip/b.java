package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.os.Bundle;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
/* loaded from: classes7.dex */
public class b<T extends KsFragment> {

    /* renamed from: a  reason: collision with root package name */
    public Class<T> f36870a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f36871b;

    /* renamed from: c  reason: collision with root package name */
    public PagerSlidingTabStrip.c f36872c;

    public b() {
    }

    public b(PagerSlidingTabStrip.c cVar, Class<T> cls, Bundle bundle) {
        this.f36872c = cVar;
        this.f36870a = cls;
        this.f36871b = bundle;
    }

    public PagerSlidingTabStrip.c a() {
        return this.f36872c;
    }

    public void a(int i2, T t) {
    }

    public Class<T> b() {
        return this.f36870a;
    }

    public Bundle c() {
        return this.f36871b;
    }
}
