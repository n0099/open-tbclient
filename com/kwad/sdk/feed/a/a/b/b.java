package com.kwad.sdk.feed.a.a.b;

import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.feed.a.a.a.a implements View.OnClickListener {
    private ImageView b;
    private AdTemplate c;
    private com.kwad.sdk.lib.b.c<?, AdTemplate> d;

    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: com.kwad.sdk.lib.b.c<?, MODEL>, com.kwad.sdk.lib.b.c<?, com.kwad.sdk.core.response.model.AdTemplate> */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.c = (AdTemplate) ((com.kwad.sdk.feed.a.a.a.b) this.f6892a).i;
        this.d = ((com.kwad.sdk.feed.a.a.a.b) this.f6892a).f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.b = (ImageView) b(R.id.ksad_feed_item_close);
        this.b.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.a()) {
            return;
        }
        if (view == this.b && com.kwad.sdk.core.response.b.c.c(this.c)) {
            com.kwad.sdk.core.report.b.d(this.c, 69);
        }
        this.d.a((com.kwad.sdk.lib.b.c<?, AdTemplate>) this.c);
    }
}
