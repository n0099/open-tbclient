package com.kwad.sdk.h.a;

import android.app.Activity;
import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.utils.ax;
/* loaded from: classes4.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f57170b;

    /* renamed from: c  reason: collision with root package name */
    public long f57171c;

    /* renamed from: d  reason: collision with root package name */
    public long f57172d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57173e;

    public void a() {
        b bVar = new b();
        bVar.a = this.a;
        long j2 = this.f57170b;
        bVar.f57175c = j2 != 0 ? this.f57171c - j2 : 0L;
        long j3 = this.f57171c;
        bVar.f57176d = j3 != 0 ? this.f57172d - j3 : 0L;
        long j4 = this.f57170b;
        bVar.f57174b = j4 != 0 ? this.f57172d - j4 : 0L;
        d.a(bVar);
        com.kwad.sdk.core.d.a.a("PageMonitor", bVar.toString());
    }

    public void a(long j2) {
        this.f57170b = j2;
        this.f57171c = SystemClock.uptimeMillis();
    }

    public void a(Activity activity) {
        if (this.f57173e) {
            return;
        }
        this.f57173e = true;
        ax.a(new Runnable() { // from class: com.kwad.sdk.h.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.f57172d = SystemClock.uptimeMillis();
                a.this.a();
            }
        });
    }

    public void a(String str) {
        this.a = str;
    }
}
