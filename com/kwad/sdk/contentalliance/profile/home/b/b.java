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
    public c f32869a;

    /* renamed from: b  reason: collision with root package name */
    public SceneImpl f32870b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f32871c;

    /* renamed from: d  reason: collision with root package name */
    public ProfileHomeParam f32872d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f32873e;

    /* renamed from: f  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.profile.home.a.a> f32874f = new LinkedHashSet();

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.f32874f.clear();
        com.kwad.sdk.core.i.a aVar = this.f32873e;
        if (aVar != null) {
            aVar.f();
        }
    }
}
