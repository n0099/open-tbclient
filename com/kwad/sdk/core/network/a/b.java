package com.kwad.sdk.core.network.a;

import android.os.SystemClock;
import com.kwad.sdk.core.report.d;
import com.kwad.sdk.internal.api.SceneImpl;
/* loaded from: classes7.dex */
public class b {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f39569b;

    /* renamed from: c  reason: collision with root package name */
    public long f39570c;

    /* renamed from: d  reason: collision with root package name */
    public long f39571d;

    /* renamed from: e  reason: collision with root package name */
    public String f39572e;

    /* renamed from: f  reason: collision with root package name */
    public SceneImpl f39573f;

    /* renamed from: g  reason: collision with root package name */
    public String f39574g = "";

    public void a() {
        this.a = SystemClock.uptimeMillis();
    }

    public void a(String str) {
        this.f39574g = str;
    }

    public void a(String str, SceneImpl sceneImpl) {
        this.f39572e = str;
        this.f39573f = sceneImpl;
    }

    public void b() {
        this.f39569b = SystemClock.uptimeMillis();
    }

    public void c() {
        this.f39570c = SystemClock.uptimeMillis();
    }

    public void d() {
        this.f39571d = SystemClock.uptimeMillis();
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
        aVar.f39568g = this.f39572e;
        long uptimeMillis = SystemClock.uptimeMillis();
        long j6 = this.a;
        aVar.a = j6 != 0 ? uptimeMillis - j6 : 0L;
        long j7 = this.f39569b;
        if (j7 != 0) {
            long j8 = this.a;
            if (j8 != 0) {
                j = j7 - j8;
                aVar.f39563b = j;
                j2 = this.f39570c;
                if (j2 != 0) {
                    long j9 = this.f39569b;
                    if (j9 != 0) {
                        j3 = j2 - j9;
                        aVar.f39564c = j3;
                        j4 = this.f39571d;
                        if (j4 != 0) {
                            long j10 = this.f39570c;
                            if (j10 != 0) {
                                j5 = j4 - j10;
                                aVar.f39565d = j5;
                                long j11 = this.f39571d;
                                aVar.f39566e = j11 != 0 ? uptimeMillis - j11 : 0L;
                                aVar.f39567f = this.f39574g;
                                d.a(this.f39573f, aVar);
                                com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                            }
                        }
                        j5 = 0;
                        aVar.f39565d = j5;
                        long j112 = this.f39571d;
                        aVar.f39566e = j112 != 0 ? uptimeMillis - j112 : 0L;
                        aVar.f39567f = this.f39574g;
                        d.a(this.f39573f, aVar);
                        com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
                    }
                }
                j3 = 0;
                aVar.f39564c = j3;
                j4 = this.f39571d;
                if (j4 != 0) {
                }
                j5 = 0;
                aVar.f39565d = j5;
                long j1122 = this.f39571d;
                aVar.f39566e = j1122 != 0 ? uptimeMillis - j1122 : 0L;
                aVar.f39567f = this.f39574g;
                d.a(this.f39573f, aVar);
                com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
            }
        }
        j = 0;
        aVar.f39563b = j;
        j2 = this.f39570c;
        if (j2 != 0) {
        }
        j3 = 0;
        aVar.f39564c = j3;
        j4 = this.f39571d;
        if (j4 != 0) {
        }
        j5 = 0;
        aVar.f39565d = j5;
        long j11222 = this.f39571d;
        aVar.f39566e = j11222 != 0 ? uptimeMillis - j11222 : 0L;
        aVar.f39567f = this.f39574g;
        d.a(this.f39573f, aVar);
        com.kwad.sdk.core.d.a.a("NetworkMonitorRecorder", aVar.toString());
    }
}
