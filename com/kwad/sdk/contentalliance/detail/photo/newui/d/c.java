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
    public Context f32839a;

    /* renamed from: d  reason: collision with root package name */
    public int f32842d;

    /* renamed from: f  reason: collision with root package name */
    public int f32844f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f32840b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32841c = true;

    /* renamed from: e  reason: collision with root package name */
    public int f32843e = -1;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f32845g = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f32846h = false;

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
        if (this.f32840b) {
            return false;
        }
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply enablePageSlideLeft=" + z + " mNeedShowSlideLeftGuide=" + this.f32841c);
        if ((this.f32841c && z) || com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            return false;
        }
        int e2 = c.a.ac.e();
        int i3 = this.f32843e;
        return i3 == -1 || i2 - i3 > e2;
    }

    public void a(int i2) {
        this.f32843e = i2;
        int i3 = this.f32842d + 1;
        this.f32842d = i3;
        if (i3 >= this.f32844f) {
            this.f32845g = true;
        }
        ae.b(this.f32839a, this.f32842d);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "realShow mAlreadyShowTimes = " + this.f32842d + " mLastShowPosition=" + this.f32843e);
    }

    @WorkerThread
    public void a(@NonNull Context context) {
        if (this.f32846h) {
            return;
        }
        this.f32839a = context;
        this.f32842d = ae.a(context, 0);
        this.f32840b = ae.c(context);
        this.f32841c = ae.a(context);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "init mNeedShowSlideLeftGuide=" + this.f32841c);
        this.f32846h = true;
    }

    public void a(@NonNull AdTemplate adTemplate, int i2, boolean z, @NonNull a aVar) {
        if (!this.f32846h || this.f32845g) {
            com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply !mInited || mNoLongerNeeded");
            return;
        }
        this.f32844f = c.a.ac.f();
        if (!com.kwad.sdk.core.config.c.B() || !com.kwad.sdk.core.config.c.Y() || this.f32842d >= this.f32844f) {
            this.f32845g = true;
        } else if (a(z, adTemplate, i2)) {
            aVar.a(adTemplate, i2);
        }
    }

    public void a(boolean z) {
        this.f32840b = z;
    }

    public void b() {
        this.f32845g = true;
        this.f32842d = Integer.MAX_VALUE;
        ae.b(this.f32839a, Integer.MAX_VALUE);
    }

    public void b(boolean z) {
        this.f32841c = z;
    }

    public int c() {
        int i2 = this.f32842d;
        if (i2 == Integer.MAX_VALUE) {
            return 0;
        }
        return i2;
    }
}
