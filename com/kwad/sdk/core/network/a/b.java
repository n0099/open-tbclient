package com.kwad.sdk.core.network.a;

import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes3.dex */
public class b {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f55884b;

    /* renamed from: c  reason: collision with root package name */
    public long f55885c;

    /* renamed from: d  reason: collision with root package name */
    public long f55886d;

    /* renamed from: e  reason: collision with root package name */
    public String f55887e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f55888f;

    /* renamed from: g  reason: collision with root package name */
    public String f55889g = "";

    public void a() {
        this.a = SystemClock.uptimeMillis();
    }

    public void a(String str) {
        this.f55889g = str;
    }

    public void a(String str, SceneImpl sceneImpl) {
        this.f55887e = str;
        this.f55888f = sceneImpl;
    }

    public void b() {
        this.f55884b = SystemClock.uptimeMillis();
    }

    public void c() {
        this.f55885c = SystemClock.uptimeMillis();
    }

    public void d() {
        this.f55886d = SystemClock.uptimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        a aVar = new a();
        aVar.f55883g = this.f55887e;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j7 = this.a;
        aVar.a = j7 != 0 ? uptimeMillis - j7 : 0L;
        long j8 = this.f55884b;
        if (j8 != 0) {
            long j9 = this.a;
            if (j9 != 0) {
                j2 = j8 - j9;
                aVar.f55878b = j2;
                j3 = this.f55885c;
                if (j3 != 0) {
                    long j10 = this.f55884b;
                    if (j10 != 0) {
                        j4 = j3 - j10;
                        aVar.f55879c = j4;
                        j5 = this.f55886d;
                        if (j5 != 0) {
                            long j11 = this.f55885c;
                            if (j11 != 0) {
                                j6 = j5 - j11;
                                aVar.f55880d = j6;
                                long j12 = this.f55886d;
                                aVar.f55881e = j12 != 0 ? uptimeMillis - j12 : 0L;
                                aVar.f55882f = this.f55889g;
                                d.a(this.f55888f, aVar);
                                com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                            }
                        }
                        j6 = 0;
                        aVar.f55880d = j6;
                        long j122 = this.f55886d;
                        aVar.f55881e = j122 != 0 ? uptimeMillis - j122 : 0L;
                        aVar.f55882f = this.f55889g;
                        d.a(this.f55888f, aVar);
                        com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                    }
                }
                j4 = 0;
                aVar.f55879c = j4;
                j5 = this.f55886d;
                if (j5 != 0) {
                }
                j6 = 0;
                aVar.f55880d = j6;
                long j1222 = this.f55886d;
                aVar.f55881e = j1222 != 0 ? uptimeMillis - j1222 : 0L;
                aVar.f55882f = this.f55889g;
                d.a(this.f55888f, aVar);
                com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
            }
        }
        j2 = 0;
        aVar.f55878b = j2;
        j3 = this.f55885c;
        if (j3 != 0) {
        }
        j4 = 0;
        aVar.f55879c = j4;
        j5 = this.f55886d;
        if (j5 != 0) {
        }
        j6 = 0;
        aVar.f55880d = j6;
        long j12222 = this.f55886d;
        aVar.f55881e = j12222 != 0 ? uptimeMillis - j12222 : 0L;
        aVar.f55882f = this.f55889g;
        d.a(this.f55888f, aVar);
        com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
    }
}
