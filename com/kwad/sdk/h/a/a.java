package com.kwad.sdk.h.a;

import android.app.Activity;
import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.utils.ax;
/* loaded from: classes3.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f56958b;

    /* renamed from: c  reason: collision with root package name */
    public long f56959c;

    /* renamed from: d  reason: collision with root package name */
    public long f56960d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56961e;

    public void a() {
        b bVar = new b();
        bVar.a = this.a;
        long j2 = this.f56958b;
        bVar.f56963c = j2 != 0 ? this.f56959c - j2 : 0L;
        long j3 = this.f56959c;
        bVar.f56964d = j3 != 0 ? this.f56960d - j3 : 0L;
        long j4 = this.f56958b;
        bVar.f56962b = j4 != 0 ? this.f56960d - j4 : 0L;
        d.a(bVar);
        com.kwad.sdk.core.d.a.a("PageMonitor", bVar.toString());
    }

    public void a(long j2) {
        this.f56958b = j2;
        this.f56959c = SystemClock.uptimeMillis();
    }

    public void a(Activity activity) {
        if (this.f56961e) {
            return;
        }
        this.f56961e = true;
        ax.a(new Runnable() { // from class: com.kwad.sdk.h.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.f56960d = SystemClock.uptimeMillis();
                a.this.a();
            }
        });
    }

    public void a(String str) {
        this.a = str;
    }
}
