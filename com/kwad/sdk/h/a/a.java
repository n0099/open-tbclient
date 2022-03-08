package com.kwad.sdk.h.a;

import android.app.Activity;
import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.utils.ax;
/* loaded from: classes8.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f55520b;

    /* renamed from: c  reason: collision with root package name */
    public long f55521c;

    /* renamed from: d  reason: collision with root package name */
    public long f55522d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55523e;

    public void a() {
        b bVar = new b();
        bVar.a = this.a;
        long j2 = this.f55520b;
        bVar.f55525c = j2 != 0 ? this.f55521c - j2 : 0L;
        long j3 = this.f55521c;
        bVar.f55526d = j3 != 0 ? this.f55522d - j3 : 0L;
        long j4 = this.f55520b;
        bVar.f55524b = j4 != 0 ? this.f55522d - j4 : 0L;
        d.a(bVar);
        com.kwad.sdk.core.d.a.a("PageMonitor", bVar.toString());
    }

    public void a(long j2) {
        this.f55520b = j2;
        this.f55521c = SystemClock.uptimeMillis();
    }

    public void a(Activity activity) {
        if (this.f55523e) {
            return;
        }
        this.f55523e = true;
        ax.a(new Runnable() { // from class: com.kwad.sdk.h.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.f55522d = SystemClock.uptimeMillis();
                a.this.a();
            }
        });
    }

    public void a(String str) {
        this.a = str;
    }
}
