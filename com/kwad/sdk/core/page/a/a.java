package com.kwad.sdk.core.page.a;

import android.view.View;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.feed.widget.k;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class a extends Presenter {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        final e eVar = (e) n();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(true).build();
        k kVar = (k) l();
        kVar.a(eVar.c);
        kVar.a(build);
        kVar.setVisibility(0);
        kVar.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.response.b.a.y(c.j(eVar.c))) {
                    if (eVar.f9658a != null) {
                        eVar.f9658a.a(a.this.m());
                    }
                } else if (eVar.f9659b == null || eVar.f9659b.getAdapter() == null || eVar.f9659b.getAdapter().getItemCount() <= 1) {
                } else {
                    eVar.f9659b.scrollToPosition(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }
}
