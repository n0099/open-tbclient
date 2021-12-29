package com.ss.android.socialbase.downloader.i;
/* loaded from: classes3.dex */
public class e {
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public a f62455b;

    /* renamed from: c  reason: collision with root package name */
    public int f62456c;

    /* renamed from: d  reason: collision with root package name */
    public int f62457d = 10;

    /* loaded from: classes3.dex */
    public static class a {
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f62458b;

        /* renamed from: c  reason: collision with root package name */
        public a f62459c;

        /* renamed from: d  reason: collision with root package name */
        public a f62460d;

        public a() {
        }
    }

    public boolean a(long j2, long j3) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar != null) {
                if (j2 >= aVar.a && j3 >= aVar.f62458b) {
                    a aVar2 = aVar.f62459c;
                    if (aVar2 != null && j3 - aVar2.f62458b < 1000) {
                        aVar.a = j2;
                        aVar.f62458b = j3;
                        return true;
                    }
                }
                return false;
            }
            a a2 = a();
            a2.a = j2;
            a2.f62458b = j3;
            if (aVar != null) {
                a2.f62459c = aVar;
                aVar.f62460d = a2;
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
            long j5 = j3 - a2.f62458b;
            if (j4 < 0 || j5 <= 0) {
                return -1L;
            }
            return j4 / j5;
        }
    }

    private a a() {
        a aVar;
        if (this.f62456c >= this.f62457d && (aVar = this.f62455b) != null) {
            a aVar2 = aVar.f62460d;
            aVar.f62460d = null;
            this.f62455b = aVar2;
            if (aVar2 != null) {
                aVar2.f62459c = null;
            }
            return aVar;
        }
        this.f62456c++;
        return new a();
    }

    private a a(long j2) {
        a aVar = this.a;
        a aVar2 = null;
        while (aVar != null && aVar.f62458b > j2) {
            aVar2 = aVar;
            aVar = aVar.f62459c;
        }
        return (aVar == null || aVar2 == null || aVar == aVar2 || j2 - aVar.f62458b >= aVar2.f62458b - j2) ? aVar2 : aVar;
    }
}
