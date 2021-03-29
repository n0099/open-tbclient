package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.os.Bundle;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
/* loaded from: classes6.dex */
public class b<T extends KsFragment> {

    /* renamed from: a  reason: collision with root package name */
    public Class<T> f36063a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f36064b;

    /* renamed from: c  reason: collision with root package name */
    public PagerSlidingTabStrip.c f36065c;

    public b() {
    }

    public b(PagerSlidingTabStrip.c cVar, Class<T> cls, Bundle bundle) {
        this.f36065c = cVar;
        this.f36063a = cls;
        this.f36064b = bundle;
    }

    public PagerSlidingTabStrip.c a() {
        return this.f36065c;
    }

    public void a(int i, T t) {
    }

    public Class<T> b() {
        return this.f36063a;
    }

    public Bundle c() {
        return this.f36064b;
    }
}
