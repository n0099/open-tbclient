package h.o.b;

import h.f;
/* loaded from: classes7.dex */
public final class a implements f {
    public static final f k = new C1924a();

    /* renamed from: e  reason: collision with root package name */
    public long f68538e;

    /* renamed from: f  reason: collision with root package name */
    public f f68539f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68540g;

    /* renamed from: h  reason: collision with root package name */
    public long f68541h;

    /* renamed from: i  reason: collision with root package name */
    public long f68542i;
    public f j;

    /* renamed from: h.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1924a implements f {
        @Override // h.f
        public void request(long j) {
        }
    }

    public void a() {
        while (true) {
            synchronized (this) {
                long j = this.f68541h;
                long j2 = this.f68542i;
                f fVar = this.j;
                int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i2 == 0 && j2 == 0 && fVar == null) {
                    this.f68540g = false;
                    return;
                }
                this.f68541h = 0L;
                this.f68542i = 0L;
                this.j = null;
                long j3 = this.f68538e;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == Long.MAX_VALUE) {
                        this.f68538e = Long.MAX_VALUE;
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = j4 - j2;
                        if (j3 >= 0) {
                            this.f68538e = j3;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    }
                }
                if (fVar != null) {
                    if (fVar == k) {
                        this.f68539f = null;
                    } else {
                        this.f68539f = fVar;
                        fVar.request(j3);
                    }
                } else {
                    f fVar2 = this.f68539f;
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
                if (this.f68540g) {
                    this.f68542i += j;
                    return;
                }
                this.f68540g = true;
                try {
                    long j2 = this.f68538e;
                    if (j2 != Long.MAX_VALUE) {
                        long j3 = j2 - j;
                        if (j3 >= 0) {
                            this.f68538e = j3;
                        } else {
                            throw new IllegalStateException("more items arrived than were requested");
                        }
                    }
                    a();
                    return;
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f68540g = false;
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
            if (this.f68540g) {
                if (fVar == null) {
                    fVar = k;
                }
                this.j = fVar;
                return;
            }
            this.f68540g = true;
            try {
                this.f68539f = fVar;
                if (fVar != null) {
                    fVar.request(this.f68538e);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f68540g = false;
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
            if (this.f68540g) {
                this.f68541h += j;
                return;
            }
            this.f68540g = true;
            try {
                long j2 = this.f68538e + j;
                if (j2 < 0) {
                    j2 = Long.MAX_VALUE;
                }
                this.f68538e = j2;
                f fVar = this.f68539f;
                if (fVar != null) {
                    fVar.request(j);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f68540g = false;
                    throw th;
                }
            }
        }
    }
}
