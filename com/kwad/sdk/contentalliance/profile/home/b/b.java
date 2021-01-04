package com.kwad.sdk.contentalliance.profile.home.b;

import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.contentalliance.profile.home.ProfileHomeParam;
import com.kwad.sdk.contentalliance.profile.home.c;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public c f9078a;

    /* renamed from: b  reason: collision with root package name */
    public SceneImpl f9079b;
    public ViewPager c;
    public ProfileHomeParam d;
    public com.kwad.sdk.core.i.a e;
    public Set<com.kwad.sdk.contentalliance.profile.home.a.a> f = new LinkedHashSet();

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.f.clear();
        if (this.e != null) {
            this.e.f();
        }
    }
}
