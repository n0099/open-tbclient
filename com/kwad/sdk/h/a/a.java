package com.kwad.sdk.h.a;

import android.app.Activity;
import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.utils.ax;
/* loaded from: classes3.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f57003b;

    /* renamed from: c  reason: collision with root package name */
    public long f57004c;

    /* renamed from: d  reason: collision with root package name */
    public long f57005d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57006e;

    public void a() {
        b bVar = new b();
        bVar.a = this.a;
        long j2 = this.f57003b;
        bVar.f57008c = j2 != 0 ? this.f57004c - j2 : 0L;
        long j3 = this.f57004c;
        bVar.f57009d = j3 != 0 ? this.f57005d - j3 : 0L;
        long j4 = this.f57003b;
        bVar.f57007b = j4 != 0 ? this.f57005d - j4 : 0L;
        d.a(bVar);
        com.kwad.sdk.core.d.a.a("PageMonitor", bVar.toString());
    }

    public void a(long j2) {
        this.f57003b = j2;
        this.f57004c = SystemClock.uptimeMillis();
    }

    public void a(Activity activity) {
        if (this.f57006e) {
            return;
        }
        this.f57006e = true;
        ax.a(new Runnable() { // from class: com.kwad.sdk.h.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.f57005d = SystemClock.uptimeMillis();
                a.this.a();
            }
        });
    }

    public void a(String str) {
        this.a = str;
    }
}
