package com.kwad.sdk.kwai.kwai;

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
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.kwai.kwai.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static c Rj;
    public d Rk;
    public final Map<String, Integer> Rl = new HashMap();
    public final Map<String, Integer> Rm = new HashMap();
    public final Stack<AdTemplate> Rn = new Stack<>();
    public volatile boolean Ro = false;
    public volatile boolean Rp = false;
    public volatile boolean Rq = false;

    public static /* synthetic */ d a(c cVar, d dVar) {
        cVar.Rk = null;
        return null;
    }

    @MainThread
    private void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (a.mq()) {
            return;
        }
        com.kwad.sdk.core.c.b.tp();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null && a.a(currentActivity, adTemplate, null, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(AdTemplate adTemplate, boolean z, int i, boolean z2) {
        if (this.Rk != null || com.kwad.components.core.c.kwai.b.mq()) {
            return;
        }
        boolean z3 = true;
        a(adTemplate, z, (z && i == 1) ? false : false, z2);
    }

    private void a(AdTemplate adTemplate, boolean z, boolean z2) {
        int i;
        String valueOf = String.valueOf(com.kwad.sdk.core.response.a.d.ca(adTemplate));
        if (!z) {
            com.kwad.sdk.core.report.a.d(adTemplate, 93, (JSONObject) null);
            a(this.Rm, valueOf);
            return;
        }
        a(this.Rl, valueOf);
        f fVar = new f();
        if (z2) {
            fVar.aP(23);
            i = 191;
        } else {
            i = 92;
        }
        fVar.aK(i);
        com.kwad.sdk.core.report.a.d(adTemplate, (JSONObject) null, fVar);
    }

    @UiThread
    private void a(final AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        Context context;
        Context wrapContextIfNeed;
        com.kwad.sdk.core.c.b.tp();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity == null || (context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext()) == null || (wrapContextIfNeed = Wrapper.wrapContextIfNeed(context)) == null) {
            return;
        }
        d dVar = new d(wrapContextIfNeed, adTemplate, z, z2, z3);
        View findViewById = currentActivity.getWindow().getDecorView().findViewById(16908290);
        if (findViewById instanceof FrameLayout) {
            dVar.a((FrameLayout) findViewById);
            this.Rk = dVar;
            a(adTemplate, z, z3);
        }
        if (z3) {
            com.kwad.sdk.core.c.b.tp();
            com.kwad.sdk.kwai.kwai.kwai.b.I(com.kwad.sdk.core.c.b.getCurrentActivity());
            bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.9
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.Rk != null) {
                        c.this.Rk.dismiss();
                        c.a(c.this, (d) null);
                        c cVar = c.this;
                        c.f(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    public static void a(Map<String, Integer> map, String str) {
        map.put(str, map.containsKey(str) ? Integer.valueOf(map.get(str).intValue() + 1) : 1);
    }

    public static boolean ae(AdTemplate adTemplate) {
        String w;
        if (adTemplate == null) {
            return false;
        }
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || ai.U(context, com.kwad.sdk.core.response.a.a.ag(bQ)) || (w = com.kwad.sdk.core.download.a.w(bQ)) == null || TextUtils.isEmpty(w)) {
            return false;
        }
        return new File(w).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(final AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (i != -1) {
                    if (i == -2) {
                        c cVar = c.this;
                        c.f(adTemplate, 1);
                        return;
                    }
                    return;
                }
                f fVar = new f();
                fVar.aK(29);
                fVar.aP(23);
                com.kwad.sdk.core.report.a.a(adTemplate, fVar);
                a.qY();
            }
        });
        bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.8
            @Override // java.lang.Runnable
            public final void run() {
                if (a.qY()) {
                    c cVar = c.this;
                    c.f(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void ak(AdTemplate adTemplate) {
        if (a.mq()) {
            return;
        }
        com.kwad.sdk.core.c.b.tp();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null && a.a(currentActivity, adTemplate, null, null)) {
            a(adTemplate, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final AdTemplate adTemplate, final boolean z) {
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.3
            @Override // java.lang.Runnable
            public final void run() {
                int rQ = com.kwad.sdk.core.config.d.rQ();
                if (z && rQ == 2) {
                    c.this.ak(adTemplate);
                } else {
                    c.this.a(adTemplate, z, rQ, false);
                }
            }
        });
    }

    public static void f(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.report.a.a(adTemplate, new f().aK(69).aP(23).aT(i));
    }

    public static c rd() {
        if (Rj == null) {
            synchronized (c.class) {
                if (Rj == null) {
                    Rj = new c();
                }
            }
        }
        return Rj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh() {
        if (!this.Rp && com.kwad.sdk.kwai.kwai.kwai.b.cp() <= 0) {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.6
                @Override // java.lang.Runnable
                @SuppressLint({"WrongConstant"})
                public final void run() {
                    try {
                        AdTemplate rb = b.ra().rb();
                        if (rb == null) {
                            return;
                        }
                        int rR = com.kwad.sdk.core.config.d.rR();
                        c.this.Rp = true;
                        if (rR == 1) {
                            com.kwad.sdk.core.c.b.tp();
                            com.kwad.sdk.kwai.kwai.kwai.b.I(com.kwad.sdk.core.c.b.getCurrentActivity());
                            c.this.aj(rb);
                        } else if (rR == 2) {
                            c.this.a(rb, true, 1, true);
                        }
                    } catch (Throwable th) {
                        com.kwad.components.core.b.a.b(th);
                    }
                }
            });
        }
    }

    public final void aI(boolean z) {
        this.Ro = z;
    }

    public final void af(AdTemplate adTemplate) {
        if (ae(adTemplate)) {
            this.Rn.add(adTemplate);
        }
    }

    public final void ag(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.Rn.remove(adTemplate);
    }

    public final void ah(final AdTemplate adTemplate) {
        int rP = com.kwad.sdk.core.config.d.rP();
        if (adTemplate == null || rP <= 0) {
            return;
        }
        final AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String valueOf = String.valueOf(com.kwad.sdk.core.response.a.d.ca(adTemplate));
        int i = 0;
        if (this.Rl.containsKey(valueOf)) {
            i = this.Rl.get(valueOf).intValue();
            this.Rl.put(valueOf, Integer.valueOf(i));
        }
        if (i > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.1
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = bQ.status;
                if (i2 == 12 || i2 == 10) {
                    return;
                }
                c.this.d(adTemplate, true);
            }
        }, rP, TimeUnit.SECONDS);
    }

    public final void ai(final AdTemplate adTemplate) {
        int rY = com.kwad.sdk.core.config.d.rY();
        if (rY < 0) {
            return;
        }
        final AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        String valueOf = String.valueOf(bQ.adBaseInfo.creativeId);
        int i = 0;
        if (this.Rm.containsKey(valueOf)) {
            i = this.Rm.get(valueOf).intValue();
            this.Rm.put(valueOf, Integer.valueOf(i));
        }
        if (i > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (ai.V(KsAdSDK.getContext(), com.kwad.sdk.core.response.a.a.ag(bQ)) == 1) {
                    return;
                }
                c.this.d(adTemplate, false);
            }
        }, rY, TimeUnit.SECONDS);
    }

    public final void dismiss() {
        a.qY();
        d dVar = this.Rk;
        if (dVar != null) {
            dVar.dismiss();
            this.Rk = null;
        }
    }

    @Nullable
    public final AdTemplate re() {
        AdTemplate adTemplate = null;
        while (!this.Rn.isEmpty()) {
            AdTemplate pop = this.Rn.pop();
            if (ae(pop)) {
                adTemplate = pop;
            }
        }
        if (adTemplate != null) {
            this.Rn.add(0, adTemplate);
        }
        return adTemplate;
    }

    @SuppressLint({"WrongConstant"})
    public final void rf() {
        if (com.kwad.sdk.core.config.d.rR() != 0 && com.kwad.sdk.kwai.kwai.kwai.b.cp() <= 0) {
            b.ra().a(new b.a() { // from class: com.kwad.sdk.kwai.kwai.c.4
                @Override // com.kwad.sdk.kwai.kwai.b.a
                public final void fT() {
                    bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (c.this.Ro) {
                                c.this.Rq = true;
                            } else {
                                c.this.rh();
                            }
                        }
                    }, com.kwad.sdk.core.config.d.rS());
                }

                @Override // com.kwad.sdk.kwai.kwai.b.a
                public final void rc() {
                    com.kwad.sdk.core.e.b.d("InstallTipsManager", "showInitDelayDialog failed");
                }
            });
        }
    }

    public final void rg() {
        aI(false);
        if (this.Rp || !this.Rq) {
            return;
        }
        bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.5
            @Override // java.lang.Runnable
            public final void run() {
                c.this.rh();
            }
        }, 5000L);
    }

    public final void ri() {
        this.Rk = null;
    }
}
