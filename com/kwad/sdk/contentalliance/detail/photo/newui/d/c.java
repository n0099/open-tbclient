package com.kwad.sdk.contentalliance.detail.photo.newui.d;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
/* loaded from: classes6.dex */
public class c {
    public static volatile c i;

    /* renamed from: a  reason: collision with root package name */
    public Context f32454a;

    /* renamed from: d  reason: collision with root package name */
    public int f32457d;

    /* renamed from: f  reason: collision with root package name */
    public int f32459f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f32455b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32456c = true;

    /* renamed from: e  reason: collision with root package name */
    public int f32458e = -1;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f32460g = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f32461h = false;

    /* loaded from: classes6.dex */
    public interface a {
        void a(AdTemplate adTemplate, int i);
    }

    public static c a() {
        if (i == null) {
            synchronized (c.class) {
                if (i == null) {
                    i = new c();
                }
            }
        }
        return i;
    }

    private boolean a(boolean z, @NonNull AdTemplate adTemplate, int i2) {
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply mNeedShowSlideUpGuide");
        if (this.f32455b) {
            return false;
        }
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply enablePageSlideLeft=" + z + " mNeedShowSlideLeftGuide=" + this.f32456c);
        if ((this.f32456c && z) || com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            return false;
        }
        int e2 = c.a.ac.e();
        int i3 = this.f32458e;
        return i3 == -1 || i2 - i3 > e2;
    }

    public void a(int i2) {
        this.f32458e = i2;
        int i3 = this.f32457d + 1;
        this.f32457d = i3;
        if (i3 >= this.f32459f) {
            this.f32460g = true;
        }
        ae.b(this.f32454a, this.f32457d);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "realShow mAlreadyShowTimes = " + this.f32457d + " mLastShowPosition=" + this.f32458e);
    }

    @WorkerThread
    public void a(@NonNull Context context) {
        if (this.f32461h) {
            return;
        }
        this.f32454a = context;
        this.f32457d = ae.a(context, 0);
        this.f32455b = ae.c(context);
        this.f32456c = ae.a(context);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "init mNeedShowSlideLeftGuide=" + this.f32456c);
        this.f32461h = true;
    }

    public void a(@NonNull AdTemplate adTemplate, int i2, boolean z, @NonNull a aVar) {
        if (!this.f32461h || this.f32460g) {
            com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply !mInited || mNoLongerNeeded");
            return;
        }
        this.f32459f = c.a.ac.f();
        if (!com.kwad.sdk.core.config.c.B() || !com.kwad.sdk.core.config.c.Y() || this.f32457d >= this.f32459f) {
            this.f32460g = true;
        } else if (a(z, adTemplate, i2)) {
            aVar.a(adTemplate, i2);
        }
    }

    public void a(boolean z) {
        this.f32455b = z;
    }

    public void b() {
        this.f32460g = true;
        this.f32457d = Integer.MAX_VALUE;
        ae.b(this.f32454a, Integer.MAX_VALUE);
    }

    public void b(boolean z) {
        this.f32456c = z;
    }

    public int c() {
        int i2 = this.f32457d;
        if (i2 == Integer.MAX_VALUE) {
            return 0;
        }
        return i2;
    }
}
