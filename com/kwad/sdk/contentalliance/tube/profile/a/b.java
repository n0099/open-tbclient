package com.kwad.sdk.contentalliance.tube.profile.a;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.contentalliance.tube.a.c;
import com.kwad.sdk.contentalliance.tube.profile.TubeProfileParam;
import com.kwad.sdk.contentalliance.tube.profile.e;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public c f33845a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f33846b;

    /* renamed from: c  reason: collision with root package name */
    public TubeProfileParam f33847c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f33848d;

    /* renamed from: e  reason: collision with root package name */
    public Set<e> f33849e = new LinkedHashSet();

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f33850f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.f33849e.clear();
        com.kwad.sdk.core.i.a aVar = this.f33848d;
        if (aVar != null) {
            aVar.f();
        }
    }
}
