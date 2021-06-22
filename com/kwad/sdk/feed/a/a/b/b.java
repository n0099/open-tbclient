package com.kwad.sdk.feed.a.a.b;

import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35594b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f35595c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f35596d;

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, MODEL>, com.kwad.sdk.lib.b.c<?, com.kwad.sdk.core.response.model.AdTemplate> */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f36811a;
        this.f35595c = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36810i;
        this.f35596d = ((com.kwad.sdk.feed.a.a.a.b) callercontext).f36807f;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ImageView imageView = (ImageView) b(R.id.ksad_feed_item_close);
        this.f35594b = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.a()) {
            return;
        }
        if (view == this.f35594b && com.kwad.sdk.core.response.b.c.c(this.f35595c)) {
            com.kwad.sdk.core.report.b.d(this.f35595c, 69);
        }
        this.f35596d.a((com.kwad.sdk.lib.b.c<?, AdTemplate>) this.f35595c);
    }
}
