package com.kwad.sdk.contentalliance.detail.photo.newui.d;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    public static volatile c f33129i;

    /* renamed from: a  reason: collision with root package name */
    public Context f33130a;

    /* renamed from: d  reason: collision with root package name */
    public int f33133d;

    /* renamed from: f  reason: collision with root package name */
    public int f33135f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f33131b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33132c = true;

    /* renamed from: e  reason: collision with root package name */
    public int f33134e = -1;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f33136g = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f33137h = false;

    /* loaded from: classes6.dex */
    public interface a {
        void a(AdTemplate adTemplate, int i2);
    }

    public static c a() {
        if (f33129i == null) {
            synchronized (c.class) {
                if (f33129i == null) {
                    f33129i = new c();
                }
            }
        }
        return f33129i;
    }

    private boolean a(boolean z, @NonNull AdTemplate adTemplate, int i2) {
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply mNeedShowSlideUpGuide");
        if (this.f33131b) {
            return false;
        }
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply enablePageSlideLeft=" + z + " mNeedShowSlideLeftGuide=" + this.f33132c);
        if ((this.f33132c && z) || com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            return false;
        }
        int e2 = c.a.ac.e();
        int i3 = this.f33134e;
        return i3 == -1 || i2 - i3 > e2;
    }

    public void a(int i2) {
        this.f33134e = i2;
        int i3 = this.f33133d + 1;
        this.f33133d = i3;
        if (i3 >= this.f33135f) {
            this.f33136g = true;
        }
        ae.b(this.f33130a, this.f33133d);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "realShow mAlreadyShowTimes = " + this.f33133d + " mLastShowPosition=" + this.f33134e);
    }

    @WorkerThread
    public void a(@NonNull Context context) {
        if (this.f33137h) {
            return;
        }
        this.f33130a = context;
        this.f33133d = ae.a(context, 0);
        this.f33131b = ae.c(context);
        this.f33132c = ae.a(context);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "init mNeedShowSlideLeftGuide=" + this.f33132c);
        this.f33137h = true;
    }

    public void a(@NonNull AdTemplate adTemplate, int i2, boolean z, @NonNull a aVar) {
        if (!this.f33137h || this.f33136g) {
            com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply !mInited || mNoLongerNeeded");
            return;
        }
        this.f33135f = c.a.ac.f();
        if (!com.kwad.sdk.core.config.c.B() || !com.kwad.sdk.core.config.c.Y() || this.f33133d >= this.f33135f) {
            this.f33136g = true;
        } else if (a(z, adTemplate, i2)) {
            aVar.a(adTemplate, i2);
        }
    }

    public void a(boolean z) {
        this.f33131b = z;
    }

    public void b() {
        this.f33136g = true;
        this.f33133d = Integer.MAX_VALUE;
        ae.b(this.f33130a, Integer.MAX_VALUE);
    }

    public void b(boolean z) {
        this.f33132c = z;
    }

    public int c() {
        int i2 = this.f33133d;
        if (i2 == Integer.MAX_VALUE) {
            return 0;
        }
        return i2;
    }
}
