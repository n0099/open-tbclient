package com.kwad.components.ad.f.kwai.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
/* loaded from: classes10.dex */
public final class b implements com.kwad.sdk.core.webview.kwai.a {
    public static int ks = 1;
    public static int kt = 2;
    public com.kwad.sdk.core.webview.kwai.c kr;
    public int ku;
    public int kv;
    public InterfaceC0603b kx;
    public c kw = new c(this, (byte) 0);
    @Nullable
    public Runnable ky = null;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int kA;
        public int kB;
    }

    /* renamed from: com.kwad.components.ad.f.kwai.kwai.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0603b {
        void C(int i);
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public boolean kC;
        public int kD;

        public c() {
            this.kC = false;
            this.kD = -1;
        }

        public /* synthetic */ c(b bVar, byte b) {
            this();
        }

        public final void J(int i) {
            this.kD = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.b.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.kC + ", currentTime: " + this.kD);
            if (this.kC) {
                bd.a(this, null, 1000L);
                return;
            }
            int i = this.kD;
            if (i < 0) {
                return;
            }
            b.this.I(i);
            this.kD--;
            bd.a(this, null, 1000L);
        }

        public final void y(boolean z) {
            this.kC = z;
        }
    }

    public b(int i, int i2) {
        this.ku = i;
        this.kv = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i) {
        com.kwad.sdk.core.e.b.d("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.kr);
        if (i >= 0 && this.kr != null) {
            InterfaceC0603b interfaceC0603b = this.kx;
            if (interfaceC0603b != null && i == 0) {
                interfaceC0603b.C(this.ku);
            }
            a aVar = new a();
            aVar.kB = i;
            aVar.kA = this.ku;
            com.kwad.sdk.core.webview.kwai.c cVar = this.kr;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    @Nullable
    public static b j(AdTemplate adTemplate) {
        AdInfo bQ = d.bQ(adTemplate);
        if (!com.kwad.sdk.core.response.a.a.aB(bQ)) {
            if (com.kwad.sdk.core.response.a.a.aY(bQ)) {
                return new b(kt, com.kwad.components.ad.interstitial.kwai.b.b(bQ));
            }
            int i = bQ.adInsertScreenInfo.autoCloseTime;
            if (i > 0) {
                return new b(ks, i);
            }
            return null;
        }
        return null;
    }

    public final void a(InterfaceC0603b interfaceC0603b) {
        this.kx = interfaceC0603b;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.kr = cVar;
        Runnable runnable = this.ky;
        if (runnable != null) {
            runnable.run();
            this.ky = null;
        }
    }

    public final void eA() {
        this.kw.y(true);
    }

    public final void eB() {
        this.kw.y(false);
    }

    public final void ez() {
        com.kwad.sdk.core.e.b.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.kr);
        if (this.kr == null) {
            this.ky = new Runnable() { // from class: com.kwad.components.ad.f.kwai.kwai.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.ez();
                }
            };
            return;
        }
        this.kw.J(this.kv);
        bd.runOnUiThread(this.kw);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        this.kr = null;
    }
}
