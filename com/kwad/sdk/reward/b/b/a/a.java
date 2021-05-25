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
    public InterfaceC0382a f33541a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f33542b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f33543c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f33544d;

    /* renamed from: e  reason: collision with root package name */
    public int f33545e;

    /* renamed from: g  reason: collision with root package name */
    public final long f33547g;

    /* renamed from: f  reason: collision with root package name */
    public Handler f33546f = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f33548h = false;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0382a {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate, int i2) {
        this.f33543c = adTemplate;
        this.f33544d = com.kwad.sdk.core.response.b.c.g(adTemplate);
        this.f33545e = i2;
        long g2 = com.kwad.sdk.core.response.b.b.g(adTemplate);
        this.f33547g = g2 == 0 ? 1000L : g2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f33541a != null) {
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
            this.f33541a.a(z);
        }
    }

    private boolean c(int i2, int i3) {
        if (com.kwad.sdk.core.response.b.a.K(this.f33544d)) {
            return this.f33545e == 1 ? i2 <= i3 : i2 >= i3;
        }
        return false;
    }

    public void a(int i2, int i3) {
        b bVar;
        if (c(i2, i3)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.i(this.f33543c) || (bVar = this.f33542b) == null) {
            a(false);
        } else if (bVar.a()) {
        } else {
            this.f33546f.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.b.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f33548h = true;
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                    if (a.this.f33542b != null && a.this.f33542b.a()) {
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + a.this.f33547g);
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + a.this.f33547g);
                    e.c(a.this.f33543c, a.this.f33547g);
                    a.this.a(true);
                }
            }, this.f33547g);
        }
    }

    @MainThread
    public void a(InterfaceC0382a interfaceC0382a) {
        this.f33541a = interfaceC0382a;
    }

    @MainThread
    public void a(b bVar) {
        this.f33542b = bVar;
    }

    public void b(int i2, int i3) {
        if (this.f33548h) {
            com.kwad.sdk.core.d.a.c("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f33546f.removeCallbacksAndMessages(null);
        if (c(i2, i3)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.i(this.f33543c) || this.f33542b == null) {
            a(true);
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f33547g);
        this.f33542b.a();
    }
}
