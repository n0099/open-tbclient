package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.o;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.b.b.d;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class k extends com.kwad.components.core.g.a {
    @NonNull
    public com.kwad.components.ad.reward.j.a eF;
    @NonNull
    public com.kwad.components.ad.reward.d.a mAdOpenInteractionListener;
    @NonNull
    public com.kwad.components.ad.reward.d.c mAdRewardStepListener;
    @NonNull
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public l mCloseDialog;
    @Nullable
    public com.kwad.components.ad.reward.i.a.a mK;
    @Nullable
    public com.kwad.components.ad.reward.i.kwai.a mL;
    public int mM;
    public long mO;
    public long mP;
    public long mPageEnterTime;
    public boolean mQ;
    @Nullable
    public JSONObject mReportExtData;
    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public boolean mT;
    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    @Nullable
    public com.kwad.components.ad.reward.h.kwai.b mW;
    @Nullable
    public com.kwad.components.ad.reward.h.kwai.b mX;
    public DetailVideoView mj;
    @Nullable
    public com.kwad.components.core.playable.a mk;
    @NonNull
    public RewardActionBarControl ml;
    @Nullable
    public m mm;
    @Nullable
    public com.kwad.components.ad.i.b mn;
    @Nullable
    public com.kwad.components.ad.i.a mo;
    @Nullable
    public h mp;
    @Nullable
    public com.kwad.components.ad.reward.g.c ms;
    @Nullable
    public com.kwad.components.core.webview.b.d.a mt;
    @Nullable
    public e.a mu;
    @Nullable
    public e.b mv;
    public boolean mz;
    public Set<com.kwad.components.ad.reward.d.e> mq = new HashSet();
    public Set<com.kwad.components.ad.reward.d.d> mr = new HashSet();
    public Set<com.kwad.components.core.webview.b.d.b> mw = new HashSet();
    public boolean mx = false;
    public boolean my = false;
    public boolean mA = false;
    public boolean mB = false;
    public boolean mC = false;
    public boolean mRewardVerifyCalled = false;
    public boolean mD = false;
    public List<Integer> mE = new ArrayList();
    public boolean mF = false;
    @Nullable
    public PlayableSource mG = null;
    public boolean mH = false;
    public List<DialogInterface.OnDismissListener> mI = new CopyOnWriteArrayList();
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean mJ = false;
    public int mN = 2;
    public boolean mR = false;
    public boolean mS = false;
    public boolean mU = false;
    public boolean mV = false;

    public static long a(long j, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.a.a.T(adInfo), j);
    }

    @Nullable
    public static com.kwad.components.ad.reward.c.b a(List<com.kwad.components.ad.reward.c.b> list, long j) {
        if (j >= 0 && list != null) {
            for (com.kwad.components.ad.reward.c.b bVar : list) {
                if (com.kwad.sdk.core.response.a.d.ca(bVar.getAdTemplate()) == j) {
                    return bVar;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.report.f fVar) {
        if (fVar == null) {
            fVar = new com.kwad.sdk.core.report.f();
        }
        fVar.aI(i);
        fVar.b(this.mRootContainer.getTouchCoords());
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, fVar.uw(), this.mReportExtData);
        com.kwad.components.ad.reward.b.a.gp().b(this.mAdTemplate, com.kwad.components.ad.reward.b.b.STATUS_NONE);
        this.mAdOpenInteractionListener.bB();
    }

    public static void a(Activity activity, k kVar) {
        com.kwad.components.ad.reward.h.kwai.b.a(activity, kVar.mAdTemplate, kVar.eF.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.k.7
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                k.this.d(dialogInterface);
                com.kwad.sdk.core.c.b.tp();
                Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(k.this.getActivity())) {
                    return;
                }
                k.this.eF.resume();
            }
        }, new com.kwad.components.core.webview.b.d.c() { // from class: com.kwad.components.ad.reward.k.8
            @Override // com.kwad.components.core.webview.b.d.c
            public final void G(boolean z) {
            }

            @Override // com.kwad.components.core.webview.b.d.c
            public final void fH() {
                k.this.eF.pause();
            }

            @Override // com.kwad.components.core.webview.b.d.c
            public final void fI() {
            }
        });
    }

    public static void a(k kVar, final Activity activity, final AdTemplate adTemplate, final o.b bVar) {
        com.kwad.components.ad.reward.h.kwai.b fF = kVar.fF();
        if (fF != null) {
            com.kwad.components.ad.reward.h.kwai.b.a(fF, kVar.getActivity(), kVar.eF.getPlayDuration(), bVar, new d.a() { // from class: com.kwad.components.ad.reward.k.6
                @Override // com.kwad.components.core.webview.b.b.d.a
                public final boolean fG() {
                    o.a(activity, adTemplate, bVar);
                    return true;
                }
            });
        } else {
            o.a(activity, adTemplate, bVar);
        }
    }

    public static void a(k kVar, final l.c cVar, final l.a aVar) {
        com.kwad.components.ad.reward.h.kwai.b fE = kVar.fE();
        if (fE == null) {
            fE = e(kVar);
        }
        com.kwad.components.ad.reward.h.kwai.b bVar = fE;
        if (bVar != null) {
            com.kwad.components.ad.reward.h.kwai.b.a(bVar, kVar.getActivity(), kVar.eF.getPlayDuration(), aVar, new d.a() { // from class: com.kwad.components.ad.reward.k.5
                @Override // com.kwad.components.core.webview.b.b.d.a
                public final boolean fG() {
                    k.b(k.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(kVar, cVar, aVar);
        }
    }

    public static boolean a(k kVar) {
        boolean z = false;
        if (com.kwad.sdk.core.config.d.isCanUseTk() && com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class) != null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate);
            boolean z2 = (com.kwad.sdk.core.response.a.a.bF(bQ) || (com.kwad.sdk.core.response.a.a.aY(bQ) && com.kwad.components.ad.reward.kwai.b.gc()) || com.kwad.sdk.core.response.a.d.cc(kVar.mAdTemplate)) ? false : true;
            kVar.mA = z2 && !kVar.mV;
            if (z2 && !kVar.mV) {
                z = true;
            }
            kVar.D(z);
            return z2;
        }
        return false;
    }

    public static void b(k kVar, l.c cVar, l.a aVar) {
        if (d(kVar)) {
            return;
        }
        l.a(kVar.getActivity(), kVar.mAdTemplate, cVar, aVar);
    }

    public static boolean b(k kVar) {
        boolean z = false;
        if (com.kwad.sdk.core.config.d.isCanUseTk() && com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class) != null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate);
            boolean z2 = com.kwad.components.ad.reward.kwai.b.i(bQ) || !(com.kwad.components.ad.reward.kwai.b.h(bQ) || com.kwad.sdk.core.response.a.d.cd(kVar.mAdTemplate) || com.kwad.sdk.core.response.a.a.bF(bQ));
            if (z2 && !kVar.mV) {
                z = true;
            }
            kVar.mA = z;
            return z2;
        }
        return false;
    }

    public static boolean c(k kVar) {
        if (!com.kwad.sdk.core.config.d.isCanUseTk() || com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class) == null || kVar.mU) {
            return false;
        }
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.bQ(bQ)) {
            return true;
        }
        boolean z = com.kwad.components.ad.reward.kwai.b.i(bQ) || !(com.kwad.components.ad.reward.kwai.b.h(bQ) || com.kwad.sdk.core.response.a.a.bF(bQ) || (com.kwad.sdk.core.response.a.a.aY(bQ) && com.kwad.components.ad.reward.kwai.b.gc()) || com.kwad.sdk.core.response.a.d.cd(kVar.mAdTemplate) || com.kwad.sdk.core.response.a.a.aK(kVar.mAdTemplate));
        return com.kwad.sdk.core.response.a.b.e(kVar.mContext, kVar.mAdTemplate) ? z : (o(kVar.mAdTemplate) || p(kVar.mAdTemplate) || !z) ? false : true;
    }

    public static boolean d(k kVar) {
        l lVar = kVar.mCloseDialog;
        return lVar != null && lVar.isShowing();
    }

    public static com.kwad.components.ad.reward.h.kwai.b e(k kVar) {
        if (com.kwad.sdk.core.response.a.a.bK(com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate)) || com.kwad.sdk.core.response.a.a.bL(com.kwad.sdk.core.response.a.d.bQ(kVar.mAdTemplate))) {
            d.b bVar = new d.b();
            bVar.setAdTemplate(kVar.mAdTemplate);
            bVar.aI("ksad-video-confirm-card");
            bVar.aE(false);
            bVar.aF(true);
            return com.kwad.components.ad.reward.h.kwai.b.a(bVar);
        }
        return null;
    }

    private void fq() {
        this.EF.clear();
        this.mq.clear();
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        m mVar = this.mm;
        if (mVar != null) {
            mVar.release();
        }
        h hVar = this.mp;
        if (hVar != null) {
            hVar.release();
        }
        Set<com.kwad.components.ad.reward.d.d> set = this.mr;
        if (set != null) {
            set.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs() {
        for (com.kwad.components.ad.reward.d.e eVar : this.mq) {
            eVar.bA();
        }
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean o(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.e(adTemplate, com.kwad.components.ad.reward.kwai.b.j(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
    }

    public static boolean p(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.p(adTemplate);
    }

    public static boolean q(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.a.a.bQ(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
            return false;
        }
        return o(adTemplate) || p(adTemplate);
    }

    public final void B(boolean z) {
        this.mS = z;
    }

    public final void C(boolean z) {
        this.my = true;
    }

    public final void D(boolean z) {
        this.mB = z;
    }

    public final void E(boolean z) {
        this.mH = true;
    }

    public final void F(boolean z) {
        this.mR = true;
    }

    public final void L(int i) {
        this.mN = i;
    }

    public final void a(long j, long j2, int i) {
        for (com.kwad.components.ad.reward.d.d dVar : this.mr) {
            dVar.bV();
        }
    }

    public final void a(Context context, int i, int i2) {
        b(context, i, i2);
    }

    public final void a(Context context, int i, int i2, long j) {
        a(context, 40, 1, j, false, null);
    }

    public final void a(Context context, final int i, int i2, long j, boolean z, final com.kwad.sdk.core.report.f fVar) {
        com.kwad.components.core.c.a.a.a(new a.C0641a(context).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(false).ae(i2).l(j).a(new a.b() { // from class: com.kwad.components.ad.reward.k.2
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                k.this.a(i, fVar);
            }
        }));
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.mI.add(onDismissListener);
    }

    @MainThread
    public final void a(com.kwad.components.ad.reward.d.e eVar) {
        this.mq.add(eVar);
    }

    public final void a(com.kwad.components.ad.reward.g.c cVar) {
        this.ms = cVar;
    }

    public final void a(@Nullable com.kwad.components.ad.reward.h.kwai.b bVar) {
        this.mW = bVar;
    }

    public final void a(@Nullable e.a aVar) {
        this.mu = aVar;
    }

    public final void a(@Nullable e.b bVar) {
        this.mv = bVar;
    }

    public final void a(com.kwad.components.core.webview.b.d.a aVar) {
        this.mt = aVar;
    }

    public final void b(Context context, int i, int i2) {
        a(context, i, i2, 0L, false, null);
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.mI.remove(onDismissListener);
    }

    public final void b(com.kwad.components.ad.reward.b.b bVar) {
        com.kwad.components.ad.reward.b.a.gp().a(this.mAdTemplate, bVar);
    }

    public final void b(final com.kwad.components.ad.reward.c.b bVar) {
        final com.kwad.components.ad.reward.c.c H = KSRewardVideoActivityProxy.a.H(this.mAdTemplate.getUniqueId());
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.k.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.ad.reward.c.c cVar = H;
                if (cVar != null) {
                    cVar.d(bVar);
                }
            }
        });
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.d.e eVar) {
        this.mq.remove(eVar);
    }

    public final void b(@Nullable com.kwad.components.ad.reward.h.kwai.b bVar) {
        this.mX = bVar;
    }

    public final void c(final com.kwad.components.ad.reward.c.b bVar) {
        final com.kwad.components.ad.reward.c.c H = KSRewardVideoActivityProxy.a.H(this.mAdTemplate.getUniqueId());
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.k.4
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.ad.reward.c.c cVar = H;
                if (cVar != null) {
                    cVar.e(bVar);
                }
            }
        });
    }

    public final void d(DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.mI) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public final void d(@Nullable PlayableSource playableSource) {
        this.mG = playableSource;
    }

    public final boolean fA() {
        return this.mH;
    }

    @Nullable
    public final e.a fB() {
        return this.mu;
    }

    @Nullable
    public final e.b fC() {
        return this.mv;
    }

    public final boolean fD() {
        return this.mR;
    }

    @Nullable
    public final com.kwad.components.ad.reward.h.kwai.b fE() {
        return this.mW;
    }

    @Nullable
    public final com.kwad.components.ad.reward.h.kwai.b fF() {
        return this.mX;
    }

    public final void fr() {
        if (isMainThread()) {
            fs();
        } else {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.reward.k.1
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.fs();
                }
            });
        }
    }

    public final int ft() {
        return this.mN;
    }

    public final void fu() {
        com.kwad.components.ad.reward.g.c cVar = this.ms;
        if (cVar == null) {
            return;
        }
        cVar.onPlayAgainClick();
    }

    public final boolean fv() {
        return this.mS;
    }

    public final void fw() {
        com.kwad.components.core.webview.b.d.a aVar = this.mt;
        if (aVar == null) {
            return;
        }
        aVar.cy();
    }

    public final boolean fx() {
        return this.my;
    }

    public final boolean fy() {
        return this.mB;
    }

    @Nullable
    public final PlayableSource fz() {
        return this.mG;
    }

    @Override // com.kwad.components.core.g.a, com.kwad.sdk.mvp.a
    public final void release() {
        fq();
        com.kwad.components.ad.reward.j.a aVar = this.eF;
        if (aVar != null) {
            aVar.release();
        }
    }

    public final void releaseSync() {
        fq();
        com.kwad.components.ad.reward.j.a aVar = this.eF;
        if (aVar != null) {
            aVar.releaseSync();
        }
    }
}
