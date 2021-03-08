package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.os.Bundle;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
/* loaded from: classes3.dex */
public class b<T extends KsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private Class<T> f6907a;
    private Bundle b;
    private PagerSlidingTabStrip.c c;

    public b() {
    }

    public b(PagerSlidingTabStrip.c cVar, Class<T> cls, Bundle bundle) {
        this.c = cVar;
        this.f6907a = cls;
        this.b = bundle;
    }

    public PagerSlidingTabStrip.c a() {
        return this.c;
    }

    public void a(int i, T t) {
    }

    public Class<T> b() {
        return this.f6907a;
    }

    public Bundle c() {
        return this.b;
    }
}
