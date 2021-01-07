package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.os.Bundle;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
/* loaded from: classes5.dex */
public class b<T extends KsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private Class<T> f10775a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f10776b;
    private PagerSlidingTabStrip.c c;

    public b() {
    }

    public b(PagerSlidingTabStrip.c cVar, Class<T> cls, Bundle bundle) {
        this.c = cVar;
        this.f10775a = cls;
        this.f10776b = bundle;
    }

    public PagerSlidingTabStrip.c a() {
        return this.c;
    }

    public void a(int i, T t) {
    }

    public Class<T> b() {
        return this.f10775a;
    }

    public Bundle c() {
        return this.f10776b;
    }
}
