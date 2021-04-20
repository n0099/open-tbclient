package com.kwad.sdk.contentalliance.detail.photo.related.b;

import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class d extends com.kwad.sdk.contentalliance.detail.photo.related.a.a {

    /* renamed from: b  reason: collision with root package name */
    public TextView f32778b;

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f32778b.setText(ag.a(com.kwad.sdk.core.response.b.c.s((AdTemplate) ((com.kwad.sdk.contentalliance.detail.photo.related.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36297a).i)));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32778b = (TextView) b(R.id.ksad_related_like_count);
    }
}
