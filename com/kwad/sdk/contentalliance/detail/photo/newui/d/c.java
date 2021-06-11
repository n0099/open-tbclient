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
    public static volatile c f33031i;

    /* renamed from: a  reason: collision with root package name */
    public Context f33032a;

    /* renamed from: d  reason: collision with root package name */
    public int f33035d;

    /* renamed from: f  reason: collision with root package name */
    public int f33037f;

    /* renamed from: b  reason: collision with root package name */
    public boolean f33033b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33034c = true;

    /* renamed from: e  reason: collision with root package name */
    public int f33036e = -1;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f33038g = false;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f33039h = false;

    /* loaded from: classes6.dex */
    public interface a {
        void a(AdTemplate adTemplate, int i2);
    }

    public static c a() {
        if (f33031i == null) {
            synchronized (c.class) {
                if (f33031i == null) {
                    f33031i = new c();
                }
            }
        }
        return f33031i;
    }

    private boolean a(boolean z, @NonNull AdTemplate adTemplate, int i2) {
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply mNeedShowSlideUpGuide");
        if (this.f33033b) {
            return false;
        }
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply enablePageSlideLeft=" + z + " mNeedShowSlideLeftGuide=" + this.f33034c);
        if ((this.f33034c && z) || com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            return false;
        }
        int e2 = c.a.ac.e();
        int i3 = this.f33036e;
        return i3 == -1 || i2 - i3 > e2;
    }

    public void a(int i2) {
        this.f33036e = i2;
        int i3 = this.f33035d + 1;
        this.f33035d = i3;
        if (i3 >= this.f33037f) {
            this.f33038g = true;
        }
        ae.b(this.f33032a, this.f33035d);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "realShow mAlreadyShowTimes = " + this.f33035d + " mLastShowPosition=" + this.f33036e);
    }

    @WorkerThread
    public void a(@NonNull Context context) {
        if (this.f33039h) {
            return;
        }
        this.f33032a = context;
        this.f33035d = ae.a(context, 0);
        this.f33033b = ae.c(context);
        this.f33034c = ae.a(context);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "init mNeedShowSlideLeftGuide=" + this.f33034c);
        this.f33039h = true;
    }

    public void a(@NonNull AdTemplate adTemplate, int i2, boolean z, @NonNull a aVar) {
        if (!this.f33039h || this.f33038g) {
            com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply !mInited || mNoLongerNeeded");
            return;
        }
        this.f33037f = c.a.ac.f();
        if (!com.kwad.sdk.core.config.c.B() || !com.kwad.sdk.core.config.c.Y() || this.f33035d >= this.f33037f) {
            this.f33038g = true;
        } else if (a(z, adTemplate, i2)) {
            aVar.a(adTemplate, i2);
        }
    }

    public void a(boolean z) {
        this.f33033b = z;
    }

    public void b() {
        this.f33038g = true;
        this.f33035d = Integer.MAX_VALUE;
        ae.b(this.f33032a, Integer.MAX_VALUE);
    }

    public void b(boolean z) {
        this.f33034c = z;
    }

    public int c() {
        int i2 = this.f33035d;
        if (i2 == Integer.MAX_VALUE) {
            return 0;
        }
        return i2;
    }
}
