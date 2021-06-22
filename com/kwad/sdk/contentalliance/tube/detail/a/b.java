package com.kwad.sdk.contentalliance.tube.detail.a;

import com.kwad.sdk.contentalliance.tube.a.c;
import com.kwad.sdk.contentalliance.tube.b;
import com.kwad.sdk.contentalliance.tube.detail.TubeDetailParam;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public c f33867a;

    /* renamed from: b  reason: collision with root package name */
    public TubeDetailParam f33868b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33869c;

    /* renamed from: d  reason: collision with root package name */
    public Set<b.a> f33870d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    public Set<com.kwad.sdk.contentalliance.tube.detail.a> f33871e = new LinkedHashSet();

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f33872f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.tube.b f33873g;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.f33870d.clear();
        com.kwad.sdk.core.i.a aVar = this.f33869c;
        if (aVar != null) {
            aVar.f();
        }
    }
}
