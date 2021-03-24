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
    public InterfaceC0431a f36260a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f36261b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f36262c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f36263d;

    /* renamed from: e  reason: collision with root package name */
    public int f36264e;

    /* renamed from: g  reason: collision with root package name */
    public final long f36266g;

    /* renamed from: f  reason: collision with root package name */
    public Handler f36265f = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f36267h = false;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0431a {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate, int i) {
        this.f36262c = adTemplate;
        this.f36263d = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f36264e = i;
        long l = com.kwad.sdk.core.response.b.b.l(adTemplate);
        this.f36266g = l == 0 ? 1000L : l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f36260a != null) {
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
            this.f36260a.a(z);
        }
    }

    private boolean c(int i, int i2) {
        if (com.kwad.sdk.core.response.b.a.O(this.f36263d)) {
            return this.f36264e == 1 ? i <= i2 : i >= i2;
        }
        return false;
    }

    public void a(int i, int i2) {
        b bVar;
        if (c(i, i2)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.f36262c) || (bVar = this.f36261b) == null) {
            a(false);
        } else if (bVar.a()) {
        } else {
            this.f36265f.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.b.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f36267h = true;
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                    if (a.this.f36261b != null && a.this.f36261b.a()) {
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + a.this.f36266g);
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + a.this.f36266g);
                    a.this.a(true);
                }
            }, this.f36266g);
        }
    }

    @MainThread
    public void a(InterfaceC0431a interfaceC0431a) {
        this.f36260a = interfaceC0431a;
    }

    @MainThread
    public void a(b bVar) {
        this.f36261b = bVar;
    }

    public void b(int i, int i2) {
        if (this.f36267h) {
            com.kwad.sdk.core.d.a.b("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f36265f.removeCallbacksAndMessages(null);
        if (c(i, i2)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.f36262c) || this.f36261b == null) {
            a(true);
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f36266g);
        this.f36261b.a();
    }
}
