package h.o.b;

import h.f;
/* loaded from: classes7.dex */
public final class a implements f {
    public static final f k = new C1874a();

    /* renamed from: e  reason: collision with root package name */
    public long f67843e;

    /* renamed from: f  reason: collision with root package name */
    public f f67844f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67845g;

    /* renamed from: h  reason: collision with root package name */
    public long f67846h;
    public long i;
    public f j;

    /* renamed from: h.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1874a implements f {
        @Override // h.f
        public void request(long j) {
        }
    }

    public void a() {
        while (true) {
            synchronized (this) {
                long j = this.f67846h;
                long j2 = this.i;
                f fVar = this.j;
                if (j == 0 && j2 == 0 && fVar == null) {
                    this.f67845g = false;
                    return;
                }
                this.f67846h = 0L;
                this.i = 0L;
                this.j = null;
                long j3 = this.f67843e;
                if (j3 != Long.MAX_VALUE) {
                    long j4 = j3 + j;
                    if (j4 < 0 || j4 == Long.MAX_VALUE) {
                        this.f67843e = Long.MAX_VALUE;
                        j3 = Long.MAX_VALUE;
                    } else {
                        j3 = j4 - j2;
                        if (j3 >= 0) {
                            this.f67843e = j3;
                        } else {
                            throw new IllegalStateException("more produced than requested");
                        }
                    }
                }
                if (fVar != null) {
                    if (fVar == k) {
                        this.f67844f = null;
                    } else {
                        this.f67844f = fVar;
                        fVar.request(j3);
                    }
                } else {
                    f fVar2 = this.f67844f;
                    if (fVar2 != null && j != 0) {
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
                if (this.f67845g) {
                    this.i += j;
                    return;
                }
                this.f67845g = true;
                try {
                    long j2 = this.f67843e;
                    if (j2 != Long.MAX_VALUE) {
                        long j3 = j2 - j;
                        if (j3 >= 0) {
                            this.f67843e = j3;
                        } else {
                            throw new IllegalStateException("more items arrived than were requested");
                        }
                    }
                    a();
                    return;
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f67845g = false;
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
            if (this.f67845g) {
                if (fVar == null) {
                    fVar = k;
                }
                this.j = fVar;
                return;
            }
            this.f67845g = true;
            try {
                this.f67844f = fVar;
                if (fVar != null) {
                    fVar.request(this.f67843e);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f67845g = false;
                    throw th;
                }
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Override // h.f
    public void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j == 0) {
            return;
        }
        synchronized (this) {
            if (this.f67845g) {
                this.f67846h += j;
                return;
            }
            this.f67845g = true;
            try {
                long j2 = this.f67843e + j;
                if (j2 < 0) {
                    j2 = Long.MAX_VALUE;
                }
                this.f67843e = j2;
                f fVar = this.f67844f;
                if (fVar != null) {
                    fVar.request(j);
                }
                a();
            } catch (Throwable th) {
                synchronized (this) {
                    this.f67845g = false;
                    throw th;
                }
            }
        }
    }
}
