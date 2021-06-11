package com.kwad.sdk.core.page.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.feed.widget.k;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes4.dex */
public class a extends Presenter {
    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        final e eVar = (e) n();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(true).build();
        k kVar = (k) l();
        kVar.a(eVar.f34573c);
        kVar.a(build);
        kVar.setVisibility(0);
        kVar.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.kwad.sdk.core.response.b.a.y(c.j(eVar.f34573c))) {
                    com.kwad.sdk.core.download.b.b bVar = eVar.f34571a;
                    if (bVar != null) {
                        bVar.a(a.this.m());
                        return;
                    }
                    return;
                }
                RecyclerView recyclerView = eVar.f34572b;
                if (recyclerView == null || recyclerView.getAdapter() == null || eVar.f34572b.getAdapter().getItemCount() <= 1) {
                    return;
                }
                eVar.f34572b.scrollToPosition(1);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }
}
