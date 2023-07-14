package com.kwad.components.ad.reward.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class a {
    public static volatile a oE;
    public k nM;
    @Nullable
    public b oF;
    public volatile boolean oG = false;
    public volatile boolean oH = false;
    public List<WeakReference<com.kwad.components.core.webview.jshandler.a>> oI = new CopyOnWriteArrayList();

    public static a gp() {
        if (oE == null) {
            synchronized (a.class) {
                if (oE == null) {
                    oE = new a();
                }
            }
        }
        return oE;
    }

    private synchronized boolean gr() {
        boolean z;
        if (this.oF != null) {
            z = this.oF.oM == b.oJ;
        }
        return z;
    }

    public final void O(Context context) {
        boolean gr = gr();
        com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + gr + ", hadToast: " + this.oH);
        if (this.oH || !gr) {
            return;
        }
        this.oH = true;
        t.z(context, "恭喜获得第2份奖励");
    }

    public final void a(com.kwad.components.core.webview.jshandler.a aVar) {
        com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + aVar);
        if (aVar != null) {
            this.oI.add(new WeakReference<>(aVar));
        }
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
        this.oF = bVar;
        if (bVar.oM == b.oJ && !this.oG) {
            this.oG = true;
            c.a(this.oF, KSRewardVideoActivityProxy.a.E(adTemplate.getUniqueId()));
            com.kwad.sdk.core.report.a.aF(adTemplate);
        }
        for (WeakReference<com.kwad.components.core.webview.jshandler.a> weakReference : this.oI) {
            if (weakReference.get() == null) {
                this.oI.remove(weakReference);
            } else {
                b gq = gq();
                com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + gq.toJson().toString());
                weakReference.get().a(gq);
            }
        }
    }

    public final synchronized void b(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "updateExtraReward: " + i);
        if (this.nM != null && this.nM.mRewardVerifyCalled && i == b.STATUS_NONE) {
            com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        b gq = gp().gq();
        gq.N(i);
        gp().a(adTemplate, gq);
    }

    @NonNull
    public final synchronized b gq() {
        if (this.oF == null) {
            b gt = c.gt();
            this.oF = gt;
            gt.oM = 0;
        }
        com.kwad.sdk.core.e.b.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.oF.oM);
        return this.oF;
    }

    public final synchronized void reset() {
        this.oF = null;
        this.oH = false;
        this.oG = false;
        this.nM = null;
    }

    public final void setCallerContext(k kVar) {
        this.nM = kVar;
    }
}
