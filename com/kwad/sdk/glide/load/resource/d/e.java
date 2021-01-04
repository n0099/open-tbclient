package com.kwad.sdk.glide.load.resource.d;

import androidx.annotation.NonNull;
import com.kwad.sdk.glide.load.engine.o;
/* loaded from: classes5.dex */
public class e extends com.kwad.sdk.glide.load.resource.b.b<c> implements o {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<c> a() {
        return c.class;
    }

    @Override // com.kwad.sdk.glide.load.resource.b.b, com.kwad.sdk.glide.load.engine.o
    public void b() {
        ((c) this.f10559a).b().prepareToDraw();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return ((c) this.f10559a).a();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
        ((c) this.f10559a).stop();
        ((c) this.f10559a).g();
    }
}
