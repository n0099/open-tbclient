package com.kwad.components.ad.g.a.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public static int ns = 1;
    public static int nt = 2;
    public com.kwad.sdk.core.webview.c.c nr;
    public int nu;
    public int nv;
    public InterfaceC0592b nx;
    public c nw = new c(this, (byte) 0);
    @Nullable
    public Runnable ny = null;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int nA;
        public int nB;
    }

    /* renamed from: com.kwad.components.ad.g.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0592b {
        void E(int i);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerTimerListener";
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public boolean nC;
        public int nD;

        public c() {
            this.nC = false;
            this.nD = -1;
        }

        public final void J(int i) {
            this.nD = i;
        }

        public final void y(boolean z) {
            this.nC = z;
        }

        public /* synthetic */ c(b bVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.c.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.nC + ", currentTime: " + this.nD);
            if (this.nC) {
                bn.a(this, null, 1000L);
                return;
            }
            int i = this.nD;
            if (i >= 0) {
                b.this.I(i);
                this.nD--;
                bn.a(this, null, 1000L);
            }
        }
    }

    public b(int i, int i2) {
        this.nu = i;
        this.nv = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i) {
        com.kwad.sdk.core.e.c.d("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.nr);
        if (i < 0 || this.nr == null) {
            return;
        }
        InterfaceC0592b interfaceC0592b = this.nx;
        if (interfaceC0592b != null && i == 0) {
            interfaceC0592b.E(this.nu);
        }
        a aVar = new a();
        aVar.nB = i;
        aVar.nA = this.nu;
        com.kwad.sdk.core.webview.c.c cVar = this.nr;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public static int f(AdInfo adInfo) {
        int b = com.kwad.components.ad.interstitial.b.b.b(adInfo);
        if (b <= 0) {
            b = 60;
        }
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        if (i > 0) {
            return Math.min(b, i);
        }
        return b;
    }

    @Nullable
    public static b z(AdTemplate adTemplate) {
        AdInfo dP = e.dP(adTemplate);
        if (!(!com.kwad.sdk.core.response.b.a.bc(dP))) {
            return null;
        }
        if (com.kwad.sdk.core.response.b.a.bH(dP)) {
            return new b(nt, f(dP));
        }
        int i = dP.adInsertScreenInfo.autoCloseTime;
        if (i <= 0) {
            return null;
        }
        return new b(ns, i);
    }

    public final void a(InterfaceC0592b interfaceC0592b) {
        this.nx = interfaceC0592b;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.nr = cVar;
        Runnable runnable = this.ny;
        if (runnable != null) {
            runnable.run();
            this.ny = null;
        }
    }

    public final void eE() {
        com.kwad.sdk.core.e.c.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.nr);
        if (this.nr == null) {
            this.ny = new Runnable() { // from class: com.kwad.components.ad.g.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.eE();
                }
            };
            return;
        }
        this.nw.J(this.nv);
        bn.runOnUiThread(this.nw);
    }

    public final void eF() {
        this.nw.y(true);
    }

    public final void eG() {
        this.nw.y(false);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.nr = null;
    }
}
