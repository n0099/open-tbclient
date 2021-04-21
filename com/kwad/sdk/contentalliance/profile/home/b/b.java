package com.kwad.sdk.contentalliance.profile.home.b;

import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.contentalliance.profile.home.c;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public c f33253a;

    /* renamed from: b  reason: collision with root package name */
    public SceneImpl f33254b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f33255c;

    /* renamed from: d  reason: collision with root package name */
    public ProfileHomeParam f33256d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33257e;

    /* renamed from: f  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.profile.home.a.a> f33258f = new LinkedHashSet();

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.f33258f.clear();
        com.kwad.sdk.core.i.a aVar = this.f33257e;
        if (aVar != null) {
            aVar.f();
        }
    }
}
