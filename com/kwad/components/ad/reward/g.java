package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.i.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bm;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class g extends com.kwad.components.core.l.a {
    public boolean fP;
    public Handler fS;
    public boolean gt;
    public AdResultData mAdResultData;
    @NonNull
    public com.kwad.components.ad.reward.e.d mAdRewardStepListener;
    @Nullable
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public boolean mCheckExposureResult;
    public long mPageEnterTime;
    @Nullable
    public JSONObject mReportExtData;
    public boolean mRewardVerifyCalled;
    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public bm mTimerHelper;
    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    public boolean oG;
    @NonNull
    public com.kwad.components.ad.reward.e.b oH;
    public com.kwad.components.ad.reward.m.e oI;
    @Nullable
    public IAdLiveOfflineView oJ;
    @Nullable
    public com.kwad.components.core.playable.a oK;
    @NonNull
    public RewardActionBarControl oL;
    @Nullable
    public j oM;
    @Nullable
    public com.kwad.components.ad.k.a oN;
    @Nullable
    public d oO;
    public final PriorityQueue<com.kwad.components.ad.reward.e.g> oP;
    public final List<com.kwad.components.ad.reward.k.a> oQ;
    public final List<r> oR;
    public final List<com.kwad.components.ad.reward.m.c> oS;
    public Set<com.kwad.components.ad.reward.e.e> oT;
    @Nullable
    public com.kwad.components.core.webview.tachikoma.e.a oU;
    public boolean oV;
    public boolean oW;
    public boolean oX;
    public boolean oY;
    public boolean oZ;
    @NonNull
    public LoadStrategy pA;
    public RewardRenderResult pB;
    public List<a> pC;
    public List<b> pD;
    public List<a.InterfaceC0649a> pE;
    public boolean pa;
    public boolean pb;
    public boolean pc;
    public boolean pd;
    public List<Integer> pe;
    public int pf;
    public boolean pg;
    @Nullable
    public p ph;
    public boolean pi;
    @Nullable
    public PlayableSource pj;
    public boolean pk;
    public long pl;
    public List<DialogInterface.OnDismissListener> pm;
    @Nullable
    public com.kwad.components.ad.reward.e.o pn;
    public boolean po;
    @Nullable
    public com.kwad.components.ad.reward.l.b.a pp;
    @Nullable
    public com.kwad.components.ad.reward.l.a.a pq;
    public int pr;
    public int ps;
    public long pt;
    public long pu;
    public boolean pv;
    public boolean pw;
    public boolean px;
    public boolean py;
    public boolean pz;

    /* loaded from: classes10.dex */
    public interface a {
        void fS();

        void fT();

        void fU();

        void fV();
    }

    /* loaded from: classes10.dex */
    public interface b {
        boolean interceptPlayCardResume();
    }

    public g(com.kwad.components.core.l.b<?> bVar) {
        super(bVar);
        this.oG = false;
        this.oP = new PriorityQueue<>();
        this.oQ = new CopyOnWriteArrayList();
        this.oR = new CopyOnWriteArrayList();
        this.oS = new CopyOnWriteArrayList();
        this.oT = new HashSet();
        this.oV = false;
        this.oW = false;
        this.oY = false;
        this.oZ = false;
        this.pa = false;
        this.pb = false;
        this.pc = false;
        this.mRewardVerifyCalled = false;
        this.pd = false;
        this.pe = new ArrayList();
        this.mCheckExposureResult = true;
        this.pf = 0;
        this.pg = false;
        this.pi = false;
        this.pj = null;
        this.pk = false;
        this.gt = false;
        this.pm = new CopyOnWriteArrayList();
        this.fS = new Handler(Looper.getMainLooper());
        this.po = false;
        this.ps = 2;
        this.pw = false;
        this.px = false;
        this.py = false;
        this.pz = false;
        this.pA = LoadStrategy.FULL_TK;
        this.pC = new CopyOnWriteArrayList();
        this.pD = new CopyOnWriteArrayList();
        this.pE = new CopyOnWriteArrayList();
        this.Mm.add(new com.kwad.components.core.l.a.a() { // from class: com.kwad.components.ad.reward.g.1
            @Override // com.kwad.components.core.l.a.a
            public final void c(com.kwad.components.core.proxy.c cVar) {
                g.this.ft();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void d(com.kwad.components.core.proxy.c cVar) {
                g.this.fu();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fN() {
                g.this.fs();
            }

            @Override // com.kwad.components.core.l.a.a
            public final void fO() {
                g.this.fv();
            }
        });
    }

    public static boolean E(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.i(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
    }

    public static boolean F(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.F(adTemplate);
    }

    public static boolean G(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.b.a.cO(com.kwad.sdk.core.response.b.e.dP(adTemplate))) {
            return false;
        }
        if (!E(adTemplate) && !F(adTemplate)) {
            return false;
        }
        return true;
    }

    public static boolean b(g gVar) {
        return gVar.oV;
    }

    public static com.kwad.components.ad.reward.k.a.b c(g gVar) {
        e.b bVar = new e.b();
        bVar.d(gVar.mAdResultData);
        bVar.aN(com.kwad.sdk.core.response.b.b.dt(gVar.mAdTemplate));
        bVar.aV(false);
        bVar.aW(true);
        return com.kwad.components.ad.reward.k.a.b.a(gVar, bVar);
    }

    public static com.kwad.components.ad.reward.k.a.b d(g gVar) {
        if (com.kwad.sdk.core.response.b.a.cb(com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate)) != 4 && com.kwad.sdk.core.response.b.a.cb(com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate)) != 3) {
            return null;
        }
        return c(gVar);
    }

    public final void A(boolean z) {
        this.px = z;
    }

    public final void B(boolean z) {
        this.pk = true;
    }

    public final void C(boolean z) {
        this.pw = true;
    }

    public final void D(boolean z) {
        this.oV = z;
    }

    public final void L(int i) {
        this.ps = i;
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.pm.add(onDismissListener);
    }

    public final void x(String str) {
        int i = -1;
        try {
            if (com.kwad.sdk.core.config.d.yD()) {
                i = com.kwad.components.ad.reward.j.a.a(getActivity());
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        com.kwad.components.ad.reward.j.b.a(this.mContext, this.mAdTemplate, str, i, this.mReportExtData);
    }

    public final void z(boolean z) {
        this.oW = z;
        if (z) {
            fu();
        } else {
            ft();
        }
    }

    public static long a(long j, AdInfo adInfo) {
        return Math.min(com.kwad.sdk.core.response.b.a.ag(adInfo), j);
    }

    public final void d(final boolean z, final boolean z2) {
        if (this.oI.jK()) {
            bn.runOnUiThreadDelay(new ay() { // from class: com.kwad.components.ad.reward.g.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    com.kwad.components.ad.reward.f.a jL = g.this.oI.jL();
                    if (jL != null) {
                        jL.setAudioEnabled(z, z2);
                    }
                }
            }, 500L);
        }
    }

    @Nullable
    public static com.kwad.components.core.i.c a(List<com.kwad.components.core.i.c> list, long j) {
        if (j >= 0 && list != null) {
            for (com.kwad.components.core.i.c cVar : list) {
                if (com.kwad.sdk.core.response.b.e.dZ(cVar.getAdTemplate()) == j) {
                    return cVar;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.report.j jVar) {
        if (jVar == null) {
            jVar = new com.kwad.sdk.core.report.j();
        }
        jVar.cA(i);
        jVar.d(this.mRootContainer.getTouchCoords());
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, (String) null, (String) null, jVar, this.mReportExtData);
        com.kwad.components.ad.reward.c.a.gJ().c(this.mAdTemplate, com.kwad.components.ad.reward.c.b.STATUS_NONE);
        this.oH.bJ();
    }

    public static void a(Activity activity, g gVar) {
        com.kwad.sdk.core.e.c.d("RewardCallerContext", "showExtraDialog");
        com.kwad.components.ad.reward.k.a.b.a(gVar, activity, gVar.oI.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.g.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                g.this.d(dialogInterface);
                com.kwad.sdk.core.c.b.Ct();
                Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (currentActivity != null && currentActivity.equals(g.this.getActivity())) {
                    g.this.oI.resume();
                }
            }
        }, new h.b() { // from class: com.kwad.components.ad.reward.g.4
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void fP() {
                g.this.oI.pause();
            }
        });
    }

    public static void a(Context context, g gVar, ViewGroup viewGroup) {
        int i;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate);
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class);
        if (aVar != null && aVar.oA() && com.kwad.sdk.core.response.b.a.cJ(com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate))) {
            if (com.kwad.sdk.core.response.b.a.bf(dP) == 8) {
                i = 1;
            } else {
                i = 0;
            }
            IAdLiveOfflineView view2 = aVar.getView(context, i);
            View view3 = view2.getView();
            gVar.oJ = view2;
            viewGroup.addView(view3);
            gVar.oI.a(2, new com.kwad.components.ad.reward.f.a(gVar.mAdTemplate, aVar.getAdLivePlayModule(view2, KsAdSDKImpl.get().getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cg(dP)))));
        }
    }

    public static void b(g gVar, h.c cVar, h.a aVar) {
        boolean b2 = b(gVar);
        com.kwad.sdk.core.e.c.d("RewardCallerContext", "showNativeCloseDialog isCloseDialogShowing: " + b2);
        if (b2) {
            return;
        }
        h.a(gVar.getActivity(), gVar.mAdTemplate, cVar, aVar);
    }

    public static void a(g gVar, final h.c cVar, final h.a aVar) {
        boolean z;
        com.kwad.components.ad.reward.k.a.b bVar = null;
        if (!gVar.oI.jK()) {
            AdInfo dP = com.kwad.sdk.core.response.b.e.dP(gVar.mAdTemplate);
            if (!com.kwad.components.ad.reward.a.b.j(dP) && com.kwad.sdk.core.response.b.a.cb(dP) != 2) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                bVar = c(gVar);
            }
            if (bVar == null) {
                bVar = d(gVar);
            }
        }
        com.kwad.components.ad.reward.k.a.b bVar2 = bVar;
        if (bVar2 != null) {
            com.kwad.components.ad.reward.k.a.b.a(bVar2, gVar.getActivity(), gVar.oI.getPlayDuration(), aVar, new e.a() { // from class: com.kwad.components.ad.reward.g.12
                @Override // com.kwad.components.core.webview.tachikoma.c.e.a
                public final boolean fR() {
                    g.b(g.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(gVar, cVar, aVar);
        }
    }

    public static <T> void a(List<T> list, com.kwad.sdk.g.a<T> aVar) {
        if (list != null) {
            for (T t : list) {
                aVar.accept(t);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fB() {
        int size = this.oP.size();
        for (int i = 0; i < size; i++) {
            com.kwad.components.ad.reward.e.g poll = this.oP.poll();
            if (poll != null) {
                poll.bL();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs() {
        for (a aVar : this.pC) {
            aVar.fS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv() {
        for (a aVar : this.pC) {
            aVar.fV();
        }
    }

    private void fz() {
        this.oP.clear();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        j jVar = this.oM;
        if (jVar != null) {
            jVar.release();
        }
        d dVar = this.oO;
        if (dVar != null) {
            dVar.release();
        }
        Set<com.kwad.components.ad.reward.e.e> set = this.oT;
        if (set != null) {
            set.clear();
        }
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public final void fA() {
        if (isMainThread()) {
            fB();
        } else {
            this.fS.post(new Runnable() { // from class: com.kwad.components.ad.reward.g.6
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.fB();
                }
            });
        }
    }

    public final boolean fC() {
        return this.px;
    }

    public final void fD() {
        com.kwad.components.core.webview.tachikoma.e.a aVar = this.oU;
        if (aVar == null) {
            return;
        }
        aVar.iY();
    }

    public final boolean fE() {
        return this.pb;
    }

    @Nullable
    public final PlayableSource fF() {
        return this.pj;
    }

    public final boolean fG() {
        return this.pk;
    }

    public final List<a.InterfaceC0649a> fH() {
        return this.pE;
    }

    public final RewardRenderResult fI() {
        return this.pB;
    }

    public final boolean fJ() {
        return this.pw;
    }

    public final boolean fK() {
        return this.oV;
    }

    public final boolean fL() {
        return this.mRewardVerifyCalled;
    }

    public final void fM() {
        int i;
        long j = this.pu;
        if (j != 0) {
            i = (int) (j / 1000);
        } else {
            i = 0;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.sdk.core.report.a.e(adTemplate, com.kwad.sdk.core.response.b.a.ae(com.kwad.sdk.core.response.b.e.dP(adTemplate)), i);
    }

    public final void fu() {
        for (a aVar : this.pC) {
            aVar.fU();
        }
    }

    public final boolean fw() {
        return this.oW;
    }

    public final void fx() {
        a(this.oS, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.m.c>() { // from class: com.kwad.components.ad.reward.g.5
            public static void c(com.kwad.components.ad.reward.m.c cVar) {
                cVar.io();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.m.c cVar) {
                c(cVar);
            }
        });
    }

    @Nullable
    public final String fy() {
        TKAdLiveShopItemInfo tKAdLiveShopItemInfo = this.mAdTemplate.tkLiveShopItemInfo;
        if (tKAdLiveShopItemInfo == null) {
            return null;
        }
        return tKAdLiveShopItemInfo.itemId;
    }

    @Override // com.kwad.components.core.l.a, com.kwad.sdk.mvp.a
    public final void release() {
        fz();
        com.kwad.components.ad.reward.m.e eVar = this.oI;
        if (eVar != null) {
            eVar.release();
        }
    }

    public static boolean g(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.b.g(adInfo) && !com.kwad.components.ad.reward.a.b.k(adInfo)) {
            return true;
        }
        return false;
    }

    public final void E(final boolean z) {
        if (z != this.mRewardVerifyCalled) {
            a(this.oR, new com.kwad.sdk.g.a<r>() { // from class: com.kwad.components.ad.reward.g.11
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* renamed from: c */
                public void accept(r rVar) {
                    rVar.aa(z);
                }
            });
        }
        this.mRewardVerifyCalled = z;
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.pB = rewardRenderResult;
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.pm.remove(onDismissListener);
    }

    @MainThread
    public final void c(com.kwad.components.ad.reward.e.g gVar) {
        this.oP.remove(gVar);
    }

    public final void d(DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismissListener : this.pm) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public final void a(int i, Context context, int i2, int i3) {
        b(i, context, i2, i3);
    }

    public final void b(int i, Context context, int i2, int i3) {
        a(i, context, i2, i3, 0L, false, null);
    }

    public final void a(int i, Context context, int i2, int i3, long j) {
        a(1, context, 40, 1, j, false, null);
    }

    public final void a(int i, Context context, final int i2, int i3, long j, boolean z, final com.kwad.sdk.core.report.j jVar) {
        com.kwad.components.core.e.d.a.a(new a.C0644a(context).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).an(i3).v(j).am(i2).al(i).af(fy()).a(new Callable<String>() { // from class: com.kwad.components.ad.reward.g.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: fQ */
            public String call() {
                com.kwad.components.ad.reward.m.e eVar = g.this.oI;
                if (eVar != null) {
                    return eVar.jL().getCurrentShowShopItemInfo().itemId;
                }
                return null;
            }
        }).a(new a.b() { // from class: com.kwad.components.ad.reward.g.7
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                g.this.a(i2, jVar);
            }
        }));
    }

    public final void a(long j, long j2, int i) {
        for (com.kwad.components.ad.reward.e.e eVar : this.oT) {
            eVar.ce();
        }
    }

    public final void a(@Nullable com.kwad.components.ad.reward.e.o oVar) {
        this.pn = oVar;
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.gJ().a(this.mAdTemplate, bVar);
    }

    public final void d(@Nullable PlayableSource playableSource) {
        this.pj = playableSource;
    }

    public final void a(a aVar) {
        this.pC.add(aVar);
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.e.g gVar) {
        this.oP.offer(gVar);
    }

    public final void d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.m(adResultData);
    }

    public final void a(b bVar) {
        this.pD.add(bVar);
    }

    public final void b(a aVar) {
        this.pC.remove(aVar);
    }

    public final void a(com.kwad.components.ad.reward.k.a aVar) {
        this.oQ.add(aVar);
    }

    public final void b(b bVar) {
        this.pD.remove(bVar);
    }

    public final void a(r rVar) {
        this.oR.add(rVar);
    }

    public final void b(com.kwad.components.ad.reward.k.a aVar) {
        this.oQ.remove(aVar);
    }

    public final void a(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.oS.add(cVar);
        }
    }

    public final void b(r rVar) {
        this.oR.remove(rVar);
    }

    public final void a(a.InterfaceC0649a interfaceC0649a) {
        List<a.InterfaceC0649a> list = this.pE;
        if (list != null) {
            list.add(interfaceC0649a);
        }
    }

    public final void b(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.oS.remove(cVar);
        }
    }

    public final void a(final com.kwad.components.core.i.c cVar) {
        final com.kwad.components.core.i.d I = com.kwad.components.ad.reward.e.f.I(this.mAdTemplate.getUniqueId());
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.g.9
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.i.d dVar = I;
                if (dVar != null) {
                    dVar.c(cVar);
                }
            }
        });
    }

    public final void b(a.InterfaceC0649a interfaceC0649a) {
        List<a.InterfaceC0649a> list = this.pE;
        if (list != null) {
            list.remove(interfaceC0649a);
        }
    }

    public final void a(com.kwad.components.core.webview.tachikoma.e.a aVar) {
        this.oU = aVar;
    }

    public final void b(final com.kwad.components.core.i.c cVar) {
        final com.kwad.components.core.i.d I = com.kwad.components.ad.reward.e.f.I(this.mAdTemplate.getUniqueId());
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.g.10
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.i.d dVar = I;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    public final void ft() {
        if (!this.oW && !this.oV && !this.pw) {
            boolean z = false;
            for (b bVar : this.pD) {
                z |= bVar.interceptPlayCardResume();
            }
            if (z) {
                return;
            }
            for (a aVar : this.pC) {
                aVar.fT();
            }
        }
    }
}
