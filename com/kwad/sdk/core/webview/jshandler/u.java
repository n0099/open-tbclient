package com.kwad.sdk.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
/* loaded from: classes5.dex */
public class u implements com.kwad.sdk.core.webview.kwai.a {
    public static int a = 1;
    public static int b = 2;
    public com.kwad.sdk.core.webview.kwai.c c;
    public int d;
    public int e;
    public b g;
    public c f = new c();
    @Nullable
    public Runnable h = null;

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;
        public int b;
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public boolean b;
        public int c;

        public c() {
            this.b = false;
            this.c = -1;
        }

        public void a(int i) {
            this.c = i;
        }

        public void a(boolean z) {
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.d.a.a("RegisterTimer", "TimerRunnable run timerPaused:  " + this.b + ", currentTime: " + this.c);
            if (this.b) {
                ax.a(this, null, 1000L);
                return;
            }
            int i = this.c;
            if (i < 0) {
                return;
            }
            u.this.a(i);
            this.c--;
            ax.a(this, null, 1000L);
        }
    }

    public u(int i, int i2) {
        this.d = -1;
        this.e = -1;
        this.d = i;
        this.e = i2;
    }

    public static int a(AdInfo adInfo) {
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        int a2 = com.kwad.sdk.core.config.b.a(adInfo);
        if (i > 0) {
            a2 = Math.min(a2, i);
        }
        if (a2 > 0) {
            return a2;
        }
        return 60;
    }

    @Nullable
    public static u a(Context context, AdTemplate adTemplate) {
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        boolean an = com.kwad.sdk.core.response.a.a.an(j);
        boolean z = !com.kwad.sdk.core.response.a.a.P(j);
        if (an && z) {
            return new u(b, a(j));
        }
        if (j.adInsertScreenInfo.autoCloseTime > 0) {
            return new u(a, a(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.kwad.sdk.core.d.a.a("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.c);
        if (i >= 0 && this.c != null) {
            b bVar = this.g;
            if (bVar != null && i == 0) {
                bVar.a(this.d);
            }
            a aVar = new a();
            aVar.b = i;
            aVar.a = this.d;
            this.c.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerTimerListener";
    }

    public void a(b bVar) {
        this.g = bVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.c = cVar;
        Runnable runnable = this.h;
        if (runnable != null) {
            runnable.run();
            this.h = null;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.c = null;
    }

    public void c() {
        com.kwad.sdk.core.d.a.a("RegisterTimer", "startTimer: mCallBackFunction: " + this.c);
        if (this.c == null) {
            this.h = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.c();
                }
            };
            return;
        }
        this.f.a(this.e);
        ax.a(this.f);
    }

    public void d() {
        this.f.a(true);
    }

    public void e() {
        this.f.a(false);
    }
}
