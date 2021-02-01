package com.kwad.sdk.contentalliance.tube.profile.a;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.contentalliance.tube.a.c;
import com.kwad.sdk.contentalliance.tube.profile.TubeProfileParam;
import com.kwad.sdk.contentalliance.tube.profile.e;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.e.b {

    /* renamed from: a  reason: collision with root package name */
    public c f8956a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f8957b;
    public TubeProfileParam c;
    public com.kwad.sdk.core.i.a d;
    public Set<e> e = new LinkedHashSet();
    public SceneImpl f;

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        this.e.clear();
        if (this.d != null) {
            this.d.f();
        }
    }
}
