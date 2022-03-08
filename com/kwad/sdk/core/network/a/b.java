package com.kwad.sdk.core.network.a;

import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes7.dex */
public class b {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f54446b;

    /* renamed from: c  reason: collision with root package name */
    public long f54447c;

    /* renamed from: d  reason: collision with root package name */
    public long f54448d;

    /* renamed from: e  reason: collision with root package name */
    public String f54449e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f54450f;

    /* renamed from: g  reason: collision with root package name */
    public String f54451g = "";

    public void a() {
        this.a = SystemClock.uptimeMillis();
    }

    public void a(String str) {
        this.f54451g = str;
    }

    public void a(String str, SceneImpl sceneImpl) {
        this.f54449e = str;
        this.f54450f = sceneImpl;
    }

    public void b() {
        this.f54446b = SystemClock.uptimeMillis();
    }

    public void c() {
        this.f54447c = SystemClock.uptimeMillis();
    }

    public void d() {
        this.f54448d = SystemClock.uptimeMillis();
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
        aVar.f54445g = this.f54449e;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j7 = this.a;
        aVar.a = j7 != 0 ? uptimeMillis - j7 : 0L;
        long j8 = this.f54446b;
        if (j8 != 0) {
            long j9 = this.a;
            if (j9 != 0) {
                j2 = j8 - j9;
                aVar.f54440b = j2;
                j3 = this.f54447c;
                if (j3 != 0) {
                    long j10 = this.f54446b;
                    if (j10 != 0) {
                        j4 = j3 - j10;
                        aVar.f54441c = j4;
                        j5 = this.f54448d;
                        if (j5 != 0) {
                            long j11 = this.f54447c;
                            if (j11 != 0) {
                                j6 = j5 - j11;
                                aVar.f54442d = j6;
                                long j12 = this.f54448d;
                                aVar.f54443e = j12 != 0 ? uptimeMillis - j12 : 0L;
                                aVar.f54444f = this.f54451g;
                                d.a(this.f54450f, aVar);
                                com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                            }
                        }
                        j6 = 0;
                        aVar.f54442d = j6;
                        long j122 = this.f54448d;
                        aVar.f54443e = j122 != 0 ? uptimeMillis - j122 : 0L;
                        aVar.f54444f = this.f54451g;
                        d.a(this.f54450f, aVar);
                        com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                    }
                }
                j4 = 0;
                aVar.f54441c = j4;
                j5 = this.f54448d;
                if (j5 != 0) {
                }
                j6 = 0;
                aVar.f54442d = j6;
                long j1222 = this.f54448d;
                aVar.f54443e = j1222 != 0 ? uptimeMillis - j1222 : 0L;
                aVar.f54444f = this.f54451g;
                d.a(this.f54450f, aVar);
                com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
            }
        }
        j2 = 0;
        aVar.f54440b = j2;
        j3 = this.f54447c;
        if (j3 != 0) {
        }
        j4 = 0;
        aVar.f54441c = j4;
        j5 = this.f54448d;
        if (j5 != 0) {
        }
        j6 = 0;
        aVar.f54442d = j6;
        long j12222 = this.f54448d;
        aVar.f54443e = j12222 != 0 ? uptimeMillis - j12222 : 0L;
        aVar.f54444f = this.f54451g;
        d.a(this.f54450f, aVar);
        com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
    }
}
