package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class RewardActionBarControl {
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public g qn;
    public b uD;
    @Nullable
    public d uH;
    @Nullable
    public c uI;
    public final long uK;
    @NonNull
    public a uJ = new a((byte) 0);
    public Handler fS = new Handler(Looper.getMainLooper());
    public boolean uL = false;
    public boolean uM = false;

    /* loaded from: classes10.dex */
    public enum ShowActionBarResult {
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE,
        SHOW_NATIVE_ORIGIN_LIVE
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes10.dex */
    public interface d {
        boolean f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes10.dex */
    public static class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        public List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> uR;
        public ShowActionBarResult uS;

        public a() {
            this.uR = new CopyOnWriteArrayList();
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.uR.add(aVar);
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.uR.remove(aVar);
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view2) {
            com.kwad.sdk.core.e.c.d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
            this.uS = showActionBarResult;
            for (com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar : this.uR) {
                aVar.a(showActionBarResult, view2);
            }
        }
    }

    public RewardActionBarControl(g gVar, Context context, AdTemplate adTemplate) {
        long j;
        this.qn = gVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        if (com.kwad.sdk.core.response.b.b.ck(adTemplate) > 0) {
            j = com.kwad.sdk.core.response.b.b.ck(adTemplate);
        } else {
            j = 1000;
        }
        this.uK = j > 0 ? j : 1000L;
    }

    private ShowActionBarResult P(boolean z) {
        c cVar;
        if (com.kwad.components.ad.reward.a.b.i(this.mAdInfo) && (cVar = this.uI) != null) {
            cVar.e(this.uJ);
            return ShowActionBarResult.SHOW_ORDER;
        } else if (com.kwad.sdk.core.response.b.b.cl(this.mAdTemplate) && !com.kwad.sdk.core.response.b.a.bd(this.mAdInfo) && this.uH != null) {
            com.kwad.sdk.core.e.c.d("ActionBarControl", "showWebActionBar success in " + this.uK);
            if (this.uH.f(this.uJ)) {
                return ShowActionBarResult.SHOW_H5_SUCCESS;
            }
            return ShowActionBarResult.SHOW_H5_FAILURE;
        } else {
            Q(z);
            return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z) {
        if (this.uD != null) {
            com.kwad.sdk.core.e.c.d("ActionBarControl", "showNativeActionBar");
            this.uM = true;
            this.uD.a(z, this.uJ);
        }
    }

    public final void O(boolean z) {
        ShowActionBarResult P = P(z);
        com.kwad.sdk.core.e.c.d("ActionBarControl", "showActionBarOnVideoStart result: " + P);
        if (P != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // java.lang.Runnable
            public final void run() {
                RewardActionBarControl.a(RewardActionBarControl.this, true);
                com.kwad.sdk.core.e.c.d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.uH != null && !RewardActionBarControl.this.uM && RewardActionBarControl.this.uH.f(RewardActionBarControl.this.uJ)) {
                    com.kwad.sdk.core.e.c.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.uK);
                    return;
                }
                com.kwad.sdk.core.e.c.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.uK);
                com.kwad.components.core.o.a.pX().i(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.uK);
                com.kwad.components.ad.reward.monitor.c.a(RewardActionBarControl.this.qn.mAdTemplate, RewardActionBarControl.this.qn.oX, "play_card", com.kwad.sdk.core.response.b.b.cj(RewardActionBarControl.this.qn.mAdTemplate), RewardActionBarControl.this.uK, 1);
                RewardActionBarControl.this.Q(true);
            }
        }, this.uK);
    }

    public static void a(final com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, final View view2, final ShowActionBarResult showActionBarResult) {
        if (aVar != null) {
            view2.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.ad.reward.presenter.platdetail.actionbar.a.this.a(showActionBarResult, view2);
                }
            });
        }
    }

    public static /* synthetic */ boolean a(RewardActionBarControl rewardActionBarControl, boolean z) {
        rewardActionBarControl.uL = true;
        return true;
    }

    @MainThread
    public final void a(b bVar) {
        this.uD = bVar;
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.uJ.d(aVar);
    }

    @MainThread
    public final void a(@Nullable c cVar) {
        this.uI = cVar;
    }

    @MainThread
    public final void a(d dVar) {
        this.uH = dVar;
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.uJ.c(aVar);
    }

    public final void id() {
        if (this.uL) {
            com.kwad.sdk.core.e.c.i("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.fS.removeCallbacksAndMessages(null);
        P(true);
    }

    @Nullable
    public final ShowActionBarResult ie() {
        return this.uJ.uS;
    }
}
