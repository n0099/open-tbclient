package com.kwad.sdk.h.a;

import android.app.Activity;
import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.utils.ax;
/* loaded from: classes7.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f40551b;

    /* renamed from: c  reason: collision with root package name */
    public long f40552c;

    /* renamed from: d  reason: collision with root package name */
    public long f40553d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40554e;

    public void a() {
        b bVar = new b();
        bVar.a = this.a;
        long j = this.f40551b;
        bVar.f40556c = j != 0 ? this.f40552c - j : 0L;
        long j2 = this.f40552c;
        bVar.f40557d = j2 != 0 ? this.f40553d - j2 : 0L;
        long j3 = this.f40551b;
        bVar.f40555b = j3 != 0 ? this.f40553d - j3 : 0L;
        d.a(bVar);
        com.kwad.sdk.core.d.a.a("PageMonitor", bVar.toString());
    }

    public void a(long j) {
        this.f40551b = j;
        this.f40552c = SystemClock.uptimeMillis();
    }

    public void a(Activity activity) {
        if (this.f40554e) {
            return;
        }
        this.f40554e = true;
        ax.a(new Runnable() { // from class: com.kwad.sdk.h.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.f40553d = SystemClock.uptimeMillis();
                a.this.a();
            }
        });
    }

    public void a(String str) {
        this.a = str;
    }
}
