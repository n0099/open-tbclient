package com.ss.android.socialbase.downloader.i;
/* loaded from: classes8.dex */
public class e {
    public a a;
    public a b;
    public int c;
    public int d = 10;

    /* loaded from: classes8.dex */
    public class a {
        public long a;
        public long b;
        public a c;
        public a d;

        public a() {
        }
    }

    private a a() {
        a aVar;
        if (this.c >= this.d && (aVar = this.b) != null) {
            a aVar2 = aVar.d;
            aVar.d = null;
            this.b = aVar2;
            if (aVar2 != null) {
                aVar2.c = null;
            }
            return aVar;
        }
        this.c++;
        return new a();
    }

    private a a(long j) {
        a aVar = this.a;
        a aVar2 = null;
        while (aVar != null && aVar.b > j) {
            aVar2 = aVar;
            aVar = aVar.c;
        }
        if (aVar != null && aVar2 != null && aVar != aVar2 && j - aVar.b < aVar2.b - j) {
            return aVar;
        }
        return aVar2;
    }

    public boolean a(long j, long j2) {
        synchronized (this) {
            a aVar = this.a;
            if (aVar != null) {
                if (j >= aVar.a && j2 >= aVar.b) {
                    a aVar2 = aVar.c;
                    if (aVar2 != null && j2 - aVar2.b < 1000) {
                        aVar.a = j;
                        aVar.b = j2;
                        return true;
                    }
                }
                return false;
            }
            a a2 = a();
            a2.a = j;
            a2.b = j2;
            if (aVar != null) {
                a2.c = aVar;
                aVar.d = a2;
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
            long j4 = j2 - a2.b;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }
}
