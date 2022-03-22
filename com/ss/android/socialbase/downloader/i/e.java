package com.ss.android.socialbase.downloader.i;
/* loaded from: classes7.dex */
public class e {
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public a f43364b;

    /* renamed from: c  reason: collision with root package name */
    public int f43365c;

    /* renamed from: d  reason: collision with root package name */
    public int f43366d = 10;

    /* loaded from: classes7.dex */
    public static class a {
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f43367b;

        /* renamed from: c  reason: collision with root package name */
        public a f43368c;

        /* renamed from: d  reason: collision with root package name */
        public a f43369d;

        public a() {
        }
    }

    public boolean a(long j, long j2) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar != null) {
                if (j >= aVar.a && j2 >= aVar.f43367b) {
                    a aVar2 = aVar.f43368c;
                    if (aVar2 != null && j2 - aVar2.f43367b < 1000) {
                        aVar.a = j;
                        aVar.f43367b = j2;
                        return true;
                    }
                }
                return false;
            }
            a a2 = a();
            a2.a = j;
            a2.f43367b = j2;
            if (aVar != null) {
                a2.f43368c = aVar;
                aVar.f43369d = a2;
            }
            this.a = a2;
            return true;
        }
    }

    public long b(long j, long j2) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar == null) {
                return -1L;
            }
            a a2 = a(j);
            if (a2 == null) {
                return -1L;
            }
            long j3 = aVar.a - a2.a;
            long j4 = j2 - a2.f43367b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    private a a() {
        a aVar;
        if (this.f43365c >= this.f43366d && (aVar = this.f43364b) != null) {
            a aVar2 = aVar.f43369d;
            aVar.f43369d = null;
            this.f43364b = aVar2;
            if (aVar2 != null) {
                aVar2.f43368c = null;
            }
            return aVar;
        }
        this.f43365c++;
        return new a();
    }

    private a a(long j) {
        a aVar = this.a;
        a aVar2 = null;
        while (aVar != null && aVar.f43367b > j) {
            aVar2 = aVar;
            aVar = aVar.f43368c;
        }
        return (aVar == null || aVar2 == null || aVar == aVar2 || j - aVar.f43367b >= aVar2.f43367b - j) ? aVar2 : aVar;
    }
}
