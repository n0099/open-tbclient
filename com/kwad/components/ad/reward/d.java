package com.kwad.components.ad.reward;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d extends com.kwad.components.ad.k.b {
    public boolean oA;
    public List<com.kwad.components.core.e.d.c> oB;
    public w.b oC;
    public List<AdTemplate> oz;

    @Override // com.kwad.components.ad.k.b
    public final boolean fj() {
        return false;
    }

    @Override // com.kwad.components.ad.k.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    public d(List<AdTemplate> list, @Nullable JSONObject jSONObject, w.b bVar) {
        super(jSONObject, null);
        this.oA = false;
        this.oB = new ArrayList();
        this.oz = list;
        this.oC = bVar;
        if (list != null && list.size() > 0) {
            for (AdTemplate adTemplate : this.oz) {
                this.oB.add(new com.kwad.components.core.e.d.c(adTemplate));
            }
        }
    }

    @Override // com.kwad.components.ad.k.b
    public final String B(AdTemplate adTemplate) {
        List<AdTemplate> list = this.oz;
        if (list != null && list.size() >= 2) {
            String cn2 = com.kwad.sdk.core.response.b.b.cn(this.oz.get(1));
            new StringBuilder("getUrl: ").append(cn2);
            return cn2;
        }
        return super.B(adTemplate);
    }

    @Override // com.kwad.components.ad.k.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.oz;
        w wVar = new w(new ArrayList(list.subList(1, list.size() - 1)));
        wVar.a(this.oC);
        aVar.a(wVar);
    }

    @Override // com.kwad.components.ad.k.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.oz);
    }

    public final void setShowLandingPage(boolean z) {
        this.oA = z;
    }

    @Override // com.kwad.components.ad.k.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, int i) {
        super.a(frameLayout, adBaseFrameLayout, this.oz, this.oB);
    }

    @Override // com.kwad.components.ad.k.b
    public final boolean bx() {
        if (this.oA) {
            return this.HK;
        }
        return super.bx();
    }

    @Override // com.kwad.components.ad.k.b
    @SuppressLint({"ClickableViewAccessibility"})
    public final void fi() {
        super.fi();
        this.cL.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    return true;
                }
                return false;
            }
        });
    }

    public final void fk() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sh();
        }
    }

    @Override // com.kwad.components.ad.k.b
    public final void fl() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.k.b
    public final void fm() {
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.c.a(adTemplate, true, "middle_play_end_card", B(adTemplate));
    }

    @Override // com.kwad.components.ad.k.b
    public final void fn() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card", B(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }
}
