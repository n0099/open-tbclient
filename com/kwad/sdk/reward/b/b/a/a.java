package com.kwad.sdk.reward.b.b.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0449a f36645a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f36646b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f36647c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f36648d;

    /* renamed from: e  reason: collision with root package name */
    public int f36649e;

    /* renamed from: g  reason: collision with root package name */
    public final long f36651g;

    /* renamed from: f  reason: collision with root package name */
    public Handler f36650f = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f36652h = false;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0449a {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate, int i) {
        this.f36647c = adTemplate;
        this.f36648d = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36649e = i;
        long l = com.kwad.sdk.core.response.b.b.l(adTemplate);
        this.f36651g = l == 0 ? 1000L : l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f36645a != null) {
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
            this.f36645a.a(z);
        }
    }

    private boolean c(int i, int i2) {
        if (com.kwad.sdk.core.response.b.a.O(this.f36648d)) {
            return this.f36649e == 1 ? i <= i2 : i >= i2;
        }
        return false;
    }

    public void a(int i, int i2) {
        b bVar;
        if (c(i, i2)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.f36647c) || (bVar = this.f36646b) == null) {
            a(false);
        } else if (bVar.a()) {
        } else {
            this.f36650f.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.b.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f36652h = true;
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                    if (a.this.f36646b != null && a.this.f36646b.a()) {
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + a.this.f36651g);
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + a.this.f36651g);
                    a.this.a(true);
                }
            }, this.f36651g);
        }
    }

    @MainThread
    public void a(InterfaceC0449a interfaceC0449a) {
        this.f36645a = interfaceC0449a;
    }

    @MainThread
    public void a(b bVar) {
        this.f36646b = bVar;
    }

    public void b(int i, int i2) {
        if (this.f36652h) {
            com.kwad.sdk.core.d.a.b("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f36650f.removeCallbacksAndMessages(null);
        if (c(i, i2)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.f36647c) || this.f36646b == null) {
            a(true);
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f36651g);
        this.f36646b.a();
    }
}
