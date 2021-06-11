package com.kwad.sdk.reward.b.b.a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0432a f36996a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f36997b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f36998c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f36999d;

    /* renamed from: e  reason: collision with root package name */
    public int f37000e;

    /* renamed from: g  reason: collision with root package name */
    public final long f37002g;

    /* renamed from: f  reason: collision with root package name */
    public Handler f37001f = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f37003h = false;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0432a {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate, int i2) {
        this.f36998c = adTemplate;
        this.f36999d = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37000e = i2;
        long l = com.kwad.sdk.core.response.b.b.l(adTemplate);
        this.f37002g = l == 0 ? 1000L : l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f36996a != null) {
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
            this.f36996a.a(z);
        }
    }

    private boolean c(int i2, int i3) {
        if (com.kwad.sdk.core.response.b.a.O(this.f36999d)) {
            return this.f37000e == 1 ? i2 <= i3 : i2 >= i3;
        }
        return false;
    }

    public void a(int i2, int i3) {
        b bVar;
        if (c(i2, i3)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.f36998c) || (bVar = this.f36997b) == null) {
            a(false);
        } else if (bVar.a()) {
        } else {
            this.f37001f.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.b.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f37003h = true;
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                    if (a.this.f36997b != null && a.this.f36997b.a()) {
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + a.this.f37002g);
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + a.this.f37002g);
                    a.this.a(true);
                }
            }, this.f37002g);
        }
    }

    @MainThread
    public void a(InterfaceC0432a interfaceC0432a) {
        this.f36996a = interfaceC0432a;
    }

    @MainThread
    public void a(b bVar) {
        this.f36997b = bVar;
    }

    public void b(int i2, int i3) {
        if (this.f37003h) {
            com.kwad.sdk.core.d.a.b("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f37001f.removeCallbacksAndMessages(null);
        if (c(i2, i3)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.f36998c) || this.f36997b == null) {
            a(true);
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f37002g);
        this.f36997b.a();
    }
}
