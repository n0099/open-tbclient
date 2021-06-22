package h.o.b;

import h.f;
/* loaded from: classes8.dex */
public final class a implements f {
    public static final f k = new C1980a();

    /* renamed from: e  reason: collision with root package name */
    public long f71941e;

    /* renamed from: f  reason: collision with root package name */
    public f f71942f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71943g;

    /* renamed from: h  reason: collision with root package name */
    public long f71944h;

    /* renamed from: i  reason: collision with root package name */
    public long f71945i;
    public f j;

    /* renamed from: h.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1980a implements f {
        @Override // h.f
        public void request(long j) {
        }
    }

    public void a() {
        while (true) {
            synchronized (this) {
                long j = this.f71944h;
                long j2 = this.f71945i;
                f fVar = this.j;
                int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i2 == 0 && j2 == 0 && fVar == null) {
                    this.f71943g = false;
                    return;
                }
                this.f71944h = 0L;
                this.f71945i = 0L;
                this.j = null;
                long j3 = this.f71941e;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == Long.MAX_VALUE) {
                        this.f71941e = Long.MAX_VALUE;
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = j4 - j2;
                        if (j3 >= 0) {
                            this.f71941e = j3;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    }
                }
                if (fVar != null) {
                    if (fVar == k) {
                        this.f71942f = null;
                    } else {
                        this.f71942f = fVar;
                        fVar.request(j3);
                    }
                } else {
                    f fVar2 = this.f71942f;
                    if (fVar2 != null && i2 != 0) {
                        fVar2.request(j);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void b(long j) {
        if (j > 0) {
            synchronized (this) {
                if (this.f71943g) {
                    this.f71945i += j;
                    return;
                }
                this.f71943g = true;
                try {
                    long j2 = this.f71941e;
                    if (j2 != Long.MAX_VALUE) {
                        long j3 = j2 - j;
                        if (j3 >= 0) {
                            this.f71941e = j3;
                        } else {
                            throw new IllegalStateException("more items arrived than were requested");
                        }
                    }
                    a();
                    return;
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f71943g = false;
                        throw th;
                    }
                }
            }
        }
        throw new IllegalArgumentException("n > 0 required");
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void c(f fVar) {
        synchronized (this) {
            if (this.f71943g) {
                if (fVar == null) {
                    fVar = k;
                }
                this.j = fVar;
                return;
            }
            this.f71943g = true;
            try {
                this.f71942f = fVar;
                if (fVar != null) {
                    fVar.request(this.f71941e);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f71943g = false;
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // h.f
    public void request(long j) {
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (i2 == 0) {
            return;
        }
        synchronized (this) {
            if (this.f71943g) {
                this.f71944h += j;
                return;
            }
            this.f71943g = true;
            try {
                long j2 = this.f71941e + j;
                if (j2 < 0) {
                    j2 = Long.MAX_VALUE;
                }
                this.f71941e = j2;
                f fVar = this.f71942f;
                if (fVar != null) {
                    fVar.request(j);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f71943g = false;
                    throw th;
                }
            }
        }
    }
}
