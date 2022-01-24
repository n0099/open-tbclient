package com.ss.android.socialbase.downloader.i;
/* loaded from: classes4.dex */
public class e {
    public a a;

    /* renamed from: b  reason: collision with root package name */
    public a f60143b;

    /* renamed from: c  reason: collision with root package name */
    public int f60144c;

    /* renamed from: d  reason: collision with root package name */
    public int f60145d = 10;

    /* loaded from: classes4.dex */
    public static class a {
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f60146b;

        /* renamed from: c  reason: collision with root package name */
        public a f60147c;

        /* renamed from: d  reason: collision with root package name */
        public a f60148d;

        public a() {
        }
    }

    public boolean a(long j2, long j3) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar != null) {
                if (j2 >= aVar.a && j3 >= aVar.f60146b) {
                    a aVar2 = aVar.f60147c;
                    if (aVar2 != null && j3 - aVar2.f60146b < 1000) {
                        aVar.a = j2;
                        aVar.f60146b = j3;
                        return true;
                    }
                }
                return false;
            }
            a a2 = a();
            a2.a = j2;
            a2.f60146b = j3;
            if (aVar != null) {
                a2.f60147c = aVar;
                aVar.f60148d = a2;
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
            long j5 = j3 - a2.f60146b;
            if (j4 < 0 || j5 <= 0) {
                return -1L;
            }
            return j4 / j5;
        }
    }

    private a a() {
        a aVar;
        if (this.f60144c >= this.f60145d && (aVar = this.f60143b) != null) {
            a aVar2 = aVar.f60148d;
            aVar.f60148d = null;
            this.f60143b = aVar2;
            if (aVar2 != null) {
                aVar2.f60147c = null;
            }
            return aVar;
        }
        this.f60144c++;
        return new a();
    }

    private a a(long j2) {
        a aVar = this.a;
        a aVar2 = null;
        while (aVar != null && aVar.f60146b > j2) {
            aVar2 = aVar;
            aVar = aVar.f60147c;
        }
        return (aVar == null || aVar2 == null || aVar == aVar2 || j2 - aVar.f60146b >= aVar2.f60146b - j2) ? aVar2 : aVar;
    }
}
