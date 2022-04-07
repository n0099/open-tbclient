package com.kwad.sdk.core.network.a;

import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes5.dex */
public class b {
    public long a;
    public long b;
    public long c;
    public long d;
    public String e;
    public SceneImpl f;
    public String g = "";

    public void a() {
        this.a = SystemClock.uptimeMillis();
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(String str, SceneImpl sceneImpl) {
        this.e = str;
        this.f = sceneImpl;
    }

    public void b() {
        this.b = SystemClock.uptimeMillis();
    }

    public void c() {
        this.c = SystemClock.uptimeMillis();
    }

    public void d() {
        this.d = SystemClock.uptimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        a aVar = new a();
        aVar.g = this.e;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j6 = this.a;
        aVar.a = j6 != 0 ? uptimeMillis - j6 : 0L;
        long j7 = this.b;
        if (j7 != 0) {
            long j8 = this.a;
            if (j8 != 0) {
                j = j7 - j8;
                aVar.b = j;
                j2 = this.c;
                if (j2 != 0) {
                    long j9 = this.b;
                    if (j9 != 0) {
                        j3 = j2 - j9;
                        aVar.c = j3;
                        j4 = this.d;
                        if (j4 != 0) {
                            long j10 = this.c;
                            if (j10 != 0) {
                                j5 = j4 - j10;
                                aVar.d = j5;
                                long j11 = this.d;
                                aVar.e = j11 != 0 ? uptimeMillis - j11 : 0L;
                                aVar.f = this.g;
                                d.a(this.f, aVar);
                                com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                            }
                        }
                        j5 = 0;
                        aVar.d = j5;
                        long j112 = this.d;
                        aVar.e = j112 != 0 ? uptimeMillis - j112 : 0L;
                        aVar.f = this.g;
                        d.a(this.f, aVar);
                        com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                    }
                }
                j3 = 0;
                aVar.c = j3;
                j4 = this.d;
                if (j4 != 0) {
                }
                j5 = 0;
                aVar.d = j5;
                long j1122 = this.d;
                aVar.e = j1122 != 0 ? uptimeMillis - j1122 : 0L;
                aVar.f = this.g;
                d.a(this.f, aVar);
                com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
            }
        }
        j = 0;
        aVar.b = j;
        j2 = this.c;
        if (j2 != 0) {
        }
        j3 = 0;
        aVar.c = j3;
        j4 = this.d;
        if (j4 != 0) {
        }
        j5 = 0;
        aVar.d = j5;
        long j11222 = this.d;
        aVar.e = j11222 != 0 ? uptimeMillis - j11222 : 0L;
        aVar.f = this.g;
        d.a(this.f, aVar);
        com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
    }
}
