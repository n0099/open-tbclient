package com.kwad.sdk.reward.b.b.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private InterfaceC1141a f10541a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private b f10542b;
    private AdTemplate c;
    private AdInfo d;
    private int e;
    private final long g;
    private Handler f = new Handler(Looper.getMainLooper());
    private boolean h = false;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1141a {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate, int i) {
        this.c = adTemplate;
        this.d = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.e = i;
        long l = com.kwad.sdk.core.response.b.b.l(adTemplate);
        this.g = l == 0 ? 1000L : l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f10541a != null) {
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
            this.f10541a.a(z);
        }
    }

    private boolean c(int i, int i2) {
        if (com.kwad.sdk.core.response.b.a.O(this.d)) {
            return this.e == 1 ? i <= i2 : i >= i2;
        }
        return false;
    }

    public void a(int i, int i2) {
        if (c(i, i2)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.c) || this.f10542b == null) {
            a(false);
        } else if (this.f10542b.a()) {
        } else {
            this.f.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.b.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.h = true;
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                    if (a.this.f10542b != null && a.this.f10542b.a()) {
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + a.this.g);
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + a.this.g);
                    a.this.a(true);
                }
            }, this.g);
        }
    }

    @MainThread
    public void a(InterfaceC1141a interfaceC1141a) {
        this.f10541a = interfaceC1141a;
    }

    @MainThread
    public void a(b bVar) {
        this.f10542b = bVar;
    }

    public void b(int i, int i2) {
        if (this.h) {
            com.kwad.sdk.core.d.a.b("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f.removeCallbacksAndMessages(null);
        if (c(i, i2)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.c) || this.f10542b == null) {
            a(true);
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.g);
        this.f10542b.a();
    }
}
