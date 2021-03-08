package com.kwad.sdk.contentalliance.home.c.b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.request.e;
import com.kwad.sdk.utils.ag;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.contentalliance.home.c.a.a {
    private ImageView b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) this.f6892a).i;
        PhotoInfo k = com.kwad.sdk.core.response.b.c.k(adTemplate);
        String d = d.d(k);
        String g = ag.a(d) ? d.g(k) : d;
        if (ag.a(g)) {
            return;
        }
        com.kwad.sdk.glide.c.a(((com.kwad.sdk.contentalliance.home.c.a.b) this.f6892a).d).a(g).a((e<Drawable>) new com.kwad.sdk.c(g, adTemplate)).a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (ImageView) b(R.id.ksad_slide_profile_cover);
    }
}
