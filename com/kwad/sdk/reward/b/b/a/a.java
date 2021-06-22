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
    public InterfaceC0435a f37094a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public b f37095b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f37096c;

    /* renamed from: d  reason: collision with root package name */
    public AdInfo f37097d;

    /* renamed from: e  reason: collision with root package name */
    public int f37098e;

    /* renamed from: g  reason: collision with root package name */
    public final long f37100g;

    /* renamed from: f  reason: collision with root package name */
    public Handler f37099f = new Handler(Looper.getMainLooper());

    /* renamed from: h  reason: collision with root package name */
    public boolean f37101h = false;

    /* renamed from: com.kwad.sdk.reward.b.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0435a {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface b {
        boolean a();
    }

    public a(AdTemplate adTemplate, int i2) {
        this.f37096c = adTemplate;
        this.f37097d = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.f37098e = i2;
        long l = com.kwad.sdk.core.response.b.b.l(adTemplate);
        this.f37100g = l == 0 ? 1000L : l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f37094a != null) {
            com.kwad.sdk.core.d.a.a("ActionBarControl", "showNativeActionBar");
            this.f37094a.a(z);
        }
    }

    private boolean c(int i2, int i3) {
        if (com.kwad.sdk.core.response.b.a.O(this.f37097d)) {
            return this.f37098e == 1 ? i2 <= i3 : i2 >= i3;
        }
        return false;
    }

    public void a(int i2, int i3) {
        b bVar;
        if (c(i2, i3)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.f37096c) || (bVar = this.f37095b) == null) {
            a(false);
        } else if (bVar.a()) {
        } else {
            this.f37099f.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.b.b.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f37101h = true;
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "mHasOutTime");
                    if (a.this.f37095b != null && a.this.f37095b.a()) {
                        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success on " + a.this.f37100g);
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar out " + a.this.f37100g);
                    a.this.a(true);
                }
            }, this.f37100g);
        }
    }

    @MainThread
    public void a(InterfaceC0435a interfaceC0435a) {
        this.f37094a = interfaceC0435a;
    }

    @MainThread
    public void a(b bVar) {
        this.f37095b = bVar;
    }

    public void b(int i2, int i3) {
        if (this.f37101h) {
            com.kwad.sdk.core.d.a.b("ActionBarControl", "showWebActionBar time out on pageStatus");
            return;
        }
        this.f37099f.removeCallbacksAndMessages(null);
        if (c(i2, i3)) {
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.o(this.f37096c) || this.f37095b == null) {
            a(true);
            return;
        }
        com.kwad.sdk.core.d.a.a("ActionBarControl", "showWebActionBar success in " + this.f37100g);
        this.f37095b.a();
    }
}
