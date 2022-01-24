package com.kwad.sdk.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
/* loaded from: classes3.dex */
public class u implements com.kwad.sdk.core.webview.kwai.a {
    public static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f56493b = 2;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f56494c;

    /* renamed from: d  reason: collision with root package name */
    public int f56495d;

    /* renamed from: e  reason: collision with root package name */
    public int f56496e;

    /* renamed from: g  reason: collision with root package name */
    public b f56498g;

    /* renamed from: f  reason: collision with root package name */
    public c f56497f = new c();
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Runnable f56499h = null;

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f56500b;
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i2);
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public boolean f56501b;

        /* renamed from: c  reason: collision with root package name */
        public int f56502c;

        public c() {
            this.f56501b = false;
            this.f56502c = -1;
        }

        public void a(int i2) {
            this.f56502c = i2;
        }

        public void a(boolean z) {
            this.f56501b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.d.a.a("RegisterTimer", "TimerRunnable run timerPaused:  " + this.f56501b + ", currentTime: " + this.f56502c);
            if (this.f56501b) {
                ax.a(this, null, 1000L);
                return;
            }
            int i2 = this.f56502c;
            if (i2 < 0) {
                return;
            }
            u.this.a(i2);
            this.f56502c--;
            ax.a(this, null, 1000L);
        }
    }

    public u(int i2, int i3) {
        this.f56495d = -1;
        this.f56496e = -1;
        this.f56495d = i2;
        this.f56496e = i3;
    }

    public static int a(AdInfo adInfo) {
        int i2 = adInfo.adInsertScreenInfo.autoCloseTime;
        int a2 = com.kwad.sdk.core.config.b.a(adInfo);
        if (i2 > 0) {
            a2 = Math.min(a2, i2);
        }
        if (a2 > 0) {
            return a2;
        }
        return 60;
    }

    @Nullable
    public static u a(Context context, AdTemplate adTemplate) {
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        boolean an = com.kwad.sdk.core.response.a.a.an(j2);
        boolean z = !com.kwad.sdk.core.response.a.a.P(j2);
        if (an && z) {
            return new u(f56493b, a(j2));
        }
        if (j2.adInsertScreenInfo.autoCloseTime > 0) {
            return new u(a, a(j2));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        com.kwad.sdk.core.d.a.a("RegisterTimer", "updateTimer: " + i2 + ", mCallBackFunction: " + this.f56494c);
        if (i2 >= 0 && this.f56494c != null) {
            b bVar = this.f56498g;
            if (bVar != null && i2 == 0) {
                bVar.a(this.f56495d);
            }
            a aVar = new a();
            aVar.f56500b = i2;
            aVar.a = this.f56495d;
            this.f56494c.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerTimerListener";
    }

    public void a(b bVar) {
        this.f56498g = bVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.f56494c = cVar;
        Runnable runnable = this.f56499h;
        if (runnable != null) {
            runnable.run();
            this.f56499h = null;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f56494c = null;
    }

    public void c() {
        com.kwad.sdk.core.d.a.a("RegisterTimer", "startTimer: mCallBackFunction: " + this.f56494c);
        if (this.f56494c == null) {
            this.f56499h = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.c();
                }
            };
            return;
        }
        this.f56497f.a(this.f56496e);
        ax.a(this.f56497f);
    }

    public void d() {
        this.f56497f.a(true);
    }

    public void e() {
        this.f56497f.a(false);
    }
}
