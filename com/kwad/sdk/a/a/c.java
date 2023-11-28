package com.kwad.sdk.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.a.a.b;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c {
    public e akU;
    public final Map<String, Integer> akV;
    public final Map<String, Integer> akW;
    public final Stack<AdTemplate> akX;
    public volatile boolean akY;
    public volatile boolean akZ;
    public volatile boolean ala;

    /* loaded from: classes10.dex */
    public static final class a {
        public static final c alf = new c((byte) 0);
    }

    public c() {
        this.akV = new HashMap();
        this.akW = new HashMap();
        this.akX = new Stack<>();
        this.akY = false;
        this.akZ = false;
        this.ala = false;
    }

    public static c yT() {
        return a.alf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yX() {
        if (this.akZ || com.kwad.sdk.a.a.a.b.cM() > 0) {
            return;
        }
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.a.a.c.6
            @Override // java.lang.Runnable
            @SuppressLint({"WrongConstant"})
            public final void run() {
                try {
                    AdTemplate yR = b.yQ().yR();
                    if (yR == null || com.kwad.sdk.core.config.d.AG() == 0) {
                        return;
                    }
                    c.this.akZ = true;
                    com.kwad.sdk.core.c.b.Ct();
                    com.kwad.sdk.a.a.a.b.H(com.kwad.sdk.core.c.b.getCurrentActivity());
                    c.this.aR(yR);
                } catch (Throwable th) {
                    com.kwad.components.core.d.a.b(th);
                }
            }
        });
    }

    public final void dismiss() {
        com.kwad.sdk.a.a.a.yO();
        e eVar = this.akU;
        if (eVar != null) {
            eVar.dismiss();
            this.akU = null;
        }
    }

    @Nullable
    public final AdTemplate yU() {
        AdTemplate adTemplate = null;
        while (!this.akX.isEmpty()) {
            AdTemplate pop = this.akX.pop();
            if (aM(pop)) {
                adTemplate = pop;
            }
        }
        if (adTemplate != null) {
            this.akX.add(0, adTemplate);
        }
        return adTemplate;
    }

    @SuppressLint({"WrongConstant"})
    public final void yV() {
        b.yQ().a(new b.a() { // from class: com.kwad.sdk.a.a.c.4
            @Override // com.kwad.sdk.a.a.b.a
            public final void gm() {
                bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.a.a.c.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (!c.this.akY) {
                            c.this.yX();
                        } else {
                            c.this.ala = true;
                        }
                    }
                }, com.kwad.sdk.core.config.d.AH());
            }

            @Override // com.kwad.sdk.a.a.b.a
            public final void yS() {
                com.kwad.sdk.core.e.c.d("InstallTipsManager", "showInitDelayDialog failed");
            }
        });
    }

    public final void yW() {
        bi(false);
        if (!this.akZ && this.ala) {
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.a.a.c.5
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.yX();
                }
            }, 5000L);
        }
    }

    public final void yY() {
        this.akU = null;
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(final AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (i == -1) {
                    j jVar = new j();
                    jVar.cC(29);
                    jVar.cJ(23);
                    com.kwad.sdk.core.report.a.e(adTemplate, (JSONObject) null, jVar);
                    com.kwad.sdk.a.a.a.yO();
                } else if (i == -2) {
                    c cVar = c.this;
                    c.g(adTemplate, 1);
                }
            }
        });
        bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.a.a.c.8
            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.sdk.a.a.a.yO()) {
                    c cVar = c.this;
                    c.g(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    public final void aN(AdTemplate adTemplate) {
        if (aM(adTemplate)) {
            this.akX.add(adTemplate);
        }
    }

    public final void aO(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.akX.remove(adTemplate);
    }

    public final void bi(boolean z) {
        this.akY = z;
    }

    public static /* synthetic */ e a(c cVar, e eVar) {
        cVar.akU = null;
        return null;
    }

    public static void b(Map<String, Integer> map, String str) {
        if (map.containsKey(str)) {
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        } else {
            map.put(str, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final AdTemplate adTemplate, final boolean z) {
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.a.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                int AF = com.kwad.sdk.core.config.d.AF();
                if (z && AF == 2) {
                    c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i == -1) {
                                j jVar = new j();
                                jVar.cC(29);
                                jVar.cJ(23);
                                com.kwad.sdk.core.report.a.e(adTemplate, (JSONObject) null, jVar);
                                com.kwad.sdk.a.a.a.yO();
                            } else if (i == -2) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                c cVar = c.this;
                                c.g(adTemplate, 1);
                            }
                        }
                    });
                } else {
                    c.this.a(adTemplate, z, AF, false);
                }
            }
        });
    }

    public static void g(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.report.a.e(adTemplate, (JSONObject) null, new j().cC(69).cJ(23).cN(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (com.kwad.sdk.a.a.a.nj()) {
            return;
        }
        com.kwad.sdk.core.c.b.Ct();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null && com.kwad.sdk.a.a.a.a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(AdTemplate adTemplate, boolean z, int i, boolean z2) {
        if (this.akU == null && !com.kwad.components.core.e.c.b.nj()) {
            boolean z3 = true;
            a(adTemplate, z, (z && i == 1) ? false : false, z2);
        }
    }

    private void a(AdTemplate adTemplate, boolean z, boolean z2) {
        String valueOf = String.valueOf(com.kwad.sdk.core.response.b.e.dZ(adTemplate));
        if (z) {
            b(this.akV, valueOf);
            j jVar = new j();
            if (z2) {
                jVar.cJ(23);
                jVar.cC(191);
            } else {
                jVar.cC(92);
            }
            com.kwad.sdk.core.report.a.d(adTemplate, (JSONObject) null, jVar);
            return;
        }
        com.kwad.sdk.core.report.a.c(adTemplate, 93, (JSONObject) null);
        b(this.akW, valueOf);
    }

    @UiThread
    private void a(final AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        Context context;
        Context wrapContextIfNeed;
        com.kwad.sdk.core.c.b.Ct();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity == null || (context = ((f) ServiceProvider.get(f.class)).getContext()) == null || (wrapContextIfNeed = l.wrapContextIfNeed(context)) == null) {
            return;
        }
        e eVar = new e(wrapContextIfNeed, adTemplate, z, z2, z3);
        View findViewById = currentActivity.getWindow().getDecorView().findViewById(16908290);
        if (findViewById instanceof FrameLayout) {
            eVar.b((FrameLayout) findViewById);
            this.akU = eVar;
            a(adTemplate, z, z3);
        }
        if (z3) {
            com.kwad.sdk.core.c.b.Ct();
            com.kwad.sdk.a.a.a.b.H(com.kwad.sdk.core.c.b.getCurrentActivity());
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.a.a.c.9
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.akU != null) {
                        c.this.akU.dismiss();
                        c.a(c.this, (e) null);
                        c cVar = c.this;
                        c.g(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    public static boolean aM(AdTemplate adTemplate) {
        String G;
        if (adTemplate == null) {
            return false;
        }
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || ak.an(context, com.kwad.sdk.core.response.b.a.ay(dP)) || (G = com.kwad.sdk.core.download.a.G(dP)) == null || TextUtils.isEmpty(G)) {
            return false;
        }
        return new File(G).exists();
    }

    public final void aQ(final AdTemplate adTemplate) {
        int AQ = com.kwad.sdk.core.config.d.AQ();
        if (AQ < 0) {
            return;
        }
        final AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        String valueOf = String.valueOf(dP.adBaseInfo.creativeId);
        int i = 0;
        if (this.akW.containsKey(valueOf)) {
            i = this.akW.get(valueOf).intValue();
            this.akW.put(valueOf, Integer.valueOf(i));
        }
        if (i > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.a.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                boolean z = true;
                if (ak.ao(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(dP)) != 1) {
                    z = false;
                }
                if (z) {
                    return;
                }
                c.this.e(adTemplate, false);
            }
        }, AQ, TimeUnit.SECONDS);
    }

    public final void aP(final AdTemplate adTemplate) {
        int AE = com.kwad.sdk.core.config.d.AE();
        if (adTemplate != null && AE > 0) {
            final AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
            if (adTemplate.mAdScene.getAdStyle() == 0) {
                return;
            }
            String valueOf = String.valueOf(com.kwad.sdk.core.response.b.e.dZ(adTemplate));
            int i = 0;
            if (this.akV.containsKey(valueOf)) {
                i = this.akV.get(valueOf).intValue();
                this.akV.put(valueOf, Integer.valueOf(i));
            }
            if (i > 0) {
                return;
            }
            g.schedule(new Runnable() { // from class: com.kwad.sdk.a.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = dP.status;
                    if (i2 == 12 || i2 == 10 || !q.fK(com.kwad.sdk.core.download.a.G(com.kwad.sdk.core.response.b.e.dP(adTemplate)))) {
                        return;
                    }
                    c.this.e(adTemplate, true);
                }
            }, AE, TimeUnit.SECONDS);
        }
    }
}
