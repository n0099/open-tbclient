package com.kwad.sdk.contentalliance.detail.photo.newui.d;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.ActivityChooserView;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
/* loaded from: classes5.dex */
public class c {
    private static volatile c i;

    /* renamed from: a  reason: collision with root package name */
    private Context f8863a;
    private int d;
    private int f;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8864b = true;
    private boolean c = true;
    private int e = -1;
    private volatile boolean g = false;
    private volatile boolean h = false;

    /* loaded from: classes5.dex */
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
        if (this.f8864b) {
            return false;
        }
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply enablePageSlideLeft=" + z + " mNeedShowSlideLeftGuide=" + this.c);
        if ((this.c && z) || com.kwad.sdk.core.response.b.c.c(adTemplate)) {
            return false;
        }
        return this.e == -1 || i2 - this.e > c.a.ac.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2) {
        this.e = i2;
        this.d++;
        if (this.d >= this.f) {
            this.g = true;
        }
        ae.b(this.f8863a, this.d);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "realShow mAlreadyShowTimes = " + this.d + " mLastShowPosition=" + this.e);
    }

    @WorkerThread
    public void a(@NonNull Context context) {
        if (this.h) {
            return;
        }
        this.f8863a = context;
        this.d = ae.a(context, 0);
        this.f8864b = ae.c(context);
        this.c = ae.a(context);
        com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "init mNeedShowSlideLeftGuide=" + this.c);
        this.h = true;
    }

    public void a(@NonNull AdTemplate adTemplate, int i2, boolean z, @NonNull a aVar) {
        if (!this.h || this.g) {
            com.kwad.sdk.core.d.a.a("ProfileGuiderManager", "apply !mInited || mNoLongerNeeded");
            return;
        }
        this.f = c.a.ac.f();
        if (!com.kwad.sdk.core.config.c.B() || !com.kwad.sdk.core.config.c.Y() || this.d >= this.f) {
            this.g = true;
        } else if (a(z, adTemplate, i2)) {
            aVar.a(adTemplate, i2);
        }
    }

    public void a(boolean z) {
        this.f8864b = z;
    }

    public void b() {
        this.g = true;
        this.d = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        ae.b(this.f8863a, this.d);
    }

    public void b(boolean z) {
        this.c = z;
    }

    public int c() {
        if (this.d == Integer.MAX_VALUE) {
            return 0;
        }
        return this.d;
    }
}
