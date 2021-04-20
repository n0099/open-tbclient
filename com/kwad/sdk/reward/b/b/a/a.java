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
    public InterfaceC0446a f36550a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f36551b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f36552c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f36553d;

    /* renamed from: e  reason: collision with root package name */
    public int f36554e;

    /* renamed from: g  reason: collision with root package name */
    public final long f36556g;

    /* renamed from: f  reason: collision with root package name */
    public Handler f36555f = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f36557h = false;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0446a {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate, int i) {
        this.f36552c = adTemplate;
        this.f36553d = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36554e = i;
        long l = com.kwad.sdk.core.response.b.b.l(adTemplate);
        this.f36556g = l == 0 ? 1000L : l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f36550a != null) {
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
            this.f36550a.a(z);
        }
    }

    private boolean c(int i, int i2) {
        if (com.kwad.sdk.core.response.b.a.O(this.f36553d)) {
            return this.f36554e == 1 ? i <= i2 : i >= i2;
        }
        return false;
    }

    public void a(int i, int i2) {
        b bVar;
        if (c(i, i2)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.f36552c) || (bVar = this.f36551b) == null) {
            a(false);
        } else if (bVar.a()) {
        } else {
            this.f36555f.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.b.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f36557h = true;
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                    if (a.this.f36551b != null && a.this.f36551b.a()) {
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + a.this.f36556g);
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + a.this.f36556g);
                    a.this.a(true);
                }
            }, this.f36556g);
        }
    }

    @MainThread
    public void a(InterfaceC0446a interfaceC0446a) {
        this.f36550a = interfaceC0446a;
    }

    @MainThread
    public void a(b bVar) {
        this.f36551b = bVar;
    }

    public void b(int i, int i2) {
        if (this.f36557h) {
            com.kwad.sdk.core.d.a.b("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f36555f.removeCallbacksAndMessages(null);
        if (c(i, i2)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.f36552c) || this.f36551b == null) {
            a(true);
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f36556g);
        this.f36551b.a();
    }
}
