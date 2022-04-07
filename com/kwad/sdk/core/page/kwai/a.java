package com.kwad.sdk.core.page.kwai;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.page.recycle.e;
import com.kwad.sdk.feed.widget.k;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class a extends Presenter {
    public int a;

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        final e eVar = (e) p();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(true).build();
        k kVar = (k) m();
        kVar.a(eVar.c);
        kVar.a(build, eVar.a);
        kVar.setVisibility(0);
        kVar.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.page.kwai.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.j(eVar.c))) {
                    com.kwad.sdk.core.download.a.b bVar = eVar.a;
                    if (bVar != null) {
                        bVar.a((Context) a.this.o(), false);
                        return;
                    }
                    return;
                }
                RecyclerView recyclerView = eVar.b;
                if (recyclerView == null || recyclerView.getAdapter() == null || eVar.b.getAdapter().getItemCount() <= 1) {
                    return;
                }
                eVar.b.scrollToPosition(1);
            }
        });
        kVar.setWindowFullScreenListener(new k.a() { // from class: com.kwad.sdk.core.page.kwai.a.2
            @Override // com.kwad.sdk.feed.widget.k.a
            public void a() {
                a.this.a = eVar.b.computeVerticalScrollOffset();
            }

            @Override // com.kwad.sdk.feed.widget.k.a
            public void b() {
                eVar.b.scrollToPosition(a.this.a);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
    }
}
