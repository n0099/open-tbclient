package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes8.dex */
public final class RewardActionBarControl {
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public Context mContext;
    public k nM;
    @Nullable
    public c rA;
    @Nullable
    public d rB;
    @Nullable
    public e rC;
    public final long rE;
    public b rw;
    @Nullable
    public f rz;
    @NonNull
    public a rD = new a((byte) 0);
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean rF = false;

    /* loaded from: classes8.dex */
    public enum ShowActionBarResult {
        SHOW_NEW_STYLE,
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        TK,
        TK_NEW_STYLE,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE
    }

    /* loaded from: classes8.dex */
    public static class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        public List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> rK;
        public ShowActionBarResult rL;

        public a() {
            this.rK = new CopyOnWriteArrayList();
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view2) {
            com.kwad.sdk.core.e.b.d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
            this.rL = showActionBarResult;
            for (com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar : this.rK) {
                aVar.a(showActionBarResult, view2);
            }
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.rK.add(aVar);
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.rK.remove(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(boolean z, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes8.dex */
    public interface d {
        void f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    /* loaded from: classes8.dex */
    public interface e {
    }

    /* loaded from: classes8.dex */
    public interface f {
        boolean g(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public RewardActionBarControl(k kVar, Context context, AdTemplate adTemplate) {
        this.nM = kVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        long aO = !com.kwad.sdk.core.response.a.a.bF(this.mAdInfo) ? com.kwad.sdk.core.response.a.b.aO(adTemplate) : 1000L;
        this.rE = aO > 0 ? aO : 1000L;
    }

    private ShowActionBarResult T(boolean z) {
        c cVar;
        if (k.c(this.nM)) {
            if (com.kwad.sdk.core.response.a.b.e(this.mContext, this.mAdTemplate) && this.rC != null) {
                return ShowActionBarResult.TK_NEW_STYLE;
            }
            d dVar = this.rB;
            if (dVar != null) {
                dVar.f(this.rD);
                return ShowActionBarResult.TK;
            }
        }
        if (com.kwad.components.ad.reward.kwai.b.h(this.mAdInfo) && (cVar = this.rA) != null) {
            cVar.e(this.rD);
            return ShowActionBarResult.SHOW_ORDER;
        } else if (com.kwad.sdk.core.response.a.a.c(this.mAdTemplate, this.mAdInfo)) {
            return ShowActionBarResult.SHOW_NEW_STYLE;
        } else {
            if (!com.kwad.sdk.core.response.a.b.aP(this.mAdTemplate) || this.rz == null) {
                U(z);
                return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
            }
            com.kwad.sdk.core.e.b.d("ActionBarControl", "showWebActionBar success in " + this.rE);
            return this.rz.g(this.rD) ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(boolean z) {
        if (this.rw != null) {
            com.kwad.sdk.core.e.b.d("ActionBarControl", "showNativeActionBar");
            this.rw.a(z, this.rD);
        }
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
        rewardActionBarControl.rF = true;
        return true;
    }

    public final void S(boolean z) {
        ShowActionBarResult T = T(z);
        com.kwad.sdk.core.e.b.d("ActionBarControl", "showActionBarOnVideoStart result: " + T);
        if (T != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // java.lang.Runnable
            public final void run() {
                RewardActionBarControl.a(RewardActionBarControl.this, true);
                com.kwad.sdk.core.e.b.d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.rz != null && RewardActionBarControl.this.rz.g(RewardActionBarControl.this.rD)) {
                    com.kwad.sdk.core.e.b.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.rE);
                    return;
                }
                com.kwad.sdk.core.e.b.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.rE);
                com.kwad.components.core.j.a.og().e(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.rE);
                com.kwad.components.ad.reward.monitor.a.a(RewardActionBarControl.this.nM.mz, "play_card", com.kwad.sdk.core.response.a.b.aN(RewardActionBarControl.this.nM.mAdTemplate), RewardActionBarControl.this.rE);
                RewardActionBarControl.this.U(true);
            }
        }, this.rE);
    }

    @MainThread
    public final void a(b bVar) {
        this.rw = bVar;
    }

    @MainThread
    public final void a(@Nullable c cVar) {
        this.rA = cVar;
    }

    public final void a(@Nullable d dVar) {
        this.rB = dVar;
    }

    @MainThread
    public final void a(f fVar) {
        this.rz = fVar;
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.rD.c(aVar);
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.rD.d(aVar);
    }

    public final void hw() {
        if (this.rF) {
            com.kwad.sdk.core.e.b.i("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        T(true);
    }

    @Nullable
    public final ShowActionBarResult hx() {
        return this.rD.rL;
    }
}
