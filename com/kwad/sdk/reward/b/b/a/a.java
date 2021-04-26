package com.kwad.sdk.reward.b.b.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0394a f34367a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f34368b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34369c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f34370d;

    /* renamed from: e  reason: collision with root package name */
    public int f34371e;

    /* renamed from: g  reason: collision with root package name */
    public final long f34373g;

    /* renamed from: f  reason: collision with root package name */
    public Handler f34372f = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f34374h = false;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0394a {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate, int i2) {
        this.f34369c = adTemplate;
        this.f34370d = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f34371e = i2;
        long g2 = com.kwad.sdk.core.response.b.b.g(adTemplate);
        this.f34373g = g2 == 0 ? 1000L : g2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f34367a != null) {
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
            this.f34367a.a(z);
        }
    }

    private boolean c(int i2, int i3) {
        if (com.kwad.sdk.core.response.b.a.K(this.f34370d)) {
            return this.f34371e == 1 ? i2 <= i3 : i2 >= i3;
        }
        return false;
    }

    public void a(int i2, int i3) {
        b bVar;
        if (c(i2, i3)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.i(this.f34369c) || (bVar = this.f34368b) == null) {
            a(false);
        } else if (bVar.a()) {
        } else {
            this.f34372f.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.b.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f34374h = true;
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                    if (a.this.f34368b != null && a.this.f34368b.a()) {
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + a.this.f34373g);
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + a.this.f34373g);
                    e.c(a.this.f34369c, a.this.f34373g);
                    a.this.a(true);
                }
            }, this.f34373g);
        }
    }

    @MainThread
    public void a(InterfaceC0394a interfaceC0394a) {
        this.f34367a = interfaceC0394a;
    }

    @MainThread
    public void a(b bVar) {
        this.f34368b = bVar;
    }

    public void b(int i2, int i3) {
        if (this.f34374h) {
            com.kwad.sdk.core.d.a.c("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f34372f.removeCallbacksAndMessages(null);
        if (c(i2, i3)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.i(this.f34369c) || this.f34368b == null) {
            a(true);
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f34373g);
        this.f34368b.a();
    }
}
