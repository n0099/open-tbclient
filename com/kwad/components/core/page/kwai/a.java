package com.kwad.components.core.page.kwai;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.widget.d;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes9.dex */
public final class a extends Presenter {
    public int Gd;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        final com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) xR();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(true).build();
        com.kwad.components.core.widget.d dVar = (com.kwad.components.core.widget.d) getRootView();
        dVar.c(eVar.adTemplate);
        dVar.a(build, eVar.DV);
        dVar.setVisibility(0);
        dVar.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.kwai.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(eVar.adTemplate))) {
                    if (eVar.DV != null) {
                        eVar.DV.m(new a.C0641a(a.this.getActivity()).aj(false).ak(false).L(eVar.adTemplate).am(false));
                        return;
                    }
                    return;
                }
                RecyclerView recyclerView = eVar.GU;
                if (recyclerView == null || recyclerView.getAdapter() == null || eVar.GU.getAdapter().getItemCount() <= 1) {
                    return;
                }
                eVar.GU.scrollToPosition(1);
            }
        });
        dVar.setWindowFullScreenListener(new d.a() { // from class: com.kwad.components.core.page.kwai.a.2
            @Override // com.kwad.components.core.widget.d.a
            public final void nL() {
                a.this.Gd = eVar.GU.computeVerticalScrollOffset();
            }

            @Override // com.kwad.components.core.widget.d.a
            public final void nM() {
                eVar.GU.scrollToPosition(a.this.Gd);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
