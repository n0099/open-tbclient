package com.kwad.components.ad.reward;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class h extends com.kwad.components.ad.i.b {
    public List<AdTemplate> mc;
    public boolean md;
    public List<com.kwad.components.core.c.a.c> me;
    public e.b mf;

    public h(List<AdTemplate> list, @Nullable JSONObject jSONObject, e.b bVar) {
        super(jSONObject, null);
        this.md = false;
        this.me = new ArrayList();
        this.mc = list;
        this.mf = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (AdTemplate adTemplate : this.mc) {
            this.me.add(new com.kwad.components.core.c.a.c(adTemplate));
        }
    }

    public final void A(boolean z) {
        this.md = z;
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.c.a.c cVar, int i) {
        super.a(frameLayout, adBaseFrameLayout, this.mc, this.me, i);
    }

    @Override // com.kwad.components.ad.i.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.mc;
        com.kwad.components.core.webview.jshandler.e eVar = new com.kwad.components.core.webview.jshandler.e(new ArrayList(list.subList(1, list.size() - 1)));
        eVar.a(this.mf);
        aVar.a(eVar);
    }

    @Override // com.kwad.components.ad.i.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.mc);
    }

    @Override // com.kwad.components.ad.i.b
    public final boolean bs() {
        return this.md ? this.Cc : super.bs();
    }

    @Override // com.kwad.components.ad.i.b
    @SuppressLint({"ClickableViewAccessibility"})
    public final void fh() {
        super.fh();
        this.bF.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.h.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
    }

    @Override // com.kwad.components.ad.i.b
    public final boolean fi() {
        return false;
    }

    public final void fj() {
        aa aaVar = this.bI;
        if (aaVar != null) {
            aaVar.pz();
        }
    }

    @Override // com.kwad.components.ad.i.b
    public final void fk() {
        com.kwad.components.ad.reward.monitor.a.a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.i.b
    public final void fl() {
        com.kwad.components.ad.reward.monitor.a.a(true, "middle_play_end_card", l(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.i.b
    public final void fm() {
        com.kwad.components.ad.reward.monitor.a.b(true, "middle_play_end_card", l(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.i.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    @Override // com.kwad.components.ad.i.b
    public final String l(AdTemplate adTemplate) {
        List<AdTemplate> list = this.mc;
        if (list == null || list.size() < 2) {
            return super.l(adTemplate);
        }
        String aR = com.kwad.sdk.core.response.a.b.aR(this.mc.get(1));
        new StringBuilder("getUrl: ").append(aR);
        return aR;
    }
}
