package com.kwad.components.ad.reward.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.v;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class a {
    public static volatile a rg;
    public g qn;
    @Nullable
    public b rh;
    public volatile boolean ri = false;
    public volatile boolean rj = false;
    public List<WeakReference<h>> rk = new CopyOnWriteArrayList();

    public static a gJ() {
        if (rg == null) {
            synchronized (a.class) {
                if (rg == null) {
                    rg = new a();
                }
            }
        }
        return rg;
    }

    private synchronized boolean gL() {
        boolean z;
        if (this.rh != null) {
            if (this.rh.ro == b.rl) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    private boolean isNeoScan() {
        AdGlobalConfigInfo adGlobalConfigInfo = this.qn.mAdResultData.adGlobalConfigInfo;
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            return true;
        }
        return false;
    }

    @NonNull
    public final synchronized b gK() {
        if (this.rh == null) {
            b gN = c.gN();
            this.rh = gN;
            gN.ro = 0;
        }
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.rh.ro);
        return this.rh;
    }

    public final synchronized void reset() {
        this.rh = null;
        this.rj = false;
        this.ri = false;
        this.qn = null;
    }

    public final void M(Context context) {
        boolean gL = gL();
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + gL + ", hadToast: " + this.rj);
        if (!this.rj && gL) {
            this.rj = true;
            v.O(context, "恭喜获得第2份奖励");
        }
    }

    public final void a(h hVar) {
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + hVar);
        if (hVar != null) {
            this.rk.add(new WeakReference<>(hVar));
        }
    }

    public final void setCallerContext(g gVar) {
        this.qn = gVar;
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
        this.rh = bVar;
        if (bVar.ro == b.rl && !this.ri) {
            this.ri = true;
            c.a(this.rh, com.kwad.components.ad.reward.e.f.G(adTemplate.getUniqueId()));
            com.kwad.sdk.core.report.a.h(adTemplate, isNeoScan());
        }
        for (WeakReference<h> weakReference : this.rk) {
            if (weakReference.get() == null) {
                this.rk.remove(weakReference);
            } else {
                b gK = gK();
                com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + gK.toJson().toString());
                weakReference.get().a(gK);
            }
        }
    }

    public final synchronized void c(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + i);
        if (this.qn != null && this.qn.fL() && i == b.STATUS_NONE) {
            com.kwad.sdk.core.e.c.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        b gK = gJ().gK();
        gK.M(i);
        gJ().a(adTemplate, gK);
    }
}
