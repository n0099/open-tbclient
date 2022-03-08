package com.ss.android.socialbase.downloader.i;
/* loaded from: classes8.dex */
public class e {
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public a f58660b;

    /* renamed from: c  reason: collision with root package name */
    public int f58661c;

    /* renamed from: d  reason: collision with root package name */
    public int f58662d = 10;

    /* loaded from: classes8.dex */
    public static class a {
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f58663b;

        /* renamed from: c  reason: collision with root package name */
        public a f58664c;

        /* renamed from: d  reason: collision with root package name */
        public a f58665d;

        public a() {
        }
    }

    public boolean a(long j2, long j3) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar != null) {
                if (j2 >= aVar.a && j3 >= aVar.f58663b) {
                    a aVar2 = aVar.f58664c;
                    if (aVar2 != null && j3 - aVar2.f58663b < 1000) {
                        aVar.a = j2;
                        aVar.f58663b = j3;
                        return true;
                    }
                }
                return false;
            }
            a a2 = a();
            a2.a = j2;
            a2.f58663b = j3;
            if (aVar != null) {
                a2.f58664c = aVar;
                aVar.f58665d = a2;
            }
            this.a = a2;
            return true;
        }
    }

    public long b(long j2, long j3) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar == null) {
                return -1L;
            }
            a a2 = a(j2);
            if (a2 == null) {
                return -1L;
            }
            long j4 = aVar.a - a2.a;
            long j5 = j3 - a2.f58663b;
            if (j4 < 0 || j5 <= 0) {
                return -1L;
            }
            return j4 / j5;
        }
    }

    private a a() {
        a aVar;
        if (this.f58661c >= this.f58662d && (aVar = this.f58660b) != null) {
            a aVar2 = aVar.f58665d;
            aVar.f58665d = null;
            this.f58660b = aVar2;
            if (aVar2 != null) {
                aVar2.f58664c = null;
            }
            return aVar;
        }
        this.f58661c++;
        return new a();
    }

    private a a(long j2) {
        a aVar = this.a;
        a aVar2 = null;
        while (aVar != null && aVar.f58663b > j2) {
            aVar2 = aVar;
            aVar = aVar.f58664c;
        }
        return (aVar == null || aVar2 == null || aVar == aVar2 || j2 - aVar.f58663b >= aVar2.f58663b - j2) ? aVar2 : aVar;
    }
}
