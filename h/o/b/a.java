package h.o.b;

import h.f;
/* loaded from: classes7.dex */
public final class a implements f {
    public static final f k = new C1875a();

    /* renamed from: e  reason: collision with root package name */
    public long f67848e;

    /* renamed from: f  reason: collision with root package name */
    public f f67849f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67850g;

    /* renamed from: h  reason: collision with root package name */
    public long f67851h;
    public long i;
    public f j;

    /* renamed from: h.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1875a implements f {
        @Override // h.f
        public void request(long j) {
        }
    }

    public void a() {
        while (true) {
            synchronized (this) {
                long j = this.f67851h;
                long j2 = this.i;
                f fVar = this.j;
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i == 0 && j2 == 0 && fVar == null) {
                    this.f67850g = false;
                    return;
                }
                this.f67851h = 0L;
                this.i = 0L;
                this.j = null;
                long j3 = this.f67848e;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == Long.MAX_VALUE) {
                        this.f67848e = Long.MAX_VALUE;
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = j4 - j2;
                        if (j3 >= 0) {
                            this.f67848e = j3;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    }
                }
                if (fVar != null) {
                    if (fVar == k) {
                        this.f67849f = null;
                    } else {
                        this.f67849f = fVar;
                        fVar.request(j3);
                    }
                } else {
                    f fVar2 = this.f67849f;
                    if (fVar2 != null && i != 0) {
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
                if (this.f67850g) {
                    this.i += j;
                    return;
                }
                this.f67850g = true;
                try {
                    long j2 = this.f67848e;
                    if (j2 != Long.MAX_VALUE) {
                        long j3 = j2 - j;
                        if (j3 >= 0) {
                            this.f67848e = j3;
                        } else {
                            throw new IllegalStateException("more items arrived than were requested");
                        }
                    }
                    a();
                    return;
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f67850g = false;
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
            if (this.f67850g) {
                if (fVar == null) {
                    fVar = k;
                }
                this.j = fVar;
                return;
            }
            this.f67850g = true;
            try {
                this.f67849f = fVar;
                if (fVar != null) {
                    fVar.request(this.f67848e);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f67850g = false;
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // h.f
    public void request(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (i == 0) {
            return;
        }
        synchronized (this) {
            if (this.f67850g) {
                this.f67851h += j;
                return;
            }
            this.f67850g = true;
            try {
                long j2 = this.f67848e + j;
                if (j2 < 0) {
                    j2 = Long.MAX_VALUE;
                }
                this.f67848e = j2;
                f fVar = this.f67849f;
                if (fVar != null) {
                    fVar.request(j);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f67850g = false;
                    throw th;
                }
            }
        }
    }
}
