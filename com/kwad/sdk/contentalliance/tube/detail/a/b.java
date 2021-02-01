package com.kwad.sdk.contentalliance.tube.detail.a;

import com.kwad.sdk.contentalliance.tube.a.c;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.detail.TubeDetailParam;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public c f8925a;

    /* renamed from: b  reason: collision with root package name */
    public TubeDetailParam f8926b;
    public com.kwad.sdk.core.i.a c;
    public Set<b.a> d = new LinkedHashSet();
    public Set<com.kwad.sdk.contentalliance.tube.detail.a> e = new LinkedHashSet();
    public SceneImpl f;
    public com.kwad.sdk.contentalliance.tube.b g;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.d.clear();
        if (this.c != null) {
            this.c.f();
        }
    }
}
