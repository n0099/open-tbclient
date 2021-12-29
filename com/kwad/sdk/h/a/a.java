package com.kwad.sdk.h.a;

import android.app.Activity;
import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.utils.ax;
/* loaded from: classes3.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f59186b;

    /* renamed from: c  reason: collision with root package name */
    public long f59187c;

    /* renamed from: d  reason: collision with root package name */
    public long f59188d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59189e;

    public void a() {
        b bVar = new b();
        bVar.a = this.a;
        long j2 = this.f59186b;
        bVar.f59191c = j2 != 0 ? this.f59187c - j2 : 0L;
        long j3 = this.f59187c;
        bVar.f59192d = j3 != 0 ? this.f59188d - j3 : 0L;
        long j4 = this.f59186b;
        bVar.f59190b = j4 != 0 ? this.f59188d - j4 : 0L;
        d.a(bVar);
        com.kwad.sdk.core.d.a.a("PageMonitor", bVar.toString());
    }

    public void a(long j2) {
        this.f59186b = j2;
        this.f59187c = SystemClock.uptimeMillis();
    }

    public void a(Activity activity) {
        if (this.f59189e) {
            return;
        }
        this.f59189e = true;
        ax.a(new Runnable() { // from class: com.kwad.sdk.h.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.f59188d = SystemClock.uptimeMillis();
                a.this.a();
            }
        });
    }

    public void a(String str) {
        this.a = str;
    }
}
