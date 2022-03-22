package com.kwad.sdk.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
/* loaded from: classes7.dex */
public class u implements com.kwad.sdk.core.webview.kwai.a {
    public static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f40095b = 2;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f40096c;

    /* renamed from: d  reason: collision with root package name */
    public int f40097d;

    /* renamed from: e  reason: collision with root package name */
    public int f40098e;

    /* renamed from: g  reason: collision with root package name */
    public b f40100g;

    /* renamed from: f  reason: collision with root package name */
    public c f40099f = new c();
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Runnable f40101h = null;

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f40102b;
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public boolean f40103b;

        /* renamed from: c  reason: collision with root package name */
        public int f40104c;

        public c() {
            this.f40103b = false;
            this.f40104c = -1;
        }

        public void a(int i) {
            this.f40104c = i;
        }

        public void a(boolean z) {
            this.f40103b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.d.a.a("RegisterTimer", "TimerRunnable run timerPaused:  " + this.f40103b + ", currentTime: " + this.f40104c);
            if (this.f40103b) {
                ax.a(this, null, 1000L);
                return;
            }
            int i = this.f40104c;
            if (i < 0) {
                return;
            }
            u.this.a(i);
            this.f40104c--;
            ax.a(this, null, 1000L);
        }
    }

    public u(int i, int i2) {
        this.f40097d = -1;
        this.f40098e = -1;
        this.f40097d = i;
        this.f40098e = i2;
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
            return new u(f40095b, a(j));
        }
        if (j.adInsertScreenInfo.autoCloseTime > 0) {
            return new u(a, a(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.kwad.sdk.core.d.a.a("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.f40096c);
        if (i >= 0 && this.f40096c != null) {
            b bVar = this.f40100g;
            if (bVar != null && i == 0) {
                bVar.a(this.f40097d);
            }
            a aVar = new a();
            aVar.f40102b = i;
            aVar.a = this.f40097d;
            this.f40096c.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerTimerListener";
    }

    public void a(b bVar) {
        this.f40100g = bVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.f40096c = cVar;
        Runnable runnable = this.f40101h;
        if (runnable != null) {
            runnable.run();
            this.f40101h = null;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f40096c = null;
    }

    public void c() {
        com.kwad.sdk.core.d.a.a("RegisterTimer", "startTimer: mCallBackFunction: " + this.f40096c);
        if (this.f40096c == null) {
            this.f40101h = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.c();
                }
            };
            return;
        }
        this.f40099f.a(this.f40098e);
        ax.a(this.f40099f);
    }

    public void d() {
        this.f40099f.a(true);
    }

    public void e() {
        this.f40099f.a(false);
    }
}
