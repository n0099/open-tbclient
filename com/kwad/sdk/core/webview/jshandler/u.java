package com.kwad.sdk.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
/* loaded from: classes8.dex */
public class u implements com.kwad.sdk.core.webview.kwai.a {
    public static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f55010b = 2;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f55011c;

    /* renamed from: d  reason: collision with root package name */
    public int f55012d;

    /* renamed from: e  reason: collision with root package name */
    public int f55013e;

    /* renamed from: g  reason: collision with root package name */
    public b f55015g;

    /* renamed from: f  reason: collision with root package name */
    public c f55014f = new c();
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Runnable f55016h = null;

    /* loaded from: classes8.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f55017b;
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i2);
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public boolean f55018b;

        /* renamed from: c  reason: collision with root package name */
        public int f55019c;

        public c() {
            this.f55018b = false;
            this.f55019c = -1;
        }

        public void a(int i2) {
            this.f55019c = i2;
        }

        public void a(boolean z) {
            this.f55018b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.d.a.a("RegisterTimer", "TimerRunnable run timerPaused:  " + this.f55018b + ", currentTime: " + this.f55019c);
            if (this.f55018b) {
                ax.a(this, null, 1000L);
                return;
            }
            int i2 = this.f55019c;
            if (i2 < 0) {
                return;
            }
            u.this.a(i2);
            this.f55019c--;
            ax.a(this, null, 1000L);
        }
    }

    public u(int i2, int i3) {
        this.f55012d = -1;
        this.f55013e = -1;
        this.f55012d = i2;
        this.f55013e = i3;
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
            return new u(f55010b, a(j2));
        }
        if (j2.adInsertScreenInfo.autoCloseTime > 0) {
            return new u(a, a(j2));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        com.kwad.sdk.core.d.a.a("RegisterTimer", "updateTimer: " + i2 + ", mCallBackFunction: " + this.f55011c);
        if (i2 >= 0 && this.f55011c != null) {
            b bVar = this.f55015g;
            if (bVar != null && i2 == 0) {
                bVar.a(this.f55012d);
            }
            a aVar = new a();
            aVar.f55017b = i2;
            aVar.a = this.f55012d;
            this.f55011c.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "registerTimerListener";
    }

    public void a(b bVar) {
        this.f55015g = bVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.f55011c = cVar;
        Runnable runnable = this.f55016h;
        if (runnable != null) {
            runnable.run();
            this.f55016h = null;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f55011c = null;
    }

    public void c() {
        com.kwad.sdk.core.d.a.a("RegisterTimer", "startTimer: mCallBackFunction: " + this.f55011c);
        if (this.f55011c == null) {
            this.f55016h = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.c();
                }
            };
            return;
        }
        this.f55014f.a(this.f55013e);
        ax.a(this.f55014f);
    }

    public void d() {
        this.f55014f.a(true);
    }

    public void e() {
        this.f55014f.a(false);
    }
}
