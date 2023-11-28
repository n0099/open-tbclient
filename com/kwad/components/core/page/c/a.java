package com.kwad.components.core.page.c;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public final class a extends Presenter {
    public int On;
    public FeedVideoView Oo;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Oo.release();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        final com.kwad.components.core.page.recycle.e eVar = (com.kwad.components.core.page.recycle.e) HU();
        KsAdVideoPlayConfig build = new KsAdVideoPlayConfig.Builder().videoSoundEnable(eVar.adTemplate.mIsAudioEnable).build();
        FeedVideoView feedVideoView = (FeedVideoView) getRootView();
        this.Oo = feedVideoView;
        feedVideoView.b(com.kwad.sdk.core.response.b.c.dA(eVar.adTemplate));
        this.Oo.a(build, eVar.Kx);
        this.Oo.setVisibility(0);
        final AdInfo dP = com.kwad.sdk.core.response.b.e.dP(eVar.adTemplate);
        this.Oo.setOnEndBtnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (com.kwad.sdk.core.response.b.a.aF(dP)) {
                    if (eVar.Kx != null) {
                        com.kwad.components.core.e.d.a.a(new a.C0644a(a.this.getActivity()).ao(false).ap(false).at(true).aq(eVar.adTemplate).ar(false));
                        com.kwad.sdk.core.report.a.a(eVar.adTemplate, 50, a.this.Oo.getTouchCoords());
                        return;
                    }
                    return;
                }
                RecyclerView recyclerView = eVar.PK;
                if (recyclerView != null && recyclerView.getAdapter() != null && eVar.PK.getAdapter().getItemCount() > 1) {
                    eVar.PK.scrollToPosition(1);
                    com.kwad.sdk.core.report.a.a(eVar.adTemplate, 50, a.this.Oo.getTouchCoords());
                }
            }
        });
        if (com.kwad.sdk.core.response.b.a.aq(dP)) {
            this.Oo.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (com.kwad.sdk.core.response.b.a.aF(dP)) {
                        if (eVar.Kx != null) {
                            com.kwad.components.core.e.d.a.a(new a.C0644a(a.this.getActivity()).ao(false).ap(false).at(true).aq(eVar.adTemplate).ar(false));
                            com.kwad.sdk.core.report.a.a(eVar.adTemplate, (int) Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, a.this.Oo.getTouchCoords());
                            return;
                        }
                        return;
                    }
                    RecyclerView recyclerView = eVar.PK;
                    if (recyclerView != null && recyclerView.getAdapter() != null && eVar.PK.getAdapter().getItemCount() > 1) {
                        eVar.PK.scrollToPosition(1);
                        com.kwad.sdk.core.report.a.a(eVar.adTemplate, (int) Constants.METHOD_IM_GET_USERS_PROFILE_BATCH_BY_BAIDU_UID, a.this.Oo.getTouchCoords());
                    }
                }
            });
        }
        this.Oo.setWindowFullScreenListener(new FeedVideoView.a() { // from class: com.kwad.components.core.page.c.a.3
            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void pf() {
                RecyclerView recyclerView = eVar.PK;
                if (recyclerView != null) {
                    a.this.On = recyclerView.computeVerticalScrollOffset();
                }
            }

            @Override // com.kwad.components.core.widget.FeedVideoView.a
            public final void pg() {
                RecyclerView recyclerView = eVar.PK;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(a.this.On);
                }
            }
        });
    }
}
